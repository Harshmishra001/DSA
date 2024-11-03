/*
Given an unsorted array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. 
Do the mentioned change in the array in place.

Note: Consider the array as circular.

Examples:

Input: arr[] = [1, 2, 3, 4, 5], d = 2
Output: [3, 4, 5, 1, 2]
Explanation: When rotated by 2 elements, it becomes 3 4 5 1 2.

Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
Explanation: When rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.

Input: arr[] = [7, 3, 9, 1], d = 9
Output: [3, 9, 1, 7]
Explanation: When rotated 9 times, we'll get 3 9 1 7 as the resultant array.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
*/

// User function Template for Java

class LeftrotateAnArrayByDtimes
{
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n)
    {
        // Adjust d if it's larger than the size of the array
        d = d % n; 
        if (d == 0)
            return; // No rotation needed if d is 0 or a multiple of n
        
        // Step 1: Reverse the first 'd' elements
        reverse(arr, 0, d - 1);
        
        // Step 2: Reverse the remaining 'n-d' elements
        reverse(arr, d, n - 1);
        
        // Step 3: Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    // Helper function to reverse the elements between indices low and high
    static void reverse(int arr[], int low, int high)
    {
        while (low <= high)
        {
            // Swap the elements at positions low and high
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    // Main method for testing the solution with examples
    public static void main(String[] args) {

        int arr1[] = {1, 2, 3, 4, 5};
        int d1 = 2;
        rotateArr(arr1, d1, arr1.length); // Expected output: [3, 4, 5, 1, 2]
       
        System.out.print("Rotated array: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        int arr2[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int d2 = 3;
        rotateArr(arr2, d2, arr2.length);  // Expected output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
       
        System.out.print("Rotated array: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        int arr3[] = {7, 3, 9, 1};
        int d3 = 9;
        rotateArr(arr3, d3, arr3.length); // Expected output: [3, 9, 1, 7]
       
        System.out.print("Rotated array: ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
    }
}

/*
Dry run of the first example:
Input: arr[] = [1, 2, 3, 4, 5], d = 2

Step 1: Adjust d, d = d % n -> d = 2 % 5 = 2

Step 2: Reverse the first 'd' elements (0 to d-1 = 0 to 1)
Initial array: [1, 2, 3, 4, 5]
After reverse: [2, 1, 3, 4, 5]

Step 3: Reverse the remaining elements (d to n-1 = 2 to 4)
Initial array: [2, 1, 3, 4, 5]
After reverse: [2, 1, 5, 4, 3]

Step 4: Reverse the entire array (0 to n-1 = 0 to 4)
Initial array: [2, 1, 5, 4, 3]
After reverse: [3, 4, 5, 1, 2]

Final Output: [3, 4, 5, 1, 2]

Dry run of the third example:
Input: arr[] = [7, 3, 9, 1], d = 9

Step 1: Adjust d, d = d % n -> d = 9 % 4 = 1

Step 2: Reverse the first 'd' elements (0 to d-1 = 0 to 0)
Initial array: [7, 3, 9, 1]
After reverse (no change, as it's a single element): [7, 3, 9, 1]

Step 3: Reverse the remaining elements (d to n-1 = 1 to 3)
Initial array: [7, 3, 9, 1]
After reverse: [7, 1, 9, 3]

Step 4: Reverse the entire array (0 to n-1 = 0 to 3)
Initial array: [7, 1, 9, 3]
After reverse: [3, 9, 1, 7]

Final Output: [3, 9, 1, 7]
*/
