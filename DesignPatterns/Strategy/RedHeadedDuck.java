package DesignPatterns.Strategy;

import DesignPatterns.Strategy.fly.FlyWithWings;
import DesignPatterns.Strategy.quack.Quack;

public class RedHeadedDuck extends Duck {

    public RedHeadedDuck(){
        flyBehaviour= new FlyWithWings();
        quackBehaviour= new Quack();
    }
    @Override
    public void display() {
        System.out.println("I am red headed duck");
    }
}
