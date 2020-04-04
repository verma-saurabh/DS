package DesignPatterns.AdapterPattern;

public class AdapterSimulator {
    public static void main(String[] args) {

        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        testDuck(turkeyAdapter);

    }

    static void testDuck(Duck duck) {
        duck.fly();
        duck.quack();
    }
}
