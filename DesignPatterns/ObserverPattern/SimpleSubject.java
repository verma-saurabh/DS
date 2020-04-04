package DesignPatterns.ObserverPattern;

import java.util.ArrayList;

public class SimpleSubject implements Subject {
    private ArrayList<Observer> observers;
    private int data = 0;

    public SimpleSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void unSubscribe(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(data);
        }
    }

    public void setValue(int data) {
        this.data = data;
        notifyObservers();
    }
}
