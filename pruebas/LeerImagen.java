import java.io.*;
import java.math.*;

class LeerImagen{

   private String nombre;
   private DataInputStream input;
   //private BufferedReader input;
   public LeerImagen(String cadena){
		
		nombre=cadena;
   }
   
   public int tomarDatos(){
   
   		int valor=0;
	byte temp;
		byte []cadena=new byte[32];
	
  		boolean continuar = true;
  	
		try {
	    	//put = new BufferedReader(new InputStreamReader(System.in,"4"));
	    	input= new DataInputStream (new BufferedInputStream (new FileInputStream(nombre)));
		}
		catch ( IOException e ) {
	    	System.err.println( "No se pudo abrir el archivo !!!!"+e.getMessage());
	    	System.exit( 1 );
		}

		try {

//       	try {
//       			for(int i=0;i<32;i++){
//       	
//    				
//    				temp= input.readByte();			
//    				cadena[i]=temp;
//					
//   			}
//		}
//		catch ( EOFException eof ) {
//	    	continuar = false;
//		}
		
		input.readInt();
		int width = input.readInt();
		int height = input.readInt();
		int depth = input.readInt();
		int length = input.readInt();
		int type = input.readInt();
		int colorMapType = input.readInt();
		int colorMapLength = input.readInt();

		valor = width;
		System.out.println("Width: " + width + " height: " + height +
				   " depth: " + depth + " length: " + length +
				   " type: " + type + " colorMapType: " + colorMapType +
				   " colorMapLength: " + colorMapLength);
		}
		catch ( IOException e ) {
		    System.err.println( "Error durante la lectura del archivo");
		    System.exit( 1 );
		}

		return valor;
    }
    
    public static void main(String args[]){
    	
    	int resultado;
    //	args[0]="imagen";
    	
    	LeerImagen L=new LeerImagen("screen.ras");
    	
    	resultado=(int)L.tomarDatos();
    	
    	System.out.println("Los bytes leidos representan "+resultado);
    
    }
}

