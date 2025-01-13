
// Search in a sorted 2D matrix

// Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote 
// the number of rows and columns, respectively. The elements of each row are sorted in non-decreasing order.
//  Moreover, the first element of a row is greater than the last element of the previous row (if it exists).
//  You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

// Examples
// Example 1:
// Input Format:
//  N = 3, M = 4, target = 8,
// mat[] = 
// 1 2 3 4
// 5 6 7 8 
// 9 10 11 12
// Result:
//  true
// Explanation:
//  The ‘target’  = 8 exists in the 'mat' at index (1, 3).

// Example 2:
// Input Format:
//  N = 3, M = 3, target = 78,
// mat[] = 
// 1 2 4
// 6 7 8 
// 9 10 34
// Result:
//  false
// Explanation:
//  The ‘target' = 78 does not exist in the 'mat'. Therefore in the output, we see 'false'.



// Brute Force Approach

// Time Complexity: O(N X M), where N = given row number, M = given column number.
// Reason: In order to traverse the matrix, we are using nested loops running for n and m times respectively.

// Space Complexity: O(1) as we are not using any extra space.


// public class SearchInTwoDMatrix {
    
//     // Function to search for a target in a 2D matrix.
//     public static boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length;  // Number of rows in the matrix.
//         int m = matrix[0].length;  // Number of columns in the matrix.

//         // Traverse each element in the matrix:
//         for (int i = 0; i < n; i++) {  // Loop through rows.
//             for (int j = 0; j < m; j++) {  // Loop through columns.
//                 if (matrix[i][j] == target)  // If the current element is the target.
//                     return true;  // Return true if the target is found.
//             }
//         }
//         return false;  // Return false if the target is not found after checking all elements.
//     }

//     public static void main(String[] args) {
//         // Creating a 2D matrix (int[][]).
//         int[][] matrix = {
//             {1, 2, 3, 4},  // Row 1: {1, 2, 3, 4}
//             {5, 6, 7, 8},  // Row 2: {5, 6, 7, 8}
//             {9, 10, 11, 12}  // Row 3: {9, 10, 11, 12}
//         };

//         // Searching for the number 8 in the matrix.
//         boolean result = searchMatrix(matrix, 8);
        
//         // Output the result.
//         System.out.println(result ? "true" : "false");  // Output should be "true" because 8 is present in the matrix.
//     }
// }

/*
** DRY RUN for searchMatrix(matrix, 8):**

Matrix:
{
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
}

1. Initialize n = 3 (number of rows), m = 4 (number of columns).
2. Start traversing the matrix row by row.

    - First Row (i = 0): {1, 2, 3, 4}
        - j = 0: matrix[0][0] = 1 (not equal to target 8).
        - j = 1: matrix[0][1] = 2 (not equal to target 8).
        - j = 2: matrix[0][2] = 3 (not equal to target 8).
        - j = 3: matrix[0][3] = 4 (not equal to target 8).
        
    - Second Row (i = 1): {5, 6, 7, 8}
        - j = 0: matrix[1][0] = 5 (not equal to target 8).
        - j = 1: matrix[1][1] = 6 (not equal to target 8).
        - j = 2: matrix[1][2] = 7 (not equal to target 8).
        - j = 3: matrix[1][3] = 8 (equal to target 8).
        
        Since we found the target (8), return true and exit the function.

3. Output: "true" because 8 is found in the matrix.

*/





// Optimal Approach



public class SearchInTwoDMatrix {
    
    // Function to search for a target in a 2D matrix using binary search.
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;  // Number of rows in the matrix.
        int m = matrix[0].length;  // Number of columns in the matrix.

        // Apply binary search:
        int low = 0, high = n * m - 1;  // low is the start index, high is the end index (flattened 2D array).
        while (low <= high) {
            int mid = (low + high) / 2;  // Find the mid index.
            int row = mid / m;  // Calculate the row from the mid index.
            int col = mid % m;  // Calculate the column from the mid index.
            
            if (matrix[row][col] == target)  // If the current element is the target.
                return true;  // Return true if the target is found.
            else if (matrix[row][col] < target)  // If the current element is less than the target.
                low = mid + 1;  // Move the low pointer to the right.
            else  // If the current element is greater than the target.
                high = mid - 1;  // Move the high pointer to the left.
        }
        return false;  // Return false if the target is not found after binary search.
    }

    public static void main(String[] args) {
        // Creating a 2D matrix (int[][]).
        int[][] matrix = {
            {1, 2, 3, 4},  // Row 1: {1, 2, 3, 4}
            {5, 6, 7, 8},  // Row 2: {5, 6, 7, 8}
            {9, 10, 11, 12}  // Row 3: {9, 10, 11, 12}
        };

        // Searching for the number 8 in the matrix using binary search.
        boolean result = searchMatrix(matrix, 8);
        
        // Output the result.
        System.out.println(result ? "true" : "false");  // Output should be "true" because 8 is present in the matrix.
    }
}

/*
** DRY RUN for searchMatrix(matrix, 8):**

Matrix:
{
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
}

1. Initialize n = 3 (number of rows), m = 4 (number of columns).
2. Apply binary search on the flattened matrix (which is a 1D array of size 12).

    - low = 0, high = 11 (flattened 2D matrix range from 0 to 11).
    
    - Iteration 1:
        - mid = (0 + 11) / 2 = 5.
        - Calculate row = mid / m = 5 / 4 = 1, col = mid % m = 5 % 4 = 1.
        - matrix[1][1] = 6 (not equal to 8).
        - Since 6 < 8, move the low pointer: low = mid + 1 = 6.
    
    - Iteration 2:
        - mid = (6 + 11) / 2 = 8.
        - Calculate row = mid / m = 8 / 4 = 2, col = mid % m = 8 % 4 = 0.
        - matrix[2][0] = 9 (not equal to 8).
        - Since 9 > 8, move the high pointer: high = mid - 1 = 7.
    
    - Iteration 3:
        - mid = (6 + 7) / 2 = 6.
        - Calculate row = mid / m = 6 / 4 = 1, col = mid % m = 6 % 4 = 2.
        - matrix[1][2] = 7 (not equal to 8).
        - Since 7 < 8, move the low pointer: low = mid + 1 = 7.
    
    - Iteration 4:
        - mid = (7 + 7) / 2 = 7.
        - Calculate row = mid / m = 7 / 4 = 1, col = mid % m = 7 % 4 = 3.
        - matrix[1][3] = 8 (equal to target 8).

        Target found! Return true.

3. Output: "true" because 8 is found in the matrix.

*/

