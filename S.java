public class S {
   private static class R {
      private Object r;
      R(Object r) {
         this.r = r;
      }
      Object get() {
         return r;
      }
      void set(Object r) {
         this.r = r;
      }
      @Override
      public String toString() {
         return r.toString();
      }
   }
   private static void s(R r1, R r2) {
      R t = new R(r1.get());
      r1.set(r2.get());
      r2.set(t.get());
   }
   public static void main(String[] args) {
       Integer i1 = 1;
       Integer i2 = 2;
       R r1 = new R(i1);
       R r2 = new R(i2);
       System.out.printf("%s %s%n", r1, r2);
       s(r1, r2);
       System.out.printf("%s %s%n", r1, r2);
   }
} 
