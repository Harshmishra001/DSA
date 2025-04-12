

// Time Complexity (TC)
// enqueue(int value) → O(1) (Insertion at the rear takes constant time)

// dequeue() → O(1) (Removal from the front takes constant time)

// peek() → O(1) (Fetching the front element takes constant time)

// isEmpty() → O(1) (Checking if the queue is empty is constant time)

// getSize() → O(1) (Size is stored as a variable, so retrieval is constant time)

// ✅ Overall Time Complexity: O(1) for all operations

// Space Complexity (SC)
// The queue stores N elements in a linked list, where each element is represented as a QueueNode object.

// Each QueueNode stores:

// 1 integer (val) → O(1)

// 1 pointer (next) → O(1)

// For N elements, the total space required is O(N).

// ✅ Overall Space Complexity: O(N) (Proportional to the number of elements stored)

// Node structure for queue elements
class QueueNode {
    int val;
    QueueNode next;

    QueueNode(int data) {
        val = data;
        next = null;
    }
}

// Queue implementation using a linked list
class ImplementQueueUsingLL {
    private QueueNode front = null, rear = null;
    private int size = 0;

    // Checks if the queue is empty
    boolean isEmpty() {
        return front == null;
    }

    // Returns the front element without removing it
    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.val;
    }

    // Enqueues (adds) an element to the rear of the queue
    void enqueue(int value) {
        QueueNode temp = new QueueNode(value);

        if (front == null) { // If queue is empty, front and rear are the same
            front = temp;
            rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
        System.out.println(value + " inserted into Queue");
        size++;
    }

    // Dequeues (removes) the front element of the queue
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println(front.val + " removed from Queue");
        front = front.next;
        size--;

        if (front == null) { // If queue becomes empty, reset rear
            rear = null;
        }
    }

    // Returns the size of the queue
    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ImplementQueueUsingLL q = new ImplementQueueUsingLL(); // Corrected instantiation

        // Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Dequeue operation
        q.dequeue();

        // Display size and front element
        System.out.println("The size of the Queue is: " + q.getSize());
        System.out.println("The front element (peek) of the Queue is: " + q.peek());
    }
}
