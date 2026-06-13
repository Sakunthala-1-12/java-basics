public class LargestElementMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {5, 8, 2},
                {12, 7, 9},
                {4, 15, 6}
        };

        int largest = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] > largest) {
                    largest = matrix[i][j];
                }
            }
        }

        System.out.println("Largest element = " + largest);
    }
}
