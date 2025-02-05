import java.util.*;
class LL
{ 
    Node head; 
    /* Linked list Node. This inner class is made static so that main() can access it */
    static class Node { 
        int data; 
        Node next; 
        Node(int d) { data = d; next=null; } // Constructor 
    } 

    /* method to create a simple linked list with 3 nodes*/
    public static void main(String[] args) 
    { 
        Node  head = new Node(1); 
        Node second = new Node(2); 
        Node third = new Node(3); 

        head.next = second; 

        second.next = third;  

        System.out.println(head);
        System.out.println(second);
        System.out.println(third);

        System.out.println(head.data);
        System.out.println(second.data);
        System.out.println(third.data);

        System.out.println(head.next);
        System.out.println(second.next);
        System.out.println(third.next);
    } 
}