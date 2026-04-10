package behavioral;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. TEMPLATE METHOD ===");
        Meal meal1 = new HamburgerMeal(); meal1.doMeal();
        System.out.println();
        Meal meal2 = new TacoMeal(); meal2.doMeal();

        System.out.println("\n=== 2. MEDIATOR ===");
        Mediator mediator = new Mediator();
        Buyer swedishBuyer = new SwedishBuyer(mediator);
        Buyer frenchBuyer = new FrenchBuyer(mediator);
        AmericanSeller americanSeller = new AmericanSeller(mediator, 10.0f);
        DollarConverter dollarConverter = new DollarConverter(mediator);
        
        float swedishBidInKronor = 55.0f;
        while (!swedishBuyer.attemptToPurchase(swedishBidInKronor)) { swedishBidInKronor += 15.0f; }

        System.out.println("\n=== 3. CHAIN OF RESPONSIBILITY ===");
        PlanetHandler mercuryHandler = new MercuryHandler();
        PlanetHandler venusHandler = new VenusHandler();
        PlanetHandler earthHandler = new EarthHandler();
        mercuryHandler.setSuccessor(venusHandler);
        venusHandler.setSuccessor(earthHandler);
        
        mercuryHandler.handleRequest(PlanetEnum.VENUS);
        mercuryHandler.handleRequest(PlanetEnum.JUPITER);

        System.out.println("\n=== 4. OBSERVER ===");
        WeatherStation weatherStation = new WeatherStation(33);
        WeatherCustomer1 wc1 = new WeatherCustomer1();
        weatherStation.addObserver(wc1);
        weatherStation.setTemperature(34);

        System.out.println("\n=== 5. STRATEGY ===");
        Context context = new Context(60, new SkiStrategy());
        System.out.println("Is 60F good for skiing? " + context.getResult());
        context.setStrategy(new HikeStrategy());
        System.out.println("Is 60F good for hiking? " + context.getResult());

        System.out.println("\n=== 6. COMMAND ===");
        Lunch lunch = new Lunch();
        Command lunchCommand = new LunchCommand(lunch);
        MealInvoker mealInvoker = new MealInvoker(lunchCommand);
        mealInvoker.invoke();

        System.out.println("\n=== 7. STATE ===");
        Person person = new Person(new HappyState());
        System.out.println("Happy state: " + person.sayHello());
        person.setEmotionalState(new SadState());
        System.out.println("Sad state: " + person.sayGoodbye());

        System.out.println("\n=== 8. VISITOR ===");
        List<NumberElement> numberElements = new ArrayList<>();
        numberElements.add(new TwoElement(3, 3));
        numberElements.add(new ThreeElement(3, 4, 5));
        TotalSumVisitor totalSumVisitor = new TotalSumVisitor();
        totalSumVisitor.visit(numberElements);
        System.out.println("Total sum: " + totalSumVisitor.getTotalSum());

        System.out.println("\n=== 9. ITERATOR ===");
        Menu menu = new Menu();
        menu.addItem(new Item("spaghetti", 7.50f));
        menu.addItem(new Item("hamburger", 6.00f));
        Iterator<Item> iterator = menu.iterator();
        while (iterator.hasNext()) { System.out.println(iterator.next()); }

        System.out.println("\n=== 10. MEMENTO ===");
        DietInfoCaretaker caretaker = new DietInfoCaretaker();
        DietInfo dietInfo = new DietInfo("Fred", 1, 100);
        System.out.println("Initial: " + dietInfo);
        caretaker.saveState(dietInfo);
        dietInfo.setDayNumberAndWeight(2, 90);
        System.out.println("Changed: " + dietInfo);
        caretaker.restoreState(dietInfo);
        System.out.println("Restored: " + dietInfo);
    }
}