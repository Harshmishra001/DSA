// public class findRepeatingAndMissingNo {
    
// }

// Problem Statement: You are given a read-only array of N integers with values also in the range [1, N]
//  both inclusive. Each integer appears exactly once except A which appears twice and B which is
//  missing. The task is to find the repeating and missing numbers A and B where A repeats twice
//  and B is missing.

// Examples
// Example 1:
// Input Format
// :  array[] = {3,1,2,5,3}
// Result
// : {3,4)
// Explanation
// : A = 3 , B = 4 
// Since 3 is appearing twice and 4 is missing

// Example 2:
// Input Format
// : array[] = {3,1,2,5,4,6,7,5}
// Result
// : {5,8)
// Explanation
// : A = 5 , B = 8 
// Since 5 is appearing twice and 8 is missing




// Naive Approach (Brute force):

// Time Complexity: O(N2), where N = size of the given array.
// Reason: Here, we are using nested loops to count occurrences of every element between 1 to N.

// Space Complexity: O(1) as we are not using any extra space.



// import java.util.*;

// public class findRepeatingAndMissingNo {

//     // Method to find the repeating and missing numbers in the array
//     public static int[] findMissingRepeatingNumbers(int[] a) {

//         int n = a.length; // size of the array

//         int repeating = -1, missing = -1;

//         // Iterate over all possible numbers from 1 to n
//         for (int i = 1; i <= n; i++) {
//             int cnt = 0; // Count occurrences of number i in the array
//             for (int j = 0; j < n; j++) {
//                 if (a[j] == i) cnt++;
//             }

//             // If a number appears twice, it's the repeating number
//             if (cnt == 2) repeating = i;
//             // If a number does not appear, it's the missing number
//             else if (cnt == 0) missing = i;

//             // Exit early if both numbers are found
//             if (repeating != -1 && missing != -1)
//                 break;
//         }
//         // Return the results as an array
//         return new int[]{repeating, missing};
//     }

//     public static void main(String[] args) {
//         // Input array
//         int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        
//         // Find the repeating and missing numbers
//         int[] ans = findMissingRepeatingNumbers(a);
        
//         // Print the results
//         System.out.println("The repeating and missing numbers are: {"
//                            + ans[0] + ", " + ans[1] + "}");
//     }
// }

/*
Dry Run:

Input array: [3, 1, 2, 5, 4, 6, 7, 5]
n = 8 (size of the array)

We need to find:
1. Repeating number (occurs twice).
2. Missing number (does not appear).

Step-by-step execution:

1. Initialize:
   repeating = -1, missing = -1.

2. Loop through numbers from 1 to n:
   - Check how many times each number `i` appears in the array.
   - Update `repeating` or `missing` accordingly.

Details:

i = 1:
- Count occurrences of 1 in the array: 1 time.
- No action (1 is neither repeating nor missing).

i = 2:
- Count occurrences of 2 in the array: 1 time.
- No action (2 is neither repeating nor missing).

i = 3:
- Count occurrences of 3 in the array: 1 time.
- No action (3 is neither repeating nor missing).

i = 4:
- Count occurrences of 4 in the array: 1 time.
- No action (4 is neither repeating nor missing).

i = 5:
- Count occurrences of 5 in the array: 2 times.
- `repeating` is set to 5.

i = 6:
- Count occurrences of 6 in the array: 1 time.
- No action (6 is neither repeating nor missing).

i = 7:
- Count occurrences of 7 in the array: 1 time.
- No action (7 is neither repeating nor missing).

i = 8:
- Count occurrences of 8 in the array: 0 times.
- `missing` is set to 8.

3. Exit the loop:
- Both `repeating` (5) and `missing` (8) are found.

4. Return:
- Output: {5, 8}

Final Result:
The repeating and missing numbers are: {5, 8}
*/






// Better Approach (Using Hashing): 

// Time Complexity: O(2N), where N = the size of the given array.
// Reason: We are using two loops each running for N times. So, the time complexity will be O(2N).

// Space Complexity: O(N) as we are using a hash array to solve this problem.



// import java.util.*;

// public class FindRepeatingAndMissingNumbers {

//     // Method to find the repeating and missing numbers in the array
//     public static int[] findMissingRepeatingNumbers(int[] a) {

//         int n = a.length; // Size of the array
//         int[] hash = new int[n + 1]; // Hash array to store counts of each number with all 0 entries

//         // Step 1: Update the hash array based on the input array
//         for (int i = 0; i < n; i++) {
//             hash[a[i]]++; // Increment count for each number
//         }

//         // Step 2: Find the repeating and missing numbers
//         int repeating = -1, missing = -1;

//         for (int i = 1; i <= n; i++) {
//             if (hash[i] == 2) repeating = i; // Number appears twice
//             else if (hash[i] == 0) missing = i; // Number does not appear

//             // Exit early if both numbers are found
//             if (repeating != -1 && missing != -1)
//                 break;
//         }

//         // Step 3: Return the results
//         return new int[]{repeating, missing};
//     }

//     public static void main(String[] args) {
//         // Input array
//         int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        
//         // Find the repeating and missing numbers
//         int[] ans = findMissingRepeatingNumbers(a);
        
//         // Print the results
//         System.out.println("The repeating and missing numbers are: {"
//                            + ans[0] + ", " + ans[1] + "}");
//     }
// }

/*
Dry Run:

Input array: [3, 1, 2, 5, 4, 6, 7, 5]
n = 8 (size of the array)
hash = [0, 0, 0, 0, 0, 0, 0, 0, 0] (initial state)

Step-by-step execution:

1. Update the hash array:
   - For a[0] = 3: hash[3]++
     hash = [0, 0, 0, 1, 0, 0, 0, 0, 0]
   - For a[1] = 1: hash[1]++
     hash = [0, 1, 0, 1, 0, 0, 0, 0, 0]
   - For a[2] = 2: hash[2]++
     hash = [0, 1, 1, 1, 0, 0, 0, 0, 0]
   - For a[3] = 5: hash[5]++
     hash = [0, 1, 1, 1, 0, 1, 0, 0, 0]
   - For a[4] = 4: hash[4]++
     hash = [0, 1, 1, 1, 1, 1, 0, 0, 0]
   - For a[5] = 6: hash[6]++
     hash = [0, 1, 1, 1, 1, 1, 1, 0, 0]
   - For a[6] = 7: hash[7]++
     hash = [0, 1, 1, 1, 1, 1, 1, 1, 0]
   - For a[7] = 5: hash[5]++
     hash = [0, 1, 1, 1, 1, 2, 1, 1, 0]

2. Find the repeating and missing numbers:
   - For i = 1: hash[1] = 1 (no action)
   - For i = 2: hash[2] = 1 (no action)
   - For i = 3: hash[3] = 1 (no action)
   - For i = 4: hash[4] = 1 (no action)
   - For i = 5: hash[5] = 2 (repeating = 5)
   - For i = 6: hash[6] = 1 (no action)
   - For i = 7: hash[7] = 1 (no action)
   - For i = 8: hash[8] = 0 (missing = 8)

3. Exit the loop:
   Both repeating and missing numbers are found: repeating = 5, missing = 8.

4. Return:
   Output: {5, 8}

Final Result:
The repeating and missing numbers are: {5, 8}
*/






// Optimal Approach 1 (Using Maths):    

// Time Complexity: O(N), where N = the size of the given array.
// Reason: We are using only one loop running for N times. So, the time complexity will be O(N).

// Space Complexity: O(1) as we are not using any extra space to solve this problem.

import java.util.*;

public class FindRepeatingAndMissingNumbers {

    // Method to find the repeating and missing numbers in the array
    public static int[] findMissingRepeatingNumbers(int[] a) {

        long n = a.length; // Size of the array
        
        // Step 1:a Calculate the theoretical sum (SN) and sum of squares (S2N) for numbers 1 to n
        long SumofNaturalno = (n * (n + 1)) / 2; // Sum of first n natural numbers
        long SquareofsumofNaturalno = (n * (n + 1) * (2 * n + 1)) / 6; // Sum of squares of first n natural numbers

        // Step 2: Calculate the actual sum (S) of array elemnt and sum of squares (S2) of the array element
        long S = 0, S2 = 0;

        for (int i = 0; i < n; i++) {
            S += a[i]; // Sum of elements in the array
            S2 += (long)a[i] * (long)a[i]; // Sum of squares of elements in the array
        }

        // Step 3: Calculate the difference values
        long val1 = S - SumofNaturalno; // Difference between the actual sum and theoretical sum (X - Y)
        long val2 = S2 - SquareofsumofNaturalno; // Difference between the actual sum of squares and theoretical sum of squares (X² - Y²)

        // Step 4: Calculate X + Y
        val2 = val2 / val1; // Using the relation (X² - Y²) / (X - Y) = X + Y

        // Step 5: Calculate X and Y
        long x = (val1 + val2) / 2; // X = (X + Y + X - Y) / 2
        long y = x - val1; // Y = X - (X - Y)

        // Step 6: Return the result as an integer array
        return new int[]{(int)x, (int)y};
    }

    public static void main(String[] args) {
        // Input array
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        
        // Find the repeating and missing numbers
        int[] ans = findMissingRepeatingNumbers(a);
        
        // Print the results
        System.out.println("The repeating and missing numbers are: {"
                           + ans[0] + ", " + ans[1] + "}");
    }
}

/*
Dry Run:

Input array: [3, 1, 2, 5, 4, 6, 7, 5]
n = 8 (size of the array)

1. Calculate theoretical sums:
   SN = (n * (n + 1)) / 2 = (8 * 9) / 2 = 36
   S2N = (n * (n + 1) * (2 * n + 1)) / 6 = (8 * 9 * 17) / 6 = 204

2. Calculate actual sums:
   S = sum of array elements = 3 + 1 + 2 + 5 + 4 + 6 + 7 + 5 = 33
   S2 = sum of squares of array elements = 3² + 1² + 2² + 5² + 4² + 6² + 7² + 5²
      = 9 + 1 + 4 + 25 + 16 + 36 + 49 + 25 = 165

3. Calculate differences:
   val1 = S - SN = 33 - 36 = -3 (X - Y)
   val2 = S2 - S2N = 165 - 204 = -39 (X² - Y²)

4. Find X + Y:
   val2 / val1 = -39 / -3 = 13 (X + Y)

5. Find X and Y:
   X = (val1 + val2) / 2 = (-3 + 13) / 2 = 10 / 2 = 5
   Y = X - val1 = 5 - (-3) = 5 + 3 = 8

6. Result:
   Repeating = X = 5
   Missing = Y = 8

Final Output:
The repeating and missing numbers are: {5, 8}
*/
