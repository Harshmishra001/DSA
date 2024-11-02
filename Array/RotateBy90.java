



// BRUTE-FORCE APPROACH
// Time Complexity: O(N*N) to linearly iterate and put it into some other matrix.

// Space Complexity: O(N*N) to copy it into some other matrix.
import java.util.*;

// class RotateBy90 {
    // Function to rotate matrix by 90 degrees clockwise.
//     static int[][] rotate(int[][] matrix) {
//         int n = matrix.length;

        // created space of n^2
//         int rotated[][] = new int[n][n];
        
        // Fill the rotated matrix by placing elements in a 90-degree rotated position
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
                // Place element matrix[i][j] into rotated[j][n - i - 1] to achieve 90-degree rotation
//                 rotated[j][n - i - 1] = matrix[i][j];
//             }
//         }
//         return rotated;
//     }

//     public static void main(String args[]) {
//         int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//         int rotated[][] = rotate(arr);
        
//         System.out.println("Rotated Image");
//         for (int i = 0; i < rotated.length; i++) {
//             for (int j = 0; j < rotated.length; j++) {
//                 System.out.print(rotated[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

/*
Dry Run:

Input matrix (arr):
1 2 3
4 5 6
7 8 9

Step-by-step rotation process:

For i = 0, j = 0:
    rotated[0][2] = arr[0][0] => rotated[0][2] = 1
For i = 0, j = 1:
    rotated[1][2] = arr[0][1] => rotated[1][2] = 2
For i = 0, j = 2:
    rotated[2][2] = arr[0][2] => rotated[2][2] = 3

For i = 1, j = 0:
    rotated[0][1] = arr[1][0] => rotated[0][1] = 4
For i = 1, j = 1:
    rotated[1][1] = arr[1][1] => rotated[1][1] = 5
For i = 1, j = 2:
    rotated[2][1] = arr[1][2] => rotated[2][1] = 6

For i = 2, j = 0:
    rotated[0][0] = arr[2][0] => rotated[0][0] = 7
For i = 2, j = 1:
    rotated[1][0] = arr[2][1] => rotated[1][0] = 8
For i = 2, j = 2:
    rotated[2][0] = arr[2][2] => rotated[2][0] = 9

Rotated matrix:
7 4 1
8 5 2
9 6 3
*/




// OPTIMAL APPROACH - Rotate anti-clockwise
// Time Complexity: O(N*N)


// Space Complexity - O(1).




//User function Template for Java

// import java.util.*;

// class RotateBy90 {
//     // Function to rotate matrix by 90 degrees anticlockwise in-place.
//     static void rotated90(int[][] matrix, int n) {
//         // Step 1: Transpose the matrix
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 // Swap elements across the diagonal
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = temp;
//             }
//         }

//         // Step 2: Reverse each column to rotate the matrix by 90 degrees anticlockwise
//         for (int i = 0; i < n; i++) {
//             int low = 0, high = n - 1;
//             // Swap elements symmetrically across the middle row
//             while (low < high) {
//                 int temp = matrix[low][i];
//                 matrix[low][i] = matrix[high][i];
//                 matrix[high][i] = temp;
//                 low++;
//                 high--;
//             }
//         }
//     }

//     public static void main(String args[]) {
//         int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//         rotated90(arr, arr.length);

//         System.out.println("Rotated Matrix:");
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr.length; j++) {
//                 System.out.print(arr[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

/*
Dry Run:

Input matrix (arr):
1 2 3
4 5 6
7 8 9

Step-by-step rotation process:

1. Transpose the matrix:
   - Swap elements across the diagonal.
   
   For i = 0, j = 1:
       Swap matrix[0][1] and matrix[1][0] -> 2 and 4
       Resulting matrix:
       1 4 3
       2 5 6
       7 8 9

   For i = 0, j = 2:
       Swap matrix[0][2] and matrix[2][0] -> 3 and 7
       Resulting matrix:
       1 4 7
       2 5 6
       3 8 9

   For i = 1, j = 2:
       Swap matrix[1][2] and matrix[2][1] -> 6 and 8
       Resulting matrix:
       1 4 7
       2 5 8
       3 6 9

   Transposed matrix:
   1 4 7
   2 5 8
   3 6 9

2. Reverse each column:
   - Swap elements symmetrically in each column.

   For i = 0 (column 0):
       Swap matrix[0][0] and matrix[2][0] -> 1 and 3
       Resulting matrix:
       3 4 7
       2 5 8
       1 6 9

   For i = 1 (column 1):
       Swap matrix[0][1] and matrix[2][1] -> 4 and 6
       Resulting matrix:
       3 6 7
       2 5 8
       1 4 9

   For i = 2 (column 2):
       Swap matrix[0][2] and matrix[2][2] -> 7 and 9
       Resulting matrix:
       3 6 9
       2 5 8
       1 4 7

Final rotated matrix:
3 6 9
2 5 8
1 4 7
*/


// Rotate clockwise - OPTIMAL APPROACH

import java.util.*;

class RotateBy90 {
    // Function to rotate matrix by 90 degrees clockwise in-place.
    static void rotateClockwise(int[][] matrix, int n) {
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to complete the clockwise rotation
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low <= high) {
                // Swap elements symmetrically in the row
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateClockwise(arr, arr.length);

        System.out.println("Rotated Matrix:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Dry Run:

Input matrix (arr):
1 2 3
4 5 6
7 8 9

Step-by-step rotation process:

1. Transpose the matrix:
   - Swap elements across the diagonal.

   For i = 0, j = 1:
       Swap matrix[0][1] and matrix[1][0] -> 2 and 4
       Resulting matrix:
       1 4 3
       2 5 6
       7 8 9

   For i = 0, j = 2:
       Swap matrix[0][2] and matrix[2][0] -> 3 and 7
       Resulting matrix:
       1 4 7
       2 5 6
       3 8 9

   For i = 1, j = 2:
       Swap matrix[1][2] and matrix[2][1] -> 6 and 8
       Resulting matrix:
       1 4 7
       2 5 8
       3 6 9

   Transposed matrix:
   1 4 7
   2 5 8
   3 6 9

2. Reverse each row:
   - Swap elements symmetrically in each row.

   For i = 0 (row 0):
       Swap matrix[0][0] and matrix[0][2] -> 1 and 7
       Resulting matrix:
       7 4 1
       2 5 8
       3 6 9

   For i = 1 (row 1):
       Swap matrix[1][0] and matrix[1][2] -> 2 and 8
       Resulting matrix:
       7 4 1
       8 5 2
       3 6 9

   For i = 2 (row 2):
       Swap matrix[2][0] and matrix[2][2] -> 3 and 9
       Resulting matrix:
       7 4 1
       8 5 2
       9 6 3

Final rotated matrix:
7 4 1
8 5 2
9 6 3
*/
