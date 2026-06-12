class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinaryTree<T> {
    TreeNode<T> root;

    BinaryTree(T rootData) {
        root = new TreeNode<>(rootData);
    }

    // Inorder Traversal (Left - Root - Right)
    public void inorder(TreeNode<T> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder Traversal (Root - Left - Right)
    public void preorder(TreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder Traversal (Left - Right - Root)
    public void postorder(TreeNode<T> node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
}
public class Main {
    public static void main(String[] args) {
        // Create Binary Tree of Strings
        BinaryTree<String> tree = new BinaryTree<>("A");

        // Add children
        tree.root.left = new TreeNode<>("B");
        tree.root.right = new TreeNode<>("C");

        tree.root.left.left = new TreeNode<>("D");
        tree.root.left.right = new TreeNode<>("E");

        // Tree looks like:
        //        A
        //      /   \
        //     B     C
        //    / \
        //   D   E

        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);
    }
}
0 