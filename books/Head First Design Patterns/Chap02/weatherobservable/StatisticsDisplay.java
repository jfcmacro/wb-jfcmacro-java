import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
   private float maxTemp = 0.0f;
   private float minTemp = 200;
   private float tempSum= 0.0f;
   private int numReadings;
   private WeatherData weatherData;

   public StatisticsDisplay(Observable o) {
      o.addObserver(this);
   }

   public void update(Observable o, Object arg) { // float temp, float humidity, float pressure) {
      if (o instanceof WeatherData) {
         WeatherData wd = (WeatherData) o;
         tempSum += wd.getTemperature();
         numReadings++;

         if (wd.getTemperature() > maxTemp) {
            maxTemp = wd.getTemperature();
         }
 
         if (wd.getTemperature() < minTemp) {
            minTemp = wd.getTemperature();
         }

         display();
      }
   }

   public void display() {
      System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                         + "/" + maxTemp + "/" + minTemp);
   }
}
