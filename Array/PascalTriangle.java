// Problem Statement: This problem has 3 variations. They are stated below:

// Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

// Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

// Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

// In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:


// Examples
// Example 1:
// Input Format:
//  N = 5, r = 5, c = 3
// Result:
//  6 (for variation 1)
// 1 4 6 4 1 (for variation 2)

// 1 
// 1 1 
// 1 2 1 
// 1 3 3 1 
// 1 4 6 4 1    (for variation 3)

// Explanation:
//  There are 5 rows in the output matrix. Each row is formed using the logic of Pascal’s triangle.

// Example 2:
// Input Format:
//  N = 1, r = 1, c = 1
// Result:
//  1 (for variation 1)
//     1 (for variation 2)
//     1  (for variation 3)
// Explanation:
//  The output matrix has only 1 row.



//*-----------------------------------------------------------------------------------------------------------------------------------------
// VARIATION 1 SOLUTION

// Time Complexity: O(c), where c = given column number.
// Reason: We are running a loop for r times, where r is c-1.

// Space Complexity: O(1) as we are not using any extra space.

// import java.util.*;
// public class PascalTriangle {

//     public static long nCr(int n, int r) {
//         long res = 1;
//         // calculating nCr:
//         for (int i = 0; i < r; i++) {
//             res = res * (n - i);
//             res = res / (i + 1);
//         }
//         return res;
//     }

//     public static int pascalTriangle(int r, int c) {
//         int element = (int) nCr(r - 1, c - 1);
//         return element;
//     }

//     public static void main(String[] args) {
//         int r = 5; // row number
//         int c = 3; // col number
//         int element = pascalTriangle(r, c);
//         System.out.println("The element at position (r,c) is: " + element);
//     }   
// }
//*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// VARIATION 2 SOLUTION

// BRUTE-FORCE APPROACH
// Time Complexity: O(n*r), where n is the given row number, and r is the column index which can vary from 0 to n-1.
// Reason: We are calculating the element for each column. Now, there are total n columns, and for each column, the calculation of the element takes O(r) time where r is the column index.

// Space Complexity: O(1) as we are not using any extra space.

// import java.util.*;

// public class PascalTriangle {

//     public static long nCr(int n, int r) {
//         long res = 1;
//         // calculating nCr:
//         for (int i = 0; i < r; i++) {
//             res = res * (n - i);
//             res = res / (i + 1);
//         }
//         return res;
//     }

//     public static void pascalTriangle(int n) {
//         // printing the entire row n:
//         for (int r = 1; r <= n; r++) {
//             System.out.print(nCr(n - 1, r - 1) + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         int n = 5;  //GIVEN ROW NO.
//         pascalTriangle(n);
//     }
// }

// OPTIMAL APPROACH
// ime Complexity: O(N) where N = given row number. Here we are using only a single loop.

// Space Complexity: O(1) as we not using any extra space.

// import java.util.*;

// public class PascalTriangle {

//     static void pascalTriangle(int n) {
//         long ans = 1;
//         System.out.print(ans + " "); // printing 1st element  which is always 1 look in pascal triangle figure

//         // Printing the rest of the part:
//         for (int i = 1; i < n; i++) {
//             ans = ans * (n - i);
//             ans = ans / i;
//             System.out.print(ans + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         int n = 5;
//         pascalTriangle(n);
//     }
// }
//*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // VARIATION 3 SOLUTION

// BRUTE-FORCE APPROACH

// Time Complexity: O(n*n*r) ~ O(n3), where n = number of rows, and r = column index.
// Reason: The row loop will run for approximately n times. And generating a row using the naive approach of variation 2 takes O(n*r) time complexity.

// Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can be still considered as O(1).

// import java.util.*;

// public class PascalTriangle {

//     // Function to calculate nCr (combinations)
//     public static int nCr(int n, int r) {
//         long res = 1;
//         // yeh loop nCr calculate kar raha hai
//         for (int i = 0; i < r; i++) {
//             res = res * (n - i); // pehle multiply karenge
//             res = res / (i + 1);  // fir divide
//         }
//         return (int) res;
//     }

//     // Function to generate Pascal's Triangle up to nth row
//     public static List<List<Integer>> pascalTriangle(int n) {
//         List<List<Integer>> ans = new ArrayList<>();
//         // poora Pascal's triangle ko store karenge
//         for (int row = 1; row <= n; row++) {
//             List<Integer> tempLst = new ArrayList<>(); // temporary list banate hain har row ke liye
//             for (int col = 1; col <= row; col++) {
//                 // nCr calculate karke row ke elements add karenge
//                 tempLst.add(nCr(row - 1, col - 1));
//             }
//             ans.add(tempLst); // tempLst ko ans mein add karenge
//         }
//         return ans;
//     }

//     public static void main(String[] args) {
//         int n = 5; // Pascal's Triangle ke kitne rows chahiye
//         List<List<Integer>> ans = pascalTriangle(n); // triangle generate karenge
//         for (List<Integer> it : ans) { // triangle print karna
//             for (int ele : it) {
//                 System.out.print(ele + " ");
//             }
//             System.out.println();
//         }
//     }
//}


// OPTIMAL APPROACH

// Time Complexity: O(n2), where n = number of rows(given).
// Reason: We are generating a row for each single row. The number of rows is n. And generating an entire row takes O(n) time complexity.

// Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can still be considered as O(1).

import java.util.*;

public class PascalTriangle {

    public static List<Integer> generateRow(int row) {

        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element

        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalTriangle(int n) {

        List<List<Integer>> ans = new ArrayList<>();

        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}





//*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
