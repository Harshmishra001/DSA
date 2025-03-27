package SlidingWindowTwoPntr;
import java.util.*;

class BinarySubarrayWithSum  {
    
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    // Helper function to count subarrays with sum <= goal
    public int helper(int nums[], int goal) {
        if (goal < 0) return 0; // If goal is negative, no valid subarray exists
        
        int count = 0, sum = 0;
        int start = 0, end = 0;
        
        
        while (start < nums.length) {
            sum += nums[start]; // Expand the window by adding nums[start]
            
            while (end < nums.length && sum > goal) { // Shrink window if sum exceeds goal
                sum -= nums[end];
                end++;
            }
            
            count += start - end + 1; // Count subarrays within the window
            start++; // Move to the next element
        }
        return count;
    }

    public static void main(String[] args) {
        BinarySubarrayWithSum  solution = new BinarySubarrayWithSum ();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        
        int result = solution.numSubarraysWithSum(nums, goal);
        System.out.println("Number of subarrays with sum " + goal + " is: " + result);
    }
}

/*
Detailed Dry Run for nums = [1, 0, 1, 0, 1] and goal = 2
--------------------------------------------------------
Calling helper(nums, 2) (counts subarrays with sum ≤ 2)

start=0, sum=1, count+=1  → count=1
start=1, sum=1, count+=2  → count=3
start=2, sum=2, count+=3  → count=6
start=3, sum=2, count+=4  → count=10
start=4, sum=3 (exceeds goal), shrink window: end=1, sum=2, count+=4 → count=14
Return helper(nums, 2) = 14

Calling helper(nums, 1) (counts subarrays with sum ≤ 1)

start=0, sum=1, count+=1  → count=1
start=1, sum=1, count+=2  → count=3
start=2, sum=2 (exceeds goal), shrink window: end=1, sum=1, count+=2 → count=5
start=3, sum=1, count+=3  → count=8
start=4, sum=2 (exceeds goal), shrink window: end=2, sum=1, count+=3 → count=11
Return helper(nums, 1) = 11

Final result:
numSubarraysWithSum(nums, 2) = helper(nums, 2) - helper(nums, 1)
= 14 - 11 = 3

### Step-by-step walkthrough with sliding window changes:

1. **helper(nums, 2)** counts all subarrays with sum ≤ 2.
2. **helper(nums, 1)** counts all subarrays with sum ≤ 1.
3. The difference of both gives **only** those subarrays with sum exactly 2.

**Example Calculation (Corrected):**
- `[1, 0, 1]` → Valid
- `[1, 0, 1, 0]` → Valid
- `[0, 1, 0, 1]` → Valid

Total Valid Subarrays = **3**

Output:
Number of subarrays with sum 2 is: 3
*/
