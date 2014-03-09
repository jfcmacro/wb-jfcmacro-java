package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public abstract class Stmt extends BlockStmt implements Cloneable {
    // Declared in picojava.ast line 5

    public Stmt() {
        super();

    }

    public Object clone() throws CloneNotSupportedException {
        Stmt node = (Stmt)super.clone();
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public void flushCache() {
        super.flushCache();
    }
  protected int numChildren() {
    return 0;
  }
  public boolean mayHaveRewrite() { return false; }
public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
