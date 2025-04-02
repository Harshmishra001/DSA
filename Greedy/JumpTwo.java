// You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

// 0 <= j <= nums[i] and
// i + j < n
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [2,3,0,1,4]
// Output: 2

// **Time Complexity:** O(n) (Single pass through the array)  
// **Space Complexity:** O(1) (Constant extra space used)

class JumpTwo {

    // Function to find the minimum number of jumps to reach the end
    int jump(int[] nums) {
        int totalJumps = 0; // Count of jumps taken
        int destination = nums.length - 1; // Last index (goal)
        int coverage = 0, lastJumpIdx = 0; // Tracking farthest reach and last jump index

        // Base case: If there's only one element, no jumps are needed
        if (nums.length == 1) return 0;

        // Iterate through the array to determine the minimum jumps
        for (int i = 0; i < nums.length; i++) {
            // Update the farthest index we can reach
            coverage = Math.max(coverage, i + nums[i]);

            // When we reach the index where the last jump took us, we must jump again
            if (i == lastJumpIdx) {
                lastJumpIdx = coverage; // Update last jump index
                totalJumps++; // Increase jump count

                // If we have reached or surpassed the last index, return total jumps
                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }
        return totalJumps; // Return minimum jumps required
    }

    // Main method to test the function
    public static void main(String[] args) {
        JumpTwo solution = new JumpTwo();
        
        // Example test case
        int[] nums = {2, 3, 1, 1, 4}; 
        int result = solution.jump(nums);
        
        System.out.println("Minimum jumps needed: " + result); // Expected output: 2
    }
}

// ### **Dry Run for Input:** `nums = {2, 3, 1, 1, 4}`  

// 1. **Initialization:**  
//    - `totalJumps = 0`, `destination = 4`, `coverage = 0`, `lastJumpIdx = 0`.

// 2. **Iteration Begins:**  

//    - **i = 0:**  
//      - `nums[0] = 2`, so `coverage = max(0, 0 + 2) = 2`.  
//      - Since `i == lastJumpIdx` (0 == 0), we jump:  
//        - `lastJumpIdx = 2`, `totalJumps = 1`.  

//    - **i = 1:**  
//      - `nums[1] = 3`, so `coverage = max(2, 1 + 3) = 4`.  
//      - No jump yet, since `i ≠ lastJumpIdx`.  

//    - **i = 2:**  
//      - `nums[2] = 1`, so `coverage = max(4, 2 + 1) = 4`.  
//      - Since `i == lastJumpIdx` (2 == 2), we jump:  
//        - `lastJumpIdx = 4`, `totalJumps = 2`.  
//      - Now, `coverage >= destination` (4 >= 4), so we return `2`.  

// ### **Final Output:**  
// `Minimum jumps needed: 2` ✅  
// _(Path: **0 → 1 → 4**)_

// Let me know if you need more details! 🚀