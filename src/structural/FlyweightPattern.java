package structural;
import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern { }

interface Flyweight {
    public void doMath(int a, int b);
}

class FlyweightAdder implements Flyweight {
    String operation;
    public FlyweightAdder() {
        operation = "adding";
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    @Override
    public void doMath(int a, int b) { System.out.println(operation + " " + a + " and " + b + ": " + (a + b)); }
}

class FlyweightMultiplier implements Flyweight {
    String operation;
    public FlyweightMultiplier() {
        operation = "multiplying";
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    @Override
    public void doMath(int a, int b) { System.out.println(operation + " " + a + " and " + b + ": " + (a * b)); }
}

class FlyweightFactory {
    private static FlyweightFactory flyweightFactory;
    private Map<String, Flyweight> flyweightPool;
    private FlyweightFactory() { flyweightPool = new HashMap<String, Flyweight>(); }
    public static FlyweightFactory getInstance() {
        if (flyweightFactory == null) { flyweightFactory = new FlyweightFactory(); }
        return flyweightFactory;
    }
    public Flyweight getFlyweight(String key) {
        if (flyweightPool.containsKey(key)) { return flyweightPool.get(key); } else {
            Flyweight flyweight;
            if ("add".equals(key)) { flyweight = new FlyweightAdder(); } 
            else { flyweight = new FlyweightMultiplier(); }
            flyweightPool.put(key, flyweight);
            return flyweight;
        }
    }
}