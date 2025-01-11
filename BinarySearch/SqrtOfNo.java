// package BinarySearch;
// Problem Statement: You are given a positive integer n. Your task is to find and return its square root. If ‘n’ is 
// not a perfect square, then return the floor value of 'sqrt(n)'.

// Note: The question explicitly states that if the given number, n, is not a perfect square, our objective is to find the
//  maximum number, x, such that x squared is less than or equal to n (x*x <= n). In other words, we need to determine the 
// floor value of the square root of n.

// Examples
// Example 1:
// Input Format:
//  n = 36
// Result:
//  6
// Explanation:
//  6 is the square root of 36.

// Example 2:
// Input Format:
//  n = 28
// Result:
//  5
// Explanation:
//  Square root of 28 is approximately 5.292. So, the floor value will be 5.



// *Brute-Force Approach*

// Time Complexity: O(N), N = the given number.
// Reason: Since we are using linear search, we traverse the entire answer space.

// Space Complexity: O(1) as we are not using any extra space

// public class SqrtOfNo  {
//     // Function to find the floor of the square root of a number
//     public static int floorSqrt(int n) {
//         int ans = 0; // To store the floor value of the square root

//         // Linear search on the answer space (from 1 to n)
//         for (long i = 1; i <= n; i++) {
//             // Calculate the square of the current number
//             long val = i * i;

//             // If square is less than or equal to n, update the answer
//             if (val <= (long) n) {
//                 ans = (int) i; // Store the current number as the answer
//             } else {
//                 // If square exceeds n, break out of the loop as further values will exceed n
//                 break;
//             }
//         }

//         return ans; // Return the computed floor square root
//     }

//     public static void main(String[] args) {
//         int n = 28; // Example number
//         int ans = floorSqrt(n); // Call the function to find the floor square root
//         System.out.println("The floor of square root of " + n + " is: " + ans); // Output the result
//     }
// }

/*
Dry Run:
Initial input: n = 28

1. Initialize `ans = 0`.

2. Start the loop with i = 1:
   - Calculate i * i = 1 * 1 = 1.
   - Since 1 <= 28, update `ans = 1`.

3. For i = 2:
   - Calculate i * i = 2 * 2 = 4.
   - Since 4 <= 28, update `ans = 2`.

4. For i = 3:
   - Calculate i * i = 3 * 3 = 9.
   - Since 9 <= 28, update `ans = 3`.

5. For i = 4:
   - Calculate i * i = 4 * 4 = 16.
   - Since 16 <= 28, update `ans = 4`.

6. For i = 5:
   - Calculate i * i = 5 * 5 = 25.
   - Since 25 <= 28, update `ans = 5`.

7. For i = 6:
   - Calculate i * i = 6 * 6 = 36.
   - Since 36 > 28, break out of the loop.

The loop ends, and `ans = 5`, which is the floor of the square root of 28.

Output: The floor of square root of 28 is: 5
*/


// *Optimal Approach-1*

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are basically using the Binary Search algorithm.

// Space Complexity: O(1) as we are not using any extra space.


// public class  SqrtOfNo{
//     // Function to find the floor of the square root of a number using binary search
//     public static int floorSqrt(int n) {

//         int low = 1, high = n; // Initialize low and high pointers for binary search
        
//         // Binary search on the answer space
//         while (low <= high) {
//             long mid = (low + high) / 2; // Calculate the mid-point
//             long val = mid * mid; // Square of mid

//             // If mid^2 is less than or equal to n, then this is a potential answer
//             if (val <= (long)(n)) {
//                 // Eliminate the left half by setting low to mid + 1
//                 low = (int)(mid + 1);
//             } else {
//                 // If mid^2 is greater than n, eliminate the right half by setting high to mid - 1
//                 high = (int)(mid - 1);
//             }
//         }

//         return high; // Return the floor value of square root, which is high
//     }

//     public static void main(String[] args) {
//         int n = 28; // Example number to find the floor square root
//         int ans = floorSqrt(n); // Call the function to compute the floor square root
//         System.out.println("The floor of square root of " + n + " is: " + ans); // Output the result
//     }
// }

/*
Dry Run:
Initial input: n = 28

1. Initialize `low = 1`, `high = 28`.

2. First iteration:
   - mid = (1 + 28) / 2 = 14
   - Calculate mid^2 = 14 * 14 = 196.
   - 196 > 28, so set high = mid - 1 = 13.

3. Second iteration:
   - mid = (1 + 13) / 2 = 7
   - Calculate mid^2 = 7 * 7 = 49.
   - 49 > 28, so set high = mid - 1 = 6.

4. Third iteration:
   - mid = (1 + 6) / 2 = 3
   - Calculate mid^2 = 3 * 3 = 9.
   - 9 <= 28, so set low = mid + 1 = 4.

5. Fourth iteration:
   - mid = (4 + 6) / 2 = 5
   - Calculate mid^2 = 5 * 5 = 25.
   - 25 <= 28, so set low = mid + 1 = 6.

6. Fifth iteration:
   - mid = (6 + 6) / 2 = 6
   - Calculate mid^2 = 6 * 6 = 36.
   - 36 > 28, so set high = mid - 1 = 5.

The loop ends as low > high. The value of high is 5, which is the floor of the square root of 28.

Output: The floor of square root of 28 is: 5
*/


// *Optimal Approach-2*  

// Time Complexity: O(logN), N = size of the given array.
// Reason: We are basically using the Binary Search algorithm.

// Space Complexity: O(1) as we are not using any extra space.

import java.lang.Math;

public class SqrtOfNo {
    // Function to find the floor of the square root of a number using Math.sqrt
    public static int floorSqrt(int n) {
        // Using Math.sqrt to get the square root and casting to int to get the floor value
        int ans = (int) Math.sqrt(n);
        return ans; // Return the floor value of the square root
    }

    public static void main(String[] args) {
        int n = 28; // Example number
        int ans = floorSqrt(n); // Call the function to compute the floor square root
        System.out.println("The floor of square root of " + n + " is: " + ans); // Output the result
    }
}

/*
Dry Run:
Initial input: n = 28

1. Call Math.sqrt(28), which gives the square root of 28: approximately 5.2915.
2. Cast the result to an integer. The result after casting is 5, which is the floor value of the square root.
3. Return the result `5` from the `floorSqrt` function.

Output: The floor of square root of 28 is: 5
*/
