import Coleccion.*;
import Coleccion.ListaPackage.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
import java.util.Map;
import java.util.Hashtable;

class ListaImpl extends ListaPOA {
   
    private Map lista;
    
    public ListaImpl() {
	lista = new Hashtable();
    }
    
    public boolean Adicionar(String nombre) {
	
	if (lista.containsKey(nombre))
	    return false;

	lista.put(nombre, nombre);
	return true;
    }
    
    public void Borrar (String nombre) 
	throws NoExiste {

	if (lista.remove(nombre) == null) {
	    throw new NoExiste();
	}
    }

    public boolean Consultar(String nombre){
	
	if (lista.containsKey(nombre)) 
	    return true;

	return false;
    }
}

public class ListaServer {

  public static void main(String args[]) {
    try{
      // Crea e inicializa el Servidor
      ORB orb = ORB.init(args, null);

      // Obtiene una referencia al rootpoa 
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // Crea el servidor y lo registra con el ORB
      ListaImpl listaImpl = new ListaImpl();

      // Obtiene la referencia del servidor
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(listaImpl);
      Lista href = ListaHelper.narrow(ref);

      // Obtiene el contexto de nombres raiz
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Utiliza NamingContextExt el cual es parte del interorable
      // de la especificacion del servicio de nombres
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // Encadena la referencia del objeto al servicio de nombres
      String name = "Lista";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("ListaServer lista y esperando ...");

      // wait for invocations from clients
      orb.run();
    } 
        
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
          
      System.out.println("ListaServer Terminando ...");
        
  }
}
