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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_QUALIFIER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "'with'", "','", "'environment'", "'define'", "'='", "'${'", "'}'", "'include'", "'location'", "'{'", "';'", "'version'", "'.'", "'('", "'['", "')'", "']'", "'lazy'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:77:1: ruleTargetPlatform returns [EObject current=null] : (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )? ;
    public final EObject ruleTargetPlatform() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_contents_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:80:28: ( (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:1: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:1: (otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:3: otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )*
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleTargetPlatform122); 

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

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:103:2: ( (lv_contents_2_0= ruleTargetContent ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13||(LA1_0>=15 && LA1_0<=16)||(LA1_0>=20 && LA1_0<=21)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:104:1: (lv_contents_2_0= ruleTargetContent )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:104:1: (lv_contents_2_0= ruleTargetContent )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:105:3: lv_contents_2_0= ruleTargetContent
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:129:1: entryRuleTargetContent returns [EObject current=null] : iv_ruleTargetContent= ruleTargetContent EOF ;
    public final EObject entryRuleTargetContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetContent = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:130:2: (iv_ruleTargetContent= ruleTargetContent EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:131:2: iv_ruleTargetContent= ruleTargetContent EOF
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:138:1: ruleTargetContent returns [EObject current=null] : (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation | this_VarDefinition_4= ruleVarDefinition ) ;
    public final EObject ruleTargetContent() throws RecognitionException {
        EObject current = null;

        EObject this_Options_0 = null;

        EObject this_Environment_1 = null;

        EObject this_IncludeDeclaration_2 = null;

        EObject this_Location_3 = null;

        EObject this_VarDefinition_4 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:141:28: ( (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation | this_VarDefinition_4= ruleVarDefinition ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:142:1: (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation | this_VarDefinition_4= ruleVarDefinition )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:142:1: (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation | this_VarDefinition_4= ruleVarDefinition )
            int alt3=5;
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
            case 20:
                {
                alt3=3;
                }
                break;
            case 21:
                {
                alt3=4;
                }
                break;
            case 16:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:143:5: this_Options_0= ruleOptions
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
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:153:5: this_Environment_1= ruleEnvironment
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
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:163:5: this_IncludeDeclaration_2= ruleIncludeDeclaration
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
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:173:5: this_Location_3= ruleLocation
                    {
                     
                            newCompositeNode(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleLocation_in_ruleTargetContent341);
                    this_Location_3=ruleLocation();

                    state._fsp--;

                     
                            current = this_Location_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:183:5: this_VarDefinition_4= ruleVarDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getTargetContentAccess().getVarDefinitionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleVarDefinition_in_ruleTargetContent368);
                    this_VarDefinition_4=ruleVarDefinition();

                    state._fsp--;

                     
                            current = this_VarDefinition_4; 
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:199:1: entryRuleOptions returns [EObject current=null] : iv_ruleOptions= ruleOptions EOF ;
    public final EObject entryRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptions = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:200:2: (iv_ruleOptions= ruleOptions EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:201:2: iv_ruleOptions= ruleOptions EOF
            {
             newCompositeNode(grammarAccess.getOptionsRule()); 
            pushFollow(FOLLOW_ruleOptions_in_entryRuleOptions403);
            iv_ruleOptions=ruleOptions();

            state._fsp--;

             current =iv_ruleOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptions413); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:208:1: ruleOptions returns [EObject current=null] : (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_options_1_0 = null;

        Enumerator lv_options_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:211:28: ( (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:212:1: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:212:1: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:212:3: otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleOptions450); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionsAccess().getWithKeyword_0());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:216:1: ( (lv_options_1_0= ruleOption ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:217:1: (lv_options_1_0= ruleOption )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:217:1: (lv_options_1_0= ruleOption )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:218:3: lv_options_1_0= ruleOption
            {
             
            	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleOption_in_ruleOptions471);
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

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:234:2: ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14||(LA5_0>=31 && LA5_0<=34)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:234:3: (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:234:3: (otherlv_2= ',' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==14) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:234:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleOptions485); 

            	                	newLeafNode(otherlv_2, grammarAccess.getOptionsAccess().getCommaKeyword_2_0());
            	                

            	            }
            	            break;

            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:238:3: ( (lv_options_3_0= ruleOption ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:239:1: (lv_options_3_0= ruleOption )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:239:1: (lv_options_3_0= ruleOption )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:240:3: lv_options_3_0= ruleOption
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOption_in_ruleOptions508);
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:264:1: entryRuleEnvironment returns [EObject current=null] : iv_ruleEnvironment= ruleEnvironment EOF ;
    public final EObject entryRuleEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnvironment = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:265:2: (iv_ruleEnvironment= ruleEnvironment EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:266:2: iv_ruleEnvironment= ruleEnvironment EOF
            {
             newCompositeNode(grammarAccess.getEnvironmentRule()); 
            pushFollow(FOLLOW_ruleEnvironment_in_entryRuleEnvironment546);
            iv_ruleEnvironment=ruleEnvironment();

            state._fsp--;

             current =iv_ruleEnvironment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnvironment556); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:273:1: ruleEnvironment returns [EObject current=null] : ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_env_2_0=null;
        Token otherlv_3=null;
        Token lv_env_4_0=null;

         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:276:28: ( ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:1: ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:1: ( () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:2: () otherlv_1= 'environment' ( (lv_env_2_0= RULE_ID ) ) ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )*
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:2: ()
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:278:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEnvironmentAccess().getEnvironmentAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleEnvironment602); 

                	newLeafNode(otherlv_1, grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:287:1: ( (lv_env_2_0= RULE_ID ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:288:1: (lv_env_2_0= RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:288:1: (lv_env_2_0= RULE_ID )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:289:3: lv_env_2_0= RULE_ID
            {
            lv_env_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment619); 

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

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:305:2: ( (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:305:3: (otherlv_3= ',' )? ( (lv_env_4_0= RULE_ID ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:305:3: (otherlv_3= ',' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==14) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:305:5: otherlv_3= ','
            	            {
            	            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleEnvironment638); 

            	                	newLeafNode(otherlv_3, grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0());
            	                

            	            }
            	            break;

            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:309:3: ( (lv_env_4_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:310:1: (lv_env_4_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:310:1: (lv_env_4_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:311:3: lv_env_4_0= RULE_ID
            	    {
            	    lv_env_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment657); 

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


    // $ANTLR start "entryRuleVarDefinition"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:335:1: entryRuleVarDefinition returns [EObject current=null] : iv_ruleVarDefinition= ruleVarDefinition EOF ;
    public final EObject entryRuleVarDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDefinition = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:336:2: (iv_ruleVarDefinition= ruleVarDefinition EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:337:2: iv_ruleVarDefinition= ruleVarDefinition EOF
            {
             newCompositeNode(grammarAccess.getVarDefinitionRule()); 
            pushFollow(FOLLOW_ruleVarDefinition_in_entryRuleVarDefinition700);
            iv_ruleVarDefinition=ruleVarDefinition();

            state._fsp--;

             current =iv_ruleVarDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarDefinition710); 

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
    // $ANTLR end "entryRuleVarDefinition"


    // $ANTLR start "ruleVarDefinition"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:344:1: ruleVarDefinition returns [EObject current=null] : (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleVarDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;

         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:347:28: ( (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:348:1: (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:348:1: (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:348:3: otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVarDefinition747); 

                	newLeafNode(otherlv_0, grammarAccess.getVarDefinitionAccess().getDefineKeyword_0());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:352:1: ( (lv_name_1_0= RULE_ID ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:353:1: (lv_name_1_0= RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:353:1: (lv_name_1_0= RULE_ID )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:354:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarDefinition764); 

            			newLeafNode(lv_name_1_0, grammarAccess.getVarDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVarDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleVarDefinition781); 

                	newLeafNode(otherlv_2, grammarAccess.getVarDefinitionAccess().getEqualsSignKeyword_2());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:374:1: ( (lv_value_3_0= RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:375:1: (lv_value_3_0= RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:375:1: (lv_value_3_0= RULE_STRING )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:376:3: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVarDefinition798); 

            			newLeafNode(lv_value_3_0, grammarAccess.getVarDefinitionAccess().getValueSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVarDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
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
    // $ANTLR end "ruleVarDefinition"


    // $ANTLR start "entryRuleCompositeString"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:400:1: entryRuleCompositeString returns [EObject current=null] : iv_ruleCompositeString= ruleCompositeString EOF ;
    public final EObject entryRuleCompositeString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeString = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:401:2: (iv_ruleCompositeString= ruleCompositeString EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:402:2: iv_ruleCompositeString= ruleCompositeString EOF
            {
             newCompositeNode(grammarAccess.getCompositeStringRule()); 
            pushFollow(FOLLOW_ruleCompositeString_in_entryRuleCompositeString839);
            iv_ruleCompositeString=ruleCompositeString();

            state._fsp--;

             current =iv_ruleCompositeString; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeString849); 

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
    // $ANTLR end "entryRuleCompositeString"


    // $ANTLR start "ruleCompositeString"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:409:1: ruleCompositeString returns [EObject current=null] : ( () ( (lv_stringParts_1_0= ruleCompositeStringPart ) )* ) ;
    public final EObject ruleCompositeString() throws RecognitionException {
        EObject current = null;

        EObject lv_stringParts_1_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:412:28: ( ( () ( (lv_stringParts_1_0= ruleCompositeStringPart ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:413:1: ( () ( (lv_stringParts_1_0= ruleCompositeStringPart ) )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:413:1: ( () ( (lv_stringParts_1_0= ruleCompositeStringPart ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:413:2: () ( (lv_stringParts_1_0= ruleCompositeStringPart ) )*
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:413:2: ()
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:414:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCompositeStringAccess().getCompositeStringAction_0(),
                        current);
                

            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:419:2: ( (lv_stringParts_1_0= ruleCompositeStringPart ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_STRING||LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:420:1: (lv_stringParts_1_0= ruleCompositeStringPart )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:420:1: (lv_stringParts_1_0= ruleCompositeStringPart )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:421:3: lv_stringParts_1_0= ruleCompositeStringPart
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompositeStringAccess().getStringPartsCompositeStringPartParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCompositeStringPart_in_ruleCompositeString904);
            	    lv_stringParts_1_0=ruleCompositeStringPart();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompositeStringRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"stringParts",
            	            		lv_stringParts_1_0, 
            	            		"CompositeStringPart");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleCompositeString"


    // $ANTLR start "entryRuleCompositeStringPart"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:445:1: entryRuleCompositeStringPart returns [EObject current=null] : iv_ruleCompositeStringPart= ruleCompositeStringPart EOF ;
    public final EObject entryRuleCompositeStringPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeStringPart = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:446:2: (iv_ruleCompositeStringPart= ruleCompositeStringPart EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:447:2: iv_ruleCompositeStringPart= ruleCompositeStringPart EOF
            {
             newCompositeNode(grammarAccess.getCompositeStringPartRule()); 
            pushFollow(FOLLOW_ruleCompositeStringPart_in_entryRuleCompositeStringPart941);
            iv_ruleCompositeStringPart=ruleCompositeStringPart();

            state._fsp--;

             current =iv_ruleCompositeStringPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeStringPart951); 

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
    // $ANTLR end "entryRuleCompositeStringPart"


    // $ANTLR start "ruleCompositeStringPart"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:454:1: ruleCompositeStringPart returns [EObject current=null] : (this_VarCall_0= ruleVarCall | this_StaticString_1= ruleStaticString ) ;
    public final EObject ruleCompositeStringPart() throws RecognitionException {
        EObject current = null;

        EObject this_VarCall_0 = null;

        EObject this_StaticString_1 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:457:28: ( (this_VarCall_0= ruleVarCall | this_StaticString_1= ruleStaticString ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:458:1: (this_VarCall_0= ruleVarCall | this_StaticString_1= ruleStaticString )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:458:1: (this_VarCall_0= ruleVarCall | this_StaticString_1= ruleStaticString )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_STRING) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:459:5: this_VarCall_0= ruleVarCall
                    {
                     
                            newCompositeNode(grammarAccess.getCompositeStringPartAccess().getVarCallParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVarCall_in_ruleCompositeStringPart998);
                    this_VarCall_0=ruleVarCall();

                    state._fsp--;

                     
                            current = this_VarCall_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:469:5: this_StaticString_1= ruleStaticString
                    {
                     
                            newCompositeNode(grammarAccess.getCompositeStringPartAccess().getStaticStringParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleStaticString_in_ruleCompositeStringPart1025);
                    this_StaticString_1=ruleStaticString();

                    state._fsp--;

                     
                            current = this_StaticString_1; 
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
    // $ANTLR end "ruleCompositeStringPart"


    // $ANTLR start "entryRuleVarCall"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:485:1: entryRuleVarCall returns [EObject current=null] : iv_ruleVarCall= ruleVarCall EOF ;
    public final EObject entryRuleVarCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarCall = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:486:2: (iv_ruleVarCall= ruleVarCall EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:487:2: iv_ruleVarCall= ruleVarCall EOF
            {
             newCompositeNode(grammarAccess.getVarCallRule()); 
            pushFollow(FOLLOW_ruleVarCall_in_entryRuleVarCall1060);
            iv_ruleVarCall=ruleVarCall();

            state._fsp--;

             current =iv_ruleVarCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarCall1070); 

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
    // $ANTLR end "entryRuleVarCall"


    // $ANTLR start "ruleVarCall"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:494:1: ruleVarCall returns [EObject current=null] : (otherlv_0= '${' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}' ) ;
    public final EObject ruleVarCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:497:28: ( (otherlv_0= '${' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}' ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:498:1: (otherlv_0= '${' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}' )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:498:1: (otherlv_0= '${' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}' )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:498:3: otherlv_0= '${' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleVarCall1107); 

                	newLeafNode(otherlv_0, grammarAccess.getVarCallAccess().getDollarSignLeftCurlyBracketKeyword_0());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:502:1: ( (otherlv_1= RULE_ID ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:503:1: (otherlv_1= RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:503:1: (otherlv_1= RULE_ID )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:504:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVarCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarCall1127); 

            		newLeafNode(otherlv_1, grammarAccess.getVarCallAccess().getVarNameVarDefinitionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleVarCall1139); 

                	newLeafNode(otherlv_2, grammarAccess.getVarCallAccess().getRightCurlyBracketKeyword_2());
                

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
    // $ANTLR end "ruleVarCall"


    // $ANTLR start "entryRuleStaticString"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:527:1: entryRuleStaticString returns [EObject current=null] : iv_ruleStaticString= ruleStaticString EOF ;
    public final EObject entryRuleStaticString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticString = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:528:2: (iv_ruleStaticString= ruleStaticString EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:529:2: iv_ruleStaticString= ruleStaticString EOF
            {
             newCompositeNode(grammarAccess.getStaticStringRule()); 
            pushFollow(FOLLOW_ruleStaticString_in_entryRuleStaticString1175);
            iv_ruleStaticString=ruleStaticString();

            state._fsp--;

             current =iv_ruleStaticString; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticString1185); 

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
    // $ANTLR end "entryRuleStaticString"


    // $ANTLR start "ruleStaticString"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:536:1: ruleStaticString returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStaticString() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:539:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:540:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:540:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:541:1: (lv_value_0_0= RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:541:1: (lv_value_0_0= RULE_STRING )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:542:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStaticString1226); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStaticStringAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStaticStringRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleStaticString"


    // $ANTLR start "entryRuleIncludeDeclaration"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:566:1: entryRuleIncludeDeclaration returns [EObject current=null] : iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF ;
    public final EObject entryRuleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDeclaration = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:567:2: (iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:568:2: iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF
            {
             newCompositeNode(grammarAccess.getIncludeDeclarationRule()); 
            pushFollow(FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration1266);
            iv_ruleIncludeDeclaration=ruleIncludeDeclaration();

            state._fsp--;

             current =iv_ruleIncludeDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDeclaration1276); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:575:1: ruleIncludeDeclaration returns [EObject current=null] : (otherlv_0= 'include' ( (lv_compositeImportURI_1_0= ruleCompositeString ) ) ) ;
    public final EObject ruleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_compositeImportURI_1_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:578:28: ( (otherlv_0= 'include' ( (lv_compositeImportURI_1_0= ruleCompositeString ) ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:579:1: (otherlv_0= 'include' ( (lv_compositeImportURI_1_0= ruleCompositeString ) ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:579:1: (otherlv_0= 'include' ( (lv_compositeImportURI_1_0= ruleCompositeString ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:579:3: otherlv_0= 'include' ( (lv_compositeImportURI_1_0= ruleCompositeString ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleIncludeDeclaration1313); 

                	newLeafNode(otherlv_0, grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:583:1: ( (lv_compositeImportURI_1_0= ruleCompositeString ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:584:1: (lv_compositeImportURI_1_0= ruleCompositeString )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:584:1: (lv_compositeImportURI_1_0= ruleCompositeString )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:585:3: lv_compositeImportURI_1_0= ruleCompositeString
            {
             
            	        newCompositeNode(grammarAccess.getIncludeDeclarationAccess().getCompositeImportURICompositeStringParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleCompositeString_in_ruleIncludeDeclaration1334);
            lv_compositeImportURI_1_0=ruleCompositeString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIncludeDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"compositeImportURI",
                    		lv_compositeImportURI_1_0, 
                    		"CompositeString");
            	        afterParserOrEnumRuleCall();
            	    

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:609:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:610:2: (iv_ruleLocation= ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:611:2: iv_ruleLocation= ruleLocation EOF
            {
             newCompositeNode(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation1370);
            iv_ruleLocation=ruleLocation();

            state._fsp--;

             current =iv_ruleLocation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation1380); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:618:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:621:28: ( (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:622:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:622:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:622:3: otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleLocation1417); 

                	newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:626:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:628:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:628:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:629:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:632:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:633:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:633:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( LA10_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                    alt10=1;
                }
                else if ( LA10_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:635:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:635:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:636:5: {...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:636:105: ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:637:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:640:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:640:7: {...}? => ( (lv_ID_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:640:16: ( (lv_ID_2_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:641:1: (lv_ID_2_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:641:1: (lv_ID_2_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:642:3: lv_ID_2_0= RULE_ID
            	    {
            	    lv_ID_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocation1479); 

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
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:665:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:665:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:666:5: {...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:666:105: ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:667:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:670:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:670:7: {...}? => ( (lv_uri_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:670:16: ( (lv_uri_3_0= RULE_STRING ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:671:1: (lv_uri_3_0= RULE_STRING )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:671:1: (lv_uri_3_0= RULE_STRING )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:672:3: lv_uri_3_0= RULE_STRING
            	    {
            	    lv_uri_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLocation1555); 

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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	

            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:703:2: (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:703:4: otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}'
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleLocation1619); 

                        	newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0());
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:707:1: (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==13) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:707:3: otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            {
                            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleLocation1632); 

                                	newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getWithKeyword_2_1_0());
                                
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:711:1: ( (lv_options_6_0= ruleOption ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:712:1: (lv_options_6_0= ruleOption )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:712:1: (lv_options_6_0= ruleOption )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:713:3: lv_options_6_0= ruleOption
                            {
                             
                            	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleOption_in_ruleLocation1653);
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

                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:729:2: ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==14||(LA12_0>=31 && LA12_0<=34)) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:729:3: (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:729:3: (otherlv_7= ',' )?
                            	    int alt11=2;
                            	    int LA11_0 = input.LA(1);

                            	    if ( (LA11_0==14) ) {
                            	        alt11=1;
                            	    }
                            	    switch (alt11) {
                            	        case 1 :
                            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:729:5: otherlv_7= ','
                            	            {
                            	            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleLocation1667); 

                            	                	newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
                            	                

                            	            }
                            	            break;

                            	    }

                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:733:3: ( (lv_options_8_0= ruleOption ) )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:734:1: (lv_options_8_0= ruleOption )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:734:1: (lv_options_8_0= ruleOption )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:735:3: lv_options_8_0= ruleOption
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleOption_in_ruleLocation1690);
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
                            	    break loop12;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:751:6: ( (lv_ius_9_0= ruleIU ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:752:1: (lv_ius_9_0= ruleIU )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:752:1: (lv_ius_9_0= ruleIU )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:753:3: lv_ius_9_0= ruleIU
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleIU_in_ruleLocation1715);
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
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_19_in_ruleLocation1728); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:781:1: entryRuleIU returns [EObject current=null] : iv_ruleIU= ruleIU EOF ;
    public final EObject entryRuleIU() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIU = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:782:2: (iv_ruleIU= ruleIU EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:783:2: iv_ruleIU= ruleIU EOF
            {
             newCompositeNode(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU1766);
            iv_ruleIU=ruleIU();

            state._fsp--;

             current =iv_ruleIU; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU1776); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:790:1: ruleIU returns [EObject current=null] : ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:793:28: ( ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:794:1: ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:794:1: ( ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:794:2: ( (lv_ID_0_0= RULE_ID ) ) ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:794:2: ( (lv_ID_0_0= RULE_ID ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:795:1: (lv_ID_0_0= RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:795:1: (lv_ID_0_0= RULE_ID )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:796:3: lv_ID_0_0= RULE_ID
            {
            lv_ID_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIU1818); 

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

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:812:2: ( (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_STRING||LA18_0==RULE_INT||LA18_0==23||(LA18_0>=26 && LA18_0<=27)||LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:812:3: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:812:3: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==23) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:812:5: otherlv_1= ';' otherlv_2= 'version' otherlv_3= '='
                            {
                            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleIU1837); 

                                	newLeafNode(otherlv_1, grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0());
                                
                            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleIU1849); 

                                	newLeafNode(otherlv_2, grammarAccess.getIUAccess().getVersionKeyword_1_0_1());
                                
                            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleIU1861); 

                                	newLeafNode(otherlv_3, grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2());
                                

                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:824:3: ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_INT||(LA17_0>=26 && LA17_0<=27)||LA17_0==30) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_STRING) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:824:4: ( (lv_version_4_0= ruleVersionRange ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:824:4: ( (lv_version_4_0= ruleVersionRange ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:825:1: (lv_version_4_0= ruleVersionRange )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:825:1: (lv_version_4_0= ruleVersionRange )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:826:3: lv_version_4_0= ruleVersionRange
                            {
                             
                            	        newCompositeNode(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleVersionRange_in_ruleIU1885);
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
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:843:6: ( (lv_version_5_0= RULE_STRING ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:843:6: ( (lv_version_5_0= RULE_STRING ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:844:1: (lv_version_5_0= RULE_STRING )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:844:1: (lv_version_5_0= RULE_STRING )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:845:3: lv_version_5_0= RULE_STRING
                            {
                            lv_version_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIU1908); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:869:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:873:2: (iv_ruleVersion= ruleVersion EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:874:2: iv_ruleVersion= ruleVersion EOF
            {
             newCompositeNode(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion1959);
            iv_ruleVersion=ruleVersion();

            state._fsp--;

             current =iv_ruleVersion.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion1970); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:884:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:888:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:889:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:889:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:889:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2014); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
                
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:896:1: (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )? )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:897:2: kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )?
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleVersion2033); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2048); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:909:1: (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )? )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==25) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:910:2: kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )?
                            {
                            kw=(Token)match(input,25,FOLLOW_25_in_ruleVersion2067); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
                                
                            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2082); 

                            		current.merge(this_INT_4);
                                
                             
                                newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
                                
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:922:1: (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER ) )?
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==25) ) {
                                alt20=1;
                            }
                            switch (alt20) {
                                case 1 :
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:923:2: kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER )
                                    {
                                    kw=(Token)match(input,25,FOLLOW_25_in_ruleVersion2101); 

                                            current.merge(kw);
                                            newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
                                        
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:928:1: (this_ID_6= RULE_ID | this_INT_7= RULE_INT | this_QUALIFIER_8= RULE_QUALIFIER )
                                    int alt19=3;
                                    switch ( input.LA(1) ) {
                                    case RULE_ID:
                                        {
                                        alt19=1;
                                        }
                                        break;
                                    case RULE_INT:
                                        {
                                        alt19=2;
                                        }
                                        break;
                                    case RULE_QUALIFIER:
                                        {
                                        alt19=3;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 19, 0, input);

                                        throw nvae;
                                    }

                                    switch (alt19) {
                                        case 1 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:928:6: this_ID_6= RULE_ID
                                            {
                                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVersion2117); 

                                            		current.merge(this_ID_6);
                                                
                                             
                                                newLeafNode(this_ID_6, grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:936:10: this_INT_7= RULE_INT
                                            {
                                            this_INT_7=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2143); 

                                            		current.merge(this_INT_7);
                                                
                                             
                                                newLeafNode(this_INT_7, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 
                                                

                                            }
                                            break;
                                        case 3 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:944:10: this_QUALIFIER_8= RULE_QUALIFIER
                                            {
                                            this_QUALIFIER_8=(Token)match(input,RULE_QUALIFIER,FOLLOW_RULE_QUALIFIER_in_ruleVersion2169); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:962:1: entryRuleVersionRange returns [String current=null] : iv_ruleVersionRange= ruleVersionRange EOF ;
    public final String entryRuleVersionRange() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionRange = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:966:2: (iv_ruleVersionRange= ruleVersionRange EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:967:2: iv_ruleVersionRange= ruleVersionRange EOF
            {
             newCompositeNode(grammarAccess.getVersionRangeRule()); 
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange2232);
            iv_ruleVersionRange=ruleVersionRange();

            state._fsp--;

             current =iv_ruleVersionRange.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange2243); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:977:1: ruleVersionRange returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) ;
    public final AntlrDatatypeRuleToken ruleVersionRange() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Version_2 = null;

        AntlrDatatypeRuleToken this_Version_4 = null;

        AntlrDatatypeRuleToken this_Version_7 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:981:28: ( ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:982:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:982:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 26:
            case 27:
                {
                alt25=1;
                }
                break;
            case RULE_INT:
                {
                alt25=2;
                }
                break;
            case 30:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:982:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:982:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:982:3: (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:982:3: (kw= '(' | kw= '[' )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==26) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==27) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:983:2: kw= '('
                            {
                            kw=(Token)match(input,26,FOLLOW_26_in_ruleVersionRange2287); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:990:2: kw= '['
                            {
                            kw=(Token)match(input,27,FOLLOW_27_in_ruleVersionRange2306); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                                

                            }
                            break;

                    }

                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2329);
                    this_Version_2=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleVersionRange2347); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
                        
                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2369);
                    this_Version_4=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_4);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1023:1: (kw= ')' | kw= ']' )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==28) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==29) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1024:2: kw= ')'
                            {
                            kw=(Token)match(input,28,FOLLOW_28_in_ruleVersionRange2388); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1031:2: kw= ']'
                            {
                            kw=(Token)match(input,29,FOLLOW_29_in_ruleVersionRange2407); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1038:5: this_Version_7= ruleVersion
                    {
                     
                            newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2437);
                    this_Version_7=ruleVersion();

                    state._fsp--;


                    		current.merge(this_Version_7);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1050:2: kw= 'lazy'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleVersionRange2461); 

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1066:1: ruleOption returns [Enumerator current=null] : ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) ;
    public final Enumerator ruleOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1068:28: ( ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1069:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1069:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt26=1;
                }
                break;
            case 32:
                {
                alt26=2;
                }
                break;
            case 33:
                {
                alt26=3;
                }
                break;
            case 34:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1069:2: (enumLiteral_0= 'requirements' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1069:2: (enumLiteral_0= 'requirements' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1069:4: enumLiteral_0= 'requirements'
                    {
                    enumLiteral_0=(Token)match(input,31,FOLLOW_31_in_ruleOption2519); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1075:6: (enumLiteral_1= 'allEnvironments' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1075:6: (enumLiteral_1= 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1075:8: enumLiteral_1= 'allEnvironments'
                    {
                    enumLiteral_1=(Token)match(input,32,FOLLOW_32_in_ruleOption2536); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1081:6: (enumLiteral_2= 'source' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1081:6: (enumLiteral_2= 'source' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1081:8: enumLiteral_2= 'source'
                    {
                    enumLiteral_2=(Token)match(input,33,FOLLOW_33_in_ruleOption2553); 

                            current = grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1087:6: (enumLiteral_3= 'configurePhase' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1087:6: (enumLiteral_3= 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1087:8: enumLiteral_3= 'configurePhase'
                    {
                    enumLiteral_3=(Token)match(input,34,FOLLOW_34_in_ruleOption2570); 

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
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTargetPlatform139 = new BitSet(new long[]{0x000000000031A002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_ruleTargetPlatform165 = new BitSet(new long[]{0x000000000031A002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_entryRuleTargetContent203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetContent213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleTargetContent260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_ruleTargetContent287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_ruleTargetContent314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_ruleTargetContent341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarDefinition_in_ruleTargetContent368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_entryRuleOptions403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptions413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOptions450 = new BitSet(new long[]{0x0000000780000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions471 = new BitSet(new long[]{0x0000000780004002L});
    public static final BitSet FOLLOW_14_in_ruleOptions485 = new BitSet(new long[]{0x0000000780000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions508 = new BitSet(new long[]{0x0000000780004002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_entryRuleEnvironment546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnvironment556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEnvironment602 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment619 = new BitSet(new long[]{0x0000000000004022L});
    public static final BitSet FOLLOW_14_in_ruleEnvironment638 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment657 = new BitSet(new long[]{0x0000000000004022L});
    public static final BitSet FOLLOW_ruleVarDefinition_in_entryRuleVarDefinition700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarDefinition710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVarDefinition747 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarDefinition764 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVarDefinition781 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVarDefinition798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeString_in_entryRuleCompositeString839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeString849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeStringPart_in_ruleCompositeString904 = new BitSet(new long[]{0x0000000000040012L});
    public static final BitSet FOLLOW_ruleCompositeStringPart_in_entryRuleCompositeStringPart941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeStringPart951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarCall_in_ruleCompositeStringPart998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticString_in_ruleCompositeStringPart1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarCall_in_entryRuleVarCall1060 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarCall1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVarCall1107 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarCall1127 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleVarCall1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticString_in_entryRuleStaticString1175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticString1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStaticString1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration1266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDeclaration1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleIncludeDeclaration1313 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleCompositeString_in_ruleIncludeDeclaration1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation1370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleLocation1417 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocation1479 = new BitSet(new long[]{0x0000000000400032L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLocation1555 = new BitSet(new long[]{0x0000000000400032L});
    public static final BitSet FOLLOW_22_in_ruleLocation1619 = new BitSet(new long[]{0x0000000000082020L});
    public static final BitSet FOLLOW_13_in_ruleLocation1632 = new BitSet(new long[]{0x0000000780000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1653 = new BitSet(new long[]{0x0000000780084020L});
    public static final BitSet FOLLOW_14_in_ruleLocation1667 = new BitSet(new long[]{0x0000000780000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1690 = new BitSet(new long[]{0x0000000780084020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation1715 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleLocation1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU1766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIU1818 = new BitSet(new long[]{0x000000004C800052L});
    public static final BitSet FOLLOW_23_in_ruleIU1837 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleIU1849 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIU1861 = new BitSet(new long[]{0x000000004C000050L});
    public static final BitSet FOLLOW_ruleVersionRange_in_ruleIU1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIU1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion1959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2014 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleVersion2033 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2048 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleVersion2067 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2082 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleVersion2101 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVersion2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_QUALIFIER_in_ruleVersion2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange2232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVersionRange2287 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_27_in_ruleVersionRange2306 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2329 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVersionRange2347 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2369 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleVersionRange2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVersionRange2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVersionRange2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOption2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOption2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOption2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOption2570 = new BitSet(new long[]{0x0000000000000002L});

}
