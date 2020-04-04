package DesignPatterns.DecoratorPattern.Beverage;

public class DarkRoast extends Beverage {
    @Override
    public String getDescription() {
        return "Dark Roast";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
