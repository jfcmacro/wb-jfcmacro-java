
public class Main {

    public static void  main(String []Args) {
	IEncendido unTocadiscos = new Tocadiscos();
	unTocadiscos.presionar();
	unTocadiscos.presionar();
	unTocadiscos.presionar();
	unTocadiscos.presionar();
	unTocadiscos.presionar();
	unTocadiscos.presionar();
	IEncendido unDisp = new IEncendido() {
		boolean estado = false;
		public void presionar() {
		    estado = !estado;
		}
	    };
	unDisp.presionar();
	unDisp.presionar();
	unDisp.presionar();unDisp.presionar();unDisp.presionar();
	
    }
}
