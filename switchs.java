import java.util.Scanner;

public class switchs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        int choice = sc.nextInt();

        int a = 20, b = 10;

        switch (choice) {
            case 1:
                System.out.println("Addition = " + (a + b));
                break;

            case 2:
                System.out.println("Subtraction = " + (a - b));
                break;

            case 3:
                System.out.println("Multiplication = " + (a * b));
                break;

            case 4:
                System.out.println("Division = " + (a / b));
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}

