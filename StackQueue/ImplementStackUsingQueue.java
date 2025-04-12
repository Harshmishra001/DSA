

/*
Time Complexity:
- push(): O(N) (Since elements are rotated within the queue)
- pop(): O(1) (Removes the front element in O(1) time)
- top(): O(1) (Retrieves the front element in O(1) time)
- size(): O(1) (Retrieves the size in O(1) time)

Space Complexity:
- O(N) (A queue of N elements is used)
*/
import java.util.*;

// Driver class to demonstrate stack operations using a queue
public class ImplementStackUsingQueue {

    Queue<Integer> q = new LinkedList<>();

    // Push operation: Inserts an element at the back and rotates the queue to maintain stack order
    void push(int x) {
        q.add(x);  // Step 1: Insert element at the end

        // Step 2: Rotate the queue to bring the newly added element to the front
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    // Pop operation: Removes the front element (which behaves like the top of a stack)
    int pop() {
        return q.remove();
    }

    // Top operation: Retrieves the top element without removing it
    int top() {
        return q.peek();
    }

    // Size operation: Returns the current size of the stack
    int size() {
        return q.size();
    }
    public static void main(String[] args) {
        ImplementStackUsingQueue s = new ImplementStackUsingQueue();

        // Pushing elements onto the stack
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);

        // Displaying stack details
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());

        // Popping an element
        System.out.println("The deleted element is: " + s.pop());

        // Displaying updated stack details
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}


    


/*
Dry Run:

Step 1: Initialize an empty queue
-----------------------------------
Queue: (empty)

Step 2: push(3)
-----------------------------------
Queue after rotation: [3]
Output: 3 inserted

Step 3: push(2)
-----------------------------------
Queue before rotation: [3, 2]
Queue after rotation:  [2, 3]
Output: 2 inserted

Step 4: push(4)
-----------------------------------
Queue before rotation: [2, 3, 4]
Queue after rotation:  [4, 2, 3]
Output: 4 inserted

Step 5: push(1)
-----------------------------------
Queue before rotation: [4, 2, 3, 1]
Queue after rotation:  [1, 4, 2, 3]
Output: 1 inserted

Step 6: top()
-----------------------------------
Queue: [1, 4, 2, 3]
Output: Top of the stack is 1

Step 7: size()
-----------------------------------
Output: Size of the stack is 4

Step 8: pop()
-----------------------------------
Queue before popping: [1, 4, 2, 3]
Queue after popping:  [4, 2, 3]
Output: The deleted element is 1

Step 9: top()
-----------------------------------
Queue: [4, 2, 3]
Output: Top of the stack is 4

Step 10: size()
-----------------------------------
Output: Size of the stack is 3

*/

