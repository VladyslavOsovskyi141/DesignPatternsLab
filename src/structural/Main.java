package structural;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. ADAPTER ===");
        TemperatureInfo tempInfo = new TemperatureClassReporter();
        tempInfo.setTemperatureInC(0);
        System.out.println("Class adapter -> temp in C: " + tempInfo.getTemperatureInC() + ", temp in F: " + tempInfo.getTemperatureInF());

        System.out.println("\n=== 2. COMPOSITE ===");
        Composite composite = new Composite();
        composite.add(new Leaf("Bob"));
        composite.add(new Leaf("Fred"));
        composite.sayHello();

        System.out.println("\n=== 3. PROXY ===");
        Proxy proxy = new Proxy();
        FastThing fastThing = new FastThing();
        fastThing.sayHello();
        proxy.sayHello(); // Затримка буде лише тут

        System.out.println("\n=== 4. FLYWEIGHT ===");
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();
        Flyweight flyweightAdder = flyweightFactory.getFlyweight("add");
        flyweightAdder.doMath(1, 1);

        System.out.println("\n=== 5. FACADE ===");
        Facade facade = new Facade();
        System.out.println("Cube of 3: " + facade.cubeX(3));

        System.out.println("\n=== 6. BRIDGE ===");
        Vehicle vehicle = new BigBus(new SmallEngine());
        vehicle.drive();
        vehicle.setEngine(new BigEngine());
        vehicle.drive();

        System.out.println("\n=== 7. DECORATOR ===");
        AnimalStruct animal = new LivingAnimal();
        animal = new LegDecorator(animal);
        animal = new WingDecorator(animal);
        animal = new GrowlDecorator(animal);
        animal.describe();
    }
}