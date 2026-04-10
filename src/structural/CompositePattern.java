package structural;
import java.util.ArrayList;
import java.util.List;

public class CompositePattern { }

interface Component {
    public void sayHello();
    public void sayGoodbye();
}

class Leaf implements Component {
    String name;
    public Leaf(String name) { this.name = name; }
    @Override
    public void sayHello() { System.out.println(name + " leaf says hello"); }
    @Override
    public void sayGoodbye() { System.out.println(name + " leaf says goodbye"); }
}

class Composite implements Component {
    List<Component> components = new ArrayList<Component>();
    @Override
    public void sayHello() {
        for (Component component : components) { component.sayHello(); }
    }
    @Override
    public void sayGoodbye() {
        for (Component component : components) { component.sayGoodbye(); }
    }
    public void add(Component component) { components.add(component); }
    public void remove(Component component) { components.remove(component); }
    public List<Component> getComponents() { return components; }
    public Component getComponent(int index) { return components.get(index); }
}