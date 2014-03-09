package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public abstract class Access extends Exp implements Cloneable {
    // Declared in picojava.ast line 13

    public Access() {
        super();

    }

    public Object clone() throws CloneNotSupportedException {
        Access node = (Access)super.clone();
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
    // Declared in NameResolution.jrag at line 10
    public abstract Decl decl();
public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
