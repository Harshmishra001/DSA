class DiameterOfBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize the node with a value
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    private int diameter; // Use an instance variable instead of an array

    /**
     * Function to find the diameter of a binary tree.
     * 
     * Time Complexity: O(N) - Each node is visited once.
     * Space Complexity: O(H) - Recursion stack space, where H is the height of the tree.
     */
    public int diameterOfBinaryTree(Node root) {
        diameter = 0; // Initialize the diameter
        height(root);  // Compute the height and update diameter
        return diameter; // Return the computed diameter
    }

    /**
     * Function to calculate the height of the tree and update the diameter.
     * 
     * Time Complexity: O(N) - Each node's height is calculated once.
     * Space Complexity: O(H) - Due to recursion stack.
     */
    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update the diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current node's subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        // Creating an instance of the DiameterOfBinaryTree class
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Calculate the diameter of the binary tree
        int diameter = solution.diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }
}