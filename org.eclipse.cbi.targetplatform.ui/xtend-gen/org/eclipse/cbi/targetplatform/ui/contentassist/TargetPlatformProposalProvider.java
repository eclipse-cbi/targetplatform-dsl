/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.ui.contentassist;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.cbi.targetplatform.Environment;
import org.eclipse.cbi.targetplatform.IU;
import org.eclipse.cbi.targetplatform.IncludeDeclaration;
import org.eclipse.cbi.targetplatform.Location;
import org.eclipse.cbi.targetplatform.Option;
import org.eclipse.cbi.targetplatform.Options;
import org.eclipse.cbi.targetplatform.TargetPlatform;
import org.eclipse.cbi.targetplatform.TargetPlatformFactory;
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess;
import org.eclipse.cbi.targetplatform.ui.contentassist.AbstractTargetPlatformProposalProvider;
import org.eclipse.cbi.targetplatform.ui.contentassist.ReadAndDispatchProgressMonitorWrapper;
import org.eclipse.cbi.targetplatform.ui.internal.TargetPlatformActivator;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class TargetPlatformProposalProvider extends AbstractTargetPlatformProposalProvider {
  private final static String PROP_TYPE_CATEGORY = "org.eclipse.equinox.p2.type.category";
  
  private final static String PROP_TYPE_PRODUCT = "org.eclipse.equinox.p2.type.product";
  
  private final static String TARGET_PLATFORM__NAME_PLACEHOLDER = "Target Platform Name";
  
  private final static String INCLUDE_DECLARATION__URI_PLACEHOLDER = "includedFile.tpd";
  
  private final static String LOCATION__URI_PLACEHOLDER = "http://p2.repository.url/";
  
  private final static String LOCATION__ID_PLACEHOLDER = "locationID";
  
  private final static TargetPlatform TARGET_PLATFORM = TargetPlatformFactory.eINSTANCE.createTargetPlatform();
  
  private final static IncludeDeclaration INCLUDE_DECLARATION = TargetPlatformFactory.eINSTANCE.createIncludeDeclaration();
  
  private final static Options OPTIONS = TargetPlatformFactory.eINSTANCE.createOptions();
  
  private final static Environment ENVIRONMENT = TargetPlatformFactory.eINSTANCE.createEnvironment();
  
  private final static Location LOCATION = TargetPlatformFactory.eINSTANCE.createLocation();
  
  private final static IU IU = TargetPlatformFactory.eINSTANCE.createIU();
  
  @Inject
  private TargetPlatformGrammarAccess grammarAccess;
  
  @Inject
  private IProvisioningAgent provisioningAgent;
  
  private IQuery<IInstallableUnit> iuAssistQuery;
  
  public TargetPlatformProposalProvider() {
  }
  
  @Override
  public void complete_TargetPlatform(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EObject _grammarElement = context.getCurrentNode().getGrammarElement();
    Keyword _targetKeyword_0 = this.grammarAccess.getTargetPlatformAccess().getTargetKeyword_0();
    boolean _notEquals = (!Objects.equal(_grammarElement, _targetKeyword_0));
    if (_notEquals) {
      String _value = this.grammarAccess.getTargetPlatformAccess().getTargetKeyword_0().getValue();
      final String proposalPrefix = (_value + " \"");
      final String proposalText = ((proposalPrefix + TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER) + "\"");
      String _lineDelimiter = context.getViewer().getTextWidget().getLineDelimiter();
      String _plus = (proposalText + _lineDelimiter);
      final ICompletionProposal p = this.createCompletionProposal(_plus, 
        new StyledString(proposalText).append(" - create a new target platform", StyledString.QUALIFIER_STYLER), 
        this.getImage(TargetPlatformProposalProvider.TARGET_PLATFORM), context);
      if ((p instanceof ConfigurableCompletionProposal)) {
        int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
        int _length = proposalPrefix.length();
        int _plus_1 = (_replacementOffset + _length);
        ((ConfigurableCompletionProposal)p).setSelectionStart(_plus_1);
        ((ConfigurableCompletionProposal)p).setSelectionLength(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER.length());
        ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(context.getViewer(), '\t');
      }
      acceptor.accept(p);
    }
  }
  
  private IQuery<IInstallableUnit> getIUAssistQuery() {
    boolean _tripleEquals = (this.iuAssistQuery == null);
    if (_tripleEquals) {
      this.iuAssistQuery = QueryUtil.createQuery("latest(x | x.properties[$0] != true && x.properties[$1] != true)", 
        TargetPlatformProposalProvider.PROP_TYPE_CATEGORY, TargetPlatformProposalProvider.PROP_TYPE_PRODUCT);
    }
    return this.iuAssistQuery;
  }
  
  @Override
  public void completeTargetPlatform_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    String textProposal = null;
    int offset = 0;
    EObject _grammarElement = context.getCurrentNode().getGrammarElement();
    Keyword _targetKeyword_0 = this.grammarAccess.getTargetPlatformAccess().getTargetKeyword_0();
    boolean _equals = Objects.equal(_grammarElement, _targetKeyword_0);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("\"");
      _builder.append(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER, " ");
      _builder.append("\"");
      String _lineDelimiter = context.getViewer().getTextWidget().getLineDelimiter();
      _builder.append(_lineDelimiter, " ");
      textProposal = _builder.toString();
      offset = 2;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\"");
      _builder_1.append(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER);
      _builder_1.append("\"");
      String _lineDelimiter_1 = context.getViewer().getTextWidget().getLineDelimiter();
      _builder_1.append(_lineDelimiter_1);
      textProposal = _builder_1.toString();
      offset = 1;
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"");
    _builder_2.append(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER);
    _builder_2.append("\"");
    final ICompletionProposal p = this.createCompletionProposal(textProposal, 
      new StyledString(_builder_2.toString()).append(" - name of the target", StyledString.QUALIFIER_STYLER), 
      this.getImage(TargetPlatformProposalProvider.TARGET_PLATFORM), context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _plus = (_replacementOffset + offset);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus);
      ((ConfigurableCompletionProposal)p).setSelectionLength(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER.length());
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(context.getViewer(), '\t');
    }
    acceptor.accept(p);
  }
  
  @Override
  public void completeTargetPlatform_Contents(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    int _offset = context.getOffset();
    int _endOffset = context.getLastCompleteNode().getEndOffset();
    final int currentNodeSizeToCursor = (_offset - _endOffset);
    String _xifexpression = null;
    int _length = context.getCurrentNode().getText().length();
    boolean _greaterEqualsThan = (_length >= currentNodeSizeToCursor);
    if (_greaterEqualsThan) {
      _xifexpression = context.getCurrentNode().getText().substring(0, currentNodeSizeToCursor);
    } else {
      _xifexpression = "";
    }
    final String text = _xifexpression;
    if ((text.contains("\n") || (context.getCurrentNode().getText().length() < currentNodeSizeToCursor))) {
      final TargetPlatform tp = ((TargetPlatform) model);
      boolean _isEmpty = tp.getOptions().isEmpty();
      if (_isEmpty) {
        acceptor.accept(this.createCompletionProposal("with", "describe how the set of elements to add to this target is determined", TargetPlatformProposalProvider.OPTIONS, 520, context));
      }
      Environment _environment = tp.getEnvironment();
      boolean _tripleEquals = (_environment == null);
      if (_tripleEquals) {
        acceptor.accept(this.createCompletionProposal("environment", "describe the system that this target is built for", TargetPlatformProposalProvider.ENVIRONMENT, 510, context));
      }
      this.templateLocation(context, acceptor);
      this.templateIncludeDeclaration(context, acceptor);
    }
  }
  
  private void templateLocation(final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    String _value = this.grammarAccess.getLocationAccess().getLocationKeyword_0().getValue();
    final String proposalPrefix = (_value + " \"");
    final String proposalText = ((proposalPrefix + TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER) + "\"");
    String _lineDelimiter = context.getViewer().getTextWidget().getLineDelimiter();
    String _plus = (" {" + _lineDelimiter);
    final String middleText = (_plus + "\t");
    String _lineDelimiter_1 = context.getViewer().getTextWidget().getLineDelimiter();
    String _plus_1 = ((proposalText + middleText) + _lineDelimiter_1);
    String _plus_2 = (_plus_1 + "}");
    final ICompletionProposal p = this.createCompletionProposal(_plus_2, 
      new StyledString(proposalText).append(" - add a new location to this target platform", StyledString.QUALIFIER_STYLER), 
      this.getImage(TargetPlatformProposalProvider.LOCATION), context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _defaultPriority = this.getPriorityHelper().getDefaultPriority();
      int _plus_3 = (_defaultPriority + 540);
      ((ConfigurableCompletionProposal)p).setPriority(_plus_3);
      int _length = proposalText.length();
      int _length_1 = middleText.length();
      int _plus_4 = (_length + _length_1);
      ((ConfigurableCompletionProposal)p).setCursorPosition(_plus_4);
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _length_2 = proposalPrefix.length();
      int _plus_5 = (_replacementOffset + _length_2);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus_5);
      ((ConfigurableCompletionProposal)p).setSelectionLength(TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER.length());
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(context.getViewer(), '\t');
    }
    acceptor.accept(p);
  }
  
  private void templateIncludeDeclaration(final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    String _value = this.grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0().getValue();
    final String proposalPrefix = (_value + " \"");
    final String proposalText = ((proposalPrefix + TargetPlatformProposalProvider.INCLUDE_DECLARATION__URI_PLACEHOLDER) + "\"");
    String _lineDelimiter = context.getViewer().getTextWidget().getLineDelimiter();
    String _plus = (proposalText + _lineDelimiter);
    final ICompletionProposal p = this.createCompletionProposal(_plus, 
      new StyledString(proposalText).append(" - include another target platform to this file", StyledString.QUALIFIER_STYLER), 
      this.getImage(TargetPlatformProposalProvider.INCLUDE_DECLARATION), context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _defaultPriority = this.getPriorityHelper().getDefaultPriority();
      int _plus_1 = (_defaultPriority + 530);
      ((ConfigurableCompletionProposal)p).setPriority(_plus_1);
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _length = proposalPrefix.length();
      int _plus_2 = (_replacementOffset + _length);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus_2);
      ((ConfigurableCompletionProposal)p).setSelectionLength(TargetPlatformProposalProvider.INCLUDE_DECLARATION__URI_PLACEHOLDER.length());
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(context.getViewer(), '\t');
    }
    acceptor.accept(p);
  }
  
  @Override
  public void completeOptions_Options(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    int _offset = context.getOffset();
    int _endOffset = context.getLastCompleteNode().getEndOffset();
    final int currentNodeSizeToCursor = (_offset - _endOffset);
    String _xifexpression = null;
    int _length = context.getCurrentNode().getText().length();
    boolean _greaterEqualsThan = (_length >= currentNodeSizeToCursor);
    if (_greaterEqualsThan) {
      _xifexpression = context.getCurrentNode().getText().substring(0, currentNodeSizeToCursor);
    } else {
      _xifexpression = "";
    }
    final String text = _xifexpression;
    if (((!text.contains("\n")) || (context.getCurrentNode().getText().length() < currentNodeSizeToCursor))) {
      final Options options = ((Options) model);
      boolean _contains = options.getOptions().contains(Option.INCLUDE_REQUIRED);
      boolean _not = (!_contains);
      if (_not) {
        acceptor.accept(this.createCompletionProposal(Option.INCLUDE_REQUIRED.getLiteral(), "all required software will be added to the target platform", options, 440, context));
      }
      boolean _contains_1 = options.getOptions().contains(Option.INCLUDE_SOURCE);
      boolean _not_1 = (!_contains_1);
      if (_not_1) {
        acceptor.accept(this.createCompletionProposal(Option.INCLUDE_SOURCE.getLiteral(), "sources (if available) of the content will be added to the target platform", options, 430, context));
      }
      boolean _contains_2 = options.getOptions().contains(Option.INCLUDE_ALL_ENVIRONMENTS);
      boolean _not_2 = (!_contains_2);
      if (_not_2) {
        acceptor.accept(this.createCompletionProposal(Option.INCLUDE_ALL_ENVIRONMENTS.getLiteral(), "all available environment specific plug-ins will be added to the target platform", options, 420, context));
      }
      boolean _contains_3 = options.getOptions().contains(Option.INCLUDE_CONFIGURE_PHASE);
      boolean _not_3 = (!_contains_3);
      if (_not_3) {
        acceptor.accept(this.createCompletionProposal(Option.INCLUDE_CONFIGURE_PHASE.getLiteral(), "the configure phase will be run during the download operation of the target platform", options, 410, context));
      }
    }
  }
  
  private ICompletionProposal createCompletionProposal(final String proposal, final String desc, final EObject imageFor, final int priority, final ContentAssistContext context) {
    StyledString _styledString = new StyledString(proposal);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("- ");
    _builder.append(desc, " ");
    final ICompletionProposal p = this.createCompletionProposal(proposal, 
      _styledString.append(_builder.toString(), StyledString.QUALIFIER_STYLER), 
      this.getImage(imageFor), context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _defaultPriority = this.getPriorityHelper().getDefaultPriority();
      int _plus = (_defaultPriority + priority);
      ((ConfigurableCompletionProposal)p).setPriority(_plus);
    }
    return p;
  }
  
  @Override
  public void completeEnvironment_Env(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    int _offset = context.getOffset();
    int _endOffset = context.getLastCompleteNode().getEndOffset();
    final int currentNodeSizeToCursor = (_offset - _endOffset);
    String _xifexpression = null;
    int _length = context.getCurrentNode().getText().length();
    boolean _greaterEqualsThan = (_length >= currentNodeSizeToCursor);
    if (_greaterEqualsThan) {
      _xifexpression = context.getCurrentNode().getText().substring(0, currentNodeSizeToCursor);
    } else {
      _xifexpression = "";
    }
    final String text = _xifexpression;
    if (((!text.contains("\n")) || (context.getCurrentNode().getText().length() < currentNodeSizeToCursor))) {
      final Environment env = ((Environment) model);
      String _operatingSystem = env.getOperatingSystem();
      boolean _tripleEquals = (_operatingSystem == null);
      if (_tripleEquals) {
        final Consumer<String> _function = new Consumer<String>() {
          @Override
          public void accept(final String it) {
            acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(it, "operating system", env, 340, context));
          }
        };
        ((List<String>)Conversions.doWrapArray(Platform.knownOSValues())).forEach(_function);
      }
      String _windowingSystem = env.getWindowingSystem();
      boolean _tripleEquals_1 = (_windowingSystem == null);
      if (_tripleEquals_1) {
        final Consumer<String> _function_1 = new Consumer<String>() {
          @Override
          public void accept(final String it) {
            acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(it, "windowing system", env, 330, context));
          }
        };
        ((List<String>)Conversions.doWrapArray(Platform.knownWSValues())).forEach(_function_1);
      }
      String _architecture = env.getArchitecture();
      boolean _tripleEquals_2 = (_architecture == null);
      if (_tripleEquals_2) {
        final Consumer<String> _function_2 = new Consumer<String>() {
          @Override
          public void accept(final String it) {
            acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(it, "architecture", env, 320, context));
          }
        };
        ((List<String>)Conversions.doWrapArray(Platform.knownOSArchValues())).forEach(_function_2);
      }
      IExecutionEnvironment _executionEnvironment = env.getExecutionEnvironment();
      boolean _tripleEquals_3 = (_executionEnvironment == null);
      if (_tripleEquals_3) {
        final IExecutionEnvironmentsManager eeManager = JavaRuntime.getExecutionEnvironmentsManager();
        boolean _tripleNotEquals = (eeManager != null);
        if (_tripleNotEquals) {
          final Consumer<IExecutionEnvironment> _function_3 = new Consumer<IExecutionEnvironment>() {
            @Override
            public void accept(final IExecutionEnvironment it) {
              acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(it.getId(), it.getDescription(), env, 310, context));
            }
          };
          ((List<IExecutionEnvironment>)Conversions.doWrapArray(eeManager.getExecutionEnvironments())).forEach(_function_3);
        }
      }
      Locale _localization = env.getLocalization();
      boolean _tripleEquals_4 = (_localization == null);
      if (_tripleEquals_4) {
        final Consumer<Locale> _function_4 = new Consumer<Locale>() {
          @Override
          public void accept(final Locale it) {
            acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(it.toString(), it.getDisplayName(), env, 300, context));
          }
        };
        ((List<Locale>)Conversions.doWrapArray(Locale.getAvailableLocales())).forEach(_function_4);
      }
    }
  }
  
  @Override
  public void completeIU_ID(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    try {
      int _offset = context.getOffset();
      int _endOffset = context.getLastCompleteNode().getEndOffset();
      final int currentNodeSizeToCursor = (_offset - _endOffset);
      String _xifexpression = null;
      int _length = context.getCurrentNode().getText().length();
      boolean _greaterEqualsThan = (_length >= currentNodeSizeToCursor);
      if (_greaterEqualsThan) {
        _xifexpression = context.getCurrentNode().getText().substring(0, currentNodeSizeToCursor);
      } else {
        _xifexpression = "";
      }
      final String text = _xifexpression;
      if ((text.contains("\n") || (context.getCurrentNode().getText().length() < currentNodeSizeToCursor))) {
        final Location location = ((Location) model);
        final String uri = location.getUri();
        final IWorkbenchWindow window = TargetPlatformActivator.getInstance().getWorkbench().getActiveWorkbenchWindow();
        final IRunnableWithProgress _function = new IRunnableWithProgress() {
          @Override
          public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            Display _display = window.getShell().getDisplay();
            ReadAndDispatchProgressMonitorWrapper _readAndDispatchProgressMonitorWrapper = new ReadAndDispatchProgressMonitorWrapper(monitor, _display);
            final SubMonitor wpm = SubMonitor.convert(_readAndDispatchProgressMonitorWrapper, ("Creating content assist for " + uri), 100);
            try {
              Object _service = TargetPlatformProposalProvider.this.provisioningAgent.getService(IMetadataRepositoryManager.SERVICE_NAME);
              final IMetadataRepositoryManager repositoryManager = ((IMetadataRepositoryManager) _service);
              URI _uRI = new URI(uri);
              final IMetadataRepository metadataRepository = repositoryManager.loadRepository(_uRI, wpm.newChild(90));
              final Set<IInstallableUnit> results = metadataRepository.query(TargetPlatformProposalProvider.this.getIUAssistQuery(), wpm.newChild(5)).toUnmodifiableSet();
              final Function1<IInstallableUnit, Boolean> _function = new Function1<IInstallableUnit, Boolean>() {
                @Override
                public Boolean apply(final IInstallableUnit it) {
                  final Function1<IU, String> _function = new Function1<IU, String>() {
                    @Override
                    public String apply(final IU it) {
                      return it.getID();
                    }
                  };
                  boolean _contains = ListExtensions.<IU, String>map(location.getIus(), _function).contains(it.getId());
                  return Boolean.valueOf((!_contains));
                }
              };
              final Consumer<IInstallableUnit> _function_1 = new Consumer<IInstallableUnit>() {
                @Override
                public void accept(final IInstallableUnit it) {
                  final IQueryResult<IInstallableUnit> allVersions = metadataRepository.query(QueryUtil.createIUQuery(it.getId()), wpm.newChild(5));
                  final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
                    @Override
                    public String apply(final IInstallableUnit it) {
                      return it.getVersion().toString();
                    }
                  };
                  acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(it.getId(), IteratorExtensions.join(IteratorExtensions.<IInstallableUnit, String>map(allVersions.iterator(), _function), ", "), TargetPlatformProposalProvider.IU, 0, context));
                }
              };
              IterableExtensions.<IInstallableUnit>filter(results, _function).forEach(_function_1);
            } catch (final Throwable _t) {
              if (_t instanceof Exception) {
                final Exception e = (Exception)_t;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        };
        final IRunnableWithProgress op = _function;
        window.run(false, true, op);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void completeIU_Version(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    try {
      final String docText = context.getViewer().getDocument().get();
      final int offset = context.getOffset();
      String _xifexpression = null;
      int _length = docText.length();
      boolean _greaterEqualsThan = (_length >= 1);
      if (_greaterEqualsThan) {
        _xifexpression = docText.substring((offset - 1), offset);
      } else {
        _xifexpression = "";
      }
      final String charBefore = _xifexpression;
      String _xifexpression_1 = null;
      if (((!charBefore.equals(" ")) && (!charBefore.equals("\n")))) {
        _xifexpression_1 = " ";
      } else {
        _xifexpression_1 = "";
      }
      final String prefix = _xifexpression_1;
      int _offset = context.getOffset();
      int _endOffset = context.getLastCompleteNode().getEndOffset();
      final int currentNodeSizeToCursor = (_offset - _endOffset);
      String _xifexpression_2 = null;
      int _length_1 = context.getCurrentNode().getText().length();
      boolean _greaterEqualsThan_1 = (_length_1 >= currentNodeSizeToCursor);
      if (_greaterEqualsThan_1) {
        _xifexpression_2 = context.getCurrentNode().getText().substring(0, currentNodeSizeToCursor);
      } else {
        _xifexpression_2 = "";
      }
      final String text = _xifexpression_2;
      if (((!text.contains("\n")) || (context.getCurrentNode().getText().length() < currentNodeSizeToCursor))) {
        final IU iu = ((IU) model);
        final String uri = iu.getLocation().getUri();
        final IWorkbenchWindow window = TargetPlatformActivator.getInstance().getWorkbench().getActiveWorkbenchWindow();
        final IRunnableWithProgress op = this.versionProposalRunnable(uri, iu, prefix, window.getShell().getDisplay(), context, acceptor);
        window.run(false, true, op);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void completeLocation_ID(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final String docText = context.getViewer().getDocument().get();
    final int offset = context.getOffset();
    String _xifexpression = null;
    int _length = docText.length();
    boolean _greaterEqualsThan = (_length >= 1);
    if (_greaterEqualsThan) {
      _xifexpression = docText.substring((offset - 1), offset);
    } else {
      _xifexpression = "";
    }
    final String charBefore = _xifexpression;
    String _xifexpression_1 = null;
    int _length_1 = docText.length();
    boolean _greaterThan = (_length_1 > offset);
    if (_greaterThan) {
      _xifexpression_1 = docText.substring(offset, (offset + 1));
    } else {
      _xifexpression_1 = "";
    }
    final String charAfter = _xifexpression_1;
    String _xifexpression_2 = null;
    if (((!charBefore.equals(" ")) && (!charBefore.equals("\n")))) {
      _xifexpression_2 = " ";
    } else {
      _xifexpression_2 = "";
    }
    final String prefix = _xifexpression_2;
    String _xifexpression_3 = null;
    boolean _equals = charAfter.equals(" ");
    boolean _not = (!_equals);
    if (_not) {
      _xifexpression_3 = " ";
    } else {
      _xifexpression_3 = "";
    }
    final String suffix = _xifexpression_3;
    final String proposal = ((prefix + TargetPlatformProposalProvider.LOCATION__ID_PLACEHOLDER) + suffix);
    final ICompletionProposal p = this.createCompletionProposal(proposal, 
      new StyledString(TargetPlatformProposalProvider.LOCATION__ID_PLACEHOLDER).append(" - ID of this location ", StyledString.QUALIFIER_STYLER), 
      this.getImage(TargetPlatformProposalProvider.LOCATION), context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _length_2 = prefix.length();
      int _plus = (_replacementOffset + _length_2);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus);
      ((ConfigurableCompletionProposal)p).setSelectionLength(TargetPlatformProposalProvider.LOCATION__ID_PLACEHOLDER.length());
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(context.getViewer(), '\t');
    }
    acceptor.accept(p);
  }
  
  @Override
  public void completeLocation_Uri(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final String docText = context.getViewer().getDocument().get();
    final int offset = context.getOffset();
    String _xifexpression = null;
    int _length = docText.length();
    boolean _greaterEqualsThan = (_length >= 1);
    if (_greaterEqualsThan) {
      _xifexpression = docText.substring((offset - 1), offset);
    } else {
      _xifexpression = "";
    }
    final String charBefore = _xifexpression;
    String _xifexpression_1 = null;
    int _length_1 = docText.length();
    boolean _greaterThan = (_length_1 > offset);
    if (_greaterThan) {
      _xifexpression_1 = docText.substring(offset, (offset + 1));
    } else {
      _xifexpression_1 = "";
    }
    final String charAfter = _xifexpression_1;
    String _xifexpression_2 = null;
    if (((!charBefore.equals(" ")) && (!charBefore.equals("\n")))) {
      _xifexpression_2 = " \"";
    } else {
      _xifexpression_2 = "\"";
    }
    final String prefix = _xifexpression_2;
    String _xifexpression_3 = null;
    boolean _equals = charAfter.equals(" ");
    boolean _not = (!_equals);
    if (_not) {
      _xifexpression_3 = "\" ";
    } else {
      _xifexpression_3 = "\"";
    }
    final String suffix = _xifexpression_3;
    final String proposal = ((prefix + TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER) + suffix);
    final ICompletionProposal p = this.createCompletionProposal(proposal, 
      new StyledString(TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER).append(" - URI of the location", StyledString.QUALIFIER_STYLER), 
      this.getImage(TargetPlatformProposalProvider.LOCATION), context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _length_2 = prefix.length();
      int _plus = (_replacementOffset + _length_2);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus);
      ((ConfigurableCompletionProposal)p).setSelectionLength(TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER.length());
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(context.getViewer(), '\t');
    }
    acceptor.accept(p);
  }
  
  @Override
  public void completeKeyword(final Keyword keyword, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
  }
  
  @Override
  public void complete_STRING(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
  }
  
  private IRunnableWithProgress versionProposalRunnable(final String uri, final IU iu, final String prefix, final Display display, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final IRunnableWithProgress _function = new IRunnableWithProgress() {
      @Override
      public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        try {
          ReadAndDispatchProgressMonitorWrapper _readAndDispatchProgressMonitorWrapper = new ReadAndDispatchProgressMonitorWrapper(monitor, display);
          final SubMonitor wpm = SubMonitor.convert(_readAndDispatchProgressMonitorWrapper, ("Creating content assist for " + uri), 100);
          try {
            Object _service = TargetPlatformProposalProvider.this.provisioningAgent.getService(IMetadataRepositoryManager.SERVICE_NAME);
            final IMetadataRepositoryManager repositoryManager = ((IMetadataRepositoryManager) _service);
            URI _uRI = new URI(uri);
            final IMetadataRepository metadataRepository = repositoryManager.loadRepository(_uRI, wpm.newChild(95));
            final Set<IInstallableUnit> results = metadataRepository.query(QueryUtil.createIUQuery(iu.getID()), wpm.newChild(5)).toUnmodifiableSet();
            final Consumer<IInstallableUnit> _function = new Consumer<IInstallableUnit>() {
              @Override
              public void accept(final IInstallableUnit it) {
                Comparable<?> _segment = it.getVersion().getSegment(0);
                final Integer major = ((Integer) _segment);
                Comparable<?> _segment_1 = it.getVersion().getSegment(1);
                final Integer minor = ((Integer) _segment_1);
                Comparable<?> _segment_2 = it.getVersion().getSegment(2);
                final Integer micro = ((Integer) _segment_2);
                StringConcatenation _builder = new StringConcatenation();
                _builder.append(prefix);
                _builder.append("[");
                _builder.append(major);
                _builder.append(".");
                _builder.append(minor);
                _builder.append(".");
                _builder.append(micro);
                _builder.append(",");
                _builder.append(((major).intValue() + 1));
                _builder.append(".0.0)");
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("[");
                _builder_1.append(major);
                _builder_1.append(".");
                _builder_1.append(minor);
                _builder_1.append(".");
                _builder_1.append(micro);
                _builder_1.append(",");
                _builder_1.append(((major).intValue() + 1));
                _builder_1.append(".0.0)");
                acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(_builder.toString(), _builder_1.toString(), TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU), context));
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append(prefix);
                _builder_2.append("[");
                _builder_2.append(major);
                _builder_2.append(".");
                _builder_2.append(minor);
                _builder_2.append(".");
                _builder_2.append(micro);
                _builder_2.append(",");
                _builder_2.append(major);
                _builder_2.append(".");
                _builder_2.append(((minor).intValue() + 1));
                _builder_2.append(".0)");
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("[");
                _builder_3.append(major);
                _builder_3.append(".");
                _builder_3.append(minor);
                _builder_3.append(".");
                _builder_3.append(micro);
                _builder_3.append(",");
                _builder_3.append(major);
                _builder_3.append(".");
                _builder_3.append(((minor).intValue() + 1));
                _builder_3.append(".0)");
                acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(_builder_2.toString(), _builder_3.toString(), TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU), context));
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append(prefix);
                _builder_4.append("[");
                _builder_4.append(major);
                _builder_4.append(".");
                _builder_4.append(minor);
                _builder_4.append(".");
                _builder_4.append(micro);
                _builder_4.append(",");
                _builder_4.append(major);
                _builder_4.append(".");
                _builder_4.append(minor);
                _builder_4.append(".");
                _builder_4.append(((micro).intValue() + 1));
                _builder_4.append(")");
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("[");
                _builder_5.append(major);
                _builder_5.append(".");
                _builder_5.append(minor);
                _builder_5.append(".");
                _builder_5.append(micro);
                _builder_5.append(",");
                _builder_5.append(major);
                _builder_5.append(".");
                _builder_5.append(minor);
                _builder_5.append(".");
                _builder_5.append(((micro).intValue() + 1));
                _builder_5.append(")");
                acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(_builder_4.toString(), _builder_5.toString(), TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU), context));
                StringConcatenation _builder_6 = new StringConcatenation();
                _builder_6.append(prefix);
                _builder_6.append("[");
                Version _version = it.getVersion();
                _builder_6.append(_version);
                _builder_6.append(",");
                Version _version_1 = it.getVersion();
                _builder_6.append(_version_1);
                _builder_6.append("]");
                StringConcatenation _builder_7 = new StringConcatenation();
                _builder_7.append("[");
                Version _version_2 = it.getVersion();
                _builder_7.append(_version_2);
                _builder_7.append(",");
                Version _version_3 = it.getVersion();
                _builder_7.append(_version_3);
                _builder_7.append("]");
                acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(_builder_6.toString(), _builder_7.toString(), TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU), context));
              }
            };
            results.forEach(_function);
            boolean _isEmpty = results.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append(prefix);
              _builder.append("lazy");
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("lazy");
              acceptor.accept(TargetPlatformProposalProvider.this.createCompletionProposal(_builder.toString(), _builder_1.toString(), TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU), context));
            }
          } catch (final Throwable _t) {
            if (_t instanceof IllegalStateException) {
              final IllegalStateException e = (IllegalStateException)_t;
            } else if (_t instanceof ProvisionException) {
              final ProvisionException e_1 = (ProvisionException)_t;
            } else if (_t instanceof OperationCanceledException) {
              final OperationCanceledException e_2 = (OperationCanceledException)_t;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return _function;
  }
}
