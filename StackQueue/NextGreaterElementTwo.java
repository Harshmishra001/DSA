// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater
//  number for every element in nums.

// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means
//  you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 
// Example 1:

// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.
import java.util.*;

public class NextGreaterElementTwo {

    // Brute Force Approach - O(n^2) Time | O(n) Space
    static int[] nextGreaterElementBrute(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Result array to store next greater elements
        Arrays.fill(result, -1); // Initialize all elements to -1 (default when no greater element is found)

        // Traverse each element in the array
        for (int i = 0; i < n; i++) {
            // Look for the next greater element in the circular array
            for (int j = i + 1; j < i + n; j++) {
                if (arr[j % n] > arr[i]) { // Modulo ensures circular traversal
                    result[i] = arr[j % n]; // Found the next greater element
                    break; // Stop searching after finding the first greater element
                }
            }
        }
        return result;
    }

    // Optimal Approach - O(n) Time | O(n) Space using Monotonic Stack
    static int[] nextGreaterElementOptimal(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Array to store next greater elements
        Arrays.fill(result, -1); // Initialize result array with -1
        Stack<Integer> stack = new Stack<>(); // Stack to maintain potential next greater elements

        // Step 1: Traverse the array twice (to simulate circular behavior)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentElement = arr[i % n]; // Access element using modulo operator

            // Step 2: Remove elements from stack that are smaller or equal to current element
            while (!stack.isEmpty() && stack.peek() <= currentElement) {
                stack.pop(); // Pop elements that cannot be the next greater element
            }

            // Step 3: Only update the result array in the first pass (i < n)
            if (i < n) {
                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            // Step 4: Push the current element onto the stack
            stack.push(currentElement);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};

        // Brute Force Approach
        int[] result = nextGreaterElementBrute(arr);
        System.out.println("Brute Force: " + Arrays.toString(result));

        // Optimal Approach
        result = nextGreaterElementOptimal(arr);
        System.out.println("Optimal: " + Arrays.toString(result));
    }
}

/*
Dry Run Explanation for Optimal Approach:

Input: [4, 5, 2, 10, 8]

Step 1: Initialize result array and stack
result = [-1, -1, -1, -1, -1]
stack = []

Step 2: Traverse from i = 9 to 0 (simulate circular array)

1. i = 9 (index 4 → arr[4] = 8)
   - Stack is empty → No greater element, keep -1
   - Push 8 onto stack
   stack = [8]

2. i = 8 (index 3 → arr[3] = 10)
   - Pop 8 (since 10 > 8)
   - Stack empty → No greater element, keep -1
   - Push 10 onto stack
   stack = [10]

3. i = 7 (index 2 → arr[2] = 2)
   - Top of stack = 10 → Next greater = 10
   - Push 2 onto stack
   stack = [10, 2]
   result = [-1, -1, 10, -1, -1]

4. i = 6 (index 1 → arr[1] = 5)
   - Pop 2 (since 5 > 2)
   - Top of stack = 10 → Next greater = 10
   - Push 5 onto stack
   stack = [10, 5]
   result = [-1, 10, 10, -1, -1]

5. i = 5 (index 0 → arr[0] = 4)
   - Pop 4 (since 5 > 4)
   - Top of stack = 5 → Next greater = 5
   - Push 4 onto stack
   stack = [10, 5, 4]
   result = [5, 10, 10, -1, -1]

Final Output:
Brute Force: [5, 10, 10, -1, 10]
Optimal: [5, 10, 10, -1, 10]
*/
