

public class KgrpReverseLinkedList {
    static class Node {
        int data;
        Node next;
    
        // Constructor to initialize a node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Function to print the linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    // Function to reverse the linked list
    static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        
        while (curr != null) {
            next = curr.next;  // Store the next node
            curr.next = prev;  // Reverse the current node's pointer
            prev = curr;  // Move prev to the current node
            curr = next;  // Move curr to the next node
        }
        return prev; // New head of the reversed list
    }

    // Function to get the kth node from a given node
    static Node getKthNode(Node temp, int k) {
        k -= 1; // Because k-th means moving k-1 times from current node
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp; // Returns null if k-th node doesn't exist
    }

    // Function to reverse nodes in k-groups
    static Node kReverse(Node head, int k) {
        if (head == null || k == 1 || head.next == null) return head; // Edge case
        
        Node temp = head;
        Node prevLast = null; // Tracks the last node of the previous reversed group

        while (temp != null) {
            Node kThNode = getKthNode(temp, k); // Find the k-th node from temp
            
            if (kThNode == null) { // If k-th node is null, attach remaining nodes and break
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }
            

            Node nextNode = kThNode.next; // Store the next node after k-th node
            kThNode.next = null; // Break the link to isolate k nodes
            
            // Reverse the k nodes
            Node reversedHead = reverseLL(temp);

            if (temp == head) {
                head = reversedHead; // Update head if this is the first group
            } else {
                prevLast.next = reversedHead; // Connect previous part with reversed part
            }

            prevLast = temp; // Update prevLast to the last node of the reversed group
            temp = nextNode; // Move to the next group
        }
        return head;
    }

    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original linked list:");
        printList(head);

        int k = 3; // Reverse in groups of k = 3
        head = kReverse(head, k);

        System.out.println("Modified linked list:");
        printList(head);
    }
}

/*
*************** DRY RUN ******************
** Input List: **
1 -> 2 -> 3 -> 4 -> 5
** k = 3 **

Step 1: Find the k-th node.
- Start from head (1), move 2 steps ahead: k-th node = 3

Step 2: Break the link after 3.
- List becomes: 1 -> 2 -> 3 (isolated) | 4 -> 5 (remaining)

Step 3: Reverse first k-group.
- Reversed: 3 -> 2 -> 1 | 4 -> 5

Step 4: Move to next k-group.
- Start at 4, find k-th node (not available, only 2 nodes left)
- Attach remaining part as is.

** Output List after Reversal: **
3 -> 2 -> 1 -> 4 -> 5

******************************************
** Time Complexity: O(n) **
- O(n) for traversing the list
- O(n) for reversing the segments

** Space Complexity: O(1) **
- No extra space used except for pointers.
******************************************
*/

