import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
   private float currentPressure = 29.92f;  
   private float lastPressure;

   public ForecastDisplay(Observable o) {
      o.addObserver(this);
   }

   public void update(Observable o, Object arg) { // float temp, float humidity, float pressure) {
      if (o instanceof WeatherData) {
         
         lastPressure = currentPressure;
         currentPressure = ((WeatherData) o).getPressure();

         display();
      }
   }

   public void display() {
      System.out.print("Forecast: ");
      if (currentPressure > lastPressure) {
         System.out.println("Improving weather on the way!");
      } else if (currentPressure == lastPressure) {
         System.out.println("More of the same");
      } else if (currentPressure < lastPressure) {
         System.out.println("Watch out for cooler, rainy weather");
      }
   }
}
