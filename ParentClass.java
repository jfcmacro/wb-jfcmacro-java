public class ParentClass {
    // Atributos
    private int valor;
    private String nombre;

    public ParentClass(int valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }
    // metodos

    public String obtNombre() {
        return nombre;
    }

    public int obtValor() {
        return valor;
    }

    public void ponerNombre(String nombre) {
        this.nombre = nombre;
    }

    public void ponerValor(int valor) {
        this.valor = valor;
    }
}
