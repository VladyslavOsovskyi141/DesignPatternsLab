package behavioral;

public class ChainOfResponsibilityPattern {}

enum PlanetEnum { MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE }

abstract class PlanetHandler {
    PlanetHandler successor;
    public void setSuccessor(PlanetHandler successor) { this.successor = successor; }
    public abstract void handleRequest(PlanetEnum request);
}

class MercuryHandler extends PlanetHandler {
    public void handleRequest(PlanetEnum request) {
        if (request == PlanetEnum.MERCURY) {
            System.out.println("MercuryHandler handles " + request + "\nMercury is hot.\n");
        } else {
            System.out.println("MercuryHandler doesn't handle " + request);
            if (successor != null) successor.handleRequest(request);
        }
    }
}

class VenusHandler extends PlanetHandler {
    public void handleRequest(PlanetEnum request) {
        if (request == PlanetEnum.VENUS) {
            System.out.println("VenusHandler handles " + request + "\nVenus is poisonous.\n");
        } else {
            System.out.println("VenusHandler doesn't handle " + request);
            if (successor != null) successor.handleRequest(request);
        }
    }
}

class EarthHandler extends PlanetHandler {
    public void handleRequest(PlanetEnum request) {
        if (request == PlanetEnum.EARTH) {
            System.out.println("EarthHandler handles " + request + "\nEarth is comfortable.\n");
        } else {
            System.out.println("EarthHandler doesn't handle " + request);
            if (successor != null) successor.handleRequest(request);
        }
    }
}