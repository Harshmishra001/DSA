

public class RemoveDuplicateDLL {
    
   static class Node {
        int data;
        Node next, prev;
    
        Node(int val) {
            data = val;
            next = prev = null;
        }
    }
    // Function to print the linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to remove duplicates from sorted doubly linked list
    static Node removeDuplicates(Node head) {
        if (head == null || head.next == null) return head;

        Node p = head;
        while (p.next != null) {
            if (p.data == p.next.data) {
                Node temp = p.next;
                p.next = temp.next; 
                if (temp.next != null)
                    temp.next.prev = p;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original list:");
        printList(head);

        head = removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}
