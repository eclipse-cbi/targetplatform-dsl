package fr.obeo.releng.targetplatform.util

import org.eclipse.jface.text.source.Annotation
import org.eclipse.ui.IFileEditorInput
import org.eclipse.xtext.ui.editor.utils.EditorUtils

class ReferenceResolvingErrorClearer implements Runnable {
	
	private static final String ANNOTATION_TYPE_TO_REMOVE = "org.eclipse.xtext.ui.editor.error"

	private String targetPlatformURI
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
	private String varCallFromOnlyImportedVariable
	
	new(String targetPlatformURI, String varCallFromOnlyImportedVariable) {
		this.targetPlatformURI = targetPlatformURI
		this.varCallFromOnlyImportedVariable = varCallFromOnlyImportedVariable
	}
	
	override run() {
		val xtextEditor = EditorUtils.getActiveXtextEditor()
		if (xtextEditor === null || !targetPlatformURI.contains(xtextEditor.title)) {
			return
		}
				
		val editorInput = xtextEditor.editorInput as IFileEditorInput
		val annotationModel = xtextEditor.documentProvider.getAnnotationModel(editorInput)
		
		val annotationsToRemove = newArrayList
		val annotIter = annotationModel.annotationIterator
		annotIter.filter[
				val annotation = it as Annotation
				ANNOTATION_TYPE_TO_REMOVE.equals(annotation.type)
			]
			.filter[
				val annotation = it as Annotation
				annotation.text.startsWith("Couldn't resolve reference to VarDefinition")
			]
			.filter[
				val annotation = it as Annotation
				varCallFromOnlyImportedVariable.split(", ").exists[
					annotation.text.contains(it)
				]
			]
			.forEach[
				annotationsToRemove.add(it as Annotation)
			]
			
		annotationsToRemove.forEach[
			annotationModel.removeAnnotation(it)
		]
	}
	
}
