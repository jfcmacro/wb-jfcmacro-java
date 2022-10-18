public class Tocadiscos implements IEncendido {
    private boolean estado = false; 
    public void presionar() {
	estado = !estado;
    }
}
