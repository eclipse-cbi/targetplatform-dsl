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
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=10;
    public static final int RULE_QUALIFIER=7;

    // delegates
    // delegators


        public InternalTargetPlatformParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTargetPlatformParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTargetPlatformParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g"; }



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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:68:1: entryRuleTargetPlatform returns [EObject current=null] : iv_ruleTargetPlatform= ruleTargetPlatform EOF ;
    public final EObject entryRuleTargetPlatform() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetPlatform = null;


        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:69:2: (iv_ruleTargetPlatform= ruleTargetPlatform EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:70:2: iv_ruleTargetPlatform= ruleTargetPlatform EOF
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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:77:1: ruleTargetPlatform returns [EObject current=null] : (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )? ;
    public final EObject ruleTargetPlatform() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_contents_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:80:28: ( (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )? )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:1: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )?
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:1: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:3: otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )*
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleTargetPlatform122); 

                        	newLeafNode(otherlv_0, grammarAccess.getTargetPlatformAccess().getTargetKeyword_0());
                        
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:85:1: ( (lv_name_1_0= RULE_STRING ) )
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:86:1: (lv_name_1_0= RULE_STRING )
                    {
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:86:1: (lv_name_1_0= RULE_STRING )
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:87:3: lv_name_1_0= RULE_STRING
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

                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:103:2: ( (lv_contents_2_0= ruleTargetContent ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13||(LA1_0>=15 && LA1_0<=17)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:104:1: (lv_contents_2_0= ruleTargetContent )
                    	    {
                    	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:104:1: (lv_contents_2_0= ruleTargetContent )
                    	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:105:3: lv_contents_2_0= ruleTargetContent
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTargetPlatformAccess().getContentsTargetContentParserRuleCall_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTargetContent_in_ruleTargetPlatform165);
                    	    lv_contents_2_0=ruleTargetContent();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTargetPlatformRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"contents",
                    	            		lv_contents_2_0, 
                    	            		"TargetContent");
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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:129:1: entryRuleTargetContent returns [EObject current=null] : iv_ruleTargetContent= ruleTargetContent EOF ;
    public final EObject entryRuleTargetContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetContent = null;


        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:130:2: (iv_ruleTargetContent= ruleTargetContent EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:131:2: iv_ruleTargetContent= ruleTargetContent EOF
            {
             newCompositeNode(grammarAccess.getTargetContentRule()); 
            pushFollow(FOLLOW_ruleTargetContent_in_entryRuleTargetContent203);
            iv_ruleTargetContent=ruleTargetContent();

            state._fsp--;

             current =iv_ruleTargetContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTargetContent213); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:138:1: ruleTargetContent returns [EObject current=null] : (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation ) ;
    public final EObject ruleTargetContent() throws RecognitionException {
        EObject current = null;

        EObject this_Options_0 = null;

        EObject this_Environment_1 = null;

        EObject this_IncludeDeclaration_2 = null;

        EObject this_Location_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:141:28: ( (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:142:1: (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:142:1: (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation )
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
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:143:5: this_Options_0= ruleOptions
                    {
                     
                            newCompositeNode(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleOptions_in_ruleTargetContent260);
                    this_Options_0=ruleOptions();

                    state._fsp--;

                     
                            current = this_Options_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:153:5: this_Environment_1= ruleEnvironment
                    {
                     
                            newCompositeNode(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnvironment_in_ruleTargetContent287);
                    this_Environment_1=ruleEnvironment();

                    state._fsp--;

                     
                            current = this_Environment_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:163:5: this_IncludeDeclaration_2= ruleIncludeDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleIncludeDeclaration_in_ruleTargetContent314);
                    this_IncludeDeclaration_2=ruleIncludeDeclaration();

                    state._fsp--;

                     
                            current = this_IncludeDeclaration_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:173:5: this_Location_3= ruleLocation
                    {
                     
                            newCompositeNode(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleLocation_in_ruleTargetContent341);
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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:189:1: entryRuleOptions returns [EObject current=null] : iv_ruleOptions= ruleOptions EOF ;
    public final EObject entryRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptions = null;


        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:190:2: (iv_ruleOptions= ruleOptions EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:191:2: iv_ruleOptions= ruleOptions EOF
            {
             newCompositeNode(grammarAccess.getOptionsRule()); 
            pushFollow(FOLLOW_ruleOptions_in_entryRuleOptions376);
            iv_ruleOptions=ruleOptions();

            state._fsp--;

             current =iv_ruleOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptions386); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:198:1: ruleOptions returns [EObject current=null] : (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_options_1_0 = null;

        Enumerator lv_options_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:201:28: ( (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:1: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:1: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:3: otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleOptions423); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionsAccess().getWithKeyword_0());
                
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:206:1: ( (lv_options_1_0= ruleOption ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:207:1: (lv_options_1_0= ruleOption )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:207:1: (lv_options_1_0= ruleOption )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:208:3: lv_options_1_0= ruleOption
            {
             
            	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleOption_in_ruleOptions444);
            lv_options_1_0=ruleOption();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionsRule());
            	        }
                   		add(
                   			current, 
                   			"options",
                    		lv_options_1_0, 
                    		"Option");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:2: ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14||(LA5_0>=29 && LA5_0<=32)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:3: (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) )
            	    {
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:3: (otherlv_2= ',' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==14) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleOptions458); 

            	                	newLeafNode(otherlv_2, grammarAccess.getOptionsAccess().getCommaKeyword_2_0());
            	                

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:228:3: ( (lv_options_3_0= ruleOption ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:229:1: (lv_options_3_0= ruleOption )
            	    {
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:229:1: (lv_options_3_0= ruleOption )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:230:3: lv_options_3_0= ruleOption
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOption_in_ruleOptions481);
            	    lv_options_3_0=ruleOption();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOptionsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"options",
            	            		lv_options_3_0, 
            	            		"Option");
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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:254:1: entryRuleEnvironment returns [EObject current=null] : iv_ruleEnvironment= ruleEnvironment EOF ;
    public final EObject entryRuleEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnvironment = null;


        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:255:2: (iv_ruleEnvironment= ruleEnvironment EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:256:2: iv_ruleEnvironment= ruleEnvironment EOF
            {
             newCompositeNode(grammarAccess.getEnvironmentRule()); 
            pushFollow(FOLLOW_ruleEnvironment_in_entryRuleEnvironment519);
            iv_ruleEnvironment=ruleEnvironment();

            state._fsp--;

             current =iv_ruleEnvironment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnvironment529); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:263:1: ruleEnvironment returns [EObject current=null] : ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_env_2_0=null;
        Token otherlv_3=null;
        Token lv_env_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:266:28: ( ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:1: ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:1: ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:2: () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:2: ()
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:268:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEnvironmentAccess().getEnvironmentAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleEnvironment575); 

                	newLeafNode(otherlv_1, grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1());
                
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:1: ( (lv_env_2_0= RULE_ID ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:278:1: (lv_env_2_0= RULE_ID )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:278:1: (lv_env_2_0= RULE_ID )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:279:3: lv_env_2_0= RULE_ID
            {
            lv_env_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment592); 

            			newLeafNode(lv_env_2_0, grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnvironmentRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"env",
                    		lv_env_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:295:2: ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:295:3: (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:295:3: (otherlv_3= ',' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==14) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:295:5: otherlv_3= ','
            	            {
            	            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleEnvironment611); 

            	                	newLeafNode(otherlv_3, grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0());
            	                

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:299:3: ( (lv_env_4_0= RULE_ID ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:300:1: (lv_env_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:300:1: (lv_env_4_0= RULE_ID )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:301:3: lv_env_4_0= RULE_ID
            	    {
            	    lv_env_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment630); 

            	    			newLeafNode(lv_env_4_0, grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEnvironmentRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"env",
            	            		lv_env_4_0, 
            	            		"ID");
            	    	    

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:325:1: entryRuleIncludeDeclaration returns [EObject current=null] : iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF ;
    public final EObject entryRuleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDeclaration = null;


        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:326:2: (iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:327:2: iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF
            {
             newCompositeNode(grammarAccess.getIncludeDeclarationRule()); 
            pushFollow(FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration673);
            iv_ruleIncludeDeclaration=ruleIncludeDeclaration();

            state._fsp--;

             current =iv_ruleIncludeDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDeclaration683); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:334:1: ruleIncludeDeclaration returns [EObject current=null] : (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:337:28: ( (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:338:1: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:338:1: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:338:3: otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleIncludeDeclaration720); 

                	newLeafNode(otherlv_0, grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0());
                
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:342:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:343:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:343:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:344:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIncludeDeclaration737); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIncludeDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"STRING");
            	    

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:368:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:369:2: (iv_ruleLocation= ruleLocation EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:370:2: iv_ruleLocation= ruleLocation EOF
            {
             newCompositeNode(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation778);
            iv_ruleLocation=ruleLocation();

            state._fsp--;

             current =iv_ruleLocation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation788); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:377:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) ;
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
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:380:28: ( (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:381:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:381:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:381:3: otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleLocation825); 

                	newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
                
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:385:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:387:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:387:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:388:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:391:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:392:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:392:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( LA8_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                    alt8=1;
                }
                else if ( LA8_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:394:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:394:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:395:5: {...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:395:105: ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:396:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:399:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:399:7: {...}? => ( (lv_ID_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:399:16: ( (lv_ID_2_0= RULE_ID ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:400:1: (lv_ID_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:400:1: (lv_ID_2_0= RULE_ID )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:401:3: lv_ID_2_0= RULE_ID
            	    {
            	    lv_ID_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocation887); 

            	    			newLeafNode(lv_ID_2_0, grammarAccess.getLocationAccess().getIDIDTerminalRuleCall_1_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLocationRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"ID",
            	            		lv_ID_2_0, 
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
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:424:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:424:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:425:5: {...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:425:105: ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:426:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:429:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:429:7: {...}? => ( (lv_uri_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:429:16: ( (lv_uri_3_0= RULE_STRING ) )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:430:1: (lv_uri_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:430:1: (lv_uri_3_0= RULE_STRING )
            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:431:3: lv_uri_3_0= RULE_STRING
            	    {
            	    lv_uri_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLocation963); 

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

            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:462:2: (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:462:4: otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleLocation1027); 

                        	newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0());
                        
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:466:1: (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==13) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:466:3: otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            {
                            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleLocation1040); 

                                	newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getWithKeyword_2_1_0());
                                
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:470:1: ( (lv_options_6_0= ruleOption ) )
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:471:1: (lv_options_6_0= ruleOption )
                            {
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:471:1: (lv_options_6_0= ruleOption )
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:472:3: lv_options_6_0= ruleOption
                            {
                             
                            	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleOption_in_ruleLocation1061);
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

                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:488:2: ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==14||(LA10_0>=29 && LA10_0<=32)) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:488:3: (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) )
                            	    {
                            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:488:3: (otherlv_7= ',' )?
                            	    int alt9=2;
                            	    int LA9_0 = input.LA(1);

                            	    if ( (LA9_0==14) ) {
                            	        alt9=1;
                            	    }
                            	    switch (alt9) {
                            	        case 1 :
                            	            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:488:5: otherlv_7= ','
                            	            {
                            	            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleLocation1075); 

                            	                	newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
                            	                

                            	            }
                            	            break;

                            	    }

                            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:492:3: ( (lv_options_8_0= ruleOption ) )
                            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:493:1: (lv_options_8_0= ruleOption )
                            	    {
                            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:493:1: (lv_options_8_0= ruleOption )
                            	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:494:3: lv_options_8_0= ruleOption
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleOption_in_ruleLocation1098);
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
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:510:6: ( (lv_ius_9_0= ruleIU ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:511:1: (lv_ius_9_0= ruleIU )
                    	    {
                    	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:511:1: (lv_ius_9_0= ruleIU )
                    	    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:512:3: lv_ius_9_0= ruleIU
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleIU_in_ruleLocation1123);
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
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_19_in_ruleLocation1136); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:540:1: entryRuleIU returns [EObject current=null] : iv_ruleIU= ruleIU EOF ;
    public final EObject entryRuleIU() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIU = null;


        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:541:2: (iv_ruleIU= ruleIU EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:542:2: iv_ruleIU= ruleIU EOF
            {
             newCompositeNode(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU1174);
            iv_ruleIU=ruleIU();

            state._fsp--;

             current =iv_ruleIU; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU1184); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:549:1: ruleIU returns [EObject current=null] : ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) ;
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
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:552:28: ( ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:553:1: ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:553:1: ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:553:2: ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:553:2: ( (lv_ID_0_0= RULE_ID ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:554:1: (lv_ID_0_0= RULE_ID )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:554:1: (lv_ID_0_0= RULE_ID )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:555:3: lv_ID_0_0= RULE_ID
            {
            lv_ID_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIU1226); 

            			newLeafNode(lv_ID_0_0, grammarAccess.getIUAccess().getIDIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIURule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ID",
                    		lv_ID_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:571:2: ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING||LA16_0==RULE_INT||LA16_0==20||(LA16_0>=24 && LA16_0<=25)||LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:571:3: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:571:3: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==20) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:571:5: otherlv_1= ';' otherlv_2= 'version' otherlv_3= '='
                            {
                            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleIU1245); 

                                	newLeafNode(otherlv_1, grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0());
                                
                            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleIU1257); 

                                	newLeafNode(otherlv_2, grammarAccess.getIUAccess().getVersionKeyword_1_0_1());
                                
                            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleIU1269); 

                                	newLeafNode(otherlv_3, grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2());
                                

                            }
                            break;

                    }

                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:583:3: ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
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
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:583:4: ( (lv_version_4_0= ruleVersionRange ) )
                            {
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:583:4: ( (lv_version_4_0= ruleVersionRange ) )
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:584:1: (lv_version_4_0= ruleVersionRange )
                            {
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:584:1: (lv_version_4_0= ruleVersionRange )
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:585:3: lv_version_4_0= ruleVersionRange
                            {
                             
                            	        newCompositeNode(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleVersionRange_in_ruleIU1293);
                            lv_version_4_0=ruleVersionRange();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getIURule());
                            	        }
                                   		set(
                                   			current, 
                                   			"version",
                                    		lv_version_4_0, 
                                    		"VersionRange");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:602:6: ( (lv_version_5_0= RULE_STRING ) )
                            {
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:602:6: ( (lv_version_5_0= RULE_STRING ) )
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:603:1: (lv_version_5_0= RULE_STRING )
                            {
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:603:1: (lv_version_5_0= RULE_STRING )
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:604:3: lv_version_5_0= RULE_STRING
                            {
                            lv_version_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIU1316); 

                            			newLeafNode(lv_version_5_0, grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_1_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getIURule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"version",
                                    		lv_version_5_0, 
                                    		"STRING");
                            	    

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:628:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:632:2: (iv_ruleVersion= ruleVersion EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:633:2: iv_ruleVersion= ruleVersion EOF
            {
             newCompositeNode(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion1367);
            iv_ruleVersion=ruleVersion();

            state._fsp--;

             current =iv_ruleVersion.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion1378); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:643:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? ) ;
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
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:647:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:648:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:648:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:648:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1422); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
                
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:655:1: (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==23) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:656:2: kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )?
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleVersion1441); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1456); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
                        
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:668:1: (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==23) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:669:2: kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )?
                            {
                            kw=(Token)match(input,23,FOLLOW_23_in_ruleVersion1475); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
                                
                            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1490); 

                            		current.merge(this_INT_4);
                                
                             
                                newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
                                
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:681:1: (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )?
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==23) ) {
                                alt18=1;
                            }
                            switch (alt18) {
                                case 1 :
                                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:682:2: kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER )
                                    {
                                    kw=(Token)match(input,23,FOLLOW_23_in_ruleVersion1509); 

                                            current.merge(kw);
                                            newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
                                        
                                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:687:1: (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER )
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
                                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:687:6: this_ID_6= RULE_ID
                                            {
                                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVersion1525); 

                                            		current.merge(this_ID_6);
                                                
                                             
                                                newLeafNode(this_ID_6, grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:695:10: this_INT_7= RULE_INT
                                            {
                                            this_INT_7=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1551); 

                                            		current.merge(this_INT_7);
                                                
                                             
                                                newLeafNode(this_INT_7, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 
                                                

                                            }
                                            break;
                                        case 3 :
                                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:703:10: this_QUALIFIER_8= RULE_QUALIFIER
                                            {
                                            this_QUALIFIER_8=(Token)match(input,RULE_QUALIFIER,FOLLOW_RULE_QUALIFIER_in_ruleVersion1577); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:721:1: entryRuleVersionRange returns [String current=null] : iv_ruleVersionRange= ruleVersionRange EOF ;
    public final String entryRuleVersionRange() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionRange = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:725:2: (iv_ruleVersionRange= ruleVersionRange EOF )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:726:2: iv_ruleVersionRange= ruleVersionRange EOF
            {
             newCompositeNode(grammarAccess.getVersionRangeRule()); 
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange1640);
            iv_ruleVersionRange=ruleVersionRange();

            state._fsp--;

             current =iv_ruleVersionRange.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange1651); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:736:1: ruleVersionRange returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) ;
    public final AntlrDatatypeRuleToken ruleVersionRange() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Version_2 = null;

        AntlrDatatypeRuleToken this_Version_4 = null;

        AntlrDatatypeRuleToken this_Version_7 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:740:28: ( ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:741:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:741:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
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
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:741:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    {
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:741:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:741:3: (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' )
                    {
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:741:3: (kw= '(' | kw= '[' )
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
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:742:2: kw= '('
                            {
                            kw=(Token)match(input,24,FOLLOW_24_in_ruleVersionRange1695); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:749:2: kw= '['
                            {
                            kw=(Token)match(input,25,FOLLOW_25_in_ruleVersionRange1714); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                                

                            }
                            break;

                    }

                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1737);
                    this_Version_2=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleVersionRange1755); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
                        
                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1777);
                    this_Version_4=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_4);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:782:1: (kw= ')' | kw= ']' )
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
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:783:2: kw= ')'
                            {
                            kw=(Token)match(input,26,FOLLOW_26_in_ruleVersionRange1796); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:790:2: kw= ']'
                            {
                            kw=(Token)match(input,27,FOLLOW_27_in_ruleVersionRange1815); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:797:5: this_Version_7= ruleVersion
                    {
                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1845);
                    this_Version_7=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_7);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:809:2: kw= 'lazy'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleVersionRange1869); 

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
    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:825:1: ruleOption returns [Enumerator current=null] : ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) ;
    public final Enumerator ruleOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:827:28: ( ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) )
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:828:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            {
            // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:828:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
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
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:828:2: (enumLiteral_0= 'requirements' )
                    {
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:828:2: (enumLiteral_0= 'requirements' )
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:828:4: enumLiteral_0= 'requirements'
                    {
                    enumLiteral_0=(Token)match(input,29,FOLLOW_29_in_ruleOption1927); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:834:6: (enumLiteral_1= 'allEnvironments' )
                    {
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:834:6: (enumLiteral_1= 'allEnvironments' )
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:834:8: enumLiteral_1= 'allEnvironments'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_30_in_ruleOption1944); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:840:6: (enumLiteral_2= 'source' )
                    {
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:840:6: (enumLiteral_2= 'source' )
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:840:8: enumLiteral_2= 'source'
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_31_in_ruleOption1961); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:846:6: (enumLiteral_3= 'configurePhase' )
                    {
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:846:6: (enumLiteral_3= 'configurePhase' )
                    // ../org.eclipse.cbi.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:846:8: enumLiteral_3= 'configurePhase'
                    {
                    enumLiteral_3=(Token)match(input,32,FOLLOW_32_in_ruleOption1978); 

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
    public static final BitSet FOLLOW_12_in_ruleTargetPlatform122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTargetPlatform139 = new BitSet(new long[]{0x000000000003A002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_ruleTargetPlatform165 = new BitSet(new long[]{0x000000000003A002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_entryRuleTargetContent203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetContent213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleTargetContent260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_ruleTargetContent287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_ruleTargetContent314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_ruleTargetContent341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_entryRuleOptions376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptions386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOptions423 = new BitSet(new long[]{0x00000001E0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions444 = new BitSet(new long[]{0x00000001E0004002L});
    public static final BitSet FOLLOW_14_in_ruleOptions458 = new BitSet(new long[]{0x00000001E0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions481 = new BitSet(new long[]{0x00000001E0004002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_entryRuleEnvironment519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnvironment529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEnvironment575 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment592 = new BitSet(new long[]{0x0000000000004022L});
    public static final BitSet FOLLOW_14_in_ruleEnvironment611 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment630 = new BitSet(new long[]{0x0000000000004022L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDeclaration683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleIncludeDeclaration720 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIncludeDeclaration737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleLocation825 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocation887 = new BitSet(new long[]{0x0000000000040032L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLocation963 = new BitSet(new long[]{0x0000000000040032L});
    public static final BitSet FOLLOW_18_in_ruleLocation1027 = new BitSet(new long[]{0x0000000000082020L});
    public static final BitSet FOLLOW_13_in_ruleLocation1040 = new BitSet(new long[]{0x00000001E0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1061 = new BitSet(new long[]{0x00000001E0084020L});
    public static final BitSet FOLLOW_14_in_ruleLocation1075 = new BitSet(new long[]{0x00000001E0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1098 = new BitSet(new long[]{0x00000001E0084020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation1123 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleLocation1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU1174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIU1226 = new BitSet(new long[]{0x0000000013100052L});
    public static final BitSet FOLLOW_20_in_ruleIU1245 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleIU1257 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleIU1269 = new BitSet(new long[]{0x0000000013000050L});
    public static final BitSet FOLLOW_ruleVersionRange_in_ruleIU1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIU1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion1367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1422 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleVersion1441 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1456 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleVersion1475 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1490 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleVersion1509 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVersion1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_QUALIFIER_in_ruleVersion1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange1640 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVersionRange1695 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_25_in_ruleVersionRange1714 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1737 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVersionRange1755 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1777 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleVersionRange1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVersionRange1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVersionRange1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOption1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOption1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOption1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOption1978 = new BitSet(new long[]{0x0000000000000002L});

}
