package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public abstract class Exp extends ASTNode implements Cloneable {
    // Declared in picojava.ast line 12

    public Exp() {
        super();

    }

    public Object clone() throws CloneNotSupportedException {
        Exp node = (Exp)super.clone();
        node.isValue_visited = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public void flushCache() {
        super.flushCache();
        isValue_visited = false;
    }
  protected int numChildren() {
    return 0;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in TypeAnalysis.jrag at line 9
    public abstract TypeDecl type();
    // Declared in TypeAnalysis.jrag at line 17
    protected boolean isValue_visited = false;
    public boolean isValue() {
        if(isValue_visited)
            throw new RuntimeException("Circular definition of attr: isValue in class: ");
        isValue_visited = true;
        boolean isValue_value = isValue_compute();
        isValue_visited = false;
        return isValue_value;
    }

    private boolean isValue_compute() {  return  true;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
