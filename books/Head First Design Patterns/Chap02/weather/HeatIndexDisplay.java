// import java.util.*;

public class HeatIndexDisplay implements Observer, DisplayElement {
   private double heatIndex = 0.0d;
   private WeatherData weatherData;

   public HeatIndexDisplay(WeatherData weatherData) {
      this.weatherData = weatherData;
      weatherData.registerObserver(this);
   }

   public void update(float temp, float humidity, float pressure) {
      heatIndex = computeHeatIndex(temp, humidity);
      display();
   }

   private double computeHeatIndex(double t, double rh) { 
      return 16.923
         + 1.85212 * Math.pow(10, -1) * t
         + 5.37941 * rh
         - 1.00254 * Math.pow(10, -1) * t * rh
         + 9.41695 * Math.pow(10, -3) * Math.pow(t, 2)
         + 7.28898 * Math.pow(10, -3) * Math.pow(rh, 2)
         + 3.45372 * Math.pow(10, -4) * Math.pow(t, 2) * rh
         - 8.14971 * Math.pow(10, -4) * t * Math.pow(rh, 2)
         + 1.02102 * Math.pow(10, -5) * Math.pow(t, 2) * Math.pow(rh, 2)
         - 3.8646  * Math.pow(10, -5) * Math.pow(t, 3)
         + 2.91583 * Math.pow(10, -5) * Math.pow(rh, 3)
         + 1.42721 * Math.pow(10, -6) * Math.pow(t, 3) * rh
         + 1.97483 * Math.pow(10, -7) * t * Math.pow(rh, 3)
         - 2.18429 * Math.pow(10, -8) * Math.pow(t,3) * Math.pow(rh, 2)
         + 8.43296 * Math.pow(10,-10) * Math.pow(t,2) * Math.pow(rh, 3)
         - 4.81975 * Math.pow(10,-11) * Math.pow(t,3) * Math.pow(rh, 3);
   }
   
   public void display() {
         
      System.out.println(String.format("Head index is %2.5f", heatIndex));
   }
}
