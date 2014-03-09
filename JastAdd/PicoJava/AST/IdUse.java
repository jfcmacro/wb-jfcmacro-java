package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public abstract class IdUse extends Access implements Cloneable {
    // Declared in picojava.ast line 14

    public IdUse() {
        super();

    }

    // Declared in picojava.ast line 14
    public IdUse(String p0) {
        setName(p0);
    }

    public Object clone() throws CloneNotSupportedException {
        IdUse node = (IdUse)super.clone();
        node.decl_visited = false;
        node.decl_computed = false;
        node.decl_value = null;
        node.type_visited = false;
        node.type_computed = false;
        node.type_value = null;
        node.isQualified_visited = false;
        node.qualifier_visited = false;
        node.lookup_String_visited = new java.util.HashSet(4);
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public void flushCache() {
        super.flushCache();
        decl_visited = false;
        decl_computed = false;
        decl_value = null;
        type_visited = false;
        type_computed = false;
        type_value = null;
        isQualified_visited = false;
        qualifier_visited = false;
        lookup_String_visited = new java.util.HashSet(4);
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


    // Declared in ErrorCheck.jadd at line 48


  // add error for the first unbound name in a, possibly qualified, name 
  public void collectErrors(Collection c) {
    super.collectErrors(c);
    if(decl().isUnknown() && (!isQualified() || !qualifier().type().isUnknown()))
      error(c, "Unknown identifier " + getName());
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

    private Decl decl_compute() {  return  lookup(getName());  }

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

    private TypeDecl type_compute() {  return  decl().type();  }

    // Declared in ErrorCheck.jadd at line 58
    protected boolean isQualified_visited = false;
    public boolean isQualified() {
        if(isQualified_visited)
            throw new RuntimeException("Circular definition of attr: isQualified in class: ");
        isQualified_visited = true;
        boolean isQualified_value = getParent().Define_boolean_isQualified(this, null);
        isQualified_visited = false;
        return isQualified_value;
    }

    // Declared in ErrorCheck.jadd at line 68
    protected boolean qualifier_visited = false;
    public Access qualifier() {
        if(qualifier_visited)
            throw new RuntimeException("Circular definition of attr: qualifier in class: ");
        qualifier_visited = true;
        Access qualifier_value = getParent().Define_Access_qualifier(this, null);
        qualifier_visited = false;
        return qualifier_value;
    }

    // Declared in NameResolution.jrag at line 61
    protected java.util.Set lookup_String_visited = new java.util.HashSet(4);
    public Decl lookup(String name) {
        Object _parameters = name;
        if(lookup_String_visited.contains(_parameters))
            throw new RuntimeException("Circular definition of attr: lookup in class: ");
        lookup_String_visited.add(_parameters);
        Decl lookup_String_value = getParent().Define_Decl_lookup(this, null, name);
        lookup_String_visited.remove(_parameters);
        return lookup_String_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
