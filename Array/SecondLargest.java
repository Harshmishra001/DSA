
// Given an array arr, return the second largest distinct element from an array. If the second largest element 
// doesn't exist then return -1.

// Examples:

// Input: arr = [12, 35, 1, 10, 34, 1]
// Output: 34
// Explanation: The largest element of the array is 35 and the second largest element is 34.
// Input: arr = [10, 10]
// Output: -1
// Explanation: The largest element of the array is 10 and the second largest element does not exist..


class SecondLargest {   // Overall time complexity of the code is O(n)

    // Function to find the second largest element in an array
    int print2largest(int arr[], int n) {
       
        // If there are fewer than 2 elements, second largest doesn't exist
        if (n < 2) {
            return -1; // Return -1 as an indicator that second largest doesn't exist
        }
        
        int largest = arr[0]; // Assume the first element is the largest
        int secondLargest = Integer.MIN_VALUE; // Initialize second largest to the smallest possible value
        
        // Traverse the array to find the largest and second largest elements
        for (int i = 1; i < n; i++) {
            // If current element is larger than the largest, update largest and second largest
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } 
            // If current element is not the largest but is greater than second largest
            else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        
        // If second largest was never updated, return -1 (indicating it doesn't exist)
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }
        
        // Return the second largest element
        return secondLargest;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Test case: array and its size
        int[] arr = {10, 5, 20, 8, 15}; 
        int n = arr.length; // Get the size of the array
        
        // Create an object of SecondLargest class
        SecondLargest sol = new SecondLargest();
        
        // Call the method to find the second largest element and print it
        int secondLargest = sol.print2largest(arr, n);
        System.out.println("The second largest element in the array is: " + secondLargest);
    }
}

/*
Dry Run Example:
Test Case Input:
Array: [10, 5, 20, 8, 15]

Step-by-Step Execution:
1. Array size (n) is 5, so proceed with the array elements.
2. Array elements are [10, 5, 20, 8, 15].
3. Initialize largest = 10, secondLargest = Integer.MIN_VALUE.
4. Compare arr[1] (5) with largest (10): 5 is not greater than 10, but larger than secondLargest, so update secondLargest = 5.
5. Compare arr[2] (20) with largest (10): 20 is greater than 10, so update secondLargest = 10 and largest = 20.
6. Compare arr[3] (8) with largest (20): 8 is not greater than 20 and is smaller than secondLargest, no update.
7. Compare arr[4] (15) with largest (20): 15 is not greater than 20 but greater than secondLargest, update secondLargest = 15.
8. The loop finishes. The second largest element is 15.
9. Output: "The second largest element in the array is: 15".

Final Output: 15
*/
