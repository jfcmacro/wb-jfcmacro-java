package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public abstract class TypeDecl extends Decl implements Cloneable {
    // Declared in picojava.ast line 7

    public TypeDecl() {
        super();

    }

    // Declared in picojava.ast line 7
    public TypeDecl(String p0) {
        setName(p0);
    }

    public Object clone() throws CloneNotSupportedException {
        TypeDecl node = (TypeDecl)super.clone();
        node.remoteLookup_String_visited = new java.util.HashSet(4);
        node.type_visited = false;
        node.type_computed = false;
        node.type_value = null;
        node.isSubtypeOf_TypeDecl_visited = new java.util.HashSet(4);
        node.isSubtypeOf_TypeDecl_values = new java.util.HashMap(4);
        node.isSuperTypeOf_TypeDecl_visited = new java.util.HashSet(4);
        node.isSuperTypeOf_TypeDecl_values = new java.util.HashMap(4);
        node.isSuperTypeOfClassDecl_ClassDecl_visited = new java.util.HashSet(4);
        node.isSuperTypeOfClassDecl_ClassDecl_values = new java.util.HashMap(4);
        node.isQualified_visited = false;
        node.qualifier_visited = false;
        node.lookup_String_visited = new java.util.HashSet(4);
        node.unknownDecl_visited = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public void flushCache() {
        super.flushCache();
        remoteLookup_String_visited = new java.util.HashSet(4);
        type_visited = false;
        type_computed = false;
        type_value = null;
        isSubtypeOf_TypeDecl_visited = new java.util.HashSet(4);
        isSubtypeOf_TypeDecl_values = new java.util.HashMap(4);
        isSuperTypeOf_TypeDecl_visited = new java.util.HashSet(4);
        isSuperTypeOf_TypeDecl_values = new java.util.HashMap(4);
        isSuperTypeOfClassDecl_ClassDecl_visited = new java.util.HashSet(4);
        isSuperTypeOfClassDecl_ClassDecl_values = new java.util.HashMap(4);
        isQualified_visited = false;
        qualifier_visited = false;
        lookup_String_visited = new java.util.HashSet(4);
        unknownDecl_visited = false;
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


    // Declared in NameResolution.jrag at line 46
    protected java.util.Set remoteLookup_String_visited = new java.util.HashSet(4);
    public Decl remoteLookup(String name) {
        Object _parameters = name;
        if(remoteLookup_String_visited.contains(_parameters))
            throw new RuntimeException("Circular definition of attr: remoteLookup in class: ");
        remoteLookup_String_visited.add(_parameters);
        Decl remoteLookup_String_value = remoteLookup_compute(name);
        remoteLookup_String_visited.remove(_parameters);
        return remoteLookup_String_value;
    }

    private Decl remoteLookup_compute(String name) {  return  unknownDecl();  }

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

    private TypeDecl type_compute() {  return  this;  }

    // Declared in TypeAnalysis.jrag at line 13
    protected java.util.Set isSubtypeOf_TypeDecl_visited = new java.util.HashSet(4);
    protected java.util.Map isSubtypeOf_TypeDecl_values = new java.util.HashMap(4);
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

    private boolean isSubtypeOf_compute(TypeDecl typeDecl) {  return  typeDecl.isSuperTypeOf(this);  }

    // Declared in TypeAnalysis.jrag at line 45
    protected java.util.Set isSuperTypeOf_TypeDecl_visited = new java.util.HashSet(4);
    protected java.util.Map isSuperTypeOf_TypeDecl_values = new java.util.HashMap(4);
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

    private boolean isSuperTypeOf_compute(TypeDecl typeDecl) {  return  this == typeDecl;  }

    // Declared in TypeAnalysis.jrag at line 46
    protected java.util.Set isSuperTypeOfClassDecl_ClassDecl_visited = new java.util.HashSet(4);
    protected java.util.Map isSuperTypeOfClassDecl_ClassDecl_values = new java.util.HashMap(4);
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

    private boolean isSuperTypeOfClassDecl_compute(ClassDecl typeDecl) {  return  
    this == typeDecl || typeDecl.superClass() != null && typeDecl.superClass().isSubtypeOf(this);  }

    // Declared in ErrorCheck.jadd at line 59
    protected boolean isQualified_visited = false;
    public boolean isQualified() {
        if(isQualified_visited)
            throw new RuntimeException("Circular definition of attr: isQualified in class: ");
        isQualified_visited = true;
        boolean isQualified_value = getParent().Define_boolean_isQualified(this, null);
        isQualified_visited = false;
        return isQualified_value;
    }

    // Declared in ErrorCheck.jadd at line 69
    protected boolean qualifier_visited = false;
    public Access qualifier() {
        if(qualifier_visited)
            throw new RuntimeException("Circular definition of attr: qualifier in class: ");
        qualifier_visited = true;
        Access qualifier_value = getParent().Define_Access_qualifier(this, null);
        qualifier_visited = false;
        return qualifier_value;
    }

    // Declared in NameResolution.jrag at line 63
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

    // Declared in NullObjects.jrag at line 20
    protected boolean unknownDecl_visited = false;
    public Decl unknownDecl() {
        if(unknownDecl_visited)
            throw new RuntimeException("Circular definition of attr: unknownDecl in class: ");
        unknownDecl_visited = true;
        Decl unknownDecl_value = getParent().Define_Decl_unknownDecl(this, null);
        unknownDecl_visited = false;
        return unknownDecl_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
