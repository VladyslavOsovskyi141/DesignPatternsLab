package structural;
import java.util.Date;

public class ProxyPattern { }

abstract class Thing {
    public void sayHello() {
        System.out.println(this.getClass().getSimpleName() + " says howdy at " + new Date());
    }
}

class FastThing extends Thing {
    public FastThing() { }
}

class SlowThing extends Thing {
    public SlowThing() {
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

class Proxy {
    SlowThing slowThing;
    public Proxy() { System.out.println("Creating proxy at " + new Date()); }
    public void sayHello() {
        if (slowThing == null) { slowThing = new SlowThing(); }
        slowThing.sayHello();
    }
}