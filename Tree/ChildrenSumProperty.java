// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.*;

// TreeNode structure
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class ChildrenSumProperty {
    // Function to modify the tree to follow Children Sum Property
    public void changeTree(TreeNode root) {
        if (root == null) return; // Base case

        int childSum = 0;
        if (root.left != null) childSum += root.left.val;
        if (root.right != null) childSum += root.right.val;

        if (childSum >= root.val) {
            root.val = childSum;
        } else {
            if (root.left != null) root.left.val = root.val;
            if (root.right != null) root.right.val = root.val;
        }

        // Recursive calls for left and right children
        changeTree(root.left);
        changeTree(root.right);

        // Update the root value after recursion
        int total = 0;
        if (root.left != null) total += root.left.val;
        if (root.right != null) total += root.right.val;
        if (root.left != null || root.right != null) root.val = total;
    }

    // Function for inorder traversal
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Construct the tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        ChildrenSumProperty obj = new ChildrenSumProperty();

        System.out.print("Before modification (Inorder): ");
        obj.inorderTraversal(root);
        System.out.println();

        obj.changeTree(root);

        System.out.print("After modification (Inorder): ");
        obj.inorderTraversal(root);
        System.out.println();
    }
}

/*
    Dry Run for the given tree:

    Initial tree structure:

            3
           / \
          5   1
         / \  / \
        6   2 0  8
           / \
          7   4

    Step 1: Recursively process left and right subtrees first.
    Step 2: At each node, check if sum of children is >= node value.
    Step 3: If not, update children to hold parent's value.
    Step 4: After processing children, update the node to sum of children.

    After modification, the tree follows the Children Sum Property:

           36
          /  \
        13    23
       /  \   /  \
      6    7 0    8
          / \
         7   4
*/
