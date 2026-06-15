public class SameTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isSameTree(Node p, Node q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One node is null and the other is not
        if (p == null || q == null) {
            return false;
        }

        // Data values are different
        if (p.data != q.data) {
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) &&isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(15);
        root1.left = new Node(10);
        root1.right = new Node(20);
        root1.left.left = new Node(7);
        root1.right.right = new Node(40);

        Node root2 = new Node(15);
        root2.left = new Node(8);
        root2.right = new Node(17);
        root1.left.left = new Node(7);
        root1.right.right = new Node(40);

        System.out.println(isSameTree(root1, root2)); // true
    }
}