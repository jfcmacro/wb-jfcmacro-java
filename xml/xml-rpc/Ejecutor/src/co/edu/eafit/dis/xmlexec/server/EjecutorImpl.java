package co.edu.eafit.dis.xmlexec.server;

import java.io.File;
// import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class EjecutorImpl implements Ejecutor {

    public static int FILENOTFOUND      = 1;
    public static int IOERROR           = 2;
    public static int EXECFAIL          = 3;
    public static int INTREXCEPTION     = 4;
    public static int EXITO             = 0;
    public static int NO_RAZON          = 1;
    public static String COMPILADORJAVA = "/opt/java/bin/javac";
    public static String EJECUTORJAVA   = "/opt/java/bin/java";

    private Process lastProcess; 

    private Map<String,String> initResp(int codTerm, int razon) {

	Map<String,String> mapRet = new HashMap<String,String>();
	mapRet.put("codterm", new Integer(codTerm).toString());
	mapRet.put("razon", new Integer(razon).toString());
	mapRet.put("output", new String(" "));
	mapRet.put("error", new String(" "));
	return mapRet;
    }

    private String readInputStream(InputStream is) throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	StringBuffer sb  = new StringBuffer();
	String line;
	while ((line = br.readLine()) != null) {
	    sb.append(line);
	}
	return sb.toString();
    }

    private File almacenandoFuente(String nombreDeRuta, String contenido)
	throws IOException {

	File fuente = new File(nombreDeRuta);

	// Creando archivo fuente
	fuente.createNewFile();

	// Poniendo datos al archivo fuente
	System.out.println("Poniendo datos al archivo fuente");
	// DataOutputStream dos = new DataOutputStream(new FileOutputStream(fuente));

	// dos.writeUTF(contenido);
	// FileOutputStream fos = new FileOutputStream(fuente);
	// fos.write(contenido);
	FileWriter fw = new FileWriter(fuente);
	fw.write(contenido);
	System.out.println("Contenido: " + contenido + " longitud: " + contenido.length());
	fw.close();
	return fuente;
    }

    /*
     * Pre: debe ser almacenado un archivo fuente (almacenandoFuente).
     */
    private int compilar(String nombreDeRuta)
	throws NullPointerException, IOException, InterruptedException {

	// Iniciando el comando del compilador
	System.out.println("Comando");
	List<String> proArgs = new ArrayList<String>();
	proArgs.add(COMPILADORJAVA);
	proArgs.add(nombreDeRuta);
	ProcessBuilder pb = new ProcessBuilder(proArgs);
	this.lastProcess = pb.start();

	// Obteniendo los resultados
	System.out.println("Esperando por resultados");
	return this.lastProcess.waitFor();
    }

    /*
     * Pre: debe ser almacenado un archivo fuente (almacenandoFuente) y
     *      luego debe ser compilado (compilar).
     */
    private int exec(String nombreDeRuta)
	throws NullPointerException, IOException, InterruptedException {

	// Iniciando el comando del compilador
	System.out.println("Comando");
	String claseAExec;
	claseAExec = nombreDeRuta.endsWith(".java") ? nombreDeRuta.substring(0, nombreDeRuta.indexOf("."))
	    : nombreDeRuta;
	List<String> proArgs = new ArrayList<String>();
	proArgs.add(EJECUTORJAVA);
	proArgs.add("-cp");
	proArgs.add(".");
	proArgs.add(claseAExec);
	ProcessBuilder pb = new ProcessBuilder(proArgs);
	this.lastProcess = pb.start();

	// Obteniendo los resultados
	System.out.println("Esperando por resultados de ejecución");
	return this.lastProcess.waitFor();
    }

    void establecerNivelLog() {
    }

    public Map<String,String>  compilarJavaFile(String nombreDeRuta,
						String contenido)
    {
	Map<String,String> mapRes = null;
	File fuente = null;
	try {
	    // Creando archivo fuente
	    fuente = almacenandoFuente(nombreDeRuta, contenido);

	    // Iniciando el comando del compilador
	    int códigoProceso  = compilar(nombreDeRuta);
	    if (códigoProceso == 0) {

		System.out.println("Compilación OK");
		mapRes = initResp(EjecutorImpl.EXITO, códigoProceso);
		mapRes.put("output", readInputStream(this.lastProcess.getInputStream()));
	    }
	    else {

		System.out.println("Error en ejecución\n");
		mapRes = initResp(EjecutorImpl.EXECFAIL, códigoProceso);
		mapRes.put("error", readInputStream(this.lastProcess.getErrorStream()));
	    }
	}
	catch (FileNotFoundException e) {

	    return initResp(EjecutorImpl.FILENOTFOUND, EjecutorImpl.NO_RAZON);
 	}
	catch (IOException e) {

	    return initResp(EjecutorImpl.IOERROR, EjecutorImpl.NO_RAZON);
	}
	catch (InterruptedException ie) {

	    return initResp(EjecutorImpl.INTREXCEPTION, EjecutorImpl.NO_RAZON);
	}
	finally {
	    if (fuente != null)
		fuente.delete();
	}
	System.out.println("Termino");
	return mapRes;
    }

    public Map<String,String>  execCompJavaFile(String nombreDeRuta,
						String contenido)
    {
	Map<String,String> mapRes = null;
	File fuente = null;
	try {
	    System.out.println("Exec");
	    // Creando archivo fuente
	    fuente = almacenandoFuente(nombreDeRuta, contenido);

	    // Iniciando el comando del compilador
	    int códigoProceso  = compilar(nombreDeRuta);
	    if (códigoProceso != 0) {

		System.out.println("Error\n");
		mapRes = initResp(EjecutorImpl.EXECFAIL, códigoProceso);
		mapRes.put("error", readInputStream(this.lastProcess.getErrorStream()));
	    }
	    else {
		System.out.println("Listo para ejecutar");
		códigoProceso = exec(nombreDeRuta);
		if (códigoProceso != 0) {

		    System.out.println("Error\n");
		    mapRes = initResp(EjecutorImpl.EXECFAIL, códigoProceso);
		    mapRes.put("error", readInputStream(this.lastProcess.getErrorStream()));
		}
		else {
		    
		    System.out.println("Ejecución OK");
		    mapRes = initResp(EjecutorImpl.EXITO, códigoProceso);
		    mapRes.put("output", readInputStream(this.lastProcess.getInputStream()));
		}
	    }
	}
	catch (FileNotFoundException e) {

	    return initResp(EjecutorImpl.FILENOTFOUND, EjecutorImpl.NO_RAZON);
 	}
	catch (IOException e) {

	    return initResp(EjecutorImpl.IOERROR, EjecutorImpl.NO_RAZON);
	}
	catch (InterruptedException ie) {

	    return initResp(EjecutorImpl.INTREXCEPTION, EjecutorImpl.NO_RAZON);
	}
	finally {

	    if (fuente != null)
		fuente.delete();
	}
	System.out.println("Termino");
	return mapRes;
    }
}