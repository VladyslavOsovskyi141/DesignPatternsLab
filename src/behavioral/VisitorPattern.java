package behavioral;
import java.util.*;

public class VisitorPattern {}

interface NumberVisitor {
    public void visit(TwoElement twoElement);
    public void visit(ThreeElement threeElement);
    public void visit(List<NumberElement> elementList);
}

interface NumberElement { public void accept(NumberVisitor visitor); }

class TwoElement implements NumberElement {
    int a; int b;
    public TwoElement(int a, int b) { this.a = a; this.b = b; }
    @Override public void accept(NumberVisitor visitor) { visitor.visit(this); }
}

class ThreeElement implements NumberElement {
    int a; int b; int c;
    public ThreeElement(int a, int b, int c) { this.a = a; this.b = b; this.c = c; }
    @Override public void accept(NumberVisitor visitor) { visitor.visit(this); }
}

class SumVisitor implements NumberVisitor {
    @Override public void visit(TwoElement twoElement) {
        int sum = twoElement.a + twoElement.b;
        System.out.println(twoElement.a + "+" + twoElement.b + "=" + sum);
    }
    @Override public void visit(ThreeElement threeElement) {
        int sum = threeElement.a + threeElement.b + threeElement.c;
        System.out.println(threeElement.a + "+" + threeElement.b + "+" + threeElement.c + "=" + sum);
    }
    @Override public void visit(List<NumberElement> elementList) {
        for (NumberElement ne : elementList) { ne.accept(this); }
    }
}

class TotalSumVisitor implements NumberVisitor {
    int totalSum = 0;
    @Override public void visit(TwoElement twoElement) {
        int sum = twoElement.a + twoElement.b;
        System.out.println("Adding " + twoElement.a + "+" + twoElement.b + "=" + sum + " to total");
        totalSum += sum;
    }
    @Override public void visit(ThreeElement threeElement) {
        int sum = threeElement.a + threeElement.b + threeElement.c;
        System.out.println("Adding " + threeElement.a + "+" + threeElement.b + "+" + threeElement.c + "=" + sum + " to total");
        totalSum += sum;
    }
    @Override public void visit(List<NumberElement> elementList) {
        for (NumberElement ne : elementList) { ne.accept(this); }
    }
    public int getTotalSum() { return totalSum; }
}