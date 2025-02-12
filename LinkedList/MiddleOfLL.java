import java.util.*;

public class MiddleOfLL {

    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to calculate length of linked list
    static int lengthofLL(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    // Brute force O(2n) and O(1)
    static Node middle1(Node head) {
        int length = lengthofLL(head);
        int count = length / 2;
        Node mid = head;
        while (count > 0) {
            mid = mid.next;
            count--;
        }
        return mid;
    }

    // Optimal O(n/2) and O(1)   turtoise approach
    static Node middle2(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = new Node(14);
        head.next.next.next.next.next.next.next = new Node(16);

        Node mid = middle1(head);
        System.out.println("Brute force : " + mid.data);
        Node mid2 = middle2(head);
        System.out.println("Optimal : " + mid2.data);
    }
}