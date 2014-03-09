package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public abstract class BlockStmt extends ASTNode implements Cloneable {
    // Declared in picojava.ast line 4

    public BlockStmt() {
        super();

    }

    public Object clone() throws CloneNotSupportedException {
        BlockStmt node = (BlockStmt)super.clone();
        node.declarationOf_String_visited = new java.util.HashSet(4);
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public void flushCache() {
        super.flushCache();
        declarationOf_String_visited = new java.util.HashSet(4);
    }
  protected int numChildren() {
    return 0;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in NameResolution.jrag at line 83
    protected java.util.Set declarationOf_String_visited = new java.util.HashSet(4);
    public Decl declarationOf(String name) {
        Object _parameters = name;
        if(declarationOf_String_visited.contains(_parameters))
            throw new RuntimeException("Circular definition of attr: declarationOf in class: ");
        declarationOf_String_visited.add(_parameters);
        Decl declarationOf_String_value = declarationOf_compute(name);
        declarationOf_String_visited.remove(_parameters);
        return declarationOf_String_value;
    }

    private Decl declarationOf_compute(String name) {  return  null;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
