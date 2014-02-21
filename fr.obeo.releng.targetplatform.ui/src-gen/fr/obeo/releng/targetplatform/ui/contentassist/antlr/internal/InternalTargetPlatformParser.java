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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'latest'", "'('", "'['", "')'", "']'", "'3.8'", "'3.6'", "'requirements'", "'allEnvironments'", "'source'", "'configurePhase'", "'target'", "'version'", "','", "'with'", "'location'", "'{'", "'}'", "';'", "'='", "'.'"
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
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=6;

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

            if ( (LA1_0==22) ) {
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


    // $ANTLR start "entryRuleLocation"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:88:1: entryRuleLocation : ruleLocation EOF ;
    public final void entryRuleLocation() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:89:1: ( ruleLocation EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:90:1: ruleLocation EOF
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:97:1: ruleLocation : ( ( rule__Location__Group__0 ) ) ;
    public final void ruleLocation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:101:2: ( ( ( rule__Location__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:102:1: ( ( rule__Location__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:102:1: ( ( rule__Location__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:103:1: ( rule__Location__Group__0 )
            {
             before(grammarAccess.getLocationAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:104:1: ( rule__Location__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:104:2: rule__Location__Group__0
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:116:1: entryRuleIU : ruleIU EOF ;
    public final void entryRuleIU() throws RecognitionException {
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:117:1: ( ruleIU EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:118:1: ruleIU EOF
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:125:1: ruleIU : ( ( rule__IU__Group__0 ) ) ;
    public final void ruleIU() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:129:2: ( ( ( rule__IU__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:130:1: ( ( rule__IU__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:130:1: ( ( rule__IU__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:131:1: ( rule__IU__Group__0 )
            {
             before(grammarAccess.getIUAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:132:1: ( rule__IU__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:132:2: rule__IU__Group__0
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:144:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:148:1: ( ruleQualifiedName EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:149:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName247);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName254); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:159:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:164:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:165:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:165:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:166:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:167:1: ( rule__QualifiedName__Group__0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:167:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName284);
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
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleVersion"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:180:1: entryRuleVersion : ruleVersion EOF ;
    public final void entryRuleVersion() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:184:1: ( ruleVersion EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:185:1: ruleVersion EOF
            {
             before(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_ruleVersion_in_entryRuleVersion316);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersion323); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:195:1: ruleVersion : ( ( rule__Version__Alternatives ) ) ;
    public final void ruleVersion() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:200:2: ( ( ( rule__Version__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:201:1: ( ( rule__Version__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:201:1: ( ( rule__Version__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:202:1: ( rule__Version__Alternatives )
            {
             before(grammarAccess.getVersionAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:203:1: ( rule__Version__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:203:2: rule__Version__Alternatives
            {
            pushFollow(FOLLOW_rule__Version__Alternatives_in_ruleVersion353);
            rule__Version__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVersionAccess().getAlternatives()); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:216:1: entryRuleVersionRange : ruleVersionRange EOF ;
    public final void entryRuleVersionRange() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:220:1: ( ruleVersionRange EOF )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:221:1: ruleVersionRange EOF
            {
             before(grammarAccess.getVersionRangeRule()); 
            pushFollow(FOLLOW_ruleVersionRange_in_entryRuleVersionRange385);
            ruleVersionRange();

            state._fsp--;

             after(grammarAccess.getVersionRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionRange392); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:231:1: ruleVersionRange : ( ( rule__VersionRange__Alternatives ) ) ;
    public final void ruleVersionRange() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:236:2: ( ( ( rule__VersionRange__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:237:1: ( ( rule__VersionRange__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:237:1: ( ( rule__VersionRange__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:238:1: ( rule__VersionRange__Alternatives )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:239:1: ( rule__VersionRange__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:239:2: rule__VersionRange__Alternatives
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_in_ruleVersionRange422);
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


    // $ANTLR start "ruleTargetVersion"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:253:1: ruleTargetVersion : ( ( rule__TargetVersion__Alternatives ) ) ;
    public final void ruleTargetVersion() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:257:1: ( ( ( rule__TargetVersion__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:258:1: ( ( rule__TargetVersion__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:258:1: ( ( rule__TargetVersion__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:259:1: ( rule__TargetVersion__Alternatives )
            {
             before(grammarAccess.getTargetVersionAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:260:1: ( rule__TargetVersion__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:260:2: rule__TargetVersion__Alternatives
            {
            pushFollow(FOLLOW_rule__TargetVersion__Alternatives_in_ruleTargetVersion459);
            rule__TargetVersion__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTargetVersionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTargetVersion"


    // $ANTLR start "ruleOption"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:272:1: ruleOption : ( ( rule__Option__Alternatives ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:276:1: ( ( ( rule__Option__Alternatives ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:277:1: ( ( rule__Option__Alternatives ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:277:1: ( ( rule__Option__Alternatives ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:278:1: ( rule__Option__Alternatives )
            {
             before(grammarAccess.getOptionAccess().getAlternatives()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:279:1: ( rule__Option__Alternatives )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:279:2: rule__Option__Alternatives
            {
            pushFollow(FOLLOW_rule__Option__Alternatives_in_ruleOption495);
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


    // $ANTLR start "rule__IU__Alternatives_1_3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:290:1: rule__IU__Alternatives_1_3 : ( ( ( rule__IU__VersionAssignment_1_3_0 ) ) | ( ( rule__IU__VersionAssignment_1_3_1 ) ) );
    public final void rule__IU__Alternatives_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:294:1: ( ( ( rule__IU__VersionAssignment_1_3_0 ) ) | ( ( rule__IU__VersionAssignment_1_3_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_INT||(LA2_0>=11 && LA2_0<=13)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:295:1: ( ( rule__IU__VersionAssignment_1_3_0 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:295:1: ( ( rule__IU__VersionAssignment_1_3_0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:296:1: ( rule__IU__VersionAssignment_1_3_0 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_3_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:297:1: ( rule__IU__VersionAssignment_1_3_0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:297:2: rule__IU__VersionAssignment_1_3_0
                    {
                    pushFollow(FOLLOW_rule__IU__VersionAssignment_1_3_0_in_rule__IU__Alternatives_1_3530);
                    rule__IU__VersionAssignment_1_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getVersionAssignment_1_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:301:6: ( ( rule__IU__VersionAssignment_1_3_1 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:301:6: ( ( rule__IU__VersionAssignment_1_3_1 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:302:1: ( rule__IU__VersionAssignment_1_3_1 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_3_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:303:1: ( rule__IU__VersionAssignment_1_3_1 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:303:2: rule__IU__VersionAssignment_1_3_1
                    {
                    pushFollow(FOLLOW_rule__IU__VersionAssignment_1_3_1_in_rule__IU__Alternatives_1_3548);
                    rule__IU__VersionAssignment_1_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getVersionAssignment_1_3_1()); 

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
    // $ANTLR end "rule__IU__Alternatives_1_3"


    // $ANTLR start "rule__Version__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:312:1: rule__Version__Alternatives : ( ( ( rule__Version__Group_0__0 ) ) | ( 'latest' ) );
    public final void rule__Version__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:316:1: ( ( ( rule__Version__Group_0__0 ) ) | ( 'latest' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            else if ( (LA3_0==11) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:317:1: ( ( rule__Version__Group_0__0 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:317:1: ( ( rule__Version__Group_0__0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:318:1: ( rule__Version__Group_0__0 )
                    {
                     before(grammarAccess.getVersionAccess().getGroup_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:319:1: ( rule__Version__Group_0__0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:319:2: rule__Version__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_0__0_in_rule__Version__Alternatives581);
                    rule__Version__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:323:6: ( 'latest' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:323:6: ( 'latest' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:324:1: 'latest'
                    {
                     before(grammarAccess.getVersionAccess().getLatestKeyword_1()); 
                    match(input,11,FOLLOW_11_in_rule__Version__Alternatives600); 
                     after(grammarAccess.getVersionAccess().getLatestKeyword_1()); 

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
    // $ANTLR end "rule__Version__Alternatives"


    // $ANTLR start "rule__VersionRange__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:336:1: rule__VersionRange__Alternatives : ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) );
    public final void rule__VersionRange__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:340:1: ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=12 && LA4_0<=13)) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT||LA4_0==11) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:341:1: ( ( rule__VersionRange__Group_0__0 ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:341:1: ( ( rule__VersionRange__Group_0__0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:342:1: ( rule__VersionRange__Group_0__0 )
                    {
                     before(grammarAccess.getVersionRangeAccess().getGroup_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:343:1: ( rule__VersionRange__Group_0__0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:343:2: rule__VersionRange__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__VersionRange__Group_0__0_in_rule__VersionRange__Alternatives634);
                    rule__VersionRange__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionRangeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:347:6: ( ruleVersion )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:347:6: ( ruleVersion )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:348:1: ruleVersion
                    {
                     before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Alternatives652);
                    ruleVersion();

                    state._fsp--;

                     after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:358:1: rule__VersionRange__Alternatives_0_0 : ( ( '(' ) | ( '[' ) );
    public final void rule__VersionRange__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:362:1: ( ( '(' ) | ( '[' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==13) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:363:1: ( '(' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:363:1: ( '(' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:364:1: '('
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                    match(input,12,FOLLOW_12_in_rule__VersionRange__Alternatives_0_0685); 
                     after(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:371:6: ( '[' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:371:6: ( '[' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:372:1: '['
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__VersionRange__Alternatives_0_0705); 
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


    // $ANTLR start "rule__VersionRange__Alternatives_0_8"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:384:1: rule__VersionRange__Alternatives_0_8 : ( ( ')' ) | ( ']' ) );
    public final void rule__VersionRange__Alternatives_0_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:388:1: ( ( ')' ) | ( ']' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==15) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:389:1: ( ')' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:389:1: ( ')' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:390:1: ')'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_8_0()); 
                    match(input,14,FOLLOW_14_in_rule__VersionRange__Alternatives_0_8740); 
                     after(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_8_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:397:6: ( ']' )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:397:6: ( ']' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:398:1: ']'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_8_1()); 
                    match(input,15,FOLLOW_15_in_rule__VersionRange__Alternatives_0_8760); 
                     after(grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_8_1()); 

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
    // $ANTLR end "rule__VersionRange__Alternatives_0_8"


    // $ANTLR start "rule__TargetVersion__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:410:1: rule__TargetVersion__Alternatives : ( ( ( '3.8' ) ) | ( ( '3.6' ) ) );
    public final void rule__TargetVersion__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:414:1: ( ( ( '3.8' ) ) | ( ( '3.6' ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==17) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:415:1: ( ( '3.8' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:415:1: ( ( '3.8' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:416:1: ( '3.8' )
                    {
                     before(grammarAccess.getTargetVersionAccess().getTARGET38EnumLiteralDeclaration_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:417:1: ( '3.8' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:417:3: '3.8'
                    {
                    match(input,16,FOLLOW_16_in_rule__TargetVersion__Alternatives795); 

                    }

                     after(grammarAccess.getTargetVersionAccess().getTARGET38EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:422:6: ( ( '3.6' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:422:6: ( ( '3.6' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:423:1: ( '3.6' )
                    {
                     before(grammarAccess.getTargetVersionAccess().getTARGET36EnumLiteralDeclaration_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:424:1: ( '3.6' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:424:3: '3.6'
                    {
                    match(input,17,FOLLOW_17_in_rule__TargetVersion__Alternatives816); 

                    }

                     after(grammarAccess.getTargetVersionAccess().getTARGET36EnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__TargetVersion__Alternatives"


    // $ANTLR start "rule__Option__Alternatives"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:434:1: rule__Option__Alternatives : ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) );
    public final void rule__Option__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:438:1: ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt8=1;
                }
                break;
            case 19:
                {
                alt8=2;
                }
                break;
            case 20:
                {
                alt8=3;
                }
                break;
            case 21:
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
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:439:1: ( ( 'requirements' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:439:1: ( ( 'requirements' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:440:1: ( 'requirements' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:441:1: ( 'requirements' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:441:3: 'requirements'
                    {
                    match(input,18,FOLLOW_18_in_rule__Option__Alternatives852); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:446:6: ( ( 'allEnvironments' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:446:6: ( ( 'allEnvironments' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:447:1: ( 'allEnvironments' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:448:1: ( 'allEnvironments' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:448:3: 'allEnvironments'
                    {
                    match(input,19,FOLLOW_19_in_rule__Option__Alternatives873); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:453:6: ( ( 'source' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:453:6: ( ( 'source' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:454:1: ( 'source' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:455:1: ( 'source' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:455:3: 'source'
                    {
                    match(input,20,FOLLOW_20_in_rule__Option__Alternatives894); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:460:6: ( ( 'configurePhase' ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:460:6: ( ( 'configurePhase' ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:461:1: ( 'configurePhase' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:462:1: ( 'configurePhase' )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:462:3: 'configurePhase'
                    {
                    match(input,21,FOLLOW_21_in_rule__Option__Alternatives915); 

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:474:1: rule__TargetPlatform__Group__0 : rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 ;
    public final void rule__TargetPlatform__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:478:1: ( rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:479:2: rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__0948);
            rule__TargetPlatform__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__0951);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:486:1: rule__TargetPlatform__Group__0__Impl : ( 'target' ) ;
    public final void rule__TargetPlatform__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:490:1: ( ( 'target' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:491:1: ( 'target' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:491:1: ( 'target' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:492:1: 'target'
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__TargetPlatform__Group__0__Impl979); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:505:1: rule__TargetPlatform__Group__1 : rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 ;
    public final void rule__TargetPlatform__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:509:1: ( rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:510:2: rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__11010);
            rule__TargetPlatform__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__11013);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:517:1: rule__TargetPlatform__Group__1__Impl : ( ( rule__TargetPlatform__NameAssignment_1 ) ) ;
    public final void rule__TargetPlatform__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:521:1: ( ( ( rule__TargetPlatform__NameAssignment_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:522:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:522:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:523:1: ( rule__TargetPlatform__NameAssignment_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getNameAssignment_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:524:1: ( rule__TargetPlatform__NameAssignment_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:524:2: rule__TargetPlatform__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl1040);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:534:1: rule__TargetPlatform__Group__2 : rule__TargetPlatform__Group__2__Impl rule__TargetPlatform__Group__3 ;
    public final void rule__TargetPlatform__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:538:1: ( rule__TargetPlatform__Group__2__Impl rule__TargetPlatform__Group__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:539:2: rule__TargetPlatform__Group__2__Impl rule__TargetPlatform__Group__3
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__21070);
            rule__TargetPlatform__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group__3_in_rule__TargetPlatform__Group__21073);
            rule__TargetPlatform__Group__3();

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:546:1: rule__TargetPlatform__Group__2__Impl : ( ( rule__TargetPlatform__UnorderedGroup_2 ) ) ;
    public final void rule__TargetPlatform__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:550:1: ( ( ( rule__TargetPlatform__UnorderedGroup_2 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:551:1: ( ( rule__TargetPlatform__UnorderedGroup_2 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:551:1: ( ( rule__TargetPlatform__UnorderedGroup_2 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:552:1: ( rule__TargetPlatform__UnorderedGroup_2 )
            {
             before(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:553:1: ( rule__TargetPlatform__UnorderedGroup_2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:553:2: rule__TargetPlatform__UnorderedGroup_2
            {
            pushFollow(FOLLOW_rule__TargetPlatform__UnorderedGroup_2_in_rule__TargetPlatform__Group__2__Impl1100);
            rule__TargetPlatform__UnorderedGroup_2();

            state._fsp--;


            }

             after(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__TargetPlatform__Group__3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:563:1: rule__TargetPlatform__Group__3 : rule__TargetPlatform__Group__3__Impl ;
    public final void rule__TargetPlatform__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:567:1: ( rule__TargetPlatform__Group__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:568:2: rule__TargetPlatform__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group__3__Impl_in_rule__TargetPlatform__Group__31130);
            rule__TargetPlatform__Group__3__Impl();

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
    // $ANTLR end "rule__TargetPlatform__Group__3"


    // $ANTLR start "rule__TargetPlatform__Group__3__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:574:1: rule__TargetPlatform__Group__3__Impl : ( ( rule__TargetPlatform__LocationsAssignment_3 )* ) ;
    public final void rule__TargetPlatform__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:578:1: ( ( ( rule__TargetPlatform__LocationsAssignment_3 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:579:1: ( ( rule__TargetPlatform__LocationsAssignment_3 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:579:1: ( ( rule__TargetPlatform__LocationsAssignment_3 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:580:1: ( rule__TargetPlatform__LocationsAssignment_3 )*
            {
             before(grammarAccess.getTargetPlatformAccess().getLocationsAssignment_3()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:581:1: ( rule__TargetPlatform__LocationsAssignment_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==26) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:581:2: rule__TargetPlatform__LocationsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__TargetPlatform__LocationsAssignment_3_in_rule__TargetPlatform__Group__3__Impl1157);
            	    rule__TargetPlatform__LocationsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getTargetPlatformAccess().getLocationsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group__3__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_0__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:599:1: rule__TargetPlatform__Group_2_0__0 : rule__TargetPlatform__Group_2_0__0__Impl rule__TargetPlatform__Group_2_0__1 ;
    public final void rule__TargetPlatform__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:603:1: ( rule__TargetPlatform__Group_2_0__0__Impl rule__TargetPlatform__Group_2_0__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:604:2: rule__TargetPlatform__Group_2_0__0__Impl rule__TargetPlatform__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0__0__Impl_in_rule__TargetPlatform__Group_2_0__01196);
            rule__TargetPlatform__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0__1_in_rule__TargetPlatform__Group_2_0__01199);
            rule__TargetPlatform__Group_2_0__1();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_0__0"


    // $ANTLR start "rule__TargetPlatform__Group_2_0__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:611:1: rule__TargetPlatform__Group_2_0__0__Impl : ( 'version' ) ;
    public final void rule__TargetPlatform__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:615:1: ( ( 'version' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:616:1: ( 'version' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:616:1: ( 'version' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:617:1: 'version'
            {
             before(grammarAccess.getTargetPlatformAccess().getVersionKeyword_2_0_0()); 
            match(input,23,FOLLOW_23_in_rule__TargetPlatform__Group_2_0__0__Impl1227); 
             after(grammarAccess.getTargetPlatformAccess().getVersionKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_0__0__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_0__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:630:1: rule__TargetPlatform__Group_2_0__1 : rule__TargetPlatform__Group_2_0__1__Impl rule__TargetPlatform__Group_2_0__2 ;
    public final void rule__TargetPlatform__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:634:1: ( rule__TargetPlatform__Group_2_0__1__Impl rule__TargetPlatform__Group_2_0__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:635:2: rule__TargetPlatform__Group_2_0__1__Impl rule__TargetPlatform__Group_2_0__2
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0__1__Impl_in_rule__TargetPlatform__Group_2_0__11258);
            rule__TargetPlatform__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0__2_in_rule__TargetPlatform__Group_2_0__11261);
            rule__TargetPlatform__Group_2_0__2();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_0__1"


    // $ANTLR start "rule__TargetPlatform__Group_2_0__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:642:1: rule__TargetPlatform__Group_2_0__1__Impl : ( ( rule__TargetPlatform__TargetVersionsAssignment_2_0_1 ) ) ;
    public final void rule__TargetPlatform__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:646:1: ( ( ( rule__TargetPlatform__TargetVersionsAssignment_2_0_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:647:1: ( ( rule__TargetPlatform__TargetVersionsAssignment_2_0_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:647:1: ( ( rule__TargetPlatform__TargetVersionsAssignment_2_0_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:648:1: ( rule__TargetPlatform__TargetVersionsAssignment_2_0_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetVersionsAssignment_2_0_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:649:1: ( rule__TargetPlatform__TargetVersionsAssignment_2_0_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:649:2: rule__TargetPlatform__TargetVersionsAssignment_2_0_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__TargetVersionsAssignment_2_0_1_in_rule__TargetPlatform__Group_2_0__1__Impl1288);
            rule__TargetPlatform__TargetVersionsAssignment_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTargetPlatformAccess().getTargetVersionsAssignment_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_0__1__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_0__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:659:1: rule__TargetPlatform__Group_2_0__2 : rule__TargetPlatform__Group_2_0__2__Impl ;
    public final void rule__TargetPlatform__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:663:1: ( rule__TargetPlatform__Group_2_0__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:664:2: rule__TargetPlatform__Group_2_0__2__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0__2__Impl_in_rule__TargetPlatform__Group_2_0__21318);
            rule__TargetPlatform__Group_2_0__2__Impl();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_0__2"


    // $ANTLR start "rule__TargetPlatform__Group_2_0__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:670:1: rule__TargetPlatform__Group_2_0__2__Impl : ( ( rule__TargetPlatform__Group_2_0_2__0 )* ) ;
    public final void rule__TargetPlatform__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:674:1: ( ( ( rule__TargetPlatform__Group_2_0_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:675:1: ( ( rule__TargetPlatform__Group_2_0_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:675:1: ( ( rule__TargetPlatform__Group_2_0_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:676:1: ( rule__TargetPlatform__Group_2_0_2__0 )*
            {
             before(grammarAccess.getTargetPlatformAccess().getGroup_2_0_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:677:1: ( rule__TargetPlatform__Group_2_0_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:677:2: rule__TargetPlatform__Group_2_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0_2__0_in_rule__TargetPlatform__Group_2_0__2__Impl1345);
            	    rule__TargetPlatform__Group_2_0_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getTargetPlatformAccess().getGroup_2_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_0__2__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_0_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:693:1: rule__TargetPlatform__Group_2_0_2__0 : rule__TargetPlatform__Group_2_0_2__0__Impl rule__TargetPlatform__Group_2_0_2__1 ;
    public final void rule__TargetPlatform__Group_2_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:697:1: ( rule__TargetPlatform__Group_2_0_2__0__Impl rule__TargetPlatform__Group_2_0_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:698:2: rule__TargetPlatform__Group_2_0_2__0__Impl rule__TargetPlatform__Group_2_0_2__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0_2__0__Impl_in_rule__TargetPlatform__Group_2_0_2__01382);
            rule__TargetPlatform__Group_2_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0_2__1_in_rule__TargetPlatform__Group_2_0_2__01385);
            rule__TargetPlatform__Group_2_0_2__1();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_0_2__0"


    // $ANTLR start "rule__TargetPlatform__Group_2_0_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:705:1: rule__TargetPlatform__Group_2_0_2__0__Impl : ( ',' ) ;
    public final void rule__TargetPlatform__Group_2_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:709:1: ( ( ',' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:710:1: ( ',' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:710:1: ( ',' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:711:1: ','
            {
             before(grammarAccess.getTargetPlatformAccess().getCommaKeyword_2_0_2_0()); 
            match(input,24,FOLLOW_24_in_rule__TargetPlatform__Group_2_0_2__0__Impl1413); 
             after(grammarAccess.getTargetPlatformAccess().getCommaKeyword_2_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_0_2__0__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_0_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:724:1: rule__TargetPlatform__Group_2_0_2__1 : rule__TargetPlatform__Group_2_0_2__1__Impl ;
    public final void rule__TargetPlatform__Group_2_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:728:1: ( rule__TargetPlatform__Group_2_0_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:729:2: rule__TargetPlatform__Group_2_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0_2__1__Impl_in_rule__TargetPlatform__Group_2_0_2__11444);
            rule__TargetPlatform__Group_2_0_2__1__Impl();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_0_2__1"


    // $ANTLR start "rule__TargetPlatform__Group_2_0_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:735:1: rule__TargetPlatform__Group_2_0_2__1__Impl : ( ( rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1 ) ) ;
    public final void rule__TargetPlatform__Group_2_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:739:1: ( ( ( rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:740:1: ( ( rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:740:1: ( ( rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:741:1: ( rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetVersionsAssignment_2_0_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:742:1: ( rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:742:2: rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1_in_rule__TargetPlatform__Group_2_0_2__1__Impl1471);
            rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTargetPlatformAccess().getTargetVersionsAssignment_2_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_0_2__1__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_1__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:756:1: rule__TargetPlatform__Group_2_1__0 : rule__TargetPlatform__Group_2_1__0__Impl rule__TargetPlatform__Group_2_1__1 ;
    public final void rule__TargetPlatform__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:760:1: ( rule__TargetPlatform__Group_2_1__0__Impl rule__TargetPlatform__Group_2_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:761:2: rule__TargetPlatform__Group_2_1__0__Impl rule__TargetPlatform__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1__0__Impl_in_rule__TargetPlatform__Group_2_1__01505);
            rule__TargetPlatform__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1__1_in_rule__TargetPlatform__Group_2_1__01508);
            rule__TargetPlatform__Group_2_1__1();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_1__0"


    // $ANTLR start "rule__TargetPlatform__Group_2_1__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:768:1: rule__TargetPlatform__Group_2_1__0__Impl : ( 'with' ) ;
    public final void rule__TargetPlatform__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:772:1: ( ( 'with' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:773:1: ( 'with' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:773:1: ( 'with' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:774:1: 'with'
            {
             before(grammarAccess.getTargetPlatformAccess().getWithKeyword_2_1_0()); 
            match(input,25,FOLLOW_25_in_rule__TargetPlatform__Group_2_1__0__Impl1536); 
             after(grammarAccess.getTargetPlatformAccess().getWithKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_1__0__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_1__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:787:1: rule__TargetPlatform__Group_2_1__1 : rule__TargetPlatform__Group_2_1__1__Impl rule__TargetPlatform__Group_2_1__2 ;
    public final void rule__TargetPlatform__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:791:1: ( rule__TargetPlatform__Group_2_1__1__Impl rule__TargetPlatform__Group_2_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:792:2: rule__TargetPlatform__Group_2_1__1__Impl rule__TargetPlatform__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1__1__Impl_in_rule__TargetPlatform__Group_2_1__11567);
            rule__TargetPlatform__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1__2_in_rule__TargetPlatform__Group_2_1__11570);
            rule__TargetPlatform__Group_2_1__2();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_1__1"


    // $ANTLR start "rule__TargetPlatform__Group_2_1__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:799:1: rule__TargetPlatform__Group_2_1__1__Impl : ( ( rule__TargetPlatform__OptionsAssignment_2_1_1 ) ) ;
    public final void rule__TargetPlatform__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:803:1: ( ( ( rule__TargetPlatform__OptionsAssignment_2_1_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:804:1: ( ( rule__TargetPlatform__OptionsAssignment_2_1_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:804:1: ( ( rule__TargetPlatform__OptionsAssignment_2_1_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:805:1: ( rule__TargetPlatform__OptionsAssignment_2_1_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getOptionsAssignment_2_1_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:806:1: ( rule__TargetPlatform__OptionsAssignment_2_1_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:806:2: rule__TargetPlatform__OptionsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__OptionsAssignment_2_1_1_in_rule__TargetPlatform__Group_2_1__1__Impl1597);
            rule__TargetPlatform__OptionsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTargetPlatformAccess().getOptionsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_1__1__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_1__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:816:1: rule__TargetPlatform__Group_2_1__2 : rule__TargetPlatform__Group_2_1__2__Impl ;
    public final void rule__TargetPlatform__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:820:1: ( rule__TargetPlatform__Group_2_1__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:821:2: rule__TargetPlatform__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1__2__Impl_in_rule__TargetPlatform__Group_2_1__21627);
            rule__TargetPlatform__Group_2_1__2__Impl();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_1__2"


    // $ANTLR start "rule__TargetPlatform__Group_2_1__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:827:1: rule__TargetPlatform__Group_2_1__2__Impl : ( ( rule__TargetPlatform__Group_2_1_2__0 )* ) ;
    public final void rule__TargetPlatform__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:831:1: ( ( ( rule__TargetPlatform__Group_2_1_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:832:1: ( ( rule__TargetPlatform__Group_2_1_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:832:1: ( ( rule__TargetPlatform__Group_2_1_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:833:1: ( rule__TargetPlatform__Group_2_1_2__0 )*
            {
             before(grammarAccess.getTargetPlatformAccess().getGroup_2_1_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:834:1: ( rule__TargetPlatform__Group_2_1_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:834:2: rule__TargetPlatform__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1_2__0_in_rule__TargetPlatform__Group_2_1__2__Impl1654);
            	    rule__TargetPlatform__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getTargetPlatformAccess().getGroup_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_1__2__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_1_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:850:1: rule__TargetPlatform__Group_2_1_2__0 : rule__TargetPlatform__Group_2_1_2__0__Impl rule__TargetPlatform__Group_2_1_2__1 ;
    public final void rule__TargetPlatform__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:854:1: ( rule__TargetPlatform__Group_2_1_2__0__Impl rule__TargetPlatform__Group_2_1_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:855:2: rule__TargetPlatform__Group_2_1_2__0__Impl rule__TargetPlatform__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1_2__0__Impl_in_rule__TargetPlatform__Group_2_1_2__01691);
            rule__TargetPlatform__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1_2__1_in_rule__TargetPlatform__Group_2_1_2__01694);
            rule__TargetPlatform__Group_2_1_2__1();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_1_2__0"


    // $ANTLR start "rule__TargetPlatform__Group_2_1_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:862:1: rule__TargetPlatform__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__TargetPlatform__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:866:1: ( ( ',' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:867:1: ( ',' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:867:1: ( ',' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:868:1: ','
            {
             before(grammarAccess.getTargetPlatformAccess().getCommaKeyword_2_1_2_0()); 
            match(input,24,FOLLOW_24_in_rule__TargetPlatform__Group_2_1_2__0__Impl1722); 
             after(grammarAccess.getTargetPlatformAccess().getCommaKeyword_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_1_2__0__Impl"


    // $ANTLR start "rule__TargetPlatform__Group_2_1_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:881:1: rule__TargetPlatform__Group_2_1_2__1 : rule__TargetPlatform__Group_2_1_2__1__Impl ;
    public final void rule__TargetPlatform__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:885:1: ( rule__TargetPlatform__Group_2_1_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:886:2: rule__TargetPlatform__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1_2__1__Impl_in_rule__TargetPlatform__Group_2_1_2__11753);
            rule__TargetPlatform__Group_2_1_2__1__Impl();

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
    // $ANTLR end "rule__TargetPlatform__Group_2_1_2__1"


    // $ANTLR start "rule__TargetPlatform__Group_2_1_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:892:1: rule__TargetPlatform__Group_2_1_2__1__Impl : ( ( rule__TargetPlatform__OptionsAssignment_2_1_2_1 ) ) ;
    public final void rule__TargetPlatform__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:896:1: ( ( ( rule__TargetPlatform__OptionsAssignment_2_1_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:897:1: ( ( rule__TargetPlatform__OptionsAssignment_2_1_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:897:1: ( ( rule__TargetPlatform__OptionsAssignment_2_1_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:898:1: ( rule__TargetPlatform__OptionsAssignment_2_1_2_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getOptionsAssignment_2_1_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:899:1: ( rule__TargetPlatform__OptionsAssignment_2_1_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:899:2: rule__TargetPlatform__OptionsAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__TargetPlatform__OptionsAssignment_2_1_2_1_in_rule__TargetPlatform__Group_2_1_2__1__Impl1780);
            rule__TargetPlatform__OptionsAssignment_2_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTargetPlatformAccess().getOptionsAssignment_2_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__Group_2_1_2__1__Impl"


    // $ANTLR start "rule__Location__Group__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:913:1: rule__Location__Group__0 : rule__Location__Group__0__Impl rule__Location__Group__1 ;
    public final void rule__Location__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:917:1: ( rule__Location__Group__0__Impl rule__Location__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:918:2: rule__Location__Group__0__Impl rule__Location__Group__1
            {
            pushFollow(FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__01814);
            rule__Location__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__1_in_rule__Location__Group__01817);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:925:1: rule__Location__Group__0__Impl : ( 'location' ) ;
    public final void rule__Location__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:929:1: ( ( 'location' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:930:1: ( 'location' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:930:1: ( 'location' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:931:1: 'location'
            {
             before(grammarAccess.getLocationAccess().getLocationKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__Location__Group__0__Impl1845); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:944:1: rule__Location__Group__1 : rule__Location__Group__1__Impl rule__Location__Group__2 ;
    public final void rule__Location__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:948:1: ( rule__Location__Group__1__Impl rule__Location__Group__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:949:2: rule__Location__Group__1__Impl rule__Location__Group__2
            {
            pushFollow(FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__11876);
            rule__Location__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group__2_in_rule__Location__Group__11879);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:956:1: rule__Location__Group__1__Impl : ( ( rule__Location__UnorderedGroup_1 ) ) ;
    public final void rule__Location__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:960:1: ( ( ( rule__Location__UnorderedGroup_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:961:1: ( ( rule__Location__UnorderedGroup_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:961:1: ( ( rule__Location__UnorderedGroup_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:962:1: ( rule__Location__UnorderedGroup_1 )
            {
             before(grammarAccess.getLocationAccess().getUnorderedGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:963:1: ( rule__Location__UnorderedGroup_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:963:2: rule__Location__UnorderedGroup_1
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1_in_rule__Location__Group__1__Impl1906);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:973:1: rule__Location__Group__2 : rule__Location__Group__2__Impl ;
    public final void rule__Location__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:977:1: ( rule__Location__Group__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:978:2: rule__Location__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__21936);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:984:1: rule__Location__Group__2__Impl : ( ( rule__Location__Group_2__0 )? ) ;
    public final void rule__Location__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:988:1: ( ( ( rule__Location__Group_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:989:1: ( ( rule__Location__Group_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:989:1: ( ( rule__Location__Group_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:990:1: ( rule__Location__Group_2__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:991:1: ( rule__Location__Group_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:991:2: rule__Location__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl1963);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1007:1: rule__Location__Group_2__0 : rule__Location__Group_2__0__Impl rule__Location__Group_2__1 ;
    public final void rule__Location__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1011:1: ( rule__Location__Group_2__0__Impl rule__Location__Group_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1012:2: rule__Location__Group_2__0__Impl rule__Location__Group_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__02000);
            rule__Location__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__02003);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1019:1: rule__Location__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Location__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1023:1: ( ( '{' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1024:1: ( '{' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1024:1: ( '{' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1025:1: '{'
            {
             before(grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,27,FOLLOW_27_in_rule__Location__Group_2__0__Impl2031); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1038:1: rule__Location__Group_2__1 : rule__Location__Group_2__1__Impl rule__Location__Group_2__2 ;
    public final void rule__Location__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1042:1: ( rule__Location__Group_2__1__Impl rule__Location__Group_2__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1043:2: rule__Location__Group_2__1__Impl rule__Location__Group_2__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__12062);
            rule__Location__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__12065);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1050:1: rule__Location__Group_2__1__Impl : ( ( rule__Location__Group_2_1__0 )? ) ;
    public final void rule__Location__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1054:1: ( ( ( rule__Location__Group_2_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1055:1: ( ( rule__Location__Group_2_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1055:1: ( ( rule__Location__Group_2_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1056:1: ( rule__Location__Group_2_1__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1057:1: ( rule__Location__Group_2_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1057:2: rule__Location__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl2092);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1067:1: rule__Location__Group_2__2 : rule__Location__Group_2__2__Impl rule__Location__Group_2__3 ;
    public final void rule__Location__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1071:1: ( rule__Location__Group_2__2__Impl rule__Location__Group_2__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1072:2: rule__Location__Group_2__2__Impl rule__Location__Group_2__3
            {
            pushFollow(FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__22123);
            rule__Location__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__22126);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1079:1: rule__Location__Group_2__2__Impl : ( ( rule__Location__Group_2_2__0 )? ) ;
    public final void rule__Location__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1083:1: ( ( ( rule__Location__Group_2_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1084:1: ( ( rule__Location__Group_2_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1084:1: ( ( rule__Location__Group_2_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1085:1: ( rule__Location__Group_2_2__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1086:1: ( rule__Location__Group_2_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1086:2: rule__Location__Group_2_2__0
                    {
                    pushFollow(FOLLOW_rule__Location__Group_2_2__0_in_rule__Location__Group_2__2__Impl2153);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1096:1: rule__Location__Group_2__3 : rule__Location__Group_2__3__Impl ;
    public final void rule__Location__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1100:1: ( rule__Location__Group_2__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1101:2: rule__Location__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__32184);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1107:1: rule__Location__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Location__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1111:1: ( ( '}' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1112:1: ( '}' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1112:1: ( '}' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1113:1: '}'
            {
             before(grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,28,FOLLOW_28_in_rule__Location__Group_2__3__Impl2212); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1134:1: rule__Location__Group_2_1__0 : rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 ;
    public final void rule__Location__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1138:1: ( rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1139:2: rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__02251);
            rule__Location__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__02254);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1146:1: rule__Location__Group_2_1__0__Impl : ( 'with' ) ;
    public final void rule__Location__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1150:1: ( ( 'with' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1151:1: ( 'with' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1151:1: ( 'with' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1152:1: 'with'
            {
             before(grammarAccess.getLocationAccess().getWithKeyword_2_1_0()); 
            match(input,25,FOLLOW_25_in_rule__Location__Group_2_1__0__Impl2282); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1165:1: rule__Location__Group_2_1__1 : rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 ;
    public final void rule__Location__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1169:1: ( rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1170:2: rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__12313);
            rule__Location__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__12316);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1177:1: rule__Location__Group_2_1__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_1 ) ) ;
    public final void rule__Location__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1181:1: ( ( ( rule__Location__OptionsAssignment_2_1_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1182:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1182:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1183:1: ( rule__Location__OptionsAssignment_2_1_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1184:1: ( rule__Location__OptionsAssignment_2_1_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1184:2: rule__Location__OptionsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl2343);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1194:1: rule__Location__Group_2_1__2 : rule__Location__Group_2_1__2__Impl ;
    public final void rule__Location__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1198:1: ( rule__Location__Group_2_1__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1199:2: rule__Location__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__22373);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1205:1: rule__Location__Group_2_1__2__Impl : ( ( rule__Location__Group_2_1_2__0 )* ) ;
    public final void rule__Location__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1209:1: ( ( ( rule__Location__Group_2_1_2__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1210:1: ( ( rule__Location__Group_2_1_2__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1210:1: ( ( rule__Location__Group_2_1_2__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1211:1: ( rule__Location__Group_2_1_2__0 )*
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1212:1: ( rule__Location__Group_2_1_2__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1212:2: rule__Location__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl2400);
            	    rule__Location__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1228:1: rule__Location__Group_2_1_2__0 : rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 ;
    public final void rule__Location__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1232:1: ( rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1233:2: rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__02437);
            rule__Location__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__02440);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1240:1: rule__Location__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__Location__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1244:1: ( ( ',' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1245:1: ( ',' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1245:1: ( ',' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1246:1: ','
            {
             before(grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0()); 
            match(input,24,FOLLOW_24_in_rule__Location__Group_2_1_2__0__Impl2468); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1259:1: rule__Location__Group_2_1_2__1 : rule__Location__Group_2_1_2__1__Impl ;
    public final void rule__Location__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1263:1: ( rule__Location__Group_2_1_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1264:2: rule__Location__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__12499);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1270:1: rule__Location__Group_2_1_2__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) ;
    public final void rule__Location__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1274:1: ( ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1275:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1275:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1276:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1277:1: ( rule__Location__OptionsAssignment_2_1_2_1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1277:2: rule__Location__OptionsAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl2526);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1291:1: rule__Location__Group_2_2__0 : rule__Location__Group_2_2__0__Impl rule__Location__Group_2_2__1 ;
    public final void rule__Location__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1295:1: ( rule__Location__Group_2_2__0__Impl rule__Location__Group_2_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1296:2: rule__Location__Group_2_2__0__Impl rule__Location__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__Location__Group_2_2__0__Impl_in_rule__Location__Group_2_2__02560);
            rule__Location__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Location__Group_2_2__1_in_rule__Location__Group_2_2__02563);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1303:1: rule__Location__Group_2_2__0__Impl : ( ( rule__Location__IusAssignment_2_2_0 ) ) ;
    public final void rule__Location__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1307:1: ( ( ( rule__Location__IusAssignment_2_2_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1308:1: ( ( rule__Location__IusAssignment_2_2_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1308:1: ( ( rule__Location__IusAssignment_2_2_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1309:1: ( rule__Location__IusAssignment_2_2_0 )
            {
             before(grammarAccess.getLocationAccess().getIusAssignment_2_2_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1310:1: ( rule__Location__IusAssignment_2_2_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1310:2: rule__Location__IusAssignment_2_2_0
            {
            pushFollow(FOLLOW_rule__Location__IusAssignment_2_2_0_in_rule__Location__Group_2_2__0__Impl2590);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1320:1: rule__Location__Group_2_2__1 : rule__Location__Group_2_2__1__Impl ;
    public final void rule__Location__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1324:1: ( rule__Location__Group_2_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1325:2: rule__Location__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Location__Group_2_2__1__Impl_in_rule__Location__Group_2_2__12620);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1331:1: rule__Location__Group_2_2__1__Impl : ( ( rule__Location__IusAssignment_2_2_1 )* ) ;
    public final void rule__Location__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1335:1: ( ( ( rule__Location__IusAssignment_2_2_1 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1336:1: ( ( rule__Location__IusAssignment_2_2_1 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1336:1: ( ( rule__Location__IusAssignment_2_2_1 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1337:1: ( rule__Location__IusAssignment_2_2_1 )*
            {
             before(grammarAccess.getLocationAccess().getIusAssignment_2_2_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1338:1: ( rule__Location__IusAssignment_2_2_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1338:2: rule__Location__IusAssignment_2_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Location__IusAssignment_2_2_1_in_rule__Location__Group_2_2__1__Impl2647);
            	    rule__Location__IusAssignment_2_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1352:1: rule__IU__Group__0 : rule__IU__Group__0__Impl rule__IU__Group__1 ;
    public final void rule__IU__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1356:1: ( rule__IU__Group__0__Impl rule__IU__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1357:2: rule__IU__Group__0__Impl rule__IU__Group__1
            {
            pushFollow(FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__02682);
            rule__IU__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group__1_in_rule__IU__Group__02685);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1364:1: rule__IU__Group__0__Impl : ( ( rule__IU__IDAssignment_0 ) ) ;
    public final void rule__IU__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1368:1: ( ( ( rule__IU__IDAssignment_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1369:1: ( ( rule__IU__IDAssignment_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1369:1: ( ( rule__IU__IDAssignment_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1370:1: ( rule__IU__IDAssignment_0 )
            {
             before(grammarAccess.getIUAccess().getIDAssignment_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1371:1: ( rule__IU__IDAssignment_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1371:2: rule__IU__IDAssignment_0
            {
            pushFollow(FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl2712);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1381:1: rule__IU__Group__1 : rule__IU__Group__1__Impl ;
    public final void rule__IU__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1385:1: ( rule__IU__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1386:2: rule__IU__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__12742);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1392:1: rule__IU__Group__1__Impl : ( ( rule__IU__Group_1__0 )? ) ;
    public final void rule__IU__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1396:1: ( ( ( rule__IU__Group_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1397:1: ( ( rule__IU__Group_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1397:1: ( ( rule__IU__Group_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1398:1: ( rule__IU__Group_1__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1399:1: ( rule__IU__Group_1__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1399:2: rule__IU__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl2769);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1413:1: rule__IU__Group_1__0 : rule__IU__Group_1__0__Impl rule__IU__Group_1__1 ;
    public final void rule__IU__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1417:1: ( rule__IU__Group_1__0__Impl rule__IU__Group_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1418:2: rule__IU__Group_1__0__Impl rule__IU__Group_1__1
            {
            pushFollow(FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__02804);
            rule__IU__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__02807);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1425:1: rule__IU__Group_1__0__Impl : ( ';' ) ;
    public final void rule__IU__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1429:1: ( ( ';' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1430:1: ( ';' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1430:1: ( ';' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1431:1: ';'
            {
             before(grammarAccess.getIUAccess().getSemicolonKeyword_1_0()); 
            match(input,29,FOLLOW_29_in_rule__IU__Group_1__0__Impl2835); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1444:1: rule__IU__Group_1__1 : rule__IU__Group_1__1__Impl rule__IU__Group_1__2 ;
    public final void rule__IU__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1448:1: ( rule__IU__Group_1__1__Impl rule__IU__Group_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1449:2: rule__IU__Group_1__1__Impl rule__IU__Group_1__2
            {
            pushFollow(FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__12866);
            rule__IU__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__2_in_rule__IU__Group_1__12869);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1456:1: rule__IU__Group_1__1__Impl : ( 'version' ) ;
    public final void rule__IU__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1460:1: ( ( 'version' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1461:1: ( 'version' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1461:1: ( 'version' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1462:1: 'version'
            {
             before(grammarAccess.getIUAccess().getVersionKeyword_1_1()); 
            match(input,23,FOLLOW_23_in_rule__IU__Group_1__1__Impl2897); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1475:1: rule__IU__Group_1__2 : rule__IU__Group_1__2__Impl rule__IU__Group_1__3 ;
    public final void rule__IU__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1479:1: ( rule__IU__Group_1__2__Impl rule__IU__Group_1__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1480:2: rule__IU__Group_1__2__Impl rule__IU__Group_1__3
            {
            pushFollow(FOLLOW_rule__IU__Group_1__2__Impl_in_rule__IU__Group_1__22928);
            rule__IU__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IU__Group_1__3_in_rule__IU__Group_1__22931);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1487:1: rule__IU__Group_1__2__Impl : ( '=' ) ;
    public final void rule__IU__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1491:1: ( ( '=' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1492:1: ( '=' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1492:1: ( '=' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1493:1: '='
            {
             before(grammarAccess.getIUAccess().getEqualsSignKeyword_1_2()); 
            match(input,30,FOLLOW_30_in_rule__IU__Group_1__2__Impl2959); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1506:1: rule__IU__Group_1__3 : rule__IU__Group_1__3__Impl ;
    public final void rule__IU__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1510:1: ( rule__IU__Group_1__3__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1511:2: rule__IU__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__IU__Group_1__3__Impl_in_rule__IU__Group_1__32990);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1517:1: rule__IU__Group_1__3__Impl : ( ( rule__IU__Alternatives_1_3 ) ) ;
    public final void rule__IU__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1521:1: ( ( ( rule__IU__Alternatives_1_3 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1522:1: ( ( rule__IU__Alternatives_1_3 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1522:1: ( ( rule__IU__Alternatives_1_3 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1523:1: ( rule__IU__Alternatives_1_3 )
            {
             before(grammarAccess.getIUAccess().getAlternatives_1_3()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1524:1: ( rule__IU__Alternatives_1_3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1524:2: rule__IU__Alternatives_1_3
            {
            pushFollow(FOLLOW_rule__IU__Alternatives_1_3_in_rule__IU__Group_1__3__Impl3017);
            rule__IU__Alternatives_1_3();

            state._fsp--;


            }

             after(grammarAccess.getIUAccess().getAlternatives_1_3()); 

            }


            }

        }
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1542:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1546:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1547:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03055);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03058);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1554:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1558:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1559:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1559:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1560:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3085); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1571:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1575:1: ( rule__QualifiedName__Group__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1576:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13114);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1582:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1586:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1587:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1587:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1588:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1589:1: ( rule__QualifiedName__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==31) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1589:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3141);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1603:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1607:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1608:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03176);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03179);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1615:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1619:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1620:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1620:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1621:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,31,FOLLOW_31_in_rule__QualifiedName__Group_1__0__Impl3207); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1634:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1638:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1639:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13238);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1645:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1649:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1650:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1650:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1651:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3265); 
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


    // $ANTLR start "rule__Version__Group_0__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1666:1: rule__Version__Group_0__0 : rule__Version__Group_0__0__Impl rule__Version__Group_0__1 ;
    public final void rule__Version__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1670:1: ( rule__Version__Group_0__0__Impl rule__Version__Group_0__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1671:2: rule__Version__Group_0__0__Impl rule__Version__Group_0__1
            {
            pushFollow(FOLLOW_rule__Version__Group_0__0__Impl_in_rule__Version__Group_0__03298);
            rule__Version__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_0__1_in_rule__Version__Group_0__03301);
            rule__Version__Group_0__1();

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
    // $ANTLR end "rule__Version__Group_0__0"


    // $ANTLR start "rule__Version__Group_0__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1678:1: rule__Version__Group_0__0__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1682:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1683:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1683:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1684:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_0__0__Impl3328); 
             after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0__0__Impl"


    // $ANTLR start "rule__Version__Group_0__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1695:1: rule__Version__Group_0__1 : rule__Version__Group_0__1__Impl ;
    public final void rule__Version__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1699:1: ( rule__Version__Group_0__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1700:2: rule__Version__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_0__1__Impl_in_rule__Version__Group_0__13357);
            rule__Version__Group_0__1__Impl();

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
    // $ANTLR end "rule__Version__Group_0__1"


    // $ANTLR start "rule__Version__Group_0__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1706:1: rule__Version__Group_0__1__Impl : ( ( rule__Version__Group_0_1__0 )? ) ;
    public final void rule__Version__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1710:1: ( ( ( rule__Version__Group_0_1__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1711:1: ( ( rule__Version__Group_0_1__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1711:1: ( ( rule__Version__Group_0_1__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1712:1: ( rule__Version__Group_0_1__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_0_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1713:1: ( rule__Version__Group_0_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1713:2: rule__Version__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_0_1__0_in_rule__Version__Group_0__1__Impl3384);
                    rule__Version__Group_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVersionAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0__1__Impl"


    // $ANTLR start "rule__Version__Group_0_1__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1727:1: rule__Version__Group_0_1__0 : rule__Version__Group_0_1__0__Impl rule__Version__Group_0_1__1 ;
    public final void rule__Version__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1731:1: ( rule__Version__Group_0_1__0__Impl rule__Version__Group_0_1__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1732:2: rule__Version__Group_0_1__0__Impl rule__Version__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__Version__Group_0_1__0__Impl_in_rule__Version__Group_0_1__03419);
            rule__Version__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_0_1__1_in_rule__Version__Group_0_1__03422);
            rule__Version__Group_0_1__1();

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
    // $ANTLR end "rule__Version__Group_0_1__0"


    // $ANTLR start "rule__Version__Group_0_1__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1739:1: rule__Version__Group_0_1__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1743:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1744:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1744:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1745:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_0_1_0()); 
            match(input,31,FOLLOW_31_in_rule__Version__Group_0_1__0__Impl3450); 
             after(grammarAccess.getVersionAccess().getFullStopKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0_1__0__Impl"


    // $ANTLR start "rule__Version__Group_0_1__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1758:1: rule__Version__Group_0_1__1 : rule__Version__Group_0_1__1__Impl rule__Version__Group_0_1__2 ;
    public final void rule__Version__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1762:1: ( rule__Version__Group_0_1__1__Impl rule__Version__Group_0_1__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1763:2: rule__Version__Group_0_1__1__Impl rule__Version__Group_0_1__2
            {
            pushFollow(FOLLOW_rule__Version__Group_0_1__1__Impl_in_rule__Version__Group_0_1__13481);
            rule__Version__Group_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_0_1__2_in_rule__Version__Group_0_1__13484);
            rule__Version__Group_0_1__2();

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
    // $ANTLR end "rule__Version__Group_0_1__1"


    // $ANTLR start "rule__Version__Group_0_1__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1770:1: rule__Version__Group_0_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1774:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1775:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1775:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1776:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_0_1__1__Impl3511); 
             after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0_1__1__Impl"


    // $ANTLR start "rule__Version__Group_0_1__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1787:1: rule__Version__Group_0_1__2 : rule__Version__Group_0_1__2__Impl ;
    public final void rule__Version__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1791:1: ( rule__Version__Group_0_1__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1792:2: rule__Version__Group_0_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_0_1__2__Impl_in_rule__Version__Group_0_1__23540);
            rule__Version__Group_0_1__2__Impl();

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
    // $ANTLR end "rule__Version__Group_0_1__2"


    // $ANTLR start "rule__Version__Group_0_1__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1798:1: rule__Version__Group_0_1__2__Impl : ( ( rule__Version__Group_0_1_2__0 )? ) ;
    public final void rule__Version__Group_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1802:1: ( ( ( rule__Version__Group_0_1_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1803:1: ( ( rule__Version__Group_0_1_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1803:1: ( ( rule__Version__Group_0_1_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1804:1: ( rule__Version__Group_0_1_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_0_1_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1805:1: ( rule__Version__Group_0_1_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1805:2: rule__Version__Group_0_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_0_1_2__0_in_rule__Version__Group_0_1__2__Impl3567);
                    rule__Version__Group_0_1_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVersionAccess().getGroup_0_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0_1__2__Impl"


    // $ANTLR start "rule__Version__Group_0_1_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1821:1: rule__Version__Group_0_1_2__0 : rule__Version__Group_0_1_2__0__Impl rule__Version__Group_0_1_2__1 ;
    public final void rule__Version__Group_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1825:1: ( rule__Version__Group_0_1_2__0__Impl rule__Version__Group_0_1_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1826:2: rule__Version__Group_0_1_2__0__Impl rule__Version__Group_0_1_2__1
            {
            pushFollow(FOLLOW_rule__Version__Group_0_1_2__0__Impl_in_rule__Version__Group_0_1_2__03604);
            rule__Version__Group_0_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_0_1_2__1_in_rule__Version__Group_0_1_2__03607);
            rule__Version__Group_0_1_2__1();

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
    // $ANTLR end "rule__Version__Group_0_1_2__0"


    // $ANTLR start "rule__Version__Group_0_1_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1833:1: rule__Version__Group_0_1_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_0_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1837:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1838:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1838:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1839:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_0_1_2_0()); 
            match(input,31,FOLLOW_31_in_rule__Version__Group_0_1_2__0__Impl3635); 
             after(grammarAccess.getVersionAccess().getFullStopKeyword_0_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0_1_2__0__Impl"


    // $ANTLR start "rule__Version__Group_0_1_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1852:1: rule__Version__Group_0_1_2__1 : rule__Version__Group_0_1_2__1__Impl rule__Version__Group_0_1_2__2 ;
    public final void rule__Version__Group_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1856:1: ( rule__Version__Group_0_1_2__1__Impl rule__Version__Group_0_1_2__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1857:2: rule__Version__Group_0_1_2__1__Impl rule__Version__Group_0_1_2__2
            {
            pushFollow(FOLLOW_rule__Version__Group_0_1_2__1__Impl_in_rule__Version__Group_0_1_2__13666);
            rule__Version__Group_0_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_0_1_2__2_in_rule__Version__Group_0_1_2__13669);
            rule__Version__Group_0_1_2__2();

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
    // $ANTLR end "rule__Version__Group_0_1_2__1"


    // $ANTLR start "rule__Version__Group_0_1_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1864:1: rule__Version__Group_0_1_2__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_0_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1868:1: ( ( RULE_INT ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1869:1: ( RULE_INT )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1869:1: ( RULE_INT )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1870:1: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_1_2_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Version__Group_0_1_2__1__Impl3696); 
             after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0_1_2__1__Impl"


    // $ANTLR start "rule__Version__Group_0_1_2__2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1881:1: rule__Version__Group_0_1_2__2 : rule__Version__Group_0_1_2__2__Impl ;
    public final void rule__Version__Group_0_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1885:1: ( rule__Version__Group_0_1_2__2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1886:2: rule__Version__Group_0_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_0_1_2__2__Impl_in_rule__Version__Group_0_1_2__23725);
            rule__Version__Group_0_1_2__2__Impl();

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
    // $ANTLR end "rule__Version__Group_0_1_2__2"


    // $ANTLR start "rule__Version__Group_0_1_2__2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1892:1: rule__Version__Group_0_1_2__2__Impl : ( ( rule__Version__Group_0_1_2_2__0 )? ) ;
    public final void rule__Version__Group_0_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1896:1: ( ( ( rule__Version__Group_0_1_2_2__0 )? ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1897:1: ( ( rule__Version__Group_0_1_2_2__0 )? )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1897:1: ( ( rule__Version__Group_0_1_2_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1898:1: ( rule__Version__Group_0_1_2_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_0_1_2_2()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1899:1: ( rule__Version__Group_0_1_2_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1899:2: rule__Version__Group_0_1_2_2__0
                    {
                    pushFollow(FOLLOW_rule__Version__Group_0_1_2_2__0_in_rule__Version__Group_0_1_2__2__Impl3752);
                    rule__Version__Group_0_1_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVersionAccess().getGroup_0_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0_1_2__2__Impl"


    // $ANTLR start "rule__Version__Group_0_1_2_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1915:1: rule__Version__Group_0_1_2_2__0 : rule__Version__Group_0_1_2_2__0__Impl rule__Version__Group_0_1_2_2__1 ;
    public final void rule__Version__Group_0_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1919:1: ( rule__Version__Group_0_1_2_2__0__Impl rule__Version__Group_0_1_2_2__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1920:2: rule__Version__Group_0_1_2_2__0__Impl rule__Version__Group_0_1_2_2__1
            {
            pushFollow(FOLLOW_rule__Version__Group_0_1_2_2__0__Impl_in_rule__Version__Group_0_1_2_2__03789);
            rule__Version__Group_0_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Version__Group_0_1_2_2__1_in_rule__Version__Group_0_1_2_2__03792);
            rule__Version__Group_0_1_2_2__1();

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
    // $ANTLR end "rule__Version__Group_0_1_2_2__0"


    // $ANTLR start "rule__Version__Group_0_1_2_2__0__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1927:1: rule__Version__Group_0_1_2_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_0_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1931:1: ( ( '.' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1932:1: ( '.' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1932:1: ( '.' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1933:1: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_0_1_2_2_0()); 
            match(input,31,FOLLOW_31_in_rule__Version__Group_0_1_2_2__0__Impl3820); 
             after(grammarAccess.getVersionAccess().getFullStopKeyword_0_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0_1_2_2__0__Impl"


    // $ANTLR start "rule__Version__Group_0_1_2_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1946:1: rule__Version__Group_0_1_2_2__1 : rule__Version__Group_0_1_2_2__1__Impl ;
    public final void rule__Version__Group_0_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1950:1: ( rule__Version__Group_0_1_2_2__1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1951:2: rule__Version__Group_0_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Version__Group_0_1_2_2__1__Impl_in_rule__Version__Group_0_1_2_2__13851);
            rule__Version__Group_0_1_2_2__1__Impl();

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
    // $ANTLR end "rule__Version__Group_0_1_2_2__1"


    // $ANTLR start "rule__Version__Group_0_1_2_2__1__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1957:1: rule__Version__Group_0_1_2_2__1__Impl : ( RULE_ID ) ;
    public final void rule__Version__Group_0_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1961:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1962:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1962:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1963:1: RULE_ID
            {
             before(grammarAccess.getVersionAccess().getIDTerminalRuleCall_0_1_2_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Version__Group_0_1_2_2__1__Impl3878); 
             after(grammarAccess.getVersionAccess().getIDTerminalRuleCall_0_1_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group_0_1_2_2__1__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1978:1: rule__VersionRange__Group_0__0 : rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 ;
    public final void rule__VersionRange__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1982:1: ( rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1983:2: rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__0__Impl_in_rule__VersionRange__Group_0__03911);
            rule__VersionRange__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__1_in_rule__VersionRange__Group_0__03914);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1990:1: rule__VersionRange__Group_0__0__Impl : ( ( rule__VersionRange__Alternatives_0_0 ) ) ;
    public final void rule__VersionRange__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1994:1: ( ( ( rule__VersionRange__Alternatives_0_0 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1995:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1995:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1996:1: ( rule__VersionRange__Alternatives_0_0 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_0()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1997:1: ( rule__VersionRange__Alternatives_0_0 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:1997:2: rule__VersionRange__Alternatives_0_0
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_0_0_in_rule__VersionRange__Group_0__0__Impl3941);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2007:1: rule__VersionRange__Group_0__1 : rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 ;
    public final void rule__VersionRange__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2011:1: ( rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2012:2: rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__1__Impl_in_rule__VersionRange__Group_0__13971);
            rule__VersionRange__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__2_in_rule__VersionRange__Group_0__13974);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2019:1: rule__VersionRange__Group_0__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__VersionRange__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2023:1: ( ( ( RULE_WS )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2024:1: ( ( RULE_WS )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2024:1: ( ( RULE_WS )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2025:1: ( RULE_WS )*
            {
             before(grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_1()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2026:1: ( RULE_WS )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2026:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__VersionRange__Group_0__1__Impl4002); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_1()); 

            }


            }

        }
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2036:1: rule__VersionRange__Group_0__2 : rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 ;
    public final void rule__VersionRange__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2040:1: ( rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2041:2: rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__2__Impl_in_rule__VersionRange__Group_0__24033);
            rule__VersionRange__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__3_in_rule__VersionRange__Group_0__24036);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2048:1: rule__VersionRange__Group_0__2__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2052:1: ( ( ruleVersion ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2053:1: ( ruleVersion )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2053:1: ( ruleVersion )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2054:1: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_2()); 
            pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__2__Impl4063);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_2()); 

            }


            }

        }
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2065:1: rule__VersionRange__Group_0__3 : rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 ;
    public final void rule__VersionRange__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2069:1: ( rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2070:2: rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__3__Impl_in_rule__VersionRange__Group_0__34092);
            rule__VersionRange__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__4_in_rule__VersionRange__Group_0__34095);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2077:1: rule__VersionRange__Group_0__3__Impl : ( ( RULE_WS )* ) ;
    public final void rule__VersionRange__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2081:1: ( ( ( RULE_WS )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2082:1: ( ( RULE_WS )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2082:1: ( ( RULE_WS )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2083:1: ( RULE_WS )*
            {
             before(grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_3()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2084:1: ( RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2084:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__VersionRange__Group_0__3__Impl4123); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_3()); 

            }


            }

        }
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2094:1: rule__VersionRange__Group_0__4 : rule__VersionRange__Group_0__4__Impl rule__VersionRange__Group_0__5 ;
    public final void rule__VersionRange__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2098:1: ( rule__VersionRange__Group_0__4__Impl rule__VersionRange__Group_0__5 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2099:2: rule__VersionRange__Group_0__4__Impl rule__VersionRange__Group_0__5
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__4__Impl_in_rule__VersionRange__Group_0__44154);
            rule__VersionRange__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__5_in_rule__VersionRange__Group_0__44157);
            rule__VersionRange__Group_0__5();

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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2106:1: rule__VersionRange__Group_0__4__Impl : ( ',' ) ;
    public final void rule__VersionRange__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2110:1: ( ( ',' ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2111:1: ( ',' )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2111:1: ( ',' )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2112:1: ','
            {
             before(grammarAccess.getVersionRangeAccess().getCommaKeyword_0_4()); 
            match(input,24,FOLLOW_24_in_rule__VersionRange__Group_0__4__Impl4185); 
             after(grammarAccess.getVersionRangeAccess().getCommaKeyword_0_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__VersionRange__Group_0__5"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2125:1: rule__VersionRange__Group_0__5 : rule__VersionRange__Group_0__5__Impl rule__VersionRange__Group_0__6 ;
    public final void rule__VersionRange__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2129:1: ( rule__VersionRange__Group_0__5__Impl rule__VersionRange__Group_0__6 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2130:2: rule__VersionRange__Group_0__5__Impl rule__VersionRange__Group_0__6
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__5__Impl_in_rule__VersionRange__Group_0__54216);
            rule__VersionRange__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__6_in_rule__VersionRange__Group_0__54219);
            rule__VersionRange__Group_0__6();

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
    // $ANTLR end "rule__VersionRange__Group_0__5"


    // $ANTLR start "rule__VersionRange__Group_0__5__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2137:1: rule__VersionRange__Group_0__5__Impl : ( ( RULE_WS )* ) ;
    public final void rule__VersionRange__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2141:1: ( ( ( RULE_WS )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2142:1: ( ( RULE_WS )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2142:1: ( ( RULE_WS )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2143:1: ( RULE_WS )*
            {
             before(grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_5()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2144:1: ( RULE_WS )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_WS) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2144:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__VersionRange__Group_0__5__Impl4247); 

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__5__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__6"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2154:1: rule__VersionRange__Group_0__6 : rule__VersionRange__Group_0__6__Impl rule__VersionRange__Group_0__7 ;
    public final void rule__VersionRange__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2158:1: ( rule__VersionRange__Group_0__6__Impl rule__VersionRange__Group_0__7 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2159:2: rule__VersionRange__Group_0__6__Impl rule__VersionRange__Group_0__7
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__6__Impl_in_rule__VersionRange__Group_0__64278);
            rule__VersionRange__Group_0__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__7_in_rule__VersionRange__Group_0__64281);
            rule__VersionRange__Group_0__7();

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
    // $ANTLR end "rule__VersionRange__Group_0__6"


    // $ANTLR start "rule__VersionRange__Group_0__6__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2166:1: rule__VersionRange__Group_0__6__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2170:1: ( ( ruleVersion ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2171:1: ( ruleVersion )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2171:1: ( ruleVersion )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2172:1: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_6()); 
            pushFollow(FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__6__Impl4308);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__6__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__7"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2183:1: rule__VersionRange__Group_0__7 : rule__VersionRange__Group_0__7__Impl rule__VersionRange__Group_0__8 ;
    public final void rule__VersionRange__Group_0__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2187:1: ( rule__VersionRange__Group_0__7__Impl rule__VersionRange__Group_0__8 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2188:2: rule__VersionRange__Group_0__7__Impl rule__VersionRange__Group_0__8
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__7__Impl_in_rule__VersionRange__Group_0__74337);
            rule__VersionRange__Group_0__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionRange__Group_0__8_in_rule__VersionRange__Group_0__74340);
            rule__VersionRange__Group_0__8();

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
    // $ANTLR end "rule__VersionRange__Group_0__7"


    // $ANTLR start "rule__VersionRange__Group_0__7__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2195:1: rule__VersionRange__Group_0__7__Impl : ( ( RULE_WS )* ) ;
    public final void rule__VersionRange__Group_0__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2199:1: ( ( ( RULE_WS )* ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2200:1: ( ( RULE_WS )* )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2200:1: ( ( RULE_WS )* )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2201:1: ( RULE_WS )*
            {
             before(grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_7()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2202:1: ( RULE_WS )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2202:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__VersionRange__Group_0__7__Impl4368); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getVersionRangeAccess().getWSTerminalRuleCall_0_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__7__Impl"


    // $ANTLR start "rule__VersionRange__Group_0__8"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2212:1: rule__VersionRange__Group_0__8 : rule__VersionRange__Group_0__8__Impl ;
    public final void rule__VersionRange__Group_0__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2216:1: ( rule__VersionRange__Group_0__8__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2217:2: rule__VersionRange__Group_0__8__Impl
            {
            pushFollow(FOLLOW_rule__VersionRange__Group_0__8__Impl_in_rule__VersionRange__Group_0__84399);
            rule__VersionRange__Group_0__8__Impl();

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
    // $ANTLR end "rule__VersionRange__Group_0__8"


    // $ANTLR start "rule__VersionRange__Group_0__8__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2223:1: rule__VersionRange__Group_0__8__Impl : ( ( rule__VersionRange__Alternatives_0_8 ) ) ;
    public final void rule__VersionRange__Group_0__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2227:1: ( ( ( rule__VersionRange__Alternatives_0_8 ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2228:1: ( ( rule__VersionRange__Alternatives_0_8 ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2228:1: ( ( rule__VersionRange__Alternatives_0_8 ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2229:1: ( rule__VersionRange__Alternatives_0_8 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_8()); 
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2230:1: ( rule__VersionRange__Alternatives_0_8 )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2230:2: rule__VersionRange__Alternatives_0_8
            {
            pushFollow(FOLLOW_rule__VersionRange__Alternatives_0_8_in_rule__VersionRange__Group_0__8__Impl4426);
            rule__VersionRange__Alternatives_0_8();

            state._fsp--;


            }

             after(grammarAccess.getVersionRangeAccess().getAlternatives_0_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionRange__Group_0__8__Impl"


    // $ANTLR start "rule__TargetPlatform__UnorderedGroup_2"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2259:1: rule__TargetPlatform__UnorderedGroup_2 : ( rule__TargetPlatform__UnorderedGroup_2__0 )? ;
    public final void rule__TargetPlatform__UnorderedGroup_2() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2());
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2264:1: ( ( rule__TargetPlatform__UnorderedGroup_2__0 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2265:2: ( rule__TargetPlatform__UnorderedGroup_2__0 )?
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2265:2: ( rule__TargetPlatform__UnorderedGroup_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( LA26_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0) ) {
                alt26=1;
            }
            else if ( LA26_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2265:2: rule__TargetPlatform__UnorderedGroup_2__0
                    {
                    pushFollow(FOLLOW_rule__TargetPlatform__UnorderedGroup_2__0_in_rule__TargetPlatform__UnorderedGroup_24475);
                    rule__TargetPlatform__UnorderedGroup_2__0();

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

            	getUnorderedGroupHelper().leave(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__UnorderedGroup_2"


    // $ANTLR start "rule__TargetPlatform__UnorderedGroup_2__Impl"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2275:1: rule__TargetPlatform__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__TargetPlatform__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TargetPlatform__Group_2_1__0 ) ) ) ) ) ;
    public final void rule__TargetPlatform__UnorderedGroup_2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2280:1: ( ( ({...}? => ( ( ( rule__TargetPlatform__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TargetPlatform__Group_2_1__0 ) ) ) ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2281:3: ( ({...}? => ( ( ( rule__TargetPlatform__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TargetPlatform__Group_2_1__0 ) ) ) ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2281:3: ( ({...}? => ( ( ( rule__TargetPlatform__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TargetPlatform__Group_2_1__0 ) ) ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( LA27_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0) ) {
                alt27=1;
            }
            else if ( LA27_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2283:4: ({...}? => ( ( ( rule__TargetPlatform__Group_2_0__0 ) ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2283:4: ({...}? => ( ( ( rule__TargetPlatform__Group_2_0__0 ) ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2284:5: {...}? => ( ( ( rule__TargetPlatform__Group_2_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0) ) {
                        throw new FailedPredicateException(input, "rule__TargetPlatform__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0)");
                    }
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2284:111: ( ( ( rule__TargetPlatform__Group_2_0__0 ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2285:6: ( ( rule__TargetPlatform__Group_2_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2291:6: ( ( rule__TargetPlatform__Group_2_0__0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2293:7: ( rule__TargetPlatform__Group_2_0__0 )
                    {
                     before(grammarAccess.getTargetPlatformAccess().getGroup_2_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2294:7: ( rule__TargetPlatform__Group_2_0__0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2294:8: rule__TargetPlatform__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__TargetPlatform__Group_2_0__0_in_rule__TargetPlatform__UnorderedGroup_2__Impl4562);
                    rule__TargetPlatform__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTargetPlatformAccess().getGroup_2_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2300:4: ({...}? => ( ( ( rule__TargetPlatform__Group_2_1__0 ) ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2300:4: ({...}? => ( ( ( rule__TargetPlatform__Group_2_1__0 ) ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2301:5: {...}? => ( ( ( rule__TargetPlatform__Group_2_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1) ) {
                        throw new FailedPredicateException(input, "rule__TargetPlatform__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1)");
                    }
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2301:111: ( ( ( rule__TargetPlatform__Group_2_1__0 ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2302:6: ( ( rule__TargetPlatform__Group_2_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2308:6: ( ( rule__TargetPlatform__Group_2_1__0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2310:7: ( rule__TargetPlatform__Group_2_1__0 )
                    {
                     before(grammarAccess.getTargetPlatformAccess().getGroup_2_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2311:7: ( rule__TargetPlatform__Group_2_1__0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2311:8: rule__TargetPlatform__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__TargetPlatform__Group_2_1__0_in_rule__TargetPlatform__UnorderedGroup_2__Impl4653);
                    rule__TargetPlatform__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTargetPlatformAccess().getGroup_2_1()); 

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__UnorderedGroup_2__Impl"


    // $ANTLR start "rule__TargetPlatform__UnorderedGroup_2__0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2326:1: rule__TargetPlatform__UnorderedGroup_2__0 : rule__TargetPlatform__UnorderedGroup_2__Impl ( rule__TargetPlatform__UnorderedGroup_2__1 )? ;
    public final void rule__TargetPlatform__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2330:1: ( rule__TargetPlatform__UnorderedGroup_2__Impl ( rule__TargetPlatform__UnorderedGroup_2__1 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2331:2: rule__TargetPlatform__UnorderedGroup_2__Impl ( rule__TargetPlatform__UnorderedGroup_2__1 )?
            {
            pushFollow(FOLLOW_rule__TargetPlatform__UnorderedGroup_2__Impl_in_rule__TargetPlatform__UnorderedGroup_2__04712);
            rule__TargetPlatform__UnorderedGroup_2__Impl();

            state._fsp--;

            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2332:2: ( rule__TargetPlatform__UnorderedGroup_2__1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( LA28_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 0) ) {
                alt28=1;
            }
            else if ( LA28_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getTargetPlatformAccess().getUnorderedGroup_2(), 1) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2332:2: rule__TargetPlatform__UnorderedGroup_2__1
                    {
                    pushFollow(FOLLOW_rule__TargetPlatform__UnorderedGroup_2__1_in_rule__TargetPlatform__UnorderedGroup_2__04715);
                    rule__TargetPlatform__UnorderedGroup_2__1();

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
    // $ANTLR end "rule__TargetPlatform__UnorderedGroup_2__0"


    // $ANTLR start "rule__TargetPlatform__UnorderedGroup_2__1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2339:1: rule__TargetPlatform__UnorderedGroup_2__1 : rule__TargetPlatform__UnorderedGroup_2__Impl ;
    public final void rule__TargetPlatform__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2343:1: ( rule__TargetPlatform__UnorderedGroup_2__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2344:2: rule__TargetPlatform__UnorderedGroup_2__Impl
            {
            pushFollow(FOLLOW_rule__TargetPlatform__UnorderedGroup_2__Impl_in_rule__TargetPlatform__UnorderedGroup_2__14740);
            rule__TargetPlatform__UnorderedGroup_2__Impl();

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
    // $ANTLR end "rule__TargetPlatform__UnorderedGroup_2__1"


    // $ANTLR start "rule__Location__UnorderedGroup_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2355:1: rule__Location__UnorderedGroup_1 : rule__Location__UnorderedGroup_1__0 {...}?;
    public final void rule__Location__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2360:1: ( rule__Location__UnorderedGroup_1__0 {...}?)
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2361:2: rule__Location__UnorderedGroup_1__0 {...}?
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__0_in_rule__Location__UnorderedGroup_14768);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2372:1: rule__Location__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__Location__IdAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) ) ;
    public final void rule__Location__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2377:1: ( ( ({...}? => ( ( ( rule__Location__IdAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2378:3: ( ({...}? => ( ( ( rule__Location__IdAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2378:3: ( ({...}? => ( ( ( rule__Location__IdAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( LA29_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                alt29=1;
            }
            else if ( LA29_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2380:4: ({...}? => ( ( ( rule__Location__IdAssignment_1_0 ) ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2380:4: ({...}? => ( ( ( rule__Location__IdAssignment_1_0 ) ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2381:5: {...}? => ( ( ( rule__Location__IdAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
                    }
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2381:105: ( ( ( rule__Location__IdAssignment_1_0 ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2382:6: ( ( rule__Location__IdAssignment_1_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2388:6: ( ( rule__Location__IdAssignment_1_0 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2390:7: ( rule__Location__IdAssignment_1_0 )
                    {
                     before(grammarAccess.getLocationAccess().getIdAssignment_1_0()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2391:7: ( rule__Location__IdAssignment_1_0 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2391:8: rule__Location__IdAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__Location__IdAssignment_1_0_in_rule__Location__UnorderedGroup_1__Impl4857);
                    rule__Location__IdAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLocationAccess().getIdAssignment_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2397:4: ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) )
                    {
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2397:4: ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2398:5: {...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
                    }
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2398:105: ( ( ( rule__Location__UriAssignment_1_1 ) ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2399:6: ( ( rule__Location__UriAssignment_1_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2405:6: ( ( rule__Location__UriAssignment_1_1 ) )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2407:7: ( rule__Location__UriAssignment_1_1 )
                    {
                     before(grammarAccess.getLocationAccess().getUriAssignment_1_1()); 
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2408:7: ( rule__Location__UriAssignment_1_1 )
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2408:8: rule__Location__UriAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__Location__UriAssignment_1_1_in_rule__Location__UnorderedGroup_1__Impl4948);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2423:1: rule__Location__UnorderedGroup_1__0 : rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? ;
    public final void rule__Location__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2427:1: ( rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2428:2: rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )?
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__05007);
            rule__Location__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2429:2: ( rule__Location__UnorderedGroup_1__1 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( LA30_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                alt30=1;
            }
            else if ( LA30_0 ==RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2429:2: rule__Location__UnorderedGroup_1__1
                    {
                    pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__1_in_rule__Location__UnorderedGroup_1__05010);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2436:1: rule__Location__UnorderedGroup_1__1 : rule__Location__UnorderedGroup_1__Impl ;
    public final void rule__Location__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2440:1: ( rule__Location__UnorderedGroup_1__Impl )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2441:2: rule__Location__UnorderedGroup_1__Impl
            {
            pushFollow(FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__15035);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2452:1: rule__TargetPlatform__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TargetPlatform__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2456:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2457:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2457:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2458:1: RULE_STRING
            {
             before(grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_15067); 
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


    // $ANTLR start "rule__TargetPlatform__TargetVersionsAssignment_2_0_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2467:1: rule__TargetPlatform__TargetVersionsAssignment_2_0_1 : ( ruleTargetVersion ) ;
    public final void rule__TargetPlatform__TargetVersionsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2471:1: ( ( ruleTargetVersion ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2472:1: ( ruleTargetVersion )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2472:1: ( ruleTargetVersion )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2473:1: ruleTargetVersion
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetVersionsTargetVersionEnumRuleCall_2_0_1_0()); 
            pushFollow(FOLLOW_ruleTargetVersion_in_rule__TargetPlatform__TargetVersionsAssignment_2_0_15098);
            ruleTargetVersion();

            state._fsp--;

             after(grammarAccess.getTargetPlatformAccess().getTargetVersionsTargetVersionEnumRuleCall_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__TargetVersionsAssignment_2_0_1"


    // $ANTLR start "rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2482:1: rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1 : ( ruleTargetVersion ) ;
    public final void rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2486:1: ( ( ruleTargetVersion ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2487:1: ( ruleTargetVersion )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2487:1: ( ruleTargetVersion )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2488:1: ruleTargetVersion
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetVersionsTargetVersionEnumRuleCall_2_0_2_1_0()); 
            pushFollow(FOLLOW_ruleTargetVersion_in_rule__TargetPlatform__TargetVersionsAssignment_2_0_2_15129);
            ruleTargetVersion();

            state._fsp--;

             after(grammarAccess.getTargetPlatformAccess().getTargetVersionsTargetVersionEnumRuleCall_2_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1"


    // $ANTLR start "rule__TargetPlatform__OptionsAssignment_2_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2497:1: rule__TargetPlatform__OptionsAssignment_2_1_1 : ( ruleOption ) ;
    public final void rule__TargetPlatform__OptionsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2501:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2502:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2502:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2503:1: ruleOption
            {
             before(grammarAccess.getTargetPlatformAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__TargetPlatform__OptionsAssignment_2_1_15160);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getTargetPlatformAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__OptionsAssignment_2_1_1"


    // $ANTLR start "rule__TargetPlatform__OptionsAssignment_2_1_2_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2512:1: rule__TargetPlatform__OptionsAssignment_2_1_2_1 : ( ruleOption ) ;
    public final void rule__TargetPlatform__OptionsAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2516:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2517:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2517:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2518:1: ruleOption
            {
             before(grammarAccess.getTargetPlatformAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__TargetPlatform__OptionsAssignment_2_1_2_15191);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getTargetPlatformAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__OptionsAssignment_2_1_2_1"


    // $ANTLR start "rule__TargetPlatform__LocationsAssignment_3"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2527:1: rule__TargetPlatform__LocationsAssignment_3 : ( ruleLocation ) ;
    public final void rule__TargetPlatform__LocationsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2531:1: ( ( ruleLocation ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2532:1: ( ruleLocation )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2532:1: ( ruleLocation )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2533:1: ruleLocation
            {
             before(grammarAccess.getTargetPlatformAccess().getLocationsLocationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLocation_in_rule__TargetPlatform__LocationsAssignment_35222);
            ruleLocation();

            state._fsp--;

             after(grammarAccess.getTargetPlatformAccess().getLocationsLocationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetPlatform__LocationsAssignment_3"


    // $ANTLR start "rule__Location__IdAssignment_1_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2542:1: rule__Location__IdAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Location__IdAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2546:1: ( ( RULE_ID ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2547:1: ( RULE_ID )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2547:1: ( RULE_ID )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2548:1: RULE_ID
            {
             before(grammarAccess.getLocationAccess().getIdIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Location__IdAssignment_1_05253); 
             after(grammarAccess.getLocationAccess().getIdIDTerminalRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__IdAssignment_1_0"


    // $ANTLR start "rule__Location__UriAssignment_1_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2557:1: rule__Location__UriAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Location__UriAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2561:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2562:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2562:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2563:1: RULE_STRING
            {
             before(grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Location__UriAssignment_1_15284); 
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2572:1: rule__Location__OptionsAssignment_2_1_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2576:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2577:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2577:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2578:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_15315);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2587:1: rule__Location__OptionsAssignment_2_1_2_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2591:1: ( ( ruleOption ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2592:1: ( ruleOption )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2592:1: ( ruleOption )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2593:1: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_15346);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2602:1: rule__Location__IusAssignment_2_2_0 : ( ruleIU ) ;
    public final void rule__Location__IusAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2606:1: ( ( ruleIU ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2607:1: ( ruleIU )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2607:1: ( ruleIU )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2608:1: ruleIU
            {
             before(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0_0()); 
            pushFollow(FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_2_05377);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2617:1: rule__Location__IusAssignment_2_2_1 : ( ruleIU ) ;
    public final void rule__Location__IusAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2621:1: ( ( ruleIU ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2622:1: ( ruleIU )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2622:1: ( ruleIU )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2623:1: ruleIU
            {
             before(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_2_15408);
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
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2632:1: rule__IU__IDAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__IU__IDAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2636:1: ( ( ruleQualifiedName ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2637:1: ( ruleQualifiedName )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2637:1: ( ruleQualifiedName )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2638:1: ruleQualifiedName
            {
             before(grammarAccess.getIUAccess().getIDQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__IU__IDAssignment_05439);
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


    // $ANTLR start "rule__IU__VersionAssignment_1_3_0"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2647:1: rule__IU__VersionAssignment_1_3_0 : ( RULE_STRING ) ;
    public final void rule__IU__VersionAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2651:1: ( ( RULE_STRING ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2652:1: ( RULE_STRING )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2652:1: ( RULE_STRING )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2653:1: RULE_STRING
            {
             before(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_3_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_3_05470); 
             after(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__VersionAssignment_1_3_0"


    // $ANTLR start "rule__IU__VersionAssignment_1_3_1"
    // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2662:1: rule__IU__VersionAssignment_1_3_1 : ( ruleVersionRange ) ;
    public final void rule__IU__VersionAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2666:1: ( ( ruleVersionRange ) )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2667:1: ( ruleVersionRange )
            {
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2667:1: ( ruleVersionRange )
            // ../fr.obeo.releng.targetplatform.ui/src-gen/fr/obeo/releng/targetplatform/ui/contentassist/antlr/internal/InternalTargetPlatform.g:2668:1: ruleVersionRange
            {
             before(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_3_1_0()); 
            pushFollow(FOLLOW_ruleVersionRange_in_rule__IU__VersionAssignment_1_3_15501);
            ruleVersionRange();

            state._fsp--;

             after(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IU__VersionAssignment_1_3_1"

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
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersion323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Alternatives_in_ruleVersion353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_entryRuleVersionRange385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionRange392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_in_ruleVersionRange422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetVersion__Alternatives_in_ruleTargetVersion459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Option__Alternatives_in_ruleOption495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__VersionAssignment_1_3_0_in_rule__IU__Alternatives_1_3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__VersionAssignment_1_3_1_in_rule__IU__Alternatives_1_3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0__0_in_rule__Version__Alternatives581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Version__Alternatives600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__0_in_rule__VersionRange__Alternatives634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Alternatives652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__VersionRange__Alternatives_0_0685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VersionRange__Alternatives_0_0705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VersionRange__Alternatives_0_8740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VersionRange__Alternatives_0_8760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__TargetVersion__Alternatives795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TargetVersion__Alternatives816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Option__Alternatives852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Option__Alternatives873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Option__Alternatives894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Option__Alternatives915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__0__Impl_in_rule__TargetPlatform__Group__0948 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1_in_rule__TargetPlatform__Group__0951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__TargetPlatform__Group__0__Impl979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__1__Impl_in_rule__TargetPlatform__Group__11010 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2_in_rule__TargetPlatform__Group__11013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__NameAssignment_1_in_rule__TargetPlatform__Group__1__Impl1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__2__Impl_in_rule__TargetPlatform__Group__21070 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__3_in_rule__TargetPlatform__Group__21073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__UnorderedGroup_2_in_rule__TargetPlatform__Group__2__Impl1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group__3__Impl_in_rule__TargetPlatform__Group__31130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__LocationsAssignment_3_in_rule__TargetPlatform__Group__3__Impl1157 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0__0__Impl_in_rule__TargetPlatform__Group_2_0__01196 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0__1_in_rule__TargetPlatform__Group_2_0__01199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__TargetPlatform__Group_2_0__0__Impl1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0__1__Impl_in_rule__TargetPlatform__Group_2_0__11258 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0__2_in_rule__TargetPlatform__Group_2_0__11261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__TargetVersionsAssignment_2_0_1_in_rule__TargetPlatform__Group_2_0__1__Impl1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0__2__Impl_in_rule__TargetPlatform__Group_2_0__21318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0_2__0_in_rule__TargetPlatform__Group_2_0__2__Impl1345 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0_2__0__Impl_in_rule__TargetPlatform__Group_2_0_2__01382 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0_2__1_in_rule__TargetPlatform__Group_2_0_2__01385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__TargetPlatform__Group_2_0_2__0__Impl1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0_2__1__Impl_in_rule__TargetPlatform__Group_2_0_2__11444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__TargetVersionsAssignment_2_0_2_1_in_rule__TargetPlatform__Group_2_0_2__1__Impl1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1__0__Impl_in_rule__TargetPlatform__Group_2_1__01505 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1__1_in_rule__TargetPlatform__Group_2_1__01508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__TargetPlatform__Group_2_1__0__Impl1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1__1__Impl_in_rule__TargetPlatform__Group_2_1__11567 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1__2_in_rule__TargetPlatform__Group_2_1__11570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__OptionsAssignment_2_1_1_in_rule__TargetPlatform__Group_2_1__1__Impl1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1__2__Impl_in_rule__TargetPlatform__Group_2_1__21627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1_2__0_in_rule__TargetPlatform__Group_2_1__2__Impl1654 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1_2__0__Impl_in_rule__TargetPlatform__Group_2_1_2__01691 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1_2__1_in_rule__TargetPlatform__Group_2_1_2__01694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__TargetPlatform__Group_2_1_2__0__Impl1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1_2__1__Impl_in_rule__TargetPlatform__Group_2_1_2__11753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__OptionsAssignment_2_1_2_1_in_rule__TargetPlatform__Group_2_1_2__1__Impl1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__0__Impl_in_rule__Location__Group__01814 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_rule__Location__Group__1_in_rule__Location__Group__01817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Location__Group__0__Impl1845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__1__Impl_in_rule__Location__Group__11876 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Location__Group__2_in_rule__Location__Group__11879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1_in_rule__Location__Group__1__Impl1906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group__2__Impl_in_rule__Location__Group__21936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0_in_rule__Location__Group__2__Impl1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__0__Impl_in_rule__Location__Group_2__02000 = new BitSet(new long[]{0x0000000012000010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1_in_rule__Location__Group_2__02003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Location__Group_2__0__Impl2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__1__Impl_in_rule__Location__Group_2__12062 = new BitSet(new long[]{0x0000000012000010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2_in_rule__Location__Group_2__12065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0_in_rule__Location__Group_2__1__Impl2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__2__Impl_in_rule__Location__Group_2__22123 = new BitSet(new long[]{0x0000000012000010L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3_in_rule__Location__Group_2__22126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_2__0_in_rule__Location__Group_2__2__Impl2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2__3__Impl_in_rule__Location__Group_2__32184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Location__Group_2__3__Impl2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__0__Impl_in_rule__Location__Group_2_1__02251 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1_in_rule__Location__Group_2_1__02254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Location__Group_2_1__0__Impl2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__1__Impl_in_rule__Location__Group_2_1__12313 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2_in_rule__Location__Group_2_1__12316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_1_in_rule__Location__Group_2_1__1__Impl2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1__2__Impl_in_rule__Location__Group_2_1__22373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0_in_rule__Location__Group_2_1__2__Impl2400 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__0__Impl_in_rule__Location__Group_2_1_2__02437 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1_in_rule__Location__Group_2_1_2__02440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Location__Group_2_1_2__0__Impl2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_1_2__1__Impl_in_rule__Location__Group_2_1_2__12499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__OptionsAssignment_2_1_2_1_in_rule__Location__Group_2_1_2__1__Impl2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_2__0__Impl_in_rule__Location__Group_2_2__02560 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Location__Group_2_2__1_in_rule__Location__Group_2_2__02563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IusAssignment_2_2_0_in_rule__Location__Group_2_2__0__Impl2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__Group_2_2__1__Impl_in_rule__Location__Group_2_2__12620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IusAssignment_2_2_1_in_rule__Location__Group_2_2__1__Impl2647 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IU__Group__0__Impl_in_rule__IU__Group__02682 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__IU__Group__1_in_rule__IU__Group__02685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__IDAssignment_0_in_rule__IU__Group__0__Impl2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group__1__Impl_in_rule__IU__Group__12742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0_in_rule__IU__Group__1__Impl2769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__0__Impl_in_rule__IU__Group_1__02804 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1_in_rule__IU__Group_1__02807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__IU__Group_1__0__Impl2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__1__Impl_in_rule__IU__Group_1__12866 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__IU__Group_1__2_in_rule__IU__Group_1__12869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__IU__Group_1__1__Impl2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__2__Impl_in_rule__IU__Group_1__22928 = new BitSet(new long[]{0x00000000000038A0L});
    public static final BitSet FOLLOW_rule__IU__Group_1__3_in_rule__IU__Group_1__22931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__IU__Group_1__2__Impl2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Group_1__3__Impl_in_rule__IU__Group_1__32990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IU__Alternatives_1_3_in_rule__IU__Group_1__3__Impl3017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03055 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3141 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03176 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__QualifiedName__Group_1__0__Impl3207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0__0__Impl_in_rule__Version__Group_0__03298 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Version__Group_0__1_in_rule__Version__Group_0__03301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_0__0__Impl3328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0__1__Impl_in_rule__Version__Group_0__13357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1__0_in_rule__Version__Group_0__1__Impl3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1__0__Impl_in_rule__Version__Group_0_1__03419 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1__1_in_rule__Version__Group_0_1__03422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Version__Group_0_1__0__Impl3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1__1__Impl_in_rule__Version__Group_0_1__13481 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1__2_in_rule__Version__Group_0_1__13484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_0_1__1__Impl3511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1__2__Impl_in_rule__Version__Group_0_1__23540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2__0_in_rule__Version__Group_0_1__2__Impl3567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2__0__Impl_in_rule__Version__Group_0_1_2__03604 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2__1_in_rule__Version__Group_0_1_2__03607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Version__Group_0_1_2__0__Impl3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2__1__Impl_in_rule__Version__Group_0_1_2__13666 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2__2_in_rule__Version__Group_0_1_2__13669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Version__Group_0_1_2__1__Impl3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2__2__Impl_in_rule__Version__Group_0_1_2__23725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2_2__0_in_rule__Version__Group_0_1_2__2__Impl3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2_2__0__Impl_in_rule__Version__Group_0_1_2_2__03789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2_2__1_in_rule__Version__Group_0_1_2_2__03792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Version__Group_0_1_2_2__0__Impl3820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Version__Group_0_1_2_2__1__Impl_in_rule__Version__Group_0_1_2_2__13851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Version__Group_0_1_2_2__1__Impl3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__0__Impl_in_rule__VersionRange__Group_0__03911 = new BitSet(new long[]{0x00000000000038E0L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__1_in_rule__VersionRange__Group_0__03914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_0_0_in_rule__VersionRange__Group_0__0__Impl3941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__1__Impl_in_rule__VersionRange__Group_0__13971 = new BitSet(new long[]{0x00000000000038E0L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__2_in_rule__VersionRange__Group_0__13974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__VersionRange__Group_0__1__Impl4002 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__2__Impl_in_rule__VersionRange__Group_0__24033 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__3_in_rule__VersionRange__Group_0__24036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__2__Impl4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__3__Impl_in_rule__VersionRange__Group_0__34092 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__4_in_rule__VersionRange__Group_0__34095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__VersionRange__Group_0__3__Impl4123 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__4__Impl_in_rule__VersionRange__Group_0__44154 = new BitSet(new long[]{0x00000000000038E0L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__5_in_rule__VersionRange__Group_0__44157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__VersionRange__Group_0__4__Impl4185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__5__Impl_in_rule__VersionRange__Group_0__54216 = new BitSet(new long[]{0x00000000000038E0L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__6_in_rule__VersionRange__Group_0__54219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__VersionRange__Group_0__5__Impl4247 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__6__Impl_in_rule__VersionRange__Group_0__64278 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__7_in_rule__VersionRange__Group_0__64281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersion_in_rule__VersionRange__Group_0__6__Impl4308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__7__Impl_in_rule__VersionRange__Group_0__74337 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__8_in_rule__VersionRange__Group_0__74340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__VersionRange__Group_0__7__Impl4368 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__VersionRange__Group_0__8__Impl_in_rule__VersionRange__Group_0__84399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionRange__Alternatives_0_8_in_rule__VersionRange__Group_0__8__Impl4426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__UnorderedGroup_2__0_in_rule__TargetPlatform__UnorderedGroup_24475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_0__0_in_rule__TargetPlatform__UnorderedGroup_2__Impl4562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__Group_2_1__0_in_rule__TargetPlatform__UnorderedGroup_2__Impl4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__UnorderedGroup_2__Impl_in_rule__TargetPlatform__UnorderedGroup_2__04712 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__UnorderedGroup_2__1_in_rule__TargetPlatform__UnorderedGroup_2__04715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TargetPlatform__UnorderedGroup_2__Impl_in_rule__TargetPlatform__UnorderedGroup_2__14740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__0_in_rule__Location__UnorderedGroup_14768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__IdAssignment_1_0_in_rule__Location__UnorderedGroup_1__Impl4857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UriAssignment_1_1_in_rule__Location__UnorderedGroup_1__Impl4948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__05007 = new BitSet(new long[]{0x0000000000000092L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__1_in_rule__Location__UnorderedGroup_1__05010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Location__UnorderedGroup_1__Impl_in_rule__Location__UnorderedGroup_1__15035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__TargetPlatform__NameAssignment_15067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetVersion_in_rule__TargetPlatform__TargetVersionsAssignment_2_0_15098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTargetVersion_in_rule__TargetPlatform__TargetVersionsAssignment_2_0_2_15129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__TargetPlatform__OptionsAssignment_2_1_15160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__TargetPlatform__OptionsAssignment_2_1_2_15191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocation_in_rule__TargetPlatform__LocationsAssignment_35222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Location__IdAssignment_1_05253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Location__UriAssignment_1_15284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_15315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOption_in_rule__Location__OptionsAssignment_2_1_2_15346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_2_05377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIU_in_rule__Location__IusAssignment_2_2_15408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__IU__IDAssignment_05439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IU__VersionAssignment_1_3_05470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionRange_in_rule__IU__VersionAssignment_1_3_15501 = new BitSet(new long[]{0x0000000000000002L});

}
