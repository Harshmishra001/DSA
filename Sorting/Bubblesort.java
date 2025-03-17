package Sorting;

import java.util.*;

public class Bubblesort {
    static void bubble_sort(int[] arr, int n) {

        
        for (int i = 0; i < n-1; i++) { // Outer loop goes from 0 to n-1

            int didSwap = 0;

            for (int j = 0; j < n-i-1; j++) { // Inner loop goes from 0 to n-i-1

                if (arr[j] > arr[j+1]) { // Compare adjacent elements
                    // Swap if elements are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    didSwap = 1;
                }
            }
            // If no elements were swapped in the inner loop, break early
            if (didSwap == 0) {
                break;
            }
        }

        System.out.println("After bubble sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before Using Bubble Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        bubble_sort(arr, n);
    }
}

// Output: 

// Before Using Bubble Sort:

// 13 46 24 52 20 9

// After Using bubble sort:

// 9 13 20 24 46 52

// * Time Complexity: O(N2) for the worst and average cases and O(N) for the best case. Here, N = size of the array.

// * Space Complexity: O(1)