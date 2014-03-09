package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class AssignStmt extends Stmt implements Cloneable {
    // Declared in picojava.ast line 10

    public AssignStmt() {
        super();

        setChild(null, 0);
        setChild(null, 1);
    }

    // Declared in picojava.ast line 10
    public AssignStmt(Access p0, Exp p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    public Object clone() throws CloneNotSupportedException {
        AssignStmt node = (AssignStmt)super.clone();
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          AssignStmt node = (AssignStmt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        AssignStmt res = (AssignStmt)copy();
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
    return 2;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in picojava.ast line 10
    public void setVariable(Access node) {
        setChild(node, 0);
    }
    public Access getVariable() {
        return (Access)getChild(0);
    }

    public Access getVariableNoTransform() {
        return (Access)getChildNoTransform(0);
    }


    // Declared in picojava.ast line 10
    public void setValue(Exp node) {
        setChild(node, 1);
    }
    public Exp getValue() {
        return (Exp)getChild(1);
    }

    public Exp getValueNoTransform() {
        return (Exp)getChildNoTransform(1);
    }


    // Declared in ErrorCheck.jadd at line 24


  // add error for incompatible assignment
  public void collectErrors(Collection c) {
    super.collectErrors(c);
    if(!getValue().type().isSubtypeOf(getVariable().type()))
      error(c, "Can not assign a variable of type " + getVariable().type().getName() +
        " to a value of type " + getValue().type().getName());
  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
