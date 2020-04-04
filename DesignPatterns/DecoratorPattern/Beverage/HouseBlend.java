package DesignPatterns.DecoratorPattern.Beverage;

public class HouseBlend extends Beverage{
    @Override
    public String getDescription() {
        return "HouseBlend";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
