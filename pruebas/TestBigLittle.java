
public class TestBigLittle {


    public static void main(String args[]) {

	if (args.length != 1) {
	    
	    System.err.println("Uso: java TestBigLittle <java_class>");
	    System.exit(1);
	}

	try {
	
	    Class c = Class.forName(args[0]);

	    Object o = c.newInstance();

	    if (o instanceof BigLittle) {

		BigLittle bl = (BigLittle) o;

		int i = 1;
		int res = 0;

		if (!(i == (res = bl.bigToLittleInt(bl.bigToLittleInt(i))))) {
		    System.err.println("No paso prueba de identidad en i=" 
				       + i + " res= " + res);
		}

		i = -1;

		if (!(i == (res = bl.bigToLittleInt(bl.bigToLittleInt(i))))) {
		    System.err.println("No paso prueba de identidad en i=" 
		     	       + i + " res= " + res);
		}

		long j = 1L;
		long resl = 0L;

		if (!(j == (resl = bl.bigToLittleLong(bl.bigToLittleLong(i))))){
		    System.err.println("No paso prueba de identidad en long=" 
				       + j + " result=" + resl);
		}
		    
		j = -1L;

		if (!(j == (resl = bl.bigToLittleLong(bl.bigToLittleLong(i))))){
		    System.err.println("No paso prueba de identidad en long" 
				       + j + " result=" + resl);
		}

	    }
 
	} catch (ClassNotFoundException cnfe) {
	    System.err.println("Clase no encontrada");
	} catch (IllegalAccessException iae) {
	    System.out.println("Constructor no accesible");
	} catch (InstantiationException ie) {
	    System.out.println("La clase " + args[0] + 
			       " es una clase abstracta");
	}
	
    }

}
