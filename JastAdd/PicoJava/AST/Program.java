package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class Program extends ASTNode implements Cloneable {
    // Declared in picojava.ast line 2

    public Program() {
        super();
        setChild(null, 0);

        setChild(null, 0);
        setChild(new List(), 1);
    }

    // Declared in picojava.ast line 2
    public Program(Block p0) {
        setChild(p0, 0);
        setChild(new List(), 1);
    }

    public Object clone() throws CloneNotSupportedException {
        Program node = (Program)super.clone();
        node.localLookup_String_visited = new java.util.HashSet(4);
        node.localLookup_String_values = new java.util.HashMap(4);
        node.unknownDecl_visited = false;
        node.unknownDecl_computed = false;
        node.unknownDecl_value = null;
        node.getPredefinedTypeList_visited = false;
        node.getPredefinedTypeList_computed = false;
        node.getPredefinedTypeList_value = null;
        node.booleanType_visited = false;
        node.booleanType_computed = false;
        node.booleanType_value = null;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          Program node = (Program)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        Program res = (Program)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
        super.flushCache();
        localLookup_String_visited = new java.util.HashSet(4);
        localLookup_String_values = new java.util.HashMap(4);
        unknownDecl_visited = false;
        unknownDecl_computed = false;
        unknownDecl_value = null;
        getPredefinedTypeList_visited = false;
        getPredefinedTypeList_computed = false;
        getPredefinedTypeList_value = null;
        booleanType_visited = false;
        booleanType_computed = false;
        booleanType_value = null;
    }
    {
        isFinal = true;
    }
  protected int numChildren() {
    return 1;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in picojava.ast line 2
    public void setBlock(Block node) {
        setChild(node, 0);
    }
    public Block getBlock() {
        return (Block)getChild(0);
    }

    public Block getBlockNoTransform() {
        return (Block)getChildNoTransform(0);
    }


    // Declared in picojava.ast line 2
    public void setPredefinedTypeList(List list) {
        setChild(list, 1);
    }

    public int getNumPredefinedType() {
        return getPredefinedTypeList().getNumChild();
    }

    public TypeDecl getPredefinedType(int i) {
        return (TypeDecl)getPredefinedTypeList().getChild(i);
    }

    public void addPredefinedType(TypeDecl node) {
        List list = getPredefinedTypeList();
        list.setChild(node, list.getNumChild());
    }

    public void setPredefinedType(TypeDecl node, int i) {
        List list = getPredefinedTypeList();
        list.setChild(node, i);
    }
    public List getPredefinedTypeListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    protected int getPredefinedTypeListChildPosition() {
        return 1;
    }


    // Declared in ErrorCheck.jadd at line 5

  public Collection errors() {
    Collection c = new ArrayList();
    collectErrors(c);
    return c;
  }

    // Declared in NameResolution.jrag at line 75
    protected java.util.Set localLookup_String_visited = new java.util.HashSet(4);
    protected java.util.Map localLookup_String_values = new java.util.HashMap(4);
    public Decl localLookup(String name) {
        Object _parameters = name;
        if(localLookup_String_values.containsKey(_parameters))
            return (Decl)localLookup_String_values.get(_parameters);
        if(localLookup_String_visited.contains(_parameters))
            throw new RuntimeException("Circular definition of attr: localLookup in class: ");
        localLookup_String_visited.add(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        Decl localLookup_String_value = localLookup_compute(name);
        if(isFinal && num == boundariesCrossed)
            localLookup_String_values.put(_parameters, localLookup_String_value);
        localLookup_String_visited.remove(_parameters);
        return localLookup_String_value;
    }

    private Decl localLookup_compute(String name)  {
    for (int k = 0; k < getNumPredefinedType(); k++) {
      Decl d = getPredefinedType(k).declarationOf(name);
      if (d != null) return d;
    }
    return unknownDecl();
  }

    // Declared in NullObjects.jrag at line 16
    protected boolean unknownDecl_visited = false;
    protected boolean unknownDecl_computed = false;
    protected UnknownDecl unknownDecl_value;
    public UnknownDecl unknownDecl() {
        if(unknownDecl_computed)
            return unknownDecl_value;
        if(unknownDecl_visited)
            throw new RuntimeException("Circular definition of attr: unknownDecl in class: ");
        unknownDecl_visited = true;
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        unknownDecl_value = unknownDecl_compute();
        if(isFinal && num == boundariesCrossed)
            unknownDecl_computed = true;
        unknownDecl_visited = false;
        return unknownDecl_value;
    }

    private UnknownDecl unknownDecl_compute() {  return  (UnknownDecl) localLookup("$unknown");  }

    // Declared in PredefinedTypes.jrag at line 3
    protected boolean getPredefinedTypeList_visited = false;
    protected boolean getPredefinedTypeList_computed = false;
    protected List getPredefinedTypeList_value;
    public List getPredefinedTypeList() {
        if(getPredefinedTypeList_computed)
            return (List)ASTNode.getChild(this, getPredefinedTypeListChildPosition());
        if(getPredefinedTypeList_visited)
            throw new RuntimeException("Circular definition of attr: getPredefinedTypeList in class: ");
        getPredefinedTypeList_visited = true;
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        getPredefinedTypeList_value = getPredefinedTypeList_compute();
        setPredefinedTypeList(getPredefinedTypeList_value);
        if(isFinal && num == boundariesCrossed)
            getPredefinedTypeList_computed = true;
        getPredefinedTypeList_visited = false;
        return (List)ASTNode.getChild(this, getPredefinedTypeListChildPosition());
    }

    private List getPredefinedTypeList_compute()  {
  return new List().
    add(new UnknownDecl("$unknown")).
    add(new PrimitiveDecl("boolean"));
  }

    // Declared in PredefinedTypes.jrag at line 10
    protected boolean booleanType_visited = false;
    protected boolean booleanType_computed = false;
    protected PrimitiveDecl booleanType_value;
    public PrimitiveDecl booleanType() {
        if(booleanType_computed)
            return booleanType_value;
        if(booleanType_visited)
            throw new RuntimeException("Circular definition of attr: booleanType in class: ");
        booleanType_visited = true;
        int num = boundariesCrossed;
        boolean isFinal = this.isFinal;
        booleanType_value = booleanType_compute();
        if(isFinal && num == boundariesCrossed)
            booleanType_computed = true;
        booleanType_visited = false;
        return booleanType_value;
    }

    private PrimitiveDecl booleanType_compute() {  return  (PrimitiveDecl) localLookup("boolean");  }

    // Declared in ErrorCheck.jadd at line 55
    public boolean Define_boolean_isQualified(ASTNode caller, ASTNode child) {
        if(caller == getBlockNoTransform()) {
            return  false;
        }
        if(caller == getPredefinedTypeListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isQualified(this, caller);
    }

    // Declared in NullObjects.jrag at line 17
    public Decl Define_Decl_unknownDecl(ASTNode caller, ASTNode child) {
        if(caller == getBlockNoTransform()) {
            return  unknownDecl();
        }
        if(caller == getPredefinedTypeListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  unknownDecl();
        }
        return getParent().Define_Decl_unknownDecl(this, caller);
    }

    // Declared in NameResolution.jrag at line 20
    public Decl Define_Decl_lookup(ASTNode caller, ASTNode child, String name) {
        if(caller == getBlockNoTransform()) {
            return  localLookup(name);
        }
        if(caller == getPredefinedTypeListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return  unknownDecl();
        }
        return getParent().Define_Decl_lookup(this, caller, name);
    }

    // Declared in PredefinedTypes.jrag at line 11
    public PrimitiveDecl Define_PrimitiveDecl_booleanType(ASTNode caller, ASTNode child) {
        if(caller == getBlockNoTransform()) {
            return  booleanType();
        }
        if(caller == getPredefinedTypeListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  booleanType();
        }
        return getParent().Define_PrimitiveDecl_booleanType(this, caller);
    }

    // Declared in ErrorCheck.jadd at line 61
    public Access Define_Access_qualifier(ASTNode caller, ASTNode child) {
        if(caller == getBlockNoTransform()) {
    throw new Error("Can not compute qualifier for non qualified names");
  }
        if(caller == getPredefinedTypeListNoTransform()) { 
   int i = caller.getIndexOfChild(child);
 {
    throw new Error("Can not compute qualifier for non qualified names");
  }
}
        return getParent().Define_Access_qualifier(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
