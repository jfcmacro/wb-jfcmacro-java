interface I {
     void f();
     void g();
}
 
class A implements I {
    public void f() { System.out.println("A: doing f()"); }
    public void g() { System.out.println("A: doing g()"); }
}
 
class B implements I {
    public void f() { System.out.println("B: doing f()"); }
    public void g() { System.out.println("B: doing g()"); }
}
 
class C implements I {
    // delegation
    I i = new A();
    
    public void f() { i.f(); }
    public void g() { i.g(); }
    
    // normal attributes
    void toA() { i = new A(); }
    void toB() { i = new B(); }
}
 
 
public class Main2 {
    public static void main(String[] args) {
	C c = new C();
	c.f();
	c.g();
	c.toB();
	c.f();
	c.g();
    }
}
