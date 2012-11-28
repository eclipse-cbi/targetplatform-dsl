package fr.obeo.releng.ui.contentassist.antlr.internal; 

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
import fr.obeo.releng.services.TargetPlatformGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTargetPlatformParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'", "'target'", "'location'", "'{'", "'}'", "'with'", "','", "';'", "'version'", "'='", "'.'"
    };
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=5;
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
    public String getGrammarFileName() { return "../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g"; }


     
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:60:1: entryRuleTargetPlatform : ruleTargetPlatform EOF ;
    public final void entryRuleTargetPlatform() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:61:1: ( ruleTargetPlatform EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:62:1: ruleTargetPlatform EOF
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:69:1: ruleTargetPlatform : ( ( rule__TargetPlatform__Group__0 )? ) ;
    public final void ruleTargetPlatform() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:73:2: ( ( ( rule__TargetPlatform__Group__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:74:1: ( ( rule__TargetPlatform__Group__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:74:1: ( ( rule__TargetPlatform__Group__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:75:1: ( rule__TargetPlatform__Group__0 )?
            {
             before(grammarAccess.getTargetPlatformAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:76:1: ( rule__TargetPlatform__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:76:2: rule__TargetPlatform__Group__0
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


    // $ANTLR start "entryRuleLocation"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:88:1: entryRuleLocation : ruleLocation EOF ;
    public final void entryRuleLocation() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:89:1: ( ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:90:1: ruleLocation EOF
            {
             before(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_ruleLocation_in_entryRuleLocation122);
            ruleLocation();

            state._fsp--;

             after(grammarAccess.getLocationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocation129); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:97:1: ruleLocation : ( ( rule__Location__Group__0 ) ) ;
    public final void ruleLocation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:101:2: ( ( ( rule__Location__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:102:1: ( ( rule__Location__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:102:1: ( ( rule__Location__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:103:1: ( rule__Location__Group__0 )
            {
             before(grammarAccess.getLocationAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:104:1: ( rule__Location__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:104:2: rule__Location__Group__0
            {
            pushFollow(FOLLOW_rule__Location__Group__0_in_ruleLocation155);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:116:1: entryRuleIU : ruleIU EOF ;
    public final void entryRuleIU() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:117:1: ( ruleIU EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:118:1: ruleIU EOF
            {
             before(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_ruleIU_in_entryRuleIU182);
            ruleIU();

            state._fsp--;

             after(grammarAccess.getIURule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIU189); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:125:1: ruleIU : ( ( rule__IU__Group__0 ) ) ;
    public final void ruleIU() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:129:2: ( ( ( rule__IU__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:130:1: ( ( rule__IU__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:130:1: ( ( rule__IU__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:131:1: ( rule__IU__Group__0 )
            {
             before(grammarAccess.getIUAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:132:1: ( rule__IU__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:132:2: rule__IU__Group__0
            {
            pushFollow(FOLLOW_rule__IU__Group__0_in_ruleIU215);
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:144:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:145:1: ( ruleQualifiedName EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:146:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName242);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName249); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:153:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:157:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:159:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:160:1: ( rule__QualifiedName__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:160:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName275);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleOption"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:173:1: ruleOption : ( ( rule__Option__Alternatives ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:177:1: ( ( ( rule__Option__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:178:1: ( ( rule__Option__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:178:1: ( ( rule__Option__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:179:1: ( rule__Option__Alternatives )
            {
             before(grammarAccess.getOptionAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:180:1: ( rule__Option__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:180:2: rule__Option__Alternatives
            {
            pushFollow(FOLLOW_rule__Option__Alternatives_in_ruleOption312);
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


    // $ANTLR start "rule__Option__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:191:1: rule__Option__Alternatives : ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) );
    public final void rule__Option__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:195:1: ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
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
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:196:1: ( ( 'requirements' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:196:1: ( ( 'requirements' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:197:1: ( 'requirements' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:198:1: ( 'requirements' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:198:3: 'requirements'
                    {
                    match(input,11,FOLLOW_11_in_rule__Option__Alternatives348); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:203:6: ( ( 'allEnvironments' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:203:6: ( ( 'allEnvironments' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:204:1: ( 'allEnvironments' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:205:1: ( 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:205:3: 'allEnvironments'
                    {
                    match(input,12,FOLLOW_12_in_rule__Option__Alternatives369); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:210:6: ( ( 'source' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:210:6: ( ( 'source' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:211:1: ( 'source' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:212:1: ( 'source' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:212:3: 'source'
                    {
                    match(input,13,FOLLOW_13_in_rule__Option__Alternatives390); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:217:6: ( ( 'configurePhase' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:217:6: ( ( 'configurePhase' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:218:1: ( 'configurePhase' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:219:1: ( 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:219:3: 'configurePhase'
                    {
                    match(input,14,FOLLOW_14_in_rule__Option__Alternatives411); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:231:1: rule__TargetPlatform__Group__0 : rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 ;
    public final void rule__TargetPlatform__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:235:1: ( rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:236:2: rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__0444);
            rule__TargetPlatform__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__0447);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:243:1: rule__TargetPlatform__Group__0__Impl : ( 'target' ) ;
    public final void rule__TargetPlatform__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:247:1: ( ( 'target' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:248:1: ( 'target' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:248:1: ( 'target' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:249:1: 'target'
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__TargetPlatform__Group__0__Impl475); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:262:1: rule__TargetPlatform__Group__1 : rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 ;
    public final void rule__TargetPlatform__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:266:1: ( rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:267:2: rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__1506);
            rule__TargetPlatform__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__1509);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:274:1: rule__TargetPlatform__Group__1__Impl : ( ( rule__TargetPlatform__NameAssignment_1 ) ) ;
    public final void rule__TargetPlatform__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:278:1: ( ( ( rule__TargetPlatform__NameAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:279:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:279:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:280:1: ( rule__TargetPlatform__NameAssignment_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getNameAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:281:1: ( rule__TargetPlatform__NameAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:281:2: rule__TargetPlatform__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl536);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:291:1: rule__TargetPlatform__Group__2 : rule__TargetPlatform__Group__2__Impl ;
    public final void rule__TargetPlatform__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:295:1: ( rule__TargetPlatform__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:296:2: rule__TargetPlatform__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__2566);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:302:1: rule__TargetPlatform__Group__2__Impl : ( ( rule__TargetPlatform__LocationsAssignment_2 )* ) ;
    public final void rule__TargetPlatform__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:306:1: ( ( ( rule__TargetPlatform__LocationsAssignment_2 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:307:1: ( ( rule__TargetPlatform__LocationsAssignment_2 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:307:1: ( ( rule__TargetPlatform__LocationsAssignment_2 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:308:1: ( rule__TargetPlatform__LocationsAssignment_2 )*
            {
             before(grammarAccess.getTargetPlatformAccess().getLocationsAssignment_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:309:1: ( rule__TargetPlatform__LocationsAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:309:2: rule__TargetPlatform__LocationsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__TargetPlatform__LocationsAssignment_2_in_rule__TargetPlatform__Group__2__Impl593);
            	    rule__TargetPlatform__LocationsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getTargetPlatformAccess().getLocationsAssignment_2()); 

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


    // $ANTLR start "rule__Location__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:325:1: rule__Location__Group__0 : rule__Location__Group__0__Impl rule__Location__Group__1 ;
    public final void rule__Location__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:329:1: ( rule__Location__Group__0__Impl rule__Location__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:330:2: rule__Location__Group__0__Impl rule__Location__Group__1
            {
            pushFollow(FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__0630);
            rule__Location__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__1_in_rule__Location__Group__0633);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:337:1: rule__Location__Group__0__Impl : ( 'location' ) ;
    public final void rule__Location__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:341:1: ( ( 'location' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:342:1: ( 'location' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:342:1: ( 'location' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:343:1: 'location'
            {
             before(grammarAccess.getLocationAccess().getLocationKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Location__Group__0__Impl661); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:356:1: rule__Location__Group__1 : rule__Location__Group__1__Impl rule__Location__Group__2 ;
    public final void rule__Location__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:360:1: ( rule__Location__Group__1__Impl rule__Location__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:361:2: rule__Location__Group__1__Impl rule__Location__Group__2
            {
            pushFollow(FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__1692);
            rule__Location__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__2_in_rule__Location__Group__1695);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:368:1: rule__Location__Group__1__Impl : ( ( rule__Location__UriAssignment_1 ) ) ;
    public final void rule__Location__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:372:1: ( ( ( rule__Location__UriAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:373:1: ( ( rule__Location__UriAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:373:1: ( ( rule__Location__UriAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:374:1: ( rule__Location__UriAssignment_1 )
            {
             before(grammarAccess.getLocationAccess().getUriAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:375:1: ( rule__Location__UriAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:375:2: rule__Location__UriAssignment_1
            {
            pushFollow(FOLLOW_rule__Location__UriAssignment_1_in_rule__Location__Group__1__Impl722);
            rule__Location__UriAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getUriAssignment_1()); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:385:1: rule__Location__Group__2 : rule__Location__Group__2__Impl ;
    public final void rule__Location__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:389:1: ( rule__Location__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:390:2: rule__Location__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__2752);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:396:1: rule__Location__Group__2__Impl : ( ( rule__Location__Group_2__0 )? ) ;
    public final void rule__Location__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:400:1: ( ( ( rule__Location__Group_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:401:1: ( ( rule__Location__Group_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:401:1: ( ( rule__Location__Group_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:402:1: ( rule__Location__Group_2__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:403:1: ( rule__Location__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:403:2: rule__Location__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl779);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:419:1: rule__Location__Group_2__0 : rule__Location__Group_2__0__Impl rule__Location__Group_2__1 ;
    public final void rule__Location__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:423:1: ( rule__Location__Group_2__0__Impl rule__Location__Group_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:424:2: rule__Location__Group_2__0__Impl rule__Location__Group_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__0816);
            rule__Location__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__0819);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:431:1: rule__Location__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Location__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:435:1: ( ( '{' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:436:1: ( '{' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:436:1: ( '{' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:437:1: '{'
            {
             before(grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,17,FOLLOW_17_in_rule__Location__Group_2__0__Impl847); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:450:1: rule__Location__Group_2__1 : rule__Location__Group_2__1__Impl rule__Location__Group_2__2 ;
    public final void rule__Location__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:454:1: ( rule__Location__Group_2__1__Impl rule__Location__Group_2__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:455:2: rule__Location__Group_2__1__Impl rule__Location__Group_2__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__1878);
            rule__Location__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__1881);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:462:1: rule__Location__Group_2__1__Impl : ( ( rule__Location__Group_2_1__0 )? ) ;
    public final void rule__Location__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:466:1: ( ( ( rule__Location__Group_2_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:467:1: ( ( rule__Location__Group_2_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:467:1: ( ( rule__Location__Group_2_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:468:1: ( rule__Location__Group_2_1__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:469:1: ( rule__Location__Group_2_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:469:2: rule__Location__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl908);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:479:1: rule__Location__Group_2__2 : rule__Location__Group_2__2__Impl rule__Location__Group_2__3 ;
    public final void rule__Location__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:483:1: ( rule__Location__Group_2__2__Impl rule__Location__Group_2__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:484:2: rule__Location__Group_2__2__Impl rule__Location__Group_2__3
            {
            pushFollow(FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__2939);
            rule__Location__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__2942);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:491:1: rule__Location__Group_2__2__Impl : ( ( rule__Location__Group_2_2__0 )? ) ;
    public final void rule__Location__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:495:1: ( ( ( rule__Location__Group_2_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:496:1: ( ( rule__Location__Group_2_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:496:1: ( ( rule__Location__Group_2_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:497:1: ( rule__Location__Group_2_2__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:498:1: ( rule__Location__Group_2_2__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:498:2: rule__Location__Group_2_2__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2_2__0_in_rule__Location__Group_2__2__Impl969);
                    rule__Location__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLocationAccess().getGroup_2_2()); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:508:1: rule__Location__Group_2__3 : rule__Location__Group_2__3__Impl ;
    public final void rule__Location__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:512:1: ( rule__Location__Group_2__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:513:2: rule__Location__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__31000);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:519:1: rule__Location__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Location__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:523:1: ( ( '}' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:524:1: ( '}' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:524:1: ( '}' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:525:1: '}'
            {
             before(grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,18,FOLLOW_18_in_rule__Location__Group_2__3__Impl1028); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:546:1: rule__Location__Group_2_1__0 : rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 ;
    public final void rule__Location__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:550:1: ( rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:551:2: rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__01067);
            rule__Location__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__01070);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:558:1: rule__Location__Group_2_1__0__Impl : ( 'with' ) ;
    public final void rule__Location__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:562:1: ( ( 'with' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:563:1: ( 'with' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:563:1: ( 'with' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:564:1: 'with'
            {
             before(grammarAccess.getLocationAccess().getWithKeyword_2_1_0()); 
            match(input,19,FOLLOW_19_in_rule__Location__Group_2_1__0__Impl1098); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:577:1: rule__Location__Group_2_1__1 : rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 ;
    public final void rule__Location__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:581:1: ( rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:582:2: rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__11129);
            rule__Location__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__11132);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:589:1: rule__Location__Group_2_1__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_1 ) ) ;
    public final void rule__Location__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:593:1: ( ( ( rule__Location__OptionsAssignment_2_1_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:594:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:594:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:595:1: ( rule__Location__OptionsAssignment_2_1_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:596:1: ( rule__Location__OptionsAssignment_2_1_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:596:2: rule__Location__OptionsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl1159);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:606:1: rule__Location__Group_2_1__2 : rule__Location__Group_2_1__2__Impl ;
    public final void rule__Location__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:610:1: ( rule__Location__Group_2_1__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:611:2: rule__Location__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__21189);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:617:1: rule__Location__Group_2_1__2__Impl : ( ( rule__Location__Group_2_1_2__0 )* ) ;
    public final void rule__Location__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:621:1: ( ( ( rule__Location__Group_2_1_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:622:1: ( ( rule__Location__Group_2_1_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:622:1: ( ( rule__Location__Group_2_1_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:623:1: ( rule__Location__Group_2_1_2__0 )*
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:624:1: ( rule__Location__Group_2_1_2__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:624:2: rule__Location__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl1216);
            	    rule__Location__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:640:1: rule__Location__Group_2_1_2__0 : rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 ;
    public final void rule__Location__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:644:1: ( rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:645:2: rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__01253);
            rule__Location__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__01256);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:652:1: rule__Location__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__Location__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:656:1: ( ( ',' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:657:1: ( ',' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:657:1: ( ',' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:658:1: ','
            {
             before(grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0()); 
            match(input,20,FOLLOW_20_in_rule__Location__Group_2_1_2__0__Impl1284); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:671:1: rule__Location__Group_2_1_2__1 : rule__Location__Group_2_1_2__1__Impl ;
    public final void rule__Location__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:675:1: ( rule__Location__Group_2_1_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:676:2: rule__Location__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__11315);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:682:1: rule__Location__Group_2_1_2__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) ;
    public final void rule__Location__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:686:1: ( ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:687:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:687:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:688:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:689:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:689:2: rule__Location__OptionsAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl1342);
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


    // $ANTLR start "rule__Location__Group_2_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:703:1: rule__Location__Group_2_2__0 : rule__Location__Group_2_2__0__Impl rule__Location__Group_2_2__1 ;
    public final void rule__Location__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:707:1: ( rule__Location__Group_2_2__0__Impl rule__Location__Group_2_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:708:2: rule__Location__Group_2_2__0__Impl rule__Location__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_2__0__Impl_in_rule__Location__Group_2_2__01376);
            rule__Location__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_2__1_in_rule__Location__Group_2_2__01379);
            rule__Location__Group_2_2__1();

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
    // $ANTLR end "rule__Location__Group_2_2__0"


    // $ANTLR start "rule__Location__Group_2_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:715:1: rule__Location__Group_2_2__0__Impl : ( ( rule__Location__IusAssignment_2_2_0 ) ) ;
    public final void rule__Location__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:719:1: ( ( ( rule__Location__IusAssignment_2_2_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:720:1: ( ( rule__Location__IusAssignment_2_2_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:720:1: ( ( rule__Location__IusAssignment_2_2_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:721:1: ( rule__Location__IusAssignment_2_2_0 )
            {
             before(grammarAccess.getLocationAccess().getIusAssignment_2_2_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:722:1: ( rule__Location__IusAssignment_2_2_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:722:2: rule__Location__IusAssignment_2_2_0
            {
            pushFollow(FOLLOW_rule__Location__IusAssignment_2_2_0_in_rule__Location__Group_2_2__0__Impl1406);
            rule__Location__IusAssignment_2_2_0();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getIusAssignment_2_2_0()); 

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
    // $ANTLR end "rule__Location__Group_2_2__0__Impl"


    // $ANTLR start "rule__Location__Group_2_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:732:1: rule__Location__Group_2_2__1 : rule__Location__Group_2_2__1__Impl ;
    public final void rule__Location__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:736:1: ( rule__Location__Group_2_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:737:2: rule__Location__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_2__1__Impl_in_rule__Location__Group_2_2__11436);
            rule__Location__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__Location__Group_2_2__1"


    // $ANTLR start "rule__Location__Group_2_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:743:1: rule__Location__Group_2_2__1__Impl : ( ( rule__Location__IusAssignment_2_2_1 )* ) ;
    public final void rule__Location__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:747:1: ( ( ( rule__Location__IusAssignment_2_2_1 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:748:1: ( ( rule__Location__IusAssignment_2_2_1 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:748:1: ( ( rule__Location__IusAssignment_2_2_1 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:749:1: ( rule__Location__IusAssignment_2_2_1 )*
            {
             before(grammarAccess.getLocationAccess().getIusAssignment_2_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:750:1: ( rule__Location__IusAssignment_2_2_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:750:2: rule__Location__IusAssignment_2_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Location__IusAssignment_2_2_1_in_rule__Location__Group_2_2__1__Impl1463);
            	    rule__Location__IusAssignment_2_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getLocationAccess().getIusAssignment_2_2_1()); 

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
    // $ANTLR end "rule__Location__Group_2_2__1__Impl"


    // $ANTLR start "rule__IU__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:764:1: rule__IU__Group__0 : rule__IU__Group__0__Impl rule__IU__Group__1 ;
    public final void rule__IU__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:768:1: ( rule__IU__Group__0__Impl rule__IU__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:769:2: rule__IU__Group__0__Impl rule__IU__Group__1
            {
            pushFollow(FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__01498);
            rule__IU__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group__1_in_rule__IU__Group__01501);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:776:1: rule__IU__Group__0__Impl : ( ( rule__IU__IDAssignment_0 ) ) ;
    public final void rule__IU__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:780:1: ( ( ( rule__IU__IDAssignment_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:781:1: ( ( rule__IU__IDAssignment_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:781:1: ( ( rule__IU__IDAssignment_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:782:1: ( rule__IU__IDAssignment_0 )
            {
             before(grammarAccess.getIUAccess().getIDAssignment_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:783:1: ( rule__IU__IDAssignment_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:783:2: rule__IU__IDAssignment_0
            {
            pushFollow(FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl1528);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:793:1: rule__IU__Group__1 : rule__IU__Group__1__Impl ;
    public final void rule__IU__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:797:1: ( rule__IU__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:798:2: rule__IU__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__11558);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:804:1: rule__IU__Group__1__Impl : ( ( rule__IU__Group_1__0 )? ) ;
    public final void rule__IU__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:808:1: ( ( ( rule__IU__Group_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:809:1: ( ( rule__IU__Group_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:809:1: ( ( rule__IU__Group_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:810:1: ( rule__IU__Group_1__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:811:1: ( rule__IU__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:811:2: rule__IU__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl1585);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:825:1: rule__IU__Group_1__0 : rule__IU__Group_1__0__Impl rule__IU__Group_1__1 ;
    public final void rule__IU__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:829:1: ( rule__IU__Group_1__0__Impl rule__IU__Group_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:830:2: rule__IU__Group_1__0__Impl rule__IU__Group_1__1
            {
            pushFollow(FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__01620);
            rule__IU__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__01623);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:837:1: rule__IU__Group_1__0__Impl : ( ';' ) ;
    public final void rule__IU__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:841:1: ( ( ';' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:842:1: ( ';' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:842:1: ( ';' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:843:1: ';'
            {
             before(grammarAccess.getIUAccess().getSemicolonKeyword_1_0()); 
            match(input,21,FOLLOW_21_in_rule__IU__Group_1__0__Impl1651); 
             after(grammarAccess.getIUAccess().getSemicolonKeyword_1_0()); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:856:1: rule__IU__Group_1__1 : rule__IU__Group_1__1__Impl rule__IU__Group_1__2 ;
    public final void rule__IU__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:860:1: ( rule__IU__Group_1__1__Impl rule__IU__Group_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:861:2: rule__IU__Group_1__1__Impl rule__IU__Group_1__2
            {
            pushFollow(FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__11682);
            rule__IU__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__2_in_rule__IU__Group_1__11685);
            rule__IU__Group_1__2();

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:868:1: rule__IU__Group_1__1__Impl : ( 'version' ) ;
    public final void rule__IU__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:872:1: ( ( 'version' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:873:1: ( 'version' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:873:1: ( 'version' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:874:1: 'version'
            {
             before(grammarAccess.getIUAccess().getVersionKeyword_1_1()); 
            match(input,22,FOLLOW_22_in_rule__IU__Group_1__1__Impl1713); 
             after(grammarAccess.getIUAccess().getVersionKeyword_1_1()); 

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


    // $ANTLR start "rule__IU__Group_1__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:887:1: rule__IU__Group_1__2 : rule__IU__Group_1__2__Impl rule__IU__Group_1__3 ;
    public final void rule__IU__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:891:1: ( rule__IU__Group_1__2__Impl rule__IU__Group_1__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:892:2: rule__IU__Group_1__2__Impl rule__IU__Group_1__3
            {
            pushFollow(FOLLOW_rule__IU__Group_1__2__Impl_in_rule__IU__Group_1__21744);
            rule__IU__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__3_in_rule__IU__Group_1__21747);
            rule__IU__Group_1__3();

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
    // $ANTLR end "rule__IU__Group_1__2"


    // $ANTLR start "rule__IU__Group_1__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:899:1: rule__IU__Group_1__2__Impl : ( '=' ) ;
    public final void rule__IU__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:903:1: ( ( '=' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:904:1: ( '=' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:904:1: ( '=' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:905:1: '='
            {
             before(grammarAccess.getIUAccess().getEqualsSignKeyword_1_2()); 
            match(input,23,FOLLOW_23_in_rule__IU__Group_1__2__Impl1775); 
             after(grammarAccess.getIUAccess().getEqualsSignKeyword_1_2()); 

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
    // $ANTLR end "rule__IU__Group_1__2__Impl"


    // $ANTLR start "rule__IU__Group_1__3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:918:1: rule__IU__Group_1__3 : rule__IU__Group_1__3__Impl ;
    public final void rule__IU__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:922:1: ( rule__IU__Group_1__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:923:2: rule__IU__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group_1__3__Impl_in_rule__IU__Group_1__31806);
            rule__IU__Group_1__3__Impl();

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
    // $ANTLR end "rule__IU__Group_1__3"


    // $ANTLR start "rule__IU__Group_1__3__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:929:1: rule__IU__Group_1__3__Impl : ( ( rule__IU__VersionAssignment_1_3 ) ) ;
    public final void rule__IU__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:933:1: ( ( ( rule__IU__VersionAssignment_1_3 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:934:1: ( ( rule__IU__VersionAssignment_1_3 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:934:1: ( ( rule__IU__VersionAssignment_1_3 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:935:1: ( rule__IU__VersionAssignment_1_3 )
            {
             before(grammarAccess.getIUAccess().getVersionAssignment_1_3()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:936:1: ( rule__IU__VersionAssignment_1_3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:936:2: rule__IU__VersionAssignment_1_3
            {
            pushFollow(FOLLOW_rule__IU__VersionAssignment_1_3_in_rule__IU__Group_1__3__Impl1833);
            rule__IU__VersionAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getIUAccess().getVersionAssignment_1_3()); 

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
    // $ANTLR end "rule__IU__Group_1__3__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:954:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:958:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:959:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01871);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01874);
            rule__QualifiedName__Group__1();

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:966:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:970:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:971:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:971:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:972:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl1901); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:983:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:987:1: ( rule__QualifiedName__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:988:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11930);
            rule__QualifiedName__Group__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:994:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:998:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:999:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:999:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1000:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1001:1: ( rule__QualifiedName__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1001:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl1957);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

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
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1015:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1019:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1020:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__01992);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01995);
            rule__QualifiedName__Group_1__1();

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
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1027:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1031:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1032:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1032:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1033:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,24,FOLLOW_24_in_rule__QualifiedName__Group_1__0__Impl2023); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1046:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1050:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1051:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12054);
            rule__QualifiedName__Group_1__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1057:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1061:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1062:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1062:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1063:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2081); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__TargetPlatform__NameAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1079:1: rule__TargetPlatform__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TargetPlatform__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1083:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1084:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1084:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1085:1: RULE_STRING
            {
             before(grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_12119); 
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


    // $ANTLR start "rule__TargetPlatform__LocationsAssignment_2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1094:1: rule__TargetPlatform__LocationsAssignment_2 : ( ruleLocation ) ;
    public final void rule__TargetPlatform__LocationsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1098:1: ( ( ruleLocation ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1099:1: ( ruleLocation )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1099:1: ( ruleLocation )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1100:1: ruleLocation
            {
             before(grammarAccess.getTargetPlatformAccess().getLocationsLocationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLocation_in_rule__TargetPlatform__LocationsAssignment_22150);
            ruleLocation();

            state._fsp--;

             after(grammarAccess.getTargetPlatformAccess().getLocationsLocationParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__TargetPlatform__LocationsAssignment_2"


    // $ANTLR start "rule__Location__UriAssignment_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1109:1: rule__Location__UriAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Location__UriAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1113:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1114:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1114:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1115:1: RULE_STRING
            {
             before(grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Location__UriAssignment_12181); 
             after(grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Location__UriAssignment_1"


    // $ANTLR start "rule__Location__OptionsAssignment_2_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1124:1: rule__Location__OptionsAssignment_2_1_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1128:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1129:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1129:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1130:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_12212);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1139:1: rule__Location__OptionsAssignment_2_1_2_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1143:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1144:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1144:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1145:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_12243);
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


    // $ANTLR start "rule__Location__IusAssignment_2_2_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1154:1: rule__Location__IusAssignment_2_2_0 : ( ruleIU ) ;
    public final void rule__Location__IusAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1158:1: ( ( ruleIU ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1159:1: ( ruleIU )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1159:1: ( ruleIU )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1160:1: ruleIU
            {
             before(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0_0()); 
            pushFollow(FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_2_02274);
            ruleIU();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0_0()); 

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
    // $ANTLR end "rule__Location__IusAssignment_2_2_0"


    // $ANTLR start "rule__Location__IusAssignment_2_2_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1169:1: rule__Location__IusAssignment_2_2_1 : ( ruleIU ) ;
    public final void rule__Location__IusAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1173:1: ( ( ruleIU ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1174:1: ( ruleIU )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1174:1: ( ruleIU )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1175:1: ruleIU
            {
             before(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_2_12305);
            ruleIU();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_1_0()); 

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
    // $ANTLR end "rule__Location__IusAssignment_2_2_1"


    // $ANTLR start "rule__IU__IDAssignment_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1184:1: rule__IU__IDAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__IU__IDAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1188:1: ( ( ruleQualifiedName ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1189:1: ( ruleQualifiedName )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1189:1: ( ruleQualifiedName )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1190:1: ruleQualifiedName
            {
             before(grammarAccess.getIUAccess().getIDQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__IU__IDAssignment_02336);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getIUAccess().getIDQualifiedNameParserRuleCall_0_0()); 

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


    // $ANTLR start "rule__IU__VersionAssignment_1_3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1199:1: rule__IU__VersionAssignment_1_3 : ( RULE_STRING ) ;
    public final void rule__IU__VersionAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1203:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1204:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1204:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1205:1: RULE_STRING
            {
             before(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_32367); 
             after(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_3_0()); 

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
    // $ANTLR end "rule__IU__VersionAssignment_1_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleTargetPlatform_in_entryRuleTargetPlatform61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTargetPlatform68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__0_in_ruleTargetPlatform94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_entryRuleLocation122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocation129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__0_in_ruleLocation155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_entryRuleIU182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIU189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__0_in_ruleIU215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Option__Alternatives_in_ruleOption312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Option__Alternatives348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Option__Alternatives369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Option__Alternatives390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Option__Alternatives411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__0444 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__0447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TargetPlatform__Group__0__Impl475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__1506 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__LocationsAssignment_2_in_rule__TargetPlatform__Group__2__Impl593 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__0630 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Location__Group__1_in_rule__Location__Group__0633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Location__Group__0__Impl661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__1692 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Location__Group__2_in_rule__Location__Group__1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UriAssignment_1_in_rule__Location__Group__1__Impl722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__0816 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__0819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Location__Group_2__0__Impl847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__1878 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__2939 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__2942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_2__0_in_rule__Location__Group_2__2__Impl969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__31000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Location__Group_2__3__Impl1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__01067 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__01070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Location__Group_2_1__0__Impl1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__11129 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__11132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__21189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl1216 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__01253 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__01256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Location__Group_2_1_2__0__Impl1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__11315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_2__0__Impl_in_rule__Location__Group_2_2__01376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Location__Group_2_2__1_in_rule__Location__Group_2_2__01379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IusAssignment_2_2_0_in_rule__Location__Group_2_2__0__Impl1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_2__1__Impl_in_rule__Location__Group_2_2__11436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IusAssignment_2_2_1_in_rule__Location__Group_2_2__1__Impl1463 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__01498 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__IU__Group__1_in_rule__IU__Group__01501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__11558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__01620 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__01623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__IU__Group_1__0__Impl1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__11682 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__IU__Group_1__2_in_rule__IU__Group_1__11685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__IU__Group_1__1__Impl1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__2__Impl_in_rule__IU__Group_1__21744 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IU__Group_1__3_in_rule__IU__Group_1__21747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__IU__Group_1__2__Impl1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__3__Impl_in_rule__IU__Group_1__31806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__VersionAssignment_1_3_in_rule__IU__Group_1__3__Impl1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01871 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl1957 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__01992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__QualifiedName__Group_1__0__Impl2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_12119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_rule__TargetPlatform__LocationsAssignment_22150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Location__UriAssignment_12181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_12212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_12243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_2_02274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_2_12305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__IU__IDAssignment_02336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_32367 = new BitSet(new long[]{0x0000000000000002L});

}