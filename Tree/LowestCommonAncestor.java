// Time complexity: O(N) where n is the number of nodes.
// Space complexity: O(N), auxiliary space.

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursive calls to find LCA in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, current root is the LCA
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        // Constructing the example binary tree:
        /*
                 3
               /   \
              5     1
             / \   / \
            6   2 0   8
               / \
              7   4
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor sol = new LowestCommonAncestor();
        
        // Example: Finding LCA of 5 and 1
        TreeNode lca = sol.lowestCommonAncestor(root, root.left, root.right);
        System.out.println("LCA of 5 and 1: " + lca.val);  // Output: 3

        // Example: Finding LCA of 5 and 4
        lca = sol.lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println("LCA of 5 and 4: " + lca.val);  // Output: 5
    }
}
