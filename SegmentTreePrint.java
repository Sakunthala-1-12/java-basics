public class SegmentTreePrint {

    static int[] tree;

    static void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            tree[node] = arr[start];
            System.out.println(tree[node] + " [" + start + "]");
            return;
        }

        int mid = (start + end) / 2;

        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = tree[2 * node] + tree[2 * node + 1];

        System.out.println(
            tree[2 * node] + " + " +
            tree[2 * node + 1] + " = " +
            tree[node] + " [" + start + "-" + end + "]"
        );
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 10, 12};

        tree = new int[4 * arr.length];

        build(arr, 1, 0, arr.length - 1);
    }
}