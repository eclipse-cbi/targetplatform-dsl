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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "'with'", "','", "'environment'", "'include'", "'location'", "'{'", "'}'", "';'", "'version'", "'='", "'.'", "'('", "'['", "')'", "']'", "'lazy'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'"
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

                        if ( (LA1_0==12||(LA1_0>=14 && LA1_0<=16)) ) {
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
            case 15:
                {
                alt3=3;
                }
                break;
            case 16:
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

                if ( (LA5_0==13||(LA5_0>=28 && LA5_0<=31)) ) {
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:263:1: ruleEnvironment returns [EObject current=null] : (otherlv_0= 'environment' ( (lv_env_1_0= ruleQualifiedName ) ) ( (otherlv_2= ',' )? ( (lv_env_3_0= ruleQualifiedName ) ) )* ) ;
    public final EObject ruleEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_env_1_0 = null;

        AntlrDatatypeRuleToken lv_env_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:266:28: ( (otherlv_0= 'environment' ( (lv_env_1_0= ruleQualifiedName ) ) ( (otherlv_2= ',' )? ( (lv_env_3_0= ruleQualifiedName ) ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:1: (otherlv_0= 'environment' ( (lv_env_1_0= ruleQualifiedName ) ) ( (otherlv_2= ',' )? ( (lv_env_3_0= ruleQualifiedName ) ) )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:1: (otherlv_0= 'environment' ( (lv_env_1_0= ruleQualifiedName ) ) ( (otherlv_2= ',' )? ( (lv_env_3_0= ruleQualifiedName ) ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:267:3: otherlv_0= 'environment' ( (lv_env_1_0= ruleQualifiedName ) ) ( (otherlv_2= ',' )? ( (lv_env_3_0= ruleQualifiedName ) ) )*
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleEnvironment566); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_0());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:271:1: ( (lv_env_1_0= ruleQualifiedName ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:272:1: (lv_env_1_0= ruleQualifiedName )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:272:1: (lv_env_1_0= ruleQualifiedName )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:273:3: lv_env_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEnvironmentAccess().getEnvQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleEnvironment587);
            lv_env_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEnvironmentRule());
              	        }
                     		add(
                     			current, 
                     			"env",
                      		lv_env_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:289:2: ( (otherlv_2= ',' )? ( (lv_env_3_0= ruleQualifiedName ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:289:3: (otherlv_2= ',' )? ( (lv_env_3_0= ruleQualifiedName ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:289:3: (otherlv_2= ',' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==13) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:289:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleEnvironment601); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getEnvironmentAccess().getCommaKeyword_2_0());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:293:3: ( (lv_env_3_0= ruleQualifiedName ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:294:1: (lv_env_3_0= ruleQualifiedName )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:294:1: (lv_env_3_0= ruleQualifiedName )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:295:3: lv_env_3_0= ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEnvironmentAccess().getEnvQualifiedNameParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleEnvironment624);
            	    lv_env_3_0=ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEnvironmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"env",
            	              		lv_env_3_0, 
            	              		"QualifiedName");
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:319:1: entryRuleIncludeDeclaration returns [EObject current=null] : iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF ;
    public final EObject entryRuleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDeclaration = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:320:2: (iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:321:2: iv_ruleIncludeDeclaration= ruleIncludeDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration662);
            iv_ruleIncludeDeclaration=ruleIncludeDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIncludeDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDeclaration672); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:328:1: ruleIncludeDeclaration returns [EObject current=null] : (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleIncludeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:331:28: ( (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:332:1: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:332:1: (otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:332:3: otherlv_0= 'include' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleIncludeDeclaration709); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:336:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:337:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:337:1: (lv_importURI_1_0= RULE_STRING )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:338:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIncludeDeclaration726); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:362:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:363:2: (iv_ruleLocation= ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:364:2: iv_ruleLocation= ruleLocation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocationRule()); 
            }
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation767);
            iv_ruleLocation=ruleLocation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation777); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:371:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:374:28: ( (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:375:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:375:1: (otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:375:3: otherlv_0= 'location' ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleLocation814); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:379:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:381:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:381:1: ( ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:382:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            {
            getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:385:2: ( ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:386:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+ {...}?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:386:3: ( ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) ) )+
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
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:388:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:388:4: ({...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:389:5: {...}? => ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:389:105: ( ({...}? => ( (lv_ID_2_0= RULE_ID ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:390:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:393:6: ({...}? => ( (lv_ID_2_0= RULE_ID ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:393:7: {...}? => ( (lv_ID_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:393:16: ( (lv_ID_2_0= RULE_ID ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:394:1: (lv_ID_2_0= RULE_ID )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:394:1: (lv_ID_2_0= RULE_ID )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:395:3: lv_ID_2_0= RULE_ID
            	    {
            	    lv_ID_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocation876); if (state.failed) return current;
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
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:418:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:418:4: ({...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:419:5: {...}? => ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:419:105: ( ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:420:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:423:6: ({...}? => ( (lv_uri_3_0= RULE_STRING ) ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:423:7: {...}? => ( (lv_uri_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLocation", "true");
            	    }
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:423:16: ( (lv_uri_3_0= RULE_STRING ) )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:424:1: (lv_uri_3_0= RULE_STRING )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:424:1: (lv_uri_3_0= RULE_STRING )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:425:3: lv_uri_3_0= RULE_STRING
            	    {
            	    lv_uri_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLocation952); if (state.failed) return current;
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
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1()) ) {
                if (state.backtracking>0) {state.failed=true; return current;}
                throw new FailedPredicateException(input, "ruleLocation", "getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1())");
            }

            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getLocationAccess().getUnorderedGroup_1());

            }

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:456:2: (otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:456:4: otherlv_4= '{' (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )? ( (lv_ius_9_0= ruleIU ) )* otherlv_10= '}'
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleLocation1016); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:460:1: (otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==12) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:460:3: otherlv_5= 'with' ( (lv_options_6_0= ruleOption ) ) ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            {
                            otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleLocation1029); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getWithKeyword_2_1_0());
                                  
                            }
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:464:1: ( (lv_options_6_0= ruleOption ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:465:1: (lv_options_6_0= ruleOption )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:465:1: (lv_options_6_0= ruleOption )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:466:3: lv_options_6_0= ruleOption
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOption_in_ruleLocation1050);
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

                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:482:2: ( (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) ) )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==13||(LA10_0>=28 && LA10_0<=31)) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:482:3: (otherlv_7= ',' )? ( (lv_options_8_0= ruleOption ) )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:482:3: (otherlv_7= ',' )?
                            	    int alt9=2;
                            	    int LA9_0 = input.LA(1);

                            	    if ( (LA9_0==13) ) {
                            	        alt9=1;
                            	    }
                            	    switch (alt9) {
                            	        case 1 :
                            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:482:5: otherlv_7= ','
                            	            {
                            	            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleLocation1064); if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	                  	newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0());
                            	                  
                            	            }

                            	            }
                            	            break;

                            	    }

                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:486:3: ( (lv_options_8_0= ruleOption ) )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:487:1: (lv_options_8_0= ruleOption )
                            	    {
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:487:1: (lv_options_8_0= ruleOption )
                            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:488:3: lv_options_8_0= ruleOption
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleOption_in_ruleLocation1087);
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
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:504:6: ( (lv_ius_9_0= ruleIU ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:505:1: (lv_ius_9_0= ruleIU )
                    	    {
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:505:1: (lv_ius_9_0= ruleIU )
                    	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:506:3: lv_ius_9_0= ruleIU
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleIU_in_ruleLocation1112);
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleLocation1125); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:534:1: entryRuleIU returns [EObject current=null] : iv_ruleIU= ruleIU EOF ;
    public final EObject entryRuleIU() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIU = null;


        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:535:2: (iv_ruleIU= ruleIU EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:536:2: iv_ruleIU= ruleIU EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIURule()); 
            }
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU1163);
            iv_ruleIU=ruleIU();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIU; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU1173); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:543:1: ruleIU returns [EObject current=null] : ( ( (lv_ID_0_0= ruleQualifiedName ) ) ( (otherlv_1= ';' )? (otherlv_2= 'version' )? (otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:546:28: ( ( ( (lv_ID_0_0= ruleQualifiedName ) ) ( (otherlv_1= ';' )? (otherlv_2= 'version' )? (otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:547:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) ( (otherlv_1= ';' )? (otherlv_2= 'version' )? (otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:547:1: ( ( (lv_ID_0_0= ruleQualifiedName ) ) ( (otherlv_1= ';' )? (otherlv_2= 'version' )? (otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:547:2: ( (lv_ID_0_0= ruleQualifiedName ) ) ( (otherlv_1= ';' )? (otherlv_2= 'version' )? (otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:547:2: ( (lv_ID_0_0= ruleQualifiedName ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:548:1: (lv_ID_0_0= ruleQualifiedName )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:548:1: (lv_ID_0_0= ruleQualifiedName )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:549:3: lv_ID_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIUAccess().getIDQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleIU1219);
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

            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:565:2: ( (otherlv_1= ';' )? (otherlv_2= 'version' )? (otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_STRING||LA18_0==RULE_INT||(LA18_0>=19 && LA18_0<=21)||(LA18_0>=23 && LA18_0<=24)||LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:565:3: (otherlv_1= ';' )? (otherlv_2= 'version' )? (otherlv_3= '=' )? ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:565:3: (otherlv_1= ';' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==19) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:565:5: otherlv_1= ';'
                            {
                            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleIU1233); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getIUAccess().getSemicolonKeyword_1_0());
                                  
                            }

                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:569:3: (otherlv_2= 'version' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==20) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:569:5: otherlv_2= 'version'
                            {
                            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleIU1248); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getIUAccess().getVersionKeyword_1_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:573:3: (otherlv_3= '=' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==21) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:573:5: otherlv_3= '='
                            {
                            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleIU1263); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getIUAccess().getEqualsSignKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }

                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:577:3: ( ( (lv_version_4_0= ruleVersionRange ) ) | ( (lv_version_5_0= RULE_STRING ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_INT||(LA17_0>=23 && LA17_0<=24)||LA17_0==27) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_STRING) ) {
                        alt17=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:577:4: ( (lv_version_4_0= ruleVersionRange ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:577:4: ( (lv_version_4_0= ruleVersionRange ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:578:1: (lv_version_4_0= ruleVersionRange )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:578:1: (lv_version_4_0= ruleVersionRange )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:579:3: lv_version_4_0= ruleVersionRange
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_3_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleVersionRange_in_ruleIU1287);
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
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:596:6: ( (lv_version_5_0= RULE_STRING ) )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:596:6: ( (lv_version_5_0= RULE_STRING ) )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:597:1: (lv_version_5_0= RULE_STRING )
                            {
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:597:1: (lv_version_5_0= RULE_STRING )
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:598:3: lv_version_5_0= RULE_STRING
                            {
                            lv_version_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIU1310); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:622:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:626:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:627:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1361);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1372); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:637:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:641:28: ( (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )* ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:642:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )* )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:642:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )* )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:642:6: this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1416); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:649:1: ( ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==22) && (synpred1_InternalTargetPlatform())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:649:2: ( ( '.' )=>kw= '.' ) (this_ID_2= RULE_ID | this_INT_3= RULE_INT )
            	    {
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:649:2: ( ( '.' )=>kw= '.' )
            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:649:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleQualifiedName1444); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:657:2: (this_ID_2= RULE_ID | this_INT_3= RULE_INT )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==RULE_ID) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==RULE_INT) ) {
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
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:657:7: this_ID_2= RULE_ID
            	            {
            	            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1461); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              		current.merge(this_ID_2);
            	                  
            	            }
            	            if ( state.backtracking==0 ) {
            	               
            	                  newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:665:10: this_INT_3= RULE_INT
            	            {
            	            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleQualifiedName1487); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              		current.merge(this_INT_3);
            	                  
            	            }
            	            if ( state.backtracking==0 ) {
            	               
            	                  newLeafNode(this_INT_3, grammarAccess.getQualifiedNameAccess().getINTTerminalRuleCall_1_1_1()); 
            	                  
            	            }

            	            }
            	            break;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:683:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:687:2: (iv_ruleVersion= ruleVersion EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:688:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion1546);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion1557); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:698:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? ) ;
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
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:702:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:703:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:703:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )? )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:703:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1601); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:710:1: (kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==22) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:711:2: kw= '.' this_INT_2= RULE_INT (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )?
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleVersion1620); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1635); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:723:1: (kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==22) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:724:2: kw= '.' this_INT_4= RULE_INT (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )?
                            {
                            kw=(Token)match(input,22,FOLLOW_22_in_ruleVersion1654); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
                                  
                            }
                            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1669); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_4);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
                                  
                            }
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:736:1: (kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT ) )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==22) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:737:2: kw= '.' (this_ID_6= RULE_ID | this_INT_7= RULE_INT )
                                    {
                                    kw=(Token)match(input,22,FOLLOW_22_in_ruleVersion1688); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
                                          
                                    }
                                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:742:1: (this_ID_6= RULE_ID | this_INT_7= RULE_INT )
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
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:742:6: this_ID_6= RULE_ID
                                            {
                                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVersion1704); if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              		current.merge(this_ID_6);
                                                  
                                            }
                                            if ( state.backtracking==0 ) {
                                               
                                                  newLeafNode(this_ID_6, grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                                                  
                                            }

                                            }
                                            break;
                                        case 2 :
                                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:750:10: this_INT_7= RULE_INT
                                            {
                                            this_INT_7=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVersion1730); if (state.failed) return current;
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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:768:1: entryRuleVersionRange returns [String current=null] : iv_ruleVersionRange= ruleVersionRange EOF ;
    public final String entryRuleVersionRange() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionRange = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:772:2: (iv_ruleVersionRange= ruleVersionRange EOF )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:773:2: iv_ruleVersionRange= ruleVersionRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRangeRule()); 
            }
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange1793);
            iv_ruleVersionRange=ruleVersionRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRange.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange1804); if (state.failed) return current;

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
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:783:1: ruleVersionRange returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) ;
    public final AntlrDatatypeRuleToken ruleVersionRange() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Version_2 = null;

        AntlrDatatypeRuleToken this_Version_4 = null;

        AntlrDatatypeRuleToken this_Version_7 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:787:28: ( ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:788:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:788:1: ( ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) ) | this_Version_7= ruleVersion | kw= 'lazy' )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 23:
            case 24:
                {
                alt27=1;
                }
                break;
            case RULE_INT:
                {
                alt27=2;
                }
                break;
            case 27:
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
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:788:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:788:2: ( (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' ) )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:788:3: (kw= '(' | kw= '[' ) this_Version_2= ruleVersion kw= ',' this_Version_4= ruleVersion (kw= ')' | kw= ']' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:788:3: (kw= '(' | kw= '[' )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==23) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==24) ) {
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
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:789:2: kw= '('
                            {
                            kw=(Token)match(input,23,FOLLOW_23_in_ruleVersionRange1848); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:796:2: kw= '['
                            {
                            kw=(Token)match(input,24,FOLLOW_24_in_ruleVersionRange1867); if (state.failed) return current;
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
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1890);
                    this_Version_2=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Version_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleVersionRange1908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1930);
                    this_Version_4=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Version_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:829:1: (kw= ')' | kw= ']' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==25) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==26) ) {
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
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:830:2: kw= ')'
                            {
                            kw=(Token)match(input,25,FOLLOW_25_in_ruleVersionRange1949); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:837:2: kw= ']'
                            {
                            kw=(Token)match(input,26,FOLLOW_26_in_ruleVersionRange1968); if (state.failed) return current;
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
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:844:5: this_Version_7= ruleVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVersion_in_ruleVersionRange1998);
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
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:856:2: kw= 'lazy'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleVersionRange2022); if (state.failed) return current;
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


    // $ANTLR start "ruleOption"
    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:872:1: ruleOption returns [Enumerator current=null] : ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) ;
    public final Enumerator ruleOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:874:28: ( ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) ) )
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:875:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            {
            // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:875:1: ( (enumLiteral_0= 'requirements' ) | (enumLiteral_1= 'allEnvironments' ) | (enumLiteral_2= 'source' ) | (enumLiteral_3= 'configurePhase' ) )
            int alt28=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt28=1;
                }
                break;
            case 29:
                {
                alt28=2;
                }
                break;
            case 30:
                {
                alt28=3;
                }
                break;
            case 31:
                {
                alt28=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:875:2: (enumLiteral_0= 'requirements' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:875:2: (enumLiteral_0= 'requirements' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:875:4: enumLiteral_0= 'requirements'
                    {
                    enumLiteral_0=(Token)match(input,28,FOLLOW_28_in_ruleOption2080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:881:6: (enumLiteral_1= 'allEnvironments' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:881:6: (enumLiteral_1= 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:881:8: enumLiteral_1= 'allEnvironments'
                    {
                    enumLiteral_1=(Token)match(input,29,FOLLOW_29_in_ruleOption2097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:887:6: (enumLiteral_2= 'source' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:887:6: (enumLiteral_2= 'source' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:887:8: enumLiteral_2= 'source'
                    {
                    enumLiteral_2=(Token)match(input,30,FOLLOW_30_in_ruleOption2114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:893:6: (enumLiteral_3= 'configurePhase' )
                    {
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:893:6: (enumLiteral_3= 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:893:8: enumLiteral_3= 'configurePhase'
                    {
                    enumLiteral_3=(Token)match(input,31,FOLLOW_31_in_ruleOption2131); if (state.failed) return current;
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
        // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:649:3: ( '.' )
        // ../fr.obeo.releng.targetplatform/src-gen/fr/obeo/releng/targetplatform/parser/antlr/internal/InternalTargetPlatform.g:650:2: '.'
        {
        match(input,22,FOLLOW_22_in_synpred1_InternalTargetPlatform1435); if (state.failed) return ;

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


 

    public static final BitSet FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetPlatform85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTargetPlatform122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTargetPlatform139 = new BitSet(new long[]{0x000000000001D002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_ruleTargetPlatform165 = new BitSet(new long[]{0x000000000001D002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_entryRuleTargetContent203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetContent213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_ruleTargetContent260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_ruleTargetContent287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_ruleTargetContent314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_ruleTargetContent341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_entryRuleOptions376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptions386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOptions423 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions444 = new BitSet(new long[]{0x00000000F0002002L});
    public static final BitSet FOLLOW_13_in_ruleOptions458 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleOptions481 = new BitSet(new long[]{0x00000000F0002002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_entryRuleEnvironment519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnvironment529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleEnvironment566 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEnvironment587 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_13_in_ruleEnvironment601 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEnvironment624 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDeclaration672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleIncludeDeclaration709 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIncludeDeclaration726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLocation814 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocation876 = new BitSet(new long[]{0x0000000000020032L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLocation952 = new BitSet(new long[]{0x0000000000020032L});
    public static final BitSet FOLLOW_17_in_ruleLocation1016 = new BitSet(new long[]{0x0000000000041020L});
    public static final BitSet FOLLOW_12_in_ruleLocation1029 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1050 = new BitSet(new long[]{0x00000000F0042020L});
    public static final BitSet FOLLOW_13_in_ruleLocation1064 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOption_in_ruleLocation1087 = new BitSet(new long[]{0x00000000F0042020L});
    public static final BitSet FOLLOW_ruleIU_in_ruleLocation1112 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_18_in_ruleLocation1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU1163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleIU1219 = new BitSet(new long[]{0x0000000009B80052L});
    public static final BitSet FOLLOW_19_in_ruleIU1233 = new BitSet(new long[]{0x0000000009B00050L});
    public static final BitSet FOLLOW_20_in_ruleIU1248 = new BitSet(new long[]{0x0000000009A00050L});
    public static final BitSet FOLLOW_21_in_ruleIU1263 = new BitSet(new long[]{0x0000000009800050L});
    public static final BitSet FOLLOW_ruleVersionRange_in_ruleIU1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIU1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1416 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleQualifiedName1444 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1461 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleQualifiedName1487 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion1546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1601 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleVersion1620 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1635 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleVersion1654 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1669 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleVersion1688 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVersion1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVersion1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange1793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVersionRange1848 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24_in_ruleVersionRange1867 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1890 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVersionRange1908 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1930 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleVersionRange1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVersionRange1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_ruleVersionRange1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVersionRange2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOption2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOption2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOption2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOption2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred1_InternalTargetPlatform1435 = new BitSet(new long[]{0x0000000000000002L});

}
