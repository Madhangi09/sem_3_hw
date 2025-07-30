class StudentNode {
    String name;
    StudentNode left, right;

    // Constructor
    public StudentNode(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }
}

public class StudentTree {
    StudentNode root;

    // Preorder Traversal: Root → Left → Right
    void preorder(StudentNode node) {
        if (node == null) return;
        System.out.println(node.name); // visit root
        preorder(node.left);           // visit left
        preorder(node.right);          // visit right
    }

    // Postorder Traversal: Left → Right → Root
    void postorder(StudentNode node) {
        if (node == null) return;
        postorder(node.left);          // visit left
        postorder(node.right);         // visit right
        System.out.println(node.name); // visit root
    }

    public static void main(String[] args) {
        StudentTree st = new StudentTree();

        // Creating the tree (same structure as described earlier)
        st.root = new StudentNode("Anu");
        st.root.left = new StudentNode("Bala");
        st.root.right = new StudentNode("Divya");
        st.root.left.right = new StudentNode("Charu");
        st.root.left.right.right = new StudentNode("Deepa");
        st.root.right.right = new StudentNode("Elam");

        System.out.println("--- Preorder Traversal (Attendance) ---");
        st.preorder(st.root);

        System.out.println("\n--- Postorder Traversal (Emails) ---");
        st.postorder(st.root);
    }
}
