package fr.obeo.releng.targetplatform.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ReferenceResolvingErrorClearer implements Runnable {
  private final static String ANNOTATION_TYPE_TO_REMOVE = "org.eclipse.xtext.ui.editor.error";
  
  private String targetPlatformURI;
  
  /**
   * Used a String to import the list of variable calls to clear error on eclipse editor.
   * The list elements are separated within the string by ", "
   * We use a String instead of a collection to avoid concurrency problems, String is immutable
   * 
   * We need to clear editor from GUI thread since "EditorUtils.getActiveXtextEditor"
   * works only from it
   * 
   * see {@link CompositeElementResolver#updateVarCallFromImportedVar}
   */
  private String varCallFromOnlyImportedVariable;
  
  public ReferenceResolvingErrorClearer(final String targetPlatformURI, final String varCallFromOnlyImportedVariable) {
    this.targetPlatformURI = targetPlatformURI;
    this.varCallFromOnlyImportedVariable = varCallFromOnlyImportedVariable;
  }
  
  @Override
  public void run() {
    final XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor();
    if (((xtextEditor == null) || (!this.targetPlatformURI.contains(xtextEditor.getTitle())))) {
      return;
    }
    IEditorInput _editorInput = xtextEditor.getEditorInput();
    final IFileEditorInput editorInput = ((IFileEditorInput) _editorInput);
    final IAnnotationModel annotationModel = xtextEditor.getDocumentProvider().getAnnotationModel(editorInput);
    final ArrayList<Annotation> annotationsToRemove = CollectionLiterals.<Annotation>newArrayList();
    final Iterator annotIter = annotationModel.getAnnotationIterator();
    final Function1<Object, Boolean> _function = new Function1<Object, Boolean>() {
      @Override
      public Boolean apply(final Object it) {
        boolean _xblockexpression = false;
        {
          final Annotation annotation = ((Annotation) it);
          _xblockexpression = ReferenceResolvingErrorClearer.ANNOTATION_TYPE_TO_REMOVE.equals(annotation.getType());
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    final Function1<Object, Boolean> _function_1 = new Function1<Object, Boolean>() {
      @Override
      public Boolean apply(final Object it) {
        boolean _xblockexpression = false;
        {
          final Annotation annotation = ((Annotation) it);
          _xblockexpression = annotation.getText().startsWith("Couldn\'t resolve reference to VarDefinition");
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    final Function1<Object, Boolean> _function_2 = new Function1<Object, Boolean>() {
      @Override
      public Boolean apply(final Object it) {
        boolean _xblockexpression = false;
        {
          final Annotation annotation = ((Annotation) it);
          final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
            @Override
            public Boolean apply(final String it) {
              return Boolean.valueOf(annotation.getText().contains(it));
            }
          };
          _xblockexpression = IterableExtensions.<String>exists(((Iterable<String>)Conversions.doWrapArray(ReferenceResolvingErrorClearer.this.varCallFromOnlyImportedVariable.split(", "))), _function);
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    final Procedure1<Object> _function_3 = new Procedure1<Object>() {
      @Override
      public void apply(final Object it) {
        annotationsToRemove.add(((Annotation) it));
      }
    };
    IteratorExtensions.<Object>forEach(IteratorExtensions.<Object>filter(IteratorExtensions.<Object>filter(IteratorExtensions.<Object>filter(annotIter, _function), _function_1), _function_2), _function_3);
    final Consumer<Annotation> _function_4 = new Consumer<Annotation>() {
      @Override
      public void accept(final Annotation it) {
        annotationModel.removeAnnotation(it);
      }
    };
    annotationsToRemove.forEach(_function_4);
  }
}
