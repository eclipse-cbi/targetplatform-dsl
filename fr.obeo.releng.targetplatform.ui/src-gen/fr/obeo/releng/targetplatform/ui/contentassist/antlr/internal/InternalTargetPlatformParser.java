package fr.obeo.releng.targetplatform.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTargetPlatformParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'lazy'", "'('", "'['", "')'", "']'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'", "'target'", "'with'", "','", "'environment'", "'include'", "'location'", "'{'", "'}'", "';'", "'version'", "'='", "'.'"
    };
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
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
    public String getGrammarFileName() { return "../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g"; }


     
     	private TargetPlatformGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TargetPlatformGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleTargetPlatform"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:60:1: entryRuleTargetPlatform : ruleTargetPlatform EOF ;
    public final void entryRuleTargetPlatform() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:61:1: ( ruleTargetPlatform EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:62:1: ruleTargetPlatform EOF
            {
             before(grammarAccess.getTargetPlatformRule()); 
            pushFollow(FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform61);
            ruleTargetPlatform();

            state._fsp--;

             after(grammarAccess.getTargetPlatformRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTargetPlatform68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTargetPlatform"


    // $ANTLR start "ruleTargetPlatform"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:69:1: ruleTargetPlatform : ( ( rule__TargetPlatform__Group__0 )? ) ;
    public final void ruleTargetPlatform() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:73:2: ( ( ( rule__TargetPlatform__Group__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:74:1: ( ( rule__TargetPlatform__Group__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:74:1: ( ( rule__TargetPlatform__Group__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:75:1: ( rule__TargetPlatform__Group__0 )?
            {
             before(grammarAccess.getTargetPlatformAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:76:1: ( rule__TargetPlatform__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==20) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:76:2: rule__TargetPlatform__Group__0
                    {
                    pushFollow(FOLLOW_rule__TargetPlatform__Group__0_in_ruleTargetPlatform94);
                    rule__TargetPlatform__Group__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTargetPlatformAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTargetPlatform"


    // $ANTLR start "entryRuleTargetContent"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:88:1: entryRuleTargetContent : ruleTargetContent EOF ;
    public final void entryRuleTargetContent() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:89:1: ( ruleTargetContent EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:90:1: ruleTargetContent EOF
            {
             before(grammarAccess.getTargetContentRule()); 
            pushFollow(FOLLOW_ruleTargetContent_in_entryRuleTargetContent122);
            ruleTargetContent();

            state._fsp--;

             after(grammarAccess.getTargetContentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTargetContent129); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTargetContent"


    // $ANTLR start "ruleTargetContent"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:97:1: ruleTargetContent : ( ( rule__TargetContent__Alternatives ) ) ;
    public final void ruleTargetContent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:101:2: ( ( ( rule__TargetContent__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:102:1: ( ( rule__TargetContent__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:102:1: ( ( rule__TargetContent__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:103:1: ( rule__TargetContent__Alternatives )
            {
             before(grammarAccess.getTargetContentAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:104:1: ( rule__TargetContent__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:104:2: rule__TargetContent__Alternatives
            {
            pushFollow(FOLLOW_rule__TargetContent__Alternatives_in_ruleTargetContent155);
            rule__TargetContent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTargetContentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTargetContent"


    // $ANTLR start "entryRuleOptions"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:116:1: entryRuleOptions : ruleOptions EOF ;
    public final void entryRuleOptions() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:117:1: ( ruleOptions EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:118:1: ruleOptions EOF
            {
             before(grammarAccess.getOptionsRule()); 
            pushFollow(FOLLOW_ruleOptions_in_entryRuleOptions182);
            ruleOptions();

            state._fsp--;

             after(grammarAccess.getOptionsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptions189); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOptions"


    // $ANTLR start "ruleOptions"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:125:1: ruleOptions : ( ( rule__Options__Group__0 ) ) ;
    public final void ruleOptions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:129:2: ( ( ( rule__Options__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:130:1: ( ( rule__Options__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:130:1: ( ( rule__Options__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:131:1: ( rule__Options__Group__0 )
            {
             before(grammarAccess.getOptionsAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:132:1: ( rule__Options__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:132:2: rule__Options__Group__0
            {
            pushFollow(FOLLOW_rule__Options__Group__0_in_ruleOptions215);
            rule__Options__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOptions"


    // $ANTLR start "entryRuleEnvironment"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:144:1: entryRuleEnvironment : ruleEnvironment EOF ;
    public final void entryRuleEnvironment() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:145:1: ( ruleEnvironment EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:146:1: ruleEnvironment EOF
            {
             before(grammarAccess.getEnvironmentRule()); 
            pushFollow(FOLLOW_ruleEnvironment_in_entryRuleEnvironment242);
            ruleEnvironment();

            state._fsp--;

             after(grammarAccess.getEnvironmentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnvironment249); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnvironment"


    // $ANTLR start "ruleEnvironment"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:153:1: ruleEnvironment : ( ( rule__Environment__Group__0 ) ) ;
    public final void ruleEnvironment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:157:2: ( ( ( rule__Environment__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:158:1: ( ( rule__Environment__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:158:1: ( ( rule__Environment__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:159:1: ( rule__Environment__Group__0 )
            {
             before(grammarAccess.getEnvironmentAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:160:1: ( rule__Environment__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:160:2: rule__Environment__Group__0
            {
            pushFollow(FOLLOW_rule__Environment__Group__0_in_ruleEnvironment275);
            rule__Environment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnvironmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnvironment"


    // $ANTLR start "entryRuleIncludeDeclaration"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:172:1: entryRuleIncludeDeclaration : ruleIncludeDeclaration EOF ;
    public final void entryRuleIncludeDeclaration() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:173:1: ( ruleIncludeDeclaration EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:174:1: ruleIncludeDeclaration EOF
            {
             before(grammarAccess.getIncludeDeclarationRule()); 
            pushFollow(FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration302);
            ruleIncludeDeclaration();

            state._fsp--;

             after(grammarAccess.getIncludeDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDeclaration309); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIncludeDeclaration"


    // $ANTLR start "ruleIncludeDeclaration"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:181:1: ruleIncludeDeclaration : ( ( rule__IncludeDeclaration__Group__0 ) ) ;
    public final void ruleIncludeDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:185:2: ( ( ( rule__IncludeDeclaration__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:186:1: ( ( rule__IncludeDeclaration__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:186:1: ( ( rule__IncludeDeclaration__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:187:1: ( rule__IncludeDeclaration__Group__0 )
            {
             before(grammarAccess.getIncludeDeclarationAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:188:1: ( rule__IncludeDeclaration__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:188:2: rule__IncludeDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__0_in_ruleIncludeDeclaration335);
            rule__IncludeDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIncludeDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIncludeDeclaration"


    // $ANTLR start "entryRuleLocation"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:200:1: entryRuleLocation : ruleLocation EOF ;
    public final void entryRuleLocation() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:201:1: ( ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:202:1: ruleLocation EOF
            {
             before(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation362);
            ruleLocation();

            state._fsp--;

             after(grammarAccess.getLocationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation369); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLocation"


    // $ANTLR start "ruleLocation"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:209:1: ruleLocation : ( ( rule__Location__Group__0 ) ) ;
    public final void ruleLocation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:213:2: ( ( ( rule__Location__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:214:1: ( ( rule__Location__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:214:1: ( ( rule__Location__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:215:1: ( rule__Location__Group__0 )
            {
             before(grammarAccess.getLocationAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:216:1: ( rule__Location__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:216:2: rule__Location__Group__0
            {
            pushFollow(FOLLOW_rule__Location__Group__0_in_ruleLocation395);
            rule__Location__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLocation"


    // $ANTLR start "entryRuleIU"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:228:1: entryRuleIU : ruleIU EOF ;
    public final void entryRuleIU() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:229:1: ( ruleIU EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:230:1: ruleIU EOF
            {
             before(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU422);
            ruleIU();

            state._fsp--;

             after(grammarAccess.getIURule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU429); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIU"


    // $ANTLR start "ruleIU"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:237:1: ruleIU : ( ( rule__IU__Group__0 ) ) ;
    public final void ruleIU() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:241:2: ( ( ( rule__IU__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:242:1: ( ( rule__IU__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:242:1: ( ( rule__IU__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:243:1: ( rule__IU__Group__0 )
            {
             before(grammarAccess.getIUAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:244:1: ( rule__IU__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:244:2: rule__IU__Group__0
            {
            pushFollow(FOLLOW_rule__IU__Group__0_in_ruleIU455);
            rule__IU__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIUAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIU"


    // $ANTLR start "entryRuleVersion"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:256:1: entryRuleVersion : ruleVersion EOF ;
    public final void entryRuleVersion() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:260:1: ( ruleVersion EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:261:1: ruleVersion EOF
            {
             before(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion487);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion494); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:271:1: ruleVersion : ( ( rule__Version__Group__0 ) ) ;
    public final void ruleVersion() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:276:2: ( ( ( rule__Version__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:277:1: ( ( rule__Version__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:277:1: ( ( rule__Version__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:278:1: ( rule__Version__Group__0 )
            {
             before(grammarAccess.getVersionAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:279:1: ( rule__Version__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:279:2: rule__Version__Group__0
            {
            pushFollow(FOLLOW_rule__Version__Group__0_in_ruleVersion524);
            rule__Version__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVersionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleVersionRange"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:292:1: entryRuleVersionRange : ruleVersionRange EOF ;
    public final void entryRuleVersionRange() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:296:1: ( ruleVersionRange EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:297:1: ruleVersionRange EOF
            {
             before(grammarAccess.getVersionRangeRule()); 
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange556);
            ruleVersionRange();

            state._fsp--;

             after(grammarAccess.getVersionRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange563); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleVersionRange"


    // $ANTLR start "ruleVersionRange"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:307:1: ruleVersionRange : ( ( rule__VersionRange__Alternatives ) ) ;
    public final void ruleVersionRange() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:312:2: ( ( ( rule__VersionRange__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:313:1: ( ( rule__VersionRange__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:313:1: ( ( rule__VersionRange__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:314:1: ( rule__VersionRange__Alternatives )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:315:1: ( rule__VersionRange__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:315:2: rule__VersionRange__Alternatives
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_in_ruleVersionRange593);
            rule__VersionRange__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVersionRangeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleVersionRange"


    // $ANTLR start "ruleOption"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:329:1: ruleOption : ( ( rule__Option__Alternatives ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:333:1: ( ( ( rule__Option__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:334:1: ( ( rule__Option__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:334:1: ( ( rule__Option__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:335:1: ( rule__Option__Alternatives )
            {
             before(grammarAccess.getOptionAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:336:1: ( rule__Option__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:336:2: rule__Option__Alternatives
            {
            pushFollow(FOLLOW_rule__Option__Alternatives_in_ruleOption630);
            rule__Option__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOption"


    // $ANTLR start "rule__TargetContent__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:347:1: rule__TargetContent__Alternatives : ( ( ruleOptions ) | ( ruleEnvironment ) | ( ruleIncludeDeclaration ) | ( ruleLocation ) );
    public final void rule__TargetContent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:351:1: ( ( ruleOptions ) | ( ruleEnvironment ) | ( ruleIncludeDeclaration ) | ( ruleLocation ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt2=1;
                }
                break;
            case 23:
                {
                alt2=2;
                }
                break;
            case 24:
                {
                alt2=3;
                }
                break;
            case 25:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:352:1: ( ruleOptions )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:352:1: ( ruleOptions )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:353:1: ruleOptions
                    {
                     before(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleOptions_in_rule__TargetContent__Alternatives665);
                    ruleOptions();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:358:6: ( ruleEnvironment )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:358:6: ( ruleEnvironment )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:359:1: ruleEnvironment
                    {
                     before(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnvironment_in_rule__TargetContent__Alternatives682);
                    ruleEnvironment();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:364:6: ( ruleIncludeDeclaration )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:364:6: ( ruleIncludeDeclaration )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:365:1: ruleIncludeDeclaration
                    {
                     before(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIncludeDeclaration_in_rule__TargetContent__Alternatives699);
                    ruleIncludeDeclaration();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:370:6: ( ruleLocation )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:370:6: ( ruleLocation )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:371:1: ruleLocation
                    {
                     before(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleLocation_in_rule__TargetContent__Alternatives716);
                    ruleLocation();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetContent__Alternatives"


    // $ANTLR start "rule__IU__Alternatives_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:381:1: rule__IU__Alternatives_1_1 : ( ( ( rule__IU__VersionAssignment_1_1_0 ) ) | ( ( rule__IU__VersionAssignment_1_1_1 ) ) );
    public final void rule__IU__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:385:1: ( ( ( rule__IU__VersionAssignment_1_1_0 ) ) | ( ( rule__IU__VersionAssignment_1_1_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT||(LA3_0>=11 && LA3_0<=13)) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_STRING) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:386:1: ( ( rule__IU__VersionAssignment_1_1_0 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:386:1: ( ( rule__IU__VersionAssignment_1_1_0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:387:1: ( rule__IU__VersionAssignment_1_1_0 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_1_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:388:1: ( rule__IU__VersionAssignment_1_1_0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:388:2: rule__IU__VersionAssignment_1_1_0
                    {
                    pushFollow(FOLLOW_rule__IU__VersionAssignment_1_1_0_in_rule__IU__Alternatives_1_1748);
                    rule__IU__VersionAssignment_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getVersionAssignment_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:392:6: ( ( rule__IU__VersionAssignment_1_1_1 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:392:6: ( ( rule__IU__VersionAssignment_1_1_1 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:393:1: ( rule__IU__VersionAssignment_1_1_1 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_1_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:394:1: ( rule__IU__VersionAssignment_1_1_1 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:394:2: rule__IU__VersionAssignment_1_1_1
                    {
                    pushFollow(FOLLOW_rule__IU__VersionAssignment_1_1_1_in_rule__IU__Alternatives_1_1766);
                    rule__IU__VersionAssignment_1_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getVersionAssignment_1_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Alternatives_1_1"


    // $ANTLR start "rule__Version__Alternatives_1_2_2_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:403:1: rule__Version__Alternatives_1_2_2_1 : ( ( RULE_ID ) | ( RULE_INT ) );
    public final void rule__Version__Alternatives_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:407:1: ( ( RULE_ID ) | ( RULE_INT ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:408:1: ( RULE_ID )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:408:1: ( RULE_ID )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:409:1: RULE_ID
                    {
                     before(grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Version__Alternatives_1_2_2_1799); 
                     after(grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:414:6: ( RULE_INT )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:414:6: ( RULE_INT )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:415:1: RULE_INT
                    {
                     before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Alternatives_1_2_2_1816); 
                     after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Alternatives_1_2_2_1"


    // $ANTLR start "rule__VersionRange__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:425:1: rule__VersionRange__Alternatives : ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) | ( 'lazy' ) );
    public final void rule__VersionRange__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:429:1: ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) | ( 'lazy' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 12:
            case 13:
                {
                alt5=1;
                }
                break;
            case RULE_INT:
                {
                alt5=2;
                }
                break;
            case 11:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:430:1: ( ( rule__VersionRange__Group_0__0 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:430:1: ( ( rule__VersionRange__Group_0__0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:431:1: ( rule__VersionRange__Group_0__0 )
                    {
                     before(grammarAccess.getVersionRangeAccess().getGroup_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:432:1: ( rule__VersionRange__Group_0__0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:432:2: rule__VersionRange__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__VersionRange__Group_0__0_in_rule__VersionRange__Alternatives848);
                    rule__VersionRange__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionRangeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:436:6: ( ruleVersion )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:436:6: ( ruleVersion )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:437:1: ruleVersion
                    {
                     before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Alternatives866);
                    ruleVersion();

                    state._fsp--;

                     after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:442:6: ( 'lazy' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:442:6: ( 'lazy' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:443:1: 'lazy'
                    {
                     before(grammarAccess.getVersionRangeAccess().getLazyKeyword_2()); 
                    match(input,11,FOLLOW_11_in_rule__VersionRange__Alternatives884); 
                     after(grammarAccess.getVersionRangeAccess().getLazyKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Alternatives"


    // $ANTLR start "rule__VersionRange__Alternatives_0_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:455:1: rule__VersionRange__Alternatives_0_0 : ( ( '(' ) | ( '[' ) );
    public final void rule__VersionRange__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:459:1: ( ( '(' ) | ( '[' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==12) ) {
                alt6=1;
            }
            else if ( (LA6_0==13) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:460:1: ( '(' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:460:1: ( '(' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:461:1: '('
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                    match(input,12,FOLLOW_12_in_rule__VersionRange__Alternatives_0_0919); 
                     after(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:468:6: ( '[' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:468:6: ( '[' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:469:1: '['
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__VersionRange__Alternatives_0_0939); 
                     after(grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Alternatives_0_0"


    // $ANTLR start "rule__VersionRange__Alternatives_0_4"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:481:1: rule__VersionRange__Alternatives_0_4 : ( ( ')' ) | ( ']' ) );
    public final void rule__VersionRange__Alternatives_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:485:1: ( ( ')' ) | ( ']' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            else if ( (LA7_0==15) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:486:1: ( ')' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:486:1: ( ')' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:487:1: ')'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                    match(input,14,FOLLOW_14_in_rule__VersionRange__Alternatives_0_4974); 
                     after(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:494:6: ( ']' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:494:6: ( ']' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:495:1: ']'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1()); 
                    match(input,15,FOLLOW_15_in_rule__VersionRange__Alternatives_0_4994); 
                     after(grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Alternatives_0_4"


    // $ANTLR start "rule__Option__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:507:1: rule__Option__Alternatives : ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) );
    public final void rule__Option__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:511:1: ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt8=1;
                }
                break;
            case 17:
                {
                alt8=2;
                }
                break;
            case 18:
                {
                alt8=3;
                }
                break;
            case 19:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:512:1: ( ( 'requirements' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:512:1: ( ( 'requirements' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:513:1: ( 'requirements' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:514:1: ( 'requirements' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:514:3: 'requirements'
                    {
                    match(input,16,FOLLOW_16_in_rule__Option__Alternatives1029); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:519:6: ( ( 'allEnvironments' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:519:6: ( ( 'allEnvironments' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:520:1: ( 'allEnvironments' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:521:1: ( 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:521:3: 'allEnvironments'
                    {
                    match(input,17,FOLLOW_17_in_rule__Option__Alternatives1050); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:526:6: ( ( 'source' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:526:6: ( ( 'source' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:527:1: ( 'source' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:528:1: ( 'source' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:528:3: 'source'
                    {
                    match(input,18,FOLLOW_18_in_rule__Option__Alternatives1071); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:533:6: ( ( 'configurePhase' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:533:6: ( ( 'configurePhase' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:534:1: ( 'configurePhase' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:535:1: ( 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:535:3: 'configurePhase'
                    {
                    match(input,19,FOLLOW_19_in_rule__Option__Alternatives1092); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__Alternatives"


    // $ANTLR start "rule__TargetPlatform__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:547:1: rule__TargetPlatform__Group__0 : rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 ;
    public final void rule__TargetPlatform__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:551:1: ( rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:552:2: rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__01125);
            rule__TargetPlatform__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__01128);
            rule__TargetPlatform__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group__0"


    // $ANTLR start "rule__TargetPlatform__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:559:1: rule__TargetPlatform__Group__0__Impl : ( 'target' ) ;
    public final void rule__TargetPlatform__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:563:1: ( ( 'target' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:564:1: ( 'target' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:564:1: ( 'target' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:565:1: 'target'
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__TargetPlatform__Group__0__Impl1156); 
             after(grammarAccess.getTargetPlatformAccess().getTargetKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group__0__Impl"


    // $ANTLR start "rule__TargetPlatform__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:578:1: rule__TargetPlatform__Group__1 : rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 ;
    public final void rule__TargetPlatform__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:582:1: ( rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:583:2: rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__11187);
            rule__TargetPlatform__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__11190);
            rule__TargetPlatform__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group__1"


    // $ANTLR start "rule__TargetPlatform__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:590:1: rule__TargetPlatform__Group__1__Impl : ( ( rule__TargetPlatform__NameAssignment_1 ) ) ;
    public final void rule__TargetPlatform__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:594:1: ( ( ( rule__TargetPlatform__NameAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:595:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:595:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:596:1: ( rule__TargetPlatform__NameAssignment_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getNameAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:597:1: ( rule__TargetPlatform__NameAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:597:2: rule__TargetPlatform__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl1217);
            rule__TargetPlatform__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTargetPlatformAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group__1__Impl"


    // $ANTLR start "rule__TargetPlatform__Group__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:607:1: rule__TargetPlatform__Group__2 : rule__TargetPlatform__Group__2__Impl ;
    public final void rule__TargetPlatform__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:611:1: ( rule__TargetPlatform__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:612:2: rule__TargetPlatform__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__21247);
            rule__TargetPlatform__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group__2"


    // $ANTLR start "rule__TargetPlatform__Group__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:618:1: rule__TargetPlatform__Group__2__Impl : ( ( rule__TargetPlatform__ContentsAssignment_2 )* ) ;
    public final void rule__TargetPlatform__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:622:1: ( ( ( rule__TargetPlatform__ContentsAssignment_2 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:623:1: ( ( rule__TargetPlatform__ContentsAssignment_2 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:623:1: ( ( rule__TargetPlatform__ContentsAssignment_2 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:624:1: ( rule__TargetPlatform__ContentsAssignment_2 )*
            {
             before(grammarAccess.getTargetPlatformAccess().getContentsAssignment_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:625:1: ( rule__TargetPlatform__ContentsAssignment_2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21||(LA9_0>=23 && LA9_0<=25)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:625:2: rule__TargetPlatform__ContentsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__TargetPlatform__ContentsAssignment_2_in_rule__TargetPlatform__Group__2__Impl1274);
            	    rule__TargetPlatform__ContentsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getTargetPlatformAccess().getContentsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group__2__Impl"


    // $ANTLR start "rule__Options__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:641:1: rule__Options__Group__0 : rule__Options__Group__0__Impl rule__Options__Group__1 ;
    public final void rule__Options__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:645:1: ( rule__Options__Group__0__Impl rule__Options__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:646:2: rule__Options__Group__0__Impl rule__Options__Group__1
            {
            pushFollow(FOLLOW_rule__Options__Group__0__Impl_in_rule__Options__Group__01311);
            rule__Options__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group__1_in_rule__Options__Group__01314);
            rule__Options__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group__0"


    // $ANTLR start "rule__Options__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:653:1: rule__Options__Group__0__Impl : ( 'with' ) ;
    public final void rule__Options__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:657:1: ( ( 'with' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:658:1: ( 'with' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:658:1: ( 'with' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:659:1: 'with'
            {
             before(grammarAccess.getOptionsAccess().getWithKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__Options__Group__0__Impl1342); 
             after(grammarAccess.getOptionsAccess().getWithKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group__0__Impl"


    // $ANTLR start "rule__Options__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:672:1: rule__Options__Group__1 : rule__Options__Group__1__Impl rule__Options__Group__2 ;
    public final void rule__Options__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:676:1: ( rule__Options__Group__1__Impl rule__Options__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:677:2: rule__Options__Group__1__Impl rule__Options__Group__2
            {
            pushFollow(FOLLOW_rule__Options__Group__1__Impl_in_rule__Options__Group__11373);
            rule__Options__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group__2_in_rule__Options__Group__11376);
            rule__Options__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group__1"


    // $ANTLR start "rule__Options__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:684:1: rule__Options__Group__1__Impl : ( ( rule__Options__OptionsAssignment_1 ) ) ;
    public final void rule__Options__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:688:1: ( ( ( rule__Options__OptionsAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:689:1: ( ( rule__Options__OptionsAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:689:1: ( ( rule__Options__OptionsAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:690:1: ( rule__Options__OptionsAssignment_1 )
            {
             before(grammarAccess.getOptionsAccess().getOptionsAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:691:1: ( rule__Options__OptionsAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:691:2: rule__Options__OptionsAssignment_1
            {
            pushFollow(FOLLOW_rule__Options__OptionsAssignment_1_in_rule__Options__Group__1__Impl1403);
            rule__Options__OptionsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOptionsAccess().getOptionsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group__1__Impl"


    // $ANTLR start "rule__Options__Group__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:701:1: rule__Options__Group__2 : rule__Options__Group__2__Impl ;
    public final void rule__Options__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:705:1: ( rule__Options__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:706:2: rule__Options__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Options__Group__2__Impl_in_rule__Options__Group__21433);
            rule__Options__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group__2"


    // $ANTLR start "rule__Options__Group__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:712:1: rule__Options__Group__2__Impl : ( ( rule__Options__Group_2__0 )* ) ;
    public final void rule__Options__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:716:1: ( ( ( rule__Options__Group_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:717:1: ( ( rule__Options__Group_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:717:1: ( ( rule__Options__Group_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:718:1: ( rule__Options__Group_2__0 )*
            {
             before(grammarAccess.getOptionsAccess().getGroup_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:719:1: ( rule__Options__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=16 && LA10_0<=19)||LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:719:2: rule__Options__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Options__Group_2__0_in_rule__Options__Group__2__Impl1460);
            	    rule__Options__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getOptionsAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group__2__Impl"


    // $ANTLR start "rule__Options__Group_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:735:1: rule__Options__Group_2__0 : rule__Options__Group_2__0__Impl rule__Options__Group_2__1 ;
    public final void rule__Options__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:739:1: ( rule__Options__Group_2__0__Impl rule__Options__Group_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:740:2: rule__Options__Group_2__0__Impl rule__Options__Group_2__1
            {
            pushFollow(FOLLOW_rule__Options__Group_2__0__Impl_in_rule__Options__Group_2__01497);
            rule__Options__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group_2__1_in_rule__Options__Group_2__01500);
            rule__Options__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group_2__0"


    // $ANTLR start "rule__Options__Group_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:747:1: rule__Options__Group_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__Options__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:751:1: ( ( ( ',' )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:752:1: ( ( ',' )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:752:1: ( ( ',' )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:753:1: ( ',' )?
            {
             before(grammarAccess.getOptionsAccess().getCommaKeyword_2_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:754:1: ( ',' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:755:2: ','
                    {
                    match(input,22,FOLLOW_22_in_rule__Options__Group_2__0__Impl1529); 

                    }
                    break;

            }

             after(grammarAccess.getOptionsAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group_2__0__Impl"


    // $ANTLR start "rule__Options__Group_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:766:1: rule__Options__Group_2__1 : rule__Options__Group_2__1__Impl ;
    public final void rule__Options__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:770:1: ( rule__Options__Group_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:771:2: rule__Options__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Options__Group_2__1__Impl_in_rule__Options__Group_2__11562);
            rule__Options__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group_2__1"


    // $ANTLR start "rule__Options__Group_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:777:1: rule__Options__Group_2__1__Impl : ( ( rule__Options__OptionsAssignment_2_1 ) ) ;
    public final void rule__Options__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:781:1: ( ( ( rule__Options__OptionsAssignment_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:782:1: ( ( rule__Options__OptionsAssignment_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:782:1: ( ( rule__Options__OptionsAssignment_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:783:1: ( rule__Options__OptionsAssignment_2_1 )
            {
             before(grammarAccess.getOptionsAccess().getOptionsAssignment_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:784:1: ( rule__Options__OptionsAssignment_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:784:2: rule__Options__OptionsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Options__OptionsAssignment_2_1_in_rule__Options__Group_2__1__Impl1589);
            rule__Options__OptionsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getOptionsAccess().getOptionsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__Group_2__1__Impl"


    // $ANTLR start "rule__Environment__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:798:1: rule__Environment__Group__0 : rule__Environment__Group__0__Impl rule__Environment__Group__1 ;
    public final void rule__Environment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:802:1: ( rule__Environment__Group__0__Impl rule__Environment__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:803:2: rule__Environment__Group__0__Impl rule__Environment__Group__1
            {
            pushFollow(FOLLOW_rule__Environment__Group__0__Impl_in_rule__Environment__Group__01623);
            rule__Environment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__1_in_rule__Environment__Group__01626);
            rule__Environment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group__0"


    // $ANTLR start "rule__Environment__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:810:1: rule__Environment__Group__0__Impl : ( () ) ;
    public final void rule__Environment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:814:1: ( ( () ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:815:1: ( () )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:815:1: ( () )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:816:1: ()
            {
             before(grammarAccess.getEnvironmentAccess().getEnvironmentAction_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:817:1: ()
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:819:1: 
            {
            }

             after(grammarAccess.getEnvironmentAccess().getEnvironmentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group__0__Impl"


    // $ANTLR start "rule__Environment__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:829:1: rule__Environment__Group__1 : rule__Environment__Group__1__Impl rule__Environment__Group__2 ;
    public final void rule__Environment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:833:1: ( rule__Environment__Group__1__Impl rule__Environment__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:834:2: rule__Environment__Group__1__Impl rule__Environment__Group__2
            {
            pushFollow(FOLLOW_rule__Environment__Group__1__Impl_in_rule__Environment__Group__11684);
            rule__Environment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__2_in_rule__Environment__Group__11687);
            rule__Environment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group__1"


    // $ANTLR start "rule__Environment__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:841:1: rule__Environment__Group__1__Impl : ( 'environment' ) ;
    public final void rule__Environment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:845:1: ( ( 'environment' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:846:1: ( 'environment' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:846:1: ( 'environment' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:847:1: 'environment'
            {
             before(grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__Environment__Group__1__Impl1715); 
             after(grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group__1__Impl"


    // $ANTLR start "rule__Environment__Group__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:860:1: rule__Environment__Group__2 : rule__Environment__Group__2__Impl rule__Environment__Group__3 ;
    public final void rule__Environment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:864:1: ( rule__Environment__Group__2__Impl rule__Environment__Group__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:865:2: rule__Environment__Group__2__Impl rule__Environment__Group__3
            {
            pushFollow(FOLLOW_rule__Environment__Group__2__Impl_in_rule__Environment__Group__21746);
            rule__Environment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__3_in_rule__Environment__Group__21749);
            rule__Environment__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group__2"


    // $ANTLR start "rule__Environment__Group__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:872:1: rule__Environment__Group__2__Impl : ( ( rule__Environment__EnvAssignment_2 ) ) ;
    public final void rule__Environment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:876:1: ( ( ( rule__Environment__EnvAssignment_2 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:877:1: ( ( rule__Environment__EnvAssignment_2 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:877:1: ( ( rule__Environment__EnvAssignment_2 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:878:1: ( rule__Environment__EnvAssignment_2 )
            {
             before(grammarAccess.getEnvironmentAccess().getEnvAssignment_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:879:1: ( rule__Environment__EnvAssignment_2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:879:2: rule__Environment__EnvAssignment_2
            {
            pushFollow(FOLLOW_rule__Environment__EnvAssignment_2_in_rule__Environment__Group__2__Impl1776);
            rule__Environment__EnvAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEnvironmentAccess().getEnvAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group__2__Impl"


    // $ANTLR start "rule__Environment__Group__3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:889:1: rule__Environment__Group__3 : rule__Environment__Group__3__Impl ;
    public final void rule__Environment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:893:1: ( rule__Environment__Group__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:894:2: rule__Environment__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Environment__Group__3__Impl_in_rule__Environment__Group__31806);
            rule__Environment__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group__3"


    // $ANTLR start "rule__Environment__Group__3__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:900:1: rule__Environment__Group__3__Impl : ( ( rule__Environment__Group_3__0 )* ) ;
    public final void rule__Environment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:904:1: ( ( ( rule__Environment__Group_3__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:905:1: ( ( rule__Environment__Group_3__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:905:1: ( ( rule__Environment__Group_3__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:906:1: ( rule__Environment__Group_3__0 )*
            {
             before(grammarAccess.getEnvironmentAccess().getGroup_3()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:907:1: ( rule__Environment__Group_3__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:907:2: rule__Environment__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Environment__Group_3__0_in_rule__Environment__Group__3__Impl1833);
            	    rule__Environment__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getEnvironmentAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group__3__Impl"


    // $ANTLR start "rule__Environment__Group_3__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:925:1: rule__Environment__Group_3__0 : rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1 ;
    public final void rule__Environment__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:929:1: ( rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:930:2: rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1
            {
            pushFollow(FOLLOW_rule__Environment__Group_3__0__Impl_in_rule__Environment__Group_3__01872);
            rule__Environment__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group_3__1_in_rule__Environment__Group_3__01875);
            rule__Environment__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group_3__0"


    // $ANTLR start "rule__Environment__Group_3__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:937:1: rule__Environment__Group_3__0__Impl : ( ( ',' )? ) ;
    public final void rule__Environment__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:941:1: ( ( ( ',' )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:942:1: ( ( ',' )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:942:1: ( ( ',' )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:943:1: ( ',' )?
            {
             before(grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:944:1: ( ',' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:945:2: ','
                    {
                    match(input,22,FOLLOW_22_in_rule__Environment__Group_3__0__Impl1904); 

                    }
                    break;

            }

             after(grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group_3__0__Impl"


    // $ANTLR start "rule__Environment__Group_3__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:956:1: rule__Environment__Group_3__1 : rule__Environment__Group_3__1__Impl ;
    public final void rule__Environment__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:960:1: ( rule__Environment__Group_3__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:961:2: rule__Environment__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Environment__Group_3__1__Impl_in_rule__Environment__Group_3__11937);
            rule__Environment__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group_3__1"


    // $ANTLR start "rule__Environment__Group_3__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:967:1: rule__Environment__Group_3__1__Impl : ( ( rule__Environment__EnvAssignment_3_1 ) ) ;
    public final void rule__Environment__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:971:1: ( ( ( rule__Environment__EnvAssignment_3_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:972:1: ( ( rule__Environment__EnvAssignment_3_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:972:1: ( ( rule__Environment__EnvAssignment_3_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:973:1: ( rule__Environment__EnvAssignment_3_1 )
            {
             before(grammarAccess.getEnvironmentAccess().getEnvAssignment_3_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:974:1: ( rule__Environment__EnvAssignment_3_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:974:2: rule__Environment__EnvAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Environment__EnvAssignment_3_1_in_rule__Environment__Group_3__1__Impl1964);
            rule__Environment__EnvAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getEnvironmentAccess().getEnvAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__Group_3__1__Impl"


    // $ANTLR start "rule__IncludeDeclaration__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:988:1: rule__IncludeDeclaration__Group__0 : rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1 ;
    public final void rule__IncludeDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:992:1: ( rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:993:2: rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__0__Impl_in_rule__IncludeDeclaration__Group__01998);
            rule__IncludeDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__1_in_rule__IncludeDeclaration__Group__02001);
            rule__IncludeDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDeclaration__Group__0"


    // $ANTLR start "rule__IncludeDeclaration__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1000:1: rule__IncludeDeclaration__Group__0__Impl : ( 'include' ) ;
    public final void rule__IncludeDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1004:1: ( ( 'include' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1005:1: ( 'include' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1005:1: ( 'include' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1006:1: 'include'
            {
             before(grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__IncludeDeclaration__Group__0__Impl2029); 
             after(grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDeclaration__Group__0__Impl"


    // $ANTLR start "rule__IncludeDeclaration__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1019:1: rule__IncludeDeclaration__Group__1 : rule__IncludeDeclaration__Group__1__Impl ;
    public final void rule__IncludeDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1023:1: ( rule__IncludeDeclaration__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1024:2: rule__IncludeDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__1__Impl_in_rule__IncludeDeclaration__Group__12060);
            rule__IncludeDeclaration__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDeclaration__Group__1"


    // $ANTLR start "rule__IncludeDeclaration__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1030:1: rule__IncludeDeclaration__Group__1__Impl : ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) ) ;
    public final void rule__IncludeDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1034:1: ( ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1035:1: ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1035:1: ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1036:1: ( rule__IncludeDeclaration__ImportURIAssignment_1 )
            {
             before(grammarAccess.getIncludeDeclarationAccess().getImportURIAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1037:1: ( rule__IncludeDeclaration__ImportURIAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1037:2: rule__IncludeDeclaration__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__ImportURIAssignment_1_in_rule__IncludeDeclaration__Group__1__Impl2087);
            rule__IncludeDeclaration__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIncludeDeclarationAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDeclaration__Group__1__Impl"


    // $ANTLR start "rule__Location__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1051:1: rule__Location__Group__0 : rule__Location__Group__0__Impl rule__Location__Group__1 ;
    public final void rule__Location__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1055:1: ( rule__Location__Group__0__Impl rule__Location__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1056:2: rule__Location__Group__0__Impl rule__Location__Group__1
            {
            pushFollow(FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__02121);
            rule__Location__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__1_in_rule__Location__Group__02124);
            rule__Location__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__0"


    // $ANTLR start "rule__Location__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1063:1: rule__Location__Group__0__Impl : ( 'location' ) ;
    public final void rule__Location__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1067:1: ( ( 'location' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1068:1: ( 'location' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1068:1: ( 'location' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1069:1: 'location'
            {
             before(grammarAccess.getLocationAccess().getLocationKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__Location__Group__0__Impl2152); 
             after(grammarAccess.getLocationAccess().getLocationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__0__Impl"


    // $ANTLR start "rule__Location__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1082:1: rule__Location__Group__1 : rule__Location__Group__1__Impl rule__Location__Group__2 ;
    public final void rule__Location__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1086:1: ( rule__Location__Group__1__Impl rule__Location__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1087:2: rule__Location__Group__1__Impl rule__Location__Group__2
            {
            pushFollow(FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__12183);
            rule__Location__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__2_in_rule__Location__Group__12186);
            rule__Location__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__1"


    // $ANTLR start "rule__Location__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1094:1: rule__Location__Group__1__Impl : ( ( rule__Location__UnorderedGroup_1 ) ) ;
    public final void rule__Location__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1098:1: ( ( ( rule__Location__UnorderedGroup_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1099:1: ( ( rule__Location__UnorderedGroup_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1099:1: ( ( rule__Location__UnorderedGroup_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1100:1: ( rule__Location__UnorderedGroup_1 )
            {
             before(grammarAccess.getLocationAccess().getUnorderedGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1101:1: ( rule__Location__UnorderedGroup_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1101:2: rule__Location__UnorderedGroup_1
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1_in_rule__Location__Group__1__Impl2213);
            rule__Location__UnorderedGroup_1();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getUnorderedGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__1__Impl"


    // $ANTLR start "rule__Location__Group__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1111:1: rule__Location__Group__2 : rule__Location__Group__2__Impl ;
    public final void rule__Location__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1115:1: ( rule__Location__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1116:2: rule__Location__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__22243);
            rule__Location__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__2"


    // $ANTLR start "rule__Location__Group__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1122:1: rule__Location__Group__2__Impl : ( ( rule__Location__Group_2__0 )? ) ;
    public final void rule__Location__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1126:1: ( ( ( rule__Location__Group_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1127:1: ( ( rule__Location__Group_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1127:1: ( ( rule__Location__Group_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1128:1: ( rule__Location__Group_2__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1129:1: ( rule__Location__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1129:2: rule__Location__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl2270);
                    rule__Location__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLocationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__2__Impl"


    // $ANTLR start "rule__Location__Group_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1145:1: rule__Location__Group_2__0 : rule__Location__Group_2__0__Impl rule__Location__Group_2__1 ;
    public final void rule__Location__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1149:1: ( rule__Location__Group_2__0__Impl rule__Location__Group_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1150:2: rule__Location__Group_2__0__Impl rule__Location__Group_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__02307);
            rule__Location__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__02310);
            rule__Location__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2__0"


    // $ANTLR start "rule__Location__Group_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1157:1: rule__Location__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Location__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1161:1: ( ( '{' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1162:1: ( '{' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1162:1: ( '{' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1163:1: '{'
            {
             before(grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__Location__Group_2__0__Impl2338); 
             after(grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2__0__Impl"


    // $ANTLR start "rule__Location__Group_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1176:1: rule__Location__Group_2__1 : rule__Location__Group_2__1__Impl rule__Location__Group_2__2 ;
    public final void rule__Location__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1180:1: ( rule__Location__Group_2__1__Impl rule__Location__Group_2__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1181:2: rule__Location__Group_2__1__Impl rule__Location__Group_2__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__12369);
            rule__Location__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__12372);
            rule__Location__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2__1"


    // $ANTLR start "rule__Location__Group_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1188:1: rule__Location__Group_2__1__Impl : ( ( rule__Location__Group_2_1__0 )? ) ;
    public final void rule__Location__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1192:1: ( ( ( rule__Location__Group_2_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1193:1: ( ( rule__Location__Group_2_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1193:1: ( ( rule__Location__Group_2_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1194:1: ( rule__Location__Group_2_1__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1195:1: ( rule__Location__Group_2_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==21) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1195:2: rule__Location__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl2399);
                    rule__Location__Group_2_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLocationAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2__1__Impl"


    // $ANTLR start "rule__Location__Group_2__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1205:1: rule__Location__Group_2__2 : rule__Location__Group_2__2__Impl rule__Location__Group_2__3 ;
    public final void rule__Location__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1209:1: ( rule__Location__Group_2__2__Impl rule__Location__Group_2__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1210:2: rule__Location__Group_2__2__Impl rule__Location__Group_2__3
            {
            pushFollow(FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__22430);
            rule__Location__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__22433);
            rule__Location__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2__2"


    // $ANTLR start "rule__Location__Group_2__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1217:1: rule__Location__Group_2__2__Impl : ( ( rule__Location__IusAssignment_2_2 )* ) ;
    public final void rule__Location__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1221:1: ( ( ( rule__Location__IusAssignment_2_2 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1222:1: ( ( rule__Location__IusAssignment_2_2 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1222:1: ( ( rule__Location__IusAssignment_2_2 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1223:1: ( rule__Location__IusAssignment_2_2 )*
            {
             before(grammarAccess.getLocationAccess().getIusAssignment_2_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1224:1: ( rule__Location__IusAssignment_2_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1224:2: rule__Location__IusAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_rule__Location__IusAssignment_2_2_in_rule__Location__Group_2__2__Impl2460);
            	    rule__Location__IusAssignment_2_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getLocationAccess().getIusAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2__2__Impl"


    // $ANTLR start "rule__Location__Group_2__3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1234:1: rule__Location__Group_2__3 : rule__Location__Group_2__3__Impl ;
    public final void rule__Location__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1238:1: ( rule__Location__Group_2__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1239:2: rule__Location__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__32491);
            rule__Location__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2__3"


    // $ANTLR start "rule__Location__Group_2__3__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1245:1: rule__Location__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Location__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1249:1: ( ( '}' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1250:1: ( '}' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1250:1: ( '}' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1251:1: '}'
            {
             before(grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,27,FOLLOW_27_in_rule__Location__Group_2__3__Impl2519); 
             after(grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2__3__Impl"


    // $ANTLR start "rule__Location__Group_2_1__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1272:1: rule__Location__Group_2_1__0 : rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 ;
    public final void rule__Location__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1276:1: ( rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1277:2: rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__02558);
            rule__Location__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__02561);
            rule__Location__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1__0"


    // $ANTLR start "rule__Location__Group_2_1__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1284:1: rule__Location__Group_2_1__0__Impl : ( 'with' ) ;
    public final void rule__Location__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1288:1: ( ( 'with' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1289:1: ( 'with' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1289:1: ( 'with' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1290:1: 'with'
            {
             before(grammarAccess.getLocationAccess().getWithKeyword_2_1_0()); 
            match(input,21,FOLLOW_21_in_rule__Location__Group_2_1__0__Impl2589); 
             after(grammarAccess.getLocationAccess().getWithKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1__0__Impl"


    // $ANTLR start "rule__Location__Group_2_1__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1303:1: rule__Location__Group_2_1__1 : rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 ;
    public final void rule__Location__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1307:1: ( rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1308:2: rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__12620);
            rule__Location__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__12623);
            rule__Location__Group_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1__1"


    // $ANTLR start "rule__Location__Group_2_1__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1315:1: rule__Location__Group_2_1__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_1 ) ) ;
    public final void rule__Location__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1319:1: ( ( ( rule__Location__OptionsAssignment_2_1_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1320:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1320:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1321:1: ( rule__Location__OptionsAssignment_2_1_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1322:1: ( rule__Location__OptionsAssignment_2_1_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1322:2: rule__Location__OptionsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl2650);
            rule__Location__OptionsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1__1__Impl"


    // $ANTLR start "rule__Location__Group_2_1__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1332:1: rule__Location__Group_2_1__2 : rule__Location__Group_2_1__2__Impl ;
    public final void rule__Location__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1336:1: ( rule__Location__Group_2_1__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1337:2: rule__Location__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__22680);
            rule__Location__Group_2_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1__2"


    // $ANTLR start "rule__Location__Group_2_1__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1343:1: rule__Location__Group_2_1__2__Impl : ( ( rule__Location__Group_2_1_2__0 )* ) ;
    public final void rule__Location__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1347:1: ( ( ( rule__Location__Group_2_1_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1348:1: ( ( rule__Location__Group_2_1_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1348:1: ( ( rule__Location__Group_2_1_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1349:1: ( rule__Location__Group_2_1_2__0 )*
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1350:1: ( rule__Location__Group_2_1_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=16 && LA17_0<=19)||LA17_0==22) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1350:2: rule__Location__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl2707);
            	    rule__Location__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getLocationAccess().getGroup_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1__2__Impl"


    // $ANTLR start "rule__Location__Group_2_1_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1366:1: rule__Location__Group_2_1_2__0 : rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 ;
    public final void rule__Location__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1370:1: ( rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1371:2: rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__02744);
            rule__Location__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__02747);
            rule__Location__Group_2_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1_2__0"


    // $ANTLR start "rule__Location__Group_2_1_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1378:1: rule__Location__Group_2_1_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__Location__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1382:1: ( ( ( ',' )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1383:1: ( ( ',' )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1383:1: ( ( ',' )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1384:1: ( ',' )?
            {
             before(grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1385:1: ( ',' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==22) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1386:2: ','
                    {
                    match(input,22,FOLLOW_22_in_rule__Location__Group_2_1_2__0__Impl2776); 

                    }
                    break;

            }

             after(grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1_2__0__Impl"


    // $ANTLR start "rule__Location__Group_2_1_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1397:1: rule__Location__Group_2_1_2__1 : rule__Location__Group_2_1_2__1__Impl ;
    public final void rule__Location__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1401:1: ( rule__Location__Group_2_1_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1402:2: rule__Location__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__12809);
            rule__Location__Group_2_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1_2__1"


    // $ANTLR start "rule__Location__Group_2_1_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1408:1: rule__Location__Group_2_1_2__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) ;
    public final void rule__Location__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1412:1: ( ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1413:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1413:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1414:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1415:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1415:2: rule__Location__OptionsAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl2836);
            rule__Location__OptionsAssignment_2_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_2_1_2__1__Impl"


    // $ANTLR start "rule__IU__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1429:1: rule__IU__Group__0 : rule__IU__Group__0__Impl rule__IU__Group__1 ;
    public final void rule__IU__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1433:1: ( rule__IU__Group__0__Impl rule__IU__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1434:2: rule__IU__Group__0__Impl rule__IU__Group__1
            {
            pushFollow(FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__02870);
            rule__IU__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group__1_in_rule__IU__Group__02873);
            rule__IU__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group__0"


    // $ANTLR start "rule__IU__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1441:1: rule__IU__Group__0__Impl : ( ( rule__IU__IDAssignment_0 ) ) ;
    public final void rule__IU__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1445:1: ( ( ( rule__IU__IDAssignment_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1446:1: ( ( rule__IU__IDAssignment_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1446:1: ( ( rule__IU__IDAssignment_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1447:1: ( rule__IU__IDAssignment_0 )
            {
             before(grammarAccess.getIUAccess().getIDAssignment_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1448:1: ( rule__IU__IDAssignment_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1448:2: rule__IU__IDAssignment_0
            {
            pushFollow(FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl2900);
            rule__IU__IDAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIUAccess().getIDAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group__0__Impl"


    // $ANTLR start "rule__IU__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1458:1: rule__IU__Group__1 : rule__IU__Group__1__Impl ;
    public final void rule__IU__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1462:1: ( rule__IU__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1463:2: rule__IU__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__12930);
            rule__IU__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group__1"


    // $ANTLR start "rule__IU__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1469:1: rule__IU__Group__1__Impl : ( ( rule__IU__Group_1__0 )? ) ;
    public final void rule__IU__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1473:1: ( ( ( rule__IU__Group_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1474:1: ( ( rule__IU__Group_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1474:1: ( ( rule__IU__Group_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1475:1: ( rule__IU__Group_1__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1476:1: ( rule__IU__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_INT && LA19_0<=RULE_STRING)||(LA19_0>=11 && LA19_0<=13)||LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1476:2: rule__IU__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl2957);
                    rule__IU__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIUAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group__1__Impl"


    // $ANTLR start "rule__IU__Group_1__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1490:1: rule__IU__Group_1__0 : rule__IU__Group_1__0__Impl rule__IU__Group_1__1 ;
    public final void rule__IU__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1494:1: ( rule__IU__Group_1__0__Impl rule__IU__Group_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1495:2: rule__IU__Group_1__0__Impl rule__IU__Group_1__1
            {
            pushFollow(FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__02992);
            rule__IU__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__02995);
            rule__IU__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1__0"


    // $ANTLR start "rule__IU__Group_1__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1502:1: rule__IU__Group_1__0__Impl : ( ( rule__IU__Group_1_0__0 )? ) ;
    public final void rule__IU__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1506:1: ( ( ( rule__IU__Group_1_0__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1507:1: ( ( rule__IU__Group_1_0__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1507:1: ( ( rule__IU__Group_1_0__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1508:1: ( rule__IU__Group_1_0__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1509:1: ( rule__IU__Group_1_0__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1509:2: rule__IU__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__IU__Group_1_0__0_in_rule__IU__Group_1__0__Impl3022);
                    rule__IU__Group_1_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIUAccess().getGroup_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1__0__Impl"


    // $ANTLR start "rule__IU__Group_1__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1519:1: rule__IU__Group_1__1 : rule__IU__Group_1__1__Impl ;
    public final void rule__IU__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1523:1: ( rule__IU__Group_1__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1524:2: rule__IU__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__13053);
            rule__IU__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1__1"


    // $ANTLR start "rule__IU__Group_1__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1530:1: rule__IU__Group_1__1__Impl : ( ( rule__IU__Alternatives_1_1 ) ) ;
    public final void rule__IU__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1534:1: ( ( ( rule__IU__Alternatives_1_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1535:1: ( ( rule__IU__Alternatives_1_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1535:1: ( ( rule__IU__Alternatives_1_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1536:1: ( rule__IU__Alternatives_1_1 )
            {
             before(grammarAccess.getIUAccess().getAlternatives_1_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1537:1: ( rule__IU__Alternatives_1_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1537:2: rule__IU__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__IU__Alternatives_1_1_in_rule__IU__Group_1__1__Impl3080);
            rule__IU__Alternatives_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIUAccess().getAlternatives_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1__1__Impl"


    // $ANTLR start "rule__IU__Group_1_0__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1551:1: rule__IU__Group_1_0__0 : rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1 ;
    public final void rule__IU__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1555:1: ( rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1556:2: rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__0__Impl_in_rule__IU__Group_1_0__03114);
            rule__IU__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1_0__1_in_rule__IU__Group_1_0__03117);
            rule__IU__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1_0__0"


    // $ANTLR start "rule__IU__Group_1_0__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1563:1: rule__IU__Group_1_0__0__Impl : ( ';' ) ;
    public final void rule__IU__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1567:1: ( ( ';' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1568:1: ( ';' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1568:1: ( ';' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1569:1: ';'
            {
             before(grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0()); 
            match(input,28,FOLLOW_28_in_rule__IU__Group_1_0__0__Impl3145); 
             after(grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1_0__0__Impl"


    // $ANTLR start "rule__IU__Group_1_0__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1582:1: rule__IU__Group_1_0__1 : rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2 ;
    public final void rule__IU__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1586:1: ( rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1587:2: rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__1__Impl_in_rule__IU__Group_1_0__13176);
            rule__IU__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1_0__2_in_rule__IU__Group_1_0__13179);
            rule__IU__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1_0__1"


    // $ANTLR start "rule__IU__Group_1_0__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1594:1: rule__IU__Group_1_0__1__Impl : ( 'version' ) ;
    public final void rule__IU__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1598:1: ( ( 'version' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1599:1: ( 'version' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1599:1: ( 'version' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1600:1: 'version'
            {
             before(grammarAccess.getIUAccess().getVersionKeyword_1_0_1()); 
            match(input,29,FOLLOW_29_in_rule__IU__Group_1_0__1__Impl3207); 
             after(grammarAccess.getIUAccess().getVersionKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1_0__1__Impl"


    // $ANTLR start "rule__IU__Group_1_0__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1613:1: rule__IU__Group_1_0__2 : rule__IU__Group_1_0__2__Impl ;
    public final void rule__IU__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1617:1: ( rule__IU__Group_1_0__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1618:2: rule__IU__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__2__Impl_in_rule__IU__Group_1_0__23238);
            rule__IU__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1_0__2"


    // $ANTLR start "rule__IU__Group_1_0__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1624:1: rule__IU__Group_1_0__2__Impl : ( '=' ) ;
    public final void rule__IU__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1628:1: ( ( '=' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1629:1: ( '=' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1629:1: ( '=' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1630:1: '='
            {
             before(grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2()); 
            match(input,30,FOLLOW_30_in_rule__IU__Group_1_0__2__Impl3266); 
             after(grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__Group_1_0__2__Impl"


    // $ANTLR start "rule__Version__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1649:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1653:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1654:2: rule__Version__Group__0__Impl rule__Version__Group__1
            {
            pushFollow(FOLLOW_rule__Version__Group__0__Impl_in_rule__Version__Group__03303);
            rule__Version__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group__1_in_rule__Version__Group__03306);
            rule__Version__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__0"


    // $ANTLR start "rule__Version__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1661:1: rule__Version__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1665:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1666:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1666:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1667:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group__0__Impl3333); 
             after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__0__Impl"


    // $ANTLR start "rule__Version__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1678:1: rule__Version__Group__1 : rule__Version__Group__1__Impl ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1682:1: ( rule__Version__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1683:2: rule__Version__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group__1__Impl_in_rule__Version__Group__13362);
            rule__Version__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__1"


    // $ANTLR start "rule__Version__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1689:1: rule__Version__Group__1__Impl : ( ( rule__Version__Group_1__0 )? ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1693:1: ( ( ( rule__Version__Group_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1694:1: ( ( rule__Version__Group_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1694:1: ( ( rule__Version__Group_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1695:1: ( rule__Version__Group_1__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1696:1: ( rule__Version__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1696:2: rule__Version__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1__0_in_rule__Version__Group__1__Impl3389);
                    rule__Version__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVersionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__1__Impl"


    // $ANTLR start "rule__Version__Group_1__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1710:1: rule__Version__Group_1__0 : rule__Version__Group_1__0__Impl rule__Version__Group_1__1 ;
    public final void rule__Version__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1714:1: ( rule__Version__Group_1__0__Impl rule__Version__Group_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1715:2: rule__Version__Group_1__0__Impl rule__Version__Group_1__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1__0__Impl_in_rule__Version__Group_1__03424);
            rule__Version__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1__1_in_rule__Version__Group_1__03427);
            rule__Version__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1__0"


    // $ANTLR start "rule__Version__Group_1__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1722:1: rule__Version__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1726:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1727:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1727:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1728:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
            match(input,31,FOLLOW_31_in_rule__Version__Group_1__0__Impl3455); 
             after(grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1__0__Impl"


    // $ANTLR start "rule__Version__Group_1__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1741:1: rule__Version__Group_1__1 : rule__Version__Group_1__1__Impl rule__Version__Group_1__2 ;
    public final void rule__Version__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1745:1: ( rule__Version__Group_1__1__Impl rule__Version__Group_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1746:2: rule__Version__Group_1__1__Impl rule__Version__Group_1__2
            {
            pushFollow(FOLLOW_rule__Version__Group_1__1__Impl_in_rule__Version__Group_1__13486);
            rule__Version__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1__2_in_rule__Version__Group_1__13489);
            rule__Version__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1__1"


    // $ANTLR start "rule__Version__Group_1__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1753:1: rule__Version__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1757:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1758:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1758:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1759:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_1__1__Impl3516); 
             after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1__1__Impl"


    // $ANTLR start "rule__Version__Group_1__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1770:1: rule__Version__Group_1__2 : rule__Version__Group_1__2__Impl ;
    public final void rule__Version__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1774:1: ( rule__Version__Group_1__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1775:2: rule__Version__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1__2__Impl_in_rule__Version__Group_1__23545);
            rule__Version__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1__2"


    // $ANTLR start "rule__Version__Group_1__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1781:1: rule__Version__Group_1__2__Impl : ( ( rule__Version__Group_1_2__0 )? ) ;
    public final void rule__Version__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1785:1: ( ( ( rule__Version__Group_1_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1786:1: ( ( rule__Version__Group_1_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1786:1: ( ( rule__Version__Group_1_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1787:1: ( rule__Version__Group_1_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1788:1: ( rule__Version__Group_1_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1788:2: rule__Version__Group_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1_2__0_in_rule__Version__Group_1__2__Impl3572);
                    rule__Version__Group_1_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVersionAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1__2__Impl"


    // $ANTLR start "rule__Version__Group_1_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1804:1: rule__Version__Group_1_2__0 : rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1 ;
    public final void rule__Version__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1808:1: ( rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1809:2: rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__0__Impl_in_rule__Version__Group_1_2__03609);
            rule__Version__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2__1_in_rule__Version__Group_1_2__03612);
            rule__Version__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2__0"


    // $ANTLR start "rule__Version__Group_1_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1816:1: rule__Version__Group_1_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1820:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1821:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1821:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1822:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
            match(input,31,FOLLOW_31_in_rule__Version__Group_1_2__0__Impl3640); 
             after(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2__0__Impl"


    // $ANTLR start "rule__Version__Group_1_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1835:1: rule__Version__Group_1_2__1 : rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2 ;
    public final void rule__Version__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1839:1: ( rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1840:2: rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__1__Impl_in_rule__Version__Group_1_2__13671);
            rule__Version__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2__2_in_rule__Version__Group_1_2__13674);
            rule__Version__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2__1"


    // $ANTLR start "rule__Version__Group_1_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1847:1: rule__Version__Group_1_2__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1851:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1852:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1852:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1853:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_1_2__1__Impl3701); 
             after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2__1__Impl"


    // $ANTLR start "rule__Version__Group_1_2__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1864:1: rule__Version__Group_1_2__2 : rule__Version__Group_1_2__2__Impl ;
    public final void rule__Version__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1868:1: ( rule__Version__Group_1_2__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1869:2: rule__Version__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__2__Impl_in_rule__Version__Group_1_2__23730);
            rule__Version__Group_1_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2__2"


    // $ANTLR start "rule__Version__Group_1_2__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1875:1: rule__Version__Group_1_2__2__Impl : ( ( rule__Version__Group_1_2_2__0 )? ) ;
    public final void rule__Version__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1879:1: ( ( ( rule__Version__Group_1_2_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1880:1: ( ( rule__Version__Group_1_2_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1880:1: ( ( rule__Version__Group_1_2_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1881:1: ( rule__Version__Group_1_2_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1_2_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1882:1: ( rule__Version__Group_1_2_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1882:2: rule__Version__Group_1_2_2__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1_2_2__0_in_rule__Version__Group_1_2__2__Impl3757);
                    rule__Version__Group_1_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVersionAccess().getGroup_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2__2__Impl"


    // $ANTLR start "rule__Version__Group_1_2_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1898:1: rule__Version__Group_1_2_2__0 : rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1 ;
    public final void rule__Version__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1902:1: ( rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1903:2: rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2_2__0__Impl_in_rule__Version__Group_1_2_2__03794);
            rule__Version__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2_2__1_in_rule__Version__Group_1_2_2__03797);
            rule__Version__Group_1_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2_2__0"


    // $ANTLR start "rule__Version__Group_1_2_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1910:1: rule__Version__Group_1_2_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1914:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1915:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1915:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1916:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
            match(input,31,FOLLOW_31_in_rule__Version__Group_1_2_2__0__Impl3825); 
             after(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2_2__0__Impl"


    // $ANTLR start "rule__Version__Group_1_2_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1929:1: rule__Version__Group_1_2_2__1 : rule__Version__Group_1_2_2__1__Impl ;
    public final void rule__Version__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1933:1: ( rule__Version__Group_1_2_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1934:2: rule__Version__Group_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2_2__1__Impl_in_rule__Version__Group_1_2_2__13856);
            rule__Version__Group_1_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2_2__1"


    // $ANTLR start "rule__Version__Group_1_2_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1940:1: rule__Version__Group_1_2_2__1__Impl : ( ( rule__Version__Alternatives_1_2_2_1 ) ) ;
    public final void rule__Version__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1944:1: ( ( ( rule__Version__Alternatives_1_2_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1945:1: ( ( rule__Version__Alternatives_1_2_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1945:1: ( ( rule__Version__Alternatives_1_2_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1946:1: ( rule__Version__Alternatives_1_2_2_1 )
            {
             before(grammarAccess.getVersionAccess().getAlternatives_1_2_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1947:1: ( rule__Version__Alternatives_1_2_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1947:2: rule__Version__Alternatives_1_2_2_1
            {
            pushFollow(FOLLOW_rule__Version__Alternatives_1_2_2_1_in_rule__Version__Group_1_2_2__1__Impl3883);
            rule__Version__Alternatives_1_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getVersionAccess().getAlternatives_1_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_1_2_2__1__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1961:1: rule__VersionRange__Group_0__0 : rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 ;
    public final void rule__VersionRange__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1965:1: ( rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1966:2: rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__0__Impl_in_rule__VersionRange__Group_0__03917);
            rule__VersionRange__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__1_in_rule__VersionRange__Group_0__03920);
            rule__VersionRange__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__0"


    // $ANTLR start "rule__VersionRange__Group_0__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1973:1: rule__VersionRange__Group_0__0__Impl : ( ( rule__VersionRange__Alternatives_0_0 ) ) ;
    public final void rule__VersionRange__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1977:1: ( ( ( rule__VersionRange__Alternatives_0_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1978:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1978:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1979:1: ( rule__VersionRange__Alternatives_0_0 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1980:1: ( rule__VersionRange__Alternatives_0_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1980:2: rule__VersionRange__Alternatives_0_0
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_0_0_in_rule__VersionRange__Group_0__0__Impl3947);
            rule__VersionRange__Alternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getVersionRangeAccess().getAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__0__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1990:1: rule__VersionRange__Group_0__1 : rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 ;
    public final void rule__VersionRange__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1994:1: ( rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1995:2: rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__1__Impl_in_rule__VersionRange__Group_0__13977);
            rule__VersionRange__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__2_in_rule__VersionRange__Group_0__13980);
            rule__VersionRange__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__1"


    // $ANTLR start "rule__VersionRange__Group_0__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2002:1: rule__VersionRange__Group_0__1__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2006:1: ( ( ruleVersion ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2007:1: ( ruleVersion )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2007:1: ( ruleVersion )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2008:1: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__1__Impl4007);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__1__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2019:1: rule__VersionRange__Group_0__2 : rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 ;
    public final void rule__VersionRange__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2023:1: ( rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2024:2: rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__2__Impl_in_rule__VersionRange__Group_0__24036);
            rule__VersionRange__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__3_in_rule__VersionRange__Group_0__24039);
            rule__VersionRange__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__2"


    // $ANTLR start "rule__VersionRange__Group_0__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2031:1: rule__VersionRange__Group_0__2__Impl : ( ',' ) ;
    public final void rule__VersionRange__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2035:1: ( ( ',' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2036:1: ( ',' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2036:1: ( ',' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2037:1: ','
            {
             before(grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
            match(input,22,FOLLOW_22_in_rule__VersionRange__Group_0__2__Impl4067); 
             after(grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__2__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2050:1: rule__VersionRange__Group_0__3 : rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 ;
    public final void rule__VersionRange__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2054:1: ( rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2055:2: rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__3__Impl_in_rule__VersionRange__Group_0__34098);
            rule__VersionRange__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__4_in_rule__VersionRange__Group_0__34101);
            rule__VersionRange__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__3"


    // $ANTLR start "rule__VersionRange__Group_0__3__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2062:1: rule__VersionRange__Group_0__3__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2066:1: ( ( ruleVersion ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2067:1: ( ruleVersion )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2067:1: ( ruleVersion )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2068:1: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
            pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__3__Impl4128);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__3__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__4"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2079:1: rule__VersionRange__Group_0__4 : rule__VersionRange__Group_0__4__Impl ;
    public final void rule__VersionRange__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2083:1: ( rule__VersionRange__Group_0__4__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2084:2: rule__VersionRange__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__4__Impl_in_rule__VersionRange__Group_0__44157);
            rule__VersionRange__Group_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__4"


    // $ANTLR start "rule__VersionRange__Group_0__4__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2090:1: rule__VersionRange__Group_0__4__Impl : ( ( rule__VersionRange__Alternatives_0_4 ) ) ;
    public final void rule__VersionRange__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2094:1: ( ( ( rule__VersionRange__Alternatives_0_4 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2095:1: ( ( rule__VersionRange__Alternatives_0_4 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2095:1: ( ( rule__VersionRange__Alternatives_0_4 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2096:1: ( rule__VersionRange__Alternatives_0_4 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_4()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2097:1: ( rule__VersionRange__Alternatives_0_4 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2097:2: rule__VersionRange__Alternatives_0_4
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_0_4_in_rule__VersionRange__Group_0__4__Impl4184);
            rule__VersionRange__Alternatives_0_4();

            state._fsp--;


            }

             after(grammarAccess.getVersionRangeAccess().getAlternatives_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__4__Impl"


    // $ANTLR start "rule__Location__UnorderedGroup_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2118:1: rule__Location__UnorderedGroup_1 : rule__Location__UnorderedGroup_1__0 {...}?;
    public final void rule__Location__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2123:1: ( rule__Location__UnorderedGroup_1__0 {...}?)
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2124:2: rule__Location__UnorderedGroup_1__0 {...}?
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__0_in_rule__Location__UnorderedGroup_14225);
            rule__Location__UnorderedGroup_1__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1", "getUnorderedGroupHelper().canLeave(grammarAccess.getLocationAccess().getUnorderedGroup_1())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__UnorderedGroup_1"


    // $ANTLR start "rule__Location__UnorderedGroup_1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2135:1: rule__Location__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) ) ;
    public final void rule__Location__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2140:1: ( ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2141:3: ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2141:3: ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( LA24_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                alt24=1;
            }
            else if ( LA24_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2143:4: ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2143:4: ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2144:5: {...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
                    }
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2144:105: ( ( ( rule__Location__IDAssignment_1_0 ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2145:6: ( ( rule__Location__IDAssignment_1_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2151:6: ( ( rule__Location__IDAssignment_1_0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2153:7: ( rule__Location__IDAssignment_1_0 )
                    {
                     before(grammarAccess.getLocationAccess().getIDAssignment_1_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2154:7: ( rule__Location__IDAssignment_1_0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2154:8: rule__Location__IDAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__Location__IDAssignment_1_0_in_rule__Location__UnorderedGroup_1__Impl4314);
                    rule__Location__IDAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLocationAccess().getIDAssignment_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2160:4: ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2160:4: ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2161:5: {...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
                    }
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2161:105: ( ( ( rule__Location__UriAssignment_1_1 ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2162:6: ( ( rule__Location__UriAssignment_1_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2168:6: ( ( rule__Location__UriAssignment_1_1 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2170:7: ( rule__Location__UriAssignment_1_1 )
                    {
                     before(grammarAccess.getLocationAccess().getUriAssignment_1_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2171:7: ( rule__Location__UriAssignment_1_1 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2171:8: rule__Location__UriAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__Location__UriAssignment_1_1_in_rule__Location__UnorderedGroup_1__Impl4405);
                    rule__Location__UriAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLocationAccess().getUriAssignment_1_1()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__UnorderedGroup_1__Impl"


    // $ANTLR start "rule__Location__UnorderedGroup_1__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2186:1: rule__Location__UnorderedGroup_1__0 : rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? ;
    public final void rule__Location__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2190:1: ( rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2191:2: rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )?
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__04464);
            rule__Location__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2192:2: ( rule__Location__UnorderedGroup_1__1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( LA25_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                alt25=1;
            }
            else if ( LA25_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2192:2: rule__Location__UnorderedGroup_1__1
                    {
                    pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__1_in_rule__Location__UnorderedGroup_1__04467);
                    rule__Location__UnorderedGroup_1__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__UnorderedGroup_1__0"


    // $ANTLR start "rule__Location__UnorderedGroup_1__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2199:1: rule__Location__UnorderedGroup_1__1 : rule__Location__UnorderedGroup_1__Impl ;
    public final void rule__Location__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2203:1: ( rule__Location__UnorderedGroup_1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2204:2: rule__Location__UnorderedGroup_1__Impl
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__14492);
            rule__Location__UnorderedGroup_1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__UnorderedGroup_1__1"


    // $ANTLR start "rule__TargetPlatform__NameAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2215:1: rule__TargetPlatform__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TargetPlatform__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2219:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2220:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2220:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2221:1: RULE_STRING
            {
             before(grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_14524); 
             after(grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__NameAssignment_1"


    // $ANTLR start "rule__TargetPlatform__ContentsAssignment_2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2230:1: rule__TargetPlatform__ContentsAssignment_2 : ( ruleTargetContent ) ;
    public final void rule__TargetPlatform__ContentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2234:1: ( ( ruleTargetContent ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2235:1: ( ruleTargetContent )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2235:1: ( ruleTargetContent )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2236:1: ruleTargetContent
            {
             before(grammarAccess.getTargetPlatformAccess().getContentsTargetContentParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTargetContent_in_rule__TargetPlatform__ContentsAssignment_24555);
            ruleTargetContent();

            state._fsp--;

             after(grammarAccess.getTargetPlatformAccess().getContentsTargetContentParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__ContentsAssignment_2"


    // $ANTLR start "rule__Options__OptionsAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2245:1: rule__Options__OptionsAssignment_1 : ( ruleOption ) ;
    public final void rule__Options__OptionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2249:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2250:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2250:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2251:1: ruleOption
            {
             before(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_14586);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__OptionsAssignment_1"


    // $ANTLR start "rule__Options__OptionsAssignment_2_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2260:1: rule__Options__OptionsAssignment_2_1 : ( ruleOption ) ;
    public final void rule__Options__OptionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2264:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2265:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2265:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2266:1: ruleOption
            {
             before(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_2_14617);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Options__OptionsAssignment_2_1"


    // $ANTLR start "rule__Environment__EnvAssignment_2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2275:1: rule__Environment__EnvAssignment_2 : ( RULE_ID ) ;
    public final void rule__Environment__EnvAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2279:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2280:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2280:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2281:1: RULE_ID
            {
             before(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_24648); 
             after(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__EnvAssignment_2"


    // $ANTLR start "rule__Environment__EnvAssignment_3_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2290:1: rule__Environment__EnvAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Environment__EnvAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2294:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2295:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2295:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2296:1: RULE_ID
            {
             before(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_3_14679); 
             after(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Environment__EnvAssignment_3_1"


    // $ANTLR start "rule__IncludeDeclaration__ImportURIAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2305:1: rule__IncludeDeclaration__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__IncludeDeclaration__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2309:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2310:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2310:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2311:1: RULE_STRING
            {
             before(grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IncludeDeclaration__ImportURIAssignment_14710); 
             after(grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDeclaration__ImportURIAssignment_1"


    // $ANTLR start "rule__Location__IDAssignment_1_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2320:1: rule__Location__IDAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Location__IDAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2324:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2325:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2325:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2326:1: RULE_ID
            {
             before(grammarAccess.getLocationAccess().getIDIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Location__IDAssignment_1_04741); 
             after(grammarAccess.getLocationAccess().getIDIDTerminalRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__IDAssignment_1_0"


    // $ANTLR start "rule__Location__UriAssignment_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2335:1: rule__Location__UriAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Location__UriAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2339:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2340:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2340:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2341:1: RULE_STRING
            {
             before(grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Location__UriAssignment_1_14772); 
             after(grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__UriAssignment_1_1"


    // $ANTLR start "rule__Location__OptionsAssignment_2_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2350:1: rule__Location__OptionsAssignment_2_1_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2354:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2355:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2355:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2356:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_14803);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__OptionsAssignment_2_1_1"


    // $ANTLR start "rule__Location__OptionsAssignment_2_1_2_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2365:1: rule__Location__OptionsAssignment_2_1_2_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2369:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2370:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2370:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2371:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_14834);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__OptionsAssignment_2_1_2_1"


    // $ANTLR start "rule__Location__IusAssignment_2_2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2380:1: rule__Location__IusAssignment_2_2 : ( ruleIU ) ;
    public final void rule__Location__IusAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2384:1: ( ( ruleIU ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2385:1: ( ruleIU )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2385:1: ( ruleIU )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2386:1: ruleIU
            {
             before(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_24865);
            ruleIU();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__IusAssignment_2_2"


    // $ANTLR start "rule__IU__IDAssignment_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2395:1: rule__IU__IDAssignment_0 : ( RULE_ID ) ;
    public final void rule__IU__IDAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2399:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2400:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2400:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2401:1: RULE_ID
            {
             before(grammarAccess.getIUAccess().getIDIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IU__IDAssignment_04896); 
             after(grammarAccess.getIUAccess().getIDIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__IDAssignment_0"


    // $ANTLR start "rule__IU__VersionAssignment_1_1_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2410:1: rule__IU__VersionAssignment_1_1_0 : ( ruleVersionRange ) ;
    public final void rule__IU__VersionAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2414:1: ( ( ruleVersionRange ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2415:1: ( ruleVersionRange )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2415:1: ( ruleVersionRange )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2416:1: ruleVersionRange
            {
             before(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0()); 
            pushFollow(FOLLOW_ruleVersionRange_in_rule__IU__VersionAssignment_1_1_04927);
            ruleVersionRange();

            state._fsp--;

             after(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__VersionAssignment_1_1_0"


    // $ANTLR start "rule__IU__VersionAssignment_1_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2425:1: rule__IU__VersionAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__IU__VersionAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2429:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2430:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2430:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2431:1: RULE_STRING
            {
             before(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_1_14958); 
             after(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__VersionAssignment_1_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetPlatform68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__0_in_ruleTargetPlatform94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_entryRuleTargetContent122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetContent129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetContent__Alternatives_in_ruleTargetContent155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_entryRuleOptions182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptions189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group__0_in_ruleOptions215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_entryRuleEnvironment242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnvironment249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__0_in_ruleEnvironment275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDeclaration309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__0_in_ruleIncludeDeclaration335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__0_in_ruleLocation395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__0_in_ruleIU455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group__0_in_ruleVersion524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_in_ruleVersionRange593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Option__Alternatives_in_ruleOption630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_rule__TargetContent__Alternatives665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_rule__TargetContent__Alternatives682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_rule__TargetContent__Alternatives699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_rule__TargetContent__Alternatives716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__VersionAssignment_1_1_0_in_rule__IU__Alternatives_1_1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__VersionAssignment_1_1_1_in_rule__IU__Alternatives_1_1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Version__Alternatives_1_2_2_1799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Alternatives_1_2_2_1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__0_in_rule__VersionRange__Alternatives848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Alternatives866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__VersionRange__Alternatives884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__VersionRange__Alternatives_0_0919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VersionRange__Alternatives_0_0939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VersionRange__Alternatives_0_4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VersionRange__Alternatives_0_4994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Option__Alternatives1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Option__Alternatives1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Option__Alternatives1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Option__Alternatives1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__01125 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__01128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__TargetPlatform__Group__0__Impl1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__11187 = new BitSet(new long[]{0x0000000003A00000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__11190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__21247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__ContentsAssignment_2_in_rule__TargetPlatform__Group__2__Impl1274 = new BitSet(new long[]{0x0000000003A00002L});
    public static final BitSet FOLLOW_rule__Options__Group__0__Impl_in_rule__Options__Group__01311 = new BitSet(new long[]{0x00000000000F0000L});
    public static final BitSet FOLLOW_rule__Options__Group__1_in_rule__Options__Group__01314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Options__Group__0__Impl1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group__1__Impl_in_rule__Options__Group__11373 = new BitSet(new long[]{0x00000000004F0000L});
    public static final BitSet FOLLOW_rule__Options__Group__2_in_rule__Options__Group__11376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__OptionsAssignment_1_in_rule__Options__Group__1__Impl1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group__2__Impl_in_rule__Options__Group__21433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__0_in_rule__Options__Group__2__Impl1460 = new BitSet(new long[]{0x00000000004F0002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__0__Impl_in_rule__Options__Group_2__01497 = new BitSet(new long[]{0x00000000004F0000L});
    public static final BitSet FOLLOW_rule__Options__Group_2__1_in_rule__Options__Group_2__01500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Options__Group_2__0__Impl1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__1__Impl_in_rule__Options__Group_2__11562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__OptionsAssignment_2_1_in_rule__Options__Group_2__1__Impl1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__0__Impl_in_rule__Environment__Group__01623 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Environment__Group__1_in_rule__Environment__Group__01626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__1__Impl_in_rule__Environment__Group__11684 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Environment__Group__2_in_rule__Environment__Group__11687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Environment__Group__1__Impl1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__2__Impl_in_rule__Environment__Group__21746 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_rule__Environment__Group__3_in_rule__Environment__Group__21749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__EnvAssignment_2_in_rule__Environment__Group__2__Impl1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__3__Impl_in_rule__Environment__Group__31806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__0_in_rule__Environment__Group__3__Impl1833 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__0__Impl_in_rule__Environment__Group_3__01872 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__1_in_rule__Environment__Group_3__01875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Environment__Group_3__0__Impl1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__1__Impl_in_rule__Environment__Group_3__11937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__EnvAssignment_3_1_in_rule__Environment__Group_3__1__Impl1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__0__Impl_in_rule__IncludeDeclaration__Group__01998 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__1_in_rule__IncludeDeclaration__Group__02001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__IncludeDeclaration__Group__0__Impl2029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__1__Impl_in_rule__IncludeDeclaration__Group__12060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__ImportURIAssignment_1_in_rule__IncludeDeclaration__Group__1__Impl2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__02121 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule__Location__Group__1_in_rule__Location__Group__02124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Location__Group__0__Impl2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__12183 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Location__Group__2_in_rule__Location__Group__12186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1_in_rule__Location__Group__1__Impl2213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__22243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__02307 = new BitSet(new long[]{0x0000000008200010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__02310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Location__Group_2__0__Impl2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__12369 = new BitSet(new long[]{0x0000000008200010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__12372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__22430 = new BitSet(new long[]{0x0000000008200010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__22433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IusAssignment_2_2_in_rule__Location__Group_2__2__Impl2460 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__32491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Location__Group_2__3__Impl2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__02558 = new BitSet(new long[]{0x00000000000F0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__02561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Location__Group_2_1__0__Impl2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__12620 = new BitSet(new long[]{0x00000000004F0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__12623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl2650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__22680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl2707 = new BitSet(new long[]{0x00000000004F0002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__02744 = new BitSet(new long[]{0x00000000004F0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__02747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Location__Group_2_1_2__0__Impl2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__12809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl2836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__02870 = new BitSet(new long[]{0x0000000010003860L});
    public static final BitSet FOLLOW_rule__IU__Group__1_in_rule__IU__Group__02873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl2900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__12930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__02992 = new BitSet(new long[]{0x0000000010003860L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__02995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__0_in_rule__IU__Group_1__0__Impl3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__13053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Alternatives_1_1_in_rule__IU__Group_1__1__Impl3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__0__Impl_in_rule__IU__Group_1_0__03114 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__1_in_rule__IU__Group_1_0__03117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__IU__Group_1_0__0__Impl3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__1__Impl_in_rule__IU__Group_1_0__13176 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__2_in_rule__IU__Group_1_0__13179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__IU__Group_1_0__1__Impl3207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__2__Impl_in_rule__IU__Group_1_0__23238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__IU__Group_1_0__2__Impl3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group__0__Impl_in_rule__Version__Group__03303 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Version__Group__1_in_rule__Version__Group__03306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group__0__Impl3333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group__1__Impl_in_rule__Version__Group__13362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__0_in_rule__Version__Group__1__Impl3389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__0__Impl_in_rule__Version__Group_1__03424 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Version__Group_1__1_in_rule__Version__Group_1__03427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Version__Group_1__0__Impl3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__1__Impl_in_rule__Version__Group_1__13486 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Version__Group_1__2_in_rule__Version__Group_1__13489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_1__1__Impl3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__2__Impl_in_rule__Version__Group_1__23545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__0_in_rule__Version__Group_1__2__Impl3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__0__Impl_in_rule__Version__Group_1_2__03609 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__1_in_rule__Version__Group_1_2__03612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Version__Group_1_2__0__Impl3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__1__Impl_in_rule__Version__Group_1_2__13671 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__2_in_rule__Version__Group_1_2__13674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_1_2__1__Impl3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__2__Impl_in_rule__Version__Group_1_2__23730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__0_in_rule__Version__Group_1_2__2__Impl3757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__0__Impl_in_rule__Version__Group_1_2_2__03794 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__1_in_rule__Version__Group_1_2_2__03797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Version__Group_1_2_2__0__Impl3825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__1__Impl_in_rule__Version__Group_1_2_2__13856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Alternatives_1_2_2_1_in_rule__Version__Group_1_2_2__1__Impl3883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__0__Impl_in_rule__VersionRange__Group_0__03917 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__1_in_rule__VersionRange__Group_0__03920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_0_0_in_rule__VersionRange__Group_0__0__Impl3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__1__Impl_in_rule__VersionRange__Group_0__13977 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__2_in_rule__VersionRange__Group_0__13980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__1__Impl4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__2__Impl_in_rule__VersionRange__Group_0__24036 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__3_in_rule__VersionRange__Group_0__24039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__VersionRange__Group_0__2__Impl4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__3__Impl_in_rule__VersionRange__Group_0__34098 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__4_in_rule__VersionRange__Group_0__34101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__3__Impl4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__4__Impl_in_rule__VersionRange__Group_0__44157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_0_4_in_rule__VersionRange__Group_0__4__Impl4184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__0_in_rule__Location__UnorderedGroup_14225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IDAssignment_1_0_in_rule__Location__UnorderedGroup_1__Impl4314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UriAssignment_1_1_in_rule__Location__UnorderedGroup_1__Impl4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__04464 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__1_in_rule__Location__UnorderedGroup_1__04467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__14492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_14524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_rule__TargetPlatform__ContentsAssignment_24555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_14586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_2_14617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_24648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_3_14679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IncludeDeclaration__ImportURIAssignment_14710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Location__IDAssignment_1_04741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Location__UriAssignment_1_14772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_14803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_14834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_24865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IU__IDAssignment_04896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_rule__IU__VersionAssignment_1_1_04927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_1_14958 = new BitSet(new long[]{0x0000000000000002L});

}
