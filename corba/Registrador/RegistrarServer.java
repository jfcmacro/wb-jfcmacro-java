import Registrador.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
import java.util.Map;
import java.util.Hashtable;

class RegistrarImpl extends RegistrarPOA {
   
    private Map lista;
    
    public RegistrarImpl() {
	lista = new Hashtable();
    }
    
    public void registrarHola (String nombre, Registrador.HolaMundo hola) {
	
	lista.put(nombre, hola);
    }
    
    public void removeHola (String nombre) {

	lista.remove(nombre);
    }

    public Registrador.HolaMundo obtenerHola(String nombre){
	
	return (Registrador.HolaMundo) lista.get(nombre);
    }
}

public class RegistrarServer {

  public static void main(String args[]) {
    try{
      // Crea e inicializa el Servidor
      ORB orb = ORB.init(args, null);

      // Obtiene una referencia al rootpoa 
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // Crea el servidor y lo registra con el ORB
      RegistrarImpl registrarImpl = new RegistrarImpl();

      // Obtiene la referencia del servidor
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(registrarImpl);
      Registrar href = RegistrarHelper.narrow(ref);

      // Obtiene el contexto de nombres raiz
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Utiliza NamingContextExt el cual es parte del interorable
      // de la especificacion del servicio de nombres
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // Encadena la referencia del objeto al servicio de nombres
      String name = "Registrar";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("RegistrarServer registrar y esperando ...");

      // wait for invocations from clients
      orb.run();
    } 
        
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
          
      System.out.println("RegistrarServer Terminando ...");
        
  }
}
