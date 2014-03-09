// $ANTLR 2.7.7 (2006-11-01): "simple2.g" -> "SimpleParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class SimpleParser extends antlr.LLkParser       implements SimpleParserTokenTypes
 {

protected SimpleParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public SimpleParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected SimpleParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public SimpleParser(TokenStream lexer) {
  this(lexer,1);
}

public SimpleParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void entry() throws RecognitionException, TokenStreamException {
		
		Token  d = null;
		Token  n = null;
		Token  a = null;
		
		try {      // for error handling
			{
			_loop4:
			do {
				if ((LA(1)==DOB)) {
					d = LT(1);
					match(DOB);
					n = LT(1);
					match(NAME);
					a = LT(1);
					match(AGE);
					{
					match(SEMI);
					}
					
					System.out.println(
					"Name: "    + 
					n.getText() +
					", Age: "   +
					a.getText() + 
					", DOB: "   +
					d.getText()
					);
					
				}
				else {
					break _loop4;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"DOB",
		"NAME",
		"AGE",
		"SEMI",
		"WS"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	
	}
