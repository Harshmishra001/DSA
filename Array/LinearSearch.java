


// Example 1:

// Input:
// N = 5, x = 6
// arr[] = {1,2,3,4,6}
// Output: 4
// Exlpanation: Since, 6 is present in 
// the array at index 4 (0-based indexing),
// output is 4.
 

// Example 2:

// Input:
// N = 5, x = 2
// arr[] = {1,3,4,5,6}
// Output: -1
// Exlpanation: Since, 2 is not present 
// in the array, output is -1.
 

// Your Task:
// You don't need to read input or print anything. Complete the function searchInSorted() which takes the sorted array arr[], its size N and the element K as input parameters and returns 1 if K is present in the array, else it returns -1. 

// Time Complexity:

// Best Case: In the best case, the key might be present at the first index. So the best case complexity is O(1)
// Worst Case: In the worst case, the key might be present at the last index i.e., opposite to the end from which the search has started in the list. So the worst-case complexity is O(N) where N is the size of the list.
// Average Case: O(N)
// Auxiliary Space: O(1) as except for the variable to iterate through the list, no other variable is used. 
import java.io.*;

class LinearSearch {
    public static int search(int arr[], int N, int x)
    {
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;

        // Function call
        int result = search(arr, arr.length, x);
        if (result == -1)
            System.out.print(
                "Element is not present in array");
        else
            System.out.print("Element is present at index "
                             + result);
    }
}
