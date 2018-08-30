package org.eclipse.cbi.targetplatform.parser.antlr.internal;

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
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTargetPlatformParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_QUALIFIER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "'with'", "','", "'environment'", "'include'", "'location'", "'{'", "'}'", "';'", "'version'", "'='", "'.'", "'('", "'['", "')'", "']'", "'lazy'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_QUALIFIER=7;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalTargetPlatformParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTargetPlatformParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTargetPlatformParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTargetPlatform.g"; }



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
    // InternalTargetPlatform.g:65:1: entryRuleTargetPlatform returns [EObject current=null] : iv_ruleTargetPlatform= ruleTargetPlatform EOF ;
    public final EObject entryRuleTargetPlatform() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetPlatform = null;


        try {
            // InternalTargetPlatform.g:65:55: (iv_ruleTargetPlatform= ruleTargetPlatform EOF )
            // InternalTargetPlatform.g:66:2: iv_ruleTargetPlatform= ruleTargetPlatform EOF
            {
             newCompositeNode(grammarAccess.getTargetPlatformRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTargetPlatform=ruleTargetPlatform();

            state._fsp--;

             current =iv_ruleTargetPlatform; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:72:1: ruleTargetPlatform returns [EObject current=null] : (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )? ;
    public final EObject ruleTargetPlatform() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_contents_2_0 = null;



        	enterRule();

        try {
            // InternalTargetPlatform.g:78:2: ( (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )? )
            // InternalTargetPlatform.g:79:2: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )?
            {
            // InternalTargetPlatform.g:79:2: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTargetPlatform.g:80:3: otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )*
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_3); 

                    			newLeafNode(otherlv_0, grammarAccess.getTargetPlatformAccess().getTargetKeyword_0());
                    		
                    // InternalTargetPlatform.g:84:3: ( (lv_name_1_0= RULE_STRING ) )
                    // InternalTargetPlatform.g:85:4: (lv_name_1_0= RULE_STRING )
                    {
                    // InternalTargetPlatform.g:85:4: (lv_name_1_0= RULE_STRING )
                    // InternalTargetPlatform.g:86:5: lv_name_1_0= RULE_STRING
                    {
                    lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTargetPlatformRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }

                    // InternalTargetPlatform.g:102:3: ( (lv_contents_2_0= ruleTargetContent ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13||(LA1_0>=15 && LA1_0<=17)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalTargetPlatform.g:103:4: (lv_contents_2_0= ruleTargetContent )
                    	    {
                    	    // InternalTargetPlatform.g:103:4: (lv_contents_2_0= ruleTargetContent )
                    	    // InternalTargetPlatform.g:104:5: lv_contents_2_0= ruleTargetContent
                    	    {

                    	    					newCompositeNode(grammarAccess.getTargetPlatformAccess().getContentsTargetContentParserRuleCall_2_0());
                    	    				
                    	    pushFollow(FOLLOW_4);
                    	    lv_contents_2_0=ruleTargetContent();

                    	    state._fsp--;


                    	    					if (current==null) {
                    	    						current = createModelElementForParent(grammarAccess.getTargetPlatformRule());
                    	    					}
                    	    					add(
                    	    						current,
                    	    						"contents",
                    	    						lv_contents_2_0,
                    	    						"org.eclipse.cbi.targetplatform.TargetPlatform.TargetContent");
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


    // $ANTLR start "entryRuleTargetContent"
    // InternalTargetPlatform.g:125:1: entryRuleTargetContent returns [EObject current=null] : iv_ruleTargetContent= ruleTargetContent EOF ;
    public final EObject entryRuleTargetContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetContent = null;


        try {
            // InternalTargetPlatform.g:125:54: (iv_ruleTargetContent= ruleTargetContent EOF )
            // InternalTargetPlatform.g:126:2: iv_ruleTargetContent= ruleTargetContent EOF
            {
             newCompositeNode(grammarAccess.getTargetContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTargetContent=ruleTargetContent();

            state._fsp--;

             current =iv_ruleTargetContent; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTargetContent"


    // $ANTLR start "ruleTargetContent"
    // InternalTargetPlatform.g:132:1: ruleTargetContent returns [EObject current=null] : (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation ) ;
    public final EObject ruleTargetContent() throws RecognitionException {
        EObject current = null;

        EObject this_Options_0 = null;

        EObject this_Environment_1 = null;

        EObject this_IncludeDeclaration_2 = null;

        EObject this_Location_3 = null;



        	enterRule();

        try {
            // InternalTargetPlatform.g:138:2: ( (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation ) )
            // InternalTargetPlatform.g:139:2: (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation )
            {
            // InternalTargetPlatform.g:139:2: (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 16:
                {
                alt3=3;
                }
                break;
            case 17:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalTargetPlatform.g:140:3: this_Options_0= ruleOptions
                    {

                    			newCompositeNode(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Options_0=ruleOptions();

                    state._fsp--;


                    			current = this_Options_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:149:3: this_Environment_1= ruleEnvironment
                    {

                    			newCompositeNode(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Environment_1=ruleEnvironment();

                    state._fsp--;


                    			current = this_Environment_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTargetPlatform.g:158:3: this_IncludeDeclaration_2= ruleIncludeDeclaration
                    {

                    			newCompositeNode(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_IncludeDeclaration_2=ruleIncludeDeclaration();

                    state._fsp--;


                    			current = this_IncludeDeclaration_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTargetPlatform.g:167:3: this_Location_3= ruleLocation
                    {

                    			newCompositeNode(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Location_3=ruleLocation();

                    state._fsp--;


                    			current = this_Location_3;
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
        }
        return current;
    }
    // $ANTLR end "ruleTargetContent"


    // $ANTLR start "entryRuleOptions"
    // InternalTargetPlatform.g:179:1: entryRuleOptions returns [EObject current=null] : iv_ruleOptions= ruleOptions EOF ;
    public final EObject entryRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptions = null;


        try {
            // InternalTargetPlatform.g:179:48: (iv_ruleOptions= ruleOptions EOF )
            // InternalTargetPlatform.g:180:2: iv_ruleOptions= ruleOptions EOF
            {
             newCompositeNode(grammarAccess.getOptionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptions=ruleOptions();

            state._fsp--;

             current =iv_ruleOptions; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOptions"


    // $ANTLR start "ruleOptions"
    // InternalTargetPlatform.g:186:1: ruleOptions returns [EObject current=null] : (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_options_1_0 = null;

        Enumerator lv_options_3_0 = null;



        	enterRule();

        try {
            // InternalTargetPlatform.g:192:2: ( (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* ) )
            // InternalTargetPlatform.g:193:2: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* )
            {
            // InternalTargetPlatform.g:193:2: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* )
            // InternalTargetPlatform.g:194:3: otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getOptionsAccess().getWithKeyword_0());
            		
            // InternalTargetPlatform.g:198:3: ( (lv_options_1_0= ruleOption ) )
            // InternalTargetPlatform.g:199:4: (lv_options_1_0= ruleOption )
            {
            // InternalTargetPlatform.g:199:4: (lv_options_1_0= ruleOption )
            // InternalTargetPlatform.g:200:5: lv_options_1_0= ruleOption
            {

            					newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_options_1_0=ruleOption();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOptionsRule());
            					}
            					add(
            						current,
            						"options",
            						lv_options_1_0,
            						"org.eclipse.cbi.targetplatform.TargetPlatform.Option");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTargetPlatform.g:217:3: ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14||(LA5_0>=29 && LA5_0<=32)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalTargetPlatform.g:218:4: (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) )
            	    {
            	    // InternalTargetPlatform.g:218:4: (otherlv_2= ',' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==14) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // InternalTargetPlatform.g:219:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,14,FOLLOW_5); 

            	            					newLeafNode(otherlv_2, grammarAccess.getOptionsAccess().getCommaKeyword_2_0());
            	            				

            	            }
            	            break;

            	    }

            	    // InternalTargetPlatform.g:224:4: ( (lv_options_3_0= ruleOption ) )
            	    // InternalTargetPlatform.g:225:5: (lv_options_3_0= ruleOption )
            	    {
            	    // InternalTargetPlatform.g:225:5: (lv_options_3_0= ruleOption )
            	    // InternalTargetPlatform.g:226:6: lv_options_3_0= ruleOption
            	    {

            	    						newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_options_3_0=ruleOption();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOptionsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"options",
            	    							lv_options_3_0,
            	    							"org.eclipse.cbi.targetplatform.TargetPlatform.Option");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleOptions"


    // $ANTLR start "entryRuleEnvironment"
    // InternalTargetPlatform.g:248:1: entryRuleEnvironment returns [EObject current=null] : iv_ruleEnvironment= ruleEnvironment EOF ;
    public final EObject entryRuleEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnvironment = null;


        try {
            // InternalTargetPlatform.g:248:52: (iv_ruleEnvironment= ruleEnvironment EOF )
            // InternalTargetPlatform.g:249:2: iv_ruleEnvironment= ruleEnvironment EOF
            {
             newCompositeNode(grammarAccess.getEnvironmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnvironment=ruleEnvironment();

            state._fsp--;

             current =iv_ruleEnvironment; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEnvironment"


    // $ANTLR start "ruleEnvironment"
    // InternalTargetPlatform.g:255:1: ruleEnvironment returns [EObject current=null] : ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_env_2_0=null;
        Token otherlv_3=null;
        Token lv_env_4_0=null;


        	enterRule();

        try {
            // InternalTargetPlatform.g:261:2: ( ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* ) )
            // InternalTargetPlatform.g:262:2: ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* )
            {
            // InternalTargetPlatform.g:262:2: ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* )
            // InternalTargetPlatform.g:263:3: () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )*
            {
            // InternalTargetPlatform.g:263:3: ()
            // InternalTargetPlatform.g:264:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnvironmentAccess().getEnvironmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1());
            		
            // InternalTargetPlatform.g:274:3: ( (lv_env_2_0= RULE_ID ) )
            // InternalTargetPlatform.g:275:4: (lv_env_2_0= RULE_ID )
            {
            // InternalTargetPlatform.g:275:4: (lv_env_2_0= RULE_ID )
            // InternalTargetPlatform.g:276:5: lv_env_2_0= RULE_ID
            {
            lv_env_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_env_2_0, grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnvironmentRule());
            					}
            					addWithLastConsumed(
            						current,
            						"env",
            						lv_env_2_0,
            						"org.eclipse.cbi.targetplatform.TargetPlatform.ID");
            				

            }


            }

            // InternalTargetPlatform.g:292:3: ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalTargetPlatform.g:293:4: (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) )
            	    {
            	    // InternalTargetPlatform.g:293:4: (otherlv_3= ',' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==14) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalTargetPlatform.g:294:5: otherlv_3= ','
            	            {
            	            otherlv_3=(Token)match(input,14,FOLLOW_7); 

            	            					newLeafNode(otherlv_3, grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0());
            	            				

            	            }
            	            break;

            	    }

            	    // InternalTargetPlatform.g:299:4: ( (lv_env_4_0= RULE_ID ) )
            	    // InternalTargetPlatform.g:300:5: (lv_env_4_0= RULE_ID )
            	    {
            	    // InternalTargetPlatform.g:300:5: (lv_env_4_0= RULE_ID )
            	    // InternalTargetPlatform.g:301:6: lv_env_4_0= RULE_ID
            	    {
            	    lv_env_4_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(lv_env_4_0, grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getEnvironmentRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"env",
            	    							lv_env_4_0,
            	    							"org.eclipse.cbi.targetplatform.TargetPlatform.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleEnvironment"


    // $ANTLR start "entryRuleIncludeDeclaration"
    // InternalTargetPlatform.g:322:1: entryRuleIncludeDeclaration returns [EObject current=null] : iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF ;
    public final EObject entryRuleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDeclaration = null;


        try {
            // InternalTargetPlatform.g:322:59: (iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF )
            // InternalTargetPlatform.g:323:2: iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF
            {
             newCompositeNode(grammarAccess.getIncludeDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncludeDeclaration=ruleIncludeDeclaration();

            state._fsp--;

             current =iv_ruleIncludeDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIncludeDeclaration"


    // $ANTLR start "ruleIncludeDeclaration"
    // InternalTargetPlatform.g:329:1: ruleIncludeDeclaration returns [EObject current=null] : (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;


        	enterRule();

        try {
            // InternalTargetPlatform.g:335:2: ( (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalTargetPlatform.g:336:2: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalTargetPlatform.g:336:2: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalTargetPlatform.g:337:3: otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0());
            		
            // InternalTargetPlatform.g:341:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalTargetPlatform.g:342:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalTargetPlatform.g:342:4: (lv_importURI_1_0= RULE_STRING )
            // InternalTargetPlatform.g:343:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_importURI_1_0, grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIncludeDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


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
    // $ANTLR end "ruleIncludeDeclaration"


    // $ANTLR start "entryRuleLocation"
    // InternalTargetPlatform.g:363:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // InternalTargetPlatform.g:363:49: (iv_ruleLocation= ruleLocation EOF )
            // InternalTargetPlatform.g:364:2: iv_ruleLocation= ruleLocation EOF
            {
             newCompositeNode(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocation=ruleLocation();

            state._fsp--;

             current =iv_ruleLocation; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:370:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) ;
    public final EObject ruleLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_ID_2_0=null;
        Token lv_uri_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Enumerator lv_options_6_0 = null;

        Enumerator lv_options_8_0 = null;

        EObject lv_ius_9_0 = null;



        	enterRule();

        try {
            // InternalTargetPlatform.g:376:2: ( (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) )
            // InternalTargetPlatform.g:377:2: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            {
            // InternalTargetPlatform.g:377:2: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            // InternalTargetPlatform.g:378:3: otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
            		
            // InternalTargetPlatform.g:382:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            // InternalTargetPlatform.g:383:4: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            {
            // InternalTargetPlatform.g:383:4: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            // InternalTargetPlatform.g:384:5: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            				
            // InternalTargetPlatform.g:387:5: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            // InternalTargetPlatform.g:388:6: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?
            {
            // InternalTargetPlatform.g:388:6: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( LA8_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                    alt8=1;
                }
                else if ( LA8_0 == RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalTargetPlatform.g:389:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // InternalTargetPlatform.g:389:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    // InternalTargetPlatform.g:390:5: {...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalTargetPlatform.g:390:105: ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    // InternalTargetPlatform.g:391:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // InternalTargetPlatform.g:394:9: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    // InternalTargetPlatform.g:394:10: {...}? => ( (lv_ID_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // InternalTargetPlatform.g:394:19: ( (lv_ID_2_0= RULE_ID ) )
            	    // InternalTargetPlatform.g:394:20: (lv_ID_2_0= RULE_ID )
            	    {
            	    // InternalTargetPlatform.g:394:20: (lv_ID_2_0= RULE_ID )
            	    // InternalTargetPlatform.g:395:10: lv_ID_2_0= RULE_ID
            	    {
            	    lv_ID_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            	    										newLeafNode(lv_ID_2_0, grammarAccess.getLocationAccess().getIDIDTerminalRuleCall_1_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getLocationRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"ID",
            	    											lv_ID_2_0,
            	    											"org.eclipse.cbi.targetplatform.TargetPlatform.ID");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTargetPlatform.g:416:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // InternalTargetPlatform.g:416:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    // InternalTargetPlatform.g:417:5: {...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalTargetPlatform.g:417:105: ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    // InternalTargetPlatform.g:418:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // InternalTargetPlatform.g:421:9: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    // InternalTargetPlatform.g:421:10: {...}? => ( (lv_uri_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // InternalTargetPlatform.g:421:19: ( (lv_uri_3_0= RULE_STRING ) )
            	    // InternalTargetPlatform.g:421:20: (lv_uri_3_0= RULE_STRING )
            	    {
            	    // InternalTargetPlatform.g:421:20: (lv_uri_3_0= RULE_STRING )
            	    // InternalTargetPlatform.g:422:10: lv_uri_3_0= RULE_STRING
            	    {
            	    lv_uri_3_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    										newLeafNode(lv_uri_3_0, grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getLocationRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"uri",
            	    											lv_uri_3_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            				

            }

            // InternalTargetPlatform.g:451:3: (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTargetPlatform.g:452:4: otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalTargetPlatform.g:456:4: (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==13) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalTargetPlatform.g:457:5: otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            {
                            otherlv_5=(Token)match(input,13,FOLLOW_5); 

                            					newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getWithKeyword_2_1_0());
                            				
                            // InternalTargetPlatform.g:461:5: ( (lv_options_6_0= ruleOption ) )
                            // InternalTargetPlatform.g:462:6: (lv_options_6_0= ruleOption )
                            {
                            // InternalTargetPlatform.g:462:6: (lv_options_6_0= ruleOption )
                            // InternalTargetPlatform.g:463:7: lv_options_6_0= ruleOption
                            {

                            							newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0());
                            						
                            pushFollow(FOLLOW_12);
                            lv_options_6_0=ruleOption();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getLocationRule());
                            							}
                            							add(
                            								current,
                            								"options",
                            								lv_options_6_0,
                            								"org.eclipse.cbi.targetplatform.TargetPlatform.Option");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalTargetPlatform.g:480:5: ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==14||(LA10_0>=29 && LA10_0<=32)) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // InternalTargetPlatform.g:481:6: (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) )
                            	    {
                            	    // InternalTargetPlatform.g:481:6: (otherlv_7= ',' )?
                            	    int alt9=2;
                            	    int LA9_0 = input.LA(1);

                            	    if ( (LA9_0==14) ) {
                            	        alt9=1;
                            	    }
                            	    switch (alt9) {
                            	        case 1 :
                            	            // InternalTargetPlatform.g:482:7: otherlv_7= ','
                            	            {
                            	            otherlv_7=(Token)match(input,14,FOLLOW_5); 

                            	            							newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
                            	            						

                            	            }
                            	            break;

                            	    }

                            	    // InternalTargetPlatform.g:487:6: ( (lv_options_8_0= ruleOption ) )
                            	    // InternalTargetPlatform.g:488:7: (lv_options_8_0= ruleOption )
                            	    {
                            	    // InternalTargetPlatform.g:488:7: (lv_options_8_0= ruleOption )
                            	    // InternalTargetPlatform.g:489:8: lv_options_8_0= ruleOption
                            	    {

                            	    								newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0());
                            	    							
                            	    pushFollow(FOLLOW_12);
                            	    lv_options_8_0=ruleOption();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getLocationRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"options",
                            	    									lv_options_8_0,
                            	    									"org.eclipse.cbi.targetplatform.TargetPlatform.Option");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalTargetPlatform.g:508:4: ( (lv_ius_9_0= ruleIU ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalTargetPlatform.g:509:5: (lv_ius_9_0= ruleIU )
                    	    {
                    	    // InternalTargetPlatform.g:509:5: (lv_ius_9_0= ruleIU )
                    	    // InternalTargetPlatform.g:510:6: lv_ius_9_0= ruleIU
                    	    {

                    	    						newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_ius_9_0=ruleIU();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLocationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"ius",
                    	    							lv_ius_9_0,
                    	    							"org.eclipse.cbi.targetplatform.TargetPlatform.IU");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3());
                    			

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
    // InternalTargetPlatform.g:536:1: entryRuleIU returns [EObject current=null] : iv_ruleIU= ruleIU EOF ;
    public final EObject entryRuleIU() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIU = null;


        try {
            // InternalTargetPlatform.g:536:43: (iv_ruleIU= ruleIU EOF )
            // InternalTargetPlatform.g:537:2: iv_ruleIU= ruleIU EOF
            {
             newCompositeNode(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIU=ruleIU();

            state._fsp--;

             current =iv_ruleIU; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:543:1: ruleIU returns [EObject current=null] : ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) ;
    public final EObject ruleIU() throws RecognitionException {
        EObject current = null;

        Token lv_ID_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_version_5_0=null;
        AntlrDatatypeRuleToken lv_version_4_0 = null;



        	enterRule();

        try {
            // InternalTargetPlatform.g:549:2: ( ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) )
            // InternalTargetPlatform.g:550:2: ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            {
            // InternalTargetPlatform.g:550:2: ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            // InternalTargetPlatform.g:551:3: ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            {
            // InternalTargetPlatform.g:551:3: ( (lv_ID_0_0= RULE_ID ) )
            // InternalTargetPlatform.g:552:4: (lv_ID_0_0= RULE_ID )
            {
            // InternalTargetPlatform.g:552:4: (lv_ID_0_0= RULE_ID )
            // InternalTargetPlatform.g:553:5: lv_ID_0_0= RULE_ID
            {
            lv_ID_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_ID_0_0, grammarAccess.getIUAccess().getIDIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIURule());
            					}
            					setWithLastConsumed(
            						current,
            						"ID",
            						lv_ID_0_0,
            						"org.eclipse.cbi.targetplatform.TargetPlatform.ID");
            				

            }


            }

            // InternalTargetPlatform.g:569:3: ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING||LA16_0==RULE_INT||LA16_0==20||(LA16_0>=24 && LA16_0<=25)||LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTargetPlatform.g:570:4: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    {
                    // InternalTargetPlatform.g:570:4: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==20) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalTargetPlatform.g:571:5: otherlv_1= ';' otherlv_2= 'version' otherlv_3= '='
                            {
                            otherlv_1=(Token)match(input,20,FOLLOW_15); 

                            					newLeafNode(otherlv_1, grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0());
                            				
                            otherlv_2=(Token)match(input,21,FOLLOW_16); 

                            					newLeafNode(otherlv_2, grammarAccess.getIUAccess().getVersionKeyword_1_0_1());
                            				
                            otherlv_3=(Token)match(input,22,FOLLOW_17); 

                            					newLeafNode(otherlv_3, grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2());
                            				

                            }
                            break;

                    }

                    // InternalTargetPlatform.g:584:4: ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_INT||(LA15_0>=24 && LA15_0<=25)||LA15_0==28) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==RULE_STRING) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalTargetPlatform.g:585:5: ( (lv_version_4_0= ruleVersionRange ) )
                            {
                            // InternalTargetPlatform.g:585:5: ( (lv_version_4_0= ruleVersionRange ) )
                            // InternalTargetPlatform.g:586:6: (lv_version_4_0= ruleVersionRange )
                            {
                            // InternalTargetPlatform.g:586:6: (lv_version_4_0= ruleVersionRange )
                            // InternalTargetPlatform.g:587:7: lv_version_4_0= ruleVersionRange
                            {

                            							newCompositeNode(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_version_4_0=ruleVersionRange();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getIURule());
                            							}
                            							set(
                            								current,
                            								"version",
                            								lv_version_4_0,
                            								"org.eclipse.cbi.targetplatform.TargetPlatform.VersionRange");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTargetPlatform.g:605:5: ( (lv_version_5_0= RULE_STRING ) )
                            {
                            // InternalTargetPlatform.g:605:5: ( (lv_version_5_0= RULE_STRING ) )
                            // InternalTargetPlatform.g:606:6: (lv_version_5_0= RULE_STRING )
                            {
                            // InternalTargetPlatform.g:606:6: (lv_version_5_0= RULE_STRING )
                            // InternalTargetPlatform.g:607:7: lv_version_5_0= RULE_STRING
                            {
                            lv_version_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                            							newLeafNode(lv_version_5_0, grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_1_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getIURule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"version",
                            								lv_version_5_0,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

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


    // $ANTLR start "entryRuleVersion"
    // InternalTargetPlatform.g:629:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalTargetPlatform.g:631:2: (iv_ruleVersion= ruleVersion EOF )
            // InternalTargetPlatform.g:632:2: iv_ruleVersion= ruleVersion EOF
            {
             newCompositeNode(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVersion=ruleVersion();

            state._fsp--;

             current =iv_ruleVersion.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:641:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? ) ;
    public final AntlrDatatypeRuleToken ruleVersion() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_ID_6=null;
        Token this_INT_7=null;
        Token this_QUALIFIER_8=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalTargetPlatform.g:648:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? ) )
            // InternalTargetPlatform.g:649:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? )
            {
            // InternalTargetPlatform.g:649:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? )
            // InternalTargetPlatform.g:650:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0());
            		
            // InternalTargetPlatform.g:657:3: (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==23) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTargetPlatform.g:658:4: kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )?
                    {
                    kw=(Token)match(input,23,FOLLOW_19); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_0());
                    			
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_18); 

                    				current.merge(this_INT_2);
                    			

                    				newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1());
                    			
                    // InternalTargetPlatform.g:670:4: (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==23) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalTargetPlatform.g:671:5: kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )?
                            {
                            kw=(Token)match(input,23,FOLLOW_19); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0());
                            				
                            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_18); 

                            					current.merge(this_INT_4);
                            				

                            					newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1());
                            				
                            // InternalTargetPlatform.g:683:5: (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )?
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==23) ) {
                                alt18=1;
                            }
                            switch (alt18) {
                                case 1 :
                                    // InternalTargetPlatform.g:684:6: kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER )
                                    {
                                    kw=(Token)match(input,23,FOLLOW_20); 

                                    						current.merge(kw);
                                    						newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0());
                                    					
                                    // InternalTargetPlatform.g:689:6: (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER )
                                    int alt17=3;
                                    switch ( input.LA(1) ) {
                                    case RULE_ID:
                                        {
                                        alt17=1;
                                        }
                                        break;
                                    case RULE_INT:
                                        {
                                        alt17=2;
                                        }
                                        break;
                                    case RULE_QUALIFIER:
                                        {
                                        alt17=3;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 17, 0, input);

                                        throw nvae;
                                    }

                                    switch (alt17) {
                                        case 1 :
                                            // InternalTargetPlatform.g:690:7: this_ID_6= RULE_ID
                                            {
                                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_2); 

                                            							current.merge(this_ID_6);
                                            						

                                            							newLeafNode(this_ID_6, grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0());
                                            						

                                            }
                                            break;
                                        case 2 :
                                            // InternalTargetPlatform.g:698:7: this_INT_7= RULE_INT
                                            {
                                            this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                                            							current.merge(this_INT_7);
                                            						

                                            							newLeafNode(this_INT_7, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1());
                                            						

                                            }
                                            break;
                                        case 3 :
                                            // InternalTargetPlatform.g:706:7: this_QUALIFIER_8= RULE_QUALIFIER
                                            {
                                            this_QUALIFIER_8=(Token)match(input,RULE_QUALIFIER,FOLLOW_2); 

                                            							current.merge(this_QUALIFIER_8);
                                            						

                                            							newLeafNode(this_QUALIFIER_8, grammarAccess.getVersionAccess().getQUALIFIERTerminalRuleCall_1_2_2_1_2());
                                            						

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleVersionRange"
    // InternalTargetPlatform.g:724:1: entryRuleVersionRange returns [String current=null] : iv_ruleVersionRange= ruleVersionRange EOF ;
    public final String entryRuleVersionRange() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionRange = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalTargetPlatform.g:726:2: (iv_ruleVersionRange= ruleVersionRange EOF )
            // InternalTargetPlatform.g:727:2: iv_ruleVersionRange= ruleVersionRange EOF
            {
             newCompositeNode(grammarAccess.getVersionRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVersionRange=ruleVersionRange();

            state._fsp--;

             current =iv_ruleVersionRange.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:736:1: ruleVersionRange returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) ;
    public final AntlrDatatypeRuleToken ruleVersionRange() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Version_2 = null;

        AntlrDatatypeRuleToken this_Version_4 = null;

        AntlrDatatypeRuleToken this_Version_7 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalTargetPlatform.g:743:2: ( ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) )
            // InternalTargetPlatform.g:744:2: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            {
            // InternalTargetPlatform.g:744:2: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 24:
            case 25:
                {
                alt23=1;
                }
                break;
            case RULE_INT:
                {
                alt23=2;
                }
                break;
            case 28:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalTargetPlatform.g:745:3: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    {
                    // InternalTargetPlatform.g:745:3: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    // InternalTargetPlatform.g:746:4: (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' )
                    {
                    // InternalTargetPlatform.g:746:4: (kw= '(' | kw= '[' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==24) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==25) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalTargetPlatform.g:747:5: kw= '('
                            {
                            kw=(Token)match(input,24,FOLLOW_19); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalTargetPlatform.g:753:5: kw= '['
                            {
                            kw=(Token)match(input,25,FOLLOW_19); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1());
                            				

                            }
                            break;

                    }


                    				newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_21);
                    this_Version_2=ruleVersion();

                    state._fsp--;


                    				current.merge(this_Version_2);
                    			

                    				afterParserOrEnumRuleCall();
                    			
                    kw=(Token)match(input,14,FOLLOW_19); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2());
                    			

                    				newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3());
                    			
                    pushFollow(FOLLOW_22);
                    this_Version_4=ruleVersion();

                    state._fsp--;


                    				current.merge(this_Version_4);
                    			

                    				afterParserOrEnumRuleCall();
                    			
                    // InternalTargetPlatform.g:784:4: (kw= ')' | kw= ']' )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==26) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==27) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalTargetPlatform.g:785:5: kw= ')'
                            {
                            kw=(Token)match(input,26,FOLLOW_2); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalTargetPlatform.g:791:5: kw= ']'
                            {
                            kw=(Token)match(input,27,FOLLOW_2); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:799:3: this_Version_7= ruleVersion
                    {

                    			newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Version_7=ruleVersion();

                    state._fsp--;


                    			current.merge(this_Version_7);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTargetPlatform.g:810:3: kw= 'lazy'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLazyKeyword_2());
                    		

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


    // $ANTLR start "ruleOption"
    // InternalTargetPlatform.g:822:1: ruleOption returns [Enumerator current=null] : ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) ;
    public final Enumerator ruleOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTargetPlatform.g:828:2: ( ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) )
            // InternalTargetPlatform.g:829:2: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            {
            // InternalTargetPlatform.g:829:2: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt24=1;
                }
                break;
            case 30:
                {
                alt24=2;
                }
                break;
            case 31:
                {
                alt24=3;
                }
                break;
            case 32:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalTargetPlatform.g:830:3: (enumLiteral_0= 'requirements' )
                    {
                    // InternalTargetPlatform.g:830:3: (enumLiteral_0= 'requirements' )
                    // InternalTargetPlatform.g:831:4: enumLiteral_0= 'requirements'
                    {
                    enumLiteral_0=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:838:3: (enumLiteral_1= 'allEnvironments' )
                    {
                    // InternalTargetPlatform.g:838:3: (enumLiteral_1= 'allEnvironments' )
                    // InternalTargetPlatform.g:839:4: enumLiteral_1= 'allEnvironments'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTargetPlatform.g:846:3: (enumLiteral_2= 'source' )
                    {
                    // InternalTargetPlatform.g:846:3: (enumLiteral_2= 'source' )
                    // InternalTargetPlatform.g:847:4: enumLiteral_2= 'source'
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTargetPlatform.g:854:3: (enumLiteral_3= 'configurePhase' )
                    {
                    // InternalTargetPlatform.g:854:3: (enumLiteral_3= 'configurePhase' )
                    // InternalTargetPlatform.g:855:4: enumLiteral_3= 'configurePhase'
                    {
                    enumLiteral_3=(Token)match(input,32,FOLLOW_2); 

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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000003A002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000001E0000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000001E0004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004022L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040032L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000082020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000001E0084020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000013100052L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000013000050L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000000C000000L});

}
