package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class Opt extends ASTNode implements Cloneable {
    // Declared in null line 0

    public Opt() {
        super();

    }

     public Opt(ASTNode opt) {
         setChild(opt, 0);
     }

    public Object clone() throws CloneNotSupportedException {
        Opt node = (Opt)super.clone();
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          Opt node = (Opt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        Opt res = (Opt)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
        super.flushCache();
    }
  public boolean mayHaveRewrite() { return false; }
public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
