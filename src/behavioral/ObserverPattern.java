package behavioral;
import java.util.*;

public class ObserverPattern {}

interface WeatherSubject {
    public void addObserver(WeatherObserver weatherObserver);
    public void removeObserver(WeatherObserver weatherObserver);
    public void doNotify();
}

interface WeatherObserver {
    public void doUpdate(int temperature);
}

class WeatherStation implements WeatherSubject {
    Set<WeatherObserver> weatherObservers = new HashSet<>();
    int temperature;

    public WeatherStation(int temperature) { this.temperature = temperature; }
    @Override public void addObserver(WeatherObserver weatherObserver) { weatherObservers.add(weatherObserver); }
    @Override public void removeObserver(WeatherObserver weatherObserver) { weatherObservers.remove(weatherObserver); }
    @Override public void doNotify() {
        for (WeatherObserver observer : weatherObservers) { observer.doUpdate(temperature); }
    }
    public void setTemperature(int newTemperature) {
        System.out.println("\nWeather station setting temperature to " + newTemperature);
        temperature = newTemperature;
        doNotify();
    }
}

class WeatherCustomer1 implements WeatherObserver {
    @Override public void doUpdate(int temperature) { System.out.println("Weather customer 1 just found out the temperature is: " + temperature); }
}

class WeatherCustomer2 implements WeatherObserver {
    @Override public void doUpdate(int temperature) { System.out.println("Weather customer 2 just found out the temperature is: " + temperature); }
}