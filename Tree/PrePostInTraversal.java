import java.util.*;

class PrePostIn {
    static class Node {
        int data;
        Node left, right;
        
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    
    // Time Complexity: O(n), Space Complexity: O(h)
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    // Time Complexity: O(n), Space Complexity: O(h)
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    // Time Complexity: O(n), Space Complexity: O(h)
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println();
        
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();
        
        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println();
    }
}
