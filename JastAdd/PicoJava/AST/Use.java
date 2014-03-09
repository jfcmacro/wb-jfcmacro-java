package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;

public class Use extends IdUse implements Cloneable {
    // Declared in picojava.ast line 15

    public Use() {
        super();

    }

    // Declared in picojava.ast line 15
    public Use(String p0) {
        setName(p0);
    }

    public Object clone() throws CloneNotSupportedException {
        Use node = (Use)super.clone();
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          Use node = (Use)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        Use res = (Use)copy();
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
    return 0;
  }
  public boolean mayHaveRewrite() { return true; }
    // Declared in picojava.ast line 14
    private String tokenString_Name;
    public void setName(String value) {
        tokenString_Name = value;
    }
    public String getName() {
        return tokenString_Name;
    }


public ASTNode rewriteTo() {
    // Declared in TypeAnalysis.jrag at line 75
    if(decl() instanceof VarDecl) {
        duringTypeAnalysis++;
        ASTNode result = rewriteRule0();
        duringTypeAnalysis--;
        return result;
    }

    // Declared in TypeAnalysis.jrag at line 80
    if(decl() instanceof TypeDecl) {
        duringTypeAnalysis++;
        ASTNode result = rewriteRule1();
        duringTypeAnalysis--;
        return result;
    }

    return super.rewriteTo();
}

    // Declared in TypeAnalysis.jrag at line 75
    private VariableUse rewriteRule0() {
        return  new VariableUse(getName());
    }
    // Declared in TypeAnalysis.jrag at line 80
    private TypeUse rewriteRule1() {
        return  new TypeUse(getName());
    }
}
