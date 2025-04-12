public class TrappingRainWater {

    /**
     * Optimized Approach:
     * Time Complexity: O(n) - We traverse the array once using two pointers.
     * Space Complexity: O(1) - No extra space is used.
     */
    public static int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;     // Tracks the max height to the left
        int rightMax = 0;    // Tracks the max height to the right
        int l = 0;           // Left pointer
        int r = n - 1;       // Right pointer
        int ans = 0;         // To store total trapped water

        while (l < r) {
            // Update leftMax if needed
            if (height[l] > leftMax) {
                leftMax = Math.max(leftMax, height[l]);
            }

            // Update rightMax if needed
            if (height[r] > rightMax) {
                rightMax = Math.max(rightMax, height[r]);
            }

            // Decide which side to process
            if (leftMax < rightMax) {
                // Water trapped at left is limited by leftMax
                ans += leftMax - height[l];
                l++;  // Move left pointer to the right
            } else {
                // Water trapped at right is limited by rightMax
                ans += rightMax - height[r];
                r--;  // Move right pointer to the left
            }
        }

        return ans;
    }

    /**
     * Brute Force Approach:
     * Time Complexity: O(n^2) - For each bar, we calculate the leftMax and rightMax.
     * Space Complexity: O(1) - No extra space is used.
     */
    public static int trapBruteForce(int[] height) {
        int n = height.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;

            // Find the maximum height to the left of the current bar
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find the maximum height to the right of the current bar
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Water trapped at the current bar is limited by the smaller of the two
            ans += Math.min(leftMax, rightMax) - height[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        // Optimized approach
        int totalWater = trap(height);
        System.out.println("Total trapped water (Optimized): " + totalWater); // Output: 6

        // Brute force approach
        int totalWaterBruteForce = trapBruteForce(height);
        System.out.println("Total trapped water (Brute Force): " + totalWaterBruteForce); // Output: 6
    }
}

/**
 * Dry Run of Optimized Approach:
 * Input: height = {0,1,0,2,1,0,1,3,2,1,2,1}
 * 
 * Step-by-step:
 * l = 0, r = 11, leftMax = 0, rightMax = 0, ans = 0
 * - leftMax < rightMax, ans += 0 - 0 = 0, l++
 * l = 1, r = 11, leftMax = 1, rightMax = 0, ans = 0
 * - leftMax > rightMax, ans += 0 - 1 = 0, r--
 * l = 1, r = 10, leftMax = 1, rightMax = 2, ans = 0
 * - leftMax < rightMax, ans += 1 - 1 = 0, l++
 * l = 2, r = 10, leftMax = 1, rightMax = 2, ans = 0
 * - leftMax < rightMax, ans += 1 - 0 = 1, l++
 * l = 3, r = 10, leftMax = 2, rightMax = 2, ans = 1
 * - leftMax >= rightMax, ans += 2 - 1 = 1, r--
 * ...
 * Final ans = 6
 */
