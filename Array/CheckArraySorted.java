
// Given an array arr[], check whether it is sorted in non-decreasing order. Return true if it is sorted 
// otherwise false.

// Examples:

// Input: arr[] = [10, 20, 30, 40, 50]
// Output: true
// Explanation: The given array is sorted.
// Input: arr[] = [90, 80, 100, 70, 40, 30]
// Output: false
// Explanation: The given array is not sorted.
// Expected Time Complexity: O(n)
// Expected Auxiliary Space: O(1)

class CheckArraySorted {
    // Method to check if the given array is sorted in non-decreasing order
    boolean arraySortedOrNot(int[] arr, int n) {
        // Loop through the array starting from the second element
        for (int i = 1; i < n; i++)
            // If the current element is less than the previous one, return false
            if (arr[i] < arr[i - 1])
                return false;
        // If no such pair is found, the array is sorted
        return true;       
    }

    public static void main(String[] args) {
        CheckArraySorted checker = new CheckArraySorted();

        // Test cases
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] unsortedArray = {1, 3, 2, 4};

        // Check if the sorted array is sorted
        boolean isSorted1 = checker.arraySortedOrNot(sortedArray, sortedArray.length);
        System.out.println("Is the first array sorted? " + isSorted1); // Output: true

        // Check if the unsorted array is sorted
        boolean isSorted2 = checker.arraySortedOrNot(unsortedArray, unsortedArray.length);
        System.out.println("Is the second array sorted? " + isSorted2); // Output: false
    }
}

// Dry Run Examples:
// Input Array: [1, 2, 3, 4, 5]
// n = 5
// Iterations:
// i = 1: arr[1] (2) >= arr[0] (1) -> continue
// i = 2: arr[2] (3) >= arr[1] (2) -> continue
// i = 3: arr[3] (4) >= arr[2] (3) -> continue
// i = 4: arr[4] (5) >= arr[3] (4) -> continue
// End of loop, return true -> Array is sorted

// Input Array: [1, 3, 2, 4]
// n = 4
// Iterations:
// i = 1: arr[1] (3) >= arr[0] (1) -> continue
// i = 2: arr[2] (2) < arr[1] (3) -> return false
// End of loop, return false -> Array is not sorted