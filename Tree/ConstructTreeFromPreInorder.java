import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
// - **Time Complexity (TC):** **O(N)** → Each node is processed once, and hashmap lookups are **O(1)**.  
// - **Space Complexity (SC):** **O(N)** → HashMap stores **O(N)** elements, and recursion stack takes **O(N)** in the worst case (skewed tree).
// TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class ConstructTreeFromPreInorder {
    // Function to build a binary tree from preorder and inorder traversals
    public TreeNode buildTree(Vector<Integer> preorder, Vector<Integer> inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        // Store indices of inorder elements for quick lookup
        for (int i = 0; i < inorder.size(); i++) {
            inMap.put(inorder.get(i), i);
        }

        // Recursively build the tree
        return buildTreeHelper(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, inMap);
    }

    // Recursive helper function to build the tree
    private TreeNode buildTreeHelper(Vector<Integer> preorder, int preStart, int preEnd,
                                     Vector<Integer> inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        // The first element of preorder is the root
        TreeNode root = new TreeNode(preorder.get(preStart));

        // Find the index of the root in inorder
        int inRoot = inMap.get(root.val);
        int leftSubtreeSize = inRoot - inStart;

        // Recursively construct left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

    // Function to print the inorder traversal
    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        Vector<Integer> inorder = new Vector<>(java.util.Arrays.asList(9, 3, 15, 20, 7));
        Vector<Integer> preorder = new Vector<>(java.util.Arrays.asList(3, 9, 20, 15, 7));

        ConstructTreeFromPreInorder treeBuilder = new ConstructTreeFromPreInorder();
        TreeNode root = treeBuilder.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of constructed Binary Tree:");
        treeBuilder.printInorder(root);
        System.out.println();
    }
}
