public class ChildClass extends ParentClass { // ChildClass es un ParentClass
    

    private float salario;

    public ChildClass(int valor, String nombre, float salario) {
        super(valor, nombre);
        this.salario = salario;
    }
    // metodos

    public float obtSalario() {
        return salario;
    }

    public void ponerSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public int obtValor() {
        ponerValor(super.obtValor() + 1);
        return super.obtValor();
    }

}
