import java.util.Stack;

public class SortStack {
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // Base case: if the stack is not empty
        if (!s.isEmpty()) {
            // Remove the top element
            int top = s.pop();
            
            // Recursively sort the remaining stack
            sort(s);

             // Insert the removed element back into the sorted stack
             sortInsert(s, top);    //mtlb uppr ki 2 line pop krti rhegi ab jo last m 1 reh jayega top vo pop hoga fir vhi dusre stack s insert hona shuru hoga
        }
       
        return s;
    }

    public Stack<Integer> sortInsert(Stack<Integer> s, int x) {
        // Base case: if the stack is empty or x is greater than the top element
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);  // Insert x into the stack
            return s;
        }
        // Remove the top element of the stack
        int temp = s.pop();
        
        // Recursively call sortInsert to find the correct position for x
        sortInsert(s, x);

        // Push the removed element back onto the stack
        s.push(temp);

        
        return s;
    }
    
    public static void main(String[] args) {
        SortStack obj = new SortStack();
        
        // Creating a stack and pushing some elements onto it
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(4);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        
        // Printing the stack before sorting
        System.out.println("Stack before sorting: " + stack);
        
        // Sorting the stack
        Stack<Integer> sortedStack = obj.sort(stack);
        
        // Printing the stack after sorting
        System.out.println("Stack after sorting: " + sortedStack);
    }
}

// Execution Walkthrough:

// Before Sorting:

// The stack contains: [34, 3, 31, 98, 92, 23]
// The top element is 23.
// Calling sort(stack):

// Removes 23, so stack becomes [34, 3, 31, 98, 92].
// Calls sort(stack) again.
// Recursive Calls:

// Removes 92, so stack becomes [34, 3, 31, 98].
// Calls sort(stack) again.
// Further Recursive Calls:

// Removes 98, so stack becomes [34, 3, 31].
// Calls sort(stack) again.
// Continues Recursively:

// Removes 31, so stack becomes [34, 3].
// Calls sort(stack) again.
// More Recursion:

// Removes 3, so stack becomes [34].
// Calls sort(stack) again.
// Final Recursion:

// Removes 34, so stack becomes [].
// Calls sort(stack) again, but this time the stack is empty, so the recursion base case is hit.


// Begin Sorting Stack:
// Inserting 34:

// Stack is empty, so 34 is pushed onto the stack: [34].
// Inserting 3:

// Stack: [34].
// 3 is less than 34, so 34 is popped.
// Recursive sortInsert(s, 3) call: 3 is pushed, then 34 is pushed back: [3, 34].
// Inserting 31:

// Stack: [3, 34].
// 31 is less than 34, so 34 is popped.
// Recursive sortInsert(s, 31) call: 31 is pushed, then 34 is pushed back: [3, 31, 34].
// Inserting 98:

// Stack: [3, 31, 34].
// 98 is greater than 34, so 98 is pushed directly: [3, 31, 34, 98].
// Inserting 92:

// Stack: [3, 31, 34, 98].
// 92 is less than 98, so 98 is popped.
// Recursive sortInsert(s, 92) call: 92 is pushed, then 98 is pushed back: [3, 31, 34, 92, 98].
// Inserting 23:

// Stack: [3, 31, 34, 92, 98].
// 23 is less than 92, so 92 is popped.
// Recursive sortInsert(s, 23) call: 23 is pushed, then 92 is pushed back: [3, 31, 34, 23, 92, 98].
// Stack After Sorting:

// The stack is now sorted in ascending order: [3, 23, 31, 34, 92, 98].
// Summary
// Initial Stack: [34, 3, 31, 98, 92, 23]
// Stack After Sorting: [3, 23, 31, 34, 92, 98]

    
