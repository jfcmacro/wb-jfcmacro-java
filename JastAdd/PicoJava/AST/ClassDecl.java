package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class ClassDecl extends TypeDecl implements Cloneable {
    // Declared in picojava.ast line 8

    public ClassDecl() {
        super();

        setChild(new Opt(), 0);
        setChild(null, 1);
    }

    // Declared in picojava.ast line 8
    public ClassDecl(String p0, Opt p1, Block p2) {
        setName(p0);
        setChild(p1, 0);
        setChild(p2, 1);
    }

    public Object clone() throws CloneNotSupportedException {
        ClassDecl node = (ClassDecl)super.clone();
        node.remoteLookup_String_visited = new java.util.HashSet(4);
        node.isSubtypeOf_TypeDecl_visited = new java.util.HashSet(4);
        node.isSubtypeOf_TypeDecl_values = new java.util.HashMap(4);
        node.superClass_visited = false;
        node.superClass_computed = false;
        node.superClass_value = null;
        node.hasCycleOnSuperclassChain_visited = false;
        node.hasCycleOnSuperclassChain_computed = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          ClassDecl node = (ClassDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ClassDecl res = (ClassDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
        super.flushCache();
        remoteLookup_String_visited = new java.util.HashSet(4);
        isSubtypeOf_TypeDecl_visited = new java.util.HashSet(4);
        isSubtypeOf_TypeDecl_values = new java.util.HashMap(4);
        superClass_visited = false;
        superClass_computed = false;
        superClass_value = null;
        hasCycleOnSuperclassChain_visited = false;
        hasCycleOnSuperclassChain_computed = false;
    }
  protected int numChildren() {
    return 2;
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


    // Declared in picojava.ast line 8
    public void setSuperclassOpt(Opt opt) {
        setChild(opt, 0);
    }

    public boolean hasSuperclass() {
        return getSuperclassOpt().getNumChild() != 0;
    }

    public IdUse getSuperclass() {
        return (IdUse)getSuperclassOpt().getChild(0);
    }

    public void setSuperclass(IdUse node) {
        getSuperclassOpt().setChild(node, 0);
    }
    public Opt getSuperclassOpt() {
        return (Opt)getChild(0);
    }

    public Opt getSuperclassOptNoTransform() {
        return (Opt)getChildNoTransform(0);
    }


    // Declared in picojava.ast line 8
    public void setBody(Block node) {
        setChild(node, 1);
    }
    public Block getBody() {
        return (Block)getChild(1);
    }

    public Block getBodyNoTransform() {
        return (Block)getChildNoTransform(1);
    }


    // Declared in ErrorCheck.jadd at line 32

  
  // add error for cyclic class hierarchy
  public void collectErrors(Collection c) {
    super.collectErrors(c);
    if(hasCycleOnSuperclassChain())
      error(c, "Cyclic inheritance chain for class " + getName());
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

    private Decl remoteLookup_compute(String name)  {
    // First, look in local declarations
    if (!getBody().localLookup(name).isUnknown())
      return getBody().localLookup(name); 
    // Then, look in the superclass chain
    if (superClass() != null && !superClass().remoteLookup(name).isUnknown())
      return superClass().remoteLookup(name);
    // Otherwise, return null object unknown
    return unknownDecl();
  }

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

    private boolean isSubtypeOf_compute(TypeDecl typeDecl) {  return  typeDecl.isSuperTypeOfClassDecl(this);  }

    // Declared in TypeAnalysis.jrag at line 26
    protected boolean superClass_visited = false;
    protected boolean superClass_computed = false;
    protected ClassDecl superClass_value;
    public ClassDecl superClass() {
        if(superClass_computed)
            return superClass_value;
        if(superClass_visited)
            throw new RuntimeException("Circular definition of attr: superClass in class: ");
        superClass_visited = true;
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        superClass_value = superClass_compute();
        if(isFinal && num == boundariesCrossed)
            superClass_computed = true;
        superClass_visited = false;
        return superClass_value;
    }

    private ClassDecl superClass_compute()  {
    if (hasSuperclass() && getSuperclass().decl() instanceof ClassDecl && !hasCycleOnSuperclassChain())
      return (ClassDecl) getSuperclass().decl();
    else
      return null;
  }

    // Declared in TypeAnalysis.jrag at line 21
    protected boolean hasCycleOnSuperclassChain_visited = false;
    protected boolean hasCycleOnSuperclassChain_computed = false;
    protected boolean hasCycleOnSuperclassChain_initialized = false;
    protected boolean hasCycleOnSuperclassChain_value;
    public boolean hasCycleOnSuperclassChain() {
        if(hasCycleOnSuperclassChain_computed)
            return hasCycleOnSuperclassChain_value;
        if (!hasCycleOnSuperclassChain_initialized) {
            hasCycleOnSuperclassChain_initialized = true;
            hasCycleOnSuperclassChain_value = true;
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            hasCycleOnSuperclassChain_visited = true;
            do {
                CHANGE = false;
                boolean new_hasCycleOnSuperclassChain_value = hasCycleOnSuperclassChain_compute();
                if (new_hasCycleOnSuperclassChain_value!=hasCycleOnSuperclassChain_value)
                    CHANGE = true;
                hasCycleOnSuperclassChain_value = new_hasCycleOnSuperclassChain_value; 
            } while (CHANGE);
            hasCycleOnSuperclassChain_visited = false;
            hasCycleOnSuperclassChain_computed = true;
            LAST_CYCLE = true;
            hasCycleOnSuperclassChain_compute();
            LAST_CYCLE = false;
            IN_CIRCLE = false; 
            return hasCycleOnSuperclassChain_value;
        }
        if(!hasCycleOnSuperclassChain_visited) {
            if (LAST_CYCLE) {
                hasCycleOnSuperclassChain_computed = true;
                return hasCycleOnSuperclassChain_compute();
            }
            hasCycleOnSuperclassChain_visited = true;
            boolean new_hasCycleOnSuperclassChain_value = hasCycleOnSuperclassChain_compute();
            if (new_hasCycleOnSuperclassChain_value!=hasCycleOnSuperclassChain_value)
                CHANGE = true;
            hasCycleOnSuperclassChain_value = new_hasCycleOnSuperclassChain_value; 
            hasCycleOnSuperclassChain_visited = false;
            return hasCycleOnSuperclassChain_value;
        }
        return hasCycleOnSuperclassChain_value;
    }

    private boolean hasCycleOnSuperclassChain_compute()  {
    if (hasSuperclass() && getSuperclass().decl() instanceof ClassDecl) //First, check if there is a superclass
      return ((ClassDecl) getSuperclass().decl()).hasCycleOnSuperclassChain();
    else
      return false;
  }

    // Declared in NameResolution.jrag at line 31
    public Decl Define_Decl_lookup(ASTNode caller, ASTNode child, String name) {
        if(caller == getBodyNoTransform()) {
    // First, look in superclass chain
    if (superClass() != null && !superClass().remoteLookup(name).isUnknown())
      return superClass().remoteLookup(name);
    // Then, look in surrounding context
    return lookup(name);
  }
        return getParent().Define_Decl_lookup(this, caller, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
