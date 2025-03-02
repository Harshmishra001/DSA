import java.util.*;

class Node {
    int data;
    Node left, right;

    // Constructor to initialize a node
    Node(int val) {
        data = val;
    }
}

public class LeftOrRightView {
    
    /**
     * Function to get the right-side view of the binary tree.
     * 
     * Time Complexity: O(N) -> Since each node is visited once.
     * Space Complexity: O(H) -> Due to recursive calls (where H = height of tree, O(log N) for balanced tree, O(N) for skewed tree).
     */
    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, result);
        return result;
    }

    /**
     * Function to get the left-side view of the binary tree.
     * 
     * Time Complexity: O(N) -> Since each node is visited once.
     * Space Complexity: O(H) -> Due to recursive calls (same as right view).
     */
    public List<Integer> leftSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        leftView(root, 0, result);
        return result;
    }

    /**
     * Recursive function for right view traversal.
     * 
     * Time Complexity: O(N) -> Each node is processed once.
     * Space Complexity: O(H) -> Recursion stack space.
     */
    private void rightView(Node root, int level, List<Integer> result) {
        if (root == null) return; // Base case: If node is null, return

        // If visiting this level for the first time, add node to result
        if (result.size() == level) result.add(root.data);

        // First visit the right child (priority for right view)
        rightView(root.right, level + 1, result);
        // Then visit the left child
        rightView(root.left, level + 1, result);
    }

    /**
     * Recursive function for left view traversal.
     * 
     * Time Complexity: O(N) -> Each node is processed once.
     * Space Complexity: O(H) -> Recursion stack space.
     */
    private void leftView(Node root, int level, List<Integer> result) {
        if (root == null) return; // Base case: If node is null, return

        // If visiting this level for the first time, add node to result
        if (result.size() == level) result.add(root.data);

        // First visit the left child (priority for left view)
        leftView(root.left, level + 1, result);
        // Then visit the right child
        leftView(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        LeftOrRightView solution = new LeftOrRightView();

        // Printing the right view
        System.out.println("Right View: " + solution.rightSideView(root));

        // Printing the left view
        System.out.println("Left View: " + solution.leftSideView(root));
    }
}
