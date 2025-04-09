package StackQueue;

// Time Complexity:
// - push(): O(1) (Insertion at the rear)
// - pop(): O(1) (Removal from the front)
// - top(): O(1) (Accessing front element)
// - size(): O(1) (Tracking size)

// Space Complexity:
// - O(n) (Array of fixed size storing n elements)

class ImplementQueueUsingArray {
    private int[] arr; // Array to store queue elements
    private int front, rear, currSize, maxSize; // Pointers and size variables
    
    // Default constructor with a queue size of 16
    public ImplementQueueUsingArray() {
        this(16); // Calls the parameterized constructor with default size 16
    }

    // Constructor with custom queue size
    public ImplementQueueUsingArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
        currSize = 0;
    }
    
    // Function to enqueue (insert) an element into the queue
    public void enqueue(int newElement) {
        if (currSize == maxSize) { // If the queue is full
            System.out.println("Queue is Full. Cannot insert " + newElement);
            return;
        }
        if (rear == -1) { // If queue is initially empty
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % maxSize; // Circular increment
        }
        arr[rear] = newElement; // Add element at the rear
        System.out.println("Inserted: " + newElement);
        currSize++;
    }
    
    // Function to dequeue (remove) the front element from the queue
    public int dequeue() {
        if (isEmpty()) { // If queue is empty
            System.out.println("Queue is Empty. Cannot dequeue.");
            return -1;
        }
        int dequeued = arr[front]; // Get the front element
        if (currSize == 1) { // If only one element is present
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize; // Move the front pointer forward
        }
        currSize--;
        System.out.println("Removed: " + dequeued);
        return dequeued;
    }
    
    // Function to get the front element without removing it
    public int peek() {
        if (isEmpty()) { // If queue is empty
            System.out.println("Queue is Empty.");
            return -1;
        }
        return arr[front];
    }
    
    // Function to get the current size of the queue
    public int size() {
        return currSize;
    }
    
    // Function to check if the queue is empty
    public boolean isEmpty() {
        return currSize == 0;
    }

    public static void main(String[] args) {
        ImplementQueueUsingArray queue = new ImplementQueueUsingArray(6); // Queue with size 6
        
        // Enqueue operations
        queue.enqueue(4);
        queue.enqueue(14);
        queue.enqueue(24);
        queue.enqueue(34);
        
        // Display front element
        System.out.println("Peek before dequeue: " + queue.peek());
        
        // Display size before deletion
        System.out.println("Queue size before dequeue: " + queue.size());
        
        // Dequeue operation
        queue.dequeue();
        
        // Display front element after deletion
        System.out.println("Peek after dequeue: " + queue.peek());
        
        // Display size after deletion
        System.out.println("Queue size after dequeue: " + queue.size());
    }
}

/*
Dry Run:

Step 1: Initialize Queue (maxSize = 6)
------------------------------------
Queue: [_, _, _, _, _, _]  (Empty queue)
front = -1, rear = -1, currSize = 0

Step 2: enqueue(4)
------------------------------------
Queue: [4, _, _, _, _, _]
front = 0, rear = 0, currSize = 1

Step 3: enqueue(14)
------------------------------------
Queue: [4, 14, _, _, _, _]
front = 0, rear = 1, currSize = 2

Step 4: enqueue(24)
------------------------------------
Queue: [4, 14, 24, _, _, _]
front = 0, rear = 2, currSize = 3

Step 5: enqueue(34)
------------------------------------
Queue: [4, 14, 24, 34, _, _]
front = 0, rear = 3, currSize = 4

Step 6: peek()
------------------------------------
Output: 4 (Front element)

Step 7: size()
------------------------------------
Output: 4

Step 8: dequeue()
------------------------------------
Queue: [_, 14, 24, 34, _, _]
front = 1, rear = 3, currSize = 3
Output: 4

Step 9: peek()
------------------------------------
Output: 14 (New front element)

Step 10: size()
------------------------------------
Output: 3
*/

