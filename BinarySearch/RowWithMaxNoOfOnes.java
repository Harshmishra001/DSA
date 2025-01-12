





// Brute Force Approach

// Time Complexity: O(n X m), where n = given row number, m = given column number.
// Reason: We are using nested loops running for n and m times respectively.

// Space Complexity: O(1) as we are not using any extra space.

// import java.util.*;

// public class RowWithMaxNoOfOnes {
//     // Function to find the row with the maximum number of 1s
//     public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

//         int cnt_max = 0; // To store the maximum count of 1's in a row
//         int index = -1;  // To store the index of the row with the maximum number of 1's

//         // Traverse each row of the matrix
//         for (int i = 0; i < n; i++) {
//             int cnt_ones = 0; // To count the number of 1's in the current row

//             // Traverse each column of the current row
//             for (int j = 0; j < m; j++) {
//                 // Add the value at matrix[i][j] to cnt_ones (it will be either 0 or 1)
//                 cnt_ones += matrix.get(i).get(j);
//             }

//             // If the current row has more 1's than the previous row, update cnt_max and index
//             if (cnt_ones > cnt_max) {
//                 cnt_max = cnt_ones; // Update the maximum count of 1's
//                 index = i;           // Update the row index with the maximum 1's
//             }
//         }

//         // Return the index of the row with the maximum number of 1's
//         return index;
//     }

//     public static void main(String[] args) {
//         // Create a 2D matrix using ArrayList of ArrayLists
//         ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
//         matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1))); // First row: [1, 1, 1]
//         matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1))); // Second row: [0, 0, 1]
//         matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0))); // Third row: [0, 0, 0]

//         // Define the dimensions of the matrix (n rows and m columns)
//         int n = 3, m = 3;

//         // Call the function and print the result
//         System.out.println("The row with the maximum number of 1's is: " + rowWithMax1s(matrix, n, m)); // Output the row index with maximum 1's
//     }
// }


// ### Dry Run of the Code:

// **Input:**
// ```java
// matrix = [
//   [1, 1, 1],
//   [0, 0, 1],
//   [0, 0, 0]
// ]
// ```

// **Steps:**

// 1. **Initialization:**
//    - `cnt_max = 0`: This variable keeps track of the highest number of 1's encountered in any row so far.
//    - `index = -1`: This stores the index of the row that has the most 1's.
//    - `n = 3` (number of rows), `m = 3` (number of columns).

// 2. **First Iteration (i = 0):**
//    - `cnt_ones = 0` (initial count of 1's for row 0).
//    - Traverse row 0:
//      - `matrix[0][0] = 1`, so `cnt_ones` becomes 1.
//      - `matrix[0][1] = 1`, so `cnt_ones` becomes 2.
//      - `matrix[0][2] = 1`, so `cnt_ones` becomes 3.
//    - After processing row 0, `cnt_ones = 3`.
//    - Since `cnt_ones > cnt_max` (3 > 0), update `cnt_max = 3` and `index = 0`.
   
// 3. **Second Iteration (i = 1):**
//    - `cnt_ones = 0` (initial count of 1's for row 1).
//    - Traverse row 1:
//      - `matrix[1][0] = 0`, so `cnt_ones` remains 0.
//      - `matrix[1][1] = 0`, so `cnt_ones` remains 0.
//      - `matrix[1][2] = 1`, so `cnt_ones` becomes 1.
//    - After processing row 1, `cnt_ones = 1`.
//    - Since `cnt_ones < cnt_max` (1 < 3), we do not update `cnt_max` or `index`.

// 4. **Third Iteration (i = 2):**
//    - `cnt_ones = 0` (initial count of 1's for row 2).
//    - Traverse row 2:
//      - `matrix[2][0] = 0`, so `cnt_ones` remains 0.
//      - `matrix[2][1] = 0`, so `cnt_ones` remains 0.
//      - `matrix[2][2] = 0`, so `cnt_ones` remains 0.
//    - After processing row 2, `cnt_ones = 0`.
//    - Since `cnt_ones < cnt_max` (0 < 3), we do not update `cnt_max` or `index`.

// 5. **End of Loop:**
//    - After iterating through all the rows, the row with the maximum number of 1's is row 0, as it has 3 ones.
//    - The function returns `index = 0`.

// **Output:**
// ```
// The row with the maximum number of 1's is: 0
// ```

// ### Explanation of Key Points:
// - The function counts the number of `1`s in each row and compares it to the highest count found so far (`cnt_max`).
// - If a row has more `1`s than the previous row, the function updates the maximum count and the row index (`index`).
// - At the end of the loop, the function returns the index of the row that contains the most `1`s.







// Optimal Approach

// Time Complexity: O(n X logm), where n = given row number, m = given column number.
// Reason: We are using a loop running for n times to traverse the rows. Then we are applying binary search on each row with m columns.

// Space Complexity: O(1) as we are not using any extra space.


import java.util.*;

public class RowWithMaxNoOfOnes {
    // Function to perform binary search and find the lower bound
    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n; // If no element >= x is found, we return 'n' (end of the array)

        // Perform binary search to find the index of the first occurrence of x or any number >= x
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // If arr[mid] is greater than or equal to x, we may have a possible answer
            if (arr.get(mid) >= x) {
                ans = mid; // Update the answer with the current index
                high = mid - 1; // Look for a smaller index on the left side
            } else {
                low = mid + 1; // Otherwise, look for a potential match on the right side
            }
        }
        
        // Return the index of the first element that is >= x
        return ans;
    }

    // Function to find the row with the maximum number of 1's
    public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cnt_max = 0; // Maximum count of 1's found so far
        int index = -1;  // Index of the row with the maximum 1's

        // Traverse the rows to calculate the number of 1's
        for (int i = 0; i < n; i++) {
            // Find the number of 1's in the current row using lowerBound
            int cnt_ones = m - lowerBound(matrix.get(i), m, 1);

            // If this row has more 1's than the previous max, update the max and row index
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }

        // Return the index of the row with the maximum number of 1's
        return index;
    }

    public static void main(String[] args) {
        // Create a matrix with 1's and 0's
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1))); // Row 0: [1, 1, 1]
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1))); // Row 1: [0, 0, 1]
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0))); // Row 2: [0, 0, 0]

        // Matrix dimensions: 3 rows, 3 columns
        int n = 3, m = 3;

        // Call the function and print the result
        System.out.println("The row with the maximum number of 1's is: " + rowWithMax1s(matrix, n, m)); // Output the row index with maximum 1's
    }
}


// ### Dry Run of the Code:

// **Input:**
// ```java
// matrix = [
//   [1, 1, 1],
//   [0, 0, 1],
//   [0, 0, 0]
// ]
// ```

// **Steps:**

// 1. **Initialization:**
//    - `cnt_max = 0`: Variable to track the maximum number of 1's in any row.
//    - `index = -1`: Variable to store the index of the row with the most 1's.
//    - `n = 3`, `m = 3`: Dimensions of the matrix (3 rows, 3 columns).

// 2. **First Iteration (i = 0):**
//    - Call `lowerBound(matrix.get(0), m, 1)` to find the first occurrence of `1` in row 0.
//      - Row 0 is `[1, 1, 1]`.
//      - The first `1` occurs at index `0` (using binary search).
//      - So, `cnt_ones = m - lowerBound = 3 - 0 = 3`.
//    - Since `cnt_ones = 3 > cnt_max = 0`, update `cnt_max = 3` and `index = 0`.

// 3. **Second Iteration (i = 1):**
//    - Call `lowerBound(matrix.get(1), m, 1)` to find the first occurrence of `1` in row 1.
//      - Row 1 is `[0, 0, 1]`.
//      - The first `1` occurs at index `2` (using binary search).
//      - So, `cnt_ones = m - lowerBound = 3 - 2 = 1`.
//    - Since `cnt_ones = 1 < cnt_max = 3`, do not update `cnt_max` or `index`.

// 4. **Third Iteration (i = 2):**
//    - Call `lowerBound(matrix.get(2), m, 1)` to find the first occurrence of `1` in row 2.
//      - Row 2 is `[0, 0, 0]`.
//      - There is no `1` in the row, so the function returns `3` (end of the row).
//      - So, `cnt_ones = m - lowerBound = 3 - 3 = 0`.
//    - Since `cnt_ones = 0 < cnt_max = 3`, do not update `cnt_max` or `index`.

// 5. **End of Loop:**
//    - After iterating through all rows, the row with the most `1`s is row 0 (3 ones).
//    - The function returns `index = 0`.

// **Output:**
// ```
// The row with the maximum number of 1's is: 0
// ```
