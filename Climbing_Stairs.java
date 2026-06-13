// Base case
// ways(0) = 1
// ways(1) = 1

// Dry run for n = 5
// ways(2) = ways(1) + ways(0) = 1 + 1 = 2
// ways(3) = ways(2) + ways(1) = 2 + 1 = 3
// ways(4) = ways(3) + ways(2) = 3 + 2 = 5
// ways(5) = ways(4) + ways(3) = 5 + 3 = 8

public class Climbing_Stairs {

    public static int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Number of ways to climb " + n + " stairs = " + climbStairs(n));
    }
}