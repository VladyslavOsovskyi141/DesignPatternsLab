package structural;

public class DecoratorPattern { }

interface AnimalStruct {
    public void describe();
}

class LivingAnimal implements AnimalStruct {
    @Override
    public void describe() { System.out.println("\nI am an animal."); }
}

abstract class AnimalDecorator implements AnimalStruct {
    AnimalStruct animal;
    public AnimalDecorator(AnimalStruct animal) { this.animal = animal; }
}

class LegDecorator extends AnimalDecorator {
    public LegDecorator(AnimalStruct animal) { super(animal); }
    @Override
    public void describe() {
        animal.describe();
        System.out.println("I have legs.");
        dance();
    }
    public void dance() { System.out.println("I can dance."); }
}

class WingDecorator extends AnimalDecorator {
    public WingDecorator(AnimalStruct animal) { super(animal); }
    @Override
    public void describe() {
        animal.describe();
        System.out.println("I have wings.");
        fly();
    }
    public void fly() { System.out.println("I can fly."); }
}

class GrowlDecorator extends AnimalDecorator {
    public GrowlDecorator(AnimalStruct animal) { super(animal); }
    @Override
    public void describe() {
        animal.describe();
        growl();
    }
    public void growl() { System.out.println("Grrrrr."); }
}