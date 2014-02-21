package fr.obeo.releng.targetplatform.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTargetPlatformParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'target'", "'version'", "','", "'with'", "'location'", "'{'", "'}'", "';'", "'='", "'.'", "'latest'", "'('", "'['", "')'", "']'", "'3.8'", "'3.6'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=7;

    // delegates
    // delegators


        public InternalTargetPlatformParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTargetPlatformParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTargetPlatformParser.tokenNames; }
    public String getGrammarFileName() { return "../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g"; }



     	private TargetPlatformGrammarAccess grammarAccess;
     	
        public InternalTargetPlatformParser(TokenStream input, TargetPlatformGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TargetPlatform";	
       	}
       	
       	@Override
       	protected TargetPlatformGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTargetPlatform"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:68:1: entryRuleTargetPlatform returns [EObject current=null] : iv_ruleTargetPlatform= ruleTargetPlatform EOF ;
    public final EObject entryRuleTargetPlatform() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetPlatform = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:69:2: (iv_ruleTargetPlatform= ruleTargetPlatform EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:70:2: iv_ruleTargetPlatform= ruleTargetPlatform EOF
            {
             newCompositeNode(grammarAccess.getTargetPlatformRule()); 
            pushFollow(FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform75);
            iv_ruleTargetPlatform=ruleTargetPlatform();

            state._fsp--;

             current =iv_ruleTargetPlatform; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTargetPlatform85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTargetPlatform"


    // $ANTLR start "ruleTargetPlatform"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:77:1: ruleTargetPlatform returns [EObject current=null] : (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* ) ) ) ( (lv_locations_11_0= ruleLocation ) )* )? ;
    public final EObject ruleTargetPlatform() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_targetVersions_4_0 = null;

        Enumerator lv_targetVersions_6_0 = null;

        Enumerator lv_options_8_0 = null;

        Enumerator lv_options_10_0 = null;

        EObject lv_locations_11_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:80:28: ( (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* ) ) ) ( (lv_locations_11_0= ruleLocation ) )* )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:1: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* ) ) ) ( (lv_locations_11_0= ruleLocation ) )* )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:1: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* ) ) ) ( (lv_locations_11_0= ruleLocation ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:3: otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* ) ) ) ( (lv_locations_11_0= ruleLocation ) )*
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleTargetPlatform122); 

                        	newLeafNode(otherlv_0, grammarAccess.getTargetPlatformAccess().getTargetKeyword_0());
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:85:1: ( (lv_name_1_0= RULE_STRING ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:86:1: (lv_name_1_0= RULE_STRING )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:86:1: (lv_name_1_0= RULE_STRING )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:87:3: lv_name_1_0= RULE_STRING
                    {
                    lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTargetPlatform139); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTargetPlatformRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:103:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* ) ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:105:1: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* ) )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:105:1: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:106:2: ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2());
                    	
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:109:2: ( ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )* )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:110:3: ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )*
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:110:3: ( ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( LA3_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0) ) {
                            alt3=1;
                        }
                        else if ( LA3_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:112:4: ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:112:4: ({...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) ) )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:113:5: {...}? => ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleTargetPlatform", "getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0)");
                    	    }
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:113:111: ( ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) ) )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:114:6: ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0);
                    	    	 				
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:117:6: ({...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* ) )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:117:7: {...}? => (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleTargetPlatform", "true");
                    	    }
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:117:16: (otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )* )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:117:18: otherlv_3= 'version' ( (lv_targetVersions_4_0= ruleTargetVersion ) ) (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )*
                    	    {
                    	    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleTargetPlatform202); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getTargetPlatformAccess().getVersionKeyword_2_0_0());
                    	        
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:121:1: ( (lv_targetVersions_4_0= ruleTargetVersion ) )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:122:1: (lv_targetVersions_4_0= ruleTargetVersion )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:122:1: (lv_targetVersions_4_0= ruleTargetVersion )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:123:3: lv_targetVersions_4_0= ruleTargetVersion
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTargetPlatformAccess().getTargetVersionsTargetVersionEnumRuleCall_2_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTargetVersion_in_ruleTargetPlatform223);
                    	    lv_targetVersions_4_0=ruleTargetVersion();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTargetPlatformRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"targetVersions",
                    	            		lv_targetVersions_4_0, 
                    	            		"TargetVersion");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:139:2: (otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) ) )*
                    	    loop1:
                    	    do {
                    	        int alt1=2;
                    	        int LA1_0 = input.LA(1);

                    	        if ( (LA1_0==13) ) {
                    	            alt1=1;
                    	        }


                    	        switch (alt1) {
                    	    	case 1 :
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:139:4: otherlv_5= ',' ( (lv_targetVersions_6_0= ruleTargetVersion ) )
                    	    	    {
                    	    	    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleTargetPlatform236); 

                    	    	        	newLeafNode(otherlv_5, grammarAccess.getTargetPlatformAccess().getCommaKeyword_2_0_2_0());
                    	    	        
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:143:1: ( (lv_targetVersions_6_0= ruleTargetVersion ) )
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:144:1: (lv_targetVersions_6_0= ruleTargetVersion )
                    	    	    {
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:144:1: (lv_targetVersions_6_0= ruleTargetVersion )
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:145:3: lv_targetVersions_6_0= ruleTargetVersion
                    	    	    {
                    	    	     
                    	    	    	        newCompositeNode(grammarAccess.getTargetPlatformAccess().getTargetVersionsTargetVersionEnumRuleCall_2_0_2_1_0()); 
                    	    	    	    
                    	    	    pushFollow(FOLLOW_ruleTargetVersion_in_ruleTargetPlatform257);
                    	    	    lv_targetVersions_6_0=ruleTargetVersion();

                    	    	    state._fsp--;


                    	    	    	        if (current==null) {
                    	    	    	            current = createModelElementForParent(grammarAccess.getTargetPlatformRule());
                    	    	    	        }
                    	    	           		add(
                    	    	           			current, 
                    	    	           			"targetVersions",
                    	    	            		lv_targetVersions_6_0, 
                    	    	            		"TargetVersion");
                    	    	    	        afterParserOrEnumRuleCall();
                    	    	    	    

                    	    	    }


                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop1;
                    	        }
                    	    } while (true);


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:168:4: ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:168:4: ({...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) ) )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:169:5: {...}? => ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleTargetPlatform", "getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1)");
                    	    }
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:169:111: ( ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) ) )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:170:6: ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1);
                    	    	 				
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:173:6: ({...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* ) )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:173:7: {...}? => (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleTargetPlatform", "true");
                    	    }
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:173:16: (otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )* )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:173:18: otherlv_7= 'with' ( (lv_options_8_0= ruleOption ) ) (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )*
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleTargetPlatform327); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getTargetPlatformAccess().getWithKeyword_2_1_0());
                    	        
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:177:1: ( (lv_options_8_0= ruleOption ) )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:178:1: (lv_options_8_0= ruleOption )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:178:1: (lv_options_8_0= ruleOption )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:179:3: lv_options_8_0= ruleOption
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTargetPlatformAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleOption_in_ruleTargetPlatform348);
                    	    lv_options_8_0=ruleOption();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTargetPlatformRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"options",
                    	            		lv_options_8_0, 
                    	            		"Option");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:195:2: (otherlv_9= ',' ( (lv_options_10_0= ruleOption ) ) )*
                    	    loop2:
                    	    do {
                    	        int alt2=2;
                    	        int LA2_0 = input.LA(1);

                    	        if ( (LA2_0==13) ) {
                    	            alt2=1;
                    	        }


                    	        switch (alt2) {
                    	    	case 1 :
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:195:4: otherlv_9= ',' ( (lv_options_10_0= ruleOption ) )
                    	    	    {
                    	    	    otherlv_9=(Token)match(input,13,FOLLOW_13_in_ruleTargetPlatform361); 

                    	    	        	newLeafNode(otherlv_9, grammarAccess.getTargetPlatformAccess().getCommaKeyword_2_1_2_0());
                    	    	        
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:199:1: ( (lv_options_10_0= ruleOption ) )
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:200:1: (lv_options_10_0= ruleOption )
                    	    	    {
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:200:1: (lv_options_10_0= ruleOption )
                    	    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:201:3: lv_options_10_0= ruleOption
                    	    	    {
                    	    	     
                    	    	    	        newCompositeNode(grammarAccess.getTargetPlatformAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
                    	    	    	    
                    	    	    pushFollow(FOLLOW_ruleOption_in_ruleTargetPlatform382);
                    	    	    lv_options_10_0=ruleOption();

                    	    	    state._fsp--;


                    	    	    	        if (current==null) {
                    	    	    	            current = createModelElementForParent(grammarAccess.getTargetPlatformRule());
                    	    	    	        }
                    	    	           		add(
                    	    	           			current, 
                    	    	           			"options",
                    	    	            		lv_options_10_0, 
                    	    	            		"Option");
                    	    	    	        afterParserOrEnumRuleCall();
                    	    	    	    

                    	    	    }


                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop2;
                    	        }
                    	    } while (true);


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }


                    }

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2());
                    	

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:231:2: ( (lv_locations_11_0= ruleLocation ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:232:1: (lv_locations_11_0= ruleLocation )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:232:1: (lv_locations_11_0= ruleLocation )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:233:3: lv_locations_11_0= ruleLocation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTargetPlatformAccess().getLocationsLocationParserRuleCall_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLocation_in_ruleTargetPlatform446);
                    	    lv_locations_11_0=ruleLocation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTargetPlatformRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"locations",
                    	            		lv_locations_11_0, 
                    	            		"Location");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTargetPlatform"


    // $ANTLR start "entryRuleLocation"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:257:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:258:2: (iv_ruleLocation= ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:259:2: iv_ruleLocation= ruleLocation EOF
            {
             newCompositeNode(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation484);
            iv_ruleLocation=ruleLocation();

            state._fsp--;

             current =iv_ruleLocation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation494); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocation"


    // $ANTLR start "ruleLocation"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:266:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )* )? otherlv_11= '}' )? ) ;
    public final EObject ruleLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_2_0=null;
        Token lv_uri_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Enumerator lv_options_6_0 = null;

        Enumerator lv_options_8_0 = null;

        EObject lv_ius_9_0 = null;

        EObject lv_ius_10_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:269:28: ( (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )* )? otherlv_11= '}' )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:270:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )* )? otherlv_11= '}' )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:270:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )* )? otherlv_11= '}' )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:270:3: otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )* )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleLocation531); 

                	newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:274:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:276:1: ( ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:276:1: ( ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:2: ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:280:2: ( ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:281:3: ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:281:3: ( ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( LA6_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                    alt6=1;
                }
                else if ( LA6_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:283:4: ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:283:4: ({...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:284:5: {...}? => ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:284:105: ( ({...}? => ( (lv_id_2_0= RULE_ID ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:285:6: ({...}? => ( (lv_id_2_0= RULE_ID ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:288:6: ({...}? => ( (lv_id_2_0= RULE_ID ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:288:7: {...}? => ( (lv_id_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:288:16: ( (lv_id_2_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:289:1: (lv_id_2_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:289:1: (lv_id_2_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:290:3: lv_id_2_0= RULE_ID
            	    {
            	    lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocation593); 

            	    			newLeafNode(lv_id_2_0, grammarAccess.getLocationAccess().getIdIDTerminalRuleCall_1_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLocationRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"id",
            	            		lv_id_2_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:313:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:313:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:314:5: {...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:314:105: ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:315:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:318:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:318:7: {...}? => ( (lv_uri_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:318:16: ( (lv_uri_3_0= RULE_STRING ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:319:1: (lv_uri_3_0= RULE_STRING )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:319:1: (lv_uri_3_0= RULE_STRING )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:320:3: lv_uri_3_0= RULE_STRING
            	    {
            	    lv_uri_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLocation669); 

            	    			newLeafNode(lv_uri_3_0, grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLocationRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"uri",
            	            		lv_uri_3_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	

            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:351:2: (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )* )? otherlv_11= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:351:4: otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )* )? otherlv_11= '}'
                    {
                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleLocation733); 

                        	newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0());
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:355:1: (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==14) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:355:3: otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )*
                            {
                            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleLocation746); 

                                	newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getWithKeyword_2_1_0());
                                
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:359:1: ( (lv_options_6_0= ruleOption ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:360:1: (lv_options_6_0= ruleOption )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:360:1: (lv_options_6_0= ruleOption )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:361:3: lv_options_6_0= ruleOption
                            {
                             
                            	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleOption_in_ruleLocation767);
                            lv_options_6_0=ruleOption();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getLocationRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"options",
                                    		lv_options_6_0, 
                                    		"Option");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:377:2: (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( (LA7_0==13) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:377:4: otherlv_7= ',' ( (lv_options_8_0= ruleOption ) )
                            	    {
                            	    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleLocation780); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
                            	        
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:381:1: ( (lv_options_8_0= ruleOption ) )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:382:1: (lv_options_8_0= ruleOption )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:382:1: (lv_options_8_0= ruleOption )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:383:3: lv_options_8_0= ruleOption
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleOption_in_ruleLocation801);
                            	    lv_options_8_0=ruleOption();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getLocationRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"options",
                            	            		lv_options_8_0, 
                            	            		"Option");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop7;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:399:6: ( ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_ID) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:399:7: ( (lv_ius_9_0= ruleIU ) ) ( (lv_ius_10_0= ruleIU ) )*
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:399:7: ( (lv_ius_9_0= ruleIU ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:400:1: (lv_ius_9_0= ruleIU )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:400:1: (lv_ius_9_0= ruleIU )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:401:3: lv_ius_9_0= ruleIU
                            {
                             
                            	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleIU_in_ruleLocation827);
                            lv_ius_9_0=ruleIU();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getLocationRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"ius",
                                    		lv_ius_9_0, 
                                    		"IU");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:417:2: ( (lv_ius_10_0= ruleIU ) )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==RULE_ID) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:418:1: (lv_ius_10_0= ruleIU )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:418:1: (lv_ius_10_0= ruleIU )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:419:3: lv_ius_10_0= ruleIU
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleIU_in_ruleLocation848);
                            	    lv_ius_10_0=ruleIU();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getLocationRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"ius",
                            	            		lv_ius_10_0, 
                            	            		"IU");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleLocation863); 

                        	newLeafNode(otherlv_11, grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocation"


    // $ANTLR start "entryRuleIU"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:447:1: entryRuleIU returns [EObject current=null] : iv_ruleIU= ruleIU EOF ;
    public final EObject entryRuleIU() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIU = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:448:2: (iv_ruleIU= ruleIU EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:449:2: iv_ruleIU= ruleIU EOF
            {
             newCompositeNode(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU901);
            iv_ruleIU=ruleIU();

            state._fsp--;

             current =iv_ruleIU; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU911); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIU"


    // $ANTLR start "ruleIU"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:456:1: ruleIU returns [EObject current=null] : ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= RULE_STRING ) ) | ( (lv_version_5_0= ruleVersionRange ) ) ) )? ) ;
    public final EObject ruleIU() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_version_4_0=null;
        AntlrDatatypeRuleToken lv_ID_0_0 = null;

        AntlrDatatypeRuleToken lv_version_5_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:459:28: ( ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= RULE_STRING ) ) | ( (lv_version_5_0= ruleVersionRange ) ) ) )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:460:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= RULE_STRING ) ) | ( (lv_version_5_0= ruleVersionRange ) ) ) )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:460:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= RULE_STRING ) ) | ( (lv_version_5_0= ruleVersionRange ) ) ) )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:460:2: ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= RULE_STRING ) ) | ( (lv_version_5_0= ruleVersionRange ) ) ) )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:460:2: ( (lv_ID_0_0= ruleQualifiedName ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:461:1: (lv_ID_0_0= ruleQualifiedName )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:461:1: (lv_ID_0_0= ruleQualifiedName )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:462:3: lv_ID_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getIUAccess().getIDQualifiedNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleIU957);
            lv_ID_0_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIURule());
            	        }
                   		set(
                   			current, 
                   			"ID",
                    		lv_ID_0_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:478:2: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= RULE_STRING ) ) | ( (lv_version_5_0= ruleVersionRange ) ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:478:4: otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= RULE_STRING ) ) | ( (lv_version_5_0= ruleVersionRange ) ) )
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleIU970); 

                        	newLeafNode(otherlv_1, grammarAccess.getIUAccess().getSemicolonKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleIU982); 

                        	newLeafNode(otherlv_2, grammarAccess.getIUAccess().getVersionKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleIU994); 

                        	newLeafNode(otherlv_3, grammarAccess.getIUAccess().getEqualsSignKeyword_1_2());
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:490:1: ( ( (lv_version_4_0= RULE_STRING ) ) | ( (lv_version_5_0= ruleVersionRange ) ) )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_STRING) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==RULE_INT||(LA12_0>=21 && LA12_0<=23)) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:490:2: ( (lv_version_4_0= RULE_STRING ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:490:2: ( (lv_version_4_0= RULE_STRING ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:491:1: (lv_version_4_0= RULE_STRING )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:491:1: (lv_version_4_0= RULE_STRING )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:492:3: lv_version_4_0= RULE_STRING
                            {
                            lv_version_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIU1012); 

                            			newLeafNode(lv_version_4_0, grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_3_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getIURule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"version",
                                    		lv_version_4_0, 
                                    		"STRING");
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:509:6: ( (lv_version_5_0= ruleVersionRange ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:509:6: ( (lv_version_5_0= ruleVersionRange ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:510:1: (lv_version_5_0= ruleVersionRange )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:510:1: (lv_version_5_0= ruleVersionRange )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:511:3: lv_version_5_0= ruleVersionRange
                            {
                             
                            	        newCompositeNode(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleVersionRange_in_ruleIU1044);
                            lv_version_5_0=ruleVersionRange();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getIURule());
                            	        }
                                   		set(
                                   			current, 
                                   			"version",
                                    		lv_version_5_0, 
                                    		"VersionRange");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIU"


    // $ANTLR start "entryRuleQualifiedName"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:535:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:539:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:540:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1090);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1101); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:550:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:554:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:555:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:555:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:555:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1145); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:562:1: (kw= '.' this_ID_2= RULE_ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==20) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:563:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,20,FOLLOW_20_in_ruleQualifiedName1164); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1179); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleVersion"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:586:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:590:2: (iv_ruleVersion= ruleVersion EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:591:2: iv_ruleVersion= ruleVersion EOF
            {
             newCompositeNode(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion1237);
            iv_ruleVersion=ruleVersion();

            state._fsp--;

             current =iv_ruleVersion.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion1248); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:601:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )? )? ) | kw= 'latest' ) ;
    public final AntlrDatatypeRuleToken ruleVersion() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_ID_6=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:605:28: ( ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )? )? ) | kw= 'latest' ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:606:1: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )? )? ) | kw= 'latest' )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:606:1: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )? )? ) | kw= 'latest' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT) ) {
                alt18=1;
            }
            else if ( (LA18_0==21) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:606:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )? )? )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:606:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )? )? )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:606:7: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )? )?
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1293); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_0()); 
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:613:1: (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )? )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==20) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:614:2: kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )?
                            {
                            kw=(Token)match(input,20,FOLLOW_20_in_ruleVersion1312); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_0_1_0()); 
                                
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1327); 

                            		current.merge(this_INT_2);
                                
                             
                                newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_1_1()); 
                                
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:626:1: (kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )? )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==20) ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:627:2: kw= '.' this_INT_4= RULE_INT (kw= '.' this_ID_6= RULE_ID )?
                                    {
                                    kw=(Token)match(input,20,FOLLOW_20_in_ruleVersion1346); 

                                            current.merge(kw);
                                            newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_0_1_2_0()); 
                                        
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1361); 

                                    		current.merge(this_INT_4);
                                        
                                     
                                        newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_1_2_1()); 
                                        
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:639:1: (kw= '.' this_ID_6= RULE_ID )?
                                    int alt15=2;
                                    int LA15_0 = input.LA(1);

                                    if ( (LA15_0==20) ) {
                                        alt15=1;
                                    }
                                    switch (alt15) {
                                        case 1 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:640:2: kw= '.' this_ID_6= RULE_ID
                                            {
                                            kw=(Token)match(input,20,FOLLOW_20_in_ruleVersion1380); 

                                                    current.merge(kw);
                                                    newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_0_1_2_2_0()); 
                                                
                                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVersion1395); 

                                            		current.merge(this_ID_6);
                                                
                                             
                                                newLeafNode(this_ID_6, grammarAccess.getVersionAccess().getIDTerminalRuleCall_0_1_2_2_1()); 
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:654:2: kw= 'latest'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleVersion1426); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVersionAccess().getLatestKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleVersionRange"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:670:1: entryRuleVersionRange returns [String current=null] : iv_ruleVersionRange= ruleVersionRange EOF ;
    public final String entryRuleVersionRange() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionRange = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:674:2: (iv_ruleVersionRange= ruleVersionRange EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:675:2: iv_ruleVersionRange= ruleVersionRange EOF
            {
             newCompositeNode(grammarAccess.getVersionRangeRule()); 
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange1477);
            iv_ruleVersionRange=ruleVersionRange();

            state._fsp--;

             current =iv_ruleVersionRange.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange1488); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVersionRange"


    // $ANTLR start "ruleVersionRange"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:685:1: ruleVersionRange returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' | kw= '[' ) (this_WS_2= RULE_WS )* this_Version_3= ruleVersion (this_WS_4= RULE_WS )* kw= ',' (this_WS_6= RULE_WS )* this_Version_7= ruleVersion (this_WS_8= RULE_WS )* (kw= ')' | kw= ']' ) ) | this_Version_11= ruleVersion ) ;
    public final AntlrDatatypeRuleToken ruleVersionRange() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_WS_2=null;
        Token this_WS_4=null;
        Token this_WS_6=null;
        Token this_WS_8=null;
        AntlrDatatypeRuleToken this_Version_3 = null;

        AntlrDatatypeRuleToken this_Version_7 = null;

        AntlrDatatypeRuleToken this_Version_11 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:689:28: ( ( ( (kw= '(' | kw= '[' ) (this_WS_2= RULE_WS )* this_Version_3= ruleVersion (this_WS_4= RULE_WS )* kw= ',' (this_WS_6= RULE_WS )* this_Version_7= ruleVersion (this_WS_8= RULE_WS )* (kw= ')' | kw= ']' ) ) | this_Version_11= ruleVersion ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:1: ( ( (kw= '(' | kw= '[' ) (this_WS_2= RULE_WS )* this_Version_3= ruleVersion (this_WS_4= RULE_WS )* kw= ',' (this_WS_6= RULE_WS )* this_Version_7= ruleVersion (this_WS_8= RULE_WS )* (kw= ')' | kw= ']' ) ) | this_Version_11= ruleVersion )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:1: ( ( (kw= '(' | kw= '[' ) (this_WS_2= RULE_WS )* this_Version_3= ruleVersion (this_WS_4= RULE_WS )* kw= ',' (this_WS_6= RULE_WS )* this_Version_7= ruleVersion (this_WS_8= RULE_WS )* (kw= ')' | kw= ']' ) ) | this_Version_11= ruleVersion )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=22 && LA25_0<=23)) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_INT||LA25_0==21) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:2: ( (kw= '(' | kw= '[' ) (this_WS_2= RULE_WS )* this_Version_3= ruleVersion (this_WS_4= RULE_WS )* kw= ',' (this_WS_6= RULE_WS )* this_Version_7= ruleVersion (this_WS_8= RULE_WS )* (kw= ')' | kw= ']' ) )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:2: ( (kw= '(' | kw= '[' ) (this_WS_2= RULE_WS )* this_Version_3= ruleVersion (this_WS_4= RULE_WS )* kw= ',' (this_WS_6= RULE_WS )* this_Version_7= ruleVersion (this_WS_8= RULE_WS )* (kw= ')' | kw= ']' ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:3: (kw= '(' | kw= '[' ) (this_WS_2= RULE_WS )* this_Version_3= ruleVersion (this_WS_4= RULE_WS )* kw= ',' (this_WS_6= RULE_WS )* this_Version_7= ruleVersion (this_WS_8= RULE_WS )* (kw= ')' | kw= ']' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:3: (kw= '(' | kw= '[' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==22) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==23) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:691:2: kw= '('
                            {
                            kw=(Token)match(input,22,FOLLOW_22_in_ruleVersionRange1532); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:698:2: kw= '['
                            {
                            kw=(Token)match(input,23,FOLLOW_23_in_ruleVersionRange1551); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                                

                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:703:2: (this_WS_2= RULE_WS )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_WS) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:703:7: this_WS_2= RULE_WS
                    	    {
                    	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVersionRange1568); 

                    	    		current.merge(this_WS_2);
                    	        
                    	     
                    	        newLeafNode(this_WS_2, grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1597);
                    this_Version_3=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_3);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:721:1: (this_WS_4= RULE_WS )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_WS) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:721:6: this_WS_4= RULE_WS
                    	    {
                    	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVersionRange1618); 

                    	    		current.merge(this_WS_4);
                    	        
                    	     
                    	        newLeafNode(this_WS_4, grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_3()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    kw=(Token)match(input,13,FOLLOW_13_in_ruleVersionRange1638); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVersionRangeAccess().getCommaKeyword_0_4()); 
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:734:1: (this_WS_6= RULE_WS )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_WS) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:734:6: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVersionRange1654); 

                    	    		current.merge(this_WS_6);
                    	        
                    	     
                    	        newLeafNode(this_WS_6, grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_5()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_6()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1683);
                    this_Version_7=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_7);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:752:1: (this_WS_8= RULE_WS )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_WS) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:752:6: this_WS_8= RULE_WS
                    	    {
                    	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVersionRange1704); 

                    	    		current.merge(this_WS_8);
                    	        
                    	     
                    	        newLeafNode(this_WS_8, grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_7()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:759:3: (kw= ')' | kw= ']' )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==24) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==25) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:760:2: kw= ')'
                            {
                            kw=(Token)match(input,24,FOLLOW_24_in_ruleVersionRange1725); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_8_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:767:2: kw= ']'
                            {
                            kw=(Token)match(input,25,FOLLOW_25_in_ruleVersionRange1744); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_8_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:774:5: this_Version_11= ruleVersion
                    {
                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1774);
                    this_Version_11=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_11);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVersionRange"


    // $ANTLR start "ruleTargetVersion"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:795:1: ruleTargetVersion returns [Enumerator current=null] : ( (enumLiteral_0= '3.8' ) | (enumLiteral_1= '3.6' ) ) ;
    public final Enumerator ruleTargetVersion() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:797:28: ( ( (enumLiteral_0= '3.8' ) | (enumLiteral_1= '3.6' ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:798:1: ( (enumLiteral_0= '3.8' ) | (enumLiteral_1= '3.6' ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:798:1: ( (enumLiteral_0= '3.8' ) | (enumLiteral_1= '3.6' ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==26) ) {
                alt26=1;
            }
            else if ( (LA26_0==27) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:798:2: (enumLiteral_0= '3.8' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:798:2: (enumLiteral_0= '3.8' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:798:4: enumLiteral_0= '3.8'
                    {
                    enumLiteral_0=(Token)match(input,26,FOLLOW_26_in_ruleTargetVersion1837); 

                            current = grammarAccess.getTargetVersionAccess().getTARGET38EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getTargetVersionAccess().getTARGET38EnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:804:6: (enumLiteral_1= '3.6' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:804:6: (enumLiteral_1= '3.6' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:804:8: enumLiteral_1= '3.6'
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_27_in_ruleTargetVersion1854); 

                            current = grammarAccess.getTargetVersionAccess().getTARGET36EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getTargetVersionAccess().getTARGET36EnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTargetVersion"


    // $ANTLR start "ruleOption"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:814:1: ruleOption returns [Enumerator current=null] : ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) ;
    public final Enumerator ruleOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:816:28: ( ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:817:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:817:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            int alt27=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt27=1;
                }
                break;
            case 29:
                {
                alt27=2;
                }
                break;
            case 30:
                {
                alt27=3;
                }
                break;
            case 31:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:817:2: (enumLiteral_0= 'requirements' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:817:2: (enumLiteral_0= 'requirements' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:817:4: enumLiteral_0= 'requirements'
                    {
                    enumLiteral_0=(Token)match(input,28,FOLLOW_28_in_ruleOption1899); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:823:6: (enumLiteral_1= 'allEnvironments' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:823:6: (enumLiteral_1= 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:823:8: enumLiteral_1= 'allEnvironments'
                    {
                    enumLiteral_1=(Token)match(input,29,FOLLOW_29_in_ruleOption1916); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:829:6: (enumLiteral_2= 'source' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:829:6: (enumLiteral_2= 'source' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:829:8: enumLiteral_2= 'source'
                    {
                    enumLiteral_2=(Token)match(input,30,FOLLOW_30_in_ruleOption1933); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:835:6: (enumLiteral_3= 'configurePhase' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:835:6: (enumLiteral_3= 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:835:8: enumLiteral_3= 'configurePhase'
                    {
                    enumLiteral_3=(Token)match(input,31,FOLLOW_31_in_ruleOption1950); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOption"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetPlatform85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTargetPlatform122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTargetPlatform139 = new BitSet(new long[]{0x000000000000D002L});
    public static final BitSet FOLLOW_12_in_ruleTargetPlatform202 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_ruleTargetVersion_in_ruleTargetPlatform223 = new BitSet(new long[]{0x000000000000F002L});
    public static final BitSet FOLLOW_13_in_ruleTargetPlatform236 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_ruleTargetVersion_in_ruleTargetPlatform257 = new BitSet(new long[]{0x000000000000F002L});
    public static final BitSet FOLLOW_14_in_ruleTargetPlatform327 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleTargetPlatform348 = new BitSet(new long[]{0x000000000000F002L});
    public static final BitSet FOLLOW_13_in_ruleTargetPlatform361 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleTargetPlatform382 = new BitSet(new long[]{0x000000000000F002L});
    public static final BitSet FOLLOW_ruleLocation_in_ruleTargetPlatform446 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleLocation531 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocation593 = new BitSet(new long[]{0x0000000000010032L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLocation669 = new BitSet(new long[]{0x0000000000010032L});
    public static final BitSet FOLLOW_16_in_ruleLocation733 = new BitSet(new long[]{0x0000000000024020L});
    public static final BitSet FOLLOW_14_in_ruleLocation746 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation767 = new BitSet(new long[]{0x0000000000022020L});
    public static final BitSet FOLLOW_13_in_ruleLocation780 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation801 = new BitSet(new long[]{0x0000000000022020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation827 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation848 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_17_in_ruleLocation863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleIU957 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleIU970 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleIU982 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleIU994 = new BitSet(new long[]{0x0000000000E00050L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIU1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_ruleIU1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1145 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleQualifiedName1164 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1179 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion1237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1293 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleVersion1312 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1327 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleVersion1346 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1361 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleVersion1380 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVersion1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVersion1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange1477 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVersionRange1532 = new BitSet(new long[]{0x0000000000E000D0L});
    public static final BitSet FOLLOW_23_in_ruleVersionRange1551 = new BitSet(new long[]{0x0000000000E000D0L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVersionRange1568 = new BitSet(new long[]{0x0000000000E000D0L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1597 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVersionRange1618 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_13_in_ruleVersionRange1638 = new BitSet(new long[]{0x0000000000E000D0L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVersionRange1654 = new BitSet(new long[]{0x0000000000E000D0L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1683 = new BitSet(new long[]{0x0000000003000080L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVersionRange1704 = new BitSet(new long[]{0x0000000003000080L});
    public static final BitSet FOLLOW_24_in_ruleVersionRange1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVersionRange1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTargetVersion1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTargetVersion1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOption1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOption1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOption1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOption1950 = new BitSet(new long[]{0x0000000000000002L});

}
