package DesignPatterns.Strategy.quack;

public class Mute implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("I cant Quack");
    }
}
