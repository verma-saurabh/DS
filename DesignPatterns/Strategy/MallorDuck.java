package DesignPatterns.Strategy;

import DesignPatterns.Strategy.fly.FlyWithWings;
import DesignPatterns.Strategy.quack.Quack;

public class MallorDuck extends Duck {
    public MallorDuck() {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a mallor Duck");
    }
}
