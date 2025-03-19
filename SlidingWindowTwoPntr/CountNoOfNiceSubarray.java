package SlidingWindowTwoPntr;
// Time Complexity: O(N), as we traverse the array at most twice due to the sliding window approach.
// Space Complexity: O(1), since we use only a few integer variables.
import java.util.*;

class CountNoOfNiceSubarray {
    // Helper function to count subarrays with at most 'goal' odd numbers
    private int numberOfSubarraysLessThanEqualToGoal(int[] nums, int goal) {
        int i = 0, j = 0, count = 0, ans = 0;
        int n = nums.length;
        
        while (j < n) {
            // If the current element is odd, increment count
            if (nums[j] % 2 == 1) count++;
            
            // If count exceeds the goal, shrink the window from the left
            while (i <= j && count > goal) {
                if (nums[i] % 2 == 1) count--; // Reduce count if the leftmost element is odd
                i++; // Move the left pointer forward
            }
            
            // The number of subarrays ending at index 'j' is (j - i + 1)
            ans += (j - i + 1);
            
            // Move the right pointer forward
            j++;
        }
        return ans; // Return the total count of valid subarrays
    }
    
    // Function to count subarrays with exactly 'k' odd numbers
    public int numberOfSubarrays(int[] nums, int k) {
        /* 
         * To find the number of subarrays with exactly 'k' odd numbers, 
         * we use the sliding window technique:
         * - Compute subarrays with at most 'k' odd numbers.
         * - Compute subarrays with at most 'k-1' odd numbers.
         * - Subtract the two to get exactly 'k' odd numbers.
         */
        return numberOfSubarraysLessThanEqualToGoal(nums, k) - 
               numberOfSubarraysLessThanEqualToGoal(nums, k - 1);
    }

    public static void main(String[] args) {
        // Creating an object of the class
        CountNoOfNiceSubarray obj = new CountNoOfNiceSubarray();
        
        // Example input array
        int[] nums = {1, 1, 2, 1, 1}; // Contains three subarrays with exactly 3 odd numbers
        int k = 3;
        
        // Dry run walkthrough
        /*
         * Given nums = [1, 1, 2, 1, 1] and k = 3
         * We first count subarrays with at most 3 odd numbers:
         * - Window expands to include elements until count > 3, then shrinks
         * - We accumulate valid subarrays at each step
         * Next, we count subarrays with at most 2 odd numbers:
         * - Similar sliding window approach
         * Subtract the two counts to get exactly 3 odd numbers in subarrays.
         */
        
        // Calling the function and printing the result
        int result = obj.numberOfSubarrays(nums, k);
        System.out.println("Number of nice subarrays: " + result);
    }
}
