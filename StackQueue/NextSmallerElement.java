import java.util.*;

public class NextSmallerElement {

    // Brute Force Approach - O(n^2) Time | O(n) Space
    static int[] nearestSmallerElementBrute(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Result array to store nearest smaller elements

        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default to -1 (if no smaller element is found)

            // Check all previous elements to find the nearest smaller one
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) { // Found a smaller element
                    result[i] = arr[j]; 
                    break; // Stop after finding the nearest smaller element
                }
            }
        }
        return result;
    }

    // Optimal Approach - O(n) Time | O(n) Space using Monotonic Stack
    static int[] nearestSmallerElementOptimal(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Result array to store nearest smaller elements
        Stack<Integer> stack = new Stack<>(); // Stack to track potential nearest smaller elements

        for (int i = 0; i < n; i++) {
            int currentElement = arr[i];

            // Step 1: Remove bigger elements from the stack
            while (!stack.isEmpty() && stack.peek() >= currentElement) {
                stack.pop(); // Remove elements that are not smaller
            }

            // Step 2: If stack is empty, no smaller element exists, so store -1
            // Otherwise, store the top element (nearest smaller element)
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Step 3: Push the current element onto the stack
            stack.push(currentElement);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};

        // Brute Force Approach
        int[] result = nearestSmallerElementBrute(arr);
        System.out.println("Brute Force: " + Arrays.toString(result));

        // Optimal Approach
        result = nearestSmallerElementOptimal(arr);
        System.out.println("Optimal: " + Arrays.toString(result));
    }
}
