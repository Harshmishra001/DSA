package SlidingWindowTwoPntr;
import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinctInt {
    /**
     * Returns the number of subarrays with exactly K distinct integers.
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findAtMostK(nums, k) - findAtMostK(nums, k - 1);
    }

    /**
     * Helper function to count subarrays with at most K distinct integers.
     */
    private int findAtMostK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // Stores the frequency of elements in the current window
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1); // Add the rightmost element to the map

            // Shrink the window if the number of distinct elements exceeds K
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]); // Remove the element if its count becomes zero
                }
                left++; // Move the left pointer forward
            }
            
            count += (right - left + 1); // Count the subarrays ending at index 'right'
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3}; // Example array
        int k = 2; // Example K value
        SubarraysWithKDistinctInt solution = new SubarraysWithKDistinctInt();
        int result = solution.subarraysWithKDistinct(nums, k);
        System.out.println("Number of subarrays with exactly " + k + " distinct integers: " + result);
    }

}
