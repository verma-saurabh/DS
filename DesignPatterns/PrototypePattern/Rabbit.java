package DesignPatterns.PrototypePattern;

public class Rabbit implements Cloneable {
    public enum Breed {
        HIMALYAN, AFRICAN, DUTCH
    }

    private int age;
    private Breed breed;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Rabbit() {

    }

    @Override
    protected Rabbit clone() throws CloneNotSupportedException {
        try {
            return (Rabbit) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
