import java.util.Scanner;

public class BinarySearchExample {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number to search: ");
        int target = sc.nextInt();

        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                System.out.println("Number found at index " + mid);
                found = true;
                break;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Number not found");
        }

        sc.close();
    }
}