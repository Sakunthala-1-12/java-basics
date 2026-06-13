class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Polymorphism_method_overriding{
    public static void main(String[] args) {
        Animal a = new Dog(); // Parent reference, child object
        a.sound();
    }
}
