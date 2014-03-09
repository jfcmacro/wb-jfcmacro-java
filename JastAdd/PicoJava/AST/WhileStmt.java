package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class WhileStmt extends Stmt implements Cloneable {
    // Declared in picojava.ast line 11

    public WhileStmt() {
        super();

        setChild(null, 0);
        setChild(null, 1);
    }

    // Declared in picojava.ast line 11
    public WhileStmt(Exp p0, Stmt p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    public Object clone() throws CloneNotSupportedException {
        WhileStmt node = (WhileStmt)super.clone();
        node.booleanType_visited = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          WhileStmt node = (WhileStmt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        WhileStmt res = (WhileStmt)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
        super.flushCache();
        booleanType_visited = false;
    }
  protected int numChildren() {
    return 2;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in picojava.ast line 11
    public void setCondition(Exp node) {
        setChild(node, 0);
    }
    public Exp getCondition() {
        return (Exp)getChild(0);
    }

    public Exp getConditionNoTransform() {
        return (Exp)getChildNoTransform(0);
    }


    // Declared in picojava.ast line 11
    public void setBody(Stmt node) {
        setChild(node, 1);
    }
    public Stmt getBody() {
        return (Stmt)getChild(1);
    }

    public Stmt getBodyNoTransform() {
        return (Stmt)getChildNoTransform(1);
    }


    // Declared in ErrorCheck.jadd at line 39


  // add error for non-boolean condition in while
  public void collectErrors(Collection c) {
    super.collectErrors(c);
    if(!getCondition().type().isSubtypeOf(booleanType()))
      error(c, "Condition must be a boolean expression");
    if(!getCondition().isValue())
      error(c, "Condition must be a value");
  }

    // Declared in PredefinedTypes.jrag at line 14
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
