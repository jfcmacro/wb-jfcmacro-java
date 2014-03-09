package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class Dot extends Access implements Cloneable {
    // Declared in picojava.ast line 16

    public Dot() {
        super();

        setChild(null, 0);
        setChild(null, 1);
    }

    // Declared in picojava.ast line 16
    public Dot(Access p0, IdUse p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    public Object clone() throws CloneNotSupportedException {
        Dot node = (Dot)super.clone();
        node.decl_visited = false;
        node.decl_computed = false;
        node.decl_value = null;
        node.type_visited = false;
        node.type_computed = false;
        node.type_value = null;
        node.isValue_visited = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          Dot node = (Dot)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        Dot res = (Dot)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
        super.flushCache();
        decl_visited = false;
        decl_computed = false;
        decl_value = null;
        type_visited = false;
        type_computed = false;
        type_value = null;
        isValue_visited = false;
    }
  protected int numChildren() {
    return 2;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in picojava.ast line 16
    public void setObjectReference(Access node) {
        setChild(node, 0);
    }
    public Access getObjectReference() {
        return (Access)getChild(0);
    }

    public Access getObjectReferenceNoTransform() {
        return (Access)getChildNoTransform(0);
    }


    // Declared in picojava.ast line 16
    public void setIdUse(IdUse node) {
        setChild(node, 1);
    }
    public IdUse getIdUse() {
        return (IdUse)getChild(1);
    }

    public IdUse getIdUseNoTransform() {
        return (IdUse)getChildNoTransform(1);
    }


    // Declared in NameResolution.jrag at line 10
    protected boolean decl_visited = false;
    protected boolean decl_computed = false;
    protected Decl decl_value;
    public Decl decl() {
        if(decl_computed)
            return decl_value;
        if(decl_visited)
            throw new RuntimeException("Circular definition of attr: decl in class: ");
        decl_visited = true;
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        decl_value = decl_compute();
        if(isFinal && num == boundariesCrossed)
            decl_computed = true;
        decl_visited = false;
        return decl_value;
    }

    private Decl decl_compute() {  return  getIdUse().decl();  }

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

    private TypeDecl type_compute() {  return  getIdUse().type();  }

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

    private boolean isValue_compute() {  return  getIdUse().isValue();  }

    // Declared in ErrorCheck.jadd at line 57
    public boolean Define_boolean_isQualified(ASTNode caller, ASTNode child) {
        if(caller == getIdUseNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_isQualified(this, caller);
    }

    // Declared in NameResolution.jrag at line 39
    public Decl Define_Decl_lookup(ASTNode caller, ASTNode child, String name) {
        if(caller == getIdUseNoTransform()) {
            return 
    // Do a remote lookup on the object's type.
    getObjectReference().decl().type().remoteLookup(name);
        }
        return getParent().Define_Decl_lookup(this, caller, name);
    }

    // Declared in ErrorCheck.jadd at line 67
    public Access Define_Access_qualifier(ASTNode caller, ASTNode child) {
        if(caller == getIdUseNoTransform()) {
            return  getObjectReference();
        }
        return getParent().Define_Access_qualifier(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
