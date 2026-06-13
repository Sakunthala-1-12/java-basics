class Vehicle {
    void color() {
        System.out.println("Red");
    }
}

class car extends Vehicle {
    void brand() {
        System.out.println("Toyota");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        car c1 = new car();
        c1.color();
        c1.brand();
    }
}