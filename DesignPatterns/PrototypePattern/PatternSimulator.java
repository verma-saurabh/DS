package DesignPatterns.PrototypePattern;

public class PatternSimulator {
    public static void main(String[] args) throws CloneNotSupportedException {
        Rabbit rabbit = new Rabbit();
        rabbit.setAge(2);
        Rabbit rabbitCopy = rabbit.clone();
        System.out.println(rabbit.getAge());
        System.out.println(rabbitCopy.getAge());
        rabbitCopy.setAge(3);
        System.out.println(rabbitCopy.getAge());
    }
}
