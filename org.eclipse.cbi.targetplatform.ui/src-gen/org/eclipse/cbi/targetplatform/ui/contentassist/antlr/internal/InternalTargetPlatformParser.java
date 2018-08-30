package org.eclipse.cbi.targetplatform.ui.contentassist.antlr.internal; 

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
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTargetPlatformParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_QUALIFIER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'lazy'", "'('", "'['", "')'", "']'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'", "'target'", "'with'", "','", "'environment'", "'include'", "'location'", "'{'", "'}'", "';'", "'version'", "'='", "'.'"
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
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;
    public static final int RULE_QUALIFIER=6;

    // delegates
    // delegators


        public InternalTargetPlatformParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTargetPlatformParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTargetPlatformParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g"; }


     
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:60:1: entryRuleTargetPlatform : ruleTargetPlatform EOF ;
    public final void entryRuleTargetPlatform() throws RecognitionException {
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:61:1: ( ruleTargetPlatform EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:62:1: ruleTargetPlatform EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:69:1: ruleTargetPlatform : ( ( rule__TargetPlatform__Group__0 )? ) ;
    public final void ruleTargetPlatform() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:73:2: ( ( ( rule__TargetPlatform__Group__0 )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:74:1: ( ( rule__TargetPlatform__Group__0 )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:74:1: ( ( rule__TargetPlatform__Group__0 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:75:1: ( rule__TargetPlatform__Group__0 )?
            {
             before(grammarAccess.getTargetPlatformAccess().getGroup()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:76:1: ( rule__TargetPlatform__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==21) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:76:2: rule__TargetPlatform__Group__0
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:88:1: entryRuleTargetContent : ruleTargetContent EOF ;
    public final void entryRuleTargetContent() throws RecognitionException {
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:89:1: ( ruleTargetContent EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:90:1: ruleTargetContent EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:97:1: ruleTargetContent : ( ( rule__TargetContent__Alternatives ) ) ;
    public final void ruleTargetContent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:101:2: ( ( ( rule__TargetContent__Alternatives ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:102:1: ( ( rule__TargetContent__Alternatives ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:102:1: ( ( rule__TargetContent__Alternatives ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:103:1: ( rule__TargetContent__Alternatives )
            {
             before(grammarAccess.getTargetContentAccess().getAlternatives()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:104:1: ( rule__TargetContent__Alternatives )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:104:2: rule__TargetContent__Alternatives
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:116:1: entryRuleOptions : ruleOptions EOF ;
    public final void entryRuleOptions() throws RecognitionException {
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:117:1: ( ruleOptions EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:118:1: ruleOptions EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:125:1: ruleOptions : ( ( rule__Options__Group__0 ) ) ;
    public final void ruleOptions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:129:2: ( ( ( rule__Options__Group__0 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:130:1: ( ( rule__Options__Group__0 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:130:1: ( ( rule__Options__Group__0 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:131:1: ( rule__Options__Group__0 )
            {
             before(grammarAccess.getOptionsAccess().getGroup()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:132:1: ( rule__Options__Group__0 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:132:2: rule__Options__Group__0
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:144:1: entryRuleEnvironment : ruleEnvironment EOF ;
    public final void entryRuleEnvironment() throws RecognitionException {
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:145:1: ( ruleEnvironment EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:146:1: ruleEnvironment EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:153:1: ruleEnvironment : ( ( rule__Environment__Group__0 ) ) ;
    public final void ruleEnvironment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:157:2: ( ( ( rule__Environment__Group__0 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:158:1: ( ( rule__Environment__Group__0 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:158:1: ( ( rule__Environment__Group__0 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:159:1: ( rule__Environment__Group__0 )
            {
             before(grammarAccess.getEnvironmentAccess().getGroup()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:160:1: ( rule__Environment__Group__0 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:160:2: rule__Environment__Group__0
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:172:1: entryRuleIncludeDeclaration : ruleIncludeDeclaration EOF ;
    public final void entryRuleIncludeDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:173:1: ( ruleIncludeDeclaration EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:174:1: ruleIncludeDeclaration EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:181:1: ruleIncludeDeclaration : ( ( rule__IncludeDeclaration__Group__0 ) ) ;
    public final void ruleIncludeDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:185:2: ( ( ( rule__IncludeDeclaration__Group__0 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:186:1: ( ( rule__IncludeDeclaration__Group__0 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:186:1: ( ( rule__IncludeDeclaration__Group__0 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:187:1: ( rule__IncludeDeclaration__Group__0 )
            {
             before(grammarAccess.getIncludeDeclarationAccess().getGroup()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:188:1: ( rule__IncludeDeclaration__Group__0 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:188:2: rule__IncludeDeclaration__Group__0
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:200:1: entryRuleLocation : ruleLocation EOF ;
    public final void entryRuleLocation() throws RecognitionException {
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:201:1: ( ruleLocation EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:202:1: ruleLocation EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:209:1: ruleLocation : ( ( rule__Location__Group__0 ) ) ;
    public final void ruleLocation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:213:2: ( ( ( rule__Location__Group__0 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:214:1: ( ( rule__Location__Group__0 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:214:1: ( ( rule__Location__Group__0 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:215:1: ( rule__Location__Group__0 )
            {
             before(grammarAccess.getLocationAccess().getGroup()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:216:1: ( rule__Location__Group__0 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:216:2: rule__Location__Group__0
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:228:1: entryRuleIU : ruleIU EOF ;
    public final void entryRuleIU() throws RecognitionException {
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:229:1: ( ruleIU EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:230:1: ruleIU EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:237:1: ruleIU : ( ( rule__IU__Group__0 ) ) ;
    public final void ruleIU() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:241:2: ( ( ( rule__IU__Group__0 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:242:1: ( ( rule__IU__Group__0 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:242:1: ( ( rule__IU__Group__0 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:243:1: ( rule__IU__Group__0 )
            {
             before(grammarAccess.getIUAccess().getGroup()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:244:1: ( rule__IU__Group__0 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:244:2: rule__IU__Group__0
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:256:1: entryRuleVersion : ruleVersion EOF ;
    public final void entryRuleVersion() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:260:1: ( ruleVersion EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:261:1: ruleVersion EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:271:1: ruleVersion : ( ( rule__Version__Group__0 ) ) ;
    public final void ruleVersion() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:276:2: ( ( ( rule__Version__Group__0 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:277:1: ( ( rule__Version__Group__0 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:277:1: ( ( rule__Version__Group__0 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:278:1: ( rule__Version__Group__0 )
            {
             before(grammarAccess.getVersionAccess().getGroup()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:279:1: ( rule__Version__Group__0 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:279:2: rule__Version__Group__0
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:292:1: entryRuleVersionRange : ruleVersionRange EOF ;
    public final void entryRuleVersionRange() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:296:1: ( ruleVersionRange EOF )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:297:1: ruleVersionRange EOF
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:307:1: ruleVersionRange : ( ( rule__VersionRange__Alternatives ) ) ;
    public final void ruleVersionRange() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:312:2: ( ( ( rule__VersionRange__Alternatives ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:313:1: ( ( rule__VersionRange__Alternatives ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:313:1: ( ( rule__VersionRange__Alternatives ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:314:1: ( rule__VersionRange__Alternatives )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:315:1: ( rule__VersionRange__Alternatives )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:315:2: rule__VersionRange__Alternatives
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:329:1: ruleOption : ( ( rule__Option__Alternatives ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:333:1: ( ( ( rule__Option__Alternatives ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:334:1: ( ( rule__Option__Alternatives ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:334:1: ( ( rule__Option__Alternatives ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:335:1: ( rule__Option__Alternatives )
            {
             before(grammarAccess.getOptionAccess().getAlternatives()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:336:1: ( rule__Option__Alternatives )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:336:2: rule__Option__Alternatives
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:347:1: rule__TargetContent__Alternatives : ( ( ruleOptions ) | ( ruleEnvironment ) | ( ruleIncludeDeclaration ) | ( ruleLocation ) );
    public final void rule__TargetContent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:351:1: ( ( ruleOptions ) | ( ruleEnvironment ) | ( ruleIncludeDeclaration ) | ( ruleLocation ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt2=1;
                }
                break;
            case 24:
                {
                alt2=2;
                }
                break;
            case 25:
                {
                alt2=3;
                }
                break;
            case 26:
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:352:1: ( ruleOptions )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:352:1: ( ruleOptions )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:353:1: ruleOptions
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:358:6: ( ruleEnvironment )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:358:6: ( ruleEnvironment )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:359:1: ruleEnvironment
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:364:6: ( ruleIncludeDeclaration )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:364:6: ( ruleIncludeDeclaration )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:365:1: ruleIncludeDeclaration
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:370:6: ( ruleLocation )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:370:6: ( ruleLocation )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:371:1: ruleLocation
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:381:1: rule__IU__Alternatives_1_1 : ( ( ( rule__IU__VersionAssignment_1_1_0 ) ) | ( ( rule__IU__VersionAssignment_1_1_1 ) ) );
    public final void rule__IU__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:385:1: ( ( ( rule__IU__VersionAssignment_1_1_0 ) ) | ( ( rule__IU__VersionAssignment_1_1_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT||(LA3_0>=12 && LA3_0<=14)) ) {
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:386:1: ( ( rule__IU__VersionAssignment_1_1_0 ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:386:1: ( ( rule__IU__VersionAssignment_1_1_0 ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:387:1: ( rule__IU__VersionAssignment_1_1_0 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_1_0()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:388:1: ( rule__IU__VersionAssignment_1_1_0 )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:388:2: rule__IU__VersionAssignment_1_1_0
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:392:6: ( ( rule__IU__VersionAssignment_1_1_1 ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:392:6: ( ( rule__IU__VersionAssignment_1_1_1 ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:393:1: ( rule__IU__VersionAssignment_1_1_1 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_1_1()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:394:1: ( rule__IU__VersionAssignment_1_1_1 )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:394:2: rule__IU__VersionAssignment_1_1_1
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:403:1: rule__Version__Alternatives_1_2_2_1 : ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_QUALIFIER ) );
    public final void rule__Version__Alternatives_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:407:1: ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_QUALIFIER ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt4=1;
                }
                break;
            case RULE_INT:
                {
                alt4=2;
                }
                break;
            case RULE_QUALIFIER:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:408:1: ( RULE_ID )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:408:1: ( RULE_ID )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:409:1: RULE_ID
                    {
                     before(grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Version__Alternatives_1_2_2_1799); 
                     after(grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:414:6: ( RULE_INT )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:414:6: ( RULE_INT )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:415:1: RULE_INT
                    {
                     before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Alternatives_1_2_2_1816); 
                     after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:420:6: ( RULE_QUALIFIER )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:420:6: ( RULE_QUALIFIER )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:421:1: RULE_QUALIFIER
                    {
                     before(grammarAccess.getVersionAccess().getQUALIFIERTerminalRuleCall_1_2_2_1_2()); 
                    match(input,RULE_QUALIFIER,FOLLOW_RULE_QUALIFIER_in_rule__Version__Alternatives_1_2_2_1833); 
                     after(grammarAccess.getVersionAccess().getQUALIFIERTerminalRuleCall_1_2_2_1_2()); 

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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:431:1: rule__VersionRange__Alternatives : ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) | ( 'lazy' ) );
    public final void rule__VersionRange__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:435:1: ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) | ( 'lazy' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 13:
            case 14:
                {
                alt5=1;
                }
                break;
            case RULE_INT:
                {
                alt5=2;
                }
                break;
            case 12:
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:436:1: ( ( rule__VersionRange__Group_0__0 ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:436:1: ( ( rule__VersionRange__Group_0__0 ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:437:1: ( rule__VersionRange__Group_0__0 )
                    {
                     before(grammarAccess.getVersionRangeAccess().getGroup_0()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:438:1: ( rule__VersionRange__Group_0__0 )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:438:2: rule__VersionRange__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__VersionRange__Group_0__0_in_rule__VersionRange__Alternatives865);
                    rule__VersionRange__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionRangeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:442:6: ( ruleVersion )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:442:6: ( ruleVersion )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:443:1: ruleVersion
                    {
                     before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Alternatives883);
                    ruleVersion();

                    state._fsp--;

                     after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:448:6: ( 'lazy' )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:448:6: ( 'lazy' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:449:1: 'lazy'
                    {
                     before(grammarAccess.getVersionRangeAccess().getLazyKeyword_2()); 
                    match(input,12,FOLLOW_12_in_rule__VersionRange__Alternatives901); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:461:1: rule__VersionRange__Alternatives_0_0 : ( ( '(' ) | ( '[' ) );
    public final void rule__VersionRange__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:465:1: ( ( '(' ) | ( '[' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            else if ( (LA6_0==14) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:466:1: ( '(' )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:466:1: ( '(' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:467:1: '('
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                    match(input,13,FOLLOW_13_in_rule__VersionRange__Alternatives_0_0936); 
                     after(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:474:6: ( '[' )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:474:6: ( '[' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:475:1: '['
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                    match(input,14,FOLLOW_14_in_rule__VersionRange__Alternatives_0_0956); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:487:1: rule__VersionRange__Alternatives_0_4 : ( ( ')' ) | ( ']' ) );
    public final void rule__VersionRange__Alternatives_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:491:1: ( ( ')' ) | ( ']' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            else if ( (LA7_0==16) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:492:1: ( ')' )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:492:1: ( ')' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:493:1: ')'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                    match(input,15,FOLLOW_15_in_rule__VersionRange__Alternatives_0_4991); 
                     after(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:500:6: ( ']' )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:500:6: ( ']' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:501:1: ']'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1()); 
                    match(input,16,FOLLOW_16_in_rule__VersionRange__Alternatives_0_41011); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:513:1: rule__Option__Alternatives : ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) );
    public final void rule__Option__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:517:1: ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 18:
                {
                alt8=2;
                }
                break;
            case 19:
                {
                alt8=3;
                }
                break;
            case 20:
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:518:1: ( ( 'requirements' ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:518:1: ( ( 'requirements' ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:519:1: ( 'requirements' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:520:1: ( 'requirements' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:520:3: 'requirements'
                    {
                    match(input,17,FOLLOW_17_in_rule__Option__Alternatives1046); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:525:6: ( ( 'allEnvironments' ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:525:6: ( ( 'allEnvironments' ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:526:1: ( 'allEnvironments' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:527:1: ( 'allEnvironments' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:527:3: 'allEnvironments'
                    {
                    match(input,18,FOLLOW_18_in_rule__Option__Alternatives1067); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:532:6: ( ( 'source' ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:532:6: ( ( 'source' ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:533:1: ( 'source' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:534:1: ( 'source' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:534:3: 'source'
                    {
                    match(input,19,FOLLOW_19_in_rule__Option__Alternatives1088); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:539:6: ( ( 'configurePhase' ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:539:6: ( ( 'configurePhase' ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:540:1: ( 'configurePhase' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:541:1: ( 'configurePhase' )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:541:3: 'configurePhase'
                    {
                    match(input,20,FOLLOW_20_in_rule__Option__Alternatives1109); 

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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:553:1: rule__TargetPlatform__Group__0 : rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 ;
    public final void rule__TargetPlatform__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:557:1: ( rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:558:2: rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__01142);
            rule__TargetPlatform__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__01145);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:565:1: rule__TargetPlatform__Group__0__Impl : ( 'target' ) ;
    public final void rule__TargetPlatform__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:569:1: ( ( 'target' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:570:1: ( 'target' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:570:1: ( 'target' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:571:1: 'target'
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__TargetPlatform__Group__0__Impl1173); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:584:1: rule__TargetPlatform__Group__1 : rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 ;
    public final void rule__TargetPlatform__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:588:1: ( rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:589:2: rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__11204);
            rule__TargetPlatform__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__11207);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:596:1: rule__TargetPlatform__Group__1__Impl : ( ( rule__TargetPlatform__NameAssignment_1 ) ) ;
    public final void rule__TargetPlatform__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:600:1: ( ( ( rule__TargetPlatform__NameAssignment_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:601:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:601:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:602:1: ( rule__TargetPlatform__NameAssignment_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getNameAssignment_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:603:1: ( rule__TargetPlatform__NameAssignment_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:603:2: rule__TargetPlatform__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl1234);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:613:1: rule__TargetPlatform__Group__2 : rule__TargetPlatform__Group__2__Impl ;
    public final void rule__TargetPlatform__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:617:1: ( rule__TargetPlatform__Group__2__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:618:2: rule__TargetPlatform__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__21264);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:624:1: rule__TargetPlatform__Group__2__Impl : ( ( rule__TargetPlatform__ContentsAssignment_2 )* ) ;
    public final void rule__TargetPlatform__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:628:1: ( ( ( rule__TargetPlatform__ContentsAssignment_2 )* ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:629:1: ( ( rule__TargetPlatform__ContentsAssignment_2 )* )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:629:1: ( ( rule__TargetPlatform__ContentsAssignment_2 )* )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:630:1: ( rule__TargetPlatform__ContentsAssignment_2 )*
            {
             before(grammarAccess.getTargetPlatformAccess().getContentsAssignment_2()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:631:1: ( rule__TargetPlatform__ContentsAssignment_2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22||(LA9_0>=24 && LA9_0<=26)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:631:2: rule__TargetPlatform__ContentsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__TargetPlatform__ContentsAssignment_2_in_rule__TargetPlatform__Group__2__Impl1291);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:647:1: rule__Options__Group__0 : rule__Options__Group__0__Impl rule__Options__Group__1 ;
    public final void rule__Options__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:651:1: ( rule__Options__Group__0__Impl rule__Options__Group__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:652:2: rule__Options__Group__0__Impl rule__Options__Group__1
            {
            pushFollow(FOLLOW_rule__Options__Group__0__Impl_in_rule__Options__Group__01328);
            rule__Options__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group__1_in_rule__Options__Group__01331);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:659:1: rule__Options__Group__0__Impl : ( 'with' ) ;
    public final void rule__Options__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:663:1: ( ( 'with' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:664:1: ( 'with' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:664:1: ( 'with' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:665:1: 'with'
            {
             before(grammarAccess.getOptionsAccess().getWithKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Options__Group__0__Impl1359); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:678:1: rule__Options__Group__1 : rule__Options__Group__1__Impl rule__Options__Group__2 ;
    public final void rule__Options__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:682:1: ( rule__Options__Group__1__Impl rule__Options__Group__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:683:2: rule__Options__Group__1__Impl rule__Options__Group__2
            {
            pushFollow(FOLLOW_rule__Options__Group__1__Impl_in_rule__Options__Group__11390);
            rule__Options__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group__2_in_rule__Options__Group__11393);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:690:1: rule__Options__Group__1__Impl : ( ( rule__Options__OptionsAssignment_1 ) ) ;
    public final void rule__Options__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:694:1: ( ( ( rule__Options__OptionsAssignment_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:695:1: ( ( rule__Options__OptionsAssignment_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:695:1: ( ( rule__Options__OptionsAssignment_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:696:1: ( rule__Options__OptionsAssignment_1 )
            {
             before(grammarAccess.getOptionsAccess().getOptionsAssignment_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:697:1: ( rule__Options__OptionsAssignment_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:697:2: rule__Options__OptionsAssignment_1
            {
            pushFollow(FOLLOW_rule__Options__OptionsAssignment_1_in_rule__Options__Group__1__Impl1420);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:707:1: rule__Options__Group__2 : rule__Options__Group__2__Impl ;
    public final void rule__Options__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:711:1: ( rule__Options__Group__2__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:712:2: rule__Options__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Options__Group__2__Impl_in_rule__Options__Group__21450);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:718:1: rule__Options__Group__2__Impl : ( ( rule__Options__Group_2__0 )* ) ;
    public final void rule__Options__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:722:1: ( ( ( rule__Options__Group_2__0 )* ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:723:1: ( ( rule__Options__Group_2__0 )* )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:723:1: ( ( rule__Options__Group_2__0 )* )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:724:1: ( rule__Options__Group_2__0 )*
            {
             before(grammarAccess.getOptionsAccess().getGroup_2()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:725:1: ( rule__Options__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=17 && LA10_0<=20)||LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:725:2: rule__Options__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Options__Group_2__0_in_rule__Options__Group__2__Impl1477);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:741:1: rule__Options__Group_2__0 : rule__Options__Group_2__0__Impl rule__Options__Group_2__1 ;
    public final void rule__Options__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:745:1: ( rule__Options__Group_2__0__Impl rule__Options__Group_2__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:746:2: rule__Options__Group_2__0__Impl rule__Options__Group_2__1
            {
            pushFollow(FOLLOW_rule__Options__Group_2__0__Impl_in_rule__Options__Group_2__01514);
            rule__Options__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group_2__1_in_rule__Options__Group_2__01517);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:753:1: rule__Options__Group_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__Options__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:757:1: ( ( ( ',' )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:758:1: ( ( ',' )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:758:1: ( ( ',' )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:759:1: ( ',' )?
            {
             before(grammarAccess.getOptionsAccess().getCommaKeyword_2_0()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:760:1: ( ',' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:761:2: ','
                    {
                    match(input,23,FOLLOW_23_in_rule__Options__Group_2__0__Impl1546); 

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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:772:1: rule__Options__Group_2__1 : rule__Options__Group_2__1__Impl ;
    public final void rule__Options__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:776:1: ( rule__Options__Group_2__1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:777:2: rule__Options__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Options__Group_2__1__Impl_in_rule__Options__Group_2__11579);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:783:1: rule__Options__Group_2__1__Impl : ( ( rule__Options__OptionsAssignment_2_1 ) ) ;
    public final void rule__Options__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:787:1: ( ( ( rule__Options__OptionsAssignment_2_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:788:1: ( ( rule__Options__OptionsAssignment_2_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:788:1: ( ( rule__Options__OptionsAssignment_2_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:789:1: ( rule__Options__OptionsAssignment_2_1 )
            {
             before(grammarAccess.getOptionsAccess().getOptionsAssignment_2_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:790:1: ( rule__Options__OptionsAssignment_2_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:790:2: rule__Options__OptionsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Options__OptionsAssignment_2_1_in_rule__Options__Group_2__1__Impl1606);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:804:1: rule__Environment__Group__0 : rule__Environment__Group__0__Impl rule__Environment__Group__1 ;
    public final void rule__Environment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:808:1: ( rule__Environment__Group__0__Impl rule__Environment__Group__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:809:2: rule__Environment__Group__0__Impl rule__Environment__Group__1
            {
            pushFollow(FOLLOW_rule__Environment__Group__0__Impl_in_rule__Environment__Group__01640);
            rule__Environment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__1_in_rule__Environment__Group__01643);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:816:1: rule__Environment__Group__0__Impl : ( () ) ;
    public final void rule__Environment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:820:1: ( ( () ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:821:1: ( () )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:821:1: ( () )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:822:1: ()
            {
             before(grammarAccess.getEnvironmentAccess().getEnvironmentAction_0()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:823:1: ()
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:825:1: 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:835:1: rule__Environment__Group__1 : rule__Environment__Group__1__Impl rule__Environment__Group__2 ;
    public final void rule__Environment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:839:1: ( rule__Environment__Group__1__Impl rule__Environment__Group__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:840:2: rule__Environment__Group__1__Impl rule__Environment__Group__2
            {
            pushFollow(FOLLOW_rule__Environment__Group__1__Impl_in_rule__Environment__Group__11701);
            rule__Environment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__2_in_rule__Environment__Group__11704);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:847:1: rule__Environment__Group__1__Impl : ( 'environment' ) ;
    public final void rule__Environment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:851:1: ( ( 'environment' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:852:1: ( 'environment' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:852:1: ( 'environment' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:853:1: 'environment'
            {
             before(grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__Environment__Group__1__Impl1732); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:866:1: rule__Environment__Group__2 : rule__Environment__Group__2__Impl rule__Environment__Group__3 ;
    public final void rule__Environment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:870:1: ( rule__Environment__Group__2__Impl rule__Environment__Group__3 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:871:2: rule__Environment__Group__2__Impl rule__Environment__Group__3
            {
            pushFollow(FOLLOW_rule__Environment__Group__2__Impl_in_rule__Environment__Group__21763);
            rule__Environment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__3_in_rule__Environment__Group__21766);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:878:1: rule__Environment__Group__2__Impl : ( ( rule__Environment__EnvAssignment_2 ) ) ;
    public final void rule__Environment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:882:1: ( ( ( rule__Environment__EnvAssignment_2 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:883:1: ( ( rule__Environment__EnvAssignment_2 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:883:1: ( ( rule__Environment__EnvAssignment_2 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:884:1: ( rule__Environment__EnvAssignment_2 )
            {
             before(grammarAccess.getEnvironmentAccess().getEnvAssignment_2()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:885:1: ( rule__Environment__EnvAssignment_2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:885:2: rule__Environment__EnvAssignment_2
            {
            pushFollow(FOLLOW_rule__Environment__EnvAssignment_2_in_rule__Environment__Group__2__Impl1793);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:895:1: rule__Environment__Group__3 : rule__Environment__Group__3__Impl ;
    public final void rule__Environment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:899:1: ( rule__Environment__Group__3__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:900:2: rule__Environment__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Environment__Group__3__Impl_in_rule__Environment__Group__31823);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:906:1: rule__Environment__Group__3__Impl : ( ( rule__Environment__Group_3__0 )* ) ;
    public final void rule__Environment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:910:1: ( ( ( rule__Environment__Group_3__0 )* ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:911:1: ( ( rule__Environment__Group_3__0 )* )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:911:1: ( ( rule__Environment__Group_3__0 )* )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:912:1: ( rule__Environment__Group_3__0 )*
            {
             before(grammarAccess.getEnvironmentAccess().getGroup_3()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:913:1: ( rule__Environment__Group_3__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:913:2: rule__Environment__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Environment__Group_3__0_in_rule__Environment__Group__3__Impl1850);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:931:1: rule__Environment__Group_3__0 : rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1 ;
    public final void rule__Environment__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:935:1: ( rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:936:2: rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1
            {
            pushFollow(FOLLOW_rule__Environment__Group_3__0__Impl_in_rule__Environment__Group_3__01889);
            rule__Environment__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group_3__1_in_rule__Environment__Group_3__01892);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:943:1: rule__Environment__Group_3__0__Impl : ( ( ',' )? ) ;
    public final void rule__Environment__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:947:1: ( ( ( ',' )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:948:1: ( ( ',' )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:948:1: ( ( ',' )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:949:1: ( ',' )?
            {
             before(grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:950:1: ( ',' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:951:2: ','
                    {
                    match(input,23,FOLLOW_23_in_rule__Environment__Group_3__0__Impl1921); 

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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:962:1: rule__Environment__Group_3__1 : rule__Environment__Group_3__1__Impl ;
    public final void rule__Environment__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:966:1: ( rule__Environment__Group_3__1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:967:2: rule__Environment__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Environment__Group_3__1__Impl_in_rule__Environment__Group_3__11954);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:973:1: rule__Environment__Group_3__1__Impl : ( ( rule__Environment__EnvAssignment_3_1 ) ) ;
    public final void rule__Environment__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:977:1: ( ( ( rule__Environment__EnvAssignment_3_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:978:1: ( ( rule__Environment__EnvAssignment_3_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:978:1: ( ( rule__Environment__EnvAssignment_3_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:979:1: ( rule__Environment__EnvAssignment_3_1 )
            {
             before(grammarAccess.getEnvironmentAccess().getEnvAssignment_3_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:980:1: ( rule__Environment__EnvAssignment_3_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:980:2: rule__Environment__EnvAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Environment__EnvAssignment_3_1_in_rule__Environment__Group_3__1__Impl1981);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:994:1: rule__IncludeDeclaration__Group__0 : rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1 ;
    public final void rule__IncludeDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:998:1: ( rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:999:2: rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__0__Impl_in_rule__IncludeDeclaration__Group__02015);
            rule__IncludeDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__1_in_rule__IncludeDeclaration__Group__02018);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1006:1: rule__IncludeDeclaration__Group__0__Impl : ( 'include' ) ;
    public final void rule__IncludeDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1010:1: ( ( 'include' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1011:1: ( 'include' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1011:1: ( 'include' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1012:1: 'include'
            {
             before(grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__IncludeDeclaration__Group__0__Impl2046); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1025:1: rule__IncludeDeclaration__Group__1 : rule__IncludeDeclaration__Group__1__Impl ;
    public final void rule__IncludeDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1029:1: ( rule__IncludeDeclaration__Group__1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1030:2: rule__IncludeDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__1__Impl_in_rule__IncludeDeclaration__Group__12077);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1036:1: rule__IncludeDeclaration__Group__1__Impl : ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) ) ;
    public final void rule__IncludeDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1040:1: ( ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1041:1: ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1041:1: ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1042:1: ( rule__IncludeDeclaration__ImportURIAssignment_1 )
            {
             before(grammarAccess.getIncludeDeclarationAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1043:1: ( rule__IncludeDeclaration__ImportURIAssignment_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1043:2: rule__IncludeDeclaration__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__ImportURIAssignment_1_in_rule__IncludeDeclaration__Group__1__Impl2104);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1057:1: rule__Location__Group__0 : rule__Location__Group__0__Impl rule__Location__Group__1 ;
    public final void rule__Location__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1061:1: ( rule__Location__Group__0__Impl rule__Location__Group__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1062:2: rule__Location__Group__0__Impl rule__Location__Group__1
            {
            pushFollow(FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__02138);
            rule__Location__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__1_in_rule__Location__Group__02141);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1069:1: rule__Location__Group__0__Impl : ( 'location' ) ;
    public final void rule__Location__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1073:1: ( ( 'location' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1074:1: ( 'location' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1074:1: ( 'location' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1075:1: 'location'
            {
             before(grammarAccess.getLocationAccess().getLocationKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__Location__Group__0__Impl2169); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1088:1: rule__Location__Group__1 : rule__Location__Group__1__Impl rule__Location__Group__2 ;
    public final void rule__Location__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1092:1: ( rule__Location__Group__1__Impl rule__Location__Group__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1093:2: rule__Location__Group__1__Impl rule__Location__Group__2
            {
            pushFollow(FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__12200);
            rule__Location__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__2_in_rule__Location__Group__12203);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1100:1: rule__Location__Group__1__Impl : ( ( rule__Location__UnorderedGroup_1 ) ) ;
    public final void rule__Location__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1104:1: ( ( ( rule__Location__UnorderedGroup_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1105:1: ( ( rule__Location__UnorderedGroup_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1105:1: ( ( rule__Location__UnorderedGroup_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1106:1: ( rule__Location__UnorderedGroup_1 )
            {
             before(grammarAccess.getLocationAccess().getUnorderedGroup_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1107:1: ( rule__Location__UnorderedGroup_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1107:2: rule__Location__UnorderedGroup_1
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1_in_rule__Location__Group__1__Impl2230);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1117:1: rule__Location__Group__2 : rule__Location__Group__2__Impl ;
    public final void rule__Location__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1121:1: ( rule__Location__Group__2__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1122:2: rule__Location__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__22260);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1128:1: rule__Location__Group__2__Impl : ( ( rule__Location__Group_2__0 )? ) ;
    public final void rule__Location__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1132:1: ( ( ( rule__Location__Group_2__0 )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1133:1: ( ( rule__Location__Group_2__0 )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1133:1: ( ( rule__Location__Group_2__0 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1134:1: ( rule__Location__Group_2__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1135:1: ( rule__Location__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1135:2: rule__Location__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl2287);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1151:1: rule__Location__Group_2__0 : rule__Location__Group_2__0__Impl rule__Location__Group_2__1 ;
    public final void rule__Location__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1155:1: ( rule__Location__Group_2__0__Impl rule__Location__Group_2__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1156:2: rule__Location__Group_2__0__Impl rule__Location__Group_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__02324);
            rule__Location__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__02327);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1163:1: rule__Location__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Location__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1167:1: ( ( '{' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1168:1: ( '{' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1168:1: ( '{' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1169:1: '{'
            {
             before(grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,27,FOLLOW_27_in_rule__Location__Group_2__0__Impl2355); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1182:1: rule__Location__Group_2__1 : rule__Location__Group_2__1__Impl rule__Location__Group_2__2 ;
    public final void rule__Location__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1186:1: ( rule__Location__Group_2__1__Impl rule__Location__Group_2__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1187:2: rule__Location__Group_2__1__Impl rule__Location__Group_2__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__12386);
            rule__Location__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__12389);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1194:1: rule__Location__Group_2__1__Impl : ( ( rule__Location__Group_2_1__0 )? ) ;
    public final void rule__Location__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1198:1: ( ( ( rule__Location__Group_2_1__0 )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1199:1: ( ( rule__Location__Group_2_1__0 )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1199:1: ( ( rule__Location__Group_2_1__0 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1200:1: ( rule__Location__Group_2_1__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1201:1: ( rule__Location__Group_2_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1201:2: rule__Location__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl2416);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1211:1: rule__Location__Group_2__2 : rule__Location__Group_2__2__Impl rule__Location__Group_2__3 ;
    public final void rule__Location__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1215:1: ( rule__Location__Group_2__2__Impl rule__Location__Group_2__3 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1216:2: rule__Location__Group_2__2__Impl rule__Location__Group_2__3
            {
            pushFollow(FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__22447);
            rule__Location__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__22450);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1223:1: rule__Location__Group_2__2__Impl : ( ( rule__Location__IusAssignment_2_2 )* ) ;
    public final void rule__Location__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1227:1: ( ( ( rule__Location__IusAssignment_2_2 )* ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1228:1: ( ( rule__Location__IusAssignment_2_2 )* )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1228:1: ( ( rule__Location__IusAssignment_2_2 )* )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1229:1: ( rule__Location__IusAssignment_2_2 )*
            {
             before(grammarAccess.getLocationAccess().getIusAssignment_2_2()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1230:1: ( rule__Location__IusAssignment_2_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1230:2: rule__Location__IusAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_rule__Location__IusAssignment_2_2_in_rule__Location__Group_2__2__Impl2477);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1240:1: rule__Location__Group_2__3 : rule__Location__Group_2__3__Impl ;
    public final void rule__Location__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1244:1: ( rule__Location__Group_2__3__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1245:2: rule__Location__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__32508);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1251:1: rule__Location__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Location__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1255:1: ( ( '}' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1256:1: ( '}' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1256:1: ( '}' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1257:1: '}'
            {
             before(grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,28,FOLLOW_28_in_rule__Location__Group_2__3__Impl2536); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1278:1: rule__Location__Group_2_1__0 : rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 ;
    public final void rule__Location__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1282:1: ( rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1283:2: rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__02575);
            rule__Location__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__02578);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1290:1: rule__Location__Group_2_1__0__Impl : ( 'with' ) ;
    public final void rule__Location__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1294:1: ( ( 'with' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1295:1: ( 'with' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1295:1: ( 'with' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1296:1: 'with'
            {
             before(grammarAccess.getLocationAccess().getWithKeyword_2_1_0()); 
            match(input,22,FOLLOW_22_in_rule__Location__Group_2_1__0__Impl2606); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1309:1: rule__Location__Group_2_1__1 : rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 ;
    public final void rule__Location__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1313:1: ( rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1314:2: rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__12637);
            rule__Location__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__12640);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1321:1: rule__Location__Group_2_1__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_1 ) ) ;
    public final void rule__Location__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1325:1: ( ( ( rule__Location__OptionsAssignment_2_1_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1326:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1326:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1327:1: ( rule__Location__OptionsAssignment_2_1_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1328:1: ( rule__Location__OptionsAssignment_2_1_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1328:2: rule__Location__OptionsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl2667);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1338:1: rule__Location__Group_2_1__2 : rule__Location__Group_2_1__2__Impl ;
    public final void rule__Location__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1342:1: ( rule__Location__Group_2_1__2__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1343:2: rule__Location__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__22697);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1349:1: rule__Location__Group_2_1__2__Impl : ( ( rule__Location__Group_2_1_2__0 )* ) ;
    public final void rule__Location__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1353:1: ( ( ( rule__Location__Group_2_1_2__0 )* ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1354:1: ( ( rule__Location__Group_2_1_2__0 )* )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1354:1: ( ( rule__Location__Group_2_1_2__0 )* )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1355:1: ( rule__Location__Group_2_1_2__0 )*
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1_2()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1356:1: ( rule__Location__Group_2_1_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=17 && LA17_0<=20)||LA17_0==23) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1356:2: rule__Location__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl2724);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1372:1: rule__Location__Group_2_1_2__0 : rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 ;
    public final void rule__Location__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1376:1: ( rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1377:2: rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__02761);
            rule__Location__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__02764);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1384:1: rule__Location__Group_2_1_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__Location__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1388:1: ( ( ( ',' )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1389:1: ( ( ',' )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1389:1: ( ( ',' )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1390:1: ( ',' )?
            {
             before(grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1391:1: ( ',' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==23) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1392:2: ','
                    {
                    match(input,23,FOLLOW_23_in_rule__Location__Group_2_1_2__0__Impl2793); 

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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1403:1: rule__Location__Group_2_1_2__1 : rule__Location__Group_2_1_2__1__Impl ;
    public final void rule__Location__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1407:1: ( rule__Location__Group_2_1_2__1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1408:2: rule__Location__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__12826);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1414:1: rule__Location__Group_2_1_2__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) ;
    public final void rule__Location__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1418:1: ( ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1419:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1419:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1420:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_2_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1421:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1421:2: rule__Location__OptionsAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl2853);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1435:1: rule__IU__Group__0 : rule__IU__Group__0__Impl rule__IU__Group__1 ;
    public final void rule__IU__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1439:1: ( rule__IU__Group__0__Impl rule__IU__Group__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1440:2: rule__IU__Group__0__Impl rule__IU__Group__1
            {
            pushFollow(FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__02887);
            rule__IU__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group__1_in_rule__IU__Group__02890);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1447:1: rule__IU__Group__0__Impl : ( ( rule__IU__IDAssignment_0 ) ) ;
    public final void rule__IU__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1451:1: ( ( ( rule__IU__IDAssignment_0 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1452:1: ( ( rule__IU__IDAssignment_0 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1452:1: ( ( rule__IU__IDAssignment_0 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1453:1: ( rule__IU__IDAssignment_0 )
            {
             before(grammarAccess.getIUAccess().getIDAssignment_0()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1454:1: ( rule__IU__IDAssignment_0 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1454:2: rule__IU__IDAssignment_0
            {
            pushFollow(FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl2917);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1464:1: rule__IU__Group__1 : rule__IU__Group__1__Impl ;
    public final void rule__IU__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1468:1: ( rule__IU__Group__1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1469:2: rule__IU__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__12947);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1475:1: rule__IU__Group__1__Impl : ( ( rule__IU__Group_1__0 )? ) ;
    public final void rule__IU__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1479:1: ( ( ( rule__IU__Group_1__0 )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1480:1: ( ( rule__IU__Group_1__0 )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1480:1: ( ( rule__IU__Group_1__0 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1481:1: ( rule__IU__Group_1__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1482:1: ( rule__IU__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT||LA19_0==RULE_STRING||(LA19_0>=12 && LA19_0<=14)||LA19_0==29) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1482:2: rule__IU__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl2974);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1496:1: rule__IU__Group_1__0 : rule__IU__Group_1__0__Impl rule__IU__Group_1__1 ;
    public final void rule__IU__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1500:1: ( rule__IU__Group_1__0__Impl rule__IU__Group_1__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1501:2: rule__IU__Group_1__0__Impl rule__IU__Group_1__1
            {
            pushFollow(FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__03009);
            rule__IU__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__03012);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1508:1: rule__IU__Group_1__0__Impl : ( ( rule__IU__Group_1_0__0 )? ) ;
    public final void rule__IU__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1512:1: ( ( ( rule__IU__Group_1_0__0 )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1513:1: ( ( rule__IU__Group_1_0__0 )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1513:1: ( ( rule__IU__Group_1_0__0 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1514:1: ( rule__IU__Group_1_0__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1_0()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1515:1: ( rule__IU__Group_1_0__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1515:2: rule__IU__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__IU__Group_1_0__0_in_rule__IU__Group_1__0__Impl3039);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1525:1: rule__IU__Group_1__1 : rule__IU__Group_1__1__Impl ;
    public final void rule__IU__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1529:1: ( rule__IU__Group_1__1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1530:2: rule__IU__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__13070);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1536:1: rule__IU__Group_1__1__Impl : ( ( rule__IU__Alternatives_1_1 ) ) ;
    public final void rule__IU__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1540:1: ( ( ( rule__IU__Alternatives_1_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1541:1: ( ( rule__IU__Alternatives_1_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1541:1: ( ( rule__IU__Alternatives_1_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1542:1: ( rule__IU__Alternatives_1_1 )
            {
             before(grammarAccess.getIUAccess().getAlternatives_1_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1543:1: ( rule__IU__Alternatives_1_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1543:2: rule__IU__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__IU__Alternatives_1_1_in_rule__IU__Group_1__1__Impl3097);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1557:1: rule__IU__Group_1_0__0 : rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1 ;
    public final void rule__IU__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1561:1: ( rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1562:2: rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__0__Impl_in_rule__IU__Group_1_0__03131);
            rule__IU__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1_0__1_in_rule__IU__Group_1_0__03134);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1569:1: rule__IU__Group_1_0__0__Impl : ( ';' ) ;
    public final void rule__IU__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1573:1: ( ( ';' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1574:1: ( ';' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1574:1: ( ';' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1575:1: ';'
            {
             before(grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0()); 
            match(input,29,FOLLOW_29_in_rule__IU__Group_1_0__0__Impl3162); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1588:1: rule__IU__Group_1_0__1 : rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2 ;
    public final void rule__IU__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1592:1: ( rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1593:2: rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__1__Impl_in_rule__IU__Group_1_0__13193);
            rule__IU__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1_0__2_in_rule__IU__Group_1_0__13196);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1600:1: rule__IU__Group_1_0__1__Impl : ( 'version' ) ;
    public final void rule__IU__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1604:1: ( ( 'version' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1605:1: ( 'version' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1605:1: ( 'version' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1606:1: 'version'
            {
             before(grammarAccess.getIUAccess().getVersionKeyword_1_0_1()); 
            match(input,30,FOLLOW_30_in_rule__IU__Group_1_0__1__Impl3224); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1619:1: rule__IU__Group_1_0__2 : rule__IU__Group_1_0__2__Impl ;
    public final void rule__IU__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1623:1: ( rule__IU__Group_1_0__2__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1624:2: rule__IU__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__2__Impl_in_rule__IU__Group_1_0__23255);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1630:1: rule__IU__Group_1_0__2__Impl : ( '=' ) ;
    public final void rule__IU__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1634:1: ( ( '=' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1635:1: ( '=' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1635:1: ( '=' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1636:1: '='
            {
             before(grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2()); 
            match(input,31,FOLLOW_31_in_rule__IU__Group_1_0__2__Impl3283); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1655:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1659:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1660:2: rule__Version__Group__0__Impl rule__Version__Group__1
            {
            pushFollow(FOLLOW_rule__Version__Group__0__Impl_in_rule__Version__Group__03320);
            rule__Version__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group__1_in_rule__Version__Group__03323);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1667:1: rule__Version__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1671:1: ( ( RULE_INT ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1672:1: ( RULE_INT )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1672:1: ( RULE_INT )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1673:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group__0__Impl3350); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1684:1: rule__Version__Group__1 : rule__Version__Group__1__Impl ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1688:1: ( rule__Version__Group__1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1689:2: rule__Version__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group__1__Impl_in_rule__Version__Group__13379);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1695:1: rule__Version__Group__1__Impl : ( ( rule__Version__Group_1__0 )? ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1699:1: ( ( ( rule__Version__Group_1__0 )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1700:1: ( ( rule__Version__Group_1__0 )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1700:1: ( ( rule__Version__Group_1__0 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1701:1: ( rule__Version__Group_1__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1702:1: ( rule__Version__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1702:2: rule__Version__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1__0_in_rule__Version__Group__1__Impl3406);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1716:1: rule__Version__Group_1__0 : rule__Version__Group_1__0__Impl rule__Version__Group_1__1 ;
    public final void rule__Version__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1720:1: ( rule__Version__Group_1__0__Impl rule__Version__Group_1__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1721:2: rule__Version__Group_1__0__Impl rule__Version__Group_1__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1__0__Impl_in_rule__Version__Group_1__03441);
            rule__Version__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1__1_in_rule__Version__Group_1__03444);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1728:1: rule__Version__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1732:1: ( ( '.' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1733:1: ( '.' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1733:1: ( '.' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1734:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Version__Group_1__0__Impl3472); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1747:1: rule__Version__Group_1__1 : rule__Version__Group_1__1__Impl rule__Version__Group_1__2 ;
    public final void rule__Version__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1751:1: ( rule__Version__Group_1__1__Impl rule__Version__Group_1__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1752:2: rule__Version__Group_1__1__Impl rule__Version__Group_1__2
            {
            pushFollow(FOLLOW_rule__Version__Group_1__1__Impl_in_rule__Version__Group_1__13503);
            rule__Version__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1__2_in_rule__Version__Group_1__13506);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1759:1: rule__Version__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1763:1: ( ( RULE_INT ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1764:1: ( RULE_INT )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1764:1: ( RULE_INT )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1765:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_1__1__Impl3533); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1776:1: rule__Version__Group_1__2 : rule__Version__Group_1__2__Impl ;
    public final void rule__Version__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1780:1: ( rule__Version__Group_1__2__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1781:2: rule__Version__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1__2__Impl_in_rule__Version__Group_1__23562);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1787:1: rule__Version__Group_1__2__Impl : ( ( rule__Version__Group_1_2__0 )? ) ;
    public final void rule__Version__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1791:1: ( ( ( rule__Version__Group_1_2__0 )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1792:1: ( ( rule__Version__Group_1_2__0 )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1792:1: ( ( rule__Version__Group_1_2__0 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1793:1: ( rule__Version__Group_1_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1_2()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1794:1: ( rule__Version__Group_1_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1794:2: rule__Version__Group_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1_2__0_in_rule__Version__Group_1__2__Impl3589);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1810:1: rule__Version__Group_1_2__0 : rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1 ;
    public final void rule__Version__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1814:1: ( rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1815:2: rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__0__Impl_in_rule__Version__Group_1_2__03626);
            rule__Version__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2__1_in_rule__Version__Group_1_2__03629);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1822:1: rule__Version__Group_1_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1826:1: ( ( '.' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1827:1: ( '.' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1827:1: ( '.' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1828:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
            match(input,32,FOLLOW_32_in_rule__Version__Group_1_2__0__Impl3657); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1841:1: rule__Version__Group_1_2__1 : rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2 ;
    public final void rule__Version__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1845:1: ( rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1846:2: rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__1__Impl_in_rule__Version__Group_1_2__13688);
            rule__Version__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2__2_in_rule__Version__Group_1_2__13691);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1853:1: rule__Version__Group_1_2__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1857:1: ( ( RULE_INT ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1858:1: ( RULE_INT )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1858:1: ( RULE_INT )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1859:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_1_2__1__Impl3718); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1870:1: rule__Version__Group_1_2__2 : rule__Version__Group_1_2__2__Impl ;
    public final void rule__Version__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1874:1: ( rule__Version__Group_1_2__2__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1875:2: rule__Version__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__2__Impl_in_rule__Version__Group_1_2__23747);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1881:1: rule__Version__Group_1_2__2__Impl : ( ( rule__Version__Group_1_2_2__0 )? ) ;
    public final void rule__Version__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1885:1: ( ( ( rule__Version__Group_1_2_2__0 )? ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1886:1: ( ( rule__Version__Group_1_2_2__0 )? )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1886:1: ( ( rule__Version__Group_1_2_2__0 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1887:1: ( rule__Version__Group_1_2_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1_2_2()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1888:1: ( rule__Version__Group_1_2_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1888:2: rule__Version__Group_1_2_2__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1_2_2__0_in_rule__Version__Group_1_2__2__Impl3774);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1904:1: rule__Version__Group_1_2_2__0 : rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1 ;
    public final void rule__Version__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1908:1: ( rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1909:2: rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2_2__0__Impl_in_rule__Version__Group_1_2_2__03811);
            rule__Version__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2_2__1_in_rule__Version__Group_1_2_2__03814);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1916:1: rule__Version__Group_1_2_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1920:1: ( ( '.' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1921:1: ( '.' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1921:1: ( '.' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1922:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
            match(input,32,FOLLOW_32_in_rule__Version__Group_1_2_2__0__Impl3842); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1935:1: rule__Version__Group_1_2_2__1 : rule__Version__Group_1_2_2__1__Impl ;
    public final void rule__Version__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1939:1: ( rule__Version__Group_1_2_2__1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1940:2: rule__Version__Group_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2_2__1__Impl_in_rule__Version__Group_1_2_2__13873);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1946:1: rule__Version__Group_1_2_2__1__Impl : ( ( rule__Version__Alternatives_1_2_2_1 ) ) ;
    public final void rule__Version__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1950:1: ( ( ( rule__Version__Alternatives_1_2_2_1 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1951:1: ( ( rule__Version__Alternatives_1_2_2_1 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1951:1: ( ( rule__Version__Alternatives_1_2_2_1 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1952:1: ( rule__Version__Alternatives_1_2_2_1 )
            {
             before(grammarAccess.getVersionAccess().getAlternatives_1_2_2_1()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1953:1: ( rule__Version__Alternatives_1_2_2_1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1953:2: rule__Version__Alternatives_1_2_2_1
            {
            pushFollow(FOLLOW_rule__Version__Alternatives_1_2_2_1_in_rule__Version__Group_1_2_2__1__Impl3900);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1967:1: rule__VersionRange__Group_0__0 : rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 ;
    public final void rule__VersionRange__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1971:1: ( rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1972:2: rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__0__Impl_in_rule__VersionRange__Group_0__03934);
            rule__VersionRange__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__1_in_rule__VersionRange__Group_0__03937);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1979:1: rule__VersionRange__Group_0__0__Impl : ( ( rule__VersionRange__Alternatives_0_0 ) ) ;
    public final void rule__VersionRange__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1983:1: ( ( ( rule__VersionRange__Alternatives_0_0 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1984:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1984:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1985:1: ( rule__VersionRange__Alternatives_0_0 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_0()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1986:1: ( rule__VersionRange__Alternatives_0_0 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1986:2: rule__VersionRange__Alternatives_0_0
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_0_0_in_rule__VersionRange__Group_0__0__Impl3964);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1996:1: rule__VersionRange__Group_0__1 : rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 ;
    public final void rule__VersionRange__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2000:1: ( rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2001:2: rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__1__Impl_in_rule__VersionRange__Group_0__13994);
            rule__VersionRange__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__2_in_rule__VersionRange__Group_0__13997);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2008:1: rule__VersionRange__Group_0__1__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2012:1: ( ( ruleVersion ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2013:1: ( ruleVersion )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2013:1: ( ruleVersion )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2014:1: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__1__Impl4024);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2025:1: rule__VersionRange__Group_0__2 : rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 ;
    public final void rule__VersionRange__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2029:1: ( rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2030:2: rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__2__Impl_in_rule__VersionRange__Group_0__24053);
            rule__VersionRange__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__3_in_rule__VersionRange__Group_0__24056);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2037:1: rule__VersionRange__Group_0__2__Impl : ( ',' ) ;
    public final void rule__VersionRange__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2041:1: ( ( ',' ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2042:1: ( ',' )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2042:1: ( ',' )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2043:1: ','
            {
             before(grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
            match(input,23,FOLLOW_23_in_rule__VersionRange__Group_0__2__Impl4084); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2056:1: rule__VersionRange__Group_0__3 : rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 ;
    public final void rule__VersionRange__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2060:1: ( rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2061:2: rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__3__Impl_in_rule__VersionRange__Group_0__34115);
            rule__VersionRange__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__4_in_rule__VersionRange__Group_0__34118);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2068:1: rule__VersionRange__Group_0__3__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2072:1: ( ( ruleVersion ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2073:1: ( ruleVersion )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2073:1: ( ruleVersion )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2074:1: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
            pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__3__Impl4145);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2085:1: rule__VersionRange__Group_0__4 : rule__VersionRange__Group_0__4__Impl ;
    public final void rule__VersionRange__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2089:1: ( rule__VersionRange__Group_0__4__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2090:2: rule__VersionRange__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__4__Impl_in_rule__VersionRange__Group_0__44174);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2096:1: rule__VersionRange__Group_0__4__Impl : ( ( rule__VersionRange__Alternatives_0_4 ) ) ;
    public final void rule__VersionRange__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2100:1: ( ( ( rule__VersionRange__Alternatives_0_4 ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2101:1: ( ( rule__VersionRange__Alternatives_0_4 ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2101:1: ( ( rule__VersionRange__Alternatives_0_4 ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2102:1: ( rule__VersionRange__Alternatives_0_4 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_4()); 
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2103:1: ( rule__VersionRange__Alternatives_0_4 )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2103:2: rule__VersionRange__Alternatives_0_4
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_0_4_in_rule__VersionRange__Group_0__4__Impl4201);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2124:1: rule__Location__UnorderedGroup_1 : rule__Location__UnorderedGroup_1__0 {...}?;
    public final void rule__Location__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2129:1: ( rule__Location__UnorderedGroup_1__0 {...}?)
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2130:2: rule__Location__UnorderedGroup_1__0 {...}?
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__0_in_rule__Location__UnorderedGroup_14242);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2141:1: rule__Location__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) ) ;
    public final void rule__Location__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2146:1: ( ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2147:3: ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2147:3: ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) )
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2149:4: ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2149:4: ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2150:5: {...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
                    }
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2150:105: ( ( ( rule__Location__IDAssignment_1_0 ) ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2151:6: ( ( rule__Location__IDAssignment_1_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2157:6: ( ( rule__Location__IDAssignment_1_0 ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2159:7: ( rule__Location__IDAssignment_1_0 )
                    {
                     before(grammarAccess.getLocationAccess().getIDAssignment_1_0()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2160:7: ( rule__Location__IDAssignment_1_0 )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2160:8: rule__Location__IDAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__Location__IDAssignment_1_0_in_rule__Location__UnorderedGroup_1__Impl4331);
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2166:4: ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) )
                    {
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2166:4: ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2167:5: {...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
                    }
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2167:105: ( ( ( rule__Location__UriAssignment_1_1 ) ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2168:6: ( ( rule__Location__UriAssignment_1_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2174:6: ( ( rule__Location__UriAssignment_1_1 ) )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2176:7: ( rule__Location__UriAssignment_1_1 )
                    {
                     before(grammarAccess.getLocationAccess().getUriAssignment_1_1()); 
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2177:7: ( rule__Location__UriAssignment_1_1 )
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2177:8: rule__Location__UriAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__Location__UriAssignment_1_1_in_rule__Location__UnorderedGroup_1__Impl4422);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2192:1: rule__Location__UnorderedGroup_1__0 : rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? ;
    public final void rule__Location__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2196:1: ( rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2197:2: rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )?
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__04481);
            rule__Location__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2198:2: ( rule__Location__UnorderedGroup_1__1 )?
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
                    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2198:2: rule__Location__UnorderedGroup_1__1
                    {
                    pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__1_in_rule__Location__UnorderedGroup_1__04484);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2205:1: rule__Location__UnorderedGroup_1__1 : rule__Location__UnorderedGroup_1__Impl ;
    public final void rule__Location__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2209:1: ( rule__Location__UnorderedGroup_1__Impl )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2210:2: rule__Location__UnorderedGroup_1__Impl
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__14509);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2221:1: rule__TargetPlatform__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TargetPlatform__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2225:1: ( ( RULE_STRING ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2226:1: ( RULE_STRING )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2226:1: ( RULE_STRING )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2227:1: RULE_STRING
            {
             before(grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_14541); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2236:1: rule__TargetPlatform__ContentsAssignment_2 : ( ruleTargetContent ) ;
    public final void rule__TargetPlatform__ContentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2240:1: ( ( ruleTargetContent ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2241:1: ( ruleTargetContent )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2241:1: ( ruleTargetContent )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2242:1: ruleTargetContent
            {
             before(grammarAccess.getTargetPlatformAccess().getContentsTargetContentParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTargetContent_in_rule__TargetPlatform__ContentsAssignment_24572);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2251:1: rule__Options__OptionsAssignment_1 : ( ruleOption ) ;
    public final void rule__Options__OptionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2255:1: ( ( ruleOption ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2256:1: ( ruleOption )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2256:1: ( ruleOption )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2257:1: ruleOption
            {
             before(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_14603);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2266:1: rule__Options__OptionsAssignment_2_1 : ( ruleOption ) ;
    public final void rule__Options__OptionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2270:1: ( ( ruleOption ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2271:1: ( ruleOption )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2271:1: ( ruleOption )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2272:1: ruleOption
            {
             before(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_2_14634);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2281:1: rule__Environment__EnvAssignment_2 : ( RULE_ID ) ;
    public final void rule__Environment__EnvAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2285:1: ( ( RULE_ID ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2286:1: ( RULE_ID )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2286:1: ( RULE_ID )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2287:1: RULE_ID
            {
             before(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_24665); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2296:1: rule__Environment__EnvAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Environment__EnvAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2300:1: ( ( RULE_ID ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2301:1: ( RULE_ID )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2301:1: ( RULE_ID )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2302:1: RULE_ID
            {
             before(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_3_14696); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2311:1: rule__IncludeDeclaration__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__IncludeDeclaration__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2315:1: ( ( RULE_STRING ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2316:1: ( RULE_STRING )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2316:1: ( RULE_STRING )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2317:1: RULE_STRING
            {
             before(grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IncludeDeclaration__ImportURIAssignment_14727); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2326:1: rule__Location__IDAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Location__IDAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2330:1: ( ( RULE_ID ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2331:1: ( RULE_ID )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2331:1: ( RULE_ID )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2332:1: RULE_ID
            {
             before(grammarAccess.getLocationAccess().getIDIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Location__IDAssignment_1_04758); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2341:1: rule__Location__UriAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Location__UriAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2345:1: ( ( RULE_STRING ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2346:1: ( RULE_STRING )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2346:1: ( RULE_STRING )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2347:1: RULE_STRING
            {
             before(grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Location__UriAssignment_1_14789); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2356:1: rule__Location__OptionsAssignment_2_1_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2360:1: ( ( ruleOption ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2361:1: ( ruleOption )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2361:1: ( ruleOption )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2362:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_14820);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2371:1: rule__Location__OptionsAssignment_2_1_2_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2375:1: ( ( ruleOption ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2376:1: ( ruleOption )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2376:1: ( ruleOption )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2377:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_14851);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2386:1: rule__Location__IusAssignment_2_2 : ( ruleIU ) ;
    public final void rule__Location__IusAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2390:1: ( ( ruleIU ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2391:1: ( ruleIU )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2391:1: ( ruleIU )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2392:1: ruleIU
            {
             before(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_24882);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2401:1: rule__IU__IDAssignment_0 : ( RULE_ID ) ;
    public final void rule__IU__IDAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2405:1: ( ( RULE_ID ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2406:1: ( RULE_ID )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2406:1: ( RULE_ID )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2407:1: RULE_ID
            {
             before(grammarAccess.getIUAccess().getIDIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IU__IDAssignment_04913); 
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2416:1: rule__IU__VersionAssignment_1_1_0 : ( ruleVersionRange ) ;
    public final void rule__IU__VersionAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2420:1: ( ( ruleVersionRange ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2421:1: ( ruleVersionRange )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2421:1: ( ruleVersionRange )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2422:1: ruleVersionRange
            {
             before(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0()); 
            pushFollow(FOLLOW_ruleVersionRange_in_rule__IU__VersionAssignment_1_1_04944);
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
    // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2431:1: rule__IU__VersionAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__IU__VersionAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2435:1: ( ( RULE_STRING ) )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2436:1: ( RULE_STRING )
            {
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2436:1: ( RULE_STRING )
            // ../org.eclipse.cbi.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2437:1: RULE_STRING
            {
             before(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_1_14975); 
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
    public static final BitSet FOLLOW_RULE_QUALIFIER_in_rule__Version__Alternatives_1_2_2_1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__0_in_rule__VersionRange__Alternatives865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Alternatives883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__VersionRange__Alternatives901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VersionRange__Alternatives_0_0936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VersionRange__Alternatives_0_0956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VersionRange__Alternatives_0_4991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VersionRange__Alternatives_0_41011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Option__Alternatives1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Option__Alternatives1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Option__Alternatives1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Option__Alternatives1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__01142 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__01145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__TargetPlatform__Group__0__Impl1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__11204 = new BitSet(new long[]{0x0000000007400000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__11207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__21264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__ContentsAssignment_2_in_rule__TargetPlatform__Group__2__Impl1291 = new BitSet(new long[]{0x0000000007400002L});
    public static final BitSet FOLLOW_rule__Options__Group__0__Impl_in_rule__Options__Group__01328 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__Options__Group__1_in_rule__Options__Group__01331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Options__Group__0__Impl1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group__1__Impl_in_rule__Options__Group__11390 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_rule__Options__Group__2_in_rule__Options__Group__11393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__OptionsAssignment_1_in_rule__Options__Group__1__Impl1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group__2__Impl_in_rule__Options__Group__21450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__0_in_rule__Options__Group__2__Impl1477 = new BitSet(new long[]{0x00000000009E0002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__0__Impl_in_rule__Options__Group_2__01514 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_rule__Options__Group_2__1_in_rule__Options__Group_2__01517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Options__Group_2__0__Impl1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__1__Impl_in_rule__Options__Group_2__11579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__OptionsAssignment_2_1_in_rule__Options__Group_2__1__Impl1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__0__Impl_in_rule__Environment__Group__01640 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Environment__Group__1_in_rule__Environment__Group__01643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__1__Impl_in_rule__Environment__Group__11701 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Environment__Group__2_in_rule__Environment__Group__11704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Environment__Group__1__Impl1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__2__Impl_in_rule__Environment__Group__21763 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_rule__Environment__Group__3_in_rule__Environment__Group__21766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__EnvAssignment_2_in_rule__Environment__Group__2__Impl1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__3__Impl_in_rule__Environment__Group__31823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__0_in_rule__Environment__Group__3__Impl1850 = new BitSet(new long[]{0x0000000000800012L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__0__Impl_in_rule__Environment__Group_3__01889 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__1_in_rule__Environment__Group_3__01892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Environment__Group_3__0__Impl1921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__1__Impl_in_rule__Environment__Group_3__11954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__EnvAssignment_3_1_in_rule__Environment__Group_3__1__Impl1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__0__Impl_in_rule__IncludeDeclaration__Group__02015 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__1_in_rule__IncludeDeclaration__Group__02018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__IncludeDeclaration__Group__0__Impl2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__1__Impl_in_rule__IncludeDeclaration__Group__12077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__ImportURIAssignment_1_in_rule__IncludeDeclaration__Group__1__Impl2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__02138 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_rule__Location__Group__1_in_rule__Location__Group__02141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Location__Group__0__Impl2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__12200 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Location__Group__2_in_rule__Location__Group__12203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1_in_rule__Location__Group__1__Impl2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__22260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__02324 = new BitSet(new long[]{0x0000000010400010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__02327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Location__Group_2__0__Impl2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__12386 = new BitSet(new long[]{0x0000000010400010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__12389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__22447 = new BitSet(new long[]{0x0000000010400010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__22450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IusAssignment_2_2_in_rule__Location__Group_2__2__Impl2477 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__32508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Location__Group_2__3__Impl2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__02575 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__02578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Location__Group_2_1__0__Impl2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__12637 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__12640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__22697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl2724 = new BitSet(new long[]{0x00000000009E0002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__02761 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__02764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Location__Group_2_1_2__0__Impl2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__12826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__02887 = new BitSet(new long[]{0x00000000200070A0L});
    public static final BitSet FOLLOW_rule__IU__Group__1_in_rule__IU__Group__02890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl2917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__12947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__03009 = new BitSet(new long[]{0x00000000200070A0L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__03012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__0_in_rule__IU__Group_1__0__Impl3039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__13070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Alternatives_1_1_in_rule__IU__Group_1__1__Impl3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__0__Impl_in_rule__IU__Group_1_0__03131 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__1_in_rule__IU__Group_1_0__03134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__IU__Group_1_0__0__Impl3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__1__Impl_in_rule__IU__Group_1_0__13193 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__2_in_rule__IU__Group_1_0__13196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__IU__Group_1_0__1__Impl3224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__2__Impl_in_rule__IU__Group_1_0__23255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__IU__Group_1_0__2__Impl3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group__0__Impl_in_rule__Version__Group__03320 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Version__Group__1_in_rule__Version__Group__03323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group__0__Impl3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group__1__Impl_in_rule__Version__Group__13379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__0_in_rule__Version__Group__1__Impl3406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__0__Impl_in_rule__Version__Group_1__03441 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Version__Group_1__1_in_rule__Version__Group_1__03444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Version__Group_1__0__Impl3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__1__Impl_in_rule__Version__Group_1__13503 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Version__Group_1__2_in_rule__Version__Group_1__13506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_1__1__Impl3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__2__Impl_in_rule__Version__Group_1__23562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__0_in_rule__Version__Group_1__2__Impl3589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__0__Impl_in_rule__Version__Group_1_2__03626 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__1_in_rule__Version__Group_1_2__03629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Version__Group_1_2__0__Impl3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__1__Impl_in_rule__Version__Group_1_2__13688 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__2_in_rule__Version__Group_1_2__13691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_1_2__1__Impl3718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__2__Impl_in_rule__Version__Group_1_2__23747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__0_in_rule__Version__Group_1_2__2__Impl3774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__0__Impl_in_rule__Version__Group_1_2_2__03811 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__1_in_rule__Version__Group_1_2_2__03814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Version__Group_1_2_2__0__Impl3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__1__Impl_in_rule__Version__Group_1_2_2__13873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Alternatives_1_2_2_1_in_rule__Version__Group_1_2_2__1__Impl3900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__0__Impl_in_rule__VersionRange__Group_0__03934 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__1_in_rule__VersionRange__Group_0__03937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_0_0_in_rule__VersionRange__Group_0__0__Impl3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__1__Impl_in_rule__VersionRange__Group_0__13994 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__2_in_rule__VersionRange__Group_0__13997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__1__Impl4024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__2__Impl_in_rule__VersionRange__Group_0__24053 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__3_in_rule__VersionRange__Group_0__24056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__VersionRange__Group_0__2__Impl4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__3__Impl_in_rule__VersionRange__Group_0__34115 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__4_in_rule__VersionRange__Group_0__34118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__3__Impl4145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__4__Impl_in_rule__VersionRange__Group_0__44174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_0_4_in_rule__VersionRange__Group_0__4__Impl4201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__0_in_rule__Location__UnorderedGroup_14242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IDAssignment_1_0_in_rule__Location__UnorderedGroup_1__Impl4331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UriAssignment_1_1_in_rule__Location__UnorderedGroup_1__Impl4422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__04481 = new BitSet(new long[]{0x0000000000000092L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__1_in_rule__Location__UnorderedGroup_1__04484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__14509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_14541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_rule__TargetPlatform__ContentsAssignment_24572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_14603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_2_14634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_24665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_3_14696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IncludeDeclaration__ImportURIAssignment_14727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Location__IDAssignment_1_04758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Location__UriAssignment_1_14789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_14820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_14851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_24882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IU__IDAssignment_04913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_rule__IU__VersionAssignment_1_1_04944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_1_14975 = new BitSet(new long[]{0x0000000000000002L});

}
