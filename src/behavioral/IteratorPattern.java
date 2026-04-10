package behavioral;
import java.util.*;

public class IteratorPattern {}

class Item {
    String name; float price;
    public Item(String name, float price) { this.name = name; this.price = price; }
    public String toString() { return name + ": $" + price; }
}

class Menu {
    List<Item> menuItems;
    public Menu() { menuItems = new ArrayList<>(); }
    public void addItem(Item item) { menuItems.add(item); }
    public Iterator<Item> iterator() { return new MenuIterator(); }

    class MenuIterator implements Iterator<Item> {
        int currentIndex = 0;
        @Override public boolean hasNext() { return currentIndex < menuItems.size(); }
        @Override public Item next() { return menuItems.get(currentIndex++); }
        @Override public void remove() { menuItems.remove(--currentIndex); }
    }
}