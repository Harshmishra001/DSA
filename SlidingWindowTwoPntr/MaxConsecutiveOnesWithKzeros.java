package SlidingWindowTwoPntr;

class  MaxConsecutiveOnesWithKzeros{

    /*
    Time Complexity (TC): O(N)
    - We traverse the array once using the right pointer and at most once using the left pointer.
    - In total, each element is processed at most twice → O(2N) ≈ O(N).

    Space Complexity (SC): O(1)
    - We only use integer variables (`left`, `right`, `zerosCount`, `maxlen`).
    - No additional data structures are used → O(1).
    */

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;   // Two pointers for the sliding window
        int zerosCount = 0;        // Count of zeros in the window
        int maxlen = 0;            // Stores the maximum length of valid subarray

        while (right < nums.length) {  // Expand the window by moving the right pointer
            if (nums[right] == 0) {
                zerosCount++;  // Increase zero count if 0 is encountered
            }

            // Shrink the window if zero count exceeds the allowed flips (k)
            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;  // If leftmost element is 0, reduce count
                }
                left++;  // Move left pointer forward to reduce window size
            }

            // Update the maximum length of the valid window
            maxlen = Math.max(maxlen, right - left + 1);
            
            right++;  // Move the right pointer to extend the window
        }

        return maxlen; // Return the longest contiguous 1s (with at most k flips)
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesWithKzeros sol = new MaxConsecutiveOnesWithKzeros();

        // Example test case
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        // Call the function and print the result
        int result = sol.longestOnes(nums, k);
        System.out.println("Longest contiguous subarray with at most " + k + " zero flips: " + result);
    }
}

// ## **Step-by-Step Dry Run with Comments Inside Code**
// #### **Given Input:**

// nums = {1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1}
// k = 2

// #### **Initial Variables:**
// - `left = 0`, `right = 0`
// - `zerosCount = 0`
// - `maxlen = 0`

// #### **Execution Flow (Dry Run)**

// 1. **Right = 0**, `nums[right] = 1`
//    - 1 encountered → No change in `zerosCount`
//    - `maxlen = 1` (`right - left + 1 = 0 - 0 + 1`)
//    - Move `right++`

// 2. **Right = 1**, `nums[right] = 1`
//    - 1 encountered → No change in `zerosCount`
//    - `maxlen = 2` (`right - left + 1 = 1 - 0 + 1`)
//    - Move `right++`

// 3. **Right = 2**, `nums[right] = 0`
//    - 0 encountered → `zerosCount = 1`
//    - `maxlen = 3` (`right - left + 1 = 2 - 0 + 1`)
//    - Move `right++`

// 4. **Right = 3**, `nums[right] = 0`
//    - 0 encountered → `zerosCount = 2`
//    - `maxlen = 4` (`right - left + 1 = 3 - 0 + 1`)
//    - Move `right++`

// 5. **Right = 4**, `nums[right] = 1`
//    - 1 encountered → No change in `zerosCount`
//    - `maxlen = 5` (`right - left + 1 = 4 - 0 + 1`)
//    - Move `right++`

// 6. **Right = 5**, `nums[right] = 1`
//    - 1 encountered → No change in `zerosCount`
//    - `maxlen = 6` (`right - left + 1 = 5 - 0 + 1`)
//    - Move `right++`

// 7. **Right = 6**, `nums[right] = 1`
//    - 1 encountered → No change in `zerosCount`
//    - `maxlen = 7` (`right - left + 1 = 6 - 0 + 1`)
//    - Move `right++`

// 8. **Right = 7**, `nums[right] = 0`
//    - 0 encountered → `zerosCount = 3` (**exceeds k**)
//    - **Now, `while (zerosCount > k)` executes:**
//      - `left = 0`, `nums[left] = 1` (not a zero) → Move `left++`
//      - `left = 1`, `nums[left] = 1` (not a zero) → Move `left++`
//      - `left = 2`, `nums[left] = 0` (zero found) → Decrease `zerosCount = 2`, exit loop
//    - `maxlen = 7`
//    - Move `right++`

// 9. **Right = 8**, `nums[right] = 1`
//    - 1 encountered → No change in `zerosCount`
//    - `maxlen = 7`
//    - Move `right++`

// 10. **Right = 9**, `nums[right] = 1`
//    - 1 encountered → No change in `zerosCount`
//    - `maxlen = 8`
//    - Move `right++`

// 11. **Right = 10**, `nums[right] = 1`
//    - 1 encountered → No change in `zerosCount`
//    - `maxlen = 9`
//    - Move `right++`

// #### **Final Output:**
// Longest contiguous subarray with at most 2 zero flips: 9
