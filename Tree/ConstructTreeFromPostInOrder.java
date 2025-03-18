// - **Time Complexity (TC):** **O(N)** → Each node is processed once, and hashmap lookups are **O(1)**.  
// - **Space Complexity (SC):** **O(N)** → HashMap stores **O(N)** elements, and recursion stack takes **O(N)** in the worst case (skewed tree).

import java.util.*;

public class ConstructTreeFromPostInOrder {
    // TreeNode structure
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    /**
     * @param inorder   List representing inorder traversal (Left -> Root -> Right).
     * @param postorder List representing postorder traversal (Left -> Right -> Root).
     * @return Root node of the constructed binary tree.
     */
    public static TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.size() != postorder.size() || inorder.isEmpty()) {
            return null; // Handle invalid input case
        }
        // Create a HashMap to store indexes of inorder elements for quick access
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < inorder.size(); i++) {
            indexMap.put(inorder.get(i), i);
        }

        return buildTreeRecursive(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1, indexMap);
    }

    /**
     * Recursive helper function to construct the binary tree.
     */
    private static TreeNode buildTreeRecursive(List<Integer> inorder, int inStart, int inEnd,List<Integer> postorder, int postStart, int postEnd,Map<Integer, Integer> indexMap) {
       
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        // The last element in postorder is the root of the current subtree
        int rootValue = postorder.get(postEnd);
        TreeNode root = new TreeNode(rootValue);

        // Find the root index in inorder traversal
        int inRootIndex = indexMap.get(rootValue);
        int leftSubtreeSize = inRootIndex - inStart;

        // Recursively build left and right subtrees
        root.left = buildTreeRecursive(inorder, inStart, inRootIndex - 1, postorder, postStart, postStart + leftSubtreeSize - 1, indexMap);

        root.right = buildTreeRecursive(inorder, inRootIndex + 1, inEnd, postorder, postStart + leftSubtreeSize, postEnd - 1, indexMap);

        return root;
    }

    /**
     * Prints the inorder traversal of a binary tree.
     */
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    /**
     * Prints the given list elements.
     */
    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example input lists representing inorder and postorder traversals
        List<Integer> inorder = Arrays.asList(40, 20, 50, 10, 60, 30);
        List<Integer> postorder = Arrays.asList(40, 50, 20, 60, 30, 10);

        // Display the input lists
        System.out.print("Inorder List: ");
        printList(inorder);

        System.out.print("Postorder List: ");
        printList(postorder);

        // Build the tree
        TreeNode root = buildTree(inorder, postorder);

        // Print the inorder traversal of the constructed binary tree
        System.out.println("Inorder Traversal of Constructed Binary Tree: ");
        printInorder(root);
        System.out.println();
    }
}
