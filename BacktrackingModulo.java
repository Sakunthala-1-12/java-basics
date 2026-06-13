import java.util.ArrayList;
import java.util.List;

public class BacktrackingModulo {

    static void findSubsets(int[] arr, int m, int index,
                            List<Integer> currentSubset,
                            int currentMod) {

        // If subset is not empty and sum is divisible by m
        if (!currentSubset.isEmpty() && currentMod == 0) {
            System.out.println(currentSubset);
        }

        for (int i = index; i < arr.length; i++) {
            currentSubset.add(arr[i]);

            // Modular arithmetic concept
            int newMod = (currentMod + arr[i]) % m;

            findSubsets(arr, m, i + 1, currentSubset, newMod);

            // Backtrack
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};
        int m = 5;

        System.out.println("Subsets whose sum is divisible by " + m + ":");

        findSubsets(arr, m, 0, new ArrayList<>(), 0);
    }
}