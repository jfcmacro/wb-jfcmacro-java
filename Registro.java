public class Registro {
   private final String modelo; // Modelo Vehiculo 
   private final int observador; // Identificador del observador
   private final int contador; // Numero de vehículos observados
   private final int carretera; // Numero de la carretera
   private final int periodo; // 
   
   /**
   * Crea un registro de una observacion de un modelo de vehiculo en una carretera
   * @param modelo El modelo del vehiculo
   * @param observador El ID del observador
   * @param contador Número de vehiculos observados
   * @param carretera El ID de la carretera en que fueron vistos
   * @param period    El periodo del informe
   */
   public Registro(String modelo, int observador, int contador, int carretera, int periodo) {
      this.modelo = modelo;
      this.observador = observador;
      this.contador = contador;
      this.carretera = carretera;
      this.periodo = periodo;
   }
   
   public String obtModelo() {
      return modelo;
   }
   
   public int obtObservador() {
       return observador;
   }
   
   public int obtContador() {
       return contador;
   }
   
   public int obtCarretera() {
       return carretera;
   }
   
   public int periodo() {
       return periodo;
   }
   
   public String obtDetalles() {
       return modelo +
           ", contador =" + contador +
           ", carretera =" + carretera + 
           ", observador =" + observador +
           ", periodo =" + periodo;
   }
}
