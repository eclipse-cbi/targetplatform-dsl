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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "'with'", "','", "'environment'", "'operatingSystem'", "'windowingSystem'", "'architecture'", "'localization'", "'executionEnvironment'", "'include'", "'location'", "'{'", "'}'", "';'", "'version'", "'='", "'.'", "'('", "'['", "')'", "']'", "'lazy'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'"
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
    public static final int T__36=36;
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

                        if ( (LA1_0==12||LA1_0==14||(LA1_0>=20 && LA1_0<=21)) ) {
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:198:1: ruleOptions returns [EObject current=null] : (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* ) ;
    public final EObject ruleOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_options_1_0 = null;

        Enumerator lv_options_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:201:28: ( (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:1: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:1: (otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:202:3: otherlv_0= 'with' ( (lv_options_1_0= ruleOption ) ) ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )*
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

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:2: ( (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13||(LA5_0>=33 && LA5_0<=36)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:3: (otherlv_2= ',' )? ( (lv_options_3_0= ruleOption ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:3: (otherlv_2= ',' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==13) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:224:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleOptions458); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getOptionsAccess().getCommaKeyword_2_0());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:228:3: ( (lv_options_3_0= ruleOption ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:229:1: (lv_options_3_0= ruleOption )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:229:1: (lv_options_3_0= ruleOption )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:230:3: lv_options_3_0= ruleOption
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOption_in_ruleOptions481);
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
            	    break loop5;
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
            pushFollow(FOLLOW_ruleEnvironment_in_entryRuleEnvironment519);
            iv_ruleEnvironment=ruleEnvironment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnvironment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnvironment529); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:263:1: ruleEnvironment returns [EObject current=null] : ( () otherlv_1= 'environment' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_operatingSystem_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_windowingSystem_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_architecture_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_localization_13_0 = null;

        AntlrDatatypeRuleToken lv_executionEnvironment_16_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:266:28: ( ( () otherlv_1= 'environment' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* ) ) ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:1: ( () otherlv_1= 'environment' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* ) ) ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:1: ( () otherlv_1= 'environment' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* ) ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:2: () otherlv_1= 'environment' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* ) ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:2: ()
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:268:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEnvironmentAccess().getEnvironmentAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleEnvironment575); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:277:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:279:1: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:279:1: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:280:2: ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2());
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:283:2: ( ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:284:3: ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )*
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:284:3: ( ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) ) )*
            loop11:
            do {
                int alt11=6;
                int LA11_0 = input.LA(1);

                if ( LA11_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 0) ) {
                    alt11=1;
                }
                else if ( LA11_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 1) ) {
                    alt11=2;
                }
                else if ( LA11_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 2) ) {
                    alt11=3;
                }
                else if ( LA11_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 3) ) {
                    alt11=4;
                }
                else if ( LA11_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 4) ) {
                    alt11=5;
                }


                switch (alt11) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:286:4: ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:286:4: ({...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:287:5: {...}? => ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:287:108: ( ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:288:6: ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 0);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:291:6: ({...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:291:7: {...}? => (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:291:16: (otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )? )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:291:18: otherlv_3= 'operatingSystem' ( (lv_operatingSystem_4_0= RULE_ID ) ) (otherlv_5= ',' )?
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleEnvironment633); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getEnvironmentAccess().getOperatingSystemKeyword_2_0_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:295:1: ( (lv_operatingSystem_4_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:296:1: (lv_operatingSystem_4_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:296:1: (lv_operatingSystem_4_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:297:3: lv_operatingSystem_4_0= RULE_ID
            	    {
            	    lv_operatingSystem_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment650); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_operatingSystem_4_0, grammarAccess.getEnvironmentAccess().getOperatingSystemIDTerminalRuleCall_2_0_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"operatingSystem",
            	              		lv_operatingSystem_4_0, 
            	              		"ID");
            	      	    
            	    }

            	    }


            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:313:2: (otherlv_5= ',' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==13) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:313:4: otherlv_5= ','
            	            {
            	            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleEnvironment668); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_5, grammarAccess.getEnvironmentAccess().getCommaKeyword_2_0_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:324:4: ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:324:4: ({...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:325:5: {...}? => ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:325:108: ( ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:326:6: ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 1);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:329:6: ({...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:329:7: {...}? => (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:329:16: (otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )? )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:329:18: otherlv_6= 'windowingSystem' ( (lv_windowingSystem_7_0= RULE_ID ) ) (otherlv_8= ',' )?
            	    {
            	    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleEnvironment738); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getEnvironmentAccess().getWindowingSystemKeyword_2_1_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:333:1: ( (lv_windowingSystem_7_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:334:1: (lv_windowingSystem_7_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:334:1: (lv_windowingSystem_7_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:335:3: lv_windowingSystem_7_0= RULE_ID
            	    {
            	    lv_windowingSystem_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment755); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_windowingSystem_7_0, grammarAccess.getEnvironmentAccess().getWindowingSystemIDTerminalRuleCall_2_1_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"windowingSystem",
            	              		lv_windowingSystem_7_0, 
            	              		"ID");
            	      	    
            	    }

            	    }


            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:351:2: (otherlv_8= ',' )?
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==13) ) {
            	        alt7=1;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:351:4: otherlv_8= ','
            	            {
            	            otherlv_8=(Token)match(input,13,FOLLOW_13_in_ruleEnvironment773); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_8, grammarAccess.getEnvironmentAccess().getCommaKeyword_2_1_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:362:4: ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:362:4: ({...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:363:5: {...}? => ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:363:108: ( ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:364:6: ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 2);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:367:6: ({...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:367:7: {...}? => (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:367:16: (otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )? )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:367:18: otherlv_9= 'architecture' ( (lv_architecture_10_0= RULE_ID ) ) (otherlv_11= ',' )?
            	    {
            	    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleEnvironment843); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getEnvironmentAccess().getArchitectureKeyword_2_2_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:371:1: ( (lv_architecture_10_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:372:1: (lv_architecture_10_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:372:1: (lv_architecture_10_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:373:3: lv_architecture_10_0= RULE_ID
            	    {
            	    lv_architecture_10_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnvironment860); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_architecture_10_0, grammarAccess.getEnvironmentAccess().getArchitectureIDTerminalRuleCall_2_2_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"architecture",
            	              		lv_architecture_10_0, 
            	              		"ID");
            	      	    
            	    }

            	    }


            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:389:2: (otherlv_11= ',' )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==13) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:389:4: otherlv_11= ','
            	            {
            	            otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleEnvironment878); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_11, grammarAccess.getEnvironmentAccess().getCommaKeyword_2_2_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:400:4: ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:400:4: ({...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:401:5: {...}? => ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:401:108: ( ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:402:6: ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 3);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:405:6: ({...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:405:7: {...}? => (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:405:16: (otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )? )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:405:18: otherlv_12= 'localization' ( (lv_localization_13_0= ruleLocale ) ) (otherlv_14= ',' )?
            	    {
            	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleEnvironment948); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_12, grammarAccess.getEnvironmentAccess().getLocalizationKeyword_2_3_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:409:1: ( (lv_localization_13_0= ruleLocale ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:410:1: (lv_localization_13_0= ruleLocale )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:410:1: (lv_localization_13_0= ruleLocale )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:411:3: lv_localization_13_0= ruleLocale
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEnvironmentAccess().getLocalizationLocaleParserRuleCall_2_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLocale_in_ruleEnvironment969);
            	    lv_localization_13_0=ruleLocale();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"localization",
            	              		lv_localization_13_0, 
            	              		"Locale");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:427:2: (otherlv_14= ',' )?
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==13) ) {
            	        alt9=1;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:427:4: otherlv_14= ','
            	            {
            	            otherlv_14=(Token)match(input,13,FOLLOW_13_in_ruleEnvironment982); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getEnvironmentAccess().getCommaKeyword_2_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:438:4: ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:438:4: ({...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:439:5: {...}? => ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 4)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:439:108: ( ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:440:6: ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2(), 4);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:443:6: ({...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:443:7: {...}? => (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleEnvironment", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:443:16: (otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )? )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:443:18: otherlv_15= 'executionEnvironment' ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) ) (otherlv_17= ',' )?
            	    {
            	    otherlv_15=(Token)match(input,19,FOLLOW_19_in_ruleEnvironment1052); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_15, grammarAccess.getEnvironmentAccess().getExecutionEnvironmentKeyword_2_4_0());
            	          
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:447:1: ( (lv_executionEnvironment_16_0= ruleExecutionEnvironment ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:448:1: (lv_executionEnvironment_16_0= ruleExecutionEnvironment )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:448:1: (lv_executionEnvironment_16_0= ruleExecutionEnvironment )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:449:3: lv_executionEnvironment_16_0= ruleExecutionEnvironment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEnvironmentAccess().getExecutionEnvironmentExecutionEnvironmentParserRuleCall_2_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExecutionEnvironment_in_ruleEnvironment1073);
            	    lv_executionEnvironment_16_0=ruleExecutionEnvironment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"executionEnvironment",
            	              		lv_executionEnvironment_16_0, 
            	              		"ExecutionEnvironment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:465:2: (otherlv_17= ',' )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==13) ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:465:4: otherlv_17= ','
            	            {
            	            otherlv_17=(Token)match(input,13,FOLLOW_13_in_ruleEnvironment1086); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_17, grammarAccess.getEnvironmentAccess().getCommaKeyword_2_4_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getEnvironmentAccess().getUnorderedGroup_2());

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
    // $ANTLR end "ruleEnvironment"


    // $ANTLR start "entryRuleIncludeDeclaration"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:491:1: entryRuleIncludeDeclaration returns [EObject current=null] : iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF ;
    public final EObject entryRuleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDeclaration = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:492:2: (iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:493:2: iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration1165);
            iv_ruleIncludeDeclaration=ruleIncludeDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIncludeDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDeclaration1175); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:500:1: ruleIncludeDeclaration returns [EObject current=null] : (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:503:28: ( (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:504:1: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:504:1: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:504:3: otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleIncludeDeclaration1212); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:508:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:509:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:509:1: (lv_importURI_1_0= RULE_STRING )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:510:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIncludeDeclaration1229); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:534:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:535:2: (iv_ruleLocation= ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:536:2: iv_ruleLocation= ruleLocation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocationRule()); 
            }
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation1270);
            iv_ruleLocation=ruleLocation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation1280); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:543:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:546:28: ( (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:547:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:547:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:547:3: otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleLocation1317); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:551:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:553:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:553:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:554:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            {
            getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:557:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:558:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:558:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( LA12_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                    alt12=1;
                }
                else if ( LA12_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:560:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:560:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:561:5: {...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:561:105: ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:562:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:565:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:565:7: {...}? => ( (lv_ID_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:565:16: ( (lv_ID_2_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:566:1: (lv_ID_2_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:566:1: (lv_ID_2_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:567:3: lv_ID_2_0= RULE_ID
            	    {
            	    lv_ID_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocation1379); if (state.failed) return current;
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
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:590:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:590:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:591:5: {...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:591:105: ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:592:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:595:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:595:7: {...}? => ( (lv_uri_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:595:16: ( (lv_uri_3_0= RULE_STRING ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:596:1: (lv_uri_3_0= RULE_STRING )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:596:1: (lv_uri_3_0= RULE_STRING )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:597:3: lv_uri_3_0= RULE_STRING
            	    {
            	    lv_uri_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLocation1455); if (state.failed) return current;
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
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1()) ) {
                if (state.backtracking>0) {state.failed=true; return current;}
                throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1())");
            }

            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getLocationAccess().getUnorderedGroup_1());

            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:628:2: (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:628:4: otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}'
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleLocation1519); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:632:1: (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==12) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:632:3: otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            {
                            otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleLocation1532); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getWithKeyword_2_1_0());
                                  
                            }
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:636:1: ( (lv_options_6_0= ruleOption ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:637:1: (lv_options_6_0= ruleOption )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:637:1: (lv_options_6_0= ruleOption )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:638:3: lv_options_6_0= ruleOption
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOption_in_ruleLocation1553);
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

                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:654:2: ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13||(LA14_0>=33 && LA14_0<=36)) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:654:3: (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:654:3: (otherlv_7= ',' )?
                            	    int alt13=2;
                            	    int LA13_0 = input.LA(1);

                            	    if ( (LA13_0==13) ) {
                            	        alt13=1;
                            	    }
                            	    switch (alt13) {
                            	        case 1 :
                            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:654:5: otherlv_7= ','
                            	            {
                            	            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleLocation1567); if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	                  	newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
                            	                  
                            	            }

                            	            }
                            	            break;

                            	    }

                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:658:3: ( (lv_options_8_0= ruleOption ) )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:659:1: (lv_options_8_0= ruleOption )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:659:1: (lv_options_8_0= ruleOption )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:660:3: lv_options_8_0= ruleOption
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleOption_in_ruleLocation1590);
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
                            	    break loop14;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:676:6: ( (lv_ius_9_0= ruleIU ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:677:1: (lv_ius_9_0= ruleIU )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:677:1: (lv_ius_9_0= ruleIU )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:678:3: lv_ius_9_0= ruleIU
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleIU_in_ruleLocation1615);
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
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,23,FOLLOW_23_in_ruleLocation1628); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:706:1: entryRuleIU returns [EObject current=null] : iv_ruleIU= ruleIU EOF ;
    public final EObject entryRuleIU() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIU = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:707:2: (iv_ruleIU= ruleIU EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:708:2: iv_ruleIU= ruleIU EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIURule()); 
            }
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU1666);
            iv_ruleIU=ruleIU();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIU; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU1676); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:715:1: ruleIU returns [EObject current=null] : ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:718:28: ( ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:719:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:719:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:719:2: ( (lv_ID_0_0= ruleQualifiedName ) ) (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:719:2: ( (lv_ID_0_0= ruleQualifiedName ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:720:1: (lv_ID_0_0= ruleQualifiedName )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:720:1: (lv_ID_0_0= ruleQualifiedName )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:721:3: lv_ID_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIUAccess().getIDQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleIU1722);
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

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:737:2: (otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:737:4: otherlv_1= ';' otherlv_2= 'version' otherlv_3= '=' ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleIU1735); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getIUAccess().getSemicolonKeyword_1_0());
                          
                    }
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleIU1747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIUAccess().getVersionKeyword_1_1());
                          
                    }
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleIU1759); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getIUAccess().getEqualsSignKeyword_1_2());
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:749:1: ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_INT||(LA18_0>=28 && LA18_0<=29)||LA18_0==32) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==RULE_STRING) ) {
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
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:749:2: ( (lv_version_4_0= ruleVersionRange ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:749:2: ( (lv_version_4_0= ruleVersionRange ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:750:1: (lv_version_4_0= ruleVersionRange )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:750:1: (lv_version_4_0= ruleVersionRange )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:751:3: lv_version_4_0= ruleVersionRange
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_3_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleVersionRange_in_ruleIU1781);
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
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:768:6: ( (lv_version_5_0= RULE_STRING ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:768:6: ( (lv_version_5_0= RULE_STRING ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:769:1: (lv_version_5_0= RULE_STRING )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:769:1: (lv_version_5_0= RULE_STRING )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:770:3: lv_version_5_0= RULE_STRING
                            {
                            lv_version_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIU1804); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:794:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:798:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:799:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1855);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1866); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:809:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:813:28: ( (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:814:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:814:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:814:6: this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1910); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:821:1: ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==27) && (synpred1_InternalTargetPlatform())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:821:2: ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:821:2: ( ( '.' )=>kw= '.' )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:821:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,27,FOLLOW_27_in_ruleQualifiedName1938); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1954); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:847:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:851:2: (iv_ruleVersion= ruleVersion EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:852:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion2012);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion2023); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:862:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:866:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:867:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:867:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:867:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:874:1: (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==27) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:875:2: kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )?
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleVersion2086); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2101); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:887:1: (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==27) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:888:2: kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )?
                            {
                            kw=(Token)match(input,27,FOLLOW_27_in_ruleVersion2120); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
                                  
                            }
                            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2135); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_4);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
                                  
                            }
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:900:1: (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==27) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:901:2: kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT )
                                    {
                                    kw=(Token)match(input,27,FOLLOW_27_in_ruleVersion2154); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
                                          
                                    }
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:906:1: (this_ID_6= RULE_ID | this_INT_7= RULE_INT )
                                    int alt21=2;
                                    int LA21_0 = input.LA(1);

                                    if ( (LA21_0==RULE_ID) ) {
                                        alt21=1;
                                    }
                                    else if ( (LA21_0==RULE_INT) ) {
                                        alt21=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return current;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 21, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt21) {
                                        case 1 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:906:6: this_ID_6= RULE_ID
                                            {
                                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVersion2170); if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              		current.merge(this_ID_6);
                                                  
                                            }
                                            if ( state.backtracking==0 ) {
                                               
                                                  newLeafNode(this_ID_6, grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                                                  
                                            }

                                            }
                                            break;
                                        case 2 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:914:10: this_INT_7= RULE_INT
                                            {
                                            this_INT_7=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion2196); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:932:1: entryRuleVersionRange returns [String current=null] : iv_ruleVersionRange= ruleVersionRange EOF ;
    public final String entryRuleVersionRange() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionRange = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:936:2: (iv_ruleVersionRange= ruleVersionRange EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:937:2: iv_ruleVersionRange= ruleVersionRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRangeRule()); 
            }
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange2259);
            iv_ruleVersionRange=ruleVersionRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRange.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange2270); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:947:1: ruleVersionRange returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) ;
    public final AntlrDatatypeRuleToken ruleVersionRange() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Version_2 = null;

        AntlrDatatypeRuleToken this_Version_4 = null;

        AntlrDatatypeRuleToken this_Version_7 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:951:28: ( ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:952:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:952:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 28:
            case 29:
                {
                alt27=1;
                }
                break;
            case RULE_INT:
                {
                alt27=2;
                }
                break;
            case 32:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:952:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:952:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:952:3: (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:952:3: (kw= '(' | kw= '[' )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==28) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==29) ) {
                        alt25=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:953:2: kw= '('
                            {
                            kw=(Token)match(input,28,FOLLOW_28_in_ruleVersionRange2314); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:960:2: kw= '['
                            {
                            kw=(Token)match(input,29,FOLLOW_29_in_ruleVersionRange2333); if (state.failed) return current;
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
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2356);
                    this_Version_2=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Version_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleVersionRange2374); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2396);
                    this_Version_4=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Version_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:993:1: (kw= ')' | kw= ']' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==30) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==31) ) {
                        alt26=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:994:2: kw= ')'
                            {
                            kw=(Token)match(input,30,FOLLOW_30_in_ruleVersionRange2415); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1001:2: kw= ']'
                            {
                            kw=(Token)match(input,31,FOLLOW_31_in_ruleVersionRange2434); if (state.failed) return current;
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
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1008:5: this_Version_7= ruleVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange2464);
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
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1020:2: kw= 'lazy'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleVersionRange2488); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1036:1: entryRuleLocale returns [String current=null] : iv_ruleLocale= ruleLocale EOF ;
    public final String entryRuleLocale() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLocale = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1040:2: (iv_ruleLocale= ruleLocale EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1041:2: iv_ruleLocale= ruleLocale EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocaleRule()); 
            }
            pushFollow(FOLLOW_ruleLocale_in_entryRuleLocale2539);
            iv_ruleLocale=ruleLocale();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocale.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocale2550); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1051:1: ruleLocale returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleLocale() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1055:28: (this_ID_0= RULE_ID )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1056:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocale2593); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1074:1: entryRuleExecutionEnvironment returns [String current=null] : iv_ruleExecutionEnvironment= ruleExecutionEnvironment EOF ;
    public final String entryRuleExecutionEnvironment() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExecutionEnvironment = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1078:2: (iv_ruleExecutionEnvironment= ruleExecutionEnvironment EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1079:2: iv_ruleExecutionEnvironment= ruleExecutionEnvironment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExecutionEnvironmentRule()); 
            }
            pushFollow(FOLLOW_ruleExecutionEnvironment_in_entryRuleExecutionEnvironment2648);
            iv_ruleExecutionEnvironment=ruleExecutionEnvironment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExecutionEnvironment.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionEnvironment2659); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1089:1: ruleExecutionEnvironment returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )* ) ;
    public final AntlrDatatypeRuleToken ruleExecutionEnvironment() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1093:28: ( (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1094:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1094:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1094:6: this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExecutionEnvironment2703); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getExecutionEnvironmentAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1101:1: ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==27) && (synpred2_InternalTargetPlatform())) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1101:2: ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1101:2: ( ( '.' )=>kw= '.' )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1101:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,27,FOLLOW_27_in_ruleExecutionEnvironment2731); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getExecutionEnvironmentAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1109:2: (this_ID_2= RULE_ID | this_INT_3= RULE_INT )
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==RULE_ID) ) {
            	        alt28=1;
            	    }
            	    else if ( (LA28_0==RULE_INT) ) {
            	        alt28=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1109:7: this_ID_2= RULE_ID
            	            {
            	            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExecutionEnvironment2748); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              		current.merge(this_ID_2);
            	                  
            	            }
            	            if ( state.backtracking==0 ) {
            	               
            	                  newLeafNode(this_ID_2, grammarAccess.getExecutionEnvironmentAccess().getIDTerminalRuleCall_1_1_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1117:10: this_INT_3= RULE_INT
            	            {
            	            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleExecutionEnvironment2774); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              		current.merge(this_INT_3);
            	                  
            	            }
            	            if ( state.backtracking==0 ) {
            	               
            	                  newLeafNode(this_INT_3, grammarAccess.getExecutionEnvironmentAccess().getINTTerminalRuleCall_1_1_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // $ANTLR end "ruleExecutionEnvironment"


    // $ANTLR start "ruleOption"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1135:1: ruleOption returns [Enumerator current=null] : ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) ;
    public final Enumerator ruleOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1137:28: ( ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1138:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1138:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt30=1;
                }
                break;
            case 34:
                {
                alt30=2;
                }
                break;
            case 35:
                {
                alt30=3;
                }
                break;
            case 36:
                {
                alt30=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1138:2: (enumLiteral_0= 'requirements' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1138:2: (enumLiteral_0= 'requirements' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1138:4: enumLiteral_0= 'requirements'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_33_in_ruleOption2840); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1144:6: (enumLiteral_1= 'allEnvironments' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1144:6: (enumLiteral_1= 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1144:8: enumLiteral_1= 'allEnvironments'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_34_in_ruleOption2857); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1150:6: (enumLiteral_2= 'source' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1150:6: (enumLiteral_2= 'source' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1150:8: enumLiteral_2= 'source'
                    {
                    enumLiteral_2=(Token)match(input,35,FOLLOW_35_in_ruleOption2874); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1156:6: (enumLiteral_3= 'configurePhase' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1156:6: (enumLiteral_3= 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1156:8: enumLiteral_3= 'configurePhase'
                    {
                    enumLiteral_3=(Token)match(input,36,FOLLOW_36_in_ruleOption2891); if (state.failed) return current;
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
        // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:821:3: ( '.' )
        // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:822:2: '.'
        {
        match(input,27,FOLLOW_27_in_synpred1_InternalTargetPlatform1929); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalTargetPlatform

    // $ANTLR start synpred2_InternalTargetPlatform
    public final void synpred2_InternalTargetPlatform_fragment() throws RecognitionException {   
        // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1101:3: ( '.' )
        // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:1102:2: '.'
        {
        match(input,27,FOLLOW_27_in_synpred2_InternalTargetPlatform2722); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalTargetPlatform

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
    public final boolean synpred2_InternalTargetPlatform() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalTargetPlatform_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetPlatform85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTargetPlatform122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTargetPlatform139 = new BitSet(new long[]{0x0000000000305002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_ruleTargetPlatform165 = new BitSet(new long[]{0x0000000000305002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_entryRuleTargetContent203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetContent213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleTargetContent260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_ruleTargetContent287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_ruleTargetContent314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_ruleTargetContent341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_entryRuleOptions376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptions386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOptions423 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions444 = new BitSet(new long[]{0x0000001E00002002L});
    public static final BitSet FOLLOW_13_in_ruleOptions458 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions481 = new BitSet(new long[]{0x0000001E00002002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_entryRuleEnvironment519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnvironment529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleEnvironment575 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_15_in_ruleEnvironment633 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment650 = new BitSet(new long[]{0x00000000000FA002L});
    public static final BitSet FOLLOW_13_in_ruleEnvironment668 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_16_in_ruleEnvironment738 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment755 = new BitSet(new long[]{0x00000000000FA002L});
    public static final BitSet FOLLOW_13_in_ruleEnvironment773 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_17_in_ruleEnvironment843 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnvironment860 = new BitSet(new long[]{0x00000000000FA002L});
    public static final BitSet FOLLOW_13_in_ruleEnvironment878 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_18_in_ruleEnvironment948 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleLocale_in_ruleEnvironment969 = new BitSet(new long[]{0x00000000000FA002L});
    public static final BitSet FOLLOW_13_in_ruleEnvironment982 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_19_in_ruleEnvironment1052 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExecutionEnvironment_in_ruleEnvironment1073 = new BitSet(new long[]{0x00000000000FA002L});
    public static final BitSet FOLLOW_13_in_ruleEnvironment1086 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration1165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDeclaration1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleIncludeDeclaration1212 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIncludeDeclaration1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation1270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleLocation1317 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocation1379 = new BitSet(new long[]{0x0000000000400032L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLocation1455 = new BitSet(new long[]{0x0000000000400032L});
    public static final BitSet FOLLOW_22_in_ruleLocation1519 = new BitSet(new long[]{0x0000000000801020L});
    public static final BitSet FOLLOW_12_in_ruleLocation1532 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1553 = new BitSet(new long[]{0x0000001E00802020L});
    public static final BitSet FOLLOW_13_in_ruleLocation1567 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1590 = new BitSet(new long[]{0x0000001E00802020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation1615 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_ruleLocation1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU1666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleIU1722 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleIU1735 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleIU1747 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIU1759 = new BitSet(new long[]{0x0000000130000050L});
    public static final BitSet FOLLOW_ruleVersionRange_in_ruleIU1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIU1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1910 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleQualifiedName1938 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1954 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion2012 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2067 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleVersion2086 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2101 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleVersion2120 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2135 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleVersion2154 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVersion2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange2259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVersionRange2314 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_29_in_ruleVersionRange2333 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2356 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVersionRange2374 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2396 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleVersionRange2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVersionRange2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVersionRange2488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocale_in_entryRuleLocale2539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocale2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocale2593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionEnvironment_in_entryRuleExecutionEnvironment2648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionEnvironment2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExecutionEnvironment2703 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleExecutionEnvironment2731 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExecutionEnvironment2748 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleExecutionEnvironment2774 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_33_in_ruleOption2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOption2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOption2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOption2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred1_InternalTargetPlatform1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred2_InternalTargetPlatform2722 = new BitSet(new long[]{0x0000000000000002L});

}
