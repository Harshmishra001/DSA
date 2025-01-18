package Sorting;
class Quicksort {

    // The partition function takes the array, low index, and high index,
    // and partitions the array around a pivot element.
    static int partition(int[] arr, int low, int high) {
        
        int pivot = arr[low]; // Choose the first element as the pivot
        int i = low;  // Pointer to track the smaller elements
        int j = high; // Pointer to track the larger elements

        // While i is less than j, continue to partition the array
        while (i < j) {
            // Increment i until we find an element larger than the pivot
            while (arr[i] <= pivot && i < high) {
                i++;
            }

            // Decrement j until we find an element smaller than or equal to the pivot
            while (arr[j] > pivot && j > low) {
                j--;
            }

            // If i < j, swap the elements at i and j
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // After the while loop, i and j have crossed, so swap the pivot with arr[j]
        // This places the pivot in its correct position in the sorted array
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        // Return the index where the pivot is now located
        return j;
    }

    // Recursive quicksort function
    static void qs(int[] arr, int low, int high) {
        // Base case: If low >= high, the array (or sub-array) is already sorted
        if (low < high) {
            // Partition the array and get the pivot index
            int pIndex = partition(arr, low, high);

            // Recursively sort the left and right sub-arrays
            qs(arr, low, pIndex - 1);  // Sort the left side (before pivot)
            qs(arr, pIndex + 1, high); // Sort the right side (after pivot)
        }
    }

    // The quickSort function initiates the sorting process
    public static int[] quickSort(int[] arr) {
        // Call the recursive quicksort function with the full array
        qs(arr, 0, arr.length - 1);
        return arr;  // Return the sorted array
    }

    public static void main(String args[]) {
        // Initialize the array of integers to be sorted
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        int n = arr.length;

        // Print the array before sorting
        System.out.println("Before Using QuickSort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Call quickSort method to sort the array
        arr = Quicksort.quickSort(arr);

        // Print the array after sorting
        System.out.println("After QuickSort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
