package fr.obeo.releng.targetplatform.ui.contentassist;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.Environment;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.Options;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformFactory;
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess;
import fr.obeo.releng.targetplatform.ui.contentassist.AbstractTargetPlatformProposalProvider;
import java.util.Locale;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class TargetPlatformProposalProvider extends AbstractTargetPlatformProposalProvider {
  private final static TargetPlatform TARGET_PLATFORM = TargetPlatformFactory.eINSTANCE.createTargetPlatform();
  
  @Inject
  private TargetPlatformGrammarAccess grammarAccess;
  
  private final static String TARGET_PLATFORM__NAME_PLACEHOLDER = "Target Platform Name";
  
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
        ((ConfigurableCompletionProposal)p).setAutoInsertable(true);
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
      ((ConfigurableCompletionProposal)p).setAutoInsertable(true);
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
    final TargetPlatform tp = ((TargetPlatform) model);
    IncludeDeclaration _createIncludeDeclaration = TargetPlatformFactory.eINSTANCE.createIncludeDeclaration();
    ICompletionProposal _createCompletionProposal = this.createCompletionProposal("include", "extend another target platform", _createIncludeDeclaration, 540, context);
    acceptor.accept(_createCompletionProposal);
    EList<Option> _options = tp.getOptions();
    boolean _isEmpty = _options.isEmpty();
    if (_isEmpty) {
      Options _createOptions = TargetPlatformFactory.eINSTANCE.createOptions();
      ICompletionProposal _createCompletionProposal_1 = this.createCompletionProposal("with", "describe how the set of elements to add to this target is determined", _createOptions, 530, context);
      acceptor.accept(_createCompletionProposal_1);
    }
    Environment _environment = tp.getEnvironment();
    boolean _equals = Objects.equal(_environment, null);
    if (_equals) {
      Environment _createEnvironment = TargetPlatformFactory.eINSTANCE.createEnvironment();
      ICompletionProposal _createCompletionProposal_2 = this.createCompletionProposal("environment", "describe the system that this target is built for", _createEnvironment, 520, context);
      acceptor.accept(_createCompletionProposal_2);
    }
    Location _createLocation = TargetPlatformFactory.eINSTANCE.createLocation();
    ICompletionProposal _createCompletionProposal_3 = this.createCompletionProposal("location", "add a p2 repository location", _createLocation, 510, context);
    acceptor.accept(_createCompletionProposal_3);
  }
  
  public void completeOptions_Options(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Options options = ((Options) model);
    EList<Option> _options = options.getOptions();
    boolean _contains = _options.contains(Option.INCLUDE_REQUIRED);
    boolean _not = (!_contains);
    if (_not) {
      String _literal = Option.INCLUDE_REQUIRED.getLiteral();
      ICompletionProposal _createCompletionProposal = this.createCompletionProposal(_literal, "all required software will be added to the target platform", options, 440, context);
      acceptor.accept(_createCompletionProposal);
    }
    EList<Option> _options_1 = options.getOptions();
    boolean _contains_1 = _options_1.contains(Option.INCLUDE_SOURCE);
    boolean _not_1 = (!_contains_1);
    if (_not_1) {
      String _literal_1 = Option.INCLUDE_SOURCE.getLiteral();
      ICompletionProposal _createCompletionProposal_1 = this.createCompletionProposal(_literal_1, "sources (if available) of the content will be added to the target platform", options, 430, context);
      acceptor.accept(_createCompletionProposal_1);
    }
    EList<Option> _options_2 = options.getOptions();
    boolean _contains_2 = _options_2.contains(Option.INCLUDE_ALL_ENVIRONMENTS);
    boolean _not_2 = (!_contains_2);
    if (_not_2) {
      String _literal_2 = Option.INCLUDE_ALL_ENVIRONMENTS.getLiteral();
      ICompletionProposal _createCompletionProposal_2 = this.createCompletionProposal(_literal_2, "all available environment specific plug-ins will be added to the target platform", options, 420, context);
      acceptor.accept(_createCompletionProposal_2);
    }
    EList<Option> _options_3 = options.getOptions();
    boolean _contains_3 = _options_3.contains(Option.INCLUDE_CONFIGURE_PHASE);
    boolean _not_3 = (!_contains_3);
    if (_not_3) {
      String _literal_3 = Option.INCLUDE_CONFIGURE_PHASE.getLiteral();
      ICompletionProposal _createCompletionProposal_3 = this.createCompletionProposal(_literal_3, "the configure phase will be run during the download operation of the target platform", options, 410, context);
      acceptor.accept(_createCompletionProposal_3);
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
    Locale _localization = env.getLocalization();
    boolean _equals_3 = Objects.equal(_localization, null);
    if (_equals_3) {
      Locale[] _availableLocales = Locale.getAvailableLocales();
      final Procedure1<Locale> _function_3 = new Procedure1<Locale>() {
        public void apply(final Locale it) {
          String _string = it.toString();
          String _displayName = it.getDisplayName();
          ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(_string, _displayName, env, 310, context);
          acceptor.accept(_createCompletionProposal);
        }
      };
      IterableExtensions.<Locale>forEach(((Iterable<Locale>)Conversions.doWrapArray(_availableLocales)), _function_3);
    }
    IExecutionEnvironment _executionEnvironment = env.getExecutionEnvironment();
    boolean _equals_4 = Objects.equal(_executionEnvironment, null);
    if (_equals_4) {
      final IExecutionEnvironmentsManager eeManager = JavaRuntime.getExecutionEnvironmentsManager();
      boolean _notEquals = (!Objects.equal(eeManager, null));
      if (_notEquals) {
        IExecutionEnvironment[] _executionEnvironments = eeManager.getExecutionEnvironments();
        final Procedure1<IExecutionEnvironment> _function_4 = new Procedure1<IExecutionEnvironment>() {
          public void apply(final IExecutionEnvironment it) {
            String _id = it.getId();
            String _description = it.getDescription();
            ICompletionProposal _createCompletionProposal = TargetPlatformProposalProvider.this.createCompletionProposal(_id, _description, env, 300, context);
            acceptor.accept(_createCompletionProposal);
          }
        };
        IterableExtensions.<IExecutionEnvironment>forEach(((Iterable<IExecutionEnvironment>)Conversions.doWrapArray(_executionEnvironments)), _function_4);
      }
    }
  }
  
  public void complete_IncludeDeclaration(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    ICompletionProposal _createCompletionProposal = this.createCompletionProposal("DUMMY", context);
    acceptor.accept(_createCompletionProposal);
  }
  
  public void completeKeyword(final Keyword keyword, final ContentAssistContext contentAssistContext, final ICompletionProposalAcceptor acceptor) {
  }
}
