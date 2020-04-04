package DesignPatterns.ObserverPattern;

public class SimpleObserver implements Observer {
    private int data;
    private Subject simpleSubject;

    public SimpleObserver(Subject simpleSubject) {
        this.simpleSubject = simpleSubject;
        simpleSubject.subscribe(this);

    }

    @Override
    public void update(int data) {
        this.data = data;
        display();
    }

    public void display() {
        System.out.println("The value is " + data);
    }
}
