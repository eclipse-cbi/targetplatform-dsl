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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTargetPlatformParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "'with'", "','", "'operatingSystem'", "'windowingSystem'", "'architecture'", "'localization'", "'executionEnvironment'", "'include'", "'location'", "'{'", "'}'", "';'", "'version'", "'='", "'.'", "'('", "'['", "')'", "']'", "'lazy'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'"
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
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
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
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTargetPlatformRule()); 
            }
            pushFollow(FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform75);
            iv_ruleTargetPlatform=ruleTargetPlatform();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTargetPlatform; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTargetPlatform85); if (state.failed) return current;

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

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:81:3: otherlv_0= 'target' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_contents_2_0= ruleTargetContent ) )*
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleTargetPlatform122); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getTargetPlatformAccess().getTargetKeyword_0());
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:85:1: ( (lv_name_1_0= RULE_STRING ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:86:1: (lv_name_1_0= RULE_STRING )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:86:1: (lv_name_1_0= RULE_STRING )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:87:3: lv_name_1_0= RULE_STRING
                    {
                    lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTargetPlatform139); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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


                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:103:2: ( (lv_contents_2_0= ruleTargetContent ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12||(LA1_0>=14 && LA1_0<=20)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:104:1: (lv_contents_2_0= ruleTargetContent )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:104:1: (lv_contents_2_0= ruleTargetContent )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:105:3: lv_contents_2_0= ruleTargetContent
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTargetPlatformAccess().getContentsTargetContentParserRuleCall_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTargetContent_in_ruleTargetPlatform165);
                    	    lv_contents_2_0=ruleTargetContent();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTargetContentRule()); 
            }
            pushFollow(FOLLOW_ruleTargetContent_in_entryRuleTargetContent203);
            iv_ruleTargetContent=ruleTargetContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTargetContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTargetContent213); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:138:1: ruleTargetContent returns [EObject current=null] : (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation ) ;
    public final EObject ruleTargetContent() throws RecognitionException {
        EObject current = null;

        EObject this_Options_0 = null;

        EObject this_Environment_1 = null;

        EObject this_IncludeDeclaration_2 = null;

        EObject this_Location_3 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:141:28: ( (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:142:1: (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:142:1: (this_Options_0= ruleOptions | this_Environment_1= ruleEnvironment | this_IncludeDeclaration_2= ruleIncludeDeclaration | this_Location_3= ruleLocation )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                {
                alt3=2;
                }
                break;
            case 19:
                {
                alt3=3;
                }
                break;
            case 20:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:143:5: this_Options_0= ruleOptions
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOptions_in_ruleTargetContent260);
                    this_Options_0=ruleOptions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Options_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:153:5: this_Environment_1= ruleEnvironment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEnvironment_in_ruleTargetContent287);
                    this_Environment_1=ruleEnvironment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Environment_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:163:5: this_IncludeDeclaration_2= ruleIncludeDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIncludeDeclaration_in_ruleTargetContent314);
                    this_IncludeDeclaration_2=ruleIncludeDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IncludeDeclaration_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:173:5: this_Location_3= ruleLocation
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLocation_in_ruleTargetContent341);
                    this_Location_3=ruleLocation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Location_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTargetContent"


    // $ANTLR start "entryRuleOptions"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:189:1: entryRuleOptions returns [EObject current=null] : iv_ruleOptions= ruleOptions EOF ;
    public final EObject entryRuleOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptions = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:190:2: (iv_ruleOptions= ruleOptions EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:191:2: iv_ruleOptions= ruleOptions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionsRule()); 
            }
            pushFollow(FOLLOW_ruleOptions_in_entryRuleOptions376);
            iv_ruleOptions=ruleOptions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptions; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptions386); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:198:1: ruleOptions returns [EObject current=null] : (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) (otherlv_2= ',' ( (lv_options_3_0= ruleOption ) ) )* ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_options_1_0 = null;

        Enumerator lv_options_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:201:28: ( (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) (otherlv_2= ',' ( (lv_options_3_0= ruleOption ) ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:1: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) (otherlv_2= ',' ( (lv_options_3_0= ruleOption ) ) )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:1: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) (otherlv_2= ',' ( (lv_options_3_0= ruleOption ) ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:3: otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) (otherlv_2= ',' ( (lv_options_3_0= ruleOption ) ) )*
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleOptions423); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOptionsAccess().getWithKeyword_0());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:206:1: ( (lv_options_1_0= ruleOption ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:207:1: (lv_options_1_0= ruleOption )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:207:1: (lv_options_1_0= ruleOption )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:208:3: lv_options_1_0= ruleOption
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleOption_in_ruleOptions444);
            lv_options_1_0=ruleOption();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:2: (otherlv_2= ',' ( (lv_options_3_0= ruleOption ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:4: otherlv_2= ',' ( (lv_options_3_0= ruleOption ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleOptions457); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getOptionsAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:228:1: ( (lv_options_3_0= ruleOption ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:229:1: (lv_options_3_0= ruleOption )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:229:1: (lv_options_3_0= ruleOption )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:230:3: lv_options_3_0= ruleOption
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOption_in_ruleOptions478);
            	    lv_options_3_0=ruleOption();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOptions"


    // $ANTLR start "entryRuleEnvironment"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:254:1: entryRuleEnvironment returns [EObject current=null] : iv_ruleEnvironment= ruleEnvironment EOF ;
    public final EObject entryRuleEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnvironment = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:255:2: (iv_ruleEnvironment= ruleEnvironment EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:256:2: iv_ruleEnvironment= ruleEnvironment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnvironmentRule()); 
            }
            pushFollow(FOLLOW_ruleEnvironment_in_entryRuleEnvironment516);
            iv_ruleEnvironment=ruleEnvironment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnvironment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnvironment526); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:263:1: ruleEnvironment returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_operatingSystem_2_0=null;
        Token otherlv_3=null;
        Token lv_windowingSystem_4_0=null;
        Token otherlv_5=null;
        Token lv_architecture_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_localization_8_0 = null;

        AntlrDatatypeRuleToken lv_executionEnvironment_10_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:266:28: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?) ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?) ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:269:1: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:269:1: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:270:2: ( ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?)
            {
            getUnorderedGroupHelper().enter(grammarAccess.getEnvironmentAccess().getUnorderedGroup());
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:273:2: ( ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?)
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:274:3: ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+ {...}?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:274:3: ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=6;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:276:4: ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:276:4: ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:5: {...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 0)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:106: ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:278:6: ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 0);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:281:6: ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:281:7: {...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:281:16: (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:281:18: otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleEnvironment608); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getEnvironmentAccess().getOperatingSystemKeyword_0_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:285:1: ( (lv_operatingSystem_2_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:286:1: (lv_operatingSystem_2_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:286:1: (lv_operatingSystem_2_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:287:3: lv_operatingSystem_2_0= RULE_ID
            	    {
            	    lv_operatingSystem_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment625); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_operatingSystem_2_0, grammarAccess.getEnvironmentAccess().getOperatingSystemIDTerminalRuleCall_0_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"operatingSystem",
            	              		lv_operatingSystem_2_0, 
            	              		"ID");
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:310:4: ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:310:4: ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:311:5: {...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 1)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:311:106: ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:312:6: ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 1);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:315:6: ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:315:7: {...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:315:16: (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:315:18: otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleEnvironment698); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getEnvironmentAccess().getWindowingSystemKeyword_1_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:319:1: ( (lv_windowingSystem_4_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:320:1: (lv_windowingSystem_4_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:320:1: (lv_windowingSystem_4_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:321:3: lv_windowingSystem_4_0= RULE_ID
            	    {
            	    lv_windowingSystem_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment715); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_windowingSystem_4_0, grammarAccess.getEnvironmentAccess().getWindowingSystemIDTerminalRuleCall_1_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"windowingSystem",
            	              		lv_windowingSystem_4_0, 
            	              		"ID");
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:344:4: ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:344:4: ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:345:5: {...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 2)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:345:106: ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:346:6: ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 2);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:349:6: ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:349:7: {...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:349:16: (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:349:18: otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleEnvironment788); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getEnvironmentAccess().getArchitectureKeyword_2_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:353:1: ( (lv_architecture_6_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:354:1: (lv_architecture_6_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:354:1: (lv_architecture_6_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:355:3: lv_architecture_6_0= RULE_ID
            	    {
            	    lv_architecture_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment805); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_architecture_6_0, grammarAccess.getEnvironmentAccess().getArchitectureIDTerminalRuleCall_2_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"architecture",
            	              		lv_architecture_6_0, 
            	              		"ID");
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:378:4: ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:378:4: ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:379:5: {...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 3)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:379:106: ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:380:6: ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 3);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:383:6: ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:383:7: {...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:383:16: (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:383:18: otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) )
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleEnvironment878); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getEnvironmentAccess().getLocalizationKeyword_3_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:387:1: ( (lv_localization_8_0= ruleLocale ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:388:1: (lv_localization_8_0= ruleLocale )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:388:1: (lv_localization_8_0= ruleLocale )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:389:3: lv_localization_8_0= ruleLocale
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEnvironmentAccess().getLocalizationLocaleParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLocale_in_ruleEnvironment899);
            	    lv_localization_8_0=ruleLocale();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"localization",
            	              		lv_localization_8_0, 
            	              		"Locale");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:412:4: ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:412:4: ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:413:5: {...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 4)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:413:106: ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:414:6: ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 4);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:417:6: ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:417:7: {...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:417:16: (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:417:18: otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) )
            	    {
            	    otherlv_9=(Token)match(input,18,FOLLOW_18_in_ruleEnvironment967); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getEnvironmentAccess().getExecutionEnvironmentKeyword_4_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:421:1: ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:422:1: (lv_executionEnvironment_10_0= ruleExecutionEnvironment )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:422:1: (lv_executionEnvironment_10_0= ruleExecutionEnvironment )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:423:3: lv_executionEnvironment_10_0= ruleExecutionEnvironment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEnvironmentAccess().getExecutionEnvironmentExecutionEnvironmentParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExecutionEnvironment_in_ruleEnvironment988);
            	    lv_executionEnvironment_10_0=ruleExecutionEnvironment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"executionEnvironment",
            	              		lv_executionEnvironment_10_0, 
            	              		"ExecutionEnvironment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentAccess().getUnorderedGroup()) ) {
                if (state.backtracking>0) {state.failed=true; return current;}
                throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentAccess().getUnorderedGroup())");
            }

            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getEnvironmentAccess().getUnorderedGroup());

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleEnvironment"


    // $ANTLR start "entryRuleIncludeDeclaration"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:462:1: entryRuleIncludeDeclaration returns [EObject current=null] : iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF ;
    public final EObject entryRuleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDeclaration = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:463:2: (iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:464:2: iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration1070);
            iv_ruleIncludeDeclaration=ruleIncludeDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIncludeDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDeclaration1080); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:471:1: ruleIncludeDeclaration returns [EObject current=null] : (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:474:28: ( (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:475:1: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:475:1: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:475:3: otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleIncludeDeclaration1117); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:479:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:480:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:480:1: (lv_importURI_1_0= RULE_STRING )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:481:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIncludeDeclaration1134); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_importURI_1_0, grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIncludeDeclaration"


    // $ANTLR start "entryRuleLocation"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:505:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:506:2: (iv_ruleLocation= ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:507:2: iv_ruleLocation= ruleLocation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocationRule()); 
            }
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation1175);
            iv_ruleLocation=ruleLocation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation1185); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:514:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:517:28: ( (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:518:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:518:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:518:3: otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleLocation1222); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:522:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:524:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:524:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:525:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            {
            getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:528:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:529:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:529:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+
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
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:531:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:531:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:532:5: {...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:532:105: ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:533:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:536:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:536:7: {...}? => ( (lv_ID_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:536:16: ( (lv_ID_2_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:537:1: (lv_ID_2_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:537:1: (lv_ID_2_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:538:3: lv_ID_2_0= RULE_ID
            	    {
            	    lv_ID_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocation1284); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_ID_2_0, grammarAccess.getLocationAccess().getIDIDTerminalRuleCall_1_0_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

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


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLocationAccess().getUnorderedGroup_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:561:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:561:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:562:5: {...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:562:105: ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:563:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:566:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:566:7: {...}? => ( (lv_uri_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:566:16: ( (lv_uri_3_0= RULE_STRING ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:567:1: (lv_uri_3_0= RULE_STRING )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:567:1: (lv_uri_3_0= RULE_STRING )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:568:3: lv_uri_3_0= RULE_STRING
            	    {
            	    lv_uri_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLocation1360); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_uri_3_0, grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

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


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLocationAccess().getUnorderedGroup_1());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1()) ) {
                if (state.backtracking>0) {state.failed=true; return current;}
                throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1())");
            }

            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getLocationAccess().getUnorderedGroup_1());

            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:599:2: (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:599:4: otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}'
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleLocation1424); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:603:1: (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )* )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==12) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:603:3: otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )*
                            {
                            otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleLocation1437); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getWithKeyword_2_1_0());
                                  
                            }
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:607:1: ( (lv_options_6_0= ruleOption ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:608:1: (lv_options_6_0= ruleOption )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:608:1: (lv_options_6_0= ruleOption )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:609:3: lv_options_6_0= ruleOption
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOption_in_ruleLocation1458);
                            lv_options_6_0=ruleOption();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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

                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:625:2: (otherlv_7= ',' ( (lv_options_8_0= ruleOption ) ) )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( (LA7_0==13) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:625:4: otherlv_7= ',' ( (lv_options_8_0= ruleOption ) )
                            	    {
                            	    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleLocation1471); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
                            	          
                            	    }
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:629:1: ( (lv_options_8_0= ruleOption ) )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:630:1: (lv_options_8_0= ruleOption )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:630:1: (lv_options_8_0= ruleOption )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:631:3: lv_options_8_0= ruleOption
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleOption_in_ruleLocation1492);
                            	    lv_options_8_0=ruleOption();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

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


                            	    }
                            	    break;

                            	default :
                            	    break loop7;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:647:6: ( (lv_ius_9_0= ruleIU ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:648:1: (lv_ius_9_0= ruleIU )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:648:1: (lv_ius_9_0= ruleIU )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:649:3: lv_ius_9_0= ruleIU
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleIU_in_ruleLocation1517);
                    	    lv_ius_9_0=ruleIU();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleLocation1530); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLocation"


    // $ANTLR start "entryRuleIU"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:677:1: entryRuleIU returns [EObject current=null] : iv_ruleIU= ruleIU EOF ;
    public final EObject entryRuleIU() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIU = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:678:2: (iv_ruleIU= ruleIU EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:679:2: iv_ruleIU= ruleIU EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIURule()); 
            }
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU1568);
            iv_ruleIU=ruleIU();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIU; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU1578); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:686:1: ruleIU returns [EObject current=null] : ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) ;
    public final EObject ruleIU() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_version_5_0=null;
        AntlrDatatypeRuleToken lv_ID_0_0 = null;

        AntlrDatatypeRuleToken lv_version_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:689:28: ( ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:2: ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:690:2: ( (lv_ID_0_0= ruleQualifiedName ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:691:1: (lv_ID_0_0= ruleQualifiedName )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:691:1: (lv_ID_0_0= ruleQualifiedName )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:692:3: lv_ID_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIUAccess().getIDQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleIU1624);
            lv_ID_0_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:708:2: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:708:4: otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleIU1637); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getIUAccess().getSemicolonKeyword_1_0());
                          
                    }
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleIU1649); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIUAccess().getVersionKeyword_1_1());
                          
                    }
                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleIU1661); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getIUAccess().getEqualsSignKeyword_1_2());
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:720:1: ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==RULE_INT||(LA11_0>=27 && LA11_0<=28)||LA11_0==31) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==RULE_STRING) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:720:2: ( (lv_version_4_0= ruleVersionRange ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:720:2: ( (lv_version_4_0= ruleVersionRange ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:721:1: (lv_version_4_0= ruleVersionRange )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:721:1: (lv_version_4_0= ruleVersionRange )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:722:3: lv_version_4_0= ruleVersionRange
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_3_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleVersionRange_in_ruleIU1683);
                            lv_version_4_0=ruleVersionRange();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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


                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:739:6: ( (lv_version_5_0= RULE_STRING ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:739:6: ( (lv_version_5_0= RULE_STRING ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:740:1: (lv_version_5_0= RULE_STRING )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:740:1: (lv_version_5_0= RULE_STRING )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:741:3: lv_version_5_0= RULE_STRING
                            {
                            lv_version_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIU1706); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_version_5_0, grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_3_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

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


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIU"


    // $ANTLR start "entryRuleQualifiedName"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:765:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:769:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:770:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1757);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1768); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:780:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:784:28: ( (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:785:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:785:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:785:6: this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1812); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:792:1: ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) && (synpred1_InternalTargetPlatform())) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:792:2: ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:792:2: ( ( '.' )=>kw= '.' )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:792:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,26,FOLLOW_26_in_ruleQualifiedName1840); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1856); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleVersion"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:818:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:822:2: (iv_ruleVersion= ruleVersion EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:823:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion1914);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion1925); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:833:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? ) ;
    public final AntlrDatatypeRuleToken ruleVersion() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_ID_6=null;
        Token this_INT_7=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:837:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:838:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:838:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:838:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1969); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:845:1: (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:846:2: kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )?
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleVersion1988); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2003); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:858:1: (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==26) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:859:2: kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )?
                            {
                            kw=(Token)match(input,26,FOLLOW_26_in_ruleVersion2022); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
                                  
                            }
                            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2037); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_4);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
                                  
                            }
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:871:1: (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==26) ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:872:2: kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT )
                                    {
                                    kw=(Token)match(input,26,FOLLOW_26_in_ruleVersion2056); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
                                          
                                    }
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:877:1: (this_ID_6= RULE_ID | this_INT_7= RULE_INT )
                                    int alt14=2;
                                    int LA14_0 = input.LA(1);

                                    if ( (LA14_0==RULE_ID) ) {
                                        alt14=1;
                                    }
                                    else if ( (LA14_0==RULE_INT) ) {
                                        alt14=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return current;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt14) {
                                        case 1 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:877:6: this_ID_6= RULE_ID
                                            {
                                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVersion2072); if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              		current.merge(this_ID_6);
                                                  
                                            }
                                            if ( state.backtracking==0 ) {
                                               
                                                  newLeafNode(this_ID_6, grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                                                  
                                            }

                                            }
                                            break;
                                        case 2 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:885:10: this_INT_7= RULE_INT
                                            {
                                            this_INT_7=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2098); if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              		current.merge(this_INT_7);
                                                  
                                            }
                                            if ( state.backtracking==0 ) {
                                               
                                                  newLeafNode(this_INT_7, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 
                                                  
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
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleVersionRange"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:903:1: entryRuleVersionRange returns [String current=null] : iv_ruleVersionRange= ruleVersionRange EOF ;
    public final String entryRuleVersionRange() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionRange = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:907:2: (iv_ruleVersionRange= ruleVersionRange EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:908:2: iv_ruleVersionRange= ruleVersionRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRangeRule()); 
            }
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange2161);
            iv_ruleVersionRange=ruleVersionRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRange.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange2172); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:918:1: ruleVersionRange returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) ;
    public final AntlrDatatypeRuleToken ruleVersionRange() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Version_2 = null;

        AntlrDatatypeRuleToken this_Version_4 = null;

        AntlrDatatypeRuleToken this_Version_7 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:922:28: ( ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:923:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:923:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 27:
            case 28:
                {
                alt20=1;
                }
                break;
            case RULE_INT:
                {
                alt20=2;
                }
                break;
            case 31:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:923:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:923:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:923:3: (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:923:3: (kw= '(' | kw= '[' )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==27) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==28) ) {
                        alt18=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:924:2: kw= '('
                            {
                            kw=(Token)match(input,27,FOLLOW_27_in_ruleVersionRange2216); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:931:2: kw= '['
                            {
                            kw=(Token)match(input,28,FOLLOW_28_in_ruleVersionRange2235); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2258);
                    this_Version_2=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Version_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleVersionRange2276); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2298);
                    this_Version_4=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Version_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:964:1: (kw= ')' | kw= ']' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==29) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==30) ) {
                        alt19=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:965:2: kw= ')'
                            {
                            kw=(Token)match(input,29,FOLLOW_29_in_ruleVersionRange2317); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:972:2: kw= ']'
                            {
                            kw=(Token)match(input,30,FOLLOW_30_in_ruleVersionRange2336); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:979:5: this_Version_7= ruleVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2366);
                    this_Version_7=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Version_7);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:991:2: kw= 'lazy'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleVersionRange2390); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLazyKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleVersionRange"


    // $ANTLR start "entryRuleLocale"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1007:1: entryRuleLocale returns [String current=null] : iv_ruleLocale= ruleLocale EOF ;
    public final String entryRuleLocale() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLocale = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1011:2: (iv_ruleLocale= ruleLocale EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1012:2: iv_ruleLocale= ruleLocale EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocaleRule()); 
            }
            pushFollow(FOLLOW_ruleLocale_in_entryRuleLocale2441);
            iv_ruleLocale=ruleLocale();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocale.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocale2452); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLocale"


    // $ANTLR start "ruleLocale"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1022:1: ruleLocale returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleLocale() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1026:28: (this_ID_0= RULE_ID )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1027:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocale2495); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getLocaleAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLocale"


    // $ANTLR start "entryRuleExecutionEnvironment"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1045:1: entryRuleExecutionEnvironment returns [String current=null] : iv_ruleExecutionEnvironment= ruleExecutionEnvironment EOF ;
    public final String entryRuleExecutionEnvironment() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExecutionEnvironment = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1049:2: (iv_ruleExecutionEnvironment= ruleExecutionEnvironment EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1050:2: iv_ruleExecutionEnvironment= ruleExecutionEnvironment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExecutionEnvironmentRule()); 
            }
            pushFollow(FOLLOW_ruleExecutionEnvironment_in_entryRuleExecutionEnvironment2550);
            iv_ruleExecutionEnvironment=ruleExecutionEnvironment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExecutionEnvironment.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionEnvironment2561); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExecutionEnvironment"


    // $ANTLR start "ruleExecutionEnvironment"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1060:1: ruleExecutionEnvironment returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleExecutionEnvironment() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1064:28: (this_ID_0= RULE_ID )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1065:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExecutionEnvironment2604); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getExecutionEnvironmentAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleExecutionEnvironment"


    // $ANTLR start "ruleOption"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1083:1: ruleOption returns [Enumerator current=null] : ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) ;
    public final Enumerator ruleOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1085:28: ( ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1086:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1086:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt21=1;
                }
                break;
            case 33:
                {
                alt21=2;
                }
                break;
            case 34:
                {
                alt21=3;
                }
                break;
            case 35:
                {
                alt21=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1086:2: (enumLiteral_0= 'requirements' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1086:2: (enumLiteral_0= 'requirements' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1086:4: enumLiteral_0= 'requirements'
                    {
                    enumLiteral_0=(Token)match(input,32,FOLLOW_32_in_ruleOption2666); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1092:6: (enumLiteral_1= 'allEnvironments' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1092:6: (enumLiteral_1= 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1092:8: enumLiteral_1= 'allEnvironments'
                    {
                    enumLiteral_1=(Token)match(input,33,FOLLOW_33_in_ruleOption2683); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1098:6: (enumLiteral_2= 'source' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1098:6: (enumLiteral_2= 'source' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1098:8: enumLiteral_2= 'source'
                    {
                    enumLiteral_2=(Token)match(input,34,FOLLOW_34_in_ruleOption2700); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1104:6: (enumLiteral_3= 'configurePhase' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1104:6: (enumLiteral_3= 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1104:8: enumLiteral_3= 'configurePhase'
                    {
                    enumLiteral_3=(Token)match(input,35,FOLLOW_35_in_ruleOption2717); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOption"

    // $ANTLR start synpred1_InternalTargetPlatform
    public final void synpred1_InternalTargetPlatform_fragment() throws RecognitionException {   
        // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:792:3: ( '.' )
        // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:793:2: '.'
        {
        match(input,26,FOLLOW_26_in_synpred1_InternalTargetPlatform1831); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalTargetPlatform

    // Delegated rules

    public final boolean synpred1_InternalTargetPlatform() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalTargetPlatform_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\14\uffff";
    static final String DFA5_eofS =
        "\1\1\13\uffff";
    static final String DFA5_minS =
        "\1\14\1\uffff\5\0\5\uffff";
    static final String DFA5_maxS =
        "\1\24\1\uffff\5\0\5\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\6\5\uffff\1\1\1\2\1\3\1\4\1\5";
    static final String DFA5_specialS =
        "\2\uffff\1\1\1\0\1\4\1\3\1\2\5\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\2\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()+ loopback of 274:3: ( ({...}? => ( ({...}? => (otherlv_1= 'operatingSystem' ( (lv_operatingSystem_2_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= 'windowingSystem' ( (lv_windowingSystem_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'architecture' ( (lv_architecture_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'localization' ( (lv_localization_8_0= ruleLocale ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'executionEnvironment' ( (lv_executionEnvironment_10_0= ruleExecutionEnvironment ) ) ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_3 = input.LA(1);

                         
                        int index5_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 1) ) {s = 8;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_2 = input.LA(1);

                         
                        int index5_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 0) ) {s = 7;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 4) ) {s = 11;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 3) ) {s = 10;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup(), 2) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetPlatform85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTargetPlatform122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTargetPlatform139 = new BitSet(new long[]{0x00000000001FD002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_ruleTargetPlatform165 = new BitSet(new long[]{0x00000000001FD002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_entryRuleTargetContent203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetContent213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleTargetContent260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_ruleTargetContent287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_ruleTargetContent314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_ruleTargetContent341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_entryRuleOptions376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptions386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOptions423 = new BitSet(new long[]{0x0000000F00000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions444 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleOptions457 = new BitSet(new long[]{0x0000000F00000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions478 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_entryRuleEnvironment516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnvironment526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleEnvironment608 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment625 = new BitSet(new long[]{0x000000000007C002L});
    public static final BitSet FOLLOW_15_in_ruleEnvironment698 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment715 = new BitSet(new long[]{0x000000000007C002L});
    public static final BitSet FOLLOW_16_in_ruleEnvironment788 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment805 = new BitSet(new long[]{0x000000000007C002L});
    public static final BitSet FOLLOW_17_in_ruleEnvironment878 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleLocale_in_ruleEnvironment899 = new BitSet(new long[]{0x000000000007C002L});
    public static final BitSet FOLLOW_18_in_ruleEnvironment967 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExecutionEnvironment_in_ruleEnvironment988 = new BitSet(new long[]{0x000000000007C002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration1070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDeclaration1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleIncludeDeclaration1117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIncludeDeclaration1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation1175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleLocation1222 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocation1284 = new BitSet(new long[]{0x0000000000200032L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLocation1360 = new BitSet(new long[]{0x0000000000200032L});
    public static final BitSet FOLLOW_21_in_ruleLocation1424 = new BitSet(new long[]{0x0000000000401020L});
    public static final BitSet FOLLOW_12_in_ruleLocation1437 = new BitSet(new long[]{0x0000000F00000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1458 = new BitSet(new long[]{0x0000000000402020L});
    public static final BitSet FOLLOW_13_in_ruleLocation1471 = new BitSet(new long[]{0x0000000F00000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1492 = new BitSet(new long[]{0x0000000000402020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation1517 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_22_in_ruleLocation1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU1568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleIU1624 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleIU1637 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleIU1649 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleIU1661 = new BitSet(new long[]{0x0000000098000050L});
    public static final BitSet FOLLOW_ruleVersionRange_in_ruleIU1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIU1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1812 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleQualifiedName1840 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1856 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion1914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1969 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVersion1988 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2003 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVersion2022 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2037 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVersion2056 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVersion2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange2161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVersionRange2216 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_28_in_ruleVersionRange2235 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2258 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVersionRange2276 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2298 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleVersionRange2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVersionRange2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVersionRange2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocale_in_entryRuleLocale2441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocale2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocale2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionEnvironment_in_entryRuleExecutionEnvironment2550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionEnvironment2561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExecutionEnvironment2604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOption2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOption2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOption2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOption2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred1_InternalTargetPlatform1831 = new BitSet(new long[]{0x0000000000000002L});

}
