   


  package enumTest;
  import java.util.*;
   
  public final class Mes {
    private String id;
    public final int ord; 
    private Mes prev;
    private Mes next;

    private static int Hola = 0;
    private static Mes first = null;
    private static Mes last = null;
    
    private Mes(String anID) {
      this.id = anID;
      this.ord = Hola++;
      if (first == null) first = this;
      if (last != null) {
        this.prev = last;
        last.next = this;
      }
      last = this;
    }
    public static Enumeration elements() {
      return new Enumeration() {
        private Mes n = first;
        public boolean hasMoreElements() {
          return n != null;
        }
        public Object nextElement() {
          Mes c = n;
          n = n.next();
          return c;
        }
      };
    }
    public String toString() {return this.id; }
    public static int size() { return Hola; }
    public static Mes first() { return first; }
    public static Mes last()  { return last;  }
    public Mes prev()  { return this.prev; }
    public Mes next()  { return this.next; }

    public static final Mes ENERO = new Mes("Enero");
    public static final Mes FEBRERO = new Mes("Febrero");
    public static final Mes MARZO = new Mes("Marzo");
    public static final Mes ABRIL = new Mes("Abril");
    public static final Mes MAYO = new Mes("Mayo");
    public static final Mes JUNIO = new Mes("Junio");
    public static final Mes JULIO = new Mes("Julio");
    public static final Mes AGOSTO = new Mes("Agosto");
    public static final Mes SEPTIEMBRE = new Mes("Septiembre");
    public static final Mes OCTUBRE= new Mes("Octubre");
    public static final Mes NOVIEMBRE = new Mes("Noviembre");
    public static final Mes DICIEMBRE= new Mes("Diciembre");
    
}





  
