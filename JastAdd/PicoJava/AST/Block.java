package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class Block extends ASTNode implements Cloneable {
    // Declared in picojava.ast line 3

    public Block() {
        super();

        setChild(new List(), 0);
    }

    // Declared in picojava.ast line 3
    public Block(List p0) {
        setChild(p0, 0);
    }

    public Object clone() throws CloneNotSupportedException {
        Block node = (Block)super.clone();
        node.localLookup_String_visited = new java.util.HashSet(4);
        node.localLookup_String_values = new java.util.HashMap(4);
        node.lookup_String_visited = new java.util.HashSet(4);
        node.unknownDecl_visited = false;
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          Block node = (Block)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        Block res = (Block)copy();
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
        lookup_String_visited = new java.util.HashSet(4);
        unknownDecl_visited = false;
    }
  protected int numChildren() {
    return 1;
  }
  public boolean mayHaveRewrite() { return false; }
    // Declared in picojava.ast line 3
    public void setBlockStmtList(List list) {
        setChild(list, 0);
    }

    public int getNumBlockStmt() {
        return getBlockStmtList().getNumChild();
    }

    public BlockStmt getBlockStmt(int i) {
        return (BlockStmt)getBlockStmtList().getChild(i);
    }

    public void addBlockStmt(BlockStmt node) {
        List list = getBlockStmtList();
        list.setChild(node, list.getNumChild());
    }

    public void setBlockStmt(BlockStmt node, int i) {
        List list = getBlockStmtList();
        list.setChild(node, i);
    }
    public List getBlockStmtList() {
        return (List)getChild(0);
    }

    public List getBlockStmtListNoTransform() {
        return (List)getChildNoTransform(0);
    }


    // Declared in NameResolution.jrag at line 67
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
    for (int k = 0; k < getNumBlockStmt(); k++) {
      Decl d = getBlockStmt(k).declarationOf(name);
      if (d != null) return d;
    }
    return unknownDecl();
  }

    // Declared in NameResolution.jrag at line 62
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

    // Declared in NullObjects.jrag at line 21
    protected boolean unknownDecl_visited = false;
    public Decl unknownDecl() {
        if(unknownDecl_visited)
            throw new RuntimeException("Circular definition of attr: unknownDecl in class: ");
        unknownDecl_visited = true;
        Decl unknownDecl_value = getParent().Define_Decl_unknownDecl(this, null);
        unknownDecl_visited = false;
        return unknownDecl_value;
    }

    // Declared in NameResolution.jrag at line 23
    public Decl Define_Decl_lookup(ASTNode caller, ASTNode child, String name) {
        if(caller == getBlockStmtListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
 {
    // First, look in the local declarations
    if (!localLookup(name).isUnknown())
      return localLookup(name);
    // Then, look in surrounding context
    return lookup(name);
  }
}
        return getParent().Define_Decl_lookup(this, caller, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
