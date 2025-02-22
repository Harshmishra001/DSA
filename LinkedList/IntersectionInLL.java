
import java.util.*;

public class IntersectionInLL {
   static class Node {
        int data;
        Node next;
        
        Node(int val) {
            data = val;
            next = null;
        }
    }
    // Brute force approach O(m*n), O(1) space
    static Node getIntersectionNodeBrute(Node head1, Node head2) {
        Node temp1 = head1;
        while (temp1 != null) {
            Node temp2 = head2;
            while (temp2 != null) {
                if (temp1 == temp2) {
                    return temp1;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return null;
    }
    
    // Function to find intersection using two-pointer approach (Optimal O(m+n), O(1) space)
    static Node getIntersectionNode(Node head1, Node head2) {
        Node d1 = head1, d2 = head2;
        while (d1 != d2) {
            d1 = (d1 == null) ? head2 : d1.next;
            d2 = (d2 == null) ? head1 : d2.next;
        }
        return d1;
    }
    
    // Function to print linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Creating first linked list: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        // Creating second linked list: 9 -> 10 -> NULL
        Node head2 = new Node(9);
        head2.next = new Node(10);
        
        // Creating intersection at node 4
        Node common = new Node(4);
        common.next = new Node(5);
        
        head1.next.next.next = common;
        head2.next.next = common;

        System.out.print("List 1: ");
        printList(head1);
        System.out.print("List 2: ");
        printList(head2);

        Node intersectionBrute = getIntersectionNodeBrute(head1, head2);
        if (intersectionBrute != null)
            System.out.println("Intersection (Brute) found at node with value: " + intersectionBrute.data);
        else
            System.out.println("No intersection found (Brute)." );

        Node intersection = getIntersectionNode(head1, head2);
        if (intersection != null)
            System.out.println("Intersection (Two Pointer) found at node with value: " + intersection.data);
        else
            System.out.println("No intersection found (Two Pointer)." );
    }
}
