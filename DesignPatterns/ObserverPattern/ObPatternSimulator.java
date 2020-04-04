package DesignPatterns.ObserverPattern;

import java.util.Scanner;

public class ObPatternSimulator {
    public static void main(String[] args) {
        Subject subject = new SimpleSubject();

        new SimpleObserver(subject);
        new SimpleObserver(subject);
        new SimpleObserver(subject);

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("\nEnter a number: ");
            subject.setValue(scan.nextInt());
        }
    }
}
