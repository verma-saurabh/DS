package DesignPatterns.DecoratorPattern.Beverage;

public class Expresso extends Beverage {
    @Override
    public String getDescription() {
        return "Expresso";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
