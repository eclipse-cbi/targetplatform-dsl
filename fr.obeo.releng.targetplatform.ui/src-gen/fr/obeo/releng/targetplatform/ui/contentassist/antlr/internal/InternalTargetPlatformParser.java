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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_QUALIFIER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'lazy'", "'('", "'['", "')'", "']'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'", "'target'", "'with'", "','", "'environment'", "'define'", "'='", "'+'", "'${'", "'}'", "'include'", "'location'", "'{'", "';'", "'version'", "'.'"
    };
    public static final int RULE_STRING=7;
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
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_QUALIFIER=6;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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

            if ( (LA1_0==21) ) {
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


    // $ANTLR start "entryRuleVarDefinition"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:172:1: entryRuleVarDefinition : ruleVarDefinition EOF ;
    public final void entryRuleVarDefinition() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:173:1: ( ruleVarDefinition EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:174:1: ruleVarDefinition EOF
            {
             before(grammarAccess.getVarDefinitionRule()); 
            pushFollow(FOLLOW_ruleVarDefinition_in_entryRuleVarDefinition302);
            ruleVarDefinition();

            state._fsp--;

             after(grammarAccess.getVarDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarDefinition309); 

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
    // $ANTLR end "entryRuleVarDefinition"


    // $ANTLR start "ruleVarDefinition"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:181:1: ruleVarDefinition : ( ( rule__VarDefinition__Group__0 ) ) ;
    public final void ruleVarDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:185:2: ( ( ( rule__VarDefinition__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:186:1: ( ( rule__VarDefinition__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:186:1: ( ( rule__VarDefinition__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:187:1: ( rule__VarDefinition__Group__0 )
            {
             before(grammarAccess.getVarDefinitionAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:188:1: ( rule__VarDefinition__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:188:2: rule__VarDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__VarDefinition__Group__0_in_ruleVarDefinition335);
            rule__VarDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVarDefinitionAccess().getGroup()); 

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
    // $ANTLR end "ruleVarDefinition"


    // $ANTLR start "entryRuleCompositeString"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:200:1: entryRuleCompositeString : ruleCompositeString EOF ;
    public final void entryRuleCompositeString() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:201:1: ( ruleCompositeString EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:202:1: ruleCompositeString EOF
            {
             before(grammarAccess.getCompositeStringRule()); 
            pushFollow(FOLLOW_ruleCompositeString_in_entryRuleCompositeString362);
            ruleCompositeString();

            state._fsp--;

             after(grammarAccess.getCompositeStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeString369); 

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
    // $ANTLR end "entryRuleCompositeString"


    // $ANTLR start "ruleCompositeString"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:209:1: ruleCompositeString : ( ( rule__CompositeString__Group__0 ) ) ;
    public final void ruleCompositeString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:213:2: ( ( ( rule__CompositeString__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:214:1: ( ( rule__CompositeString__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:214:1: ( ( rule__CompositeString__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:215:1: ( rule__CompositeString__Group__0 )
            {
             before(grammarAccess.getCompositeStringAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:216:1: ( rule__CompositeString__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:216:2: rule__CompositeString__Group__0
            {
            pushFollow(FOLLOW_rule__CompositeString__Group__0_in_ruleCompositeString395);
            rule__CompositeString__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeStringAccess().getGroup()); 

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
    // $ANTLR end "ruleCompositeString"


    // $ANTLR start "entryRuleCompositeStringPart"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:228:1: entryRuleCompositeStringPart : ruleCompositeStringPart EOF ;
    public final void entryRuleCompositeStringPart() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:229:1: ( ruleCompositeStringPart EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:230:1: ruleCompositeStringPart EOF
            {
             before(grammarAccess.getCompositeStringPartRule()); 
            pushFollow(FOLLOW_ruleCompositeStringPart_in_entryRuleCompositeStringPart422);
            ruleCompositeStringPart();

            state._fsp--;

             after(grammarAccess.getCompositeStringPartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeStringPart429); 

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
    // $ANTLR end "entryRuleCompositeStringPart"


    // $ANTLR start "ruleCompositeStringPart"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:237:1: ruleCompositeStringPart : ( ( rule__CompositeStringPart__Alternatives ) ) ;
    public final void ruleCompositeStringPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:241:2: ( ( ( rule__CompositeStringPart__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:242:1: ( ( rule__CompositeStringPart__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:242:1: ( ( rule__CompositeStringPart__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:243:1: ( rule__CompositeStringPart__Alternatives )
            {
             before(grammarAccess.getCompositeStringPartAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:244:1: ( rule__CompositeStringPart__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:244:2: rule__CompositeStringPart__Alternatives
            {
            pushFollow(FOLLOW_rule__CompositeStringPart__Alternatives_in_ruleCompositeStringPart455);
            rule__CompositeStringPart__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCompositeStringPartAccess().getAlternatives()); 

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
    // $ANTLR end "ruleCompositeStringPart"


    // $ANTLR start "entryRuleVarCall"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:256:1: entryRuleVarCall : ruleVarCall EOF ;
    public final void entryRuleVarCall() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:257:1: ( ruleVarCall EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:258:1: ruleVarCall EOF
            {
             before(grammarAccess.getVarCallRule()); 
            pushFollow(FOLLOW_ruleVarCall_in_entryRuleVarCall482);
            ruleVarCall();

            state._fsp--;

             after(grammarAccess.getVarCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarCall489); 

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
    // $ANTLR end "entryRuleVarCall"


    // $ANTLR start "ruleVarCall"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:265:1: ruleVarCall : ( ( rule__VarCall__Group__0 ) ) ;
    public final void ruleVarCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:269:2: ( ( ( rule__VarCall__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:270:1: ( ( rule__VarCall__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:270:1: ( ( rule__VarCall__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:271:1: ( rule__VarCall__Group__0 )
            {
             before(grammarAccess.getVarCallAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:272:1: ( rule__VarCall__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:272:2: rule__VarCall__Group__0
            {
            pushFollow(FOLLOW_rule__VarCall__Group__0_in_ruleVarCall515);
            rule__VarCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVarCallAccess().getGroup()); 

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
    // $ANTLR end "ruleVarCall"


    // $ANTLR start "entryRuleStaticString"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:284:1: entryRuleStaticString : ruleStaticString EOF ;
    public final void entryRuleStaticString() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:285:1: ( ruleStaticString EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:286:1: ruleStaticString EOF
            {
             before(grammarAccess.getStaticStringRule()); 
            pushFollow(FOLLOW_ruleStaticString_in_entryRuleStaticString542);
            ruleStaticString();

            state._fsp--;

             after(grammarAccess.getStaticStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticString549); 

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
    // $ANTLR end "entryRuleStaticString"


    // $ANTLR start "ruleStaticString"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:293:1: ruleStaticString : ( ( rule__StaticString__ValueAssignment ) ) ;
    public final void ruleStaticString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:297:2: ( ( ( rule__StaticString__ValueAssignment ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:298:1: ( ( rule__StaticString__ValueAssignment ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:298:1: ( ( rule__StaticString__ValueAssignment ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:299:1: ( rule__StaticString__ValueAssignment )
            {
             before(grammarAccess.getStaticStringAccess().getValueAssignment()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:300:1: ( rule__StaticString__ValueAssignment )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:300:2: rule__StaticString__ValueAssignment
            {
            pushFollow(FOLLOW_rule__StaticString__ValueAssignment_in_ruleStaticString575);
            rule__StaticString__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStaticStringAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleStaticString"


    // $ANTLR start "entryRuleIncludeDeclaration"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:312:1: entryRuleIncludeDeclaration : ruleIncludeDeclaration EOF ;
    public final void entryRuleIncludeDeclaration() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:313:1: ( ruleIncludeDeclaration EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:314:1: ruleIncludeDeclaration EOF
            {
             before(grammarAccess.getIncludeDeclarationRule()); 
            pushFollow(FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration602);
            ruleIncludeDeclaration();

            state._fsp--;

             after(grammarAccess.getIncludeDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDeclaration609); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:321:1: ruleIncludeDeclaration : ( ( rule__IncludeDeclaration__Group__0 ) ) ;
    public final void ruleIncludeDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:325:2: ( ( ( rule__IncludeDeclaration__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:326:1: ( ( rule__IncludeDeclaration__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:326:1: ( ( rule__IncludeDeclaration__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:327:1: ( rule__IncludeDeclaration__Group__0 )
            {
             before(grammarAccess.getIncludeDeclarationAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:328:1: ( rule__IncludeDeclaration__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:328:2: rule__IncludeDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__0_in_ruleIncludeDeclaration635);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:340:1: entryRuleLocation : ruleLocation EOF ;
    public final void entryRuleLocation() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:341:1: ( ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:342:1: ruleLocation EOF
            {
             before(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation662);
            ruleLocation();

            state._fsp--;

             after(grammarAccess.getLocationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation669); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:349:1: ruleLocation : ( ( rule__Location__Group__0 ) ) ;
    public final void ruleLocation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:353:2: ( ( ( rule__Location__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:354:1: ( ( rule__Location__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:354:1: ( ( rule__Location__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:355:1: ( rule__Location__Group__0 )
            {
             before(grammarAccess.getLocationAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:356:1: ( rule__Location__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:356:2: rule__Location__Group__0
            {
            pushFollow(FOLLOW_rule__Location__Group__0_in_ruleLocation695);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:368:1: entryRuleIU : ruleIU EOF ;
    public final void entryRuleIU() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:369:1: ( ruleIU EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:370:1: ruleIU EOF
            {
             before(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU722);
            ruleIU();

            state._fsp--;

             after(grammarAccess.getIURule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU729); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:377:1: ruleIU : ( ( rule__IU__Group__0 ) ) ;
    public final void ruleIU() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:381:2: ( ( ( rule__IU__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:382:1: ( ( rule__IU__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:382:1: ( ( rule__IU__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:383:1: ( rule__IU__Group__0 )
            {
             before(grammarAccess.getIUAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:384:1: ( rule__IU__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:384:2: rule__IU__Group__0
            {
            pushFollow(FOLLOW_rule__IU__Group__0_in_ruleIU755);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:396:1: entryRuleVersion : ruleVersion EOF ;
    public final void entryRuleVersion() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:400:1: ( ruleVersion EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:401:1: ruleVersion EOF
            {
             before(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion787);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion794); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:411:1: ruleVersion : ( ( rule__Version__Group__0 ) ) ;
    public final void ruleVersion() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:416:2: ( ( ( rule__Version__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:417:1: ( ( rule__Version__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:417:1: ( ( rule__Version__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:418:1: ( rule__Version__Group__0 )
            {
             before(grammarAccess.getVersionAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:419:1: ( rule__Version__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:419:2: rule__Version__Group__0
            {
            pushFollow(FOLLOW_rule__Version__Group__0_in_ruleVersion824);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:432:1: entryRuleVersionRange : ruleVersionRange EOF ;
    public final void entryRuleVersionRange() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:436:1: ( ruleVersionRange EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:437:1: ruleVersionRange EOF
            {
             before(grammarAccess.getVersionRangeRule()); 
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange856);
            ruleVersionRange();

            state._fsp--;

             after(grammarAccess.getVersionRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange863); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:447:1: ruleVersionRange : ( ( rule__VersionRange__Alternatives ) ) ;
    public final void ruleVersionRange() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:452:2: ( ( ( rule__VersionRange__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:453:1: ( ( rule__VersionRange__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:453:1: ( ( rule__VersionRange__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:454:1: ( rule__VersionRange__Alternatives )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:455:1: ( rule__VersionRange__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:455:2: rule__VersionRange__Alternatives
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_in_ruleVersionRange893);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:469:1: ruleOption : ( ( rule__Option__Alternatives ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:473:1: ( ( ( rule__Option__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:474:1: ( ( rule__Option__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:474:1: ( ( rule__Option__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:475:1: ( rule__Option__Alternatives )
            {
             before(grammarAccess.getOptionAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:476:1: ( rule__Option__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:476:2: rule__Option__Alternatives
            {
            pushFollow(FOLLOW_rule__Option__Alternatives_in_ruleOption930);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:487:1: rule__TargetContent__Alternatives : ( ( ruleOptions ) | ( ruleEnvironment ) | ( ruleIncludeDeclaration ) | ( ruleLocation ) | ( ruleVarDefinition ) );
    public final void rule__TargetContent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:491:1: ( ( ruleOptions ) | ( ruleEnvironment ) | ( ruleIncludeDeclaration ) | ( ruleLocation ) | ( ruleVarDefinition ) )
            int alt2=5;
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
            case 30:
                {
                alt2=3;
                }
                break;
            case 31:
                {
                alt2=4;
                }
                break;
            case 25:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:492:1: ( ruleOptions )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:492:1: ( ruleOptions )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:493:1: ruleOptions
                    {
                     before(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleOptions_in_rule__TargetContent__Alternatives965);
                    ruleOptions();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:498:6: ( ruleEnvironment )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:498:6: ( ruleEnvironment )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:499:1: ruleEnvironment
                    {
                     before(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnvironment_in_rule__TargetContent__Alternatives982);
                    ruleEnvironment();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:504:6: ( ruleIncludeDeclaration )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:504:6: ( ruleIncludeDeclaration )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:505:1: ruleIncludeDeclaration
                    {
                     before(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIncludeDeclaration_in_rule__TargetContent__Alternatives999);
                    ruleIncludeDeclaration();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:510:6: ( ruleLocation )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:510:6: ( ruleLocation )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:511:1: ruleLocation
                    {
                     before(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleLocation_in_rule__TargetContent__Alternatives1016);
                    ruleLocation();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:516:6: ( ruleVarDefinition )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:516:6: ( ruleVarDefinition )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:517:1: ruleVarDefinition
                    {
                     before(grammarAccess.getTargetContentAccess().getVarDefinitionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleVarDefinition_in_rule__TargetContent__Alternatives1033);
                    ruleVarDefinition();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getVarDefinitionParserRuleCall_4()); 

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


    // $ANTLR start "rule__CompositeStringPart__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:527:1: rule__CompositeStringPart__Alternatives : ( ( ruleVarCall ) | ( ruleStaticString ) );
    public final void rule__CompositeStringPart__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:531:1: ( ( ruleVarCall ) | ( ruleStaticString ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==28) ) {
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
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:532:1: ( ruleVarCall )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:532:1: ( ruleVarCall )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:533:1: ruleVarCall
                    {
                     before(grammarAccess.getCompositeStringPartAccess().getVarCallParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleVarCall_in_rule__CompositeStringPart__Alternatives1065);
                    ruleVarCall();

                    state._fsp--;

                     after(grammarAccess.getCompositeStringPartAccess().getVarCallParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:538:6: ( ruleStaticString )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:538:6: ( ruleStaticString )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:539:1: ruleStaticString
                    {
                     before(grammarAccess.getCompositeStringPartAccess().getStaticStringParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleStaticString_in_rule__CompositeStringPart__Alternatives1082);
                    ruleStaticString();

                    state._fsp--;

                     after(grammarAccess.getCompositeStringPartAccess().getStaticStringParserRuleCall_1()); 

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
    // $ANTLR end "rule__CompositeStringPart__Alternatives"


    // $ANTLR start "rule__IU__Alternatives_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:549:1: rule__IU__Alternatives_1_1 : ( ( ( rule__IU__Alternatives_1_1_0 ) ) | ( ( rule__IU__VarVersionAssignment_1_1_1 ) ) );
    public final void rule__IU__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:553:1: ( ( ( rule__IU__Alternatives_1_1_0 ) ) | ( ( rule__IU__VarVersionAssignment_1_1_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INT||LA4_0==RULE_STRING||(LA4_0>=12 && LA4_0<=14)) ) {
                alt4=1;
            }
            else if ( (LA4_0==28) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:554:1: ( ( rule__IU__Alternatives_1_1_0 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:554:1: ( ( rule__IU__Alternatives_1_1_0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:555:1: ( rule__IU__Alternatives_1_1_0 )
                    {
                     before(grammarAccess.getIUAccess().getAlternatives_1_1_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:556:1: ( rule__IU__Alternatives_1_1_0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:556:2: rule__IU__Alternatives_1_1_0
                    {
                    pushFollow(FOLLOW_rule__IU__Alternatives_1_1_0_in_rule__IU__Alternatives_1_11114);
                    rule__IU__Alternatives_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getAlternatives_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:560:6: ( ( rule__IU__VarVersionAssignment_1_1_1 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:560:6: ( ( rule__IU__VarVersionAssignment_1_1_1 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:561:1: ( rule__IU__VarVersionAssignment_1_1_1 )
                    {
                     before(grammarAccess.getIUAccess().getVarVersionAssignment_1_1_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:562:1: ( rule__IU__VarVersionAssignment_1_1_1 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:562:2: rule__IU__VarVersionAssignment_1_1_1
                    {
                    pushFollow(FOLLOW_rule__IU__VarVersionAssignment_1_1_1_in_rule__IU__Alternatives_1_11132);
                    rule__IU__VarVersionAssignment_1_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getVarVersionAssignment_1_1_1()); 

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


    // $ANTLR start "rule__IU__Alternatives_1_1_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:571:1: rule__IU__Alternatives_1_1_0 : ( ( ( rule__IU__VersionAssignment_1_1_0_0 ) ) | ( ( rule__IU__VersionAssignment_1_1_0_1 ) ) );
    public final void rule__IU__Alternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:575:1: ( ( ( rule__IU__VersionAssignment_1_1_0_0 ) ) | ( ( rule__IU__VersionAssignment_1_1_0_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT||(LA5_0>=12 && LA5_0<=14)) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_STRING) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:576:1: ( ( rule__IU__VersionAssignment_1_1_0_0 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:576:1: ( ( rule__IU__VersionAssignment_1_1_0_0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:577:1: ( rule__IU__VersionAssignment_1_1_0_0 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_1_0_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:578:1: ( rule__IU__VersionAssignment_1_1_0_0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:578:2: rule__IU__VersionAssignment_1_1_0_0
                    {
                    pushFollow(FOLLOW_rule__IU__VersionAssignment_1_1_0_0_in_rule__IU__Alternatives_1_1_01165);
                    rule__IU__VersionAssignment_1_1_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getVersionAssignment_1_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:582:6: ( ( rule__IU__VersionAssignment_1_1_0_1 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:582:6: ( ( rule__IU__VersionAssignment_1_1_0_1 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:583:1: ( rule__IU__VersionAssignment_1_1_0_1 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_1_0_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:584:1: ( rule__IU__VersionAssignment_1_1_0_1 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:584:2: rule__IU__VersionAssignment_1_1_0_1
                    {
                    pushFollow(FOLLOW_rule__IU__VersionAssignment_1_1_0_1_in_rule__IU__Alternatives_1_1_01183);
                    rule__IU__VersionAssignment_1_1_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getVersionAssignment_1_1_0_1()); 

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
    // $ANTLR end "rule__IU__Alternatives_1_1_0"


    // $ANTLR start "rule__Version__Alternatives_1_2_2_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:593:1: rule__Version__Alternatives_1_2_2_1 : ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_QUALIFIER ) );
    public final void rule__Version__Alternatives_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:597:1: ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_QUALIFIER ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt6=1;
                }
                break;
            case RULE_INT:
                {
                alt6=2;
                }
                break;
            case RULE_QUALIFIER:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:598:1: ( RULE_ID )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:598:1: ( RULE_ID )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:599:1: RULE_ID
                    {
                     before(grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Version__Alternatives_1_2_2_11216); 
                     after(grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:604:6: ( RULE_INT )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:604:6: ( RULE_INT )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:605:1: RULE_INT
                    {
                     before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Alternatives_1_2_2_11233); 
                     after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:610:6: ( RULE_QUALIFIER )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:610:6: ( RULE_QUALIFIER )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:611:1: RULE_QUALIFIER
                    {
                     before(grammarAccess.getVersionAccess().getQUALIFIERTerminalRuleCall_1_2_2_1_2()); 
                    match(input,RULE_QUALIFIER,FOLLOW_RULE_QUALIFIER_in_rule__Version__Alternatives_1_2_2_11250); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:621:1: rule__VersionRange__Alternatives : ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) | ( 'lazy' ) );
    public final void rule__VersionRange__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:625:1: ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) | ( 'lazy' ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 13:
            case 14:
                {
                alt7=1;
                }
                break;
            case RULE_INT:
                {
                alt7=2;
                }
                break;
            case 12:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:626:1: ( ( rule__VersionRange__Group_0__0 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:626:1: ( ( rule__VersionRange__Group_0__0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:627:1: ( rule__VersionRange__Group_0__0 )
                    {
                     before(grammarAccess.getVersionRangeAccess().getGroup_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:628:1: ( rule__VersionRange__Group_0__0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:628:2: rule__VersionRange__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__VersionRange__Group_0__0_in_rule__VersionRange__Alternatives1282);
                    rule__VersionRange__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionRangeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:632:6: ( ruleVersion )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:632:6: ( ruleVersion )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:633:1: ruleVersion
                    {
                     before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Alternatives1300);
                    ruleVersion();

                    state._fsp--;

                     after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:638:6: ( 'lazy' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:638:6: ( 'lazy' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:639:1: 'lazy'
                    {
                     before(grammarAccess.getVersionRangeAccess().getLazyKeyword_2()); 
                    match(input,12,FOLLOW_12_in_rule__VersionRange__Alternatives1318); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:651:1: rule__VersionRange__Alternatives_0_0 : ( ( '(' ) | ( '[' ) );
    public final void rule__VersionRange__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:655:1: ( ( '(' ) | ( '[' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            else if ( (LA8_0==14) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:656:1: ( '(' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:656:1: ( '(' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:657:1: '('
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                    match(input,13,FOLLOW_13_in_rule__VersionRange__Alternatives_0_01353); 
                     after(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:664:6: ( '[' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:664:6: ( '[' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:665:1: '['
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                    match(input,14,FOLLOW_14_in_rule__VersionRange__Alternatives_0_01373); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:677:1: rule__VersionRange__Alternatives_0_4 : ( ( ')' ) | ( ']' ) );
    public final void rule__VersionRange__Alternatives_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:681:1: ( ( ')' ) | ( ']' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            else if ( (LA9_0==16) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:682:1: ( ')' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:682:1: ( ')' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:683:1: ')'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                    match(input,15,FOLLOW_15_in_rule__VersionRange__Alternatives_0_41408); 
                     after(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:690:6: ( ']' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:690:6: ( ']' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:691:1: ']'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1()); 
                    match(input,16,FOLLOW_16_in_rule__VersionRange__Alternatives_0_41428); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:703:1: rule__Option__Alternatives : ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) );
    public final void rule__Option__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:707:1: ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt10=1;
                }
                break;
            case 18:
                {
                alt10=2;
                }
                break;
            case 19:
                {
                alt10=3;
                }
                break;
            case 20:
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
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:708:1: ( ( 'requirements' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:708:1: ( ( 'requirements' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:709:1: ( 'requirements' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:710:1: ( 'requirements' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:710:3: 'requirements'
                    {
                    match(input,17,FOLLOW_17_in_rule__Option__Alternatives1463); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:715:6: ( ( 'allEnvironments' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:715:6: ( ( 'allEnvironments' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:716:1: ( 'allEnvironments' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:717:1: ( 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:717:3: 'allEnvironments'
                    {
                    match(input,18,FOLLOW_18_in_rule__Option__Alternatives1484); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:722:6: ( ( 'source' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:722:6: ( ( 'source' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:723:1: ( 'source' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:724:1: ( 'source' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:724:3: 'source'
                    {
                    match(input,19,FOLLOW_19_in_rule__Option__Alternatives1505); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:729:6: ( ( 'configurePhase' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:729:6: ( ( 'configurePhase' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:730:1: ( 'configurePhase' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:731:1: ( 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:731:3: 'configurePhase'
                    {
                    match(input,20,FOLLOW_20_in_rule__Option__Alternatives1526); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:743:1: rule__TargetPlatform__Group__0 : rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 ;
    public final void rule__TargetPlatform__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:747:1: ( rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:748:2: rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__01559);
            rule__TargetPlatform__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__01562);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:755:1: rule__TargetPlatform__Group__0__Impl : ( 'target' ) ;
    public final void rule__TargetPlatform__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:759:1: ( ( 'target' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:760:1: ( 'target' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:760:1: ( 'target' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:761:1: 'target'
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__TargetPlatform__Group__0__Impl1590); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:774:1: rule__TargetPlatform__Group__1 : rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 ;
    public final void rule__TargetPlatform__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:778:1: ( rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:779:2: rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__11621);
            rule__TargetPlatform__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__11624);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:786:1: rule__TargetPlatform__Group__1__Impl : ( ( rule__TargetPlatform__NameAssignment_1 ) ) ;
    public final void rule__TargetPlatform__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:790:1: ( ( ( rule__TargetPlatform__NameAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:791:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:791:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:792:1: ( rule__TargetPlatform__NameAssignment_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getNameAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:793:1: ( rule__TargetPlatform__NameAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:793:2: rule__TargetPlatform__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl1651);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:803:1: rule__TargetPlatform__Group__2 : rule__TargetPlatform__Group__2__Impl ;
    public final void rule__TargetPlatform__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:807:1: ( rule__TargetPlatform__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:808:2: rule__TargetPlatform__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__21681);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:814:1: rule__TargetPlatform__Group__2__Impl : ( ( rule__TargetPlatform__ContentsAssignment_2 )* ) ;
    public final void rule__TargetPlatform__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:818:1: ( ( ( rule__TargetPlatform__ContentsAssignment_2 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:819:1: ( ( rule__TargetPlatform__ContentsAssignment_2 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:819:1: ( ( rule__TargetPlatform__ContentsAssignment_2 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:820:1: ( rule__TargetPlatform__ContentsAssignment_2 )*
            {
             before(grammarAccess.getTargetPlatformAccess().getContentsAssignment_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:821:1: ( rule__TargetPlatform__ContentsAssignment_2 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==22||(LA11_0>=24 && LA11_0<=25)||(LA11_0>=30 && LA11_0<=31)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:821:2: rule__TargetPlatform__ContentsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__TargetPlatform__ContentsAssignment_2_in_rule__TargetPlatform__Group__2__Impl1708);
            	    rule__TargetPlatform__ContentsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:837:1: rule__Options__Group__0 : rule__Options__Group__0__Impl rule__Options__Group__1 ;
    public final void rule__Options__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:841:1: ( rule__Options__Group__0__Impl rule__Options__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:842:2: rule__Options__Group__0__Impl rule__Options__Group__1
            {
            pushFollow(FOLLOW_rule__Options__Group__0__Impl_in_rule__Options__Group__01745);
            rule__Options__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group__1_in_rule__Options__Group__01748);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:849:1: rule__Options__Group__0__Impl : ( 'with' ) ;
    public final void rule__Options__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:853:1: ( ( 'with' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:854:1: ( 'with' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:854:1: ( 'with' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:855:1: 'with'
            {
             before(grammarAccess.getOptionsAccess().getWithKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Options__Group__0__Impl1776); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:868:1: rule__Options__Group__1 : rule__Options__Group__1__Impl rule__Options__Group__2 ;
    public final void rule__Options__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:872:1: ( rule__Options__Group__1__Impl rule__Options__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:873:2: rule__Options__Group__1__Impl rule__Options__Group__2
            {
            pushFollow(FOLLOW_rule__Options__Group__1__Impl_in_rule__Options__Group__11807);
            rule__Options__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group__2_in_rule__Options__Group__11810);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:880:1: rule__Options__Group__1__Impl : ( ( rule__Options__OptionsAssignment_1 ) ) ;
    public final void rule__Options__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:884:1: ( ( ( rule__Options__OptionsAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:885:1: ( ( rule__Options__OptionsAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:885:1: ( ( rule__Options__OptionsAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:886:1: ( rule__Options__OptionsAssignment_1 )
            {
             before(grammarAccess.getOptionsAccess().getOptionsAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:887:1: ( rule__Options__OptionsAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:887:2: rule__Options__OptionsAssignment_1
            {
            pushFollow(FOLLOW_rule__Options__OptionsAssignment_1_in_rule__Options__Group__1__Impl1837);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:897:1: rule__Options__Group__2 : rule__Options__Group__2__Impl ;
    public final void rule__Options__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:901:1: ( rule__Options__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:902:2: rule__Options__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Options__Group__2__Impl_in_rule__Options__Group__21867);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:908:1: rule__Options__Group__2__Impl : ( ( rule__Options__Group_2__0 )* ) ;
    public final void rule__Options__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:912:1: ( ( ( rule__Options__Group_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:913:1: ( ( rule__Options__Group_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:913:1: ( ( rule__Options__Group_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:914:1: ( rule__Options__Group_2__0 )*
            {
             before(grammarAccess.getOptionsAccess().getGroup_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:915:1: ( rule__Options__Group_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=17 && LA12_0<=20)||LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:915:2: rule__Options__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Options__Group_2__0_in_rule__Options__Group__2__Impl1894);
            	    rule__Options__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:931:1: rule__Options__Group_2__0 : rule__Options__Group_2__0__Impl rule__Options__Group_2__1 ;
    public final void rule__Options__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:935:1: ( rule__Options__Group_2__0__Impl rule__Options__Group_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:936:2: rule__Options__Group_2__0__Impl rule__Options__Group_2__1
            {
            pushFollow(FOLLOW_rule__Options__Group_2__0__Impl_in_rule__Options__Group_2__01931);
            rule__Options__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Options__Group_2__1_in_rule__Options__Group_2__01934);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:943:1: rule__Options__Group_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__Options__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:947:1: ( ( ( ',' )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:948:1: ( ( ',' )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:948:1: ( ( ',' )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:949:1: ( ',' )?
            {
             before(grammarAccess.getOptionsAccess().getCommaKeyword_2_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:950:1: ( ',' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:951:2: ','
                    {
                    match(input,23,FOLLOW_23_in_rule__Options__Group_2__0__Impl1963); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:962:1: rule__Options__Group_2__1 : rule__Options__Group_2__1__Impl ;
    public final void rule__Options__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:966:1: ( rule__Options__Group_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:967:2: rule__Options__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Options__Group_2__1__Impl_in_rule__Options__Group_2__11996);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:973:1: rule__Options__Group_2__1__Impl : ( ( rule__Options__OptionsAssignment_2_1 ) ) ;
    public final void rule__Options__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:977:1: ( ( ( rule__Options__OptionsAssignment_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:978:1: ( ( rule__Options__OptionsAssignment_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:978:1: ( ( rule__Options__OptionsAssignment_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:979:1: ( rule__Options__OptionsAssignment_2_1 )
            {
             before(grammarAccess.getOptionsAccess().getOptionsAssignment_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:980:1: ( rule__Options__OptionsAssignment_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:980:2: rule__Options__OptionsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Options__OptionsAssignment_2_1_in_rule__Options__Group_2__1__Impl2023);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:994:1: rule__Environment__Group__0 : rule__Environment__Group__0__Impl rule__Environment__Group__1 ;
    public final void rule__Environment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:998:1: ( rule__Environment__Group__0__Impl rule__Environment__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:999:2: rule__Environment__Group__0__Impl rule__Environment__Group__1
            {
            pushFollow(FOLLOW_rule__Environment__Group__0__Impl_in_rule__Environment__Group__02057);
            rule__Environment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__1_in_rule__Environment__Group__02060);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1006:1: rule__Environment__Group__0__Impl : ( () ) ;
    public final void rule__Environment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1010:1: ( ( () ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1011:1: ( () )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1011:1: ( () )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1012:1: ()
            {
             before(grammarAccess.getEnvironmentAccess().getEnvironmentAction_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1013:1: ()
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1015:1: 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1025:1: rule__Environment__Group__1 : rule__Environment__Group__1__Impl rule__Environment__Group__2 ;
    public final void rule__Environment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1029:1: ( rule__Environment__Group__1__Impl rule__Environment__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1030:2: rule__Environment__Group__1__Impl rule__Environment__Group__2
            {
            pushFollow(FOLLOW_rule__Environment__Group__1__Impl_in_rule__Environment__Group__12118);
            rule__Environment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__2_in_rule__Environment__Group__12121);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1037:1: rule__Environment__Group__1__Impl : ( 'environment' ) ;
    public final void rule__Environment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1041:1: ( ( 'environment' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1042:1: ( 'environment' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1042:1: ( 'environment' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1043:1: 'environment'
            {
             before(grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__Environment__Group__1__Impl2149); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1056:1: rule__Environment__Group__2 : rule__Environment__Group__2__Impl rule__Environment__Group__3 ;
    public final void rule__Environment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1060:1: ( rule__Environment__Group__2__Impl rule__Environment__Group__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1061:2: rule__Environment__Group__2__Impl rule__Environment__Group__3
            {
            pushFollow(FOLLOW_rule__Environment__Group__2__Impl_in_rule__Environment__Group__22180);
            rule__Environment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group__3_in_rule__Environment__Group__22183);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1068:1: rule__Environment__Group__2__Impl : ( ( rule__Environment__EnvAssignment_2 ) ) ;
    public final void rule__Environment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1072:1: ( ( ( rule__Environment__EnvAssignment_2 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1073:1: ( ( rule__Environment__EnvAssignment_2 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1073:1: ( ( rule__Environment__EnvAssignment_2 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1074:1: ( rule__Environment__EnvAssignment_2 )
            {
             before(grammarAccess.getEnvironmentAccess().getEnvAssignment_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1075:1: ( rule__Environment__EnvAssignment_2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1075:2: rule__Environment__EnvAssignment_2
            {
            pushFollow(FOLLOW_rule__Environment__EnvAssignment_2_in_rule__Environment__Group__2__Impl2210);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1085:1: rule__Environment__Group__3 : rule__Environment__Group__3__Impl ;
    public final void rule__Environment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1089:1: ( rule__Environment__Group__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1090:2: rule__Environment__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Environment__Group__3__Impl_in_rule__Environment__Group__32240);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1096:1: rule__Environment__Group__3__Impl : ( ( rule__Environment__Group_3__0 )* ) ;
    public final void rule__Environment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1100:1: ( ( ( rule__Environment__Group_3__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1101:1: ( ( rule__Environment__Group_3__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1101:1: ( ( rule__Environment__Group_3__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1102:1: ( rule__Environment__Group_3__0 )*
            {
             before(grammarAccess.getEnvironmentAccess().getGroup_3()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1103:1: ( rule__Environment__Group_3__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID||LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1103:2: rule__Environment__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Environment__Group_3__0_in_rule__Environment__Group__3__Impl2267);
            	    rule__Environment__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1121:1: rule__Environment__Group_3__0 : rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1 ;
    public final void rule__Environment__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1125:1: ( rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1126:2: rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1
            {
            pushFollow(FOLLOW_rule__Environment__Group_3__0__Impl_in_rule__Environment__Group_3__02306);
            rule__Environment__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Environment__Group_3__1_in_rule__Environment__Group_3__02309);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1133:1: rule__Environment__Group_3__0__Impl : ( ( ',' )? ) ;
    public final void rule__Environment__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1137:1: ( ( ( ',' )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1138:1: ( ( ',' )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1138:1: ( ( ',' )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1139:1: ( ',' )?
            {
             before(grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1140:1: ( ',' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1141:2: ','
                    {
                    match(input,23,FOLLOW_23_in_rule__Environment__Group_3__0__Impl2338); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1152:1: rule__Environment__Group_3__1 : rule__Environment__Group_3__1__Impl ;
    public final void rule__Environment__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1156:1: ( rule__Environment__Group_3__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1157:2: rule__Environment__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Environment__Group_3__1__Impl_in_rule__Environment__Group_3__12371);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1163:1: rule__Environment__Group_3__1__Impl : ( ( rule__Environment__EnvAssignment_3_1 ) ) ;
    public final void rule__Environment__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1167:1: ( ( ( rule__Environment__EnvAssignment_3_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1168:1: ( ( rule__Environment__EnvAssignment_3_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1168:1: ( ( rule__Environment__EnvAssignment_3_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1169:1: ( rule__Environment__EnvAssignment_3_1 )
            {
             before(grammarAccess.getEnvironmentAccess().getEnvAssignment_3_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1170:1: ( rule__Environment__EnvAssignment_3_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1170:2: rule__Environment__EnvAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Environment__EnvAssignment_3_1_in_rule__Environment__Group_3__1__Impl2398);
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


    // $ANTLR start "rule__VarDefinition__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1184:1: rule__VarDefinition__Group__0 : rule__VarDefinition__Group__0__Impl rule__VarDefinition__Group__1 ;
    public final void rule__VarDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1188:1: ( rule__VarDefinition__Group__0__Impl rule__VarDefinition__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1189:2: rule__VarDefinition__Group__0__Impl rule__VarDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__VarDefinition__Group__0__Impl_in_rule__VarDefinition__Group__02432);
            rule__VarDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VarDefinition__Group__1_in_rule__VarDefinition__Group__02435);
            rule__VarDefinition__Group__1();

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
    // $ANTLR end "rule__VarDefinition__Group__0"


    // $ANTLR start "rule__VarDefinition__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1196:1: rule__VarDefinition__Group__0__Impl : ( 'define' ) ;
    public final void rule__VarDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1200:1: ( ( 'define' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1201:1: ( 'define' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1201:1: ( 'define' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1202:1: 'define'
            {
             before(grammarAccess.getVarDefinitionAccess().getDefineKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__VarDefinition__Group__0__Impl2463); 
             after(grammarAccess.getVarDefinitionAccess().getDefineKeyword_0()); 

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
    // $ANTLR end "rule__VarDefinition__Group__0__Impl"


    // $ANTLR start "rule__VarDefinition__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1215:1: rule__VarDefinition__Group__1 : rule__VarDefinition__Group__1__Impl rule__VarDefinition__Group__2 ;
    public final void rule__VarDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1219:1: ( rule__VarDefinition__Group__1__Impl rule__VarDefinition__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1220:2: rule__VarDefinition__Group__1__Impl rule__VarDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__VarDefinition__Group__1__Impl_in_rule__VarDefinition__Group__12494);
            rule__VarDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VarDefinition__Group__2_in_rule__VarDefinition__Group__12497);
            rule__VarDefinition__Group__2();

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
    // $ANTLR end "rule__VarDefinition__Group__1"


    // $ANTLR start "rule__VarDefinition__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1227:1: rule__VarDefinition__Group__1__Impl : ( ( rule__VarDefinition__NameAssignment_1 ) ) ;
    public final void rule__VarDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1231:1: ( ( ( rule__VarDefinition__NameAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1232:1: ( ( rule__VarDefinition__NameAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1232:1: ( ( rule__VarDefinition__NameAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1233:1: ( rule__VarDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getVarDefinitionAccess().getNameAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1234:1: ( rule__VarDefinition__NameAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1234:2: rule__VarDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VarDefinition__NameAssignment_1_in_rule__VarDefinition__Group__1__Impl2524);
            rule__VarDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVarDefinitionAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__VarDefinition__Group__1__Impl"


    // $ANTLR start "rule__VarDefinition__Group__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1244:1: rule__VarDefinition__Group__2 : rule__VarDefinition__Group__2__Impl rule__VarDefinition__Group__3 ;
    public final void rule__VarDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1248:1: ( rule__VarDefinition__Group__2__Impl rule__VarDefinition__Group__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1249:2: rule__VarDefinition__Group__2__Impl rule__VarDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__VarDefinition__Group__2__Impl_in_rule__VarDefinition__Group__22554);
            rule__VarDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VarDefinition__Group__3_in_rule__VarDefinition__Group__22557);
            rule__VarDefinition__Group__3();

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
    // $ANTLR end "rule__VarDefinition__Group__2"


    // $ANTLR start "rule__VarDefinition__Group__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1256:1: rule__VarDefinition__Group__2__Impl : ( '=' ) ;
    public final void rule__VarDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1260:1: ( ( '=' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1261:1: ( '=' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1261:1: ( '=' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1262:1: '='
            {
             before(grammarAccess.getVarDefinitionAccess().getEqualsSignKeyword_2()); 
            match(input,26,FOLLOW_26_in_rule__VarDefinition__Group__2__Impl2585); 
             after(grammarAccess.getVarDefinitionAccess().getEqualsSignKeyword_2()); 

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
    // $ANTLR end "rule__VarDefinition__Group__2__Impl"


    // $ANTLR start "rule__VarDefinition__Group__3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1275:1: rule__VarDefinition__Group__3 : rule__VarDefinition__Group__3__Impl ;
    public final void rule__VarDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1279:1: ( rule__VarDefinition__Group__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1280:2: rule__VarDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VarDefinition__Group__3__Impl_in_rule__VarDefinition__Group__32616);
            rule__VarDefinition__Group__3__Impl();

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
    // $ANTLR end "rule__VarDefinition__Group__3"


    // $ANTLR start "rule__VarDefinition__Group__3__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1286:1: rule__VarDefinition__Group__3__Impl : ( ( rule__VarDefinition__ValueAssignment_3 ) ) ;
    public final void rule__VarDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1290:1: ( ( ( rule__VarDefinition__ValueAssignment_3 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1291:1: ( ( rule__VarDefinition__ValueAssignment_3 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1291:1: ( ( rule__VarDefinition__ValueAssignment_3 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1292:1: ( rule__VarDefinition__ValueAssignment_3 )
            {
             before(grammarAccess.getVarDefinitionAccess().getValueAssignment_3()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1293:1: ( rule__VarDefinition__ValueAssignment_3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1293:2: rule__VarDefinition__ValueAssignment_3
            {
            pushFollow(FOLLOW_rule__VarDefinition__ValueAssignment_3_in_rule__VarDefinition__Group__3__Impl2643);
            rule__VarDefinition__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getVarDefinitionAccess().getValueAssignment_3()); 

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
    // $ANTLR end "rule__VarDefinition__Group__3__Impl"


    // $ANTLR start "rule__CompositeString__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1311:1: rule__CompositeString__Group__0 : rule__CompositeString__Group__0__Impl rule__CompositeString__Group__1 ;
    public final void rule__CompositeString__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1315:1: ( rule__CompositeString__Group__0__Impl rule__CompositeString__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1316:2: rule__CompositeString__Group__0__Impl rule__CompositeString__Group__1
            {
            pushFollow(FOLLOW_rule__CompositeString__Group__0__Impl_in_rule__CompositeString__Group__02681);
            rule__CompositeString__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompositeString__Group__1_in_rule__CompositeString__Group__02684);
            rule__CompositeString__Group__1();

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
    // $ANTLR end "rule__CompositeString__Group__0"


    // $ANTLR start "rule__CompositeString__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1323:1: rule__CompositeString__Group__0__Impl : ( () ) ;
    public final void rule__CompositeString__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1327:1: ( ( () ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1328:1: ( () )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1328:1: ( () )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1329:1: ()
            {
             before(grammarAccess.getCompositeStringAccess().getCompositeStringAction_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1330:1: ()
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1332:1: 
            {
            }

             after(grammarAccess.getCompositeStringAccess().getCompositeStringAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeString__Group__0__Impl"


    // $ANTLR start "rule__CompositeString__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1342:1: rule__CompositeString__Group__1 : rule__CompositeString__Group__1__Impl rule__CompositeString__Group__2 ;
    public final void rule__CompositeString__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1346:1: ( rule__CompositeString__Group__1__Impl rule__CompositeString__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1347:2: rule__CompositeString__Group__1__Impl rule__CompositeString__Group__2
            {
            pushFollow(FOLLOW_rule__CompositeString__Group__1__Impl_in_rule__CompositeString__Group__12742);
            rule__CompositeString__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompositeString__Group__2_in_rule__CompositeString__Group__12745);
            rule__CompositeString__Group__2();

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
    // $ANTLR end "rule__CompositeString__Group__1"


    // $ANTLR start "rule__CompositeString__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1354:1: rule__CompositeString__Group__1__Impl : ( ( rule__CompositeString__StringPartsAssignment_1 ) ) ;
    public final void rule__CompositeString__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1358:1: ( ( ( rule__CompositeString__StringPartsAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1359:1: ( ( rule__CompositeString__StringPartsAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1359:1: ( ( rule__CompositeString__StringPartsAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1360:1: ( rule__CompositeString__StringPartsAssignment_1 )
            {
             before(grammarAccess.getCompositeStringAccess().getStringPartsAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1361:1: ( rule__CompositeString__StringPartsAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1361:2: rule__CompositeString__StringPartsAssignment_1
            {
            pushFollow(FOLLOW_rule__CompositeString__StringPartsAssignment_1_in_rule__CompositeString__Group__1__Impl2772);
            rule__CompositeString__StringPartsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCompositeStringAccess().getStringPartsAssignment_1()); 

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
    // $ANTLR end "rule__CompositeString__Group__1__Impl"


    // $ANTLR start "rule__CompositeString__Group__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1371:1: rule__CompositeString__Group__2 : rule__CompositeString__Group__2__Impl ;
    public final void rule__CompositeString__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1375:1: ( rule__CompositeString__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1376:2: rule__CompositeString__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CompositeString__Group__2__Impl_in_rule__CompositeString__Group__22802);
            rule__CompositeString__Group__2__Impl();

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
    // $ANTLR end "rule__CompositeString__Group__2"


    // $ANTLR start "rule__CompositeString__Group__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1382:1: rule__CompositeString__Group__2__Impl : ( ( rule__CompositeString__Group_2__0 )* ) ;
    public final void rule__CompositeString__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1386:1: ( ( ( rule__CompositeString__Group_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1387:1: ( ( rule__CompositeString__Group_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1387:1: ( ( rule__CompositeString__Group_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1388:1: ( rule__CompositeString__Group_2__0 )*
            {
             before(grammarAccess.getCompositeStringAccess().getGroup_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1389:1: ( rule__CompositeString__Group_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==27) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1389:2: rule__CompositeString__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CompositeString__Group_2__0_in_rule__CompositeString__Group__2__Impl2829);
            	    rule__CompositeString__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getCompositeStringAccess().getGroup_2()); 

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
    // $ANTLR end "rule__CompositeString__Group__2__Impl"


    // $ANTLR start "rule__CompositeString__Group_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1405:1: rule__CompositeString__Group_2__0 : rule__CompositeString__Group_2__0__Impl rule__CompositeString__Group_2__1 ;
    public final void rule__CompositeString__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1409:1: ( rule__CompositeString__Group_2__0__Impl rule__CompositeString__Group_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1410:2: rule__CompositeString__Group_2__0__Impl rule__CompositeString__Group_2__1
            {
            pushFollow(FOLLOW_rule__CompositeString__Group_2__0__Impl_in_rule__CompositeString__Group_2__02866);
            rule__CompositeString__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompositeString__Group_2__1_in_rule__CompositeString__Group_2__02869);
            rule__CompositeString__Group_2__1();

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
    // $ANTLR end "rule__CompositeString__Group_2__0"


    // $ANTLR start "rule__CompositeString__Group_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1417:1: rule__CompositeString__Group_2__0__Impl : ( '+' ) ;
    public final void rule__CompositeString__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1421:1: ( ( '+' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1422:1: ( '+' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1422:1: ( '+' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1423:1: '+'
            {
             before(grammarAccess.getCompositeStringAccess().getPlusSignKeyword_2_0()); 
            match(input,27,FOLLOW_27_in_rule__CompositeString__Group_2__0__Impl2897); 
             after(grammarAccess.getCompositeStringAccess().getPlusSignKeyword_2_0()); 

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
    // $ANTLR end "rule__CompositeString__Group_2__0__Impl"


    // $ANTLR start "rule__CompositeString__Group_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1436:1: rule__CompositeString__Group_2__1 : rule__CompositeString__Group_2__1__Impl ;
    public final void rule__CompositeString__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1440:1: ( rule__CompositeString__Group_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1441:2: rule__CompositeString__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CompositeString__Group_2__1__Impl_in_rule__CompositeString__Group_2__12928);
            rule__CompositeString__Group_2__1__Impl();

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
    // $ANTLR end "rule__CompositeString__Group_2__1"


    // $ANTLR start "rule__CompositeString__Group_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1447:1: rule__CompositeString__Group_2__1__Impl : ( ( rule__CompositeString__StringPartsAssignment_2_1 ) ) ;
    public final void rule__CompositeString__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1451:1: ( ( ( rule__CompositeString__StringPartsAssignment_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1452:1: ( ( rule__CompositeString__StringPartsAssignment_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1452:1: ( ( rule__CompositeString__StringPartsAssignment_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1453:1: ( rule__CompositeString__StringPartsAssignment_2_1 )
            {
             before(grammarAccess.getCompositeStringAccess().getStringPartsAssignment_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1454:1: ( rule__CompositeString__StringPartsAssignment_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1454:2: rule__CompositeString__StringPartsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__CompositeString__StringPartsAssignment_2_1_in_rule__CompositeString__Group_2__1__Impl2955);
            rule__CompositeString__StringPartsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCompositeStringAccess().getStringPartsAssignment_2_1()); 

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
    // $ANTLR end "rule__CompositeString__Group_2__1__Impl"


    // $ANTLR start "rule__VarCall__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1468:1: rule__VarCall__Group__0 : rule__VarCall__Group__0__Impl rule__VarCall__Group__1 ;
    public final void rule__VarCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1472:1: ( rule__VarCall__Group__0__Impl rule__VarCall__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1473:2: rule__VarCall__Group__0__Impl rule__VarCall__Group__1
            {
            pushFollow(FOLLOW_rule__VarCall__Group__0__Impl_in_rule__VarCall__Group__02989);
            rule__VarCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VarCall__Group__1_in_rule__VarCall__Group__02992);
            rule__VarCall__Group__1();

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
    // $ANTLR end "rule__VarCall__Group__0"


    // $ANTLR start "rule__VarCall__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1480:1: rule__VarCall__Group__0__Impl : ( '${' ) ;
    public final void rule__VarCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1484:1: ( ( '${' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1485:1: ( '${' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1485:1: ( '${' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1486:1: '${'
            {
             before(grammarAccess.getVarCallAccess().getDollarSignLeftCurlyBracketKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__VarCall__Group__0__Impl3020); 
             after(grammarAccess.getVarCallAccess().getDollarSignLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end "rule__VarCall__Group__0__Impl"


    // $ANTLR start "rule__VarCall__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1499:1: rule__VarCall__Group__1 : rule__VarCall__Group__1__Impl rule__VarCall__Group__2 ;
    public final void rule__VarCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1503:1: ( rule__VarCall__Group__1__Impl rule__VarCall__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1504:2: rule__VarCall__Group__1__Impl rule__VarCall__Group__2
            {
            pushFollow(FOLLOW_rule__VarCall__Group__1__Impl_in_rule__VarCall__Group__13051);
            rule__VarCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VarCall__Group__2_in_rule__VarCall__Group__13054);
            rule__VarCall__Group__2();

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
    // $ANTLR end "rule__VarCall__Group__1"


    // $ANTLR start "rule__VarCall__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1511:1: rule__VarCall__Group__1__Impl : ( ( rule__VarCall__VarNameAssignment_1 ) ) ;
    public final void rule__VarCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1515:1: ( ( ( rule__VarCall__VarNameAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1516:1: ( ( rule__VarCall__VarNameAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1516:1: ( ( rule__VarCall__VarNameAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1517:1: ( rule__VarCall__VarNameAssignment_1 )
            {
             before(grammarAccess.getVarCallAccess().getVarNameAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1518:1: ( rule__VarCall__VarNameAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1518:2: rule__VarCall__VarNameAssignment_1
            {
            pushFollow(FOLLOW_rule__VarCall__VarNameAssignment_1_in_rule__VarCall__Group__1__Impl3081);
            rule__VarCall__VarNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVarCallAccess().getVarNameAssignment_1()); 

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
    // $ANTLR end "rule__VarCall__Group__1__Impl"


    // $ANTLR start "rule__VarCall__Group__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1528:1: rule__VarCall__Group__2 : rule__VarCall__Group__2__Impl ;
    public final void rule__VarCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1532:1: ( rule__VarCall__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1533:2: rule__VarCall__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VarCall__Group__2__Impl_in_rule__VarCall__Group__23111);
            rule__VarCall__Group__2__Impl();

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
    // $ANTLR end "rule__VarCall__Group__2"


    // $ANTLR start "rule__VarCall__Group__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1539:1: rule__VarCall__Group__2__Impl : ( '}' ) ;
    public final void rule__VarCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1543:1: ( ( '}' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1544:1: ( '}' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1544:1: ( '}' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1545:1: '}'
            {
             before(grammarAccess.getVarCallAccess().getRightCurlyBracketKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__VarCall__Group__2__Impl3139); 
             after(grammarAccess.getVarCallAccess().getRightCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__VarCall__Group__2__Impl"


    // $ANTLR start "rule__IncludeDeclaration__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1564:1: rule__IncludeDeclaration__Group__0 : rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1 ;
    public final void rule__IncludeDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1568:1: ( rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1569:2: rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__0__Impl_in_rule__IncludeDeclaration__Group__03176);
            rule__IncludeDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__1_in_rule__IncludeDeclaration__Group__03179);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1576:1: rule__IncludeDeclaration__Group__0__Impl : ( 'include' ) ;
    public final void rule__IncludeDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1580:1: ( ( 'include' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1581:1: ( 'include' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1581:1: ( 'include' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1582:1: 'include'
            {
             before(grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__IncludeDeclaration__Group__0__Impl3207); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1595:1: rule__IncludeDeclaration__Group__1 : rule__IncludeDeclaration__Group__1__Impl ;
    public final void rule__IncludeDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1599:1: ( rule__IncludeDeclaration__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1600:2: rule__IncludeDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__Group__1__Impl_in_rule__IncludeDeclaration__Group__13238);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1606:1: rule__IncludeDeclaration__Group__1__Impl : ( ( rule__IncludeDeclaration__CompositeImportURIAssignment_1 ) ) ;
    public final void rule__IncludeDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1610:1: ( ( ( rule__IncludeDeclaration__CompositeImportURIAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1611:1: ( ( rule__IncludeDeclaration__CompositeImportURIAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1611:1: ( ( rule__IncludeDeclaration__CompositeImportURIAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1612:1: ( rule__IncludeDeclaration__CompositeImportURIAssignment_1 )
            {
             before(grammarAccess.getIncludeDeclarationAccess().getCompositeImportURIAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1613:1: ( rule__IncludeDeclaration__CompositeImportURIAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1613:2: rule__IncludeDeclaration__CompositeImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__IncludeDeclaration__CompositeImportURIAssignment_1_in_rule__IncludeDeclaration__Group__1__Impl3265);
            rule__IncludeDeclaration__CompositeImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIncludeDeclarationAccess().getCompositeImportURIAssignment_1()); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1627:1: rule__Location__Group__0 : rule__Location__Group__0__Impl rule__Location__Group__1 ;
    public final void rule__Location__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1631:1: ( rule__Location__Group__0__Impl rule__Location__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1632:2: rule__Location__Group__0__Impl rule__Location__Group__1
            {
            pushFollow(FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__03299);
            rule__Location__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__1_in_rule__Location__Group__03302);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1639:1: rule__Location__Group__0__Impl : ( 'location' ) ;
    public final void rule__Location__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1643:1: ( ( 'location' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1644:1: ( 'location' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1644:1: ( 'location' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1645:1: 'location'
            {
             before(grammarAccess.getLocationAccess().getLocationKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__Location__Group__0__Impl3330); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1658:1: rule__Location__Group__1 : rule__Location__Group__1__Impl rule__Location__Group__2 ;
    public final void rule__Location__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1662:1: ( rule__Location__Group__1__Impl rule__Location__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1663:2: rule__Location__Group__1__Impl rule__Location__Group__2
            {
            pushFollow(FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__13361);
            rule__Location__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__2_in_rule__Location__Group__13364);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1670:1: rule__Location__Group__1__Impl : ( ( rule__Location__UnorderedGroup_1 ) ) ;
    public final void rule__Location__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1674:1: ( ( ( rule__Location__UnorderedGroup_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1675:1: ( ( rule__Location__UnorderedGroup_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1675:1: ( ( rule__Location__UnorderedGroup_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1676:1: ( rule__Location__UnorderedGroup_1 )
            {
             before(grammarAccess.getLocationAccess().getUnorderedGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1677:1: ( rule__Location__UnorderedGroup_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1677:2: rule__Location__UnorderedGroup_1
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1_in_rule__Location__Group__1__Impl3391);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1687:1: rule__Location__Group__2 : rule__Location__Group__2__Impl ;
    public final void rule__Location__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1691:1: ( rule__Location__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1692:2: rule__Location__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__23421);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1698:1: rule__Location__Group__2__Impl : ( ( rule__Location__Group_2__0 )? ) ;
    public final void rule__Location__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1702:1: ( ( ( rule__Location__Group_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1703:1: ( ( rule__Location__Group_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1703:1: ( ( rule__Location__Group_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1704:1: ( rule__Location__Group_2__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1705:1: ( rule__Location__Group_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1705:2: rule__Location__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl3448);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1721:1: rule__Location__Group_2__0 : rule__Location__Group_2__0__Impl rule__Location__Group_2__1 ;
    public final void rule__Location__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1725:1: ( rule__Location__Group_2__0__Impl rule__Location__Group_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1726:2: rule__Location__Group_2__0__Impl rule__Location__Group_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__03485);
            rule__Location__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__03488);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1733:1: rule__Location__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Location__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1737:1: ( ( '{' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1738:1: ( '{' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1738:1: ( '{' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1739:1: '{'
            {
             before(grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,32,FOLLOW_32_in_rule__Location__Group_2__0__Impl3516); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1752:1: rule__Location__Group_2__1 : rule__Location__Group_2__1__Impl rule__Location__Group_2__2 ;
    public final void rule__Location__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1756:1: ( rule__Location__Group_2__1__Impl rule__Location__Group_2__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1757:2: rule__Location__Group_2__1__Impl rule__Location__Group_2__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__13547);
            rule__Location__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__13550);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1764:1: rule__Location__Group_2__1__Impl : ( ( rule__Location__Group_2_1__0 )? ) ;
    public final void rule__Location__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1768:1: ( ( ( rule__Location__Group_2_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1769:1: ( ( rule__Location__Group_2_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1769:1: ( ( rule__Location__Group_2_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1770:1: ( rule__Location__Group_2_1__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1771:1: ( rule__Location__Group_2_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==22) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1771:2: rule__Location__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl3577);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1781:1: rule__Location__Group_2__2 : rule__Location__Group_2__2__Impl rule__Location__Group_2__3 ;
    public final void rule__Location__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1785:1: ( rule__Location__Group_2__2__Impl rule__Location__Group_2__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1786:2: rule__Location__Group_2__2__Impl rule__Location__Group_2__3
            {
            pushFollow(FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__23608);
            rule__Location__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__23611);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1793:1: rule__Location__Group_2__2__Impl : ( ( rule__Location__IusAssignment_2_2 )* ) ;
    public final void rule__Location__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1797:1: ( ( ( rule__Location__IusAssignment_2_2 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1798:1: ( ( rule__Location__IusAssignment_2_2 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1798:1: ( ( rule__Location__IusAssignment_2_2 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1799:1: ( rule__Location__IusAssignment_2_2 )*
            {
             before(grammarAccess.getLocationAccess().getIusAssignment_2_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1800:1: ( rule__Location__IusAssignment_2_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1800:2: rule__Location__IusAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_rule__Location__IusAssignment_2_2_in_rule__Location__Group_2__2__Impl3638);
            	    rule__Location__IusAssignment_2_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1810:1: rule__Location__Group_2__3 : rule__Location__Group_2__3__Impl ;
    public final void rule__Location__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1814:1: ( rule__Location__Group_2__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1815:2: rule__Location__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__33669);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1821:1: rule__Location__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Location__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1825:1: ( ( '}' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1826:1: ( '}' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1826:1: ( '}' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1827:1: '}'
            {
             before(grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,29,FOLLOW_29_in_rule__Location__Group_2__3__Impl3697); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1848:1: rule__Location__Group_2_1__0 : rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 ;
    public final void rule__Location__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1852:1: ( rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1853:2: rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__03736);
            rule__Location__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__03739);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1860:1: rule__Location__Group_2_1__0__Impl : ( 'with' ) ;
    public final void rule__Location__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1864:1: ( ( 'with' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1865:1: ( 'with' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1865:1: ( 'with' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1866:1: 'with'
            {
             before(grammarAccess.getLocationAccess().getWithKeyword_2_1_0()); 
            match(input,22,FOLLOW_22_in_rule__Location__Group_2_1__0__Impl3767); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1879:1: rule__Location__Group_2_1__1 : rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 ;
    public final void rule__Location__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1883:1: ( rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1884:2: rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__13798);
            rule__Location__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__13801);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1891:1: rule__Location__Group_2_1__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_1 ) ) ;
    public final void rule__Location__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1895:1: ( ( ( rule__Location__OptionsAssignment_2_1_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1896:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1896:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1897:1: ( rule__Location__OptionsAssignment_2_1_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1898:1: ( rule__Location__OptionsAssignment_2_1_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1898:2: rule__Location__OptionsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl3828);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1908:1: rule__Location__Group_2_1__2 : rule__Location__Group_2_1__2__Impl ;
    public final void rule__Location__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1912:1: ( rule__Location__Group_2_1__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1913:2: rule__Location__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__23858);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1919:1: rule__Location__Group_2_1__2__Impl : ( ( rule__Location__Group_2_1_2__0 )* ) ;
    public final void rule__Location__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1923:1: ( ( ( rule__Location__Group_2_1_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1924:1: ( ( rule__Location__Group_2_1_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1924:1: ( ( rule__Location__Group_2_1_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1925:1: ( rule__Location__Group_2_1_2__0 )*
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1926:1: ( rule__Location__Group_2_1_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=17 && LA20_0<=20)||LA20_0==23) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1926:2: rule__Location__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl3885);
            	    rule__Location__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1942:1: rule__Location__Group_2_1_2__0 : rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 ;
    public final void rule__Location__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1946:1: ( rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1947:2: rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__03922);
            rule__Location__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__03925);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1954:1: rule__Location__Group_2_1_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__Location__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1958:1: ( ( ( ',' )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1959:1: ( ( ',' )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1959:1: ( ( ',' )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1960:1: ( ',' )?
            {
             before(grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1961:1: ( ',' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1962:2: ','
                    {
                    match(input,23,FOLLOW_23_in_rule__Location__Group_2_1_2__0__Impl3954); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1973:1: rule__Location__Group_2_1_2__1 : rule__Location__Group_2_1_2__1__Impl ;
    public final void rule__Location__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1977:1: ( rule__Location__Group_2_1_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1978:2: rule__Location__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__13987);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1984:1: rule__Location__Group_2_1_2__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) ;
    public final void rule__Location__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1988:1: ( ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1989:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1989:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1990:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1991:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1991:2: rule__Location__OptionsAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl4014);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2005:1: rule__IU__Group__0 : rule__IU__Group__0__Impl rule__IU__Group__1 ;
    public final void rule__IU__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2009:1: ( rule__IU__Group__0__Impl rule__IU__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2010:2: rule__IU__Group__0__Impl rule__IU__Group__1
            {
            pushFollow(FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__04048);
            rule__IU__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group__1_in_rule__IU__Group__04051);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2017:1: rule__IU__Group__0__Impl : ( ( rule__IU__IDAssignment_0 ) ) ;
    public final void rule__IU__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2021:1: ( ( ( rule__IU__IDAssignment_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2022:1: ( ( rule__IU__IDAssignment_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2022:1: ( ( rule__IU__IDAssignment_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2023:1: ( rule__IU__IDAssignment_0 )
            {
             before(grammarAccess.getIUAccess().getIDAssignment_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2024:1: ( rule__IU__IDAssignment_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2024:2: rule__IU__IDAssignment_0
            {
            pushFollow(FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl4078);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2034:1: rule__IU__Group__1 : rule__IU__Group__1__Impl ;
    public final void rule__IU__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2038:1: ( rule__IU__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2039:2: rule__IU__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__14108);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2045:1: rule__IU__Group__1__Impl : ( ( rule__IU__Group_1__0 )? ) ;
    public final void rule__IU__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2049:1: ( ( ( rule__IU__Group_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2050:1: ( ( rule__IU__Group_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2050:1: ( ( rule__IU__Group_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2051:1: ( rule__IU__Group_1__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2052:1: ( rule__IU__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_INT||LA22_0==RULE_STRING||(LA22_0>=12 && LA22_0<=14)||LA22_0==28||LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2052:2: rule__IU__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl4135);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2066:1: rule__IU__Group_1__0 : rule__IU__Group_1__0__Impl rule__IU__Group_1__1 ;
    public final void rule__IU__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2070:1: ( rule__IU__Group_1__0__Impl rule__IU__Group_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2071:2: rule__IU__Group_1__0__Impl rule__IU__Group_1__1
            {
            pushFollow(FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__04170);
            rule__IU__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__04173);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2078:1: rule__IU__Group_1__0__Impl : ( ( rule__IU__Group_1_0__0 )? ) ;
    public final void rule__IU__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2082:1: ( ( ( rule__IU__Group_1_0__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2083:1: ( ( rule__IU__Group_1_0__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2083:1: ( ( rule__IU__Group_1_0__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2084:1: ( rule__IU__Group_1_0__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2085:1: ( rule__IU__Group_1_0__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2085:2: rule__IU__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__IU__Group_1_0__0_in_rule__IU__Group_1__0__Impl4200);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2095:1: rule__IU__Group_1__1 : rule__IU__Group_1__1__Impl ;
    public final void rule__IU__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2099:1: ( rule__IU__Group_1__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2100:2: rule__IU__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__14231);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2106:1: rule__IU__Group_1__1__Impl : ( ( rule__IU__Alternatives_1_1 ) ) ;
    public final void rule__IU__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2110:1: ( ( ( rule__IU__Alternatives_1_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2111:1: ( ( rule__IU__Alternatives_1_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2111:1: ( ( rule__IU__Alternatives_1_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2112:1: ( rule__IU__Alternatives_1_1 )
            {
             before(grammarAccess.getIUAccess().getAlternatives_1_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2113:1: ( rule__IU__Alternatives_1_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2113:2: rule__IU__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__IU__Alternatives_1_1_in_rule__IU__Group_1__1__Impl4258);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2127:1: rule__IU__Group_1_0__0 : rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1 ;
    public final void rule__IU__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2131:1: ( rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2132:2: rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__0__Impl_in_rule__IU__Group_1_0__04292);
            rule__IU__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1_0__1_in_rule__IU__Group_1_0__04295);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2139:1: rule__IU__Group_1_0__0__Impl : ( ';' ) ;
    public final void rule__IU__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2143:1: ( ( ';' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2144:1: ( ';' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2144:1: ( ';' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2145:1: ';'
            {
             before(grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0()); 
            match(input,33,FOLLOW_33_in_rule__IU__Group_1_0__0__Impl4323); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2158:1: rule__IU__Group_1_0__1 : rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2 ;
    public final void rule__IU__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2162:1: ( rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2163:2: rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__1__Impl_in_rule__IU__Group_1_0__14354);
            rule__IU__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1_0__2_in_rule__IU__Group_1_0__14357);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2170:1: rule__IU__Group_1_0__1__Impl : ( 'version' ) ;
    public final void rule__IU__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2174:1: ( ( 'version' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2175:1: ( 'version' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2175:1: ( 'version' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2176:1: 'version'
            {
             before(grammarAccess.getIUAccess().getVersionKeyword_1_0_1()); 
            match(input,34,FOLLOW_34_in_rule__IU__Group_1_0__1__Impl4385); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2189:1: rule__IU__Group_1_0__2 : rule__IU__Group_1_0__2__Impl ;
    public final void rule__IU__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2193:1: ( rule__IU__Group_1_0__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2194:2: rule__IU__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group_1_0__2__Impl_in_rule__IU__Group_1_0__24416);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2200:1: rule__IU__Group_1_0__2__Impl : ( '=' ) ;
    public final void rule__IU__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2204:1: ( ( '=' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2205:1: ( '=' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2205:1: ( '=' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2206:1: '='
            {
             before(grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2()); 
            match(input,26,FOLLOW_26_in_rule__IU__Group_1_0__2__Impl4444); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2225:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2229:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2230:2: rule__Version__Group__0__Impl rule__Version__Group__1
            {
            pushFollow(FOLLOW_rule__Version__Group__0__Impl_in_rule__Version__Group__04481);
            rule__Version__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group__1_in_rule__Version__Group__04484);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2237:1: rule__Version__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2241:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2242:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2242:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2243:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group__0__Impl4511); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2254:1: rule__Version__Group__1 : rule__Version__Group__1__Impl ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2258:1: ( rule__Version__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2259:2: rule__Version__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group__1__Impl_in_rule__Version__Group__14540);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2265:1: rule__Version__Group__1__Impl : ( ( rule__Version__Group_1__0 )? ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2269:1: ( ( ( rule__Version__Group_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2270:1: ( ( rule__Version__Group_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2270:1: ( ( rule__Version__Group_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2271:1: ( rule__Version__Group_1__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2272:1: ( rule__Version__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2272:2: rule__Version__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1__0_in_rule__Version__Group__1__Impl4567);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2286:1: rule__Version__Group_1__0 : rule__Version__Group_1__0__Impl rule__Version__Group_1__1 ;
    public final void rule__Version__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2290:1: ( rule__Version__Group_1__0__Impl rule__Version__Group_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2291:2: rule__Version__Group_1__0__Impl rule__Version__Group_1__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1__0__Impl_in_rule__Version__Group_1__04602);
            rule__Version__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1__1_in_rule__Version__Group_1__04605);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2298:1: rule__Version__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2302:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2303:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2303:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2304:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
            match(input,35,FOLLOW_35_in_rule__Version__Group_1__0__Impl4633); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2317:1: rule__Version__Group_1__1 : rule__Version__Group_1__1__Impl rule__Version__Group_1__2 ;
    public final void rule__Version__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2321:1: ( rule__Version__Group_1__1__Impl rule__Version__Group_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2322:2: rule__Version__Group_1__1__Impl rule__Version__Group_1__2
            {
            pushFollow(FOLLOW_rule__Version__Group_1__1__Impl_in_rule__Version__Group_1__14664);
            rule__Version__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1__2_in_rule__Version__Group_1__14667);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2329:1: rule__Version__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2333:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2334:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2334:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2335:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_1__1__Impl4694); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2346:1: rule__Version__Group_1__2 : rule__Version__Group_1__2__Impl ;
    public final void rule__Version__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2350:1: ( rule__Version__Group_1__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2351:2: rule__Version__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1__2__Impl_in_rule__Version__Group_1__24723);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2357:1: rule__Version__Group_1__2__Impl : ( ( rule__Version__Group_1_2__0 )? ) ;
    public final void rule__Version__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2361:1: ( ( ( rule__Version__Group_1_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2362:1: ( ( rule__Version__Group_1_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2362:1: ( ( rule__Version__Group_1_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2363:1: ( rule__Version__Group_1_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2364:1: ( rule__Version__Group_1_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2364:2: rule__Version__Group_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1_2__0_in_rule__Version__Group_1__2__Impl4750);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2380:1: rule__Version__Group_1_2__0 : rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1 ;
    public final void rule__Version__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2384:1: ( rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2385:2: rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__0__Impl_in_rule__Version__Group_1_2__04787);
            rule__Version__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2__1_in_rule__Version__Group_1_2__04790);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2392:1: rule__Version__Group_1_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2396:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2397:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2397:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2398:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
            match(input,35,FOLLOW_35_in_rule__Version__Group_1_2__0__Impl4818); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2411:1: rule__Version__Group_1_2__1 : rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2 ;
    public final void rule__Version__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2415:1: ( rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2416:2: rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__1__Impl_in_rule__Version__Group_1_2__14849);
            rule__Version__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2__2_in_rule__Version__Group_1_2__14852);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2423:1: rule__Version__Group_1_2__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2427:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2428:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2428:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2429:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_1_2__1__Impl4879); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2440:1: rule__Version__Group_1_2__2 : rule__Version__Group_1_2__2__Impl ;
    public final void rule__Version__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2444:1: ( rule__Version__Group_1_2__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2445:2: rule__Version__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2__2__Impl_in_rule__Version__Group_1_2__24908);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2451:1: rule__Version__Group_1_2__2__Impl : ( ( rule__Version__Group_1_2_2__0 )? ) ;
    public final void rule__Version__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2455:1: ( ( ( rule__Version__Group_1_2_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2456:1: ( ( rule__Version__Group_1_2_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2456:1: ( ( rule__Version__Group_1_2_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2457:1: ( rule__Version__Group_1_2_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1_2_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2458:1: ( rule__Version__Group_1_2_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==35) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2458:2: rule__Version__Group_1_2_2__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_1_2_2__0_in_rule__Version__Group_1_2__2__Impl4935);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2474:1: rule__Version__Group_1_2_2__0 : rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1 ;
    public final void rule__Version__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2478:1: ( rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2479:2: rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2_2__0__Impl_in_rule__Version__Group_1_2_2__04972);
            rule__Version__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_1_2_2__1_in_rule__Version__Group_1_2_2__04975);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2486:1: rule__Version__Group_1_2_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2490:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2491:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2491:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2492:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
            match(input,35,FOLLOW_35_in_rule__Version__Group_1_2_2__0__Impl5003); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2505:1: rule__Version__Group_1_2_2__1 : rule__Version__Group_1_2_2__1__Impl ;
    public final void rule__Version__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2509:1: ( rule__Version__Group_1_2_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2510:2: rule__Version__Group_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_1_2_2__1__Impl_in_rule__Version__Group_1_2_2__15034);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2516:1: rule__Version__Group_1_2_2__1__Impl : ( ( rule__Version__Alternatives_1_2_2_1 ) ) ;
    public final void rule__Version__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2520:1: ( ( ( rule__Version__Alternatives_1_2_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2521:1: ( ( rule__Version__Alternatives_1_2_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2521:1: ( ( rule__Version__Alternatives_1_2_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2522:1: ( rule__Version__Alternatives_1_2_2_1 )
            {
             before(grammarAccess.getVersionAccess().getAlternatives_1_2_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2523:1: ( rule__Version__Alternatives_1_2_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2523:2: rule__Version__Alternatives_1_2_2_1
            {
            pushFollow(FOLLOW_rule__Version__Alternatives_1_2_2_1_in_rule__Version__Group_1_2_2__1__Impl5061);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2537:1: rule__VersionRange__Group_0__0 : rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 ;
    public final void rule__VersionRange__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2541:1: ( rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2542:2: rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__0__Impl_in_rule__VersionRange__Group_0__05095);
            rule__VersionRange__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__1_in_rule__VersionRange__Group_0__05098);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2549:1: rule__VersionRange__Group_0__0__Impl : ( ( rule__VersionRange__Alternatives_0_0 ) ) ;
    public final void rule__VersionRange__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2553:1: ( ( ( rule__VersionRange__Alternatives_0_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2554:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2554:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2555:1: ( rule__VersionRange__Alternatives_0_0 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2556:1: ( rule__VersionRange__Alternatives_0_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2556:2: rule__VersionRange__Alternatives_0_0
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_0_0_in_rule__VersionRange__Group_0__0__Impl5125);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2566:1: rule__VersionRange__Group_0__1 : rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 ;
    public final void rule__VersionRange__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2570:1: ( rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2571:2: rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__1__Impl_in_rule__VersionRange__Group_0__15155);
            rule__VersionRange__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__2_in_rule__VersionRange__Group_0__15158);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2578:1: rule__VersionRange__Group_0__1__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2582:1: ( ( ruleVersion ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2583:1: ( ruleVersion )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2583:1: ( ruleVersion )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2584:1: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__1__Impl5185);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2595:1: rule__VersionRange__Group_0__2 : rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 ;
    public final void rule__VersionRange__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2599:1: ( rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2600:2: rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__2__Impl_in_rule__VersionRange__Group_0__25214);
            rule__VersionRange__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__3_in_rule__VersionRange__Group_0__25217);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2607:1: rule__VersionRange__Group_0__2__Impl : ( ',' ) ;
    public final void rule__VersionRange__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2611:1: ( ( ',' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2612:1: ( ',' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2612:1: ( ',' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2613:1: ','
            {
             before(grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
            match(input,23,FOLLOW_23_in_rule__VersionRange__Group_0__2__Impl5245); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2626:1: rule__VersionRange__Group_0__3 : rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 ;
    public final void rule__VersionRange__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2630:1: ( rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2631:2: rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__3__Impl_in_rule__VersionRange__Group_0__35276);
            rule__VersionRange__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__4_in_rule__VersionRange__Group_0__35279);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2638:1: rule__VersionRange__Group_0__3__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2642:1: ( ( ruleVersion ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2643:1: ( ruleVersion )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2643:1: ( ruleVersion )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2644:1: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
            pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__3__Impl5306);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2655:1: rule__VersionRange__Group_0__4 : rule__VersionRange__Group_0__4__Impl ;
    public final void rule__VersionRange__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2659:1: ( rule__VersionRange__Group_0__4__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2660:2: rule__VersionRange__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__4__Impl_in_rule__VersionRange__Group_0__45335);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2666:1: rule__VersionRange__Group_0__4__Impl : ( ( rule__VersionRange__Alternatives_0_4 ) ) ;
    public final void rule__VersionRange__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2670:1: ( ( ( rule__VersionRange__Alternatives_0_4 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2671:1: ( ( rule__VersionRange__Alternatives_0_4 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2671:1: ( ( rule__VersionRange__Alternatives_0_4 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2672:1: ( rule__VersionRange__Alternatives_0_4 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_4()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2673:1: ( rule__VersionRange__Alternatives_0_4 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2673:2: rule__VersionRange__Alternatives_0_4
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_0_4_in_rule__VersionRange__Group_0__4__Impl5362);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2694:1: rule__Location__UnorderedGroup_1 : rule__Location__UnorderedGroup_1__0 {...}?;
    public final void rule__Location__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2699:1: ( rule__Location__UnorderedGroup_1__0 {...}?)
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2700:2: rule__Location__UnorderedGroup_1__0 {...}?
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__0_in_rule__Location__UnorderedGroup_15403);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2711:1: rule__Location__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__CompositeUriAssignment_1_1 ) ) ) ) ) ;
    public final void rule__Location__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2716:1: ( ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__CompositeUriAssignment_1_1 ) ) ) ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2717:3: ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__CompositeUriAssignment_1_1 ) ) ) ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2717:3: ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__CompositeUriAssignment_1_1 ) ) ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( LA27_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_STRING||LA27_0==28) && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2719:4: ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2719:4: ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2720:5: {...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
                    }
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2720:105: ( ( ( rule__Location__IDAssignment_1_0 ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2721:6: ( ( rule__Location__IDAssignment_1_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2727:6: ( ( rule__Location__IDAssignment_1_0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2729:7: ( rule__Location__IDAssignment_1_0 )
                    {
                     before(grammarAccess.getLocationAccess().getIDAssignment_1_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2730:7: ( rule__Location__IDAssignment_1_0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2730:8: rule__Location__IDAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__Location__IDAssignment_1_0_in_rule__Location__UnorderedGroup_1__Impl5492);
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
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2736:4: ({...}? => ( ( ( rule__Location__CompositeUriAssignment_1_1 ) ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2736:4: ({...}? => ( ( ( rule__Location__CompositeUriAssignment_1_1 ) ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2737:5: {...}? => ( ( ( rule__Location__CompositeUriAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
                    }
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2737:105: ( ( ( rule__Location__CompositeUriAssignment_1_1 ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2738:6: ( ( rule__Location__CompositeUriAssignment_1_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2744:6: ( ( rule__Location__CompositeUriAssignment_1_1 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2746:7: ( rule__Location__CompositeUriAssignment_1_1 )
                    {
                     before(grammarAccess.getLocationAccess().getCompositeUriAssignment_1_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2747:7: ( rule__Location__CompositeUriAssignment_1_1 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2747:8: rule__Location__CompositeUriAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__Location__CompositeUriAssignment_1_1_in_rule__Location__UnorderedGroup_1__Impl5583);
                    rule__Location__CompositeUriAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLocationAccess().getCompositeUriAssignment_1_1()); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2762:1: rule__Location__UnorderedGroup_1__0 : rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? ;
    public final void rule__Location__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2766:1: ( rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2767:2: rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )?
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__05642);
            rule__Location__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2768:2: ( rule__Location__UnorderedGroup_1__1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( LA28_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_STRING||LA28_0==28) && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2768:2: rule__Location__UnorderedGroup_1__1
                    {
                    pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__1_in_rule__Location__UnorderedGroup_1__05645);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2775:1: rule__Location__UnorderedGroup_1__1 : rule__Location__UnorderedGroup_1__Impl ;
    public final void rule__Location__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2779:1: ( rule__Location__UnorderedGroup_1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2780:2: rule__Location__UnorderedGroup_1__Impl
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__15670);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2791:1: rule__TargetPlatform__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TargetPlatform__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2795:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2796:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2796:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2797:1: RULE_STRING
            {
             before(grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_15702); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2806:1: rule__TargetPlatform__ContentsAssignment_2 : ( ruleTargetContent ) ;
    public final void rule__TargetPlatform__ContentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2810:1: ( ( ruleTargetContent ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2811:1: ( ruleTargetContent )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2811:1: ( ruleTargetContent )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2812:1: ruleTargetContent
            {
             before(grammarAccess.getTargetPlatformAccess().getContentsTargetContentParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTargetContent_in_rule__TargetPlatform__ContentsAssignment_25733);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2821:1: rule__Options__OptionsAssignment_1 : ( ruleOption ) ;
    public final void rule__Options__OptionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2825:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2826:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2826:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2827:1: ruleOption
            {
             before(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_15764);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2836:1: rule__Options__OptionsAssignment_2_1 : ( ruleOption ) ;
    public final void rule__Options__OptionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2840:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2841:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2841:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2842:1: ruleOption
            {
             before(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_2_15795);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2851:1: rule__Environment__EnvAssignment_2 : ( RULE_ID ) ;
    public final void rule__Environment__EnvAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2855:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2856:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2856:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2857:1: RULE_ID
            {
             before(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_25826); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2866:1: rule__Environment__EnvAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Environment__EnvAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2870:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2871:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2871:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2872:1: RULE_ID
            {
             before(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_3_15857); 
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


    // $ANTLR start "rule__VarDefinition__NameAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2881:1: rule__VarDefinition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__VarDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2885:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2886:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2886:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2887:1: RULE_ID
            {
             before(grammarAccess.getVarDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VarDefinition__NameAssignment_15888); 
             after(grammarAccess.getVarDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__VarDefinition__NameAssignment_1"


    // $ANTLR start "rule__VarDefinition__ValueAssignment_3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2896:1: rule__VarDefinition__ValueAssignment_3 : ( ruleCompositeString ) ;
    public final void rule__VarDefinition__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2900:1: ( ( ruleCompositeString ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2901:1: ( ruleCompositeString )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2901:1: ( ruleCompositeString )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2902:1: ruleCompositeString
            {
             before(grammarAccess.getVarDefinitionAccess().getValueCompositeStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCompositeString_in_rule__VarDefinition__ValueAssignment_35919);
            ruleCompositeString();

            state._fsp--;

             after(grammarAccess.getVarDefinitionAccess().getValueCompositeStringParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__VarDefinition__ValueAssignment_3"


    // $ANTLR start "rule__CompositeString__StringPartsAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2911:1: rule__CompositeString__StringPartsAssignment_1 : ( ruleCompositeStringPart ) ;
    public final void rule__CompositeString__StringPartsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2915:1: ( ( ruleCompositeStringPart ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2916:1: ( ruleCompositeStringPart )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2916:1: ( ruleCompositeStringPart )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2917:1: ruleCompositeStringPart
            {
             before(grammarAccess.getCompositeStringAccess().getStringPartsCompositeStringPartParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleCompositeStringPart_in_rule__CompositeString__StringPartsAssignment_15950);
            ruleCompositeStringPart();

            state._fsp--;

             after(grammarAccess.getCompositeStringAccess().getStringPartsCompositeStringPartParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__CompositeString__StringPartsAssignment_1"


    // $ANTLR start "rule__CompositeString__StringPartsAssignment_2_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2926:1: rule__CompositeString__StringPartsAssignment_2_1 : ( ruleCompositeStringPart ) ;
    public final void rule__CompositeString__StringPartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2930:1: ( ( ruleCompositeStringPart ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2931:1: ( ruleCompositeStringPart )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2931:1: ( ruleCompositeStringPart )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2932:1: ruleCompositeStringPart
            {
             before(grammarAccess.getCompositeStringAccess().getStringPartsCompositeStringPartParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleCompositeStringPart_in_rule__CompositeString__StringPartsAssignment_2_15981);
            ruleCompositeStringPart();

            state._fsp--;

             after(grammarAccess.getCompositeStringAccess().getStringPartsCompositeStringPartParserRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__CompositeString__StringPartsAssignment_2_1"


    // $ANTLR start "rule__VarCall__VarNameAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2941:1: rule__VarCall__VarNameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VarCall__VarNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2945:1: ( ( ( RULE_ID ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2946:1: ( ( RULE_ID ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2946:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2947:1: ( RULE_ID )
            {
             before(grammarAccess.getVarCallAccess().getVarNameVarDefinitionCrossReference_1_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2948:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2949:1: RULE_ID
            {
             before(grammarAccess.getVarCallAccess().getVarNameVarDefinitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VarCall__VarNameAssignment_16016); 
             after(grammarAccess.getVarCallAccess().getVarNameVarDefinitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getVarCallAccess().getVarNameVarDefinitionCrossReference_1_0()); 

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
    // $ANTLR end "rule__VarCall__VarNameAssignment_1"


    // $ANTLR start "rule__StaticString__ValueAssignment"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2960:1: rule__StaticString__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StaticString__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2964:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2965:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2965:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2966:1: RULE_STRING
            {
             before(grammarAccess.getStaticStringAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StaticString__ValueAssignment6051); 
             after(grammarAccess.getStaticStringAccess().getValueSTRINGTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__StaticString__ValueAssignment"


    // $ANTLR start "rule__IncludeDeclaration__CompositeImportURIAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2975:1: rule__IncludeDeclaration__CompositeImportURIAssignment_1 : ( ruleCompositeString ) ;
    public final void rule__IncludeDeclaration__CompositeImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2979:1: ( ( ruleCompositeString ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2980:1: ( ruleCompositeString )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2980:1: ( ruleCompositeString )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2981:1: ruleCompositeString
            {
             before(grammarAccess.getIncludeDeclarationAccess().getCompositeImportURICompositeStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleCompositeString_in_rule__IncludeDeclaration__CompositeImportURIAssignment_16082);
            ruleCompositeString();

            state._fsp--;

             after(grammarAccess.getIncludeDeclarationAccess().getCompositeImportURICompositeStringParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__IncludeDeclaration__CompositeImportURIAssignment_1"


    // $ANTLR start "rule__Location__IDAssignment_1_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2990:1: rule__Location__IDAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Location__IDAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2994:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2995:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2995:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2996:1: RULE_ID
            {
             before(grammarAccess.getLocationAccess().getIDIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Location__IDAssignment_1_06113); 
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


    // $ANTLR start "rule__Location__CompositeUriAssignment_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3005:1: rule__Location__CompositeUriAssignment_1_1 : ( ruleCompositeString ) ;
    public final void rule__Location__CompositeUriAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3009:1: ( ( ruleCompositeString ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3010:1: ( ruleCompositeString )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3010:1: ( ruleCompositeString )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3011:1: ruleCompositeString
            {
             before(grammarAccess.getLocationAccess().getCompositeUriCompositeStringParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleCompositeString_in_rule__Location__CompositeUriAssignment_1_16144);
            ruleCompositeString();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getCompositeUriCompositeStringParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Location__CompositeUriAssignment_1_1"


    // $ANTLR start "rule__Location__OptionsAssignment_2_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3020:1: rule__Location__OptionsAssignment_2_1_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3024:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3025:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3025:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3026:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_16175);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3035:1: rule__Location__OptionsAssignment_2_1_2_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3039:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3040:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3040:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3041:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_16206);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3050:1: rule__Location__IusAssignment_2_2 : ( ruleIU ) ;
    public final void rule__Location__IusAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3054:1: ( ( ruleIU ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3055:1: ( ruleIU )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3055:1: ( ruleIU )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3056:1: ruleIU
            {
             before(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_26237);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3065:1: rule__IU__IDAssignment_0 : ( RULE_ID ) ;
    public final void rule__IU__IDAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3069:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3070:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3070:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3071:1: RULE_ID
            {
             before(grammarAccess.getIUAccess().getIDIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IU__IDAssignment_06268); 
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


    // $ANTLR start "rule__IU__VersionAssignment_1_1_0_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3080:1: rule__IU__VersionAssignment_1_1_0_0 : ( ruleVersionRange ) ;
    public final void rule__IU__VersionAssignment_1_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3084:1: ( ( ruleVersionRange ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3085:1: ( ruleVersionRange )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3085:1: ( ruleVersionRange )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3086:1: ruleVersionRange
            {
             before(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0_0()); 
            pushFollow(FOLLOW_ruleVersionRange_in_rule__IU__VersionAssignment_1_1_0_06299);
            ruleVersionRange();

            state._fsp--;

             after(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0_0()); 

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
    // $ANTLR end "rule__IU__VersionAssignment_1_1_0_0"


    // $ANTLR start "rule__IU__VersionAssignment_1_1_0_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3095:1: rule__IU__VersionAssignment_1_1_0_1 : ( RULE_STRING ) ;
    public final void rule__IU__VersionAssignment_1_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3099:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3100:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3100:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3101:1: RULE_STRING
            {
             before(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_1_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_1_0_16330); 
             after(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_1_0_1_0()); 

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
    // $ANTLR end "rule__IU__VersionAssignment_1_1_0_1"


    // $ANTLR start "rule__IU__VarVersionAssignment_1_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3110:1: rule__IU__VarVersionAssignment_1_1_1 : ( ruleVarCall ) ;
    public final void rule__IU__VarVersionAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3114:1: ( ( ruleVarCall ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3115:1: ( ruleVarCall )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3115:1: ( ruleVarCall )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:3116:1: ruleVarCall
            {
             before(grammarAccess.getIUAccess().getVarVersionVarCallParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleVarCall_in_rule__IU__VarVersionAssignment_1_1_16361);
            ruleVarCall();

            state._fsp--;

             after(grammarAccess.getIUAccess().getVarVersionVarCallParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end "rule__IU__VarVersionAssignment_1_1_1"

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
    public static final BitSet FOLLOW_ruleVarDefinition_in_entryRuleVarDefinition302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarDefinition309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarDefinition__Group__0_in_ruleVarDefinition335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeString_in_entryRuleCompositeString362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeString369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeString__Group__0_in_ruleCompositeString395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeStringPart_in_entryRuleCompositeStringPart422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeStringPart429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeStringPart__Alternatives_in_ruleCompositeStringPart455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarCall_in_entryRuleVarCall482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarCall489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarCall__Group__0_in_ruleVarCall515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticString_in_entryRuleStaticString542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticString549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StaticString__ValueAssignment_in_ruleStaticString575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_entryRuleIncludeDeclaration602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDeclaration609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__0_in_ruleIncludeDeclaration635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__0_in_ruleLocation695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__0_in_ruleIU755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group__0_in_ruleVersion824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_in_ruleVersionRange893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Option__Alternatives_in_ruleOption930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptions_in_rule__TargetContent__Alternatives965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnvironment_in_rule__TargetContent__Alternatives982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDeclaration_in_rule__TargetContent__Alternatives999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_rule__TargetContent__Alternatives1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarDefinition_in_rule__TargetContent__Alternatives1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarCall_in_rule__CompositeStringPart__Alternatives1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticString_in_rule__CompositeStringPart__Alternatives1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Alternatives_1_1_0_in_rule__IU__Alternatives_1_11114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__VarVersionAssignment_1_1_1_in_rule__IU__Alternatives_1_11132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__VersionAssignment_1_1_0_0_in_rule__IU__Alternatives_1_1_01165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__VersionAssignment_1_1_0_1_in_rule__IU__Alternatives_1_1_01183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Version__Alternatives_1_2_2_11216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Alternatives_1_2_2_11233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_QUALIFIER_in_rule__Version__Alternatives_1_2_2_11250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__0_in_rule__VersionRange__Alternatives1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Alternatives1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__VersionRange__Alternatives1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VersionRange__Alternatives_0_01353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VersionRange__Alternatives_0_01373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VersionRange__Alternatives_0_41408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VersionRange__Alternatives_0_41428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Option__Alternatives1463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Option__Alternatives1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Option__Alternatives1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Option__Alternatives1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__01559 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__01562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__TargetPlatform__Group__0__Impl1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__11621 = new BitSet(new long[]{0x00000000C3400000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__11624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__21681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__ContentsAssignment_2_in_rule__TargetPlatform__Group__2__Impl1708 = new BitSet(new long[]{0x00000000C3400002L});
    public static final BitSet FOLLOW_rule__Options__Group__0__Impl_in_rule__Options__Group__01745 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__Options__Group__1_in_rule__Options__Group__01748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Options__Group__0__Impl1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group__1__Impl_in_rule__Options__Group__11807 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_rule__Options__Group__2_in_rule__Options__Group__11810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__OptionsAssignment_1_in_rule__Options__Group__1__Impl1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group__2__Impl_in_rule__Options__Group__21867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__0_in_rule__Options__Group__2__Impl1894 = new BitSet(new long[]{0x00000000009E0002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__0__Impl_in_rule__Options__Group_2__01931 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_rule__Options__Group_2__1_in_rule__Options__Group_2__01934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Options__Group_2__0__Impl1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__Group_2__1__Impl_in_rule__Options__Group_2__11996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Options__OptionsAssignment_2_1_in_rule__Options__Group_2__1__Impl2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__0__Impl_in_rule__Environment__Group__02057 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Environment__Group__1_in_rule__Environment__Group__02060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__1__Impl_in_rule__Environment__Group__12118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Environment__Group__2_in_rule__Environment__Group__12121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Environment__Group__1__Impl2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__2__Impl_in_rule__Environment__Group__22180 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_rule__Environment__Group__3_in_rule__Environment__Group__22183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__EnvAssignment_2_in_rule__Environment__Group__2__Impl2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group__3__Impl_in_rule__Environment__Group__32240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__0_in_rule__Environment__Group__3__Impl2267 = new BitSet(new long[]{0x0000000000800012L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__0__Impl_in_rule__Environment__Group_3__02306 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__1_in_rule__Environment__Group_3__02309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Environment__Group_3__0__Impl2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__Group_3__1__Impl_in_rule__Environment__Group_3__12371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Environment__EnvAssignment_3_1_in_rule__Environment__Group_3__1__Impl2398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarDefinition__Group__0__Impl_in_rule__VarDefinition__Group__02432 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VarDefinition__Group__1_in_rule__VarDefinition__Group__02435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__VarDefinition__Group__0__Impl2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarDefinition__Group__1__Impl_in_rule__VarDefinition__Group__12494 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__VarDefinition__Group__2_in_rule__VarDefinition__Group__12497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarDefinition__NameAssignment_1_in_rule__VarDefinition__Group__1__Impl2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarDefinition__Group__2__Impl_in_rule__VarDefinition__Group__22554 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_rule__VarDefinition__Group__3_in_rule__VarDefinition__Group__22557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VarDefinition__Group__2__Impl2585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarDefinition__Group__3__Impl_in_rule__VarDefinition__Group__32616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarDefinition__ValueAssignment_3_in_rule__VarDefinition__Group__3__Impl2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeString__Group__0__Impl_in_rule__CompositeString__Group__02681 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_rule__CompositeString__Group__1_in_rule__CompositeString__Group__02684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeString__Group__1__Impl_in_rule__CompositeString__Group__12742 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__CompositeString__Group__2_in_rule__CompositeString__Group__12745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeString__StringPartsAssignment_1_in_rule__CompositeString__Group__1__Impl2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeString__Group__2__Impl_in_rule__CompositeString__Group__22802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeString__Group_2__0_in_rule__CompositeString__Group__2__Impl2829 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__CompositeString__Group_2__0__Impl_in_rule__CompositeString__Group_2__02866 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_rule__CompositeString__Group_2__1_in_rule__CompositeString__Group_2__02869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__CompositeString__Group_2__0__Impl2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeString__Group_2__1__Impl_in_rule__CompositeString__Group_2__12928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeString__StringPartsAssignment_2_1_in_rule__CompositeString__Group_2__1__Impl2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarCall__Group__0__Impl_in_rule__VarCall__Group__02989 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VarCall__Group__1_in_rule__VarCall__Group__02992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__VarCall__Group__0__Impl3020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarCall__Group__1__Impl_in_rule__VarCall__Group__13051 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__VarCall__Group__2_in_rule__VarCall__Group__13054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarCall__VarNameAssignment_1_in_rule__VarCall__Group__1__Impl3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarCall__Group__2__Impl_in_rule__VarCall__Group__23111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__VarCall__Group__2__Impl3139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__0__Impl_in_rule__IncludeDeclaration__Group__03176 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__1_in_rule__IncludeDeclaration__Group__03179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__IncludeDeclaration__Group__0__Impl3207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__Group__1__Impl_in_rule__IncludeDeclaration__Group__13238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDeclaration__CompositeImportURIAssignment_1_in_rule__IncludeDeclaration__Group__1__Impl3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__03299 = new BitSet(new long[]{0x0000000010000090L});
    public static final BitSet FOLLOW_rule__Location__Group__1_in_rule__Location__Group__03302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Location__Group__0__Impl3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__13361 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Location__Group__2_in_rule__Location__Group__13364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1_in_rule__Location__Group__1__Impl3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__23421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl3448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__03485 = new BitSet(new long[]{0x0000000020400010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__03488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Location__Group_2__0__Impl3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__13547 = new BitSet(new long[]{0x0000000020400010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__13550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__23608 = new BitSet(new long[]{0x0000000020400010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__23611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IusAssignment_2_2_in_rule__Location__Group_2__2__Impl3638 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__33669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Location__Group_2__3__Impl3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__03736 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__03739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Location__Group_2_1__0__Impl3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__13798 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__13801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__23858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl3885 = new BitSet(new long[]{0x00000000009E0002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__03922 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__03925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Location__Group_2_1_2__0__Impl3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__13987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl4014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__04048 = new BitSet(new long[]{0x00000002100070A0L});
    public static final BitSet FOLLOW_rule__IU__Group__1_in_rule__IU__Group__04051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl4078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__14108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__04170 = new BitSet(new long[]{0x00000002100070A0L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__04173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__0_in_rule__IU__Group_1__0__Impl4200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__14231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Alternatives_1_1_in_rule__IU__Group_1__1__Impl4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__0__Impl_in_rule__IU__Group_1_0__04292 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__1_in_rule__IU__Group_1_0__04295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__IU__Group_1_0__0__Impl4323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__1__Impl_in_rule__IU__Group_1_0__14354 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__2_in_rule__IU__Group_1_0__14357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__IU__Group_1_0__1__Impl4385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1_0__2__Impl_in_rule__IU__Group_1_0__24416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__IU__Group_1_0__2__Impl4444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group__0__Impl_in_rule__Version__Group__04481 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Version__Group__1_in_rule__Version__Group__04484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group__0__Impl4511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group__1__Impl_in_rule__Version__Group__14540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__0_in_rule__Version__Group__1__Impl4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__0__Impl_in_rule__Version__Group_1__04602 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Version__Group_1__1_in_rule__Version__Group_1__04605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Version__Group_1__0__Impl4633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__1__Impl_in_rule__Version__Group_1__14664 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Version__Group_1__2_in_rule__Version__Group_1__14667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_1__1__Impl4694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1__2__Impl_in_rule__Version__Group_1__24723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__0_in_rule__Version__Group_1__2__Impl4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__0__Impl_in_rule__Version__Group_1_2__04787 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__1_in_rule__Version__Group_1_2__04790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Version__Group_1_2__0__Impl4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__1__Impl_in_rule__Version__Group_1_2__14849 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__2_in_rule__Version__Group_1_2__14852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_1_2__1__Impl4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2__2__Impl_in_rule__Version__Group_1_2__24908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__0_in_rule__Version__Group_1_2__2__Impl4935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__0__Impl_in_rule__Version__Group_1_2_2__04972 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__1_in_rule__Version__Group_1_2_2__04975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Version__Group_1_2_2__0__Impl5003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_1_2_2__1__Impl_in_rule__Version__Group_1_2_2__15034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Alternatives_1_2_2_1_in_rule__Version__Group_1_2_2__1__Impl5061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__0__Impl_in_rule__VersionRange__Group_0__05095 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__1_in_rule__VersionRange__Group_0__05098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_0_0_in_rule__VersionRange__Group_0__0__Impl5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__1__Impl_in_rule__VersionRange__Group_0__15155 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__2_in_rule__VersionRange__Group_0__15158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__1__Impl5185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__2__Impl_in_rule__VersionRange__Group_0__25214 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__3_in_rule__VersionRange__Group_0__25217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__VersionRange__Group_0__2__Impl5245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__3__Impl_in_rule__VersionRange__Group_0__35276 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__4_in_rule__VersionRange__Group_0__35279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__3__Impl5306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__4__Impl_in_rule__VersionRange__Group_0__45335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_0_4_in_rule__VersionRange__Group_0__4__Impl5362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__0_in_rule__Location__UnorderedGroup_15403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IDAssignment_1_0_in_rule__Location__UnorderedGroup_1__Impl5492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__CompositeUriAssignment_1_1_in_rule__Location__UnorderedGroup_1__Impl5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__05642 = new BitSet(new long[]{0x0000000010000092L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__1_in_rule__Location__UnorderedGroup_1__05645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__15670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_15702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetContent_in_rule__TargetPlatform__ContentsAssignment_25733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_15764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Options__OptionsAssignment_2_15795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_25826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Environment__EnvAssignment_3_15857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VarDefinition__NameAssignment_15888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeString_in_rule__VarDefinition__ValueAssignment_35919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeStringPart_in_rule__CompositeString__StringPartsAssignment_15950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeStringPart_in_rule__CompositeString__StringPartsAssignment_2_15981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VarCall__VarNameAssignment_16016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StaticString__ValueAssignment6051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeString_in_rule__IncludeDeclaration__CompositeImportURIAssignment_16082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Location__IDAssignment_1_06113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeString_in_rule__Location__CompositeUriAssignment_1_16144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_16175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_16206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_26237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IU__IDAssignment_06268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_rule__IU__VersionAssignment_1_1_0_06299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_1_0_16330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarCall_in_rule__IU__VarVersionAssignment_1_1_16361 = new BitSet(new long[]{0x0000000000000002L});

}
