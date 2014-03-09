package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class VarDecl extends Decl implements Cloneable {
    // Declared in picojava.ast line 9

    public VarDecl() {
        super();

        setChild(null, 0);
    }

    // Declared in picojava.ast line 9
    public VarDecl(String p0, Access p1) {
        setName(p0);
        setChild(p1, 0);
    }

    public Object clone() throws CloneNotSupportedException {
        VarDecl node = (VarDecl)super.clone();
        node.type_visited = false;
        node.type_computed = false;
        node.type_value = null;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          VarDecl node = (VarDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        VarDecl res = (VarDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
        super.flushCache();
        type_visited = false;
        type_computed = false;
        type_value = null;
    }
  protected int numChildren() {
    return 1;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in picojava.ast line 6
    private String tokenString_Name;
    public void setName(String value) {
        tokenString_Name = value;
    }
    public String getName() {
        return tokenString_Name;
    }


    // Declared in picojava.ast line 9
    public void setType(Access node) {
        setChild(node, 0);
    }
    public Access getType() {
        return (Access)getChild(0);
    }

    public Access getTypeNoTransform() {
        return (Access)getChildNoTransform(0);
    }


    // Declared in TypeAnalysis.jrag at line 8
    protected boolean type_visited = false;
    protected boolean type_computed = false;
    protected TypeDecl type_value;
    public TypeDecl type() {
        if(type_computed)
            return type_value;
        if(type_visited)
            throw new RuntimeException("Circular definition of attr: type in class: ");
        type_visited = true;
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        type_value = type_compute();
        if(isFinal && num == boundariesCrossed)
            type_computed = true;
        type_visited = false;
        return type_value;
    }

    private TypeDecl type_compute() {  return  getType().decl().type();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
