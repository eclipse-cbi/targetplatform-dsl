package org.eclipse.cbi.targetplatform.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
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
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
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
    public String getGrammarFileName() { return "InternalTargetPlatform.g"; }


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
    // InternalTargetPlatform.g:53:1: entryRuleTargetPlatform : ruleTargetPlatform EOF ;
    public final void entryRuleTargetPlatform() throws RecognitionException {
        try {
            // InternalTargetPlatform.g:54:1: ( ruleTargetPlatform EOF )
            // InternalTargetPlatform.g:55:1: ruleTargetPlatform EOF
            {
             before(grammarAccess.getTargetPlatformRule()); 
            pushFollow(FOLLOW_1);
            ruleTargetPlatform();

            state._fsp--;

             after(grammarAccess.getTargetPlatformRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:62:1: ruleTargetPlatform : ( ( rule__TargetPlatform__Group__0 )? ) ;
    public final void ruleTargetPlatform() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:66:2: ( ( ( rule__TargetPlatform__Group__0 )? ) )
            // InternalTargetPlatform.g:67:2: ( ( rule__TargetPlatform__Group__0 )? )
            {
            // InternalTargetPlatform.g:67:2: ( ( rule__TargetPlatform__Group__0 )? )
            // InternalTargetPlatform.g:68:3: ( rule__TargetPlatform__Group__0 )?
            {
             before(grammarAccess.getTargetPlatformAccess().getGroup()); 
            // InternalTargetPlatform.g:69:3: ( rule__TargetPlatform__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==21) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalTargetPlatform.g:69:4: rule__TargetPlatform__Group__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:78:1: entryRuleTargetContent : ruleTargetContent EOF ;
    public final void entryRuleTargetContent() throws RecognitionException {
        try {
            // InternalTargetPlatform.g:79:1: ( ruleTargetContent EOF )
            // InternalTargetPlatform.g:80:1: ruleTargetContent EOF
            {
             before(grammarAccess.getTargetContentRule()); 
            pushFollow(FOLLOW_1);
            ruleTargetContent();

            state._fsp--;

             after(grammarAccess.getTargetContentRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:87:1: ruleTargetContent : ( ( rule__TargetContent__Alternatives ) ) ;
    public final void ruleTargetContent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:91:2: ( ( ( rule__TargetContent__Alternatives ) ) )
            // InternalTargetPlatform.g:92:2: ( ( rule__TargetContent__Alternatives ) )
            {
            // InternalTargetPlatform.g:92:2: ( ( rule__TargetContent__Alternatives ) )
            // InternalTargetPlatform.g:93:3: ( rule__TargetContent__Alternatives )
            {
             before(grammarAccess.getTargetContentAccess().getAlternatives()); 
            // InternalTargetPlatform.g:94:3: ( rule__TargetContent__Alternatives )
            // InternalTargetPlatform.g:94:4: rule__TargetContent__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:103:1: entryRuleOptions : ruleOptions EOF ;
    public final void entryRuleOptions() throws RecognitionException {
        try {
            // InternalTargetPlatform.g:104:1: ( ruleOptions EOF )
            // InternalTargetPlatform.g:105:1: ruleOptions EOF
            {
             before(grammarAccess.getOptionsRule()); 
            pushFollow(FOLLOW_1);
            ruleOptions();

            state._fsp--;

             after(grammarAccess.getOptionsRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:112:1: ruleOptions : ( ( rule__Options__Group__0 ) ) ;
    public final void ruleOptions() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:116:2: ( ( ( rule__Options__Group__0 ) ) )
            // InternalTargetPlatform.g:117:2: ( ( rule__Options__Group__0 ) )
            {
            // InternalTargetPlatform.g:117:2: ( ( rule__Options__Group__0 ) )
            // InternalTargetPlatform.g:118:3: ( rule__Options__Group__0 )
            {
             before(grammarAccess.getOptionsAccess().getGroup()); 
            // InternalTargetPlatform.g:119:3: ( rule__Options__Group__0 )
            // InternalTargetPlatform.g:119:4: rule__Options__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:128:1: entryRuleEnvironment : ruleEnvironment EOF ;
    public final void entryRuleEnvironment() throws RecognitionException {
        try {
            // InternalTargetPlatform.g:129:1: ( ruleEnvironment EOF )
            // InternalTargetPlatform.g:130:1: ruleEnvironment EOF
            {
             before(grammarAccess.getEnvironmentRule()); 
            pushFollow(FOLLOW_1);
            ruleEnvironment();

            state._fsp--;

             after(grammarAccess.getEnvironmentRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:137:1: ruleEnvironment : ( ( rule__Environment__Group__0 ) ) ;
    public final void ruleEnvironment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:141:2: ( ( ( rule__Environment__Group__0 ) ) )
            // InternalTargetPlatform.g:142:2: ( ( rule__Environment__Group__0 ) )
            {
            // InternalTargetPlatform.g:142:2: ( ( rule__Environment__Group__0 ) )
            // InternalTargetPlatform.g:143:3: ( rule__Environment__Group__0 )
            {
             before(grammarAccess.getEnvironmentAccess().getGroup()); 
            // InternalTargetPlatform.g:144:3: ( rule__Environment__Group__0 )
            // InternalTargetPlatform.g:144:4: rule__Environment__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:153:1: entryRuleIncludeDeclaration : ruleIncludeDeclaration EOF ;
    public final void entryRuleIncludeDeclaration() throws RecognitionException {
        try {
            // InternalTargetPlatform.g:154:1: ( ruleIncludeDeclaration EOF )
            // InternalTargetPlatform.g:155:1: ruleIncludeDeclaration EOF
            {
             before(grammarAccess.getIncludeDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleIncludeDeclaration();

            state._fsp--;

             after(grammarAccess.getIncludeDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:162:1: ruleIncludeDeclaration : ( ( rule__IncludeDeclaration__Group__0 ) ) ;
    public final void ruleIncludeDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:166:2: ( ( ( rule__IncludeDeclaration__Group__0 ) ) )
            // InternalTargetPlatform.g:167:2: ( ( rule__IncludeDeclaration__Group__0 ) )
            {
            // InternalTargetPlatform.g:167:2: ( ( rule__IncludeDeclaration__Group__0 ) )
            // InternalTargetPlatform.g:168:3: ( rule__IncludeDeclaration__Group__0 )
            {
             before(grammarAccess.getIncludeDeclarationAccess().getGroup()); 
            // InternalTargetPlatform.g:169:3: ( rule__IncludeDeclaration__Group__0 )
            // InternalTargetPlatform.g:169:4: rule__IncludeDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:178:1: entryRuleLocation : ruleLocation EOF ;
    public final void entryRuleLocation() throws RecognitionException {
        try {
            // InternalTargetPlatform.g:179:1: ( ruleLocation EOF )
            // InternalTargetPlatform.g:180:1: ruleLocation EOF
            {
             before(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_1);
            ruleLocation();

            state._fsp--;

             after(grammarAccess.getLocationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:187:1: ruleLocation : ( ( rule__Location__Group__0 ) ) ;
    public final void ruleLocation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:191:2: ( ( ( rule__Location__Group__0 ) ) )
            // InternalTargetPlatform.g:192:2: ( ( rule__Location__Group__0 ) )
            {
            // InternalTargetPlatform.g:192:2: ( ( rule__Location__Group__0 ) )
            // InternalTargetPlatform.g:193:3: ( rule__Location__Group__0 )
            {
             before(grammarAccess.getLocationAccess().getGroup()); 
            // InternalTargetPlatform.g:194:3: ( rule__Location__Group__0 )
            // InternalTargetPlatform.g:194:4: rule__Location__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:203:1: entryRuleIU : ruleIU EOF ;
    public final void entryRuleIU() throws RecognitionException {
        try {
            // InternalTargetPlatform.g:204:1: ( ruleIU EOF )
            // InternalTargetPlatform.g:205:1: ruleIU EOF
            {
             before(grammarAccess.getIURule()); 
            pushFollow(FOLLOW_1);
            ruleIU();

            state._fsp--;

             after(grammarAccess.getIURule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:212:1: ruleIU : ( ( rule__IU__Group__0 ) ) ;
    public final void ruleIU() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:216:2: ( ( ( rule__IU__Group__0 ) ) )
            // InternalTargetPlatform.g:217:2: ( ( rule__IU__Group__0 ) )
            {
            // InternalTargetPlatform.g:217:2: ( ( rule__IU__Group__0 ) )
            // InternalTargetPlatform.g:218:3: ( rule__IU__Group__0 )
            {
             before(grammarAccess.getIUAccess().getGroup()); 
            // InternalTargetPlatform.g:219:3: ( rule__IU__Group__0 )
            // InternalTargetPlatform.g:219:4: rule__IU__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:228:1: entryRuleVersion : ruleVersion EOF ;
    public final void entryRuleVersion() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalTargetPlatform.g:232:1: ( ruleVersion EOF )
            // InternalTargetPlatform.g:233:1: ruleVersion EOF
            {
             before(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_1);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:243:1: ruleVersion : ( ( rule__Version__Group__0 ) ) ;
    public final void ruleVersion() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:248:2: ( ( ( rule__Version__Group__0 ) ) )
            // InternalTargetPlatform.g:249:2: ( ( rule__Version__Group__0 ) )
            {
            // InternalTargetPlatform.g:249:2: ( ( rule__Version__Group__0 ) )
            // InternalTargetPlatform.g:250:3: ( rule__Version__Group__0 )
            {
             before(grammarAccess.getVersionAccess().getGroup()); 
            // InternalTargetPlatform.g:251:3: ( rule__Version__Group__0 )
            // InternalTargetPlatform.g:251:4: rule__Version__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:261:1: entryRuleVersionRange : ruleVersionRange EOF ;
    public final void entryRuleVersionRange() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalTargetPlatform.g:265:1: ( ruleVersionRange EOF )
            // InternalTargetPlatform.g:266:1: ruleVersionRange EOF
            {
             before(grammarAccess.getVersionRangeRule()); 
            pushFollow(FOLLOW_1);
            ruleVersionRange();

            state._fsp--;

             after(grammarAccess.getVersionRangeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTargetPlatform.g:276:1: ruleVersionRange : ( ( rule__VersionRange__Alternatives ) ) ;
    public final void ruleVersionRange() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:281:2: ( ( ( rule__VersionRange__Alternatives ) ) )
            // InternalTargetPlatform.g:282:2: ( ( rule__VersionRange__Alternatives ) )
            {
            // InternalTargetPlatform.g:282:2: ( ( rule__VersionRange__Alternatives ) )
            // InternalTargetPlatform.g:283:3: ( rule__VersionRange__Alternatives )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives()); 
            // InternalTargetPlatform.g:284:3: ( rule__VersionRange__Alternatives )
            // InternalTargetPlatform.g:284:4: rule__VersionRange__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:294:1: ruleOption : ( ( rule__Option__Alternatives ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:298:1: ( ( ( rule__Option__Alternatives ) ) )
            // InternalTargetPlatform.g:299:2: ( ( rule__Option__Alternatives ) )
            {
            // InternalTargetPlatform.g:299:2: ( ( rule__Option__Alternatives ) )
            // InternalTargetPlatform.g:300:3: ( rule__Option__Alternatives )
            {
             before(grammarAccess.getOptionAccess().getAlternatives()); 
            // InternalTargetPlatform.g:301:3: ( rule__Option__Alternatives )
            // InternalTargetPlatform.g:301:4: rule__Option__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:309:1: rule__TargetContent__Alternatives : ( ( ruleOptions ) | ( ruleEnvironment ) | ( ruleIncludeDeclaration ) | ( ruleLocation ) );
    public final void rule__TargetContent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:313:1: ( ( ruleOptions ) | ( ruleEnvironment ) | ( ruleIncludeDeclaration ) | ( ruleLocation ) )
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
                    // InternalTargetPlatform.g:314:2: ( ruleOptions )
                    {
                    // InternalTargetPlatform.g:314:2: ( ruleOptions )
                    // InternalTargetPlatform.g:315:3: ruleOptions
                    {
                     before(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleOptions();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getOptionsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:320:2: ( ruleEnvironment )
                    {
                    // InternalTargetPlatform.g:320:2: ( ruleEnvironment )
                    // InternalTargetPlatform.g:321:3: ruleEnvironment
                    {
                     before(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEnvironment();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getEnvironmentParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTargetPlatform.g:326:2: ( ruleIncludeDeclaration )
                    {
                    // InternalTargetPlatform.g:326:2: ( ruleIncludeDeclaration )
                    // InternalTargetPlatform.g:327:3: ruleIncludeDeclaration
                    {
                     before(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleIncludeDeclaration();

                    state._fsp--;

                     after(grammarAccess.getTargetContentAccess().getIncludeDeclarationParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTargetPlatform.g:332:2: ( ruleLocation )
                    {
                    // InternalTargetPlatform.g:332:2: ( ruleLocation )
                    // InternalTargetPlatform.g:333:3: ruleLocation
                    {
                     before(grammarAccess.getTargetContentAccess().getLocationParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:342:1: rule__IU__Alternatives_1_1 : ( ( ( rule__IU__VersionAssignment_1_1_0 ) ) | ( ( rule__IU__VersionAssignment_1_1_1 ) ) );
    public final void rule__IU__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:346:1: ( ( ( rule__IU__VersionAssignment_1_1_0 ) ) | ( ( rule__IU__VersionAssignment_1_1_1 ) ) )
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
                    // InternalTargetPlatform.g:347:2: ( ( rule__IU__VersionAssignment_1_1_0 ) )
                    {
                    // InternalTargetPlatform.g:347:2: ( ( rule__IU__VersionAssignment_1_1_0 ) )
                    // InternalTargetPlatform.g:348:3: ( rule__IU__VersionAssignment_1_1_0 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_1_0()); 
                    // InternalTargetPlatform.g:349:3: ( rule__IU__VersionAssignment_1_1_0 )
                    // InternalTargetPlatform.g:349:4: rule__IU__VersionAssignment_1_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IU__VersionAssignment_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIUAccess().getVersionAssignment_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:353:2: ( ( rule__IU__VersionAssignment_1_1_1 ) )
                    {
                    // InternalTargetPlatform.g:353:2: ( ( rule__IU__VersionAssignment_1_1_1 ) )
                    // InternalTargetPlatform.g:354:3: ( rule__IU__VersionAssignment_1_1_1 )
                    {
                     before(grammarAccess.getIUAccess().getVersionAssignment_1_1_1()); 
                    // InternalTargetPlatform.g:355:3: ( rule__IU__VersionAssignment_1_1_1 )
                    // InternalTargetPlatform.g:355:4: rule__IU__VersionAssignment_1_1_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:363:1: rule__Version__Alternatives_1_2_2_1 : ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_QUALIFIER ) );
    public final void rule__Version__Alternatives_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:367:1: ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_QUALIFIER ) )
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
                    // InternalTargetPlatform.g:368:2: ( RULE_ID )
                    {
                    // InternalTargetPlatform.g:368:2: ( RULE_ID )
                    // InternalTargetPlatform.g:369:3: RULE_ID
                    {
                     before(grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getVersionAccess().getIDTerminalRuleCall_1_2_2_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:374:2: ( RULE_INT )
                    {
                    // InternalTargetPlatform.g:374:2: ( RULE_INT )
                    // InternalTargetPlatform.g:375:3: RULE_INT
                    {
                     before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_2_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTargetPlatform.g:380:2: ( RULE_QUALIFIER )
                    {
                    // InternalTargetPlatform.g:380:2: ( RULE_QUALIFIER )
                    // InternalTargetPlatform.g:381:3: RULE_QUALIFIER
                    {
                     before(grammarAccess.getVersionAccess().getQUALIFIERTerminalRuleCall_1_2_2_1_2()); 
                    match(input,RULE_QUALIFIER,FOLLOW_2); 
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
    // InternalTargetPlatform.g:390:1: rule__VersionRange__Alternatives : ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) | ( 'lazy' ) );
    public final void rule__VersionRange__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:394:1: ( ( ( rule__VersionRange__Group_0__0 ) ) | ( ruleVersion ) | ( 'lazy' ) )
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
                    // InternalTargetPlatform.g:395:2: ( ( rule__VersionRange__Group_0__0 ) )
                    {
                    // InternalTargetPlatform.g:395:2: ( ( rule__VersionRange__Group_0__0 ) )
                    // InternalTargetPlatform.g:396:3: ( rule__VersionRange__Group_0__0 )
                    {
                     before(grammarAccess.getVersionRangeAccess().getGroup_0()); 
                    // InternalTargetPlatform.g:397:3: ( rule__VersionRange__Group_0__0 )
                    // InternalTargetPlatform.g:397:4: rule__VersionRange__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VersionRange__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionRangeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:401:2: ( ruleVersion )
                    {
                    // InternalTargetPlatform.g:401:2: ( ruleVersion )
                    // InternalTargetPlatform.g:402:3: ruleVersion
                    {
                     before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVersion();

                    state._fsp--;

                     after(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTargetPlatform.g:407:2: ( 'lazy' )
                    {
                    // InternalTargetPlatform.g:407:2: ( 'lazy' )
                    // InternalTargetPlatform.g:408:3: 'lazy'
                    {
                     before(grammarAccess.getVersionRangeAccess().getLazyKeyword_2()); 
                    match(input,12,FOLLOW_2); 
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
    // InternalTargetPlatform.g:417:1: rule__VersionRange__Alternatives_0_0 : ( ( '(' ) | ( '[' ) );
    public final void rule__VersionRange__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:421:1: ( ( '(' ) | ( '[' ) )
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
                    // InternalTargetPlatform.g:422:2: ( '(' )
                    {
                    // InternalTargetPlatform.g:422:2: ( '(' )
                    // InternalTargetPlatform.g:423:3: '('
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:428:2: ( '[' )
                    {
                    // InternalTargetPlatform.g:428:2: ( '[' )
                    // InternalTargetPlatform.g:429:3: '['
                    {
                     before(grammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1()); 
                    match(input,14,FOLLOW_2); 
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
    // InternalTargetPlatform.g:438:1: rule__VersionRange__Alternatives_0_4 : ( ( ')' ) | ( ']' ) );
    public final void rule__VersionRange__Alternatives_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:442:1: ( ( ')' ) | ( ']' ) )
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
                    // InternalTargetPlatform.g:443:2: ( ')' )
                    {
                    // InternalTargetPlatform.g:443:2: ( ')' )
                    // InternalTargetPlatform.g:444:3: ')'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:449:2: ( ']' )
                    {
                    // InternalTargetPlatform.g:449:2: ( ']' )
                    // InternalTargetPlatform.g:450:3: ']'
                    {
                     before(grammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1()); 
                    match(input,16,FOLLOW_2); 
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
    // InternalTargetPlatform.g:459:1: rule__Option__Alternatives : ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) );
    public final void rule__Option__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:463:1: ( ( ( 'requirements' ) ) | ( ( 'allEnvironments' ) ) | ( ( 'source' ) ) | ( ( 'configurePhase' ) ) )
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
                    // InternalTargetPlatform.g:464:2: ( ( 'requirements' ) )
                    {
                    // InternalTargetPlatform.g:464:2: ( ( 'requirements' ) )
                    // InternalTargetPlatform.g:465:3: ( 'requirements' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 
                    // InternalTargetPlatform.g:466:3: ( 'requirements' )
                    // InternalTargetPlatform.g:466:4: 'requirements'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_REQUIREDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:470:2: ( ( 'allEnvironments' ) )
                    {
                    // InternalTargetPlatform.g:470:2: ( ( 'allEnvironments' ) )
                    // InternalTargetPlatform.g:471:3: ( 'allEnvironments' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 
                    // InternalTargetPlatform.g:472:3: ( 'allEnvironments' )
                    // InternalTargetPlatform.g:472:4: 'allEnvironments'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_ALL_ENVIRONMENTSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTargetPlatform.g:476:2: ( ( 'source' ) )
                    {
                    // InternalTargetPlatform.g:476:2: ( ( 'source' ) )
                    // InternalTargetPlatform.g:477:3: ( 'source' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 
                    // InternalTargetPlatform.g:478:3: ( 'source' )
                    // InternalTargetPlatform.g:478:4: 'source'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getOptionAccess().getINCLUDE_SOURCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTargetPlatform.g:482:2: ( ( 'configurePhase' ) )
                    {
                    // InternalTargetPlatform.g:482:2: ( ( 'configurePhase' ) )
                    // InternalTargetPlatform.g:483:3: ( 'configurePhase' )
                    {
                     before(grammarAccess.getOptionAccess().getINCLUDE_CONFIGURE_PHASEEnumLiteralDeclaration_3()); 
                    // InternalTargetPlatform.g:484:3: ( 'configurePhase' )
                    // InternalTargetPlatform.g:484:4: 'configurePhase'
                    {
                    match(input,20,FOLLOW_2); 

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
    // InternalTargetPlatform.g:492:1: rule__TargetPlatform__Group__0 : rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 ;
    public final void rule__TargetPlatform__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:496:1: ( rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1 )
            // InternalTargetPlatform.g:497:2: rule__TargetPlatform__Group__0__Impl rule__TargetPlatform__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__TargetPlatform__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:504:1: rule__TargetPlatform__Group__0__Impl : ( 'target' ) ;
    public final void rule__TargetPlatform__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:508:1: ( ( 'target' ) )
            // InternalTargetPlatform.g:509:1: ( 'target' )
            {
            // InternalTargetPlatform.g:509:1: ( 'target' )
            // InternalTargetPlatform.g:510:2: 'target'
            {
             before(grammarAccess.getTargetPlatformAccess().getTargetKeyword_0()); 
            match(input,21,FOLLOW_2); 
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
    // InternalTargetPlatform.g:519:1: rule__TargetPlatform__Group__1 : rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 ;
    public final void rule__TargetPlatform__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:523:1: ( rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2 )
            // InternalTargetPlatform.g:524:2: rule__TargetPlatform__Group__1__Impl rule__TargetPlatform__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__TargetPlatform__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:531:1: rule__TargetPlatform__Group__1__Impl : ( ( rule__TargetPlatform__NameAssignment_1 ) ) ;
    public final void rule__TargetPlatform__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:535:1: ( ( ( rule__TargetPlatform__NameAssignment_1 ) ) )
            // InternalTargetPlatform.g:536:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            {
            // InternalTargetPlatform.g:536:1: ( ( rule__TargetPlatform__NameAssignment_1 ) )
            // InternalTargetPlatform.g:537:2: ( rule__TargetPlatform__NameAssignment_1 )
            {
             before(grammarAccess.getTargetPlatformAccess().getNameAssignment_1()); 
            // InternalTargetPlatform.g:538:2: ( rule__TargetPlatform__NameAssignment_1 )
            // InternalTargetPlatform.g:538:3: rule__TargetPlatform__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:546:1: rule__TargetPlatform__Group__2 : rule__TargetPlatform__Group__2__Impl ;
    public final void rule__TargetPlatform__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:550:1: ( rule__TargetPlatform__Group__2__Impl )
            // InternalTargetPlatform.g:551:2: rule__TargetPlatform__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:557:1: rule__TargetPlatform__Group__2__Impl : ( ( rule__TargetPlatform__ContentsAssignment_2 )* ) ;
    public final void rule__TargetPlatform__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:561:1: ( ( ( rule__TargetPlatform__ContentsAssignment_2 )* ) )
            // InternalTargetPlatform.g:562:1: ( ( rule__TargetPlatform__ContentsAssignment_2 )* )
            {
            // InternalTargetPlatform.g:562:1: ( ( rule__TargetPlatform__ContentsAssignment_2 )* )
            // InternalTargetPlatform.g:563:2: ( rule__TargetPlatform__ContentsAssignment_2 )*
            {
             before(grammarAccess.getTargetPlatformAccess().getContentsAssignment_2()); 
            // InternalTargetPlatform.g:564:2: ( rule__TargetPlatform__ContentsAssignment_2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22||(LA9_0>=24 && LA9_0<=26)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalTargetPlatform.g:564:3: rule__TargetPlatform__ContentsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
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
    // InternalTargetPlatform.g:573:1: rule__Options__Group__0 : rule__Options__Group__0__Impl rule__Options__Group__1 ;
    public final void rule__Options__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:577:1: ( rule__Options__Group__0__Impl rule__Options__Group__1 )
            // InternalTargetPlatform.g:578:2: rule__Options__Group__0__Impl rule__Options__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Options__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:585:1: rule__Options__Group__0__Impl : ( 'with' ) ;
    public final void rule__Options__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:589:1: ( ( 'with' ) )
            // InternalTargetPlatform.g:590:1: ( 'with' )
            {
            // InternalTargetPlatform.g:590:1: ( 'with' )
            // InternalTargetPlatform.g:591:2: 'with'
            {
             before(grammarAccess.getOptionsAccess().getWithKeyword_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalTargetPlatform.g:600:1: rule__Options__Group__1 : rule__Options__Group__1__Impl rule__Options__Group__2 ;
    public final void rule__Options__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:604:1: ( rule__Options__Group__1__Impl rule__Options__Group__2 )
            // InternalTargetPlatform.g:605:2: rule__Options__Group__1__Impl rule__Options__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Options__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:612:1: rule__Options__Group__1__Impl : ( ( rule__Options__OptionsAssignment_1 ) ) ;
    public final void rule__Options__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:616:1: ( ( ( rule__Options__OptionsAssignment_1 ) ) )
            // InternalTargetPlatform.g:617:1: ( ( rule__Options__OptionsAssignment_1 ) )
            {
            // InternalTargetPlatform.g:617:1: ( ( rule__Options__OptionsAssignment_1 ) )
            // InternalTargetPlatform.g:618:2: ( rule__Options__OptionsAssignment_1 )
            {
             before(grammarAccess.getOptionsAccess().getOptionsAssignment_1()); 
            // InternalTargetPlatform.g:619:2: ( rule__Options__OptionsAssignment_1 )
            // InternalTargetPlatform.g:619:3: rule__Options__OptionsAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:627:1: rule__Options__Group__2 : rule__Options__Group__2__Impl ;
    public final void rule__Options__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:631:1: ( rule__Options__Group__2__Impl )
            // InternalTargetPlatform.g:632:2: rule__Options__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:638:1: rule__Options__Group__2__Impl : ( ( rule__Options__Group_2__0 )* ) ;
    public final void rule__Options__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:642:1: ( ( ( rule__Options__Group_2__0 )* ) )
            // InternalTargetPlatform.g:643:1: ( ( rule__Options__Group_2__0 )* )
            {
            // InternalTargetPlatform.g:643:1: ( ( rule__Options__Group_2__0 )* )
            // InternalTargetPlatform.g:644:2: ( rule__Options__Group_2__0 )*
            {
             before(grammarAccess.getOptionsAccess().getGroup_2()); 
            // InternalTargetPlatform.g:645:2: ( rule__Options__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=17 && LA10_0<=20)||LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTargetPlatform.g:645:3: rule__Options__Group_2__0
            	    {
            	    pushFollow(FOLLOW_8);
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
    // InternalTargetPlatform.g:654:1: rule__Options__Group_2__0 : rule__Options__Group_2__0__Impl rule__Options__Group_2__1 ;
    public final void rule__Options__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:658:1: ( rule__Options__Group_2__0__Impl rule__Options__Group_2__1 )
            // InternalTargetPlatform.g:659:2: rule__Options__Group_2__0__Impl rule__Options__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__Options__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:666:1: rule__Options__Group_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__Options__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:670:1: ( ( ( ',' )? ) )
            // InternalTargetPlatform.g:671:1: ( ( ',' )? )
            {
            // InternalTargetPlatform.g:671:1: ( ( ',' )? )
            // InternalTargetPlatform.g:672:2: ( ',' )?
            {
             before(grammarAccess.getOptionsAccess().getCommaKeyword_2_0()); 
            // InternalTargetPlatform.g:673:2: ( ',' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTargetPlatform.g:673:3: ','
                    {
                    match(input,23,FOLLOW_2); 

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
    // InternalTargetPlatform.g:681:1: rule__Options__Group_2__1 : rule__Options__Group_2__1__Impl ;
    public final void rule__Options__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:685:1: ( rule__Options__Group_2__1__Impl )
            // InternalTargetPlatform.g:686:2: rule__Options__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:692:1: rule__Options__Group_2__1__Impl : ( ( rule__Options__OptionsAssignment_2_1 ) ) ;
    public final void rule__Options__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:696:1: ( ( ( rule__Options__OptionsAssignment_2_1 ) ) )
            // InternalTargetPlatform.g:697:1: ( ( rule__Options__OptionsAssignment_2_1 ) )
            {
            // InternalTargetPlatform.g:697:1: ( ( rule__Options__OptionsAssignment_2_1 ) )
            // InternalTargetPlatform.g:698:2: ( rule__Options__OptionsAssignment_2_1 )
            {
             before(grammarAccess.getOptionsAccess().getOptionsAssignment_2_1()); 
            // InternalTargetPlatform.g:699:2: ( rule__Options__OptionsAssignment_2_1 )
            // InternalTargetPlatform.g:699:3: rule__Options__OptionsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:708:1: rule__Environment__Group__0 : rule__Environment__Group__0__Impl rule__Environment__Group__1 ;
    public final void rule__Environment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:712:1: ( rule__Environment__Group__0__Impl rule__Environment__Group__1 )
            // InternalTargetPlatform.g:713:2: rule__Environment__Group__0__Impl rule__Environment__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Environment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:720:1: rule__Environment__Group__0__Impl : ( () ) ;
    public final void rule__Environment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:724:1: ( ( () ) )
            // InternalTargetPlatform.g:725:1: ( () )
            {
            // InternalTargetPlatform.g:725:1: ( () )
            // InternalTargetPlatform.g:726:2: ()
            {
             before(grammarAccess.getEnvironmentAccess().getEnvironmentAction_0()); 
            // InternalTargetPlatform.g:727:2: ()
            // InternalTargetPlatform.g:727:3: 
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
    // InternalTargetPlatform.g:735:1: rule__Environment__Group__1 : rule__Environment__Group__1__Impl rule__Environment__Group__2 ;
    public final void rule__Environment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:739:1: ( rule__Environment__Group__1__Impl rule__Environment__Group__2 )
            // InternalTargetPlatform.g:740:2: rule__Environment__Group__1__Impl rule__Environment__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Environment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:747:1: rule__Environment__Group__1__Impl : ( 'environment' ) ;
    public final void rule__Environment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:751:1: ( ( 'environment' ) )
            // InternalTargetPlatform.g:752:1: ( 'environment' )
            {
            // InternalTargetPlatform.g:752:1: ( 'environment' )
            // InternalTargetPlatform.g:753:2: 'environment'
            {
             before(grammarAccess.getEnvironmentAccess().getEnvironmentKeyword_1()); 
            match(input,24,FOLLOW_2); 
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
    // InternalTargetPlatform.g:762:1: rule__Environment__Group__2 : rule__Environment__Group__2__Impl rule__Environment__Group__3 ;
    public final void rule__Environment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:766:1: ( rule__Environment__Group__2__Impl rule__Environment__Group__3 )
            // InternalTargetPlatform.g:767:2: rule__Environment__Group__2__Impl rule__Environment__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__Environment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:774:1: rule__Environment__Group__2__Impl : ( ( rule__Environment__EnvAssignment_2 ) ) ;
    public final void rule__Environment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:778:1: ( ( ( rule__Environment__EnvAssignment_2 ) ) )
            // InternalTargetPlatform.g:779:1: ( ( rule__Environment__EnvAssignment_2 ) )
            {
            // InternalTargetPlatform.g:779:1: ( ( rule__Environment__EnvAssignment_2 ) )
            // InternalTargetPlatform.g:780:2: ( rule__Environment__EnvAssignment_2 )
            {
             before(grammarAccess.getEnvironmentAccess().getEnvAssignment_2()); 
            // InternalTargetPlatform.g:781:2: ( rule__Environment__EnvAssignment_2 )
            // InternalTargetPlatform.g:781:3: rule__Environment__EnvAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:789:1: rule__Environment__Group__3 : rule__Environment__Group__3__Impl ;
    public final void rule__Environment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:793:1: ( rule__Environment__Group__3__Impl )
            // InternalTargetPlatform.g:794:2: rule__Environment__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:800:1: rule__Environment__Group__3__Impl : ( ( rule__Environment__Group_3__0 )* ) ;
    public final void rule__Environment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:804:1: ( ( ( rule__Environment__Group_3__0 )* ) )
            // InternalTargetPlatform.g:805:1: ( ( rule__Environment__Group_3__0 )* )
            {
            // InternalTargetPlatform.g:805:1: ( ( rule__Environment__Group_3__0 )* )
            // InternalTargetPlatform.g:806:2: ( rule__Environment__Group_3__0 )*
            {
             before(grammarAccess.getEnvironmentAccess().getGroup_3()); 
            // InternalTargetPlatform.g:807:2: ( rule__Environment__Group_3__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalTargetPlatform.g:807:3: rule__Environment__Group_3__0
            	    {
            	    pushFollow(FOLLOW_12);
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
    // InternalTargetPlatform.g:816:1: rule__Environment__Group_3__0 : rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1 ;
    public final void rule__Environment__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:820:1: ( rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1 )
            // InternalTargetPlatform.g:821:2: rule__Environment__Group_3__0__Impl rule__Environment__Group_3__1
            {
            pushFollow(FOLLOW_11);
            rule__Environment__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:828:1: rule__Environment__Group_3__0__Impl : ( ( ',' )? ) ;
    public final void rule__Environment__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:832:1: ( ( ( ',' )? ) )
            // InternalTargetPlatform.g:833:1: ( ( ',' )? )
            {
            // InternalTargetPlatform.g:833:1: ( ( ',' )? )
            // InternalTargetPlatform.g:834:2: ( ',' )?
            {
             before(grammarAccess.getEnvironmentAccess().getCommaKeyword_3_0()); 
            // InternalTargetPlatform.g:835:2: ( ',' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTargetPlatform.g:835:3: ','
                    {
                    match(input,23,FOLLOW_2); 

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
    // InternalTargetPlatform.g:843:1: rule__Environment__Group_3__1 : rule__Environment__Group_3__1__Impl ;
    public final void rule__Environment__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:847:1: ( rule__Environment__Group_3__1__Impl )
            // InternalTargetPlatform.g:848:2: rule__Environment__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:854:1: rule__Environment__Group_3__1__Impl : ( ( rule__Environment__EnvAssignment_3_1 ) ) ;
    public final void rule__Environment__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:858:1: ( ( ( rule__Environment__EnvAssignment_3_1 ) ) )
            // InternalTargetPlatform.g:859:1: ( ( rule__Environment__EnvAssignment_3_1 ) )
            {
            // InternalTargetPlatform.g:859:1: ( ( rule__Environment__EnvAssignment_3_1 ) )
            // InternalTargetPlatform.g:860:2: ( rule__Environment__EnvAssignment_3_1 )
            {
             before(grammarAccess.getEnvironmentAccess().getEnvAssignment_3_1()); 
            // InternalTargetPlatform.g:861:2: ( rule__Environment__EnvAssignment_3_1 )
            // InternalTargetPlatform.g:861:3: rule__Environment__EnvAssignment_3_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:870:1: rule__IncludeDeclaration__Group__0 : rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1 ;
    public final void rule__IncludeDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:874:1: ( rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1 )
            // InternalTargetPlatform.g:875:2: rule__IncludeDeclaration__Group__0__Impl rule__IncludeDeclaration__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__IncludeDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:882:1: rule__IncludeDeclaration__Group__0__Impl : ( 'include' ) ;
    public final void rule__IncludeDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:886:1: ( ( 'include' ) )
            // InternalTargetPlatform.g:887:1: ( 'include' )
            {
            // InternalTargetPlatform.g:887:1: ( 'include' )
            // InternalTargetPlatform.g:888:2: 'include'
            {
             before(grammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalTargetPlatform.g:897:1: rule__IncludeDeclaration__Group__1 : rule__IncludeDeclaration__Group__1__Impl ;
    public final void rule__IncludeDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:901:1: ( rule__IncludeDeclaration__Group__1__Impl )
            // InternalTargetPlatform.g:902:2: rule__IncludeDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:908:1: rule__IncludeDeclaration__Group__1__Impl : ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) ) ;
    public final void rule__IncludeDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:912:1: ( ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) ) )
            // InternalTargetPlatform.g:913:1: ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) )
            {
            // InternalTargetPlatform.g:913:1: ( ( rule__IncludeDeclaration__ImportURIAssignment_1 ) )
            // InternalTargetPlatform.g:914:2: ( rule__IncludeDeclaration__ImportURIAssignment_1 )
            {
             before(grammarAccess.getIncludeDeclarationAccess().getImportURIAssignment_1()); 
            // InternalTargetPlatform.g:915:2: ( rule__IncludeDeclaration__ImportURIAssignment_1 )
            // InternalTargetPlatform.g:915:3: rule__IncludeDeclaration__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:924:1: rule__Location__Group__0 : rule__Location__Group__0__Impl rule__Location__Group__1 ;
    public final void rule__Location__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:928:1: ( rule__Location__Group__0__Impl rule__Location__Group__1 )
            // InternalTargetPlatform.g:929:2: rule__Location__Group__0__Impl rule__Location__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__Location__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:936:1: rule__Location__Group__0__Impl : ( 'location' ) ;
    public final void rule__Location__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:940:1: ( ( 'location' ) )
            // InternalTargetPlatform.g:941:1: ( 'location' )
            {
            // InternalTargetPlatform.g:941:1: ( 'location' )
            // InternalTargetPlatform.g:942:2: 'location'
            {
             before(grammarAccess.getLocationAccess().getLocationKeyword_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalTargetPlatform.g:951:1: rule__Location__Group__1 : rule__Location__Group__1__Impl rule__Location__Group__2 ;
    public final void rule__Location__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:955:1: ( rule__Location__Group__1__Impl rule__Location__Group__2 )
            // InternalTargetPlatform.g:956:2: rule__Location__Group__1__Impl rule__Location__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Location__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:963:1: rule__Location__Group__1__Impl : ( ( rule__Location__UnorderedGroup_1 ) ) ;
    public final void rule__Location__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:967:1: ( ( ( rule__Location__UnorderedGroup_1 ) ) )
            // InternalTargetPlatform.g:968:1: ( ( rule__Location__UnorderedGroup_1 ) )
            {
            // InternalTargetPlatform.g:968:1: ( ( rule__Location__UnorderedGroup_1 ) )
            // InternalTargetPlatform.g:969:2: ( rule__Location__UnorderedGroup_1 )
            {
             before(grammarAccess.getLocationAccess().getUnorderedGroup_1()); 
            // InternalTargetPlatform.g:970:2: ( rule__Location__UnorderedGroup_1 )
            // InternalTargetPlatform.g:970:3: rule__Location__UnorderedGroup_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:978:1: rule__Location__Group__2 : rule__Location__Group__2__Impl ;
    public final void rule__Location__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:982:1: ( rule__Location__Group__2__Impl )
            // InternalTargetPlatform.g:983:2: rule__Location__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:989:1: rule__Location__Group__2__Impl : ( ( rule__Location__Group_2__0 )? ) ;
    public final void rule__Location__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:993:1: ( ( ( rule__Location__Group_2__0 )? ) )
            // InternalTargetPlatform.g:994:1: ( ( rule__Location__Group_2__0 )? )
            {
            // InternalTargetPlatform.g:994:1: ( ( rule__Location__Group_2__0 )? )
            // InternalTargetPlatform.g:995:2: ( rule__Location__Group_2__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2()); 
            // InternalTargetPlatform.g:996:2: ( rule__Location__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTargetPlatform.g:996:3: rule__Location__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1005:1: rule__Location__Group_2__0 : rule__Location__Group_2__0__Impl rule__Location__Group_2__1 ;
    public final void rule__Location__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1009:1: ( rule__Location__Group_2__0__Impl rule__Location__Group_2__1 )
            // InternalTargetPlatform.g:1010:2: rule__Location__Group_2__0__Impl rule__Location__Group_2__1
            {
            pushFollow(FOLLOW_15);
            rule__Location__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1017:1: rule__Location__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Location__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1021:1: ( ( '{' ) )
            // InternalTargetPlatform.g:1022:1: ( '{' )
            {
            // InternalTargetPlatform.g:1022:1: ( '{' )
            // InternalTargetPlatform.g:1023:2: '{'
            {
             before(grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1032:1: rule__Location__Group_2__1 : rule__Location__Group_2__1__Impl rule__Location__Group_2__2 ;
    public final void rule__Location__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1036:1: ( rule__Location__Group_2__1__Impl rule__Location__Group_2__2 )
            // InternalTargetPlatform.g:1037:2: rule__Location__Group_2__1__Impl rule__Location__Group_2__2
            {
            pushFollow(FOLLOW_15);
            rule__Location__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1044:1: rule__Location__Group_2__1__Impl : ( ( rule__Location__Group_2_1__0 )? ) ;
    public final void rule__Location__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1048:1: ( ( ( rule__Location__Group_2_1__0 )? ) )
            // InternalTargetPlatform.g:1049:1: ( ( rule__Location__Group_2_1__0 )? )
            {
            // InternalTargetPlatform.g:1049:1: ( ( rule__Location__Group_2_1__0 )? )
            // InternalTargetPlatform.g:1050:2: ( rule__Location__Group_2_1__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1()); 
            // InternalTargetPlatform.g:1051:2: ( rule__Location__Group_2_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTargetPlatform.g:1051:3: rule__Location__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1059:1: rule__Location__Group_2__2 : rule__Location__Group_2__2__Impl rule__Location__Group_2__3 ;
    public final void rule__Location__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1063:1: ( rule__Location__Group_2__2__Impl rule__Location__Group_2__3 )
            // InternalTargetPlatform.g:1064:2: rule__Location__Group_2__2__Impl rule__Location__Group_2__3
            {
            pushFollow(FOLLOW_15);
            rule__Location__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1071:1: rule__Location__Group_2__2__Impl : ( ( rule__Location__IusAssignment_2_2 )* ) ;
    public final void rule__Location__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1075:1: ( ( ( rule__Location__IusAssignment_2_2 )* ) )
            // InternalTargetPlatform.g:1076:1: ( ( rule__Location__IusAssignment_2_2 )* )
            {
            // InternalTargetPlatform.g:1076:1: ( ( rule__Location__IusAssignment_2_2 )* )
            // InternalTargetPlatform.g:1077:2: ( rule__Location__IusAssignment_2_2 )*
            {
             before(grammarAccess.getLocationAccess().getIusAssignment_2_2()); 
            // InternalTargetPlatform.g:1078:2: ( rule__Location__IusAssignment_2_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTargetPlatform.g:1078:3: rule__Location__IusAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_16);
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
    // InternalTargetPlatform.g:1086:1: rule__Location__Group_2__3 : rule__Location__Group_2__3__Impl ;
    public final void rule__Location__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1090:1: ( rule__Location__Group_2__3__Impl )
            // InternalTargetPlatform.g:1091:2: rule__Location__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1097:1: rule__Location__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Location__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1101:1: ( ( '}' ) )
            // InternalTargetPlatform.g:1102:1: ( '}' )
            {
            // InternalTargetPlatform.g:1102:1: ( '}' )
            // InternalTargetPlatform.g:1103:2: '}'
            {
             before(grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,28,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1113:1: rule__Location__Group_2_1__0 : rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 ;
    public final void rule__Location__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1117:1: ( rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1 )
            // InternalTargetPlatform.g:1118:2: rule__Location__Group_2_1__0__Impl rule__Location__Group_2_1__1
            {
            pushFollow(FOLLOW_6);
            rule__Location__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1125:1: rule__Location__Group_2_1__0__Impl : ( 'with' ) ;
    public final void rule__Location__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1129:1: ( ( 'with' ) )
            // InternalTargetPlatform.g:1130:1: ( 'with' )
            {
            // InternalTargetPlatform.g:1130:1: ( 'with' )
            // InternalTargetPlatform.g:1131:2: 'with'
            {
             before(grammarAccess.getLocationAccess().getWithKeyword_2_1_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1140:1: rule__Location__Group_2_1__1 : rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 ;
    public final void rule__Location__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1144:1: ( rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2 )
            // InternalTargetPlatform.g:1145:2: rule__Location__Group_2_1__1__Impl rule__Location__Group_2_1__2
            {
            pushFollow(FOLLOW_7);
            rule__Location__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1152:1: rule__Location__Group_2_1__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_1 ) ) ;
    public final void rule__Location__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1156:1: ( ( ( rule__Location__OptionsAssignment_2_1_1 ) ) )
            // InternalTargetPlatform.g:1157:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            {
            // InternalTargetPlatform.g:1157:1: ( ( rule__Location__OptionsAssignment_2_1_1 ) )
            // InternalTargetPlatform.g:1158:2: ( rule__Location__OptionsAssignment_2_1_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_1()); 
            // InternalTargetPlatform.g:1159:2: ( rule__Location__OptionsAssignment_2_1_1 )
            // InternalTargetPlatform.g:1159:3: rule__Location__OptionsAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1167:1: rule__Location__Group_2_1__2 : rule__Location__Group_2_1__2__Impl ;
    public final void rule__Location__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1171:1: ( rule__Location__Group_2_1__2__Impl )
            // InternalTargetPlatform.g:1172:2: rule__Location__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1178:1: rule__Location__Group_2_1__2__Impl : ( ( rule__Location__Group_2_1_2__0 )* ) ;
    public final void rule__Location__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1182:1: ( ( ( rule__Location__Group_2_1_2__0 )* ) )
            // InternalTargetPlatform.g:1183:1: ( ( rule__Location__Group_2_1_2__0 )* )
            {
            // InternalTargetPlatform.g:1183:1: ( ( rule__Location__Group_2_1_2__0 )* )
            // InternalTargetPlatform.g:1184:2: ( rule__Location__Group_2_1_2__0 )*
            {
             before(grammarAccess.getLocationAccess().getGroup_2_1_2()); 
            // InternalTargetPlatform.g:1185:2: ( rule__Location__Group_2_1_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=17 && LA17_0<=20)||LA17_0==23) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalTargetPlatform.g:1185:3: rule__Location__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_8);
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
    // InternalTargetPlatform.g:1194:1: rule__Location__Group_2_1_2__0 : rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 ;
    public final void rule__Location__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1198:1: ( rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1 )
            // InternalTargetPlatform.g:1199:2: rule__Location__Group_2_1_2__0__Impl rule__Location__Group_2_1_2__1
            {
            pushFollow(FOLLOW_7);
            rule__Location__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1206:1: rule__Location__Group_2_1_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__Location__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1210:1: ( ( ( ',' )? ) )
            // InternalTargetPlatform.g:1211:1: ( ( ',' )? )
            {
            // InternalTargetPlatform.g:1211:1: ( ( ',' )? )
            // InternalTargetPlatform.g:1212:2: ( ',' )?
            {
             before(grammarAccess.getLocationAccess().getCommaKeyword_2_1_2_0()); 
            // InternalTargetPlatform.g:1213:2: ( ',' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==23) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTargetPlatform.g:1213:3: ','
                    {
                    match(input,23,FOLLOW_2); 

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
    // InternalTargetPlatform.g:1221:1: rule__Location__Group_2_1_2__1 : rule__Location__Group_2_1_2__1__Impl ;
    public final void rule__Location__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1225:1: ( rule__Location__Group_2_1_2__1__Impl )
            // InternalTargetPlatform.g:1226:2: rule__Location__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1232:1: rule__Location__Group_2_1_2__1__Impl : ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) ;
    public final void rule__Location__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1236:1: ( ( ( rule__Location__OptionsAssignment_2_1_2_1 ) ) )
            // InternalTargetPlatform.g:1237:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            {
            // InternalTargetPlatform.g:1237:1: ( ( rule__Location__OptionsAssignment_2_1_2_1 ) )
            // InternalTargetPlatform.g:1238:2: ( rule__Location__OptionsAssignment_2_1_2_1 )
            {
             before(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_2_1()); 
            // InternalTargetPlatform.g:1239:2: ( rule__Location__OptionsAssignment_2_1_2_1 )
            // InternalTargetPlatform.g:1239:3: rule__Location__OptionsAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1248:1: rule__IU__Group__0 : rule__IU__Group__0__Impl rule__IU__Group__1 ;
    public final void rule__IU__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1252:1: ( rule__IU__Group__0__Impl rule__IU__Group__1 )
            // InternalTargetPlatform.g:1253:2: rule__IU__Group__0__Impl rule__IU__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__IU__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1260:1: rule__IU__Group__0__Impl : ( ( rule__IU__IDAssignment_0 ) ) ;
    public final void rule__IU__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1264:1: ( ( ( rule__IU__IDAssignment_0 ) ) )
            // InternalTargetPlatform.g:1265:1: ( ( rule__IU__IDAssignment_0 ) )
            {
            // InternalTargetPlatform.g:1265:1: ( ( rule__IU__IDAssignment_0 ) )
            // InternalTargetPlatform.g:1266:2: ( rule__IU__IDAssignment_0 )
            {
             before(grammarAccess.getIUAccess().getIDAssignment_0()); 
            // InternalTargetPlatform.g:1267:2: ( rule__IU__IDAssignment_0 )
            // InternalTargetPlatform.g:1267:3: rule__IU__IDAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1275:1: rule__IU__Group__1 : rule__IU__Group__1__Impl ;
    public final void rule__IU__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1279:1: ( rule__IU__Group__1__Impl )
            // InternalTargetPlatform.g:1280:2: rule__IU__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1286:1: rule__IU__Group__1__Impl : ( ( rule__IU__Group_1__0 )? ) ;
    public final void rule__IU__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1290:1: ( ( ( rule__IU__Group_1__0 )? ) )
            // InternalTargetPlatform.g:1291:1: ( ( rule__IU__Group_1__0 )? )
            {
            // InternalTargetPlatform.g:1291:1: ( ( rule__IU__Group_1__0 )? )
            // InternalTargetPlatform.g:1292:2: ( rule__IU__Group_1__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1()); 
            // InternalTargetPlatform.g:1293:2: ( rule__IU__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT||LA19_0==RULE_STRING||(LA19_0>=12 && LA19_0<=14)||LA19_0==29) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTargetPlatform.g:1293:3: rule__IU__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1302:1: rule__IU__Group_1__0 : rule__IU__Group_1__0__Impl rule__IU__Group_1__1 ;
    public final void rule__IU__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1306:1: ( rule__IU__Group_1__0__Impl rule__IU__Group_1__1 )
            // InternalTargetPlatform.g:1307:2: rule__IU__Group_1__0__Impl rule__IU__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__IU__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1314:1: rule__IU__Group_1__0__Impl : ( ( rule__IU__Group_1_0__0 )? ) ;
    public final void rule__IU__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1318:1: ( ( ( rule__IU__Group_1_0__0 )? ) )
            // InternalTargetPlatform.g:1319:1: ( ( rule__IU__Group_1_0__0 )? )
            {
            // InternalTargetPlatform.g:1319:1: ( ( rule__IU__Group_1_0__0 )? )
            // InternalTargetPlatform.g:1320:2: ( rule__IU__Group_1_0__0 )?
            {
             before(grammarAccess.getIUAccess().getGroup_1_0()); 
            // InternalTargetPlatform.g:1321:2: ( rule__IU__Group_1_0__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTargetPlatform.g:1321:3: rule__IU__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1329:1: rule__IU__Group_1__1 : rule__IU__Group_1__1__Impl ;
    public final void rule__IU__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1333:1: ( rule__IU__Group_1__1__Impl )
            // InternalTargetPlatform.g:1334:2: rule__IU__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1340:1: rule__IU__Group_1__1__Impl : ( ( rule__IU__Alternatives_1_1 ) ) ;
    public final void rule__IU__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1344:1: ( ( ( rule__IU__Alternatives_1_1 ) ) )
            // InternalTargetPlatform.g:1345:1: ( ( rule__IU__Alternatives_1_1 ) )
            {
            // InternalTargetPlatform.g:1345:1: ( ( rule__IU__Alternatives_1_1 ) )
            // InternalTargetPlatform.g:1346:2: ( rule__IU__Alternatives_1_1 )
            {
             before(grammarAccess.getIUAccess().getAlternatives_1_1()); 
            // InternalTargetPlatform.g:1347:2: ( rule__IU__Alternatives_1_1 )
            // InternalTargetPlatform.g:1347:3: rule__IU__Alternatives_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1356:1: rule__IU__Group_1_0__0 : rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1 ;
    public final void rule__IU__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1360:1: ( rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1 )
            // InternalTargetPlatform.g:1361:2: rule__IU__Group_1_0__0__Impl rule__IU__Group_1_0__1
            {
            pushFollow(FOLLOW_18);
            rule__IU__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1368:1: rule__IU__Group_1_0__0__Impl : ( ';' ) ;
    public final void rule__IU__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1372:1: ( ( ';' ) )
            // InternalTargetPlatform.g:1373:1: ( ';' )
            {
            // InternalTargetPlatform.g:1373:1: ( ';' )
            // InternalTargetPlatform.g:1374:2: ';'
            {
             before(grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1383:1: rule__IU__Group_1_0__1 : rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2 ;
    public final void rule__IU__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1387:1: ( rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2 )
            // InternalTargetPlatform.g:1388:2: rule__IU__Group_1_0__1__Impl rule__IU__Group_1_0__2
            {
            pushFollow(FOLLOW_19);
            rule__IU__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1395:1: rule__IU__Group_1_0__1__Impl : ( 'version' ) ;
    public final void rule__IU__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1399:1: ( ( 'version' ) )
            // InternalTargetPlatform.g:1400:1: ( 'version' )
            {
            // InternalTargetPlatform.g:1400:1: ( 'version' )
            // InternalTargetPlatform.g:1401:2: 'version'
            {
             before(grammarAccess.getIUAccess().getVersionKeyword_1_0_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1410:1: rule__IU__Group_1_0__2 : rule__IU__Group_1_0__2__Impl ;
    public final void rule__IU__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1414:1: ( rule__IU__Group_1_0__2__Impl )
            // InternalTargetPlatform.g:1415:2: rule__IU__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1421:1: rule__IU__Group_1_0__2__Impl : ( '=' ) ;
    public final void rule__IU__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1425:1: ( ( '=' ) )
            // InternalTargetPlatform.g:1426:1: ( '=' )
            {
            // InternalTargetPlatform.g:1426:1: ( '=' )
            // InternalTargetPlatform.g:1427:2: '='
            {
             before(grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1437:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1441:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // InternalTargetPlatform.g:1442:2: rule__Version__Group__0__Impl rule__Version__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Version__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1449:1: rule__Version__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1453:1: ( ( RULE_INT ) )
            // InternalTargetPlatform.g:1454:1: ( RULE_INT )
            {
            // InternalTargetPlatform.g:1454:1: ( RULE_INT )
            // InternalTargetPlatform.g:1455:2: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1464:1: rule__Version__Group__1 : rule__Version__Group__1__Impl ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1468:1: ( rule__Version__Group__1__Impl )
            // InternalTargetPlatform.g:1469:2: rule__Version__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1475:1: rule__Version__Group__1__Impl : ( ( rule__Version__Group_1__0 )? ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1479:1: ( ( ( rule__Version__Group_1__0 )? ) )
            // InternalTargetPlatform.g:1480:1: ( ( rule__Version__Group_1__0 )? )
            {
            // InternalTargetPlatform.g:1480:1: ( ( rule__Version__Group_1__0 )? )
            // InternalTargetPlatform.g:1481:2: ( rule__Version__Group_1__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1()); 
            // InternalTargetPlatform.g:1482:2: ( rule__Version__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalTargetPlatform.g:1482:3: rule__Version__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1491:1: rule__Version__Group_1__0 : rule__Version__Group_1__0__Impl rule__Version__Group_1__1 ;
    public final void rule__Version__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1495:1: ( rule__Version__Group_1__0__Impl rule__Version__Group_1__1 )
            // InternalTargetPlatform.g:1496:2: rule__Version__Group_1__0__Impl rule__Version__Group_1__1
            {
            pushFollow(FOLLOW_21);
            rule__Version__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1503:1: rule__Version__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1507:1: ( ( '.' ) )
            // InternalTargetPlatform.g:1508:1: ( '.' )
            {
            // InternalTargetPlatform.g:1508:1: ( '.' )
            // InternalTargetPlatform.g:1509:2: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1518:1: rule__Version__Group_1__1 : rule__Version__Group_1__1__Impl rule__Version__Group_1__2 ;
    public final void rule__Version__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1522:1: ( rule__Version__Group_1__1__Impl rule__Version__Group_1__2 )
            // InternalTargetPlatform.g:1523:2: rule__Version__Group_1__1__Impl rule__Version__Group_1__2
            {
            pushFollow(FOLLOW_20);
            rule__Version__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1530:1: rule__Version__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1534:1: ( ( RULE_INT ) )
            // InternalTargetPlatform.g:1535:1: ( RULE_INT )
            {
            // InternalTargetPlatform.g:1535:1: ( RULE_INT )
            // InternalTargetPlatform.g:1536:2: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1545:1: rule__Version__Group_1__2 : rule__Version__Group_1__2__Impl ;
    public final void rule__Version__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1549:1: ( rule__Version__Group_1__2__Impl )
            // InternalTargetPlatform.g:1550:2: rule__Version__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1556:1: rule__Version__Group_1__2__Impl : ( ( rule__Version__Group_1_2__0 )? ) ;
    public final void rule__Version__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1560:1: ( ( ( rule__Version__Group_1_2__0 )? ) )
            // InternalTargetPlatform.g:1561:1: ( ( rule__Version__Group_1_2__0 )? )
            {
            // InternalTargetPlatform.g:1561:1: ( ( rule__Version__Group_1_2__0 )? )
            // InternalTargetPlatform.g:1562:2: ( rule__Version__Group_1_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1_2()); 
            // InternalTargetPlatform.g:1563:2: ( rule__Version__Group_1_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTargetPlatform.g:1563:3: rule__Version__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1572:1: rule__Version__Group_1_2__0 : rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1 ;
    public final void rule__Version__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1576:1: ( rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1 )
            // InternalTargetPlatform.g:1577:2: rule__Version__Group_1_2__0__Impl rule__Version__Group_1_2__1
            {
            pushFollow(FOLLOW_21);
            rule__Version__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1584:1: rule__Version__Group_1_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1588:1: ( ( '.' ) )
            // InternalTargetPlatform.g:1589:1: ( '.' )
            {
            // InternalTargetPlatform.g:1589:1: ( '.' )
            // InternalTargetPlatform.g:1590:2: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1599:1: rule__Version__Group_1_2__1 : rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2 ;
    public final void rule__Version__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1603:1: ( rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2 )
            // InternalTargetPlatform.g:1604:2: rule__Version__Group_1_2__1__Impl rule__Version__Group_1_2__2
            {
            pushFollow(FOLLOW_20);
            rule__Version__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1611:1: rule__Version__Group_1_2__1__Impl : ( RULE_INT ) ;
    public final void rule__Version__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1615:1: ( ( RULE_INT ) )
            // InternalTargetPlatform.g:1616:1: ( RULE_INT )
            {
            // InternalTargetPlatform.g:1616:1: ( RULE_INT )
            // InternalTargetPlatform.g:1617:2: RULE_INT
            {
             before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_2_1()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1626:1: rule__Version__Group_1_2__2 : rule__Version__Group_1_2__2__Impl ;
    public final void rule__Version__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1630:1: ( rule__Version__Group_1_2__2__Impl )
            // InternalTargetPlatform.g:1631:2: rule__Version__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1637:1: rule__Version__Group_1_2__2__Impl : ( ( rule__Version__Group_1_2_2__0 )? ) ;
    public final void rule__Version__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1641:1: ( ( ( rule__Version__Group_1_2_2__0 )? ) )
            // InternalTargetPlatform.g:1642:1: ( ( rule__Version__Group_1_2_2__0 )? )
            {
            // InternalTargetPlatform.g:1642:1: ( ( rule__Version__Group_1_2_2__0 )? )
            // InternalTargetPlatform.g:1643:2: ( rule__Version__Group_1_2_2__0 )?
            {
             before(grammarAccess.getVersionAccess().getGroup_1_2_2()); 
            // InternalTargetPlatform.g:1644:2: ( rule__Version__Group_1_2_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTargetPlatform.g:1644:3: rule__Version__Group_1_2_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1653:1: rule__Version__Group_1_2_2__0 : rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1 ;
    public final void rule__Version__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1657:1: ( rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1 )
            // InternalTargetPlatform.g:1658:2: rule__Version__Group_1_2_2__0__Impl rule__Version__Group_1_2_2__1
            {
            pushFollow(FOLLOW_22);
            rule__Version__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1665:1: rule__Version__Group_1_2_2__0__Impl : ( '.' ) ;
    public final void rule__Version__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1669:1: ( ( '.' ) )
            // InternalTargetPlatform.g:1670:1: ( '.' )
            {
            // InternalTargetPlatform.g:1670:1: ( '.' )
            // InternalTargetPlatform.g:1671:2: '.'
            {
             before(grammarAccess.getVersionAccess().getFullStopKeyword_1_2_2_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1680:1: rule__Version__Group_1_2_2__1 : rule__Version__Group_1_2_2__1__Impl ;
    public final void rule__Version__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1684:1: ( rule__Version__Group_1_2_2__1__Impl )
            // InternalTargetPlatform.g:1685:2: rule__Version__Group_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1691:1: rule__Version__Group_1_2_2__1__Impl : ( ( rule__Version__Alternatives_1_2_2_1 ) ) ;
    public final void rule__Version__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1695:1: ( ( ( rule__Version__Alternatives_1_2_2_1 ) ) )
            // InternalTargetPlatform.g:1696:1: ( ( rule__Version__Alternatives_1_2_2_1 ) )
            {
            // InternalTargetPlatform.g:1696:1: ( ( rule__Version__Alternatives_1_2_2_1 ) )
            // InternalTargetPlatform.g:1697:2: ( rule__Version__Alternatives_1_2_2_1 )
            {
             before(grammarAccess.getVersionAccess().getAlternatives_1_2_2_1()); 
            // InternalTargetPlatform.g:1698:2: ( rule__Version__Alternatives_1_2_2_1 )
            // InternalTargetPlatform.g:1698:3: rule__Version__Alternatives_1_2_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1707:1: rule__VersionRange__Group_0__0 : rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 ;
    public final void rule__VersionRange__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1711:1: ( rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1 )
            // InternalTargetPlatform.g:1712:2: rule__VersionRange__Group_0__0__Impl rule__VersionRange__Group_0__1
            {
            pushFollow(FOLLOW_21);
            rule__VersionRange__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1719:1: rule__VersionRange__Group_0__0__Impl : ( ( rule__VersionRange__Alternatives_0_0 ) ) ;
    public final void rule__VersionRange__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1723:1: ( ( ( rule__VersionRange__Alternatives_0_0 ) ) )
            // InternalTargetPlatform.g:1724:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            {
            // InternalTargetPlatform.g:1724:1: ( ( rule__VersionRange__Alternatives_0_0 ) )
            // InternalTargetPlatform.g:1725:2: ( rule__VersionRange__Alternatives_0_0 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_0()); 
            // InternalTargetPlatform.g:1726:2: ( rule__VersionRange__Alternatives_0_0 )
            // InternalTargetPlatform.g:1726:3: rule__VersionRange__Alternatives_0_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1734:1: rule__VersionRange__Group_0__1 : rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 ;
    public final void rule__VersionRange__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1738:1: ( rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2 )
            // InternalTargetPlatform.g:1739:2: rule__VersionRange__Group_0__1__Impl rule__VersionRange__Group_0__2
            {
            pushFollow(FOLLOW_23);
            rule__VersionRange__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1746:1: rule__VersionRange__Group_0__1__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1750:1: ( ( ruleVersion ) )
            // InternalTargetPlatform.g:1751:1: ( ruleVersion )
            {
            // InternalTargetPlatform.g:1751:1: ( ruleVersion )
            // InternalTargetPlatform.g:1752:2: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1761:1: rule__VersionRange__Group_0__2 : rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 ;
    public final void rule__VersionRange__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1765:1: ( rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3 )
            // InternalTargetPlatform.g:1766:2: rule__VersionRange__Group_0__2__Impl rule__VersionRange__Group_0__3
            {
            pushFollow(FOLLOW_21);
            rule__VersionRange__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1773:1: rule__VersionRange__Group_0__2__Impl : ( ',' ) ;
    public final void rule__VersionRange__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1777:1: ( ( ',' ) )
            // InternalTargetPlatform.g:1778:1: ( ',' )
            {
            // InternalTargetPlatform.g:1778:1: ( ',' )
            // InternalTargetPlatform.g:1779:2: ','
            {
             before(grammarAccess.getVersionRangeAccess().getCommaKeyword_0_2()); 
            match(input,23,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1788:1: rule__VersionRange__Group_0__3 : rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 ;
    public final void rule__VersionRange__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1792:1: ( rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4 )
            // InternalTargetPlatform.g:1793:2: rule__VersionRange__Group_0__3__Impl rule__VersionRange__Group_0__4
            {
            pushFollow(FOLLOW_24);
            rule__VersionRange__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1800:1: rule__VersionRange__Group_0__3__Impl : ( ruleVersion ) ;
    public final void rule__VersionRange__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1804:1: ( ( ruleVersion ) )
            // InternalTargetPlatform.g:1805:1: ( ruleVersion )
            {
            // InternalTargetPlatform.g:1805:1: ( ruleVersion )
            // InternalTargetPlatform.g:1806:2: ruleVersion
            {
             before(grammarAccess.getVersionRangeAccess().getVersionParserRuleCall_0_3()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1815:1: rule__VersionRange__Group_0__4 : rule__VersionRange__Group_0__4__Impl ;
    public final void rule__VersionRange__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1819:1: ( rule__VersionRange__Group_0__4__Impl )
            // InternalTargetPlatform.g:1820:2: rule__VersionRange__Group_0__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1826:1: rule__VersionRange__Group_0__4__Impl : ( ( rule__VersionRange__Alternatives_0_4 ) ) ;
    public final void rule__VersionRange__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1830:1: ( ( ( rule__VersionRange__Alternatives_0_4 ) ) )
            // InternalTargetPlatform.g:1831:1: ( ( rule__VersionRange__Alternatives_0_4 ) )
            {
            // InternalTargetPlatform.g:1831:1: ( ( rule__VersionRange__Alternatives_0_4 ) )
            // InternalTargetPlatform.g:1832:2: ( rule__VersionRange__Alternatives_0_4 )
            {
             before(grammarAccess.getVersionRangeAccess().getAlternatives_0_4()); 
            // InternalTargetPlatform.g:1833:2: ( rule__VersionRange__Alternatives_0_4 )
            // InternalTargetPlatform.g:1833:3: rule__VersionRange__Alternatives_0_4
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1842:1: rule__Location__UnorderedGroup_1 : rule__Location__UnorderedGroup_1__0 {...}?;
    public final void rule__Location__UnorderedGroup_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLocationAccess().getUnorderedGroup_1());
        	
        try {
            // InternalTargetPlatform.g:1847:1: ( rule__Location__UnorderedGroup_1__0 {...}?)
            // InternalTargetPlatform.g:1848:2: rule__Location__UnorderedGroup_1__0 {...}?
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1856:1: rule__Location__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) ) ;
    public final void rule__Location__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalTargetPlatform.g:1861:1: ( ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) ) )
            // InternalTargetPlatform.g:1862:3: ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) )
            {
            // InternalTargetPlatform.g:1862:3: ( ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( LA24_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                alt24=1;
            }
            else if ( LA24_0 == RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalTargetPlatform.g:1863:3: ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) )
                    {
                    // InternalTargetPlatform.g:1863:3: ({...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) ) )
                    // InternalTargetPlatform.g:1864:4: {...}? => ( ( ( rule__Location__IDAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0)");
                    }
                    // InternalTargetPlatform.g:1864:104: ( ( ( rule__Location__IDAssignment_1_0 ) ) )
                    // InternalTargetPlatform.g:1865:5: ( ( rule__Location__IDAssignment_1_0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0);
                    				

                    					selected = true;
                    				
                    // InternalTargetPlatform.g:1871:5: ( ( rule__Location__IDAssignment_1_0 ) )
                    // InternalTargetPlatform.g:1872:6: ( rule__Location__IDAssignment_1_0 )
                    {
                     before(grammarAccess.getLocationAccess().getIDAssignment_1_0()); 
                    // InternalTargetPlatform.g:1873:6: ( rule__Location__IDAssignment_1_0 )
                    // InternalTargetPlatform.g:1873:7: rule__Location__IDAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalTargetPlatform.g:1878:3: ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) )
                    {
                    // InternalTargetPlatform.g:1878:3: ({...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) ) )
                    // InternalTargetPlatform.g:1879:4: {...}? => ( ( ( rule__Location__UriAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Location__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1)");
                    }
                    // InternalTargetPlatform.g:1879:104: ( ( ( rule__Location__UriAssignment_1_1 ) ) )
                    // InternalTargetPlatform.g:1880:5: ( ( rule__Location__UriAssignment_1_1 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1);
                    				

                    					selected = true;
                    				
                    // InternalTargetPlatform.g:1886:5: ( ( rule__Location__UriAssignment_1_1 ) )
                    // InternalTargetPlatform.g:1887:6: ( rule__Location__UriAssignment_1_1 )
                    {
                     before(grammarAccess.getLocationAccess().getUriAssignment_1_1()); 
                    // InternalTargetPlatform.g:1888:6: ( rule__Location__UriAssignment_1_1 )
                    // InternalTargetPlatform.g:1888:7: rule__Location__UriAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1901:1: rule__Location__UnorderedGroup_1__0 : rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? ;
    public final void rule__Location__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1905:1: ( rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )? )
            // InternalTargetPlatform.g:1906:2: rule__Location__UnorderedGroup_1__Impl ( rule__Location__UnorderedGroup_1__1 )?
            {
            pushFollow(FOLLOW_25);
            rule__Location__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalTargetPlatform.g:1907:2: ( rule__Location__UnorderedGroup_1__1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( LA25_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 0) ) {
                alt25=1;
            }
            else if ( LA25_0 == RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getLocationAccess().getUnorderedGroup_1(), 1) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTargetPlatform.g:1907:2: rule__Location__UnorderedGroup_1__1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1913:1: rule__Location__UnorderedGroup_1__1 : rule__Location__UnorderedGroup_1__Impl ;
    public final void rule__Location__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1917:1: ( rule__Location__UnorderedGroup_1__Impl )
            // InternalTargetPlatform.g:1918:2: rule__Location__UnorderedGroup_1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1925:1: rule__TargetPlatform__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TargetPlatform__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1929:1: ( ( RULE_STRING ) )
            // InternalTargetPlatform.g:1930:2: ( RULE_STRING )
            {
            // InternalTargetPlatform.g:1930:2: ( RULE_STRING )
            // InternalTargetPlatform.g:1931:3: RULE_STRING
            {
             before(grammarAccess.getTargetPlatformAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalTargetPlatform.g:1940:1: rule__TargetPlatform__ContentsAssignment_2 : ( ruleTargetContent ) ;
    public final void rule__TargetPlatform__ContentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1944:1: ( ( ruleTargetContent ) )
            // InternalTargetPlatform.g:1945:2: ( ruleTargetContent )
            {
            // InternalTargetPlatform.g:1945:2: ( ruleTargetContent )
            // InternalTargetPlatform.g:1946:3: ruleTargetContent
            {
             before(grammarAccess.getTargetPlatformAccess().getContentsTargetContentParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1955:1: rule__Options__OptionsAssignment_1 : ( ruleOption ) ;
    public final void rule__Options__OptionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1959:1: ( ( ruleOption ) )
            // InternalTargetPlatform.g:1960:2: ( ruleOption )
            {
            // InternalTargetPlatform.g:1960:2: ( ruleOption )
            // InternalTargetPlatform.g:1961:3: ruleOption
            {
             before(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1970:1: rule__Options__OptionsAssignment_2_1 : ( ruleOption ) ;
    public final void rule__Options__OptionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1974:1: ( ( ruleOption ) )
            // InternalTargetPlatform.g:1975:2: ( ruleOption )
            {
            // InternalTargetPlatform.g:1975:2: ( ruleOption )
            // InternalTargetPlatform.g:1976:3: ruleOption
            {
             before(grammarAccess.getOptionsAccess().getOptionsOptionEnumRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:1985:1: rule__Environment__EnvAssignment_2 : ( RULE_ID ) ;
    public final void rule__Environment__EnvAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:1989:1: ( ( RULE_ID ) )
            // InternalTargetPlatform.g:1990:2: ( RULE_ID )
            {
            // InternalTargetPlatform.g:1990:2: ( RULE_ID )
            // InternalTargetPlatform.g:1991:3: RULE_ID
            {
             before(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalTargetPlatform.g:2000:1: rule__Environment__EnvAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Environment__EnvAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2004:1: ( ( RULE_ID ) )
            // InternalTargetPlatform.g:2005:2: ( RULE_ID )
            {
            // InternalTargetPlatform.g:2005:2: ( RULE_ID )
            // InternalTargetPlatform.g:2006:3: RULE_ID
            {
             before(grammarAccess.getEnvironmentAccess().getEnvIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalTargetPlatform.g:2015:1: rule__IncludeDeclaration__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__IncludeDeclaration__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2019:1: ( ( RULE_STRING ) )
            // InternalTargetPlatform.g:2020:2: ( RULE_STRING )
            {
            // InternalTargetPlatform.g:2020:2: ( RULE_STRING )
            // InternalTargetPlatform.g:2021:3: RULE_STRING
            {
             before(grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalTargetPlatform.g:2030:1: rule__Location__IDAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Location__IDAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2034:1: ( ( RULE_ID ) )
            // InternalTargetPlatform.g:2035:2: ( RULE_ID )
            {
            // InternalTargetPlatform.g:2035:2: ( RULE_ID )
            // InternalTargetPlatform.g:2036:3: RULE_ID
            {
             before(grammarAccess.getLocationAccess().getIDIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalTargetPlatform.g:2045:1: rule__Location__UriAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Location__UriAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2049:1: ( ( RULE_STRING ) )
            // InternalTargetPlatform.g:2050:2: ( RULE_STRING )
            {
            // InternalTargetPlatform.g:2050:2: ( RULE_STRING )
            // InternalTargetPlatform.g:2051:3: RULE_STRING
            {
             before(grammarAccess.getLocationAccess().getUriSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalTargetPlatform.g:2060:1: rule__Location__OptionsAssignment_2_1_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2064:1: ( ( ruleOption ) )
            // InternalTargetPlatform.g:2065:2: ( ruleOption )
            {
            // InternalTargetPlatform.g:2065:2: ( ruleOption )
            // InternalTargetPlatform.g:2066:3: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:2075:1: rule__Location__OptionsAssignment_2_1_2_1 : ( ruleOption ) ;
    public final void rule__Location__OptionsAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2079:1: ( ( ruleOption ) )
            // InternalTargetPlatform.g:2080:2: ( ruleOption )
            {
            // InternalTargetPlatform.g:2080:2: ( ruleOption )
            // InternalTargetPlatform.g:2081:3: ruleOption
            {
             before(grammarAccess.getLocationAccess().getOptionsOptionEnumRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:2090:1: rule__Location__IusAssignment_2_2 : ( ruleIU ) ;
    public final void rule__Location__IusAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2094:1: ( ( ruleIU ) )
            // InternalTargetPlatform.g:2095:2: ( ruleIU )
            {
            // InternalTargetPlatform.g:2095:2: ( ruleIU )
            // InternalTargetPlatform.g:2096:3: ruleIU
            {
             before(grammarAccess.getLocationAccess().getIusIUParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:2105:1: rule__IU__IDAssignment_0 : ( RULE_ID ) ;
    public final void rule__IU__IDAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2109:1: ( ( RULE_ID ) )
            // InternalTargetPlatform.g:2110:2: ( RULE_ID )
            {
            // InternalTargetPlatform.g:2110:2: ( RULE_ID )
            // InternalTargetPlatform.g:2111:3: RULE_ID
            {
             before(grammarAccess.getIUAccess().getIDIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalTargetPlatform.g:2120:1: rule__IU__VersionAssignment_1_1_0 : ( ruleVersionRange ) ;
    public final void rule__IU__VersionAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2124:1: ( ( ruleVersionRange ) )
            // InternalTargetPlatform.g:2125:2: ( ruleVersionRange )
            {
            // InternalTargetPlatform.g:2125:2: ( ruleVersionRange )
            // InternalTargetPlatform.g:2126:3: ruleVersionRange
            {
             before(grammarAccess.getIUAccess().getVersionVersionRangeParserRuleCall_1_1_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalTargetPlatform.g:2135:1: rule__IU__VersionAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__IU__VersionAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTargetPlatform.g:2139:1: ( ( RULE_STRING ) )
            // InternalTargetPlatform.g:2140:2: ( RULE_STRING )
            {
            // InternalTargetPlatform.g:2140:2: ( RULE_STRING )
            // InternalTargetPlatform.g:2141:3: RULE_STRING
            {
             before(grammarAccess.getIUAccess().getVersionSTRINGTerminalRuleCall_1_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000007400000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000007400002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000009E0000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000009E0002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800012L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010400010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000200070A0L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000092L});

}
