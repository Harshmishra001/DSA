import java.io.*;
import java.util.*;

// Class to define the tree node
class CheckBalancedTreeIsBalanced {

    static class Node {
        int key;
        Node left;
        Node right;
        Node(int k) {
            key = k;
            left = right = null;
        }
    }

    // Time Complexity: O(n) - We visit each node once.
    // Space Complexity: O(h) - Recursive call stack uses space proportional to tree height.
    public static int isBalanced(Node root) {
        if (root == null)
            return 0;

        int lh = isBalanced(root.left);
        if (lh == -1)
            return -1;
        int rh = isBalanced(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1) {
            return -1;
        } 
        return Math.max(lh, rh) + 1;
    }

    // Main method
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(30);
        root.right.left = new Node(15);
        root.right.right = new Node(20);
        // root.right.right.right = new Node(60); // Making the tree **unbalanced** intentionally
        
        boolean isTreeBalanced = isBalanced(root) != -1;
        if (isTreeBalanced) 
            System.out.print("Balanced");
        else 
            System.out.print("Not Balanced");
    }
}
