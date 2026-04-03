package creational;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Singleton:");
        SingletonExample singleton = SingletonExample.getInstance();
        singleton.sayHello();

        System.out.println("\n2. Factory:");
        AnimalFactory animalFactory = new AnimalFactory();
        Animal cat = animalFactory.getAnimal("feline");
        System.out.println("Cat sound: " + cat.makeSound());

        System.out.println("\n3. Abstract Factory:");
        AbstractFactory abstractFactory = new AbstractFactory();
        SpeciesFactory reptileFactory = abstractFactory.getSpeciesFactory("reptile");
        Animal snake = reptileFactory.getAnimal("snake");
        System.out.println("Snake sound: " + snake.makeSound());

        System.out.println("\n4. Builder:");
        MealBuilder builder = new ItalianMealBuilder();
        MealDirector director = new MealDirector(builder);
        director.constructMeal();
        System.out.println("Italian meal: " + director.getMeal());

        System.out.println("\n5. Prototype:");
        Person originalPerson = new Person("Fred");
        Person clonedPerson = (Person) originalPerson.doClone();
        System.out.println("Original: " + originalPerson + " | Clone: " + clonedPerson);
    }
}
