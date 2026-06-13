public class Frog_jump{

    public static int frogJump(int[] heights) {
        int n = heights.length;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int oneJump = dp[i - 1] +
                    Math.abs(heights[i] - heights[i - 1]);

            int twoJump = Integer.MAX_VALUE;

            if (i > 1) {
                twoJump = dp[i - 2] +
                        Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(oneJump, twoJump);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};

        System.out.println(
            "Minimum Energy = " + frogJump(heights)
        );
    }
}