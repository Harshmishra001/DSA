package Sorting;
import java.util.*;

public class Insertionsort {
    static void insertion_sort(int[] arr, int n) {
        // Outer loop to iterate over the array starting from the second element
        for (int i = 0; i < n; i++) {
            // 'j' is used to compare the current element with the previous elements
            int j = i;
            
            // Inner loop: Keep moving the current element (arr[j]) to its correct position
            // by comparing it with the element to its left (arr[j-1])
            while (j > 0 && arr[j - 1] > arr[j]) {
                // Swap arr[j-1] and arr[j] to place the current element in the correct position
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                
                // Move to the previous element in the array for further comparison
                j--;
            }
        }

        // Print the sorted array after the sorting process is complete
        System.out.println("After insertion sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); // Printing each element
        }
        System.out.println(); // For newline after printing the array
    }

    public static void main(String args[]) {
        // Initial array to be sorted
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;

        // Print the array before sorting
        System.out.println("Before Using insertion Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); // Printing each element
        }
        System.out.println(); // For newline after printing the array

        // Call the insertion_sort method to sort the array
        insertion_sort(arr, n);
    }
}


// ### Initial Array:
// ```
// [13, 46, 24, 52, 20, 9]
// ```

// ### Step-by-step Execution:

// 1. **Outer Loop - i = 0:**
//    - No swap.  ,,,  coz j-1 hi nhi h ,tln index 0 se phle koi index nhi h
//    - Array after iteration 1:  
//    ```
//    [13, 46, 24, 52, 20, 9]
//    ```

// 2. **Outer Loop - i = 1:**
//    - No swap.
//    - Array after iteration 2:  
//    ```
//    [13, 46, 24, 52, 20, 9]
//    ```

// 3. **Outer Loop - i = 2:**
//    - Swap `arr[1]` and `arr[2]` → `[13, 24, 46, 52, 20, 9]`
//    - No further swaps.
//    - Array after iteration 3:  
//    ```
//    [13, 24, 46, 52, 20, 9]
//    ```

// 4. **Outer Loop - i = 3:**
//    - No swap.
//    - Array after iteration 4:  
//    ```
//    [13, 24, 46, 52, 20, 9]
//    ```

// 5. **Outer Loop - i = 4:**
//    - Swap `arr[3]` and `arr[4]` → `[13, 24, 46, 20, 52, 9]`
//    - Swap `arr[2]` and `arr[3]` → `[13, 24, 20, 46, 52, 9]`
//    - Swap `arr[1]` and `arr[2]` → `[13, 20, 24, 46, 52, 9]`
//    - No further swaps.
//    - Array after iteration 5:  
//    ```
//    [13, 20, 24, 46, 52, 9]
//    ```

// 6. **Outer Loop - i = 5:**
//    - Swap `arr[4]` and `arr[5]` → `[13, 20, 24, 46, 9, 52]`
//    - Swap `arr[3]` and `arr[4]` → `[13, 20, 24, 9, 46, 52]`
//    - Swap `arr[2]` and `arr[3]` → `[13, 20, 9, 24, 46, 52]`
//    - Swap `arr[1]` and `arr[2]` → `[13, 9, 20, 24, 46, 52]`
//    - Swap `arr[0]` and `arr[1]` → `[9, 13, 20, 24, 46, 52]`
//    - Array after iteration 6:  
//    ```
//    [9, 13, 20, 24, 46, 52]
//    ```

// ### Final Sorted Array:
// ```
// [9, 13, 20, 24, 46, 52]
// ```



// Output:

// Before insertion sort:
// 13 46 24 52 20 9
// After insertion sort:
// 9 13 20 24 46 52

// Time complexity: O(N2), (where N = size of the array), for the worst, and average cases.
// Reason: If we carefully observe, we can notice that the outer loop, say i, is running from 0 to n-1 i.e. n times, and for each i, the inner loop j runs from i to 1 i.e. i times. For, i = 1, the inner loop runs 1 time, for i = 2, the inner loop runs 2 times, and so on. So, the total steps will be approximately the following: 1 + 2 + 3 +......+ (n-2) + (n-1). The summation is approximately the sum of the first n natural numbers i.e. (n*(n+1))/2. The precise time complexity will be O(n2/2 + n/2). Previously, we have learned that we can ignore the lower values as well as the constant coefficients. So, the time complexity is O(n2). Here the value of n is N i.e. the size of the array.

// Space Complexity: O(1)

// Best Case Time Complexity: 

// The best case occurs if the given array is already sorted. And if the given array is already sorted, the outer loop will only run and the inner loop will run for 0 times. So, our overall time complexity in the best case will boil down to O(N), where N = size of the array.