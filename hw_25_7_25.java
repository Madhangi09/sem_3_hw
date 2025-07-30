class TreeNode {
    String data;
    TreeNode left, right;

    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class DepartmentTree {
    TreeNode root;

    // Inorder Traversal: Left - Root - Right
    void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    // Preorder Traversal: Root - Left - Right
    void preorder(TreeNode node) {
        if (node != null) {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder Traversal: Left - Right - Root
    void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        DepartmentTree tree = new DepartmentTree();

        // Build the tree
        tree.root = new TreeNode("Academic");
        tree.root.left = new TreeNode("Science");
        tree.root.right = new TreeNode("Arts");

        tree.root.left.left = new TreeNode("Physics");
        tree.root.left.right = new TreeNode("Chemistry");

        tree.root.right.left = new TreeNode("History");
        tree.root.right.right = new TreeNode("Literature");

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);  // Left → Root → Right

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root); // Root → Left → Right

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root); // Left → Right → Root
    }
}
