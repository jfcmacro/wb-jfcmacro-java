import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class MonitorRegistro {
   private ArrayList<Registro> registros;

   public MonitorRegistro() {
     this.registros = new ArrayList<>();
   }

    public void adicionarRegistros(String nombreFichero) {
        try {
            LectorRegistro lector = new LectorRegistro();
            registros = lector.obtRegistros(nombreFichero);
        }
        catch (FileNotFoundException fnfe) {
            System.err.println("No se pudo cargar la opcion");
        }
    }

    public void imprimirLista() {
        // Sustituirlo por una version de stream
        // for (Registro registro : registros) {
        //     System.out.println(registro.obtDetalles());
        // }
        registros.stream().forEach(r -> System.out.println(r.obtDetalles()));
    }

    // public void imprimirListaModelo(String modelo) {
    //     imprimirListaPredicado();
    // }

    public void imprimirListaObservador(int observador) {
        registros.stream()
            .filter(r -> r.obtObservador() == observador)
            .map(Registro::obtDetalles)
            .forEach((String detalle) -> System.out.println(detalle));
    }

    public void imprimirListaPredicado(Function<Registro,Boolean> p) {
        registros.stream()
            .filter(p::apply)
            .map(Registro::obtDetalles)
            .forEach(System.out::println);
    }

    public long contarPredicado2(Predicate<Registro> p) {
        return registros.stream()
            .filter(p)
            .count();
            // .map(r -> 1)
            // .reduce(0, (total, count) -> total + count);
    }
}
