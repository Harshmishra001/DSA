// Search in a row and column-wise sorted matrix

// Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. 
// The elements of each row and each column are sorted in non-decreasing order.
// But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists).
// You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

// Pre-requisite: Search in a 2D sorted matrix

// Examples
// Example 1:
// Input Format:
//  N = 5, M = 5, target = 14
// mat[] = 

// Result:
//  true
// Explanation:
//  Target 14 is present in the cell (3, 2)(0-based indexing) of the matrix. So, the answer is true.

// Example 2:
// Input Format:
//  N = 3, M = 3, target = 12,
// mat[] = 

// Result:
//  false
// Explanation:
//  As target 12 is not present in the matrix, the answer is false.




// Brute force 

// Time Complexity: O(N X M), where N = given row number, M = given column number.
// Reason: In order to traverse the matrix, we are using nested loops running for n and m times respectively.

// Space Complexity: O(1) as we are not using any extra space.

//  public class SearchInTwoDMatrix2 {
    
//     // Function to search for a target in a 2D matrix.
//     public static boolean searchElement(int[][] matrix, int target) {
//         int n = matrix.length;  // Number of rows in the matrix.
//         int m = matrix[0].length;  // Number of columns in the matrix.

//         // Traverse the matrix:
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
//             {1, 4, 7, 11, 15},  // Row 1: {1, 4, 7, 11, 15}
//             {2, 5, 8, 12, 19},  // Row 2: {2, 5, 8, 12, 19}
//             {3, 6, 9, 16, 22},  // Row 3: {3, 6, 9, 16, 22}
//             {10, 13, 14, 17, 24},  // Row 4: {10, 13, 14, 17, 24}
//             {18, 21, 23, 26, 30}   // Row 5: {18, 21, 23, 26, 30}
//         };

//         // Searching for the number 8 in the matrix.
//         boolean result = searchElement(matrix, 8);
        
//         // Output the result.
//         System.out.println(result ? "true" : "false");  // Output should be "true" because 8 is present in the matrix.
//     }
// }

/*
** DRY RUN for searchElement(matrix, 8):**

Matrix:
{
    {1, 4, 7, 11, 15},
    {2, 5, 8, 12, 19},
    {3, 6, 9, 16, 22},
    {10, 13, 14, 17, 24},
    {18, 21, 23, 26, 30}
}

1. Initialize n = 5 (number of rows), m = 5 (number of columns).
2. Start traversing the matrix row by row.

    - First Row (i = 0): {1, 4, 7, 11, 15}
        - j = 0: matrix[0][0] = 1 (not equal to target 8).
        - j = 1: matrix[0][1] = 4 (not equal to target 8).
        - j = 2: matrix[0][2] = 7 (not equal to target 8).
        - j = 3: matrix[0][3] = 11 (not equal to target 8).
        - j = 4: matrix[0][4] = 15 (not equal to target 8).
        
    - Second Row (i = 1): {2, 5, 8, 12, 19}
        - j = 0: matrix[1][0] = 2 (not equal to target 8).
        - j = 1: matrix[1][1] = 5 (not equal to target 8).
        - j = 2: matrix[1][2] = 8 (equal to target 8).
        
        Since we found the target (8), return true and exit the function.

3. Output: "true" because 8 is found in the matrix.

*/





// Optimal

// Time Complexity: O(N+M), where N = given row number, M = given column number.
// Reason: We are starting traversal from (0, M-1), and at most, we can end up being in the cell (M-1, 0). So, the total distance can be at most (N+M). So, the time complexity is O(N+M).

// Space Complexity: O(1) as we are not using any extra space.

public class SearchInTwoDMatrix2 {
    
    // Function to search for a target in a 2D matrix.
    public static boolean searchElement(int[][] matrix, int target) {
        int n = matrix.length;  // Number of rows in the matrix.
        int m = matrix[0].length;  // Number of columns in the matrix.
        int row = 0, col = m - 1;  // Start from the top-right corner.

        // Traverse the matrix from (0, m-1):
        while (row < n && col >= 0) {
            if (matrix[row][col] == target)  // If the current element is the target.
                return true;  // Return true if the target is found.
            else if (matrix[row][col] < target)  // If the current element is less than the target.
                row++;  // Move down to the next row.
            else  // If the current element is greater than the target.
                col--;  // Move left to the previous column.
        }
        return false;  // Return false if the target is not found.
    }

    public static void main(String[] args) {
        // Creating a 2D matrix (int[][]).
        int[][] matrix = {
            {1, 4, 7, 11, 15},  // Row 1: {1, 4, 7, 11, 15}
            {2, 5, 8, 12, 19},  // Row 2: {2, 5, 8, 12, 19}
            {3, 6, 9, 16, 22},  // Row 3: {3, 6, 9, 16, 22}
            {10, 13, 14, 17, 24},  // Row 4: {10, 13, 14, 17, 24}
            {18, 21, 23, 26, 30}   // Row 5: {18, 21, 23, 26, 30}
        };

        // Searching for the number 8 in the matrix.
        boolean result = searchElement(matrix, 8);
        
        // Output the result.
        System.out.println(result ? "true" : "false");  // Output should be "true" because 8 is present in the matrix.
    }
}

/*
** DRY RUN for searchElement(matrix, 8):**

Matrix:
{
    {1, 4, 7, 11, 15},
    {2, 5, 8, 12, 19},
    {3, 6, 9, 16, 22},
    {10, 13, 14, 17, 24},
    {18, 21, 23, 26, 30}
}

1. Initialize n = 5 (number of rows), m = 5 (number of columns).
2. Start from the top-right corner (row = 0, col = m - 1 = 4).

    - First Iteration:
        - matrix[0][4] = 15 (greater than target 8).
        - Move left: col = 3.
    
    - Second Iteration:
        - matrix[0][3] = 11 (greater than target 8).
        - Move left: col = 2.
    
    - Third Iteration:
        - matrix[0][2] = 7 (less than target 8).
        - Move down: row = 1.
    
    - Fourth Iteration:
        - matrix[1][2] = 8 (equal to target 8).

        Target found! Return true.

3. Output: "true" because 8 is found in the matrix.

*/

