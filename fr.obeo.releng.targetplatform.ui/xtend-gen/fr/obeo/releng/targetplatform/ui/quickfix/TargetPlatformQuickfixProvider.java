/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 */
package fr.obeo.releng.targetplatform.ui.quickfix;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Custom quickfixes.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
@SuppressWarnings("all")
public class TargetPlatformQuickfixProvider extends DefaultQuickfixProvider {
  @Fix(TargetPlatformValidator.DEPRECATE__STRINGS_ON_IU_VERSION)
  public void removeQuotes(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext context) throws Exception {
        final IXtextDocument xtextDocument = context.getXtextDocument();
        Integer _offset = issue.getOffset();
        Integer _length = issue.getLength();
        int _plus = ((_offset).intValue() + (_length).intValue());
        int _minus = (_plus - 1);
        xtextDocument.replace(_minus, 1, "");
        xtextDocument.replace((issue.getOffset()).intValue(), 1, "");
      }
    };
    acceptor.accept(issue, "Remove quotes.", "Remove quotes.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.CHECK__OPTIONS_EQUALS_ALL_LOCATIONS)
  public void equalizeOptions(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = new ISemanticModification() {
      @Override
      public void apply(final EObject element, final IModificationContext context) throws Exception {
        final Location location = ((Location) element);
        final Consumer<Location> _function = new Consumer<Location>() {
          @Override
          public void accept(final Location _) {
            final Location elemLoc = ((Location) element);
            final EList<Option> locOptions = elemLoc.getOptions();
            if (((!Objects.equal(_, element)) && (!Sets.<Option>symmetricDifference(IterableExtensions.<Option>toSet(locOptions), IterableExtensions.<Option>toSet(_.getOptions())).isEmpty()))) {
              _.getOptions().clear();
              _.getOptions().addAll(locOptions);
            }
          }
        };
        location.getTargetPlatform().getLocations().forEach(_function);
      }
    };
    acceptor.accept(issue, 
      "Set all options equals to this one.", "Set all options equals to this one.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED)
  public void removeRemoveRequirements(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = new ISemanticModification() {
      @Override
      public void apply(final EObject element, final IModificationContext context) throws Exception {
        if ((element instanceof TargetPlatform)) {
          ((TargetPlatform) element).getOptions().remove(Option.INCLUDE_REQUIRED);
        } else {
          if ((element instanceof Location)) {
            ((Location) element).getOptions().remove(Option.INCLUDE_REQUIRED);
          }
        }
      }
    };
    acceptor.accept(issue, 
      "Remove \'with requirements\' option.", "Remove \'with requirements\' option.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED)
  public void removeRemoveAllEnvironment(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = new ISemanticModification() {
      @Override
      public void apply(final EObject element, final IModificationContext context) throws Exception {
        if ((element instanceof TargetPlatform)) {
          ((TargetPlatform) element).getOptions().remove(Option.INCLUDE_ALL_ENVIRONMENTS);
        } else {
          if ((element instanceof Location)) {
            ((Location) element).getOptions().remove(Option.INCLUDE_ALL_ENVIRONMENTS);
          }
        }
      }
    };
    acceptor.accept(issue, 
      "Remove \'with allEnvironments\' option.", "Remove \'with allEnvironments\' option.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.DEPRECATE__OPTIONS_ON_LOCATIONS)
  public void moveOptionsToTargetLevel(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = new ISemanticModification() {
      @Override
      public void apply(final EObject element, final IModificationContext context) throws Exception {
        final Location location = ((Location) element);
        location.getTargetPlatform().getOptions().clear();
        final Consumer<Option> _function = new Consumer<Option>() {
          @Override
          public void accept(final Option it) {
            location.getTargetPlatform().getOptions().add(it);
          }
        };
        ((Location) element).getOptions().forEach(_function);
        final Consumer<Location> _function_1 = new Consumer<Location>() {
          @Override
          public void accept(final Location it) {
            it.getOptions().clear();
          }
        };
        location.getTargetPlatform().getLocations().forEach(_function_1);
        context.getXtextDocument();
      }
    };
    acceptor.accept(issue, 
      "Move options to the target level and remove all location specific options.", 
      "Move options to the target level and remove all location specific options.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS)
  public void removeAllLocationSpecificOptions(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = new ISemanticModification() {
      @Override
      public void apply(final EObject element, final IModificationContext context) throws Exception {
        final Location location = ((Location) element);
        final Consumer<Location> _function = new Consumer<Location>() {
          @Override
          public void accept(final Location it) {
            it.getOptions().clear();
          }
        };
        location.getTargetPlatform().getLocations().forEach(_function);
      }
    };
    acceptor.accept(issue, 
      "Remove all location specific options.", 
      "Remove all location specific options.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.CHECK__LOCATION_CONFLICTUAL_ID)
  public void setOtherLocationWithSameURIToTheSameID(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = new ISemanticModification() {
      @Override
      public void apply(final EObject element, final IModificationContext context) throws Exception {
        final String id = ((Location) element).getID();
        final String uri = ((Location) element).getUri();
        boolean _notEquals = (!Objects.equal(uri, null));
        if (_notEquals) {
          final Location location = ((Location) element);
          final Function1<Location, Boolean> _function = new Function1<Location, Boolean>() {
            @Override
            public Boolean apply(final Location it) {
              return Boolean.valueOf(((!Objects.equal(uri, null)) && uri.equals(it.getUri())));
            }
          };
          final Consumer<Location> _function_1 = new Consumer<Location>() {
            @Override
            public void accept(final Location it) {
              it.setID(id);
            }
          };
          IterableExtensions.<Location>filter(location.getTargetPlatform().getLocations(), _function).forEach(_function_1);
        }
      }
    };
    acceptor.accept(issue, 
      "Set other locations with the same URI to the same ID.", 
      "Set other locations with the same URI to the same ID.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID)
  public void setIDSameValueAsIncludedLocation(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = new ISemanticModification() {
      @Override
      public void apply(final EObject element, final IModificationContext context) throws Exception {
        final String id = issue.getData()[0];
        final String uri = issue.getData()[1];
        final Location location = ((Location) element);
        final Function1<Location, Boolean> _function = new Function1<Location, Boolean>() {
          @Override
          public Boolean apply(final Location it) {
            return Boolean.valueOf(((!Objects.equal(uri, null)) && uri.equals(it.getUri())));
          }
        };
        final Consumer<Location> _function_1 = new Consumer<Location>() {
          @Override
          public void accept(final Location it) {
            it.setID(id);
          }
        };
        IterableExtensions.<Location>filter(location.getTargetPlatform().getLocations(), _function).forEach(_function_1);
      }
    };
    acceptor.accept(issue, 
      "Set the IDs of all locations with the same URI to the same value as included location.", 
      "Set the IDs of all locations with the same URI to the same value as included location.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.CHECK__VERSION_KEYWORDS)
  public void removeVersionKeywords(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext context) throws Exception {
        final IXtextDocument xtextDocument = context.getXtextDocument();
        xtextDocument.replace((issue.getOffset()).intValue(), (issue.getLength()).intValue(), "");
      }
    };
    acceptor.accept(issue, "Remove deprecated keywords.", "Remove deprecated keywords.", null, _function);
  }
  
  @Fix(TargetPlatformValidator.CHECK__ESCAPE_CHAR_IU_ID)
  public void removeEscapeCharInIUID(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext context) throws Exception {
        final IXtextDocument xtextDocument = context.getXtextDocument();
        final String fullId = xtextDocument.get((issue.getOffset()).intValue(), (issue.getLength()).intValue());
        final String replaceID = fullId.replaceAll("\\^", "");
        xtextDocument.replace((issue.getOffset()).intValue(), (issue.getLength()).intValue(), replaceID);
      }
    };
    acceptor.accept(issue, "Remove deprecated escape character.", "Remove deprecated escape character.", null, _function);
  }
}
