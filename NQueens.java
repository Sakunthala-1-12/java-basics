public class NQueens {

    static int N = 4;
    static int count = 0;

    static boolean[] cols = new boolean[N];
    static boolean[] d1 = new boolean[2 * N];
    static boolean[] d2 = new boolean[2 * N];

    static void solve(int r) {

        if (r == N) {
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {

            if (cols[c] || d1[r - c + N] || d2[r + c])
                continue;

            // Place Queen
            cols[c] = true;
            d1[r - c + N] = true;
            d2[r + c] = true;

            solve(r + 1);

            // Backtrack
            cols[c] = false;
            d1[r - c + N] = false;
            d2[r + c] = false;
        }
    }

    public static void main(String[] args) {

        solve(0);

        System.out.println("Total Solutions = " + count);
    }
}