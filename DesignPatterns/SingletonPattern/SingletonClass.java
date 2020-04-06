package DesignPatterns.SingletonPattern;

public class SingletonClass {
    private static SingletonClass instance;
    private static boolean isInitialized = false;

    private SingletonClass() {

    }

    private void init() {

    }

    public static synchronized SingletonClass getInstance() {
        if (isInitialized) {
            return instance;
        } else {
            instance = new SingletonClass();
            instance.init();
            isInitialized = true;
            return instance;
        }
    }
}
