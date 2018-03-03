/*
* generated by Xtext
*/
package fr.obeo.releng.targetplatform.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class TargetPlatformGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class TargetPlatformElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TargetPlatform");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTargetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameSTRINGTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cContentsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cContentsTargetContentParserRuleCall_2_0 = (RuleCall)cContentsAssignment_2.eContents().get(0);
		
		//TargetPlatform:
		//	("target" name=STRING contents+=TargetContent*)?;
		public ParserRule getRule() { return rule; }

		//("target" name=STRING contents+=TargetContent*)?
		public Group getGroup() { return cGroup; }

		//"target"
		public Keyword getTargetKeyword_0() { return cTargetKeyword_0; }

		//name=STRING
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_1_0() { return cNameSTRINGTerminalRuleCall_1_0; }

		//contents+=TargetContent*
		public Assignment getContentsAssignment_2() { return cContentsAssignment_2; }

		//TargetContent
		public RuleCall getContentsTargetContentParserRuleCall_2_0() { return cContentsTargetContentParserRuleCall_2_0; }
	}

	public class TargetContentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TargetContent");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cOptionsParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEnvironmentParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cIncludeDeclarationParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLocationParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cVarDefinitionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//TargetContent:
		//	Options | Environment | IncludeDeclaration | Location | VarDefinition;
		public ParserRule getRule() { return rule; }

		//Options | Environment | IncludeDeclaration | Location | VarDefinition
		public Alternatives getAlternatives() { return cAlternatives; }

		//Options
		public RuleCall getOptionsParserRuleCall_0() { return cOptionsParserRuleCall_0; }

		//Environment
		public RuleCall getEnvironmentParserRuleCall_1() { return cEnvironmentParserRuleCall_1; }

		//IncludeDeclaration
		public RuleCall getIncludeDeclarationParserRuleCall_2() { return cIncludeDeclarationParserRuleCall_2; }

		//Location
		public RuleCall getLocationParserRuleCall_3() { return cLocationParserRuleCall_3; }

		//VarDefinition
		public RuleCall getVarDefinitionParserRuleCall_4() { return cVarDefinitionParserRuleCall_4; }
	}

	public class OptionsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Options");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cWithKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOptionsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOptionsOptionEnumRuleCall_1_0 = (RuleCall)cOptionsAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOptionsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOptionsOptionEnumRuleCall_2_1_0 = (RuleCall)cOptionsAssignment_2_1.eContents().get(0);
		
		//Options:
		//	"with" options+=Option (","? options+=Option)*;
		public ParserRule getRule() { return rule; }

		//"with" options+=Option (","? options+=Option)*
		public Group getGroup() { return cGroup; }

		//"with"
		public Keyword getWithKeyword_0() { return cWithKeyword_0; }

		//options+=Option
		public Assignment getOptionsAssignment_1() { return cOptionsAssignment_1; }

		//Option
		public RuleCall getOptionsOptionEnumRuleCall_1_0() { return cOptionsOptionEnumRuleCall_1_0; }

		//(","? options+=Option)*
		public Group getGroup_2() { return cGroup_2; }

		//","?
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//options+=Option
		public Assignment getOptionsAssignment_2_1() { return cOptionsAssignment_2_1; }

		//Option
		public RuleCall getOptionsOptionEnumRuleCall_2_1_0() { return cOptionsOptionEnumRuleCall_2_1_0; }
	}

	public class EnvironmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Environment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEnvironmentAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cEnvironmentKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cEnvAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cEnvIDTerminalRuleCall_2_0 = (RuleCall)cEnvAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCommaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cEnvAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cEnvIDTerminalRuleCall_3_1_0 = (RuleCall)cEnvAssignment_3_1.eContents().get(0);
		
		//Environment:
		//	{Environment} "environment" env+=ID (","? env+=ID)*;
		public ParserRule getRule() { return rule; }

		//{Environment} "environment" env+=ID (","? env+=ID)*
		public Group getGroup() { return cGroup; }

		//{Environment}
		public Action getEnvironmentAction_0() { return cEnvironmentAction_0; }

		//"environment"
		public Keyword getEnvironmentKeyword_1() { return cEnvironmentKeyword_1; }

		//env+=ID
		public Assignment getEnvAssignment_2() { return cEnvAssignment_2; }

		//ID
		public RuleCall getEnvIDTerminalRuleCall_2_0() { return cEnvIDTerminalRuleCall_2_0; }

		//(","? env+=ID)*
		public Group getGroup_3() { return cGroup_3; }

		//","?
		public Keyword getCommaKeyword_3_0() { return cCommaKeyword_3_0; }

		//env+=ID
		public Assignment getEnvAssignment_3_1() { return cEnvAssignment_3_1; }

		//ID
		public RuleCall getEnvIDTerminalRuleCall_3_1_0() { return cEnvIDTerminalRuleCall_3_1_0; }
	}

	public class VarDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VarDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDefineKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueSTRINGTerminalRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//VarDefinition:
		//	"define" name=ID "=" value=STRING;
		public ParserRule getRule() { return rule; }

		//"define" name=ID "=" value=STRING
		public Group getGroup() { return cGroup; }

		//"define"
		public Keyword getDefineKeyword_0() { return cDefineKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"="
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }

		//value=STRING
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_3_0() { return cValueSTRINGTerminalRuleCall_3_0; }
	}

	public class CompositeStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CompositeString");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cCompositeStringAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cStringPartsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cStringPartsCompositeStringPartParserRuleCall_1_0 = (RuleCall)cStringPartsAssignment_1.eContents().get(0);
		
		//CompositeString:
		//	{CompositeString} stringParts+=CompositeStringPart*;
		public ParserRule getRule() { return rule; }

		//{CompositeString} stringParts+=CompositeStringPart*
		public Group getGroup() { return cGroup; }

		//{CompositeString}
		public Action getCompositeStringAction_0() { return cCompositeStringAction_0; }

		//stringParts+=CompositeStringPart*
		public Assignment getStringPartsAssignment_1() { return cStringPartsAssignment_1; }

		//CompositeStringPart
		public RuleCall getStringPartsCompositeStringPartParserRuleCall_1_0() { return cStringPartsCompositeStringPartParserRuleCall_1_0; }
	}

	public class CompositeStringPartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CompositeStringPart");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cVarCallParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cStaticStringParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//CompositeStringPart:
		//	VarCall | StaticString;
		public ParserRule getRule() { return rule; }

		//VarCall | StaticString
		public Alternatives getAlternatives() { return cAlternatives; }

		//VarCall
		public RuleCall getVarCallParserRuleCall_0() { return cVarCallParserRuleCall_0; }

		//StaticString
		public RuleCall getStaticStringParserRuleCall_1() { return cStaticStringParserRuleCall_1; }
	}

	public class VarCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VarCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDollarSignLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cVarNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cVarNameVarDefinitionCrossReference_1_0 = (CrossReference)cVarNameAssignment_1.eContents().get(0);
		private final RuleCall cVarNameVarDefinitionIDTerminalRuleCall_1_0_1 = (RuleCall)cVarNameVarDefinitionCrossReference_1_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//VarCall:
		//	"${" varName=[VarDefinition] "}";
		public ParserRule getRule() { return rule; }

		//"${" varName=[VarDefinition] "}"
		public Group getGroup() { return cGroup; }

		//"${"
		public Keyword getDollarSignLeftCurlyBracketKeyword_0() { return cDollarSignLeftCurlyBracketKeyword_0; }

		//varName=[VarDefinition]
		public Assignment getVarNameAssignment_1() { return cVarNameAssignment_1; }

		//[VarDefinition]
		public CrossReference getVarNameVarDefinitionCrossReference_1_0() { return cVarNameVarDefinitionCrossReference_1_0; }

		//ID
		public RuleCall getVarNameVarDefinitionIDTerminalRuleCall_1_0_1() { return cVarNameVarDefinitionIDTerminalRuleCall_1_0_1; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2() { return cRightCurlyBracketKeyword_2; }
	}

	public class StaticStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StaticString");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//StaticString:
		//	value=STRING;
		public ParserRule getRule() { return rule; }

		//value=STRING
		public Assignment getValueAssignment() { return cValueAssignment; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_0() { return cValueSTRINGTerminalRuleCall_0; }
	}

	public class IncludeDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IncludeDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIncludeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cCompositeImportURIAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCompositeImportURICompositeStringParserRuleCall_1_0 = (RuleCall)cCompositeImportURIAssignment_1.eContents().get(0);
		
		//IncludeDeclaration:
		//	"include" compositeImportURI=CompositeString;
		public ParserRule getRule() { return rule; }

		//"include" compositeImportURI=CompositeString
		public Group getGroup() { return cGroup; }

		//"include"
		public Keyword getIncludeKeyword_0() { return cIncludeKeyword_0; }

		//compositeImportURI=CompositeString
		public Assignment getCompositeImportURIAssignment_1() { return cCompositeImportURIAssignment_1; }

		//CompositeString
		public RuleCall getCompositeImportURICompositeStringParserRuleCall_1_0() { return cCompositeImportURICompositeStringParserRuleCall_1_0; }
	}

	public class LocationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Location");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLocationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final UnorderedGroup cUnorderedGroup_1 = (UnorderedGroup)cGroup.eContents().get(1);
		private final Assignment cIDAssignment_1_0 = (Assignment)cUnorderedGroup_1.eContents().get(0);
		private final RuleCall cIDIDTerminalRuleCall_1_0_0 = (RuleCall)cIDAssignment_1_0.eContents().get(0);
		private final Assignment cUriAssignment_1_1 = (Assignment)cUnorderedGroup_1.eContents().get(1);
		private final RuleCall cUriSTRINGTerminalRuleCall_1_1_0 = (RuleCall)cUriAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cWithKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOptionsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOptionsOptionEnumRuleCall_2_1_1_0 = (RuleCall)cOptionsAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_2_1_2 = (Group)cGroup_2_1.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_2_0 = (Keyword)cGroup_2_1_2.eContents().get(0);
		private final Assignment cOptionsAssignment_2_1_2_1 = (Assignment)cGroup_2_1_2.eContents().get(1);
		private final RuleCall cOptionsOptionEnumRuleCall_2_1_2_1_0 = (RuleCall)cOptionsAssignment_2_1_2_1.eContents().get(0);
		private final Assignment cIusAssignment_2_2 = (Assignment)cGroup_2.eContents().get(2);
		private final RuleCall cIusIUParserRuleCall_2_2_0 = (RuleCall)cIusAssignment_2_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		
		//Location:
		//	"location" (ID=ID? & uri=STRING) ("{" ("with" options+=Option (","? options+=Option)*)? ius+=IU* "}")?;
		public ParserRule getRule() { return rule; }

		//"location" (ID=ID? & uri=STRING) ("{" ("with" options+=Option (","? options+=Option)*)? ius+=IU* "}")?
		public Group getGroup() { return cGroup; }

		//"location"
		public Keyword getLocationKeyword_0() { return cLocationKeyword_0; }

		//ID=ID? & uri=STRING
		public UnorderedGroup getUnorderedGroup_1() { return cUnorderedGroup_1; }

		//ID=ID?
		public Assignment getIDAssignment_1_0() { return cIDAssignment_1_0; }

		//ID
		public RuleCall getIDIDTerminalRuleCall_1_0_0() { return cIDIDTerminalRuleCall_1_0_0; }

		//uri=STRING
		public Assignment getUriAssignment_1_1() { return cUriAssignment_1_1; }

		//STRING
		public RuleCall getUriSTRINGTerminalRuleCall_1_1_0() { return cUriSTRINGTerminalRuleCall_1_1_0; }

		//("{" ("with" options+=Option (","? options+=Option)*)? ius+=IU* "}")?
		public Group getGroup_2() { return cGroup_2; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//("with" options+=Option (","? options+=Option)*)?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//"with"
		public Keyword getWithKeyword_2_1_0() { return cWithKeyword_2_1_0; }

		//options+=Option
		public Assignment getOptionsAssignment_2_1_1() { return cOptionsAssignment_2_1_1; }

		//Option
		public RuleCall getOptionsOptionEnumRuleCall_2_1_1_0() { return cOptionsOptionEnumRuleCall_2_1_1_0; }

		//(","? options+=Option)*
		public Group getGroup_2_1_2() { return cGroup_2_1_2; }

		//","?
		public Keyword getCommaKeyword_2_1_2_0() { return cCommaKeyword_2_1_2_0; }

		//options+=Option
		public Assignment getOptionsAssignment_2_1_2_1() { return cOptionsAssignment_2_1_2_1; }

		//Option
		public RuleCall getOptionsOptionEnumRuleCall_2_1_2_1_0() { return cOptionsOptionEnumRuleCall_2_1_2_1_0; }

		//ius+=IU*
		public Assignment getIusAssignment_2_2() { return cIusAssignment_2_2; }

		//IU
		public RuleCall getIusIUParserRuleCall_2_2_0() { return cIusIUParserRuleCall_2_2_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2_3() { return cRightCurlyBracketKeyword_2_3; }
	}

	public class IUElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IU");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIDAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cIDIDTerminalRuleCall_0_0 = (RuleCall)cIDAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final Keyword cVersionKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1_0_2 = (Keyword)cGroup_1_0.eContents().get(2);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Assignment cVersionAssignment_1_1_0 = (Assignment)cAlternatives_1_1.eContents().get(0);
		private final RuleCall cVersionVersionRangeParserRuleCall_1_1_0_0 = (RuleCall)cVersionAssignment_1_1_0.eContents().get(0);
		private final Assignment cVersionAssignment_1_1_1 = (Assignment)cAlternatives_1_1.eContents().get(1);
		private final RuleCall cVersionSTRINGTerminalRuleCall_1_1_1_0 = (RuleCall)cVersionAssignment_1_1_1.eContents().get(0);
		
		//IU:
		//	ID=ID ((";" "version" "=")? (version=VersionRange | version=STRING))?;
		public ParserRule getRule() { return rule; }

		//ID=ID ((";" "version" "=")? (version=VersionRange | version=STRING))?
		public Group getGroup() { return cGroup; }

		//ID=ID
		public Assignment getIDAssignment_0() { return cIDAssignment_0; }

		//ID
		public RuleCall getIDIDTerminalRuleCall_0_0() { return cIDIDTerminalRuleCall_0_0; }

		//((";" "version" "=")? (version=VersionRange | version=STRING))?
		public Group getGroup_1() { return cGroup_1; }

		//(";" "version" "=")?
		public Group getGroup_1_0() { return cGroup_1_0; }

		//";"
		public Keyword getSemicolonKeyword_1_0_0() { return cSemicolonKeyword_1_0_0; }

		//"version"
		public Keyword getVersionKeyword_1_0_1() { return cVersionKeyword_1_0_1; }

		//"="
		public Keyword getEqualsSignKeyword_1_0_2() { return cEqualsSignKeyword_1_0_2; }

		//version=VersionRange | version=STRING
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//version=VersionRange
		public Assignment getVersionAssignment_1_1_0() { return cVersionAssignment_1_1_0; }

		//VersionRange
		public RuleCall getVersionVersionRangeParserRuleCall_1_1_0_0() { return cVersionVersionRangeParserRuleCall_1_1_0_0; }

		//version=STRING
		public Assignment getVersionAssignment_1_1_1() { return cVersionAssignment_1_1_1; }

		//STRING
		public RuleCall getVersionSTRINGTerminalRuleCall_1_1_1_0() { return cVersionSTRINGTerminalRuleCall_1_1_1_0; }
	}

	public class VersionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Version");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cFullStopKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_2_1 = (RuleCall)cGroup_1_2.eContents().get(1);
		private final Group cGroup_1_2_2 = (Group)cGroup_1_2.eContents().get(2);
		private final Keyword cFullStopKeyword_1_2_2_0 = (Keyword)cGroup_1_2_2.eContents().get(0);
		private final Alternatives cAlternatives_1_2_2_1 = (Alternatives)cGroup_1_2_2.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1_2_2_1_0 = (RuleCall)cAlternatives_1_2_2_1.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_2_2_1_1 = (RuleCall)cAlternatives_1_2_2_1.eContents().get(1);
		private final RuleCall cQUALIFIERTerminalRuleCall_1_2_2_1_2 = (RuleCall)cAlternatives_1_2_2_1.eContents().get(2);
		
		//Version hidden():
		//	INT ("." INT ("." INT ("." (ID | INT | QUALIFIER))?)?)?;
		public ParserRule getRule() { return rule; }

		//INT ("." INT ("." INT ("." (ID | INT | QUALIFIER))?)?)?
		public Group getGroup() { return cGroup; }

		//INT
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }

		//("." INT ("." INT ("." (ID | INT | QUALIFIER))?)?)?
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//INT
		public RuleCall getINTTerminalRuleCall_1_1() { return cINTTerminalRuleCall_1_1; }

		//("." INT ("." (ID | INT | QUALIFIER))?)?
		public Group getGroup_1_2() { return cGroup_1_2; }

		//"."
		public Keyword getFullStopKeyword_1_2_0() { return cFullStopKeyword_1_2_0; }

		//INT
		public RuleCall getINTTerminalRuleCall_1_2_1() { return cINTTerminalRuleCall_1_2_1; }

		//("." (ID | INT | QUALIFIER))?
		public Group getGroup_1_2_2() { return cGroup_1_2_2; }

		//"."
		public Keyword getFullStopKeyword_1_2_2_0() { return cFullStopKeyword_1_2_2_0; }

		//ID | INT | QUALIFIER
		public Alternatives getAlternatives_1_2_2_1() { return cAlternatives_1_2_2_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_2_2_1_0() { return cIDTerminalRuleCall_1_2_2_1_0; }

		//INT
		public RuleCall getINTTerminalRuleCall_1_2_2_1_1() { return cINTTerminalRuleCall_1_2_2_1_1; }

		//QUALIFIER
		public RuleCall getQUALIFIERTerminalRuleCall_1_2_2_1_2() { return cQUALIFIERTerminalRuleCall_1_2_2_1_2; }
	}

	public class VersionRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VersionRange");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Alternatives cAlternatives_0_0 = (Alternatives)cGroup_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_0_0 = (Keyword)cAlternatives_0_0.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_0_0_1 = (Keyword)cAlternatives_0_0.eContents().get(1);
		private final RuleCall cVersionParserRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Keyword cCommaKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final RuleCall cVersionParserRuleCall_0_3 = (RuleCall)cGroup_0.eContents().get(3);
		private final Alternatives cAlternatives_0_4 = (Alternatives)cGroup_0.eContents().get(4);
		private final Keyword cRightParenthesisKeyword_0_4_0 = (Keyword)cAlternatives_0_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_0_4_1 = (Keyword)cAlternatives_0_4.eContents().get(1);
		private final RuleCall cVersionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final Keyword cLazyKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		
		//VersionRange hidden(WS):
		//	("(" | "[") Version "," Version (")" | "]") | Version | "lazy";
		public ParserRule getRule() { return rule; }

		//("(" | "[") Version "," Version (")" | "]") | Version | "lazy"
		public Alternatives getAlternatives() { return cAlternatives; }

		//("(" | "[") Version "," Version (")" | "]")
		public Group getGroup_0() { return cGroup_0; }

		//"(" | "["
		public Alternatives getAlternatives_0_0() { return cAlternatives_0_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_0_0_0() { return cLeftParenthesisKeyword_0_0_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0_0_1() { return cLeftSquareBracketKeyword_0_0_1; }

		//Version
		public RuleCall getVersionParserRuleCall_0_1() { return cVersionParserRuleCall_0_1; }

		//","
		public Keyword getCommaKeyword_0_2() { return cCommaKeyword_0_2; }

		//Version
		public RuleCall getVersionParserRuleCall_0_3() { return cVersionParserRuleCall_0_3; }

		//")" | "]"
		public Alternatives getAlternatives_0_4() { return cAlternatives_0_4; }

		//")"
		public Keyword getRightParenthesisKeyword_0_4_0() { return cRightParenthesisKeyword_0_4_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_0_4_1() { return cRightSquareBracketKeyword_0_4_1; }

		//Version
		public RuleCall getVersionParserRuleCall_1() { return cVersionParserRuleCall_1; }

		//"lazy"
		public Keyword getLazyKeyword_2() { return cLazyKeyword_2; }
	}
	
	
	public class OptionElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "Option");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cINCLUDE_REQUIREDEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cINCLUDE_REQUIREDRequirementsKeyword_0_0 = (Keyword)cINCLUDE_REQUIREDEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cINCLUDE_ALL_ENVIRONMENTSAllEnvironmentsKeyword_1_0 = (Keyword)cINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cINCLUDE_SOURCEEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cINCLUDE_SOURCESourceKeyword_2_0 = (Keyword)cINCLUDE_SOURCEEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cINCLUDE_CONFIGURE_PHASEConfigurePhaseKeyword_3_0 = (Keyword)cINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3.eContents().get(0);
		
		//enum Option:
		//	INCLUDE_REQUIRED="requirements" | INCLUDE_ALL_ENVIRONMENTS="allEnvironments" | INCLUDE_SOURCE="source" |
		//	INCLUDE_CONFIGURE_PHASE="configurePhase";
		public EnumRule getRule() { return rule; }

		//INCLUDE_REQUIRED="requirements" | INCLUDE_ALL_ENVIRONMENTS="allEnvironments" | INCLUDE_SOURCE="source" |
		//INCLUDE_CONFIGURE_PHASE="configurePhase"
		public Alternatives getAlternatives() { return cAlternatives; }

		//INCLUDE_REQUIRED="requirements"
		public EnumLiteralDeclaration getINCLUDE_REQUIREDEnumLiteralDeclaration_0() { return cINCLUDE_REQUIREDEnumLiteralDeclaration_0; }

		//"requirements"
		public Keyword getINCLUDE_REQUIREDRequirementsKeyword_0_0() { return cINCLUDE_REQUIREDRequirementsKeyword_0_0; }

		//INCLUDE_ALL_ENVIRONMENTS="allEnvironments"
		public EnumLiteralDeclaration getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1() { return cINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1; }

		//"allEnvironments"
		public Keyword getINCLUDE_ALL_ENVIRONMENTSAllEnvironmentsKeyword_1_0() { return cINCLUDE_ALL_ENVIRONMENTSAllEnvironmentsKeyword_1_0; }

		//INCLUDE_SOURCE="source"
		public EnumLiteralDeclaration getINCLUDE_SOURCEEnumLiteralDeclaration_2() { return cINCLUDE_SOURCEEnumLiteralDeclaration_2; }

		//"source"
		public Keyword getINCLUDE_SOURCESourceKeyword_2_0() { return cINCLUDE_SOURCESourceKeyword_2_0; }

		//INCLUDE_CONFIGURE_PHASE="configurePhase"
		public EnumLiteralDeclaration getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3() { return cINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3; }

		//"configurePhase"
		public Keyword getINCLUDE_CONFIGURE_PHASEConfigurePhaseKeyword_3_0() { return cINCLUDE_CONFIGURE_PHASEConfigurePhaseKeyword_3_0; }
	}
	
	private final TargetPlatformElements pTargetPlatform;
	private final TargetContentElements pTargetContent;
	private final OptionsElements pOptions;
	private final EnvironmentElements pEnvironment;
	private final VarDefinitionElements pVarDefinition;
	private final CompositeStringElements pCompositeString;
	private final CompositeStringPartElements pCompositeStringPart;
	private final VarCallElements pVarCall;
	private final StaticStringElements pStaticString;
	private final IncludeDeclarationElements pIncludeDeclaration;
	private final LocationElements pLocation;
	private final OptionElements unknownRuleOption;
	private final IUElements pIU;
	private final VersionElements pVersion;
	private final VersionRangeElements pVersionRange;
	private final TerminalRule tINT;
	private final TerminalRule tID;
	private final TerminalRule tQUALIFIER;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public TargetPlatformGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pTargetPlatform = new TargetPlatformElements();
		this.pTargetContent = new TargetContentElements();
		this.pOptions = new OptionsElements();
		this.pEnvironment = new EnvironmentElements();
		this.pVarDefinition = new VarDefinitionElements();
		this.pCompositeString = new CompositeStringElements();
		this.pCompositeStringPart = new CompositeStringPartElements();
		this.pVarCall = new VarCallElements();
		this.pStaticString = new StaticStringElements();
		this.pIncludeDeclaration = new IncludeDeclarationElements();
		this.pLocation = new LocationElements();
		this.unknownRuleOption = new OptionElements();
		this.pIU = new IUElements();
		this.pVersion = new VersionElements();
		this.pVersionRange = new VersionRangeElements();
		this.tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "INT");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID");
		this.tQUALIFIER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "QUALIFIER");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("fr.obeo.releng.targetplatform.TargetPlatform".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//TargetPlatform:
	//	("target" name=STRING contents+=TargetContent*)?;
	public TargetPlatformElements getTargetPlatformAccess() {
		return pTargetPlatform;
	}
	
	public ParserRule getTargetPlatformRule() {
		return getTargetPlatformAccess().getRule();
	}

	//TargetContent:
	//	Options | Environment | IncludeDeclaration | Location | VarDefinition;
	public TargetContentElements getTargetContentAccess() {
		return pTargetContent;
	}
	
	public ParserRule getTargetContentRule() {
		return getTargetContentAccess().getRule();
	}

	//Options:
	//	"with" options+=Option (","? options+=Option)*;
	public OptionsElements getOptionsAccess() {
		return pOptions;
	}
	
	public ParserRule getOptionsRule() {
		return getOptionsAccess().getRule();
	}

	//Environment:
	//	{Environment} "environment" env+=ID (","? env+=ID)*;
	public EnvironmentElements getEnvironmentAccess() {
		return pEnvironment;
	}
	
	public ParserRule getEnvironmentRule() {
		return getEnvironmentAccess().getRule();
	}

	//VarDefinition:
	//	"define" name=ID "=" value=STRING;
	public VarDefinitionElements getVarDefinitionAccess() {
		return pVarDefinition;
	}
	
	public ParserRule getVarDefinitionRule() {
		return getVarDefinitionAccess().getRule();
	}

	//CompositeString:
	//	{CompositeString} stringParts+=CompositeStringPart*;
	public CompositeStringElements getCompositeStringAccess() {
		return pCompositeString;
	}
	
	public ParserRule getCompositeStringRule() {
		return getCompositeStringAccess().getRule();
	}

	//CompositeStringPart:
	//	VarCall | StaticString;
	public CompositeStringPartElements getCompositeStringPartAccess() {
		return pCompositeStringPart;
	}
	
	public ParserRule getCompositeStringPartRule() {
		return getCompositeStringPartAccess().getRule();
	}

	//VarCall:
	//	"${" varName=[VarDefinition] "}";
	public VarCallElements getVarCallAccess() {
		return pVarCall;
	}
	
	public ParserRule getVarCallRule() {
		return getVarCallAccess().getRule();
	}

	//StaticString:
	//	value=STRING;
	public StaticStringElements getStaticStringAccess() {
		return pStaticString;
	}
	
	public ParserRule getStaticStringRule() {
		return getStaticStringAccess().getRule();
	}

	//IncludeDeclaration:
	//	"include" compositeImportURI=CompositeString;
	public IncludeDeclarationElements getIncludeDeclarationAccess() {
		return pIncludeDeclaration;
	}
	
	public ParserRule getIncludeDeclarationRule() {
		return getIncludeDeclarationAccess().getRule();
	}

	//Location:
	//	"location" (ID=ID? & uri=STRING) ("{" ("with" options+=Option (","? options+=Option)*)? ius+=IU* "}")?;
	public LocationElements getLocationAccess() {
		return pLocation;
	}
	
	public ParserRule getLocationRule() {
		return getLocationAccess().getRule();
	}

	//enum Option:
	//	INCLUDE_REQUIRED="requirements" | INCLUDE_ALL_ENVIRONMENTS="allEnvironments" | INCLUDE_SOURCE="source" |
	//	INCLUDE_CONFIGURE_PHASE="configurePhase";
	public OptionElements getOptionAccess() {
		return unknownRuleOption;
	}
	
	public EnumRule getOptionRule() {
		return getOptionAccess().getRule();
	}

	//IU:
	//	ID=ID ((";" "version" "=")? (version=VersionRange | version=STRING))?;
	public IUElements getIUAccess() {
		return pIU;
	}
	
	public ParserRule getIURule() {
		return getIUAccess().getRule();
	}

	//Version hidden():
	//	INT ("." INT ("." INT ("." (ID | INT | QUALIFIER))?)?)?;
	public VersionElements getVersionAccess() {
		return pVersion;
	}
	
	public ParserRule getVersionRule() {
		return getVersionAccess().getRule();
	}

	//VersionRange hidden(WS):
	//	("(" | "[") Version "," Version (")" | "]") | Version | "lazy";
	public VersionRangeElements getVersionRangeAccess() {
		return pVersionRange;
	}
	
	public ParserRule getVersionRangeRule() {
		return getVersionRangeAccess().getRule();
	}

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return tINT;
	} 

	//terminal ID returns ecore::EString:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("."? ("a".."z" | "A".."Z" | "^" | "_" | "-" | "0".."9"))*;
	public TerminalRule getIDRule() {
		return tID;
	} 

	//terminal QUALIFIER returns ecore::EString:
	//	("a".."z" | "A".."Z" | "_" | "-" | "0".."9")*;
	public TerminalRule getQUALIFIERRule() {
		return tQUALIFIER;
	} 

	//terminal STRING returns ecore::EString:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT returns ecore::EString:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT returns ecore::EString:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS returns ecore::EString:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER returns ecore::EString:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
