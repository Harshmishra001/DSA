/*Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire 
column and row to 0 and then return the matrix.

Examples

Examples 1:
Input:
 matrix=[[1,1,1],[1,0,1],[1,1,1]]
Output:
 [[1,0,1],[0,0,0],[1,0,1]]
Explanation:
 Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
 
Input:
 matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output:
[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
Explanation:
Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 
*/

// *NOTE-> ARRAYLIST M H GIVEN MATRIX ISLIYE GET I GET J  KR RE H AGR INT MATRIX[][] ESE HOTA TOH APNA ESE HI KRTE GET USE NI KRTE



// BRUTE-FORCE APPROACH
/*Time Complexity: O((N*M)*(N + M)).
Space Complexity: O(1)
 */
 
// import java.util.*;

// public class SetMatrixZero {

//    // Main method to process the matrix and set rows and columns to zero
// static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
//     // Iterate through the matrix to find zeroes
//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < m; j++) {
//             if (matrix.get(i).get(j) == 0) { // If a zero is found
//                 markRow(matrix, n, m, i); // Mark the row
//                 markCol(matrix, n, m, j); // Mark the column
//             }
//         }
//     }

//     // Finally, mark all -1 as 0 in the matrix
//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < m; j++) {
//             if (matrix.get(i).get(j) == -1) {
//                 matrix.get(i).set(j, 0); // Changing -1 to 0
//             }
//         }
//     }
//     return matrix; // Return the modified matrix
// }
    
//     // Method to mark all non-zero elements in row 'i' as -1
//     static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
//         for (int j = 0; j < m; j++) {
//             if (matrix.get(i).get(j) != 0) {
//                 matrix.get(i).set(j, -1); // Marking non-zero elements as -1
//             }
//         }
//     }

//     // Method to mark all non-zero elements in column 'j' as -1
//     static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
//         for (int i = 0; i < n; i++) {
//             if (matrix.get(i).get(j) != 0) {
//                 matrix.get(i).set(j, -1); // Marking non-zero elements as -1
//             }
//         }
//     }

    

//     public static void main(String[] args) {
//         // Creating an example matrix
//         ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
//         matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1))); // Row 0
//         matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1))); // Row 1 (contains zero)
//         matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1))); // Row 2

//         int n = matrix.size(); // Number of rows
//         int m = matrix.get(0).size(); // Number of columns

//         ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m); // Process the matrix

//         // Output the final modified matrix
//         System.out.println("The Final matrix is: ");
//         for (ArrayList<Integer> row : ans) {
//             for (Integer ele : row) {
//                 System.out.print(ele + " "); // Print each element in a row
//             }
//             System.out.println(); // New line after each row
//         }
//     } 
// }
//     /* 
//      * Dry Run Explanation:
//      * Initial Matrix:
//      * 1 1 1
//      * 1 0 1
//      * 1 1 1
//      *
//      * After finding the zero at (1, 1):
//      * Marked Row 1: 
//      * 1 -1 1
//      * -1 0 -1
//      * 1 -1 1
//      *
//      * Marked Column 1:
//      * 1 -1 1
//      * -1 0 -1
//      * 1 -1 1
//      *
//      * Final Pass to convert -1 to 0:
//      * 1 0 1
//      * 0 0 0
//      * 1 0 1
//      *
//      * Final Output:
//      * 1 0 1 
//      * 0 0 0 
//      * 1 0 1 
//      */

// // *BETTER APPROACH
// /*
//      * Time Complexity:
//      * - O(n * m) for traversing the matrix to find zeroes and marking rows and columns.
//      * - O(n * m) for the final pass to update the matrix.
//      * Total: O(n * m)
//      *
//      * Space Complexity:
//      * - O(n) for the row array.
//      * - O(m) for the column array.
//      * Total: O(n + m)
//      */

// import java.util.*;

// public class SetMatrixZero {
//     static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

//         int[] row = new int[n]; // Array to mark rows that need to be zeroed
//         int[] col = new int[m]; // Array to mark columns that need to be zeroed

//         // Traverse the matrix:
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (matrix.get(i).get(j) == 0) {
//                     // Mark ith index of row with 1 if zero is found
//                     row[i] = 1;
//                     // Mark jth index of column with 1 if zero is found
//                     col[j] = 1;
//                 }
//             }
//         }

//         // Finally, mark all (i, j) as 0 if row[i] or col[j] is marked with 1
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (row[i] == 1 || col[j] == 1) {
//                     matrix.get(i).set(j, 0); // Set the corresponding position to 0
//                 }
//             }
//         }

//         return matrix; // Return the modified matrix
//     }

//     public static void main(String[] args) {
//         // Creating an example matrix
//         ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
//         matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1))); // Row 0
//         matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1))); // Row 1 (contains zero)
//         matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1))); // Row 2

//         int n = matrix.size(); // Number of rows
//         int m = matrix.get(0).size(); // Number of columns

//         ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m); // Process the matrix

//         // Output the final modified matrix
//         System.out.println("The Final matrix is: ");
//         for (ArrayList<Integer> row : ans) {
//             for (Integer ele : row) {
//                 System.out.print(ele + " "); // Print each element in a row
//             }
//             System.out.println(); // New line after each row
//         }
//     } // End of main method
// }
    /* 
     * Dry Run Explanation:
     * Initial Matrix:
     * 1 1 1
     * 1 0 1
     * 1 1 1
     *
     * Initial State:
     * row = [0, 0, 0] (marks for rows)
     * col = [0, 0, 0] (marks for columns)
     *
     * Step 1: Traverse the Matrix
     * i = 0, j = 0: Matrix[0][0] = 1 (not zero) → row = [0, 0, 0], col = [0, 0, 0]
     * i = 0, j = 1: Matrix[0][1] = 1 (not zero) → row = [0, 0, 0], col = [0, 0, 0]
     * i = 0, j = 2: Matrix[0][2] = 1 (not zero) → row = [0, 0, 0], col = [0, 0, 0]
     *
     * i = 1, j = 0: Matrix[1][0] = 1 (not zero) → row = [0, 0, 0], col = [0, 0, 0]
     * i = 1, j = 1: Matrix[1][1] = 0 (found zero) → row[1] = 1, col[1] = 1
     * row = [0, 1, 0], col = [0, 1, 0]
     *
     * i = 1, j = 2: Matrix[1][2] = 1 (not zero) → row = [0, 1, 0], col = [0, 1, 0]
     *
     * i = 2, j = 0: Matrix[2][0] = 1 (not zero) → row = [0, 1, 0], col = [0, 1, 0]
     * i = 2, j = 1: Matrix[2][1] = 1 (not zero) → row = [0, 1, 0], col = [0, 1, 0]
     * i = 2, j = 2: Matrix[2][2] = 1 (not zero) → row = [0, 1, 0], col = [0, 1, 0]
     *
     * State After Traversal:
     * Row Marker: row = [0, 1, 0] (row 1 has a zero)
     * Column Marker: col = [0, 1, 0] (column 1 has a zero)
     *
     * Step 2: Zero Out Marked Rows and Columns
     * i = 0, j = 0: row[0] = 0, col[0] = 0 → Matrix[0][0] remains 1
     * i = 0, j = 1: row[0] = 0, col[1] = 1 → Matrix[0][1] becomes 0
     * i = 0, j = 2: row[0] = 0, col[2] = 0 → Matrix[0][2] remains 1
     *
     * i = 1, j = 0: row[1] = 1, col[0] = 0 → Matrix[1][0] becomes 0
     * i = 1, j = 1: row[1] = 1, col[1] = 1 → Matrix[1][1] becomes 0
     * i = 1, j = 2: row[1] = 1, col[2] = 0 → Matrix[1][2] becomes 0
     *
     * i = 2, j = 0: row[2] = 0, col[0] = 0 → Matrix[2][0] remains 1
     * i = 2, j = 1: row[2] = 0, col[1] = 1 → Matrix[2][1] becomes 0
     * i = 2, j = 2: row[2] = 0, col[2] = 0 → Matrix[2][2] remains 1
     *
     * Final Output Matrix:
     * 1 0 1 
     * 0 0 0 
     * 1 0 1 
     */
    



    //  *OPTIMAL APPROACH
    import java.util.*;

public class SetMatrixZero {
    // Method to set entire row and column to zero if any element is zero
    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Variable to track if the first column needs to be zeroed
        int col0 = 1;

        // Step 1: Mark rows and columns based on zeros found in the matrix.
        // If we find a zero in matrix[i][j], we mark:
        // - The first element of row 'i' as 0 (i.e., matrix[i][0])
        // - The first element of column 'j' as 0 (i.e., matrix[0][j])
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) { // If a zero is found at (i, j)
                    matrix.get(i).set(0, 0); // Mark the start of the row 'i' as 0
                    if (j != 0) {
                        matrix.get(0).set(j, 0); // Mark the start of column 'j' as 0
                    } else {
                        col0 = 0; // Mark that the first column itself contains a zero
                    }
                }
            }
        }

        // Step 2: Set elements to zero based on the markers in the first row and column.
        // Only traverse the matrix starting from (1,1) to avoid changing the markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) { // Skip if already zero
                    // If either the start of row 'i' or start of column 'j' is marked 0,
                    // we set matrix[i][j] to 0
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        // Step 3: Set the first row and first column to zero if they were marked.
        // If the first element of the matrix is zero, zero out the first row
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }

        // If col0 is 0, zero out the entire first column
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix; // Return the modified matrix
    }

    public static void main(String[] args) {
        // Creating a sample matrix for testing
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1))); // Row 0
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1))); // Row 1 (contains zero)
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1))); // Row 2

        int n = matrix.size(); // Number of rows
        int m = matrix.get(0).size(); // Number of columns

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m); // Process the matrix

        // Output the final modified matrix
        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " "); // Print each element in the row
            }
            System.out.println(); // New line after each row
        }
    }
}

/*
Dry Run (with Initial Matrix: 1 1 1
                               1 0 1
                               1 1 1)

Step 1: Traverse and Mark Rows/Columns
- Initialize col0 = 1

Loop i = 0:
  - j = 0: matrix[0][0] = 1, no change
  - j = 1: matrix[0][1] = 1, no change
  - j = 2: matrix[0][2] = 1, no change

Loop i = 1:
  - j = 0: matrix[1][0] = 1, no change
  - j = 1: matrix[1][1] = 0 (found zero)
    - Set matrix[1][0] = 0 (mark row 1)
    - Set matrix[0][1] = 0 (mark column 1)
  - j = 2: matrix[1][2] = 1, no change

Loop i = 2:
  - j = 0: matrix[2][0] = 1, no change
  - j = 1: matrix[2][1] = 1, no change
  - j = 2: matrix[2][2] = 1, no change

Matrix after Step 1:
  1 0 1
  0 0 1
  1 1 1

Step 2: Update based on markers from (1,1) to (n-1,m-1)
Loop i = 1:
  - j = 1: matrix[1][1] = 0, skip
  - j = 2: matrix[1][2] = 1 (row marker is zero), set matrix[1][2] = 0

Loop i = 2:
  - j = 1: matrix[2][1] = 1 (column marker is zero), set matrix[2][1] = 0
  - j = 2: matrix[2][2] = 1, no change needed

Matrix after Step 2:
  1 0 1
  0 0 0
  1 0 1

Step 3: Update first row and first column if needed
- First row check: matrix[0][0] = 1, no change
- First column check: col0 = 1, no change

Final Matrix:
  1 0 1
  0 0 0
  1 0 1
*/


    
