package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public abstract class Decl extends BlockStmt implements Cloneable {
    // Declared in picojava.ast line 6

    public Decl() {
        super();

    }

    // Declared in picojava.ast line 6
    public Decl(String p0) {
        setName(p0);
    }

    public Object clone() throws CloneNotSupportedException {
        Decl node = (Decl)super.clone();
        node.declarationOf_String_visited = new java.util.HashSet(4);
        node.isUnknown_visited = false;
        node.booleanType_visited = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public void flushCache() {
        super.flushCache();
        declarationOf_String_visited = new java.util.HashSet(4);
        isUnknown_visited = false;
        booleanType_visited = false;
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


    // Declared in TypeAnalysis.jrag at line 8
    public abstract TypeDecl type();
    // Declared in NameResolution.jrag at line 83
    protected java.util.Set declarationOf_String_visited = new java.util.HashSet(4);
    public Decl declarationOf(String name) {
        Object _parameters = name;
        if(declarationOf_String_visited.contains(_parameters))
            throw new RuntimeException("Circular definition of attr: declarationOf in class: ");
        declarationOf_String_visited.add(_parameters);
        Decl declarationOf_String_value = declarationOf_compute(name);
        declarationOf_String_visited.remove(_parameters);
        return declarationOf_String_value;
    }

    private Decl declarationOf_compute(String name)  {
    if (getName().equals(name)) return this;
    return null;
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

    private boolean isUnknown_compute() {  return  false;  }

    // Declared in PredefinedTypes.jrag at line 15
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
