/* 
 * Test.java
 */
package co.edu.eafit.ainit;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import co.edu.eafit.ainit.parser.ArrayInitLexer;
import co.edu.eafit.ainit.parser.ArrayInitParser;

public class Test {

    public static void main(String []args)
	throws Exception {

	ANTLRInputStream input = new ANTLRInputStream(System.in);

	ArrayInitLexer lexer = new ArrayInitLexer(input);

	CommonTokenStream tokens = new CommonTokenStream(lexer);

	ArrayInitParser parser = new ArrayInitParser(tokens);

	ParseTree tree = parser.init();

	System.out.println(tree.toStringTree(parser));
    }
}
