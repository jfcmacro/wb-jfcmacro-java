package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class UnknownDecl extends TypeDecl implements Cloneable {
    // Declared in picojava.ast line 21

    public UnknownDecl() {
        super();

    }

    // Declared in picojava.ast line 21
    public UnknownDecl(String p0) {
        setName(p0);
    }

    public Object clone() throws CloneNotSupportedException {
        UnknownDecl node = (UnknownDecl)super.clone();
        node.isUnknown_visited = false;
        node.isSubtypeOf_TypeDecl_visited = new java.util.HashSet(4);
        node.isSubtypeOf_TypeDecl_values = new java.util.HashMap(4);
        node.isSuperTypeOf_TypeDecl_visited = new java.util.HashSet(4);
        node.isSuperTypeOf_TypeDecl_values = new java.util.HashMap(4);
        node.isSuperTypeOfClassDecl_ClassDecl_visited = new java.util.HashSet(4);
        node.isSuperTypeOfClassDecl_ClassDecl_values = new java.util.HashMap(4);
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          UnknownDecl node = (UnknownDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        UnknownDecl res = (UnknownDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
        super.flushCache();
        isUnknown_visited = false;
        isSubtypeOf_TypeDecl_visited = new java.util.HashSet(4);
        isSubtypeOf_TypeDecl_values = new java.util.HashMap(4);
        isSuperTypeOf_TypeDecl_visited = new java.util.HashSet(4);
        isSuperTypeOf_TypeDecl_values = new java.util.HashMap(4);
        isSuperTypeOfClassDecl_ClassDecl_visited = new java.util.HashSet(4);
        isSuperTypeOfClassDecl_ClassDecl_values = new java.util.HashMap(4);
    }
  protected int numChildren() {
    return 0;
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


    // Declared in NullObjects.jrag at line 5
    protected boolean isUnknown_visited = false;
    public boolean isUnknown() {
        if(isUnknown_visited)
            throw new RuntimeException("Circular definition of attr: isUnknown in class: ");
        isUnknown_visited = true;
        boolean isUnknown_value = isUnknown_compute();
        isUnknown_visited = false;
        return isUnknown_value;
    }

    private boolean isUnknown_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 13
    protected java.util.Set isSubtypeOf_TypeDecl_visited = new java.util.HashSet(4);
    public boolean isSubtypeOf(TypeDecl typeDecl) {
        Object _parameters = typeDecl;
        if(isSubtypeOf_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)isSubtypeOf_TypeDecl_values.get(_parameters)).booleanValue();
        if(isSubtypeOf_TypeDecl_visited.contains(_parameters))
            throw new RuntimeException("Circular definition of attr: isSubtypeOf in class: ");
        isSubtypeOf_TypeDecl_visited.add(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        boolean isSubtypeOf_TypeDecl_value = isSubtypeOf_compute(typeDecl);
        if(isFinal && num == boundariesCrossed)
            isSubtypeOf_TypeDecl_values.put(_parameters, Boolean.valueOf(isSubtypeOf_TypeDecl_value));
        isSubtypeOf_TypeDecl_visited.remove(_parameters);
        return isSubtypeOf_TypeDecl_value;
    }

    private boolean isSubtypeOf_compute(TypeDecl typeDecl) {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 45
    protected java.util.Set isSuperTypeOf_TypeDecl_visited = new java.util.HashSet(4);
    public boolean isSuperTypeOf(TypeDecl typeDecl) {
        Object _parameters = typeDecl;
        if(isSuperTypeOf_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)isSuperTypeOf_TypeDecl_values.get(_parameters)).booleanValue();
        if(isSuperTypeOf_TypeDecl_visited.contains(_parameters))
            throw new RuntimeException("Circular definition of attr: isSuperTypeOf in class: ");
        isSuperTypeOf_TypeDecl_visited.add(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        boolean isSuperTypeOf_TypeDecl_value = isSuperTypeOf_compute(typeDecl);
        if(isFinal && num == boundariesCrossed)
            isSuperTypeOf_TypeDecl_values.put(_parameters, Boolean.valueOf(isSuperTypeOf_TypeDecl_value));
        isSuperTypeOf_TypeDecl_visited.remove(_parameters);
        return isSuperTypeOf_TypeDecl_value;
    }

    private boolean isSuperTypeOf_compute(TypeDecl typeDecl) {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 46
    protected java.util.Set isSuperTypeOfClassDecl_ClassDecl_visited = new java.util.HashSet(4);
    public boolean isSuperTypeOfClassDecl(ClassDecl typeDecl) {
        Object _parameters = typeDecl;
        if(isSuperTypeOfClassDecl_ClassDecl_values.containsKey(_parameters))
            return ((Boolean)isSuperTypeOfClassDecl_ClassDecl_values.get(_parameters)).booleanValue();
        if(isSuperTypeOfClassDecl_ClassDecl_visited.contains(_parameters))
            throw new RuntimeException("Circular definition of attr: isSuperTypeOfClassDecl in class: ");
        isSuperTypeOfClassDecl_ClassDecl_visited.add(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        boolean isSuperTypeOfClassDecl_ClassDecl_value = isSuperTypeOfClassDecl_compute(typeDecl);
        if(isFinal && num == boundariesCrossed)
            isSuperTypeOfClassDecl_ClassDecl_values.put(_parameters, Boolean.valueOf(isSuperTypeOfClassDecl_ClassDecl_value));
        isSuperTypeOfClassDecl_ClassDecl_visited.remove(_parameters);
        return isSuperTypeOfClassDecl_ClassDecl_value;
    }

    private boolean isSuperTypeOfClassDecl_compute(ClassDecl typeDecl) {  return  true;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
