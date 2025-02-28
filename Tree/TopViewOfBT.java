import java.util.*;





public class TopViewOfBT {
    /*
     * Function to return the top view of the binary tree.
     * Time Complexity: O(N) - We traverse each node once in BFS traversal.
     * Space Complexity: O(N) - We use a queue for BFS and a TreeMap for storing results.
     */
    // Helper class to store node and its horizontal distance
static class Pair {
    Node node;
    int hd;
    
    public Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
    // Node structure for the binary tree
 static class Node {
    int data;
    Node left;
    Node right;
    
    // Constructor to initialize the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
    public List<Integer> topView(Node root) {
        // List to store the result
        List<Integer> ans = new ArrayList<>();
        
        // Check if the tree is empty
        if (root == null) {
            return ans;
        }
        
        // TreeMap to store nodes appearing in the top view based on their horizontal distance
        Map<Integer, Integer> mpp = new TreeMap<>();
        
        // Queue for BFS traversal, stores nodes with their horizontal distance
        Queue<Pair> q = new LinkedList<>();
        
        // Insert root node with horizontal distance as 0
        q.add(new Pair(root, 0));
        
        // BFS traversal
        while (!q.isEmpty()) {
            // Get the node and its horizontal distance
            Pair pair = q.poll();
            Node node = pair.node;
            int line = pair.hd;
            
            // If this horizontal distance is not seen before, store it in the map
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }
            
            // Process left child with horizontal distance -1
            if (node.left != null) {
                q.add(new Pair(node.left, line - 1));
            }
            
            // Process right child with horizontal distance +1
            if (node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }
        }
        
        // Extract the top view elements from the map in sorted order of horizontal distance
        for (int value : mpp.values()) {
            ans.add(value);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        TopViewOfBT solution = new TopViewOfBT();

        // Get the top view traversal
        List<Integer> topView = solution.topView(root);

        // Print the result
        System.out.println("Top View of the Binary Tree: ");
        for (int node : topView) {
            System.out.print(node + " ");
        }
    }
}

/*
Detailed Dry Run:

Tree Structure:

          1
        /   \
       2     3
      / \   / \
     4  10 9  10
      \
       5
        \
         6

Step 1: Initialize
- `mpp = {}` (TreeMap for storing top view nodes)
- `q = [(1, 0)]` (Queue with root node and horizontal distance 0)

Step 2: BFS Traversal
1. Process Node 1 (hd = 0)
   - Add 1 to `mpp`: `{0: 1}`
   - Enqueue (2, -1), (3, 1)

2. Process Node 2 (hd = -1)
   - Add 2 to `mpp`: `{-1: 2, 0: 1}`
   - Enqueue (4, -2), (10, 0)

3. Process Node 3 (hd = 1)
   - Add 3 to `mpp`: `{-1: 2, 0: 1, 1: 3}`
   - Enqueue (9, 0), (10, 2)

4. Process Node 4 (hd = -2)
   - Add 4 to `mpp`: `{-2: 4, -1: 2, 0: 1, 1: 3}`
   - Enqueue (5, -1)

5. Process Node 10 (hd = 0)
   - Already exists in `mpp`, so skip.

6. Process Node 9 (hd = 0)
   - Already exists in `mpp`, so skip.

7. Process Node 10 (hd = 2)
   - Add 10 to `mpp`: `{-2: 4, -1: 2, 0: 1, 1: 3, 2: 10}`

8. Process Node 5 (hd = -1)
   - Already exists in `mpp`, so skip.
   - Enqueue (6, 0)

9. Process Node 6 (hd = 0)
   - Already exists in `mpp`, so skip.

Step 3: Extract and Print
Sorting `mpp` by horizontal distance gives: `[4, 2, 1, 3, 10]`
This is the top view of the binary tree.
*/
