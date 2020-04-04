package DesignPatterns.DecoratorPattern;

import DesignPatterns.DecoratorPattern.Beverage.Beverage;
import DesignPatterns.DecoratorPattern.Beverage.DarkRoast;
import DesignPatterns.DecoratorPattern.Beverage.Decaf;
import DesignPatterns.DecoratorPattern.condiments.Mocha;
import DesignPatterns.DecoratorPattern.condiments.Whip;

public class CoffeeSimulator {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        System.out.println(beverage.getDescription() + "->" + beverage.getCost());
    }
}
