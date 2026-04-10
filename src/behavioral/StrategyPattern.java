package behavioral;

public class StrategyPattern {}

interface Strategy {
    boolean checkTemperature(int temperatureInF);
}

class HikeStrategy implements Strategy {
    @Override public boolean checkTemperature(int temperatureInF) {
        return (temperatureInF >= 50) && (temperatureInF <= 90);
    }
}

class SkiStrategy implements Strategy {
    @Override public boolean checkTemperature(int temperatureInF) {
        return temperatureInF <= 32;
    }
}

class Context {
    int temperatureInF;
    Strategy strategy;
    public Context(int temperatureInF, Strategy strategy) {
        this.temperatureInF = temperatureInF;
        this.strategy = strategy;
    }
    public void setStrategy(Strategy strategy) { this.strategy = strategy; }
    public int getTemperatureInF() { return temperatureInF; }
    public boolean getResult() { return strategy.checkTemperature(temperatureInF); }
}