package DesignPatterns.Strategy;

public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallorDuck = new MallorDuck();
        Duck decoyDuck = new DecoyDuck();
        Duck redHeadedDuck = new RedHeadedDuck();
        Duck rubberDuck = new RubberDuck();

        process(mallorDuck);
        process(decoyDuck);
        process(redHeadedDuck);
        process(rubberDuck);
    }

    public static void process(Duck duck) {
        duck.display();
        duck.performQuack();
        duck.performFly();
    }
}
