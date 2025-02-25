
// Java program to find the height of a binary tree

import java.util.*;

class HeightOfBT {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Time Complexity: O(n), Space Complexity: O(h) (height of the tree)
    public static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);
        return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Height of tree is " + maxDepth(root));
    }
}

/*
Dry Run:
Binary Tree Structure:
        1
       / \
      2   3
     / \ 
    4   5

Step-by-step Execution:
1. Call maxDepth(1):
   - Calls maxDepth(2) and maxDepth(3)

2. Call maxDepth(2):
   - Calls maxDepth(4) and maxDepth(5)

3. Call maxDepth(4):
   - Left and right children are null → Returns 1 (leaf node)

4. Call maxDepth(5):
   - Left and right children are null → Returns 1 (leaf node)

5. maxDepth(2) returns max(1,1) + 1 = 2

6. Call maxDepth(3):
   - Left and right children are null → Returns 1 (leaf node)

7. maxDepth(1) returns max(2,1) + 1 = 3

Final Output:
Height of tree is 3
*/
