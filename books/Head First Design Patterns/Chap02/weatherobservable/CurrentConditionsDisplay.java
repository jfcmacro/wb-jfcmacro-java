import java.util.Observer;
import java.util.Observable;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
   float temperature;
   float humidity;
   
   public CurrentConditionsDisplay(Observable o) {
      o.addObserver(this);
   }

   public void update(Observable o, Object arg) {
      if (o instanceof WeatherData) {
         WeatherData wd = (WeatherData) o;
         this.temperature = wd.getTemperature();
         this.humidity = wd.getHumidity();
         display();
      }
   }

   public void display() {
      System.out.println("Current conditions: " + temperature +
                         "F degrees and " + humidity + "% humidity");
   }
}
