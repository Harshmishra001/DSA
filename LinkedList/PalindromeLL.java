import java.util.Stack;

class PalindromeLL {
    
    // Definition for singly-linked list
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; this.next = null; }
    }
    
    /**
     * Brute force approach using a Stack
     * Time Complexity: O(N) - Traversing the linked list twice
     * Space Complexity: O(N) - Storing values in a stack
     */
    public static boolean isPalindromeBrute(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node curr = head;
        
        // Push all elements into the stack
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        
        // Reset curr to head
        curr = head;
        
        // Compare stack elements with linked list values
        while (curr != null) {
            if (curr.val != stack.pop()) {
                return false; // Not a palindrome
            }
            curr = curr.next;
        }
        return true; // Palindrome
    }
    
    /**
     * Optimized approach using the slow & fast pointer method
     * Time Complexity: O(N) - Traversing the list to find the middle and comparing
     * Space Complexity: O(1) - No extra space used apart from pointers
     */
    public static boolean isPalindromeOptimized(Node head) {
        if (head == null || head.next == null) return true;
        
        Node slow = head, fast = head;
        
        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the linked list
        Node prev = null, curr = slow;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Compare first half and reversed second half
        Node first = head, second = prev;
        while (second != null) { // Only need to compare second half
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
    
    // Main method to test both approaches
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 2 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        
        System.out.println("Brute Force Approach: " + isPalindromeBrute(head)); // Expected: true
        System.out.println("Optimized Approach: " + isPalindromeOptimized(head)); // Expected: true
    }
}
