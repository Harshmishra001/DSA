// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.*;

// Class containing the solution for ZigZag traversal
class ZigZagTraversal {
    // Class representing a node in the binary tree
    static class Node {
        int data;
        Node left, right;

        // Constructor to initialize node with a value
        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public List<List<Integer>> zigZagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>(); // List to store the final result
        
        if (root == null) return result; // If tree is empty, return empty list
        
        Queue<Node> queue = new LinkedList<>(); // Queue for level order traversal
        queue.add(root);
        
        boolean leftToRight = true; // Flag to track the traversal direction
        
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level
            List<Integer> row = new ArrayList<>(size); // List to store nodes at the current level
            
            for (int i = 0; i < size; i++) {
                Node node = queue.poll(); // Get the front node from the queue
                
                // Add the node's value based on traversal direction
                if (leftToRight) {
                    row.add(node.data); // Left to right: add at the end
                } else {
                    row.add(0, node.data); // Right to left: add at the beginning (reverses order)
                }
                
                // Add left and right children to the queue if they exist
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            result.add(row); // Add the current level to the result
            
            leftToRight = !leftToRight; // Toggle traversal direction for next level
        }
        
        return result; // Return the final zigzag level order traversal
    }
}

// Helper class to test the solution
class Main {
    static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            System.out.println(row); // Print each level's nodes
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        ZigZagTraversal.Node root = new ZigZagTraversal.Node(1);
        root.left = new ZigZagTraversal.Node(2);
        root.right = new ZigZagTraversal.Node(3);
        root.left.left = new ZigZagTraversal.Node(4);
        root.left.right = new ZigZagTraversal.Node(5);
        root.right.left = new ZigZagTraversal.Node(6);
        root.right.right = new ZigZagTraversal.Node(7);

        ZigZagTraversal solution = new ZigZagTraversal();
        List<List<Integer>> result = solution.zigZagLevelOrder(root); // Perform zigzag traversal
        printResult(result); // Print the traversal result
    }
}

/*
Detailed Dry Run (Tree Structure):
         1
       /   \
      2     3
     / \   / \
    4   5 6   7

Step-by-step execution:
1. Initialize queue with root [1]. Left to right order.
2. Process level 0: 
   - Dequeue 1, add to row [1] (since leftToRight is true).
   - Enqueue left (2) and right (3).
   - Toggle direction (leftToRight = false).
   Output: [[1]]

3. Process level 1 (Right to Left):
   - Dequeue 2, insert at start of row [2].
   - Dequeue 3, insert at start of row [3, 2] (right to left order).
   - Enqueue children: 4, 5, 6, 7.
   - Toggle direction (leftToRight = true).
   Output: [[1], [3, 2]]

4. Process level 2 (Left to Right):
   - Dequeue 4, add at end [4].
   - Dequeue 5, add at end [4, 5].
   - Dequeue 6, add at end [4, 5, 6].
   - Dequeue 7, add at end [4, 5, 6, 7].
   - No more children to enqueue.
   - Toggle direction (leftToRight = false).
   Output: [[1], [3, 2], [4, 5, 6, 7]]

Final Output:
[[1], [3, 2], [4, 5, 6, 7]]

Explanation of the Toggle Mechanism:
- `leftToRight = !leftToRight;` switches the traversal direction at each level.
- When `leftToRight` is true, values are added normally (left to right order).
- When `leftToRight` is false, values are inserted at the start of the list (right to left order).
- This alternation ensures the zigzag pattern in traversal.
*/