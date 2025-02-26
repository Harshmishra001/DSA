// Time Complexity: O(N)
// Space Complexity: O(1)
import java.util.*;
public class MaxPathSumInBT{
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
    private int maxi; // Class variable to store the maximum path sum

    // Function to find the maximum path sum for the entire binary tree
    int maxPathSum(Node root) {
        maxi = Integer.MIN_VALUE; // Initialize maxi to the smallest possible value
        findMaxPathSum(root); // Call function to calculate max path sum
        return maxi; // Return the maximum path sum
    }

    // Recursive function to calculate the max path sum
    int findMaxPathSum(Node root) {
        // Base case: If the current node is null, return 0 (no contribution to sum)
        if (root == null) {
            return 0;
        }

        // Recursively find the max path sum from the left and right subtrees
        // If a subtree contributes a negative sum, we consider it as 0 (ignore it)
        int leftMaxPath = Math.max(0, findMaxPathSum(root.left));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right));

        // Compute the max sum including the current node and both subtrees
        maxi = Math.max(maxi, leftMaxPath + rightMaxPath + root.data);

        // Return the maximum sum considering only one branch (left or right)
        return Math.max(leftMaxPath, rightMaxPath) + root.data;
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

        // Creating an instance of the Solution class
        MaxPathSumInBT solution = new MaxPathSumInBT ();

        // Finding and printing the maximum path sum
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);

        /* DRY RUN: Step-by-step Execution

        Tree Structure:
                  1
                /   \
               2     3
              / \
             4   5
                  \
                   6
                    \
                     7

        Step 1: Process Leaf Nodes
        - Node(4) has no left or right children → return 4
        - Node(7) has no left or right children → return 7

        Step 2: Process Node(6)
        - Right child (Node 7) contributes 7
        - Left child is null (considered as 0)
        - Max path sum through Node(6) = 6 + 7 = 13
        - Return 13

        Step 3: Process Node(5)
        - Right child (Node 6) contributes 13
        - Left child is null (considered as 0)
        - Max path sum through Node(5) = 5 + 13 = 18
        - Return 18

        Step 4: Process Node(2)
        - Left child (Node 4) contributes 4
        - Right child (Node 5) contributes 18
        - Max path sum through Node(2) = 2 + 4 + 18 = 24
        - Update `maxi = 24`
        - Return max(4, 18) + 2 = 20

        Step 5: Process Node(3)
        - No left or right children → return 3

        Step 6: Process Root Node(1)
        - Left child (Node 2) contributes 20
        - Right child (Node 3) contributes 3
        - Max path sum through Node(1) = 1 + 20 + 3 = 24
        - `maxi` remains 24 (already updated)

        FINAL RESULT: Maximum Path Sum = 24
        */
    }
}
