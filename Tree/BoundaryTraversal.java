// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.*;

// Class for boundary traversal of a binary tree
class BoundaryTraversal {
    // Class representing a node in the binary tree
    static class Node {
        int data;
        Node left, right;

        // Constructor to initialize node with a given value
        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    // Function to check if a given node is a leaf node
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Function to add the left boundary of the tree (excluding leaf nodes)
    void addLeftBoundary(Node node, List<Integer> result) {
        Node curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) result.add(curr.data); // Add non-leaf node
            curr = (curr.left != null) ? curr.left : curr.right; // Move to the left if possible, else right
        }
    }

    // Function to add the right boundary of the tree (excluding leaf nodes)
    void addRightBoundary(Node node, List<Integer> result) {
        Node curr = node.right;
        List<Integer> temp = new ArrayList<>(); // Temporary list to store right boundary nodes
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data); // Add non-leaf node
            curr = (curr.right != null) ? curr.right : curr.left; // Move to the right if possible, else left
        }
        Collections.reverse(temp); // Reverse to maintain correct boundary order
        result.addAll(temp);
    }

    // Function to add all leaf nodes of the tree
    void addLeaves(Node node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data); // Add leaf node
        } else {
            addLeaves(node.left, result); // Recursively add left subtree leaves
            addLeaves(node.right, result); // Recursively add right subtree leaves
        }
    }

    // Main function to perform boundary traversal of the tree
    List<Integer> printBoundary(Node root) {
        List<Integer> result = new ArrayList<>(); // List to store boundary nodes
        if (root == null) return result; // If tree is empty, return empty list
        if (!isLeaf(root)) result.add(root.data); // Add root node if it's not a leaf
        addLeftBoundary(root, result); // Add left boundary nodes
        addLeaves(root, result); // Add leaf nodes
        addRightBoundary(root, result); // Add right boundary nodes
        return result; // Return the final boundary traversal list
    }

    // Helper function to print the boundary traversal result
    void printResult(List<Integer> result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BoundaryTraversal solution = new BoundaryTraversal();
        List<Integer> result = solution.printBoundary(root);
        System.out.print("Boundary Traversal: ");
        solution.printResult(result);
    }
}
