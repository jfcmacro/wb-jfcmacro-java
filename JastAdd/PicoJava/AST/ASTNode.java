package AST;
import java.util.Collection;
import java.util.ArrayList;import java.util.HashSet;


// Generated with JastAdd II (http://jastadd.cs.lth.se) version R20060915

public class ASTNode extends beaver.Symbol  implements Cloneable {
    // Declared in null line 0

    public ASTNode() {
        super();

    }

    public Object clone() throws CloneNotSupportedException {
        ASTNode node = (ASTNode)super.clone();
        node.inCircle = false;
        node.isFinal = false;
    return node;
    }
    public ASTNode copy() {
      try {
          ASTNode node = (ASTNode)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ASTNode res = (ASTNode)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    public void flushCache() {
    }
    public boolean Define_boolean_isQualified(ASTNode caller, ASTNode child) {
        return getParent().Define_boolean_isQualified(this, caller);
    }
    public Decl Define_Decl_unknownDecl(ASTNode caller, ASTNode child) {
        return getParent().Define_Decl_unknownDecl(this, caller);
    }
    public Decl Define_Decl_lookup(ASTNode caller, ASTNode child, String name) {
        return getParent().Define_Decl_lookup(this, caller, name);
    }
    public PrimitiveDecl Define_PrimitiveDecl_booleanType(ASTNode caller, ASTNode child) {
        return getParent().Define_PrimitiveDecl_booleanType(this, caller);
    }
    public Access Define_Access_qualifier(ASTNode caller, ASTNode child) {
        return getParent().Define_Access_qualifier(this, caller);
    }
   static public boolean generatedWithCircularEnabled = true;
   static public boolean generatedWithCacheCycle = true;
   static public boolean generatedWithComponentCheck = false;
  static public boolean IN_CIRCLE = false;
  static public boolean CHANGE = false;
  static public boolean LAST_CYCLE = false;
  public static int boundariesCrossed = 0;

  static class State {
   private int[] stack;
   private int pos;
   public State() {
     stack = new int[64];
     pos = 0;
   }
   private void ensureSize(int size) {
     if(size < stack.length)
       return;
     int[] newStack = new int[stack.length * 2];
     System.arraycopy(stack, 0, newStack, 0, stack.length);
     stack = newStack;
   }
   public void push(int i) {
     ensureSize(pos+1);
     stack[pos++] = i;
   }
   public int pop() {
     return stack[--pos];
   }
   public int peek() {
     return stack[pos-1];
   }
  }
  protected static State state = new State();
  public boolean inCircle = false;
  public boolean isFinal = false;
  protected static final int REWRITE_CHANGE = 1;
  protected static final int REWRITE_NOCHANGE = 2;
  protected static final int REWRITE_INTERRUPT = 3;
  public ASTNode getChild(int i) {
    return ASTNode.getChild(this, i);
  }
  public static ASTNode getChild(ASTNode that, int i) {
    ASTNode node = that.getChildNoTransform(i);
    if(node.isFinal) return node;
    if(!node.mayHaveRewrite()) {
      node.isFinal = that.isFinal;
      return node;
    }
    if(!node.inCircle) {
      int rewriteState;
      int num = ASTNode.boundariesCrossed;
      do {
        ASTNode.state.push(ASTNode.REWRITE_CHANGE);
        ASTNode oldNode = node;
        oldNode.inCircle = true;
        node = node.rewriteTo();
        oldNode.inCircle = false;
        that.setChild(node, i);
        rewriteState = state.pop();
      } while(rewriteState == ASTNode.REWRITE_CHANGE);
      if(rewriteState == ASTNode.REWRITE_NOCHANGE && that.isFinal) {
        node.isFinal = true;
        ASTNode.boundariesCrossed = num;
      }
    }
    else if(that.isFinal != node.isFinal) boundariesCrossed++;
    return node;
  }
  private int childIndex;
  public int getIndexOfChild(ASTNode node) {
    if(node.childIndex < getNumChild() && node == getChildNoTransform(node.childIndex))
      return node.childIndex;
    for(int i = 0; i < getNumChild(); i++)
      if(getChildNoTransform(i) == node) {
        node.childIndex = i;
        return i;
      }
    return -1;
  }

  public void addChild(ASTNode node) {
    setChild(node, getNumChild());
  }
  public ASTNode getChildNoTransform(int i) {
    return children[i];
  }
  protected ASTNode parent;
  protected ASTNode[] children;
  protected int numChildren;
  protected int numChildren() {
    return numChildren;
  }
  public int getNumChild() {
    return numChildren();
  }
  public void setChild(ASTNode node, int i) {
    if(children == null) {
      children = new ASTNode[i + 1];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if(i >= numChildren) numChildren = i+1;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }
  public void insertChild(ASTNode node, int i) {
    if(children == null) {
      children = new ASTNode[i + 1];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if(i < children.length)
        System.arraycopy(children, i, c, i+1, children.length-i);
      children = c;
    }
    numChildren++;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }
  public ASTNode getParent() {
    if(parent != null && parent.isFinal != isFinal) {
      boundariesCrossed++;
    }
    return parent;
  }
  public void setParent(ASTNode node) {
    parent = node;
  }
    protected static int duringTypeAnalysis = 0;
    protected static boolean duringTypeAnalysis() {
        if(duringTypeAnalysis == 0) {
            return false;
        }
        else {
            state.pop();
            state.push(ASTNode.REWRITE_INTERRUPT);
            return true;
        }
    }
  public boolean mayHaveRewrite() { return false; }
    // Declared in ErrorCheck.jadd at line 12


  // generic traversal that collects errors in AST
  public void collectErrors(Collection c) {
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).collectErrors(c);
  }

    // Declared in ErrorCheck.jadd at line 18


  // add an error msg associated with a certain context
  protected void error(Collection c, String s) {
    //c.add(getLine(getStart()) + ": " + s);
    c.add(s);
  }

public ASTNode rewriteTo() {
    if(state.peek() == ASTNode.REWRITE_CHANGE) {
        state.pop();
        state.push(ASTNode.REWRITE_NOCHANGE);
    }
    return this;
}

}
