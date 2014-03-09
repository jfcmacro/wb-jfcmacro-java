package co.edu.eafit.dis.xmlexec.server;

import java.util.Map;

public interface Ejecutor {

    public Map<String,String> compilarJavaFile(String nombreDeRuta, String contenido);
    public Map<String,String> execCompJavaFile(String nombreDeRuta, String contenido);
}