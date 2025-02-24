
import java.util.*;

class LevelOrderTraversal {
    static class Node {
        int data;
        Node left, right;
        
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    
    // Time Complexity: O(n), Space Complexity: O(n)
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.print("Level Order Traversal: ");
        levelOrder(root);
        System.out.println();
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
1. Initialize a queue and add the root node (1).
   Queue: [1]

2. Dequeue 1, print it, and enqueue its children (2, 3).
   Output: 1
   Queue: [2, 3]

3. Dequeue 2, print it, and enqueue its children (4, 5).
   Output: 1 2
   Queue: [3, 4, 5]

4. Dequeue 3, print it. It has no children.
   Output: 1 2 3
   Queue: [4, 5]

5. Dequeue 4, print it. It has no children.
   Output: 1 2 3 4
   Queue: [5]

6. Dequeue 5, print it. It has no children.
   Output: 1 2 3 4 5
   Queue: [] (empty, traversal complete)

Final Output:
Level Order Traversal: 1 2 3 4 5
*/
