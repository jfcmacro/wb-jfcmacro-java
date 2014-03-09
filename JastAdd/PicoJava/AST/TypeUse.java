package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class TypeUse extends IdUse implements Cloneable {
    // Declared in picojava.ast line 24

    public TypeUse() {
        super();

    }

    // Declared in picojava.ast line 24
    public TypeUse(String p0) {
        setName(p0);
    }

    public Object clone() throws CloneNotSupportedException {
        TypeUse node = (TypeUse)super.clone();
        node.isValue_visited = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          TypeUse node = (TypeUse)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        TypeUse res = (TypeUse)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
        super.flushCache();
        isValue_visited = false;
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

    private boolean isValue_compute() {  return  false;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
