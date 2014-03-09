class A {
     void f() { System.out.println("A: doing f()"); }
     void g() { System.out.println("A: doing g()"); }
 }
 
 class C {
     // delegation
     A a = new A();
 
     void f() { a.f(); }
     void g() { a.g(); }
 
     // normal attributes
     // X x = new X();
     void y() { /* do stuff */ }
 }
 
 public class Main {
     public static void main(String[] args) {
         C c = new C();
         c.f();
         c.g();
     }
 }
