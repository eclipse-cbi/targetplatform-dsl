package org.eclipse.cbi.targetplatform.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTargetPlatformLexer extends Lexer {
    public static final int RULE_STRING=4;
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

    public InternalTargetPlatformLexer() {;} 
    public InternalTargetPlatformLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalTargetPlatformLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalTargetPlatform.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:11:7: ( 'target' )
            // InternalTargetPlatform.g:11:9: 'target'
            {
            match("target"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:12:7: ( 'with' )
            // InternalTargetPlatform.g:12:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:13:7: ( ',' )
            // InternalTargetPlatform.g:13:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:14:7: ( 'environment' )
            // InternalTargetPlatform.g:14:9: 'environment'
            {
            match("environment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:15:7: ( 'include' )
            // InternalTargetPlatform.g:15:9: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:16:7: ( 'location' )
            // InternalTargetPlatform.g:16:9: 'location'
            {
            match("location"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:17:7: ( '{' )
            // InternalTargetPlatform.g:17:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:18:7: ( '}' )
            // InternalTargetPlatform.g:18:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:19:7: ( ';' )
            // InternalTargetPlatform.g:19:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:20:7: ( 'version' )
            // InternalTargetPlatform.g:20:9: 'version'
            {
            match("version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:21:7: ( '=' )
            // InternalTargetPlatform.g:21:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:22:7: ( '.' )
            // InternalTargetPlatform.g:22:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:23:7: ( '(' )
            // InternalTargetPlatform.g:23:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:24:7: ( '[' )
            // InternalTargetPlatform.g:24:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:25:7: ( ')' )
            // InternalTargetPlatform.g:25:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:26:7: ( ']' )
            // InternalTargetPlatform.g:26:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:27:7: ( 'lazy' )
            // InternalTargetPlatform.g:27:9: 'lazy'
            {
            match("lazy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:28:7: ( 'requirements' )
            // InternalTargetPlatform.g:28:9: 'requirements'
            {
            match("requirements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:29:7: ( 'allEnvironments' )
            // InternalTargetPlatform.g:29:9: 'allEnvironments'
            {
            match("allEnvironments"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:30:7: ( 'source' )
            // InternalTargetPlatform.g:30:9: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:31:7: ( 'configurePhase' )
            // InternalTargetPlatform.g:31:9: 'configurePhase'
            {
            match("configurePhase"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:864:10: ( ( '0' .. '9' )+ )
            // InternalTargetPlatform.g:864:12: ( '0' .. '9' )+
            {
            // InternalTargetPlatform.g:864:12: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTargetPlatform.g:864:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:866:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( ( '.' )? ( 'a' .. 'z' | 'A' .. 'Z' | '^' | '_' | '-' | '0' .. '9' ) )* )
            // InternalTargetPlatform.g:866:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( ( '.' )? ( 'a' .. 'z' | 'A' .. 'Z' | '^' | '_' | '-' | '0' .. '9' ) )*
            {
            // InternalTargetPlatform.g:866:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTargetPlatform.g:866:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalTargetPlatform.g:866:40: ( ( '.' )? ( 'a' .. 'z' | 'A' .. 'Z' | '^' | '_' | '-' | '0' .. '9' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='-' && LA4_0<='.')||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||(LA4_0>='^' && LA4_0<='_')||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalTargetPlatform.g:866:41: ( '.' )? ( 'a' .. 'z' | 'A' .. 'Z' | '^' | '_' | '-' | '0' .. '9' )
            	    {
            	    // InternalTargetPlatform.g:866:41: ( '.' )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0=='.') ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // InternalTargetPlatform.g:866:41: '.'
            	            {
            	            match('.'); 

            	            }
            	            break;

            	    }

            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='_')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_QUALIFIER"
    public final void mRULE_QUALIFIER() throws RecognitionException {
        try {
            int _type = RULE_QUALIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:868:16: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )* )
            // InternalTargetPlatform.g:868:18: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )*
            {
            // InternalTargetPlatform.g:868:18: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='-'||(LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalTargetPlatform.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_QUALIFIER"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:870:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalTargetPlatform.g:870:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalTargetPlatform.g:870:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalTargetPlatform.g:870:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalTargetPlatform.g:870:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalTargetPlatform.g:870:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTargetPlatform.g:870:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalTargetPlatform.g:870:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalTargetPlatform.g:870:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTargetPlatform.g:870:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTargetPlatform.g:870:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:872:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalTargetPlatform.g:872:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalTargetPlatform.g:872:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalTargetPlatform.g:872:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:874:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalTargetPlatform.g:874:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalTargetPlatform.g:874:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTargetPlatform.g:874:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalTargetPlatform.g:874:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTargetPlatform.g:874:41: ( '\\r' )? '\\n'
                    {
                    // InternalTargetPlatform.g:874:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalTargetPlatform.g:874:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:876:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalTargetPlatform.g:876:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalTargetPlatform.g:876:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalTargetPlatform.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTargetPlatform.g:878:16: ( . )
            // InternalTargetPlatform.g:878:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalTargetPlatform.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | RULE_INT | RULE_ID | RULE_QUALIFIER | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=29;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalTargetPlatform.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalTargetPlatform.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalTargetPlatform.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalTargetPlatform.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalTargetPlatform.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalTargetPlatform.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalTargetPlatform.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalTargetPlatform.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalTargetPlatform.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalTargetPlatform.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalTargetPlatform.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // InternalTargetPlatform.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // InternalTargetPlatform.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // InternalTargetPlatform.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // InternalTargetPlatform.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // InternalTargetPlatform.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // InternalTargetPlatform.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // InternalTargetPlatform.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // InternalTargetPlatform.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // InternalTargetPlatform.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // InternalTargetPlatform.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // InternalTargetPlatform.g:1:136: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 23 :
                // InternalTargetPlatform.g:1:145: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 24 :
                // InternalTargetPlatform.g:1:153: RULE_QUALIFIER
                {
                mRULE_QUALIFIER(); 

                }
                break;
            case 25 :
                // InternalTargetPlatform.g:1:168: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 26 :
                // InternalTargetPlatform.g:1:180: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 27 :
                // InternalTargetPlatform.g:1:196: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 28 :
                // InternalTargetPlatform.g:1:212: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 29 :
                // InternalTargetPlatform.g:1:220: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\31\2\40\1\uffff\3\40\3\uffff\1\40\6\uffff\4\40\1\66\1\36\1\40\2\uffff\3\36\2\uffff\1\40\1\uffff\2\40\1\uffff\4\40\3\uffff\1\40\6\uffff\4\40\1\uffff\1\66\4\uffff\14\40\1\123\3\40\1\127\6\40\1\uffff\3\40\1\uffff\5\40\1\146\6\40\1\155\1\40\1\uffff\1\40\1\160\1\40\1\162\2\40\1\uffff\2\40\1\uffff\1\167\1\uffff\4\40\1\uffff\7\40\1\u0083\3\40\1\uffff\1\u0087\2\40\1\uffff\3\40\1\u008d\1\u008e\2\uffff";
    static final String DFA14_eofS =
        "\u008f\uffff";
    static final String DFA14_minS =
        "\1\0\2\55\1\uffff\3\55\3\uffff\1\55\6\uffff\5\55\1\101\1\55\2\uffff\2\0\1\52\2\uffff\1\55\1\uffff\2\55\1\uffff\4\55\3\uffff\1\55\6\uffff\4\55\1\uffff\1\55\4\uffff\27\55\1\uffff\3\55\1\uffff\16\55\1\uffff\6\55\1\uffff\2\55\1\uffff\1\55\1\uffff\4\55\1\uffff\13\55\1\uffff\3\55\1\uffff\5\55\2\uffff";
    static final String DFA14_maxS =
        "\1\uffff\2\172\1\uffff\3\172\3\uffff\1\172\6\uffff\7\172\2\uffff\2\uffff\1\57\2\uffff\1\172\1\uffff\2\172\1\uffff\4\172\3\uffff\1\172\6\uffff\4\172\1\uffff\1\172\4\uffff\27\172\1\uffff\3\172\1\uffff\16\172\1\uffff\6\172\1\uffff\2\172\1\uffff\1\172\1\uffff\4\172\1\uffff\13\172\1\uffff\3\172\1\uffff\5\172\2\uffff";
    static final String DFA14_acceptS =
        "\3\uffff\1\3\3\uffff\1\7\1\10\1\11\1\uffff\1\13\1\14\1\15\1\16\1\17\1\20\7\uffff\2\30\3\uffff\1\34\1\35\1\uffff\1\27\2\uffff\1\3\4\uffff\1\7\1\10\1\11\1\uffff\1\13\1\14\1\15\1\16\1\17\1\20\4\uffff\1\26\1\uffff\1\31\1\32\1\33\1\34\27\uffff\1\2\3\uffff\1\21\16\uffff\1\1\6\uffff\1\24\2\uffff\1\5\1\uffff\1\12\4\uffff\1\6\13\uffff\1\4\3\uffff\1\22\5\uffff\1\25\1\23";
    static final String DFA14_specialS =
        "\1\0\31\uffff\1\2\1\1\163\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\36\2\35\2\36\1\35\22\36\1\35\1\36\1\32\4\36\1\33\1\15\1\17\2\36\1\3\1\30\1\14\1\34\12\25\1\36\1\11\1\36\1\13\3\36\32\27\1\16\1\36\1\20\1\26\1\27\1\36\1\22\1\27\1\24\1\27\1\4\3\27\1\5\2\27\1\6\5\27\1\21\1\23\1\1\1\27\1\12\1\2\3\27\1\7\1\36\1\10\uff82\36",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\1\37\31\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\42\21\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\44\14\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\45\14\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\1\47\15\41\1\46\13\41",
            "",
            "",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\53\25\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\62\25\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\13\41\1\63\16\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\64\13\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\65\13\41",
            "\1\31\2\uffff\12\67\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "\0\70",
            "\0\70",
            "\1\71\4\uffff\1\72",
            "",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\74\10\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\75\6\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\25\41\1\76\4\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\2\41\1\77\27\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\2\41\1\100\27\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\31\41\1\101",
            "",
            "",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\102\10\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\20\41\1\103\11\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\13\41\1\104\16\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\24\41\1\105\5\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\106\14\41",
            "",
            "\1\31\2\uffff\12\67\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\6\41\1\107\23\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\7\41\1\110\22\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\111\21\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\13\41\1\112\16\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\1\113\31\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\30\41\1\114\1\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\22\41\1\115\7\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\24\41\1\116\5\41",
            "\1\41\2\uffff\12\41\7\uffff\4\41\1\117\25\41\4\uffff\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\120\10\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\5\41\1\121\24\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\122\25\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\124\10\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\24\41\1\125\5\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\126\6\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\130\21\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\131\21\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\132\14\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\2\41\1\133\27\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\134\21\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\135\6\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\136\13\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\3\41\1\137\26\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\140\21\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\141\13\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\142\10\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\25\41\1\143\4\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\144\25\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\6\41\1\145\23\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\147\14\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\150\25\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\151\13\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\152\14\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\153\25\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\154\21\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\24\41\1\156\5\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\14\41\1\157\15\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\161\14\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\14\41\1\163\15\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\164\10\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\165\10\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\166\25\41",
            "",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\170\25\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\171\13\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\172\25\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\173\14\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\174\14\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\175\14\41",
            "\1\41\2\uffff\12\41\7\uffff\17\41\1\176\12\41\4\uffff\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\177\6\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\u0080\6\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\14\41\1\u0081\15\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\7\41\1\u0082\22\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\22\41\1\u0084\7\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\u0085\25\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\1\u0086\31\41",
            "",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\u0088\14\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\22\41\1\u0089\7\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\u008a\6\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\u008b\25\41",
            "\1\41\2\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\22\41\1\u008c\7\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "\1\41\1\40\1\uffff\12\41\7\uffff\32\41\3\uffff\1\40\1\41\1\uffff\32\41",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | RULE_INT | RULE_ID | RULE_QUALIFIER | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='t') ) {s = 1;}

                        else if ( (LA14_0=='w') ) {s = 2;}

                        else if ( (LA14_0==',') ) {s = 3;}

                        else if ( (LA14_0=='e') ) {s = 4;}

                        else if ( (LA14_0=='i') ) {s = 5;}

                        else if ( (LA14_0=='l') ) {s = 6;}

                        else if ( (LA14_0=='{') ) {s = 7;}

                        else if ( (LA14_0=='}') ) {s = 8;}

                        else if ( (LA14_0==';') ) {s = 9;}

                        else if ( (LA14_0=='v') ) {s = 10;}

                        else if ( (LA14_0=='=') ) {s = 11;}

                        else if ( (LA14_0=='.') ) {s = 12;}

                        else if ( (LA14_0=='(') ) {s = 13;}

                        else if ( (LA14_0=='[') ) {s = 14;}

                        else if ( (LA14_0==')') ) {s = 15;}

                        else if ( (LA14_0==']') ) {s = 16;}

                        else if ( (LA14_0=='r') ) {s = 17;}

                        else if ( (LA14_0=='a') ) {s = 18;}

                        else if ( (LA14_0=='s') ) {s = 19;}

                        else if ( (LA14_0=='c') ) {s = 20;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 21;}

                        else if ( (LA14_0=='^') ) {s = 22;}

                        else if ( ((LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||LA14_0=='b'||LA14_0=='d'||(LA14_0>='f' && LA14_0<='h')||(LA14_0>='j' && LA14_0<='k')||(LA14_0>='m' && LA14_0<='q')||LA14_0=='u'||(LA14_0>='x' && LA14_0<='z')) ) {s = 23;}

                        else if ( (LA14_0=='-') ) {s = 24;}

                        else if ( (LA14_0=='\"') ) {s = 26;}

                        else if ( (LA14_0=='\'') ) {s = 27;}

                        else if ( (LA14_0=='/') ) {s = 28;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 29;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='&')||(LA14_0>='*' && LA14_0<='+')||LA14_0==':'||LA14_0=='<'||(LA14_0>='>' && LA14_0<='@')||LA14_0=='\\'||LA14_0=='`'||LA14_0=='|'||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {s = 30;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_27 = input.LA(1);

                        s = -1;
                        if ( ((LA14_27>='\u0000' && LA14_27<='\uFFFF')) ) {s = 56;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_26 = input.LA(1);

                        s = -1;
                        if ( ((LA14_26>='\u0000' && LA14_26<='\uFFFF')) ) {s = 56;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}