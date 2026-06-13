import java.util.Scanner;

public class fibonacci_series {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = 1;

        System.out.println("First" + n + "Fibonacci Numbers:");

        System.out.println(dp[0] + " ");
        System.out.println(dp[1] + " ");

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println(dp[i] + " ");
        }
    }
}