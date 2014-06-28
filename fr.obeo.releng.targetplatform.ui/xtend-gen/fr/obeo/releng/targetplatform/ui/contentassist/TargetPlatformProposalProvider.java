package fr.obeo.releng.targetplatform.ui.contentassist;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.Environment;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.Options;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformFactory;
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess;
import fr.obeo.releng.targetplatform.ui.contentassist.AbstractTargetPlatformProposalProvider;
import fr.obeo.releng.targetplatform.ui.contentassist.ReadAndDispatchProgressMonitorWrapper;
import fr.obeo.releng.targetplatform.ui.internal.TargetPlatformActivator;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalPriorities;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
  
  public void complete_TargetPlatform(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    INode _currentNode = context.getCurrentNode();
    EObject _grammarElement = _currentNode.getGrammarElement();
    TargetPlatformGrammarAccess.TargetPlatformElements _targetPlatformAccess = this.grammarAccess.getTargetPlatformAccess();
    Keyword _targetKeyword_0 = _targetPlatformAccess.getTargetKeyword_0();
    boolean _notEquals = (!Objects.equal(_grammarElement, _targetKeyword_0));
    if (_notEquals) {
      TargetPlatformGrammarAccess.TargetPlatformElements _targetPlatformAccess_1 = this.grammarAccess.getTargetPlatformAccess();
      Keyword _targetKeyword_0_1 = _targetPlatformAccess_1.getTargetKeyword_0();
      String _value = _targetKeyword_0_1.getValue();
      final String proposalPrefix = (_value + " \"");
      final String proposalText = ((proposalPrefix + TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER) + "\"");
      ITextViewer _viewer = context.getViewer();
      StyledText _textWidget = _viewer.getTextWidget();
      String _lineDelimiter = _textWidget.getLineDelimiter();
      String _plus = (proposalText + _lineDelimiter);
      StyledString _styledString = new StyledString(proposalText);
      StyledString _append = _styledString.append(" - create a new target platform", StyledString.QUALIFIER_STYLER);
      Image _image = this.getImage(TargetPlatformProposalProvider.TARGET_PLATFORM);
      final ICompletionProposal p = this.createCompletionProposal(_plus, _append, _image, context);
      if ((p instanceof ConfigurableCompletionProposal)) {
        int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
        int _length = proposalPrefix.length();
        int _plus_1 = (_replacementOffset + _length);
        ((ConfigurableCompletionProposal)p).setSelectionStart(_plus_1);
        int _length_1 = TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER.length();
        ((ConfigurableCompletionProposal)p).setSelectionLength(_length_1);
        ITextViewer _viewer_1 = context.getViewer();
        ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(_viewer_1, '\t');
      }
      acceptor.accept(p);
    }
  }
  
  private IQuery<IInstallableUnit> getIUAssistQuery() {
    boolean _equals = Objects.equal(this.iuAssistQuery, null);
    if (_equals) {
      IQuery<IInstallableUnit> _createQuery = QueryUtil.createQuery("latest(x | x.properties[$0] != true && x.properties[$1] != true)", 
        TargetPlatformProposalProvider.PROP_TYPE_CATEGORY, TargetPlatformProposalProvider.PROP_TYPE_PRODUCT);
      this.iuAssistQuery = _createQuery;
    }
    return this.iuAssistQuery;
  }
  
  public void completeTargetPlatform_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    String textProposal = null;
    int offset = 0;
    INode _currentNode = context.getCurrentNode();
    EObject _grammarElement = _currentNode.getGrammarElement();
    TargetPlatformGrammarAccess.TargetPlatformElements _targetPlatformAccess = this.grammarAccess.getTargetPlatformAccess();
    Keyword _targetKeyword_0 = _targetPlatformAccess.getTargetKeyword_0();
    boolean _equals = Objects.equal(_grammarElement, _targetKeyword_0);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("\"");
      _builder.append(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER, " ");
      _builder.append("\"");
      ITextViewer _viewer = context.getViewer();
      StyledText _textWidget = _viewer.getTextWidget();
      String _lineDelimiter = _textWidget.getLineDelimiter();
      _builder.append(_lineDelimiter, " ");
      textProposal = _builder.toString();
      offset = 2;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\"");
      _builder_1.append(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER, "");
      _builder_1.append("\"");
      ITextViewer _viewer_1 = context.getViewer();
      StyledText _textWidget_1 = _viewer_1.getTextWidget();
      String _lineDelimiter_1 = _textWidget_1.getLineDelimiter();
      _builder_1.append(_lineDelimiter_1, "");
      textProposal = _builder_1.toString();
      offset = 1;
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"");
    _builder_2.append(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER, "");
    _builder_2.append("\"");
    StyledString _styledString = new StyledString(_builder_2.toString());
    StyledString _append = _styledString.append(" - name of the target", StyledString.QUALIFIER_STYLER);
    Image _image = this.getImage(TargetPlatformProposalProvider.TARGET_PLATFORM);
    final ICompletionProposal p = this.createCompletionProposal(textProposal, _append, _image, context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _plus = (_replacementOffset + offset);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus);
      int _length = TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER.length();
      ((ConfigurableCompletionProposal)p).setSelectionLength(_length);
      ITextViewer _viewer_2 = context.getViewer();
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(_viewer_2, '\t');
    }
    acceptor.accept(p);
  }
  
  public void completeTargetPlatform_Contents(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    int _offset = context.getOffset();
    INode _lastCompleteNode = context.getLastCompleteNode();
    int _endOffset = _lastCompleteNode.getEndOffset();
    final int currentNodeSizeToCursor = (_offset - _endOffset);
    String _xifexpression = null;
    INode _currentNode = context.getCurrentNode();
    String _text = _currentNode.getText();
    int _length = _text.length();
    boolean _greaterEqualsThan = (_length >= currentNodeSizeToCursor);
    if (_greaterEqualsThan) {
      INode _currentNode_1 = context.getCurrentNode();
      String _text_1 = _currentNode_1.getText();
      _xifexpression = _text_1.substring(0, currentNodeSizeToCursor);
    } else {
      _xifexpression = "";
    }
    final String text = _xifexpression;
    boolean _or = false;
    boolean _contains = text.contains("\n");
    if (_contains) {
      _or = true;
    } else {
      INode _currentNode_2 = context.getCurrentNode();
      String _text_2 = _currentNode_2.getText();
      int _length_1 = _text_2.length();
      boolean _lessThan = (_length_1 < currentNodeSizeToCursor);
      _or = _lessThan;
    }
    if (_or) {
      final TargetPlatform tp = ((TargetPlatform) model);
      EList<Option> _options = tp.getOptions();
      boolean _isEmpty = _options.isEmpty();
      if (_isEmpty) {
        ICompletionProposal _createCompletionProposal = this.createCompletionProposal("with", "describe how the set of elements to add to this target is determined", TargetPlatformProposalProvider.OPTIONS, 520, context);
        acceptor.accept(_createCompletionProposal);
      }
      Environment _environment = tp.getEnvironment();
      boolean _equals = Objects.equal(_environment, null);
      if (_equals) {
        ICompletionProposal _createCompletionProposal_1 = this.createCompletionProposal("environment", "describe the system that this target is built for", TargetPlatformProposalProvider.ENVIRONMENT, 510, context);
        acceptor.accept(_createCompletionProposal_1);
      }
      this.templateLocation(context, acceptor);
      this.templateIncludeDeclaration(context, acceptor);
    }
  }
  
  private void templateLocation(final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    TargetPlatformGrammarAccess.LocationElements _locationAccess = this.grammarAccess.getLocationAccess();
    Keyword _locationKeyword_0 = _locationAccess.getLocationKeyword_0();
    String _value = _locationKeyword_0.getValue();
    final String proposalPrefix = (_value + " \"");
    final String proposalText = ((proposalPrefix + TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER) + "\"");
    ITextViewer _viewer = context.getViewer();
    StyledText _textWidget = _viewer.getTextWidget();
    String _lineDelimiter = _textWidget.getLineDelimiter();
    String _plus = (" {" + _lineDelimiter);
    final String middleText = (_plus + "\t");
    ITextViewer _viewer_1 = context.getViewer();
    StyledText _textWidget_1 = _viewer_1.getTextWidget();
    String _lineDelimiter_1 = _textWidget_1.getLineDelimiter();
    String _plus_1 = ((proposalText + middleText) + _lineDelimiter_1);
    String _plus_2 = (_plus_1 + "}");
    StyledString _styledString = new StyledString(proposalText);
    StyledString _append = _styledString.append(" - add a new location to this target platform", StyledString.QUALIFIER_STYLER);
    Image _image = this.getImage(TargetPlatformProposalProvider.LOCATION);
    final ICompletionProposal p = this.createCompletionProposal(_plus_2, _append, _image, context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      IContentProposalPriorities _priorityHelper = this.getPriorityHelper();
      int _defaultPriority = _priorityHelper.getDefaultPriority();
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
      int _length_3 = TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER.length();
      ((ConfigurableCompletionProposal)p).setSelectionLength(_length_3);
      ITextViewer _viewer_2 = context.getViewer();
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(_viewer_2, '\t');
    }
    acceptor.accept(p);
  }
  
  private void templateIncludeDeclaration(final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    TargetPlatformGrammarAccess.IncludeDeclarationElements _includeDeclarationAccess = this.grammarAccess.getIncludeDeclarationAccess();
    Keyword _includeKeyword_0 = _includeDeclarationAccess.getIncludeKeyword_0();
    String _value = _includeKeyword_0.getValue();
    final String proposalPrefix = (_value + " \"");
    final String proposalText = ((proposalPrefix + TargetPlatformProposalProvider.INCLUDE_DECLARATION__URI_PLACEHOLDER) + "\"");
    ITextViewer _viewer = context.getViewer();
    StyledText _textWidget = _viewer.getTextWidget();
    String _lineDelimiter = _textWidget.getLineDelimiter();
    String _plus = (proposalText + _lineDelimiter);
    StyledString _styledString = new StyledString(proposalText);
    StyledString _append = _styledString.append(" - include another target platform to this file", StyledString.QUALIFIER_STYLER);
    Image _image = this.getImage(TargetPlatformProposalProvider.INCLUDE_DECLARATION);
    final ICompletionProposal p = this.createCompletionProposal(_plus, _append, _image, context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      IContentProposalPriorities _priorityHelper = this.getPriorityHelper();
      int _defaultPriority = _priorityHelper.getDefaultPriority();
      int _plus_1 = (_defaultPriority + 530);
      ((ConfigurableCompletionProposal)p).setPriority(_plus_1);
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _length = proposalPrefix.length();
      int _plus_2 = (_replacementOffset + _length);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus_2);
      int _length_1 = TargetPlatformProposalProvider.INCLUDE_DECLARATION__URI_PLACEHOLDER.length();
      ((ConfigurableCompletionProposal)p).setSelectionLength(_length_1);
      ITextViewer _viewer_1 = context.getViewer();
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(_viewer_1, '\t');
    }
    acceptor.accept(p);
  }
  
  public void completeOptions_Options(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    int _offset = context.getOffset();
    INode _lastCompleteNode = context.getLastCompleteNode();
    int _endOffset = _lastCompleteNode.getEndOffset();
    final int currentNodeSizeToCursor = (_offset - _endOffset);
    String _xifexpression = null;
    INode _currentNode = context.getCurrentNode();
    String _text = _currentNode.getText();
    int _length = _text.length();
    boolean _greaterEqualsThan = (_length >= currentNodeSizeToCursor);
    if (_greaterEqualsThan) {
      INode _currentNode_1 = context.getCurrentNode();
      String _text_1 = _currentNode_1.getText();
      _xifexpression = _text_1.substring(0, currentNodeSizeToCursor);
    } else {
      _xifexpression = "";
    }
    final String text = _xifexpression;
    boolean _or = false;
    boolean _contains = text.contains("\n");
    boolean _not = (!_contains);
    if (_not) {
      _or = true;
    } else {
      INode _currentNode_2 = context.getCurrentNode();
      String _text_2 = _currentNode_2.getText();
      int _length_1 = _text_2.length();
      boolean _lessThan = (_length_1 < currentNodeSizeToCursor);
      _or = _lessThan;
    }
    if (_or) {
      final Options options = ((Options) model);
      EList<Option> _options = options.getOptions();
      boolean _contains_1 = _options.contains(Option.INCLUDE_REQUIRED);
      boolean _not_1 = (!_contains_1);
      if (_not_1) {
        String _literal = Option.INCLUDE_REQUIRED.getLiteral();
        ICompletionProposal _createCompletionProposal = this.createCompletionProposal(_literal, "all required software will be added to the target platform", options, 440, context);
        acceptor.accept(_createCompletionProposal);
      }
      EList<Option> _options_1 = options.getOptions();
      boolean _contains_2 = _options_1.contains(Option.INCLUDE_SOURCE);
      boolean _not_2 = (!_contains_2);
      if (_not_2) {
        String _literal_1 = Option.INCLUDE_SOURCE.getLiteral();
        ICompletionProposal _createCompletionProposal_1 = this.createCompletionProposal(_literal_1, "sources (if available) of the content will be added to the target platform", options, 430, context);
        acceptor.accept(_createCompletionProposal_1);
      }
      EList<Option> _options_2 = options.getOptions();
      boolean _contains_3 = _options_2.contains(Option.INCLUDE_ALL_ENVIRONMENTS);
      boolean _not_3 = (!_contains_3);
      if (_not_3) {
        String _literal_2 = Option.INCLUDE_ALL_ENVIRONMENTS.getLiteral();
        ICompletionProposal _createCompletionProposal_2 = this.createCompletionProposal(_literal_2, "all available environment specific plug-ins will be added to the target platform", options, 420, context);
        acceptor.accept(_createCompletionProposal_2);
      }
      EList<Option> _options_3 = options.getOptions();
      boolean _contains_4 = _options_3.contains(Option.INCLUDE_CONFIGURE_PHASE);
      boolean _not_4 = (!_contains_4);
      if (_not_4) {
        String _literal_3 = Option.INCLUDE_CONFIGURE_PHASE.getLiteral();
        ICompletionProposal _createCompletionProposal_3 = this.createCompletionProposal(_literal_3, "the configure phase will be run during the download operation of the target platform", options, 410, context);
        acceptor.accept(_createCompletionProposal_3);
      }
    }
  }
  
  private ICompletionProposal createCompletionProposal(final String proposal, final String desc, final EObject imageFor, final int priority, final ContentAssistContext context) {
    StyledString _styledString = new StyledString(proposal);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("- ");
    _builder.append(desc, " ");
    StyledString _append = _styledString.append(_builder.toString(), StyledString.QUALIFIER_STYLER);
    Image _image = this.getImage(imageFor);
    final ICompletionProposal p = this.createCompletionProposal(proposal, _append, _image, context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      IContentProposalPriorities _priorityHelper = this.getPriorityHelper();
      int _defaultPriority = _priorityHelper.getDefaultPriority();
      int _plus = (_defaultPriority + priority);
      ((ConfigurableCompletionProposal)p).setPriority(_plus);
    }
    return p;
  }
  
  public void completeEnvironment_Env(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    int _offset = context.getOffset();
    INode _lastCompleteNode = context.getLastCompleteNode();
    int _endOffset = _lastCompleteNode.getEndOffset();
    final int currentNodeSizeToCursor = (_offset - _endOffset);
    String _xifexpression = null;
    INode _currentNode = context.getCurrentNode();
    String _text = _currentNode.getText();
    int _length = _text.length();
    boolean _greaterEqualsThan = (_length >= currentNodeSizeToCursor);
    if (_greaterEqualsThan) {
      INode _currentNode_1 = context.getCurrentNode();
      String _text_1 = _currentNode_1.getText();
      _xifexpression = _text_1.substring(0, currentNodeSizeToCursor);
    } else {
      _xifexpression = "";
    }
    final String text = _xifexpression;
    boolean _or = false;
    boolean _contains = text.contains("\n");
    boolean _not = (!_contains);
    if (_not) {
      _or = true;
    } else {
      INode _currentNode_2 = context.getCurrentNode();
      String _text_2 = _currentNode_2.getText();
      int _length_1 = _text_2.length();
      boolean _lessThan = (_length_1 < currentNodeSizeToCursor);
      _or = _lessThan;
    }
    if (_or) {
      final Environment env = ((Environment) model);
      String _operatingSystem = env.getOperatingSystem();
      boolean _equals = Objects.equal(_operatingSystem, null);
      if (_equals) {
        String[] _knownOSValues = Platform.knownOSValues();
        final Procedure1<String> _function = new Procedure1<String>() {
          public void apply(final String it) {
            ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(it, "operating system", env, 340, context);
            acceptor.accept(_createCompletionProposal);
          }
        };
        IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(_knownOSValues)), _function);
      }
      String _windowingSystem = env.getWindowingSystem();
      boolean _equals_1 = Objects.equal(_windowingSystem, null);
      if (_equals_1) {
        String[] _knownWSValues = Platform.knownWSValues();
        final Procedure1<String> _function_1 = new Procedure1<String>() {
          public void apply(final String it) {
            ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(it, "windowing system", env, 330, context);
            acceptor.accept(_createCompletionProposal);
          }
        };
        IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(_knownWSValues)), _function_1);
      }
      String _architecture = env.getArchitecture();
      boolean _equals_2 = Objects.equal(_architecture, null);
      if (_equals_2) {
        String[] _knownOSArchValues = Platform.knownOSArchValues();
        final Procedure1<String> _function_2 = new Procedure1<String>() {
          public void apply(final String it) {
            ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(it, "architecture", env, 320, context);
            acceptor.accept(_createCompletionProposal);
          }
        };
        IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(_knownOSArchValues)), _function_2);
      }
      IExecutionEnvironment _executionEnvironment = env.getExecutionEnvironment();
      boolean _equals_3 = Objects.equal(_executionEnvironment, null);
      if (_equals_3) {
        final IExecutionEnvironmentsManager eeManager = JavaRuntime.getExecutionEnvironmentsManager();
        boolean _notEquals = (!Objects.equal(eeManager, null));
        if (_notEquals) {
          IExecutionEnvironment[] _executionEnvironments = eeManager.getExecutionEnvironments();
          final Procedure1<IExecutionEnvironment> _function_3 = new Procedure1<IExecutionEnvironment>() {
            public void apply(final IExecutionEnvironment it) {
              String _id = it.getId();
              String _description = it.getDescription();
              ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(_id, _description, env, 310, context);
              acceptor.accept(_createCompletionProposal);
            }
          };
          IterableExtensions.<IExecutionEnvironment>forEach(((Iterable<IExecutionEnvironment>)Conversions.doWrapArray(_executionEnvironments)), _function_3);
        }
      }
      Locale _localization = env.getLocalization();
      boolean _equals_4 = Objects.equal(_localization, null);
      if (_equals_4) {
        Locale[] _availableLocales = Locale.getAvailableLocales();
        final Procedure1<Locale> _function_4 = new Procedure1<Locale>() {
          public void apply(final Locale it) {
            String _string = it.toString();
            String _displayName = it.getDisplayName();
            ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(_string, _displayName, env, 300, context);
            acceptor.accept(_createCompletionProposal);
          }
        };
        IterableExtensions.<Locale>forEach(((Iterable<Locale>)Conversions.doWrapArray(_availableLocales)), _function_4);
      }
    }
  }
  
  public void completeIU_ID(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    try {
      int _offset = context.getOffset();
      INode _lastCompleteNode = context.getLastCompleteNode();
      int _endOffset = _lastCompleteNode.getEndOffset();
      final int currentNodeSizeToCursor = (_offset - _endOffset);
      String _xifexpression = null;
      INode _currentNode = context.getCurrentNode();
      String _text = _currentNode.getText();
      int _length = _text.length();
      boolean _greaterEqualsThan = (_length >= currentNodeSizeToCursor);
      if (_greaterEqualsThan) {
        INode _currentNode_1 = context.getCurrentNode();
        String _text_1 = _currentNode_1.getText();
        _xifexpression = _text_1.substring(0, currentNodeSizeToCursor);
      } else {
        _xifexpression = "";
      }
      final String text = _xifexpression;
      boolean _or = false;
      boolean _contains = text.contains("\n");
      if (_contains) {
        _or = true;
      } else {
        INode _currentNode_2 = context.getCurrentNode();
        String _text_2 = _currentNode_2.getText();
        int _length_1 = _text_2.length();
        boolean _lessThan = (_length_1 < currentNodeSizeToCursor);
        _or = _lessThan;
      }
      if (_or) {
        final Location location = ((Location) model);
        final String uri = location.getUri();
        TargetPlatformActivator _instance = TargetPlatformActivator.getInstance();
        IWorkbench _workbench = _instance.getWorkbench();
        final IWorkbenchWindow window = _workbench.getActiveWorkbenchWindow();
        final IRunnableWithProgress _function = new IRunnableWithProgress() {
          public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            Shell _shell = window.getShell();
            Display _display = _shell.getDisplay();
            ReadAndDispatchProgressMonitorWrapper _readAndDispatchProgressMonitorWrapper = new ReadAndDispatchProgressMonitorWrapper(monitor, _display);
            final SubMonitor wpm = SubMonitor.convert(_readAndDispatchProgressMonitorWrapper, ("Creating content assist for " + uri), 100);
            try {
              Object _service = TargetPlatformProposalProvider.this.provisioningAgent.getService(IMetadataRepositoryManager.SERVICE_NAME);
              final IMetadataRepositoryManager repositoryManager = ((IMetadataRepositoryManager) _service);
              URI _uRI = new URI(uri);
              SubMonitor _newChild = wpm.newChild(90);
              final IMetadataRepository metadataRepository = repositoryManager.loadRepository(_uRI, _newChild);
              IQuery<IInstallableUnit> _iUAssistQuery = TargetPlatformProposalProvider.this.getIUAssistQuery();
              SubMonitor _newChild_1 = wpm.newChild(5);
              IQueryResult<IInstallableUnit> _query = metadataRepository.query(_iUAssistQuery, _newChild_1);
              final Set<IInstallableUnit> results = _query.toUnmodifiableSet();
              final Function1<IInstallableUnit, Boolean> _function = new Function1<IInstallableUnit, Boolean>() {
                public Boolean apply(final IInstallableUnit it) {
                  EList<IU> _ius = location.getIus();
                  final Function1<IU, String> _function = new Function1<IU, String>() {
                    public String apply(final IU it) {
                      return it.getID();
                    }
                  };
                  List<String> _map = ListExtensions.<IU, String>map(_ius, _function);
                  String _id = it.getId();
                  boolean _contains = _map.contains(_id);
                  return Boolean.valueOf((!_contains));
                }
              };
              Iterable<IInstallableUnit> _filter = IterableExtensions.<IInstallableUnit>filter(results, _function);
              final Procedure1<IInstallableUnit> _function_1 = new Procedure1<IInstallableUnit>() {
                public void apply(final IInstallableUnit it) {
                  String _id = it.getId();
                  IQuery<IInstallableUnit> _createIUQuery = QueryUtil.createIUQuery(_id);
                  SubMonitor _newChild = wpm.newChild(5);
                  final IQueryResult<IInstallableUnit> allVersions = metadataRepository.query(_createIUQuery, _newChild);
                  String _id_1 = it.getId();
                  Iterator<IInstallableUnit> _iterator = allVersions.iterator();
                  final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
                    public String apply(final IInstallableUnit it) {
                      Version _version = it.getVersion();
                      return _version.toString();
                    }
                  };
                  Iterator<String> _map = IteratorExtensions.<IInstallableUnit, String>map(_iterator, _function);
                  String _join = IteratorExtensions.join(_map, ", ");
                  ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(_id_1, _join, TargetPlatformProposalProvider.IU, 0, context);
                  acceptor.accept(_createCompletionProposal);
                }
              };
              IterableExtensions.<IInstallableUnit>forEach(_filter, _function_1);
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
  
  public void completeIU_Version(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    try {
      ITextViewer _viewer = context.getViewer();
      IDocument _document = _viewer.getDocument();
      final String docText = _document.get();
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
      boolean _and = false;
      boolean _equals = charBefore.equals(" ");
      boolean _not = (!_equals);
      if (!_not) {
        _and = false;
      } else {
        boolean _equals_1 = charBefore.equals("\n");
        boolean _not_1 = (!_equals_1);
        _and = _not_1;
      }
      if (_and) {
        _xifexpression_1 = " ";
      } else {
        _xifexpression_1 = "";
      }
      final String prefix = _xifexpression_1;
      int _offset = context.getOffset();
      INode _lastCompleteNode = context.getLastCompleteNode();
      int _endOffset = _lastCompleteNode.getEndOffset();
      final int currentNodeSizeToCursor = (_offset - _endOffset);
      String _xifexpression_2 = null;
      INode _currentNode = context.getCurrentNode();
      String _text = _currentNode.getText();
      int _length_1 = _text.length();
      boolean _greaterEqualsThan_1 = (_length_1 >= currentNodeSizeToCursor);
      if (_greaterEqualsThan_1) {
        INode _currentNode_1 = context.getCurrentNode();
        String _text_1 = _currentNode_1.getText();
        _xifexpression_2 = _text_1.substring(0, currentNodeSizeToCursor);
      } else {
        _xifexpression_2 = "";
      }
      final String text = _xifexpression_2;
      boolean _or = false;
      boolean _contains = text.contains("\n");
      boolean _not_2 = (!_contains);
      if (_not_2) {
        _or = true;
      } else {
        INode _currentNode_2 = context.getCurrentNode();
        String _text_2 = _currentNode_2.getText();
        int _length_2 = _text_2.length();
        boolean _lessThan = (_length_2 < currentNodeSizeToCursor);
        _or = _lessThan;
      }
      if (_or) {
        final IU iu = ((IU) model);
        Location _location = iu.getLocation();
        final String uri = _location.getUri();
        TargetPlatformActivator _instance = TargetPlatformActivator.getInstance();
        IWorkbench _workbench = _instance.getWorkbench();
        final IWorkbenchWindow window = _workbench.getActiveWorkbenchWindow();
        Shell _shell = window.getShell();
        Display _display = _shell.getDisplay();
        final IRunnableWithProgress op = this.versionProposalRunnable(uri, iu, prefix, _display, context, acceptor);
        window.run(false, true, op);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void completeLocation_ID(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    ITextViewer _viewer = context.getViewer();
    IDocument _document = _viewer.getDocument();
    final String docText = _document.get();
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
    boolean _and = false;
    boolean _equals = charBefore.equals(" ");
    boolean _not = (!_equals);
    if (!_not) {
      _and = false;
    } else {
      boolean _equals_1 = charBefore.equals("\n");
      boolean _not_1 = (!_equals_1);
      _and = _not_1;
    }
    if (_and) {
      _xifexpression_2 = " ";
    } else {
      _xifexpression_2 = "";
    }
    final String prefix = _xifexpression_2;
    String _xifexpression_3 = null;
    boolean _equals_2 = charAfter.equals(" ");
    boolean _not_2 = (!_equals_2);
    if (_not_2) {
      _xifexpression_3 = " ";
    } else {
      _xifexpression_3 = "";
    }
    final String suffix = _xifexpression_3;
    final String proposal = ((prefix + TargetPlatformProposalProvider.LOCATION__ID_PLACEHOLDER) + suffix);
    StyledString _styledString = new StyledString(TargetPlatformProposalProvider.LOCATION__ID_PLACEHOLDER);
    StyledString _append = _styledString.append(" - ID of this location ", StyledString.QUALIFIER_STYLER);
    Image _image = this.getImage(TargetPlatformProposalProvider.LOCATION);
    final ICompletionProposal p = this.createCompletionProposal(proposal, _append, _image, context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _length_2 = prefix.length();
      int _plus = (_replacementOffset + _length_2);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus);
      int _length_3 = TargetPlatformProposalProvider.LOCATION__ID_PLACEHOLDER.length();
      ((ConfigurableCompletionProposal)p).setSelectionLength(_length_3);
      ITextViewer _viewer_1 = context.getViewer();
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(_viewer_1, '\t');
    }
    acceptor.accept(p);
  }
  
  public void completeLocation_Uri(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    ITextViewer _viewer = context.getViewer();
    IDocument _document = _viewer.getDocument();
    final String docText = _document.get();
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
    boolean _and = false;
    boolean _equals = charBefore.equals(" ");
    boolean _not = (!_equals);
    if (!_not) {
      _and = false;
    } else {
      boolean _equals_1 = charBefore.equals("\n");
      boolean _not_1 = (!_equals_1);
      _and = _not_1;
    }
    if (_and) {
      _xifexpression_2 = " \"";
    } else {
      _xifexpression_2 = "\"";
    }
    final String prefix = _xifexpression_2;
    String _xifexpression_3 = null;
    boolean _equals_2 = charAfter.equals(" ");
    boolean _not_2 = (!_equals_2);
    if (_not_2) {
      _xifexpression_3 = "\" ";
    } else {
      _xifexpression_3 = "\"";
    }
    final String suffix = _xifexpression_3;
    final String proposal = ((prefix + TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER) + suffix);
    StyledString _styledString = new StyledString(TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER);
    StyledString _append = _styledString.append(" - URI of the location", StyledString.QUALIFIER_STYLER);
    Image _image = this.getImage(TargetPlatformProposalProvider.LOCATION);
    final ICompletionProposal p = this.createCompletionProposal(proposal, _append, _image, context);
    if ((p instanceof ConfigurableCompletionProposal)) {
      int _replacementOffset = ((ConfigurableCompletionProposal)p).getReplacementOffset();
      int _length_2 = prefix.length();
      int _plus = (_replacementOffset + _length_2);
      ((ConfigurableCompletionProposal)p).setSelectionStart(_plus);
      int _length_3 = TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER.length();
      ((ConfigurableCompletionProposal)p).setSelectionLength(_length_3);
      ITextViewer _viewer_1 = context.getViewer();
      ((ConfigurableCompletionProposal)p).setSimpleLinkedMode(_viewer_1, '\t');
    }
    acceptor.accept(p);
  }
  
  public void completeKeyword(final Keyword keyword, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
  }
  
  public void complete_STRING(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
  }
  
  private IRunnableWithProgress versionProposalRunnable(final String uri, final IU iu, final String prefix, final Display display, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final IRunnableWithProgress _function = new IRunnableWithProgress() {
      public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        try {
          ReadAndDispatchProgressMonitorWrapper _readAndDispatchProgressMonitorWrapper = new ReadAndDispatchProgressMonitorWrapper(monitor, display);
          final SubMonitor wpm = SubMonitor.convert(_readAndDispatchProgressMonitorWrapper, ("Creating content assist for " + uri), 100);
          try {
            Object _service = TargetPlatformProposalProvider.this.provisioningAgent.getService(IMetadataRepositoryManager.SERVICE_NAME);
            final IMetadataRepositoryManager repositoryManager = ((IMetadataRepositoryManager) _service);
            URI _uRI = new URI(uri);
            SubMonitor _newChild = wpm.newChild(95);
            final IMetadataRepository metadataRepository = repositoryManager.loadRepository(_uRI, _newChild);
            String _iD = iu.getID();
            IQuery<IInstallableUnit> _createIUQuery = QueryUtil.createIUQuery(_iD);
            SubMonitor _newChild_1 = wpm.newChild(5);
            IQueryResult<IInstallableUnit> _query = metadataRepository.query(_createIUQuery, _newChild_1);
            final Set<IInstallableUnit> results = _query.toUnmodifiableSet();
            final Procedure1<IInstallableUnit> _function = new Procedure1<IInstallableUnit>() {
              public void apply(final IInstallableUnit it) {
                Version _version = it.getVersion();
                Comparable<?> _segment = _version.getSegment(0);
                final Integer major = ((Integer) _segment);
                Version _version_1 = it.getVersion();
                Comparable<?> _segment_1 = _version_1.getSegment(1);
                final Integer minor = ((Integer) _segment_1);
                Version _version_2 = it.getVersion();
                Comparable<?> _segment_2 = _version_2.getSegment(2);
                final Integer micro = ((Integer) _segment_2);
                StringConcatenation _builder = new StringConcatenation();
                _builder.append(prefix, "");
                _builder.append("[");
                _builder.append(major, "");
                _builder.append(".");
                _builder.append(minor, "");
                _builder.append(".");
                _builder.append(micro, "");
                _builder.append(",");
                _builder.append(((major).intValue() + 1), "");
                _builder.append(".0.0)");
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("[");
                _builder_1.append(major, "");
                _builder_1.append(".");
                _builder_1.append(minor, "");
                _builder_1.append(".");
                _builder_1.append(micro, "");
                _builder_1.append(",");
                _builder_1.append(((major).intValue() + 1), "");
                _builder_1.append(".0.0)");
                Image _image = TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU);
                ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(_builder.toString(), _builder_1.toString(), _image, context);
                acceptor.accept(_createCompletionProposal);
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append(prefix, "");
                _builder_2.append("[");
                _builder_2.append(major, "");
                _builder_2.append(".");
                _builder_2.append(minor, "");
                _builder_2.append(".");
                _builder_2.append(micro, "");
                _builder_2.append(",");
                _builder_2.append(major, "");
                _builder_2.append(".");
                _builder_2.append(((minor).intValue() + 1), "");
                _builder_2.append(".0)");
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("[");
                _builder_3.append(major, "");
                _builder_3.append(".");
                _builder_3.append(minor, "");
                _builder_3.append(".");
                _builder_3.append(micro, "");
                _builder_3.append(",");
                _builder_3.append(major, "");
                _builder_3.append(".");
                _builder_3.append(((minor).intValue() + 1), "");
                _builder_3.append(".0)");
                Image _image_1 = TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU);
                ICompletionProposal _createCompletionProposal_1 = TargetPlatformProposalProvider.this.createCompletionProposal(_builder_2.toString(), _builder_3.toString(), _image_1, context);
                acceptor.accept(_createCompletionProposal_1);
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append(prefix, "");
                _builder_4.append("[");
                _builder_4.append(major, "");
                _builder_4.append(".");
                _builder_4.append(minor, "");
                _builder_4.append(".");
                _builder_4.append(micro, "");
                _builder_4.append(",");
                _builder_4.append(major, "");
                _builder_4.append(".");
                _builder_4.append(minor, "");
                _builder_4.append(".");
                _builder_4.append(((micro).intValue() + 1), "");
                _builder_4.append(")");
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("[");
                _builder_5.append(major, "");
                _builder_5.append(".");
                _builder_5.append(minor, "");
                _builder_5.append(".");
                _builder_5.append(micro, "");
                _builder_5.append(",");
                _builder_5.append(major, "");
                _builder_5.append(".");
                _builder_5.append(minor, "");
                _builder_5.append(".");
                _builder_5.append(((micro).intValue() + 1), "");
                _builder_5.append(")");
                Image _image_2 = TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU);
                ICompletionProposal _createCompletionProposal_2 = TargetPlatformProposalProvider.this.createCompletionProposal(_builder_4.toString(), _builder_5.toString(), _image_2, context);
                acceptor.accept(_createCompletionProposal_2);
                StringConcatenation _builder_6 = new StringConcatenation();
                _builder_6.append(prefix, "");
                _builder_6.append("[");
                Version _version_3 = it.getVersion();
                _builder_6.append(_version_3, "");
                _builder_6.append(",");
                Version _version_4 = it.getVersion();
                _builder_6.append(_version_4, "");
                _builder_6.append("]");
                StringConcatenation _builder_7 = new StringConcatenation();
                _builder_7.append("[");
                Version _version_5 = it.getVersion();
                _builder_7.append(_version_5, "");
                _builder_7.append(",");
                Version _version_6 = it.getVersion();
                _builder_7.append(_version_6, "");
                _builder_7.append("]");
                Image _image_3 = TargetPlatformProposalProvider.this.getImage(TargetPlatformProposalProvider.IU);
                ICompletionProposal _createCompletionProposal_3 = TargetPlatformProposalProvider.this.createCompletionProposal(_builder_6.toString(), _builder_7.toString(), _image_3, context);
                acceptor.accept(_createCompletionProposal_3);
              }
            };
            IterableExtensions.<IInstallableUnit>forEach(results, _function);
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
