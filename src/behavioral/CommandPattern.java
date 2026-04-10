package behavioral;

public class CommandPattern {}

interface Command { public void execute(); }

class Lunch { public void makeLunch() { System.out.println("Lunch is being made"); } }
class Dinner { public void makeDinner() { System.out.println("Dinner is being made"); } }

class LunchCommand implements Command {
    Lunch lunch;
    public LunchCommand(Lunch lunch) { this.lunch = lunch; }
    @Override public void execute() { lunch.makeLunch(); }
}

class DinnerCommand implements Command {
    Dinner dinner;
    public DinnerCommand(Dinner dinner) { this.dinner = dinner; }
    @Override public void execute() { dinner.makeDinner(); }
}

class MealInvoker {
    Command command;
    public MealInvoker(Command command) { this.command = command; }
    public void setCommand(Command command) { this.command = command; }
    public void invoke() { command.execute(); }
}