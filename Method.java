class Car {
    String brand;

    void start() {
        System.out.println("Car started");
    }
}

public class Method {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        System.out.println("Brand: " + c1.brand);
        c1.start();
    }
}