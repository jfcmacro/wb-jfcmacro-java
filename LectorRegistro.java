import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LectorRegistro {

    public LectorRegistro() {
    }

    public ArrayList<Registro> obtRegistros(String nombreFichero)
        throws FileNotFoundException {
        ArrayList<Registro> registros = new ArrayList<>();
        Scanner scanner = new Scanner(new File(nombreFichero));
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String []campos = linea.split(",");
            registros.add(new Registro(campos[0],
                                       Integer.parseInt(campos[1]),
                                       Integer.parseInt(campos[2]),
                                       Integer.parseInt(campos[3]),
                                       Integer.parseInt(campos[4])));
        }
        return registros;
    }
}
