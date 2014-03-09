package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class VariableUse extends IdUse implements Cloneable {
    // Declared in picojava.ast line 25

    public VariableUse() {
        super();

    }

    // Declared in picojava.ast line 25
    public VariableUse(String p0) {
        setName(p0);
    }

    public Object clone() throws CloneNotSupportedException {
        VariableUse node = (VariableUse)super.clone();
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          VariableUse node = (VariableUse)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        VariableUse res = (VariableUse)copy();
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
  protected int numChildren() {
    return 0;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in picojava.ast line 14
    private String tokenString_Name;
    public void setName(String value) {
        tokenString_Name = value;
    }
    public String getName() {
        return tokenString_Name;
    }


public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
