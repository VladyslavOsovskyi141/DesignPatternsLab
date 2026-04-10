package behavioral;

public class StatePattern {}

interface EmotionalState {
    public String sayHello();
    public String sayGoodbye();
}

class HappyState implements EmotionalState {
    @Override public String sayGoodbye() { return "Bye, friend!"; }
    @Override public String sayHello() { return "Hello, friend!"; }
}

class SadState implements EmotionalState {
    @Override public String sayGoodbye() { return "Bye. Sniff, sniff."; }
    @Override public String sayHello() { return "Hello. Sniff, sniff."; }
}

class Person {
    EmotionalState emotionalState;
    public Person(EmotionalState emotionalState) { this.emotionalState = emotionalState; }
    public void setEmotionalState(EmotionalState emotionalState) { this.emotionalState = emotionalState; }
    public String sayGoodbye() { return emotionalState.sayGoodbye(); }
    public String sayHello() { return emotionalState.sayHello(); }
}