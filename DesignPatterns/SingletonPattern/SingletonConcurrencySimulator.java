package DesignPatterns.SingletonPattern;

public class SingletonConcurrencySimulator {
    public static void main(String[] args) {
        SingletonClass obj = SingletonClass.getInstance();

        Thread thread1 = new Thread(() -> {
            SingletonClass s = SingletonClass.getInstance();
        });
        Thread thread2 = new Thread(() -> {
            SingletonClass s = SingletonClass.getInstance();
        });

        thread1.start();
        thread2.start();
    }
}
