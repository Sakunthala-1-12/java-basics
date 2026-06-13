import java.util.Scanner;

public class EmployeePerformance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Monthly Sales: ");
        double sales = sc.nextDouble();

        System.out.print("Enter Projects Completed: ");
        int projects = sc.nextInt();

        System.out.print("Enter Years of Experience: ");
        int experience = sc.nextInt();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        double performanceScore =
                (sales * 0.5) +
                (projects * 10) +
                (experience * 5);

        double profit = (sales * 0.20) - salary;

        int requiredProjects;

        if (experience <= 2) {
            requiredProjects = 3;
        }
        else if (experience <= 5) {
            requiredProjects = 5;
        }
        else {
            requiredProjects = 8;
        }

        System.out.println("\nPerformance Score = " + performanceScore);
        System.out.println("Company Profit = " + profit);
        System.out.println("Required Projects = " + requiredProjects);

        if (performanceScore >= 100 &&
            profit > 0 &&
            projects >= requiredProjects) {

            System.out.println("Bonus Eligible");
        }
        else {
            System.out.println("Not Eligible for Bonus");
        }

        sc.close();
    }
}