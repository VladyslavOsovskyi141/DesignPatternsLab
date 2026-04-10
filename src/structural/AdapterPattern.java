package structural;

public class AdapterPattern { }

class CelciusReporter {
    double temperatureInC;
    public double getTemperature() { return temperatureInC; }
    public void setTemperature(double temperatureInC) { this.temperatureInC = temperatureInC; }
}

interface TemperatureInfo {
    public double getTemperatureInF();
    public void setTemperatureInF(double temperatureInF);
    public double getTemperatureInC();
    public void setTemperatureInC(double temperatureInC);
}

class TemperatureClassReporter extends CelciusReporter implements TemperatureInfo {
    @Override
    public double getTemperatureInC() { return temperatureInC; }
    @Override
    public double getTemperatureInF() { return cToF(temperatureInC); }
    @Override
    public void setTemperatureInC(double temperatureInC) { this.temperatureInC = temperatureInC; }
    @Override
    public void setTemperatureInF(double temperatureInF) { this.temperatureInC = fToC(temperatureInF); }
    private double fToC(double f) { return ((f - 32) * 5 / 9); }
    private double cToF(double c) { return ((c * 9 / 5) + 32); }
}

class TemperatureObjectReporter implements TemperatureInfo {
    CelciusReporter celciusReporter;
    public TemperatureObjectReporter() { celciusReporter = new CelciusReporter(); }
    @Override
    public double getTemperatureInC() { return celciusReporter.getTemperature(); }
    @Override
    public double getTemperatureInF() { return cToF(celciusReporter.getTemperature()); }
    @Override
    public void setTemperatureInC(double temperatureInC) { celciusReporter.setTemperature(temperatureInC); }
    @Override
    public void setTemperatureInF(double temperatureInF) { celciusReporter.setTemperature(fToC(temperatureInF)); }
    private double fToC(double f) { return ((f - 32) * 5 / 9); }
    private double cToF(double c) { return ((c * 9 / 5) + 32); }
}