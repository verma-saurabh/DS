package DesignPatterns.DecoratorPattern.Beverage;

public class Decaf extends Beverage {
    @Override
    public String getDescription() {
        return "Decaf";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
