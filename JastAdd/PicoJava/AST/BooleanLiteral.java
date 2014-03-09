package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class BooleanLiteral extends Exp implements Cloneable {
    // Declared in picojava.ast line 17

    public BooleanLiteral() {
        super();

    }

    // Declared in picojava.ast line 17
    public BooleanLiteral(String p0) {
        setValue(p0);
    }

    public Object clone() throws CloneNotSupportedException {
        BooleanLiteral node = (BooleanLiteral)super.clone();
        node.type_visited = false;
        node.type_computed = false;
        node.type_value = null;
        node.booleanType_visited = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          BooleanLiteral node = (BooleanLiteral)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        BooleanLiteral res = (BooleanLiteral)copy();
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
        booleanType_visited = false;
    }
  protected int numChildren() {
    return 0;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in picojava.ast line 17
    private String tokenString_Value;
    public void setValue(String value) {
        tokenString_Value = value;
    }
    public String getValue() {
        return tokenString_Value;
    }


    // Declared in TypeAnalysis.jrag at line 9
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

    private TypeDecl type_compute() {  return  booleanType();  }

    // Declared in PredefinedTypes.jrag at line 13
    protected boolean booleanType_visited = false;
    public PrimitiveDecl booleanType() {
        if(booleanType_visited)
            throw new RuntimeException("Circular definition of attr: booleanType in class: ");
        booleanType_visited = true;
        PrimitiveDecl booleanType_value = getParent().Define_PrimitiveDecl_booleanType(this, null);
        booleanType_visited = false;
        return booleanType_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
