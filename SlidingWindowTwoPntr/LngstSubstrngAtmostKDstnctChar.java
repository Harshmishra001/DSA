package SlidingWindowTwoPntr;


import java.util.HashMap;

public class LngstSubstrngAtmostKDstnctChar {
    
    // Brute Force Approach (O(N^2))
    // Time Complexity: O(N^2) - We check every substring and count distinct characters.
    // Space Complexity: O(K) - We store at most K characters in the HashMap.
    public static int longestSubstringBruteForce(String s, int k) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }
    
    // Optimized Sliding Window Approach (O(N))
    // Time Complexity: O(N) - Each character is processed at most twice (once added, once removed).
    // Space Complexity: O(K) - We store at most K characters in the HashMap.
    public static int longestSubstringOptimized(String s, int k) {
        int left = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Right pointer moves through the string
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            // If more than k distinct characters, shrink the window from the left
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++; // Shrinking the window
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        
        System.out.println("Brute Force Result: " + longestSubstringBruteForce(s, k));
        System.out.println("Optimized Result: " + longestSubstringOptimized(s, k));
    }
}

/*
    Walkthrough of Optimized Sliding Window Approach:
    
    Input: s = "aabacbebebe", k = 3
    
    Step 1: Initialize left = 0, maxLength = 0, and an empty HashMap to track character counts.
    Step 2: Iterate through the string with the right pointer, expanding the window and updating character counts.
    Step 3: If the number of distinct characters exceeds k, move the left pointer to shrink the window until the condition is met.
    Step 4: Update maxLength with the maximum valid substring length found.
    Step 5: Repeat until the right pointer reaches the end of the string.
    
    Example Execution:
    
    - Start with "a", map = {a=1}, maxLength = 1
    - Expand to "aa", map = {a=2}, maxLength = 2
    - Expand to "aab", map = {a=2, b=1}, maxLength = 3
    - Expand to "aaba", map = {a=3, b=1}, maxLength = 4
    - Expand to "aabac", map = {a=3, b=1, c=1}, maxLength = 5
    - Expand to "abacb", map = {a=2, b=2, c=1}, maxLength = 5
    - Expand to "abacbe", map = {a=2, b=2, c=1, e=1}, now exceeding k, so shrink window
    - Move left to "bacbe", map = {b=2, a=1, c=1, e=1}, shrink further
    - Move left to "acbe", map = {a=1, c=1, b=1, e=1}, still exceeding k, shrink more
    - Move left to "cbe", map = {c=1, b=1, e=1}, maxLength = 5
    - Expand to "cbeb", map = {c=1, b=2, e=1}, maxLength = 5
    - Expand to "cbebe", map = {c=1, b=2, e=2}, maxLength = 6
    - Expand to "cbebeb", map = {c=1, b=3, e=2}, maxLength = 7
    
    Final Output: Longest substring with at most 3 distinct characters is 7
*/
