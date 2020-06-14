package DesignPatterns.SingletonPattern;

public class SingletonClass {
    private static SingletonClass instance;
    private static Object mutex = new Object();

    private SingletonClass() {

    }

    public static synchronized SingletonClass getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null) instance = new SingletonClass();
            }
        }
        return instance;
    }
}
