package fr.obeo.releng.targetplatform.util;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.CompositeStringPart;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetContent;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformFactory;
import fr.obeo.releng.targetplatform.VarCall;
import fr.obeo.releng.targetplatform.VarDefinition;
import fr.obeo.releng.targetplatform.util.ImportVariableManager;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;
import fr.obeo.releng.targetplatform.util.ReferenceResolvingErrorClearer;
import fr.obeo.releng.targetplatform.util.TargetReloader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CompositeElementResolver {
  @Inject
  private LocationIndexBuilder locationIndexBuilder;
  
  @Inject
  private ImportVariableManager importVariableManager;
  
  @Inject
  private TargetReloader targetReloader;
  
  /**
   * Composite elements are string defined by a concatenation of static string and variable call:
   * "string1" + ${var1} + "aaa" + ${var2} +...
   */
  public void resolveCompositeElements(final TargetPlatform targetPlatform) {
    boolean _isCompositeElementsResolved = targetPlatform.isCompositeElementsResolved();
    boolean _equals = (_isCompositeElementsResolved == true);
    if (_equals) {
      return;
    }
    this.overrideVariableDefinition(targetPlatform);
    this.searchAndAppendDefineFromIncludedTpd(targetPlatform);
    this.resolveLocations(targetPlatform);
    final LinkedList<TargetPlatform> importedTargetPlatforms = this.locationIndexBuilder.getImportedTargetPlatformsDoNotResolveCompositeElement(targetPlatform);
    final Consumer<TargetPlatform> _function = new Consumer<TargetPlatform>() {
      @Override
      public void accept(final TargetPlatform it) {
        CompositeElementResolver.this.resolveLocations(it);
      }
    };
    importedTargetPlatforms.forEach(_function);
    this.cleanReferenceResolvingError(targetPlatform);
  }
  
  private void cleanReferenceResolvingError(final TargetPlatform targetPlatform) {
    String _string = targetPlatform.eResource().getURI().toString();
    String _varCallFromOnlyImportedVariable = targetPlatform.getVarCallFromOnlyImportedVariable();
    final ReferenceResolvingErrorClearer referenceResolvingErrorClearer = new ReferenceResolvingErrorClearer(_string, _varCallFromOnlyImportedVariable);
    Display.getDefault().asyncExec(referenceResolvingErrorClearer);
  }
  
  private void overrideVariableDefinition(final TargetPlatform targetPlatform) {
    final HashSet<TargetPlatform> alreadyVisitedTarget = CollectionLiterals.<TargetPlatform>newHashSet();
    this.overrideVariableDefinition(targetPlatform, alreadyVisitedTarget);
  }
  
  /**
   * Override value of variable definition with command line or environment variable
   */
  private void overrideVariableDefinition(final TargetPlatform targetPlatform, final Set<TargetPlatform> alreadyVisitedTarget) {
    alreadyVisitedTarget.add(targetPlatform);
    final Consumer<VarDefinition> _function = new Consumer<VarDefinition>() {
      @Override
      public void accept(final VarDefinition it) {
        final VarDefinition varDef = it;
        final String varDefName = varDef.getName();
        final String variableValue = CompositeElementResolver.this.importVariableManager.getVariableValue(varDefName);
        boolean _tripleNotEquals = (variableValue != null);
        if (_tripleNotEquals) {
          varDef.setOverrideValue(variableValue);
        }
        targetPlatform.setModified(true);
      }
    };
    targetPlatform.getVarDefinition().forEach(_function);
    final List<TargetPlatform> directlyImportedTargetPlatforms = this.searchDirectlyImportedTpd(targetPlatform);
    final Function1<TargetPlatform, Boolean> _function_1 = new Function1<TargetPlatform, Boolean>() {
      @Override
      public Boolean apply(final TargetPlatform it) {
        boolean _contains = alreadyVisitedTarget.contains(it);
        return Boolean.valueOf((!_contains));
      }
    };
    final Consumer<TargetPlatform> _function_2 = new Consumer<TargetPlatform>() {
      @Override
      public void accept(final TargetPlatform it) {
        final TargetPlatform importedTarget = it;
        TargetPlatform reloadedImportTarget = it;
        boolean _isModified = importedTarget.isModified();
        if (_isModified) {
          reloadedImportTarget = CompositeElementResolver.this.targetReloader.forceReloadTarget(targetPlatform, importedTarget);
        }
        CompositeElementResolver.this.overrideVariableDefinition(reloadedImportTarget, CollectionLiterals.<TargetPlatform>newHashSet(((TargetPlatform[])Conversions.unwrapArray(alreadyVisitedTarget, TargetPlatform.class))));
      }
    };
    IterableExtensions.<TargetPlatform>filter(directlyImportedTargetPlatforms, _function_1).forEach(_function_2);
  }
  
  /**
   * Resolve location ("location" directive) means resolve variable call used in location declaration
   */
  private void resolveLocations(final TargetPlatform targetPlatform) {
    final Consumer<Location> _function = new Consumer<Location>() {
      @Override
      public void accept(final Location it) {
        it.resolveUri();
        it.resolveIUsVersion();
      }
    };
    targetPlatform.getLocations().forEach(_function);
    targetPlatform.setCompositeElementsResolved(true);
    targetPlatform.setModified(true);
  }
  
  void searchAndAppendDefineFromIncludedTpd(final TargetPlatform targetPlatform) {
    final HashSet<TargetPlatform> alreadyVisitedTarget = CollectionLiterals.<TargetPlatform>newHashSet();
    this.searchAndAppendDefineFromIncludedTpd(targetPlatform, alreadyVisitedTarget);
  }
  
  /**
   * Search and append to the list of "define": variable definition of the current tpd file (targetPlatform)
   * the list of "define" found in sub tpd: imported with "include" directive
   */
  private void searchAndAppendDefineFromIncludedTpd(final TargetPlatform targetPlatform, final Set<TargetPlatform> alreadyVisitedTarget) {
    final HashSet<VarDefinition> ImportedDefineFromSubTpd = CollectionLiterals.<VarDefinition>newHashSet();
    final LinkedList<TargetPlatform> processedTargetPlatform = CollectionLiterals.<TargetPlatform>newLinkedList();
    alreadyVisitedTarget.add(targetPlatform);
    List<TargetPlatform> directlyImportedTargetPlatforms = this.searchDirectlyImportedTpd(targetPlatform);
    while ((directlyImportedTargetPlatforms.size() > processedTargetPlatform.size())) {
      {
        final Function1<TargetPlatform, Boolean> _function = new Function1<TargetPlatform, Boolean>() {
          @Override
          public Boolean apply(final TargetPlatform it) {
            boolean _contains = alreadyVisitedTarget.contains(it);
            return Boolean.valueOf((!_contains));
          }
        };
        final Function1<TargetPlatform, Boolean> _function_1 = new Function1<TargetPlatform, Boolean>() {
          @Override
          public Boolean apply(final TargetPlatform it) {
            boolean _contains = processedTargetPlatform.contains(it);
            return Boolean.valueOf((!_contains));
          }
        };
        final Consumer<TargetPlatform> _function_2 = new Consumer<TargetPlatform>() {
          @Override
          public void accept(final TargetPlatform it) {
            TargetPlatform notProcessedTargetPlatform = it;
            CompositeElementResolver.this.overrideVariableDefinition(notProcessedTargetPlatform, alreadyVisitedTarget);
            CompositeElementResolver.this.searchAndAppendDefineFromIncludedTpd(notProcessedTargetPlatform, CollectionLiterals.<TargetPlatform>newHashSet(((TargetPlatform[])Conversions.unwrapArray(alreadyVisitedTarget, TargetPlatform.class))));
            final Consumer<VarDefinition> _function = new Consumer<VarDefinition>() {
              @Override
              public void accept(final VarDefinition it) {
                ImportedDefineFromSubTpd.add(it);
              }
            };
            notProcessedTargetPlatform.getVarDefinition().forEach(_function);
          }
        };
        IterableExtensions.<TargetPlatform>filter(IterableExtensions.<TargetPlatform>filter(directlyImportedTargetPlatforms, _function), _function_1).forEach(_function_2);
        final Function1<TargetPlatform, Boolean> _function_3 = new Function1<TargetPlatform, Boolean>() {
          @Override
          public Boolean apply(final TargetPlatform it) {
            boolean _contains = processedTargetPlatform.contains(it);
            return Boolean.valueOf((!_contains));
          }
        };
        final Set<TargetPlatform> newlyProcessedTarget = IterableExtensions.<TargetPlatform>toSet(IterableExtensions.<TargetPlatform>filter(directlyImportedTargetPlatforms, _function_3));
        processedTargetPlatform.addAll(newlyProcessedTarget);
        this.mergeImportedDefine(targetPlatform, ImportedDefineFromSubTpd);
        directlyImportedTargetPlatforms = this.searchDirectlyImportedTpd(targetPlatform);
      }
    }
  }
  
  /**
   * Targets that are directly imported, with an "include" directive present in the current
   * target: "targetPlatform". Do not look for target imported through an imported target
   */
  private List<TargetPlatform> searchDirectlyImportedTpd(final TargetPlatform targetPlatform) {
    final Function1<IncludeDeclaration, TargetPlatform> _function = new Function1<IncludeDeclaration, TargetPlatform>() {
      @Override
      public TargetPlatform apply(final IncludeDeclaration it) {
        return CompositeElementResolver.this.locationIndexBuilder.getImportedTargetPlatform(targetPlatform.eResource(), it);
      }
    };
    final Function1<TargetPlatform, Boolean> _function_1 = new Function1<TargetPlatform, Boolean>() {
      @Override
      public Boolean apply(final TargetPlatform it) {
        return Boolean.valueOf((it != null));
      }
    };
    return IterableExtensions.<TargetPlatform>toList(IterableExtensions.<TargetPlatform>filter(ListExtensions.<IncludeDeclaration, TargetPlatform>map(targetPlatform.getIncludes(), _function), _function_1));
  }
  
  /**
   * "variable define" of deepest include are override by "define" of lowest level
   */
  private void mergeImportedDefine(final TargetPlatform targetPlatform, final Set<VarDefinition> ImportedDefineFromSubTpd) {
    final HashSet<VarDefinition> toBeAddedDefine = CollectionLiterals.<VarDefinition>newHashSet();
    final EList<TargetContent> targetContent = targetPlatform.getContents();
    final Consumer<VarDefinition> _function = new Consumer<VarDefinition>() {
      @Override
      public void accept(final VarDefinition it) {
        final VarDefinition currentImportedDefine = it;
        final Function1<TargetContent, Boolean> _function = new Function1<TargetContent, Boolean>() {
          @Override
          public Boolean apply(final TargetContent it) {
            return Boolean.valueOf((it instanceof VarDefinition));
          }
        };
        final Function1<TargetContent, Boolean> _function_1 = new Function1<TargetContent, Boolean>() {
          @Override
          public Boolean apply(final TargetContent it) {
            boolean _xblockexpression = false;
            {
              final VarDefinition alreadyExistingDefine = ((VarDefinition) it);
              final String varName = alreadyExistingDefine.getName();
              boolean _equals = currentImportedDefine.getName().equals(varName);
              _xblockexpression = (!_equals);
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        boolean toBeAdded = IterableExtensions.<TargetContent>forall(IterableExtensions.<TargetContent>filter(targetContent, _function), _function_1);
        if (toBeAdded) {
          boolean _varDefNeverInclude = CompositeElementResolver.this.varDefNeverInclude(currentImportedDefine, toBeAddedDefine);
          if (_varDefNeverInclude) {
            final VarDefinition currentImportedDefineCopy = CompositeElementResolver.this.createImportedCopy(currentImportedDefine);
            toBeAddedDefine.add(currentImportedDefineCopy);
          } else {
            final VarDefinition alreadyAddedVarDef = CompositeElementResolver.this.searchAlreadyIncludeVarDef(currentImportedDefine, toBeAddedDefine);
            final boolean diamondlyInherited = currentImportedDefine.getSourceUUID().equals(alreadyAddedVarDef.getSourceUUID());
            if (diamondlyInherited) {
              alreadyAddedVarDef.setDiamondInherit(true);
            } else {
              alreadyAddedVarDef.getImportedValues().add(currentImportedDefine.getValue().computeActualString());
            }
          }
        }
      }
    };
    ImportedDefineFromSubTpd.forEach(_function);
    targetContent.addAll(toBeAddedDefine);
    final Set<String> varCallFromImpVar = this.updateVariableDefinition(targetContent);
    this.updateVarCallFromImportedVar(targetPlatform, varCallFromImpVar);
    targetPlatform.setModified(true);
  }
  
  /**
   * Purpose of updateVarCallFromImportedVar
   * see TestVariableVariableDefinition.testExtractVarCallFromOnlyImportedVariable
   * 
   * Consider the following case:
   * 
   * maintTpd.tpd
   * ============
   * target "mainTpd"
   * include "subTpd.tpd"
   * define var = ${impVar}
   * 
   * subTpd.tpd
   * ==========
   * target "subTpd"
   * define impVar = "value"
   * 
   * Inside mainTpd, we have the varCall ${impVar}, XTExt does not know how to manage variable call from imported target.
   * So it raises an error in eclipse editor. It is just a displayed warning and it does not disturb the generation of target.
   * 
   * To make a clearer editor display, we list all this case to clean them with method:
   */
  private void updateVarCallFromImportedVar(final TargetPlatform targetPlatform, final Set<String> varCallFromImpVar) {
    String _string = varCallFromImpVar.toString();
    int _length = varCallFromImpVar.toString().length();
    int _minus = (_length - 1);
    targetPlatform.setVarCallFromOnlyImportedVariable(_string.substring(1, _minus));
  }
  
  protected VarDefinition searchAlreadyIncludeVarDef(final VarDefinition varDef2Find, final HashSet<VarDefinition> alreadyAddedVarDefs) {
    VarDefinition _xblockexpression = null;
    {
      final String varDefNameToFind = varDef2Find.getName();
      final Function1<VarDefinition, Boolean> _function = new Function1<VarDefinition, Boolean>() {
        @Override
        public Boolean apply(final VarDefinition it) {
          boolean _xblockexpression = false;
          {
            final VarDefinition currentVarDef = it;
            int _compareTo = varDefNameToFind.compareTo(currentVarDef.getName());
            _xblockexpression = (_compareTo == 0);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      final VarDefinition alreadyAddedVarDef = IterableExtensions.<VarDefinition>findFirst(alreadyAddedVarDefs, _function);
      _xblockexpression = alreadyAddedVarDef;
    }
    return _xblockexpression;
  }
  
  private VarDefinition createImportedCopy(final VarDefinition currentImportedDefine) {
    VarDefinition _xblockexpression = null;
    {
      final VarDefinition currentImportedDefineCopy = TargetPlatformFactory.eINSTANCE.createVarDefinition();
      currentImportedDefineCopy.setName(currentImportedDefine.getName());
      currentImportedDefineCopy.setValue(currentImportedDefine.getValue().getCopy());
      currentImportedDefineCopy.setOverrideValue(currentImportedDefine.getOverrideValue());
      currentImportedDefineCopy.setImported(true);
      currentImportedDefineCopy.getImportedValues().add(currentImportedDefine.getValue().computeActualString());
      currentImportedDefineCopy.set_sourceUUID(currentImportedDefine.getSourceUUID());
      _xblockexpression = currentImportedDefineCopy;
    }
    return _xblockexpression;
  }
  
  private boolean varDefNeverInclude(final VarDefinition varDefToCheck, final HashSet<VarDefinition> alreadyAddedVarDef) {
    boolean _xblockexpression = false;
    {
      final String varDefToCheckName = varDefToCheck.getName();
      final Function1<VarDefinition, Boolean> _function = new Function1<VarDefinition, Boolean>() {
        @Override
        public Boolean apply(final VarDefinition it) {
          boolean _xblockexpression = false;
          {
            final VarDefinition currentVarDef = it;
            int _compareTo = varDefToCheckName.compareTo(currentVarDef.getName());
            boolean _equals = (_compareTo == 0);
            _xblockexpression = (!_equals);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      _xblockexpression = IterableExtensions.<VarDefinition>forall(alreadyAddedVarDef, _function);
    }
    return _xblockexpression;
  }
  
  /**
   * @param targetContent Elements contained in the target, we only processed variable definition.
   * 
   * This method "updateVariableDefinition" is called after we have imported each variable definition from subtarget
   * 
   * When a variable definition is copied into another target, if it contains some variable calls,
   * we eventually need to update them
   * 
   * target "mainTpd"
   * include "subTpd.tpd"
   * define var1 = ${var2}
   * define var2b = "value2"
   * 
   * target "subTpd"
   * define var2 = ${var2b}
   * define var2b = "value2Sub"
   * 
   * Only var2 is copied in "mainTpd" (var2b is overloaded in "mainTpd"). But (before import)
   * var2 refers to var2b of "subTpd", hence if we simply copy it into "mainTpd", var1 will take
   * the value "value2Sub" instead of "value2" => We have to update the newly created var2 in
   * "mainTpd" to make it refer to var2b of "mainTpd"
   */
  private Set<String> updateVariableDefinition(final EList<TargetContent> targetContent) {
    HashSet<String> _xblockexpression = null;
    {
      final HashSet<String> varCallFromImpVar = CollectionLiterals.<String>newHashSet();
      for (final TargetContent varDef : targetContent) {
        if ((varDef instanceof VarDefinition)) {
          EList<CompositeStringPart> _stringParts = ((VarDefinition)varDef).getValue().getStringParts();
          for (final CompositeStringPart stringPart : _stringParts) {
            if ((stringPart instanceof VarCall)) {
              VarCall varCall = ((VarCall) stringPart);
              final Set<String> tmpVarCallFromImpVar = this.updateVariableCall(varCall, targetContent);
              varCallFromImpVar.addAll(tmpVarCallFromImpVar);
            }
          }
        }
      }
      _xblockexpression = varCallFromImpVar;
    }
    return _xblockexpression;
  }
  
  private Set<String> updateVariableCall(final VarCall varCall, final EList<TargetContent> targetContent) {
    HashSet<String> _xblockexpression = null;
    {
      final HashSet<String> varCallFromImpVar = CollectionLiterals.<String>newHashSet();
      for (final TargetContent varDef : targetContent) {
        if ((varDef instanceof VarDefinition)) {
          String _name = varCall.getVarName().getName();
          String _name_1 = ((VarDefinition)varDef).getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (_equals) {
            varCall.setOriginalVarName(varCall.getVarName());
            varCall.setVarName(((VarDefinition)varDef));
            boolean _isImported = ((VarDefinition)varDef).isImported();
            if (_isImported) {
              varCallFromImpVar.add(((VarDefinition)varDef).getName());
            }
          }
        }
      }
      _xblockexpression = varCallFromImpVar;
    }
    return _xblockexpression;
  }
  
  public List<VarDefinition> checkVariableDefinitionCycle(final VarDefinition varDef) {
    varDef.checkVarCycle();
    return varDef.getVarDefCycle();
  }
}
