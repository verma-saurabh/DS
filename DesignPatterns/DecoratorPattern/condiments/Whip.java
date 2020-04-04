package DesignPatterns.DecoratorPattern.condiments;

import DesignPatterns.DecoratorPattern.Beverage.Beverage;

public class Whip extends Condiments {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Whip";
    }

    public int getCost() {
        return beverage.getCost() + 10;
    }
}
