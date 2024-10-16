
// Given an array, arr. The task is to find the largest element in it.

// Examples:

// Input: arr = [1, 8, 7, 56, 90]
// Output: 90
// Explanation: The largest element of the given array is 90.


class LargestElement { 
    
    // Function to find the largest element in an array
    public int largest(int arr[], int n) {
        // Check if array size is non-positive
        if (n <= 0) {
            return Integer.MIN_VALUE; // Return smallest possible value if array is empty or invalid
        }

        int largestIndex = 0; // Start with the first element as the largest
        for (int i = 1; i < n; i++) { // Loop through the array starting from the second element
            if (arr[i] > arr[largestIndex]) { // Compare each element with the current largest
                largestIndex = i; // Update largestIndex if a larger element is found
            }
        }
        
        return arr[largestIndex]; // Return the largest element found
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Hardcoded array and its size
        int[] arr = {10, 5, 20, 8, 15}; 
        int n = arr.length; // Size of the array

        // Creating an object of the LargestElement class
        LargestElement le = new LargestElement();
        
        // Finding and printing the largest element in the array
        int largestElement = le.largest(arr, n);
        System.out.println("The largest element in the array is: " + largestElement);
    }
}

/*
Dry Run Example:
Test Case Input:
Array: [10, 5, 20, 8, 15]

Step-by-Step Execution:
1. Array size (n) is 5, so we proceed with the array elements.
2. Array elements are [10, 5, 20, 8, 15].
3. Initialize largestIndex = 0 (the first element 10 is considered the largest initially).
4. Compare arr[1] (5) with arr[0] (10): 5 is not greater than 10, so largestIndex remains 0.
5. Compare arr[2] (20) with arr[0] (10): 20 is greater than 10, update largestIndex to 2.
6. Compare arr[3] (8) with arr[2] (20): 8 is not greater than 20, largestIndex remains 2.
7. Compare arr[4] (15) with arr[2] (20): 15 is not greater than 20, largestIndex remains 2.
8. The loop finishes. The largest element is arr[2] = 20.
9. Output: "The largest element in the array is: 20".

Final Output: 20
*/
