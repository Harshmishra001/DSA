
// push(): Insert the element in the stack.

// pop(): Remove and return the topmost element of the stack.

// top(): Return the topmost element of the stack

// size(): Return the number of remaining elements in the stack.

// Time Complexity: O(N)
// Space Complexity: O(N)




public class ImplementStackUsingArray {
    public static void main(String[] args) {

        stack s = new stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
    }
}
class stack {
    int size = 10000;
    int arr[] = new int[size];
    int top = -1;
    void push(int x) {
        top++;
        arr[top] = x;
    }
    int pop() {
        int x = arr[top];
        top--;
        return x;
    }
    int top() {
        return arr[top];
    }
    int size() {
        return top + 1;
    }
}
// Output:

// Top of the stack before deleting any element 7
// Size of the stack before deleting any element 3
// The element deleted is 7
// Size of the stack after deleting an element 2
// Top of the stack after deleting an element 3
