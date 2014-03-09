import Coleccion.*;
import Coleccion.ListaPackage.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class ListaCliente
{
  static Lista listaImpl;
    
    public static void main(String args[])
    {
	try{
	    // crea e inicializa el orb
	    ORB orb = ORB.init(args, null);
	    
	    // obtiene el contexto de nombres raíz
	    org.omg.CORBA.Object objRef = 
		orb.resolve_initial_references("NameService");

	    // Utiliza NamingContextExt en vez de NamingContext. Este
	    // es parte del Servicio de nombre interoperable.
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    
	    // resolve the Object Reference in Naming
	    // resuelve la referencia de objetos en Naming
	    String name = "Lista";
	    listaImpl = ListaHelper.narrow(ncRef.resolve_str(name));
	    
	    System.out.println("Obtiene una referencia al objeto servidor: " 
			       + listaImpl);
	    System.out.println("Adiciona un nombre a la lista");
	    
	    if (listaImpl.Adicionar("Juan")) {
		System.out.println("Juan no esta");
	    }

	    System.out.println("Adicionar otra vez el mismo nombre");
	    
	    if (listaImpl.Adicionar("Juan")) {
		System.out.println("Juan no esta");
	    }
	    else {
		System.out.println("Juan ya existe");
	    }

	    System.out.println("Consultar el nombre");

	    if (listaImpl.Consultar("Juan")) {
		System.out.println("Juan si esta");
	    }
	    else {
		System.out.println("Juan no esta");
	    }

	    System.out.println("Borrar");

	    try {
		listaImpl.Borrar("Juan");
	    }
	    catch (NoExiste e) {
		System.out.println("Error no existe: " +e);
	    }

	    System.out.println("Se intenta de nuevo");

	    try {
		listaImpl.Borrar("Juan");
	    }
	    catch (NoExiste e) {
		System.out.println("Error no existe: " +e);
	    }

        } catch (Exception e) {
	    System.out.println("ERROR : " + e) ;
	    e.printStackTrace(System.out);
	}
    }
}
