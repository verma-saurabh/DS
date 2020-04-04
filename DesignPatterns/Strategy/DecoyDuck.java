package DesignPatterns.Strategy;

import DesignPatterns.Strategy.fly.FlyNoWay;
import DesignPatterns.Strategy.quack.Quack;

public class DecoyDuck extends Duck{

    public DecoyDuck(){
        flyBehaviour= new FlyNoWay();
        quackBehaviour= new Quack();
    }
    @Override
    public void display() {
        System.out.println("I am a decoy Duck");
    }
}
