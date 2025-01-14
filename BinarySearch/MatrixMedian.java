
// Brute Force

// Time Complexity: O(MXN) + O(MXN(log(MXN))), where M = number of row in the given matrix, N = number of columns in the given matrix

// Reason: At first, we are traversing the matrix to copy the elements. This takes O(MXN) time complexity. Then we are sorting the linear array of size (MXN), that takes O(MXN(log(MXN))) time complexity

// Space Complexity: O(MXN) as we are using a temporary list to store the elements of the matrix.  

// import java.util.*;

// public class MatrixMedian {
//     public static int median(int matrix[][], int m, int n) {
//         List<Integer> lst = new ArrayList<>();

//         // Traverse the matrix and
//         // copy the elements to the list:
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 lst.add(matrix[i][j]);
//             }
//         }

//         // Sort the list:
//         Collections.sort(lst);
//         return lst.get((m * n) / 2);
//     }

//     public static void main(String[] args) {
//         int matrix[][] = {
//             {1, 2, 3, 4, 5},
//             {8, 9, 11, 12, 13},
//             {21, 23, 25, 27, 29}
//         };
//         int m = matrix.length, n = matrix[0].length;
//         int ans = median(matrix, m, n);
//         System.out.println("The median element is: " + ans);
//     }
// }
    
                                    
          


// Optimal

// Time Complexity: O(log(109)) X O(M(logN)), where M = number of rows in the given matrix, N = number of columns in the given matrix

// Reason: Our search space lies between [0, 109] as the min(matrix) can be 0 and the max(matrix) can be 109. We are applying binary search in this search space and it takes O(log(109)) time complexity. Then we call countSmallEqual() function for every ‘mid’ and this function takes O(M(logN)) time complexity.

// Space Complexity : O(1) as we are not using any extra space

import java.util.*;

class  MatrixMedian{
    // Function to find the upper bound of x in a sorted array
    static int upperBound(int[] arr, int x, int n) {

        int low = 0, high = n - 1;

        int ans = n;  // Default answer is n (if x is larger than all elements)

        while (low <= high) {
            int mid = (low + high) / 2;
            // If arr[mid] > x, it might be a possible upper bound
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;  // Search in the left half
            } else {
                low = mid + 1;  // Search in the right half
            }
        }
        return ans;
    }

    // Function to count how many elements in the matrix are less than or equal to x
    static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        // For each row, use upperBound to find how many elements are <= x
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }

    // Function to find the median of the matrix
    static int median(int[][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // Find the minimum and maximum values in the matrix
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        // We want to find the median position (half of the total elements)
        int req = (n * m) / 2;

        // Perform binary search between low and high to find the median
        while (low <= high) {
            int mid = (low + high) / 2;
            // Count how many numbers in the matrix are <= mid
            int smallEqual = countSmallEqual(matrix, m, n, mid);
            
            // If there are fewer than or exactly required elements <= mid, shift the low bound up
            if (smallEqual <= req)
                low = mid + 1;
            else high = mid - 1;  // Otherwise, shift the high bound down
        }
        return low;  // The result is the value at the low bound
    }

    // Main method to test the median function
    public static void main(String[] args) {
        // Example matrix with sorted rows
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {8, 9, 11, 12, 13},
            {21, 23, 25, 27, 29}
        };

        // Get the number of rows and columns
        int m = matrix.length;
        int n = matrix[0].length;

        // Call the median function to get the median element
        int ans = median(matrix, m, n);
        
        // Output the result
        System.out.println("The median element is: " + ans);
    }
    
    /* ------------------ DRY RUN ------------------ */

    // Input matrix:
    // [
    //     {1, 2, 3, 4, 5},
    //     {8, 9, 11, 12, 13},
    //     {21, 23, 25, 27, 29}
    // ]
    
    // Variables:
    // m = 3 (number of rows)
    // n = 5 (number of columns)
    // low = Integer.MAX_VALUE
    // high = Integer.MIN_VALUE
    
    // Step 1: Find the minimum and maximum values in the matrix
    // After iterating through the matrix:
    // low = 1
    // high = 29
    
    // Step 2: Set required count (req = (m * n) / 2 = 7)
    // req = 7
    
    // Step 3: Perform binary search on the range [low, high] which is [1, 29]
    
    // Iteration 1:
    // low = 1, high = 29
    // mid = (1 + 29) / 2 = 15
    // Count of elements <= 15:
    // For row {1, 2, 3, 4, 5} => 5 elements <= 15
    // For row {8, 9, 11, 12, 13} => 5 elements <= 15
    // For row {21, 23, 25, 27, 29} => 0 elements <= 15
    // Total count = 5 + 5 + 0 = 10
    // Since count (10) > req (7), shift high to mid - 1 = 14
    
    // Iteration 2:
    // low = 1, high = 14
    // mid = (1 + 14) / 2 = 7
    // Count of elements <= 7:
    // For row {1, 2, 3, 4, 5} => 5 elements <= 7
    // For row {8, 9, 11, 12, 13} => 0 elements <= 7
    // For row {21, 23, 25, 27, 29} => 0 elements <= 7
    // Total count = 5 + 0 + 0 = 5
    // Since count (5) <= req (7), shift low to mid + 1 = 8
    
    // Iteration 3:
    // low = 8, high = 14
    // mid = (8 + 14) / 2 = 11
    // Count of elements <= 11:
    // For row {1, 2, 3, 4, 5} => 5 elements <= 11
    // For row {8, 9, 11, 12, 13} => 3 elements <= 11
    // For row {21, 23, 25, 27, 29} => 0 elements <= 11
    // Total count = 5 + 3 + 0 = 8
    // Since count (8) > req (7), shift high to mid - 1 = 10
    
    // Iteration 4:
    // low = 8, high = 10
    // mid = (8 + 10) / 2 = 9
    // Count of elements <= 9:
    // For row {1, 2, 3, 4, 5} => 5 elements <= 9
    // For row {8, 9, 11, 12, 13} => 2 elements <= 9
    // For row {21, 23, 25, 27, 29} => 0 elements <= 9
    // Total count = 5 + 2 + 0 = 7
    // Since count (7) <= req (7), shift low to mid + 1 = 10
    
    // Iteration 5:
    // low = 10, high = 10
    // mid = (10 + 10) / 2 = 10
    // Count of elements <= 10:
    // For row {1, 2, 3, 4, 5} => 5 elements <= 10
    // For row {8, 9, 11, 12, 13} => 2 elements <= 10
    // For row {21, 23, 25, 27, 29} => 0 elements <= 10
    // Total count = 5 + 2 + 0 = 7
    // Since count (7) <= req (7), shift low to mid + 1 = 11
    
    // Step 4: Loop ends, and low = 11, which is the median.
    // Output: "The median element is: 11"
}
