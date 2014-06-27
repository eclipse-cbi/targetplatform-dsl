package fr.obeo.releng.targetplatform.serializer;

import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class TargetPlatformSyntacticSequencer extends AbstractSyntacticSequencer {

	protected TargetPlatformGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Environment_CommaKeyword_3_0_q;
	protected AbstractElementAlias match_IU___SemicolonKeyword_1_0_0_VersionKeyword_1_0_1_EqualsSignKeyword_1_0_2__q;
	protected AbstractElementAlias match_Location_CommaKeyword_2_1_2_0_q;
	protected AbstractElementAlias match_Location___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_3__q;
	protected AbstractElementAlias match_Options_CommaKeyword_2_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (TargetPlatformGrammarAccess) access;
		match_Environment_CommaKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0());
		match_IU___SemicolonKeyword_1_0_0_VersionKeyword_1_0_1_EqualsSignKeyword_1_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getIUAccess().getVersionKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2()));
		match_Location_CommaKeyword_2_1_2_0_q = new TokenAlias(false, true, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
		match_Location___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3()));
		match_Options_CommaKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getOptionsAccess().getCommaKeyword_2_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Environment_CommaKeyword_3_0_q.equals(syntax))
				emit_Environment_CommaKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IU___SemicolonKeyword_1_0_0_VersionKeyword_1_0_1_EqualsSignKeyword_1_0_2__q.equals(syntax))
				emit_IU___SemicolonKeyword_1_0_0_VersionKeyword_1_0_1_EqualsSignKeyword_1_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Location_CommaKeyword_2_1_2_0_q.equals(syntax))
				emit_Location_CommaKeyword_2_1_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Location___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_3__q.equals(syntax))
				emit_Location___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Options_CommaKeyword_2_0_q.equals(syntax))
				emit_Options_CommaKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_Environment_CommaKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (';' 'version' '=')?
	 */
	protected void emit_IU___SemicolonKeyword_1_0_0_VersionKeyword_1_0_1_EqualsSignKeyword_1_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_Location_CommaKeyword_2_1_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_Location___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_Options_CommaKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
