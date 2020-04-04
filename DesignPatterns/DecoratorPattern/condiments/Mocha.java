package DesignPatterns.DecoratorPattern.condiments;

import DesignPatterns.DecoratorPattern.Beverage.Beverage;

public class Mocha extends Condiments {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , mocha";
    }

    @Override
    public int getCost() {
        return beverage.getCost() + 10;
    }
}
