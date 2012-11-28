package fr.obeo.releng.parser.antlr.internal; 

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
import fr.obeo.releng.services.TargetPlatformGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTargetPlatformParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "'location'", "'{'", "'with'", "','", "'}'", "';'", "'version'", "'='", "'.'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'"
    };
    public static final int RULE_ID=5;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
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
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalTargetPlatformParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTargetPlatformParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTargetPlatformParser.tokenNames; }
    public String getGrammarFileName() { return "../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g"; }



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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:68:1: entryRuleTargetPlatform returns [EObject current=null] : iv_ruleTargetPlatform= ruleTargetPlatform EOF ;
    public final EObject entryRuleTargetPlatform() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetPlatform = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:69:2: (iv_ruleTargetPlatform= ruleTargetPlatform EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:70:2: iv_ruleTargetPlatform= ruleTargetPlatform EOF
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:77:1: ruleTargetPlatform returns [EObject current=null] : (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_locations_2_0= ruleLocation ) )* )? ;
    public final EObject ruleTargetPlatform() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_locations_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:80:28: ( (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_locations_2_0= ruleLocation ) )* )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:81:1: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_locations_2_0= ruleLocation ) )* )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:81:1: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_locations_2_0= ruleLocation ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:81:3: otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_locations_2_0= ruleLocation ) )*
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleTargetPlatform122); 

                        	newLeafNode(otherlv_0, grammarAccess.getTargetPlatformAccess().getTargetKeyword_0());
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:85:1: ( (lv_name_1_0= RULE_STRING ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:86:1: (lv_name_1_0= RULE_STRING )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:86:1: (lv_name_1_0= RULE_STRING )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:87:3: lv_name_1_0= RULE_STRING
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

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:103:2: ( (lv_locations_2_0= ruleLocation ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:104:1: (lv_locations_2_0= ruleLocation )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:104:1: (lv_locations_2_0= ruleLocation )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:105:3: lv_locations_2_0= ruleLocation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTargetPlatformAccess().getLocationsLocationParserRuleCall_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLocation_in_ruleTargetPlatform165);
                    	    lv_locations_2_0=ruleLocation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTargetPlatformRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"locations",
                    	            		lv_locations_2_0, 
                    	            		"Location");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:129:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:130:2: (iv_ruleLocation= ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:131:2: iv_ruleLocation= ruleLocation EOF
            {
             newCompositeNode(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation203);
            iv_ruleLocation=ruleLocation();

            state._fsp--;

             current =iv_ruleLocation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation213); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:138:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'location' ( (lv_uri_1_0= RULE_STRING ) ) (otherlv_2= '{' (otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )* )? ( ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )* )? otherlv_9= '}' )? ) ;
    public final EObject ruleLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_uri_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Enumerator lv_options_4_0 = null;

        Enumerator lv_options_6_0 = null;

        EObject lv_ius_7_0 = null;

        EObject lv_ius_8_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:141:28: ( (otherlv_0= 'location' ( (lv_uri_1_0= RULE_STRING ) ) (otherlv_2= '{' (otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )* )? ( ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )* )? otherlv_9= '}' )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:142:1: (otherlv_0= 'location' ( (lv_uri_1_0= RULE_STRING ) ) (otherlv_2= '{' (otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )* )? ( ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )* )? otherlv_9= '}' )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:142:1: (otherlv_0= 'location' ( (lv_uri_1_0= RULE_STRING ) ) (otherlv_2= '{' (otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )* )? ( ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )* )? otherlv_9= '}' )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:142:3: otherlv_0= 'location' ( (lv_uri_1_0= RULE_STRING ) ) (otherlv_2= '{' (otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )* )? ( ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )* )? otherlv_9= '}' )?
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleLocation250); 

                	newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:146:1: ( (lv_uri_1_0= RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:147:1: (lv_uri_1_0= RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:147:1: (lv_uri_1_0= RULE_STRING )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:148:3: lv_uri_1_0= RULE_STRING
            {
            lv_uri_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLocation267); 

            			newLeafNode(lv_uri_1_0, grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLocationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"uri",
                    		lv_uri_1_0, 
                    		"STRING");
            	    

            }


            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:164:2: (otherlv_2= '{' (otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )* )? ( ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )* )? otherlv_9= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:164:4: otherlv_2= '{' (otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )* )? ( ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )* )? otherlv_9= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleLocation285); 

                        	newLeafNode(otherlv_2, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0());
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:168:1: (otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==14) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:168:3: otherlv_3= 'with' ( (lv_options_4_0= ruleOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )*
                            {
                            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleLocation298); 

                                	newLeafNode(otherlv_3, grammarAccess.getLocationAccess().getWithKeyword_2_1_0());
                                
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:172:1: ( (lv_options_4_0= ruleOption ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:173:1: (lv_options_4_0= ruleOption )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:173:1: (lv_options_4_0= ruleOption )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:174:3: lv_options_4_0= ruleOption
                            {
                             
                            	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleOption_in_ruleLocation319);
                            lv_options_4_0=ruleOption();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getLocationRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"options",
                                    		lv_options_4_0, 
                                    		"Option");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:190:2: (otherlv_5= ',' ( (lv_options_6_0= ruleOption ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==15) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:190:4: otherlv_5= ',' ( (lv_options_6_0= ruleOption ) )
                            	    {
                            	    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleLocation332); 

                            	        	newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
                            	        
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:194:1: ( (lv_options_6_0= ruleOption ) )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:195:1: (lv_options_6_0= ruleOption )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:195:1: (lv_options_6_0= ruleOption )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:196:3: lv_options_6_0= ruleOption
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleOption_in_ruleLocation353);
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


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:212:6: ( ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )* )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:212:7: ( (lv_ius_7_0= ruleIU ) ) ( (lv_ius_8_0= ruleIU ) )*
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:212:7: ( (lv_ius_7_0= ruleIU ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:213:1: (lv_ius_7_0= ruleIU )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:213:1: (lv_ius_7_0= ruleIU )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:214:3: lv_ius_7_0= ruleIU
                            {
                             
                            	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleIU_in_ruleLocation379);
                            lv_ius_7_0=ruleIU();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getLocationRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"ius",
                                    		lv_ius_7_0, 
                                    		"IU");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:230:2: ( (lv_ius_8_0= ruleIU ) )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==RULE_ID) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:231:1: (lv_ius_8_0= ruleIU )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:231:1: (lv_ius_8_0= ruleIU )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:232:3: lv_ius_8_0= ruleIU
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleIU_in_ruleLocation400);
                            	    lv_ius_8_0=ruleIU();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getLocationRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"ius",
                            	            		lv_ius_8_0, 
                            	            		"IU");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleLocation415); 

                        	newLeafNode(otherlv_9, grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3());
                        

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:260:1: entryRuleIU returns [EObject current=null] : iv_ruleIU= ruleIU EOF ;
    public final EObject entryRuleIU() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIU = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:261:2: (iv_ruleIU= ruleIU EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:262:2: iv_ruleIU= ruleIU EOF
            {
             newCompositeNode(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU453);
            iv_ruleIU=ruleIU();

            state._fsp--;

             current =iv_ruleIU; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU463); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:269:1: ruleIU returns [EObject current=null] : ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( (lv_version_4_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleIU() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_version_4_0=null;
        AntlrDatatypeRuleToken lv_ID_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:272:28: ( ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( (lv_version_4_0= RULE_STRING ) ) )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:273:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( (lv_version_4_0= RULE_STRING ) ) )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:273:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( (lv_version_4_0= RULE_STRING ) ) )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:273:2: ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( (lv_version_4_0= RULE_STRING ) ) )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:273:2: ( (lv_ID_0_0= ruleQualifiedName ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:274:1: (lv_ID_0_0= ruleQualifiedName )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:274:1: (lv_ID_0_0= ruleQualifiedName )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:275:3: lv_ID_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getIUAccess().getIDQualifiedNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleIU509);
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

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:291:2: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( (lv_version_4_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:291:4: otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( (lv_version_4_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleIU522); 

                        	newLeafNode(otherlv_1, grammarAccess.getIUAccess().getSemicolonKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleIU534); 

                        	newLeafNode(otherlv_2, grammarAccess.getIUAccess().getVersionKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleIU546); 

                        	newLeafNode(otherlv_3, grammarAccess.getIUAccess().getEqualsSignKeyword_1_2());
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:303:1: ( (lv_version_4_0= RULE_STRING ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:304:1: (lv_version_4_0= RULE_STRING )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:304:1: (lv_version_4_0= RULE_STRING )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:305:3: lv_version_4_0= RULE_STRING
                    {
                    lv_version_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIU563); 

                    			newLeafNode(lv_version_4_0, grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_3_0()); 
                    		

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:329:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:330:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:331:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName607);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName618); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:338:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:341:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:342:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:342:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:342:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName658); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:349:1: (kw= '.' this_ID_2= RULE_ID )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:350:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,20,FOLLOW_20_in_ruleQualifiedName677); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName692); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop9;
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
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleOption"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:370:1: ruleOption returns [Enumerator current=null] : ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) ;
    public final Enumerator ruleOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:372:28: ( ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:373:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:373:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt10=1;
                }
                break;
            case 22:
                {
                alt10=2;
                }
                break;
            case 23:
                {
                alt10=3;
                }
                break;
            case 24:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:373:2: (enumLiteral_0= 'requirements' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:373:2: (enumLiteral_0= 'requirements' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:373:4: enumLiteral_0= 'requirements'
                    {
                    enumLiteral_0=(Token)match(input,21,FOLLOW_21_in_ruleOption753); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:379:6: (enumLiteral_1= 'allEnvironments' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:379:6: (enumLiteral_1= 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:379:8: enumLiteral_1= 'allEnvironments'
                    {
                    enumLiteral_1=(Token)match(input,22,FOLLOW_22_in_ruleOption770); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:385:6: (enumLiteral_2= 'source' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:385:6: (enumLiteral_2= 'source' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:385:8: enumLiteral_2= 'source'
                    {
                    enumLiteral_2=(Token)match(input,23,FOLLOW_23_in_ruleOption787); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:391:6: (enumLiteral_3= 'configurePhase' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:391:6: (enumLiteral_3= 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/parser/antlr/internal/InternalTargetPlatform.g:391:8: enumLiteral_3= 'configurePhase'
                    {
                    enumLiteral_3=(Token)match(input,24,FOLLOW_24_in_ruleOption804); 

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
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTargetPlatform139 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleLocation_in_ruleTargetPlatform165 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleLocation250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLocation267 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleLocation285 = new BitSet(new long[]{0x0000000000014020L});
    public static final BitSet FOLLOW_14_in_ruleLocation298 = new BitSet(new long[]{0x0000000001E00000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation319 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_15_in_ruleLocation332 = new BitSet(new long[]{0x0000000001E00000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation353 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation379 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation400 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_16_in_ruleLocation415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleIU509 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleIU522 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleIU534 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleIU546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIU563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName658 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleQualifiedName677 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName692 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_21_in_ruleOption753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOption770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOption787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOption804 = new BitSet(new long[]{0x0000000000000002L});

}