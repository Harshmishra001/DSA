
// Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones
//  in the array.

// Examples:
// Example 1:
// Input: prices = {1, 1, 0, 1, 1, 1}
// Output: 3
// Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.

// Input: prices = {1, 0, 1, 1, 0, 1} 
// Output: 2
// Explanation: There are two consecutive 1's in the array. 

// Time Complexity: O(N) since the solution involves only a single pass.
// Space Complexity: O(1) because no extra space is used.

import java.util.*;

public class MaxConsecutiveones {
    
    // Function to find the maximum consecutive 1's in the given array
    static int findMaxConsecutiveOnes(int nums[]) {
        int cnt = 0;       // Counter to track consecutive 1's
        int maxi = 0;      // To store the maximum count of consecutive 1's found so far
        
        // Loop through the entire array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {        // If the current element is 1, increment the count
                cnt++;
            } else {                  // If the current element is 0, reset the count to 0
                cnt = 0;
            }

            // Update the maximum value with the larger of the previous maximum or current count
            maxi = Math.max(maxi, cnt);
        }
        
        // Return the maximum count of consecutive 1's
        return maxi;
    }

    public static void main(String args[]) {
        // Test array
        int nums[] = { 1, 1, 0, 1, 1, 1 }; // Example input array
        
        // Find the maximum consecutive 1's in the array
        int ans = findMaxConsecutiveOnes(nums);
        
        // Output the result
        System.out.println("The maximum consecutive 1's are " + ans);
    }
}

/*
Dry Run:

1. Input array: {1, 1, 0, 1, 1, 1}
2. Initialization:
   - cnt = 0 (this variable counts consecutive 1's)
   - maxi = 0 (this variable keeps track of the highest number of consecutive 1's found so far)
   
3. Iterating through the array:

   - i = 0: nums[0] = 1
     - Increment cnt (cnt = 1)
     - Update maxi = Math.max(maxi, cnt) → maxi = Math.max(0, 1) = 1

   - i = 1: nums[1] = 1
     - Increment cnt (cnt = 2)
     - Update maxi = Math.max(maxi, cnt) → maxi = Math.max(1, 2) = 2

   - i = 2: nums[2] = 0
     - Reset cnt to 0 (as we encountered a 0)
     - maxi remains the same (maxi = 2)

   - i = 3: nums[3] = 1
     - Increment cnt (cnt = 1)
     - Update maxi = Math.max(maxi, cnt) → maxi = Math.max(2, 1) = 2

   - i = 4: nums[4] = 1
     - Increment cnt (cnt = 2)
     - Update maxi = Math.max(maxi, cnt) → maxi = Math.max(2, 2) = 2

   - i = 5: nums[5] = 1
     - Increment cnt (cnt = 3)
     - Update maxi = Math.max(maxi, cnt) → maxi = Math.max(2, 3) = 3

4. After looping through the array, the maximum value of consecutive 1's (maxi) is 3

5. Output: "The maximum consecutive 1's are 3"
*/



// QUESTION 2

// Given a number N. Find the length of the longest consecutive 1s in its binary representation.

// Example 1:

// Input: N = 14
// Output: 3
// Explanation: 
// Binary representation of 14 is 
// 1110, in which 111 is the longest 
// consecutive set bits of length is 3.
// Example 2:

// Input: N = 222
// Output: 4
// Explanation: 
// Binary representation of 222 is 
// 11011110, in which 1111 is the 
// longest consecutive set bits of length 4. 

//User function Template for Java


// class Solution {
//     public static int maxConsecutiveOnes(int N) {
        
//         int count = 0;  // Initialize a counter to keep track of the maximum number of consecutive 1s
        
//         // Loop until N becomes 0
//         while (N != 0) {
//             // Perform bitwise AND operation between N and (N left-shifted by 1)
//             // This operation removes the rightmost 1 from the sequence of consecutive 1s
//             N = (N & (N << 1));
//             count++;  // Increment the counter for each sequence of consecutive 1s found
//         }
        
//         return count;  // Return the maximum count of consecutive 1s
//     }
// }

