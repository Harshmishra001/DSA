import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /*
     * Function to find the minimum window substring that contains all characters of t
     * 
     * Time Complexity: O(m + n) where m = length of s and n = length of t
     * Space Complexity: O(n) where n is the size of string t (storing character frequencies)
     */
    public String minWindow(String s, String t) {
        int n = s.length();

        // If t is larger than s, it's impossible to find such a window
        if (t.length() > n)
            return "";

        Map<Character, Integer> mp = new HashMap<>();

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = t.length(); // Number of characters still needed in the window
        int i = 0, j = 0; // Window start and end pointers

        int minWindowSize = Integer.MAX_VALUE; // Tracks minimum window size
        int start_i = 0; // Start index of the minimum window found

        // Start expanding the window with the right pointer (j)
        while (j < n) {
            char ch = s.charAt(j);
            
            // If character is in t and still required, decrease requiredCount
            if (mp.containsKey(ch) && mp.get(ch) > 0) {
                requiredCount--;
            }
            
            // Reduce the frequency in the map
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);
            
            // Once all characters are found, try to shrink the window
            while (requiredCount == 0) {
                int currWindowSize = j - i + 1;
                
                // Update minimum window size and starting index
                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i;
                }
                
                // Remove the leftmost character from the window
                char startChar = s.charAt(i);
                mp.put(startChar, mp.getOrDefault(startChar, 0) + 1);
                
                // If this character was part of t and is now required again, increase requiredCount
                if (mp.containsKey(startChar) && mp.get(startChar) > 0) {
                    requiredCount++;
                }
                
                i++; // Shrink the window from the left
            }

            j++; // Expand the window from the right
        }

        // If no valid window was found, return an empty string
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new  MinimumWindowSubstring();

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = solution.minWindow(s, t);
        System.out.println("Minimum window substring: " + result); // Expected Output: "BANC"
    }
}

/*
Example Walkthrough:
Input: s = "ADOBECODEBANC", t = "ABC"

Step 1: Store frequency of t -> {A:1, B:1, C:1}
Step 2: Start expanding the window.
    - j=0 -> A (found, requiredCount=2)
    - j=1 -> D (not in t)
    - j=2 -> O (not in t)
    - j=3 -> B (found, requiredCount=1)
    - j=4 -> E (not in t)
    - j=5 -> C (found, requiredCount=0) [Valid window: "ADOBEC"]
Step 3: Start shrinking from the left.
    - i=0 -> Remove A (requiredCount=1) [Window invalid]
    - Move j further to find a new valid window.
    - j=9 -> A (found again, requiredCount=0) [Valid window: "BECODEBA"]
    - Continue shrinking.
    - i=3 -> Remove B (requiredCount=1) [Window invalid]
    - j=10 -> N (not in t)
    - j=11 -> C (found again, requiredCount=0) [Valid window: "BANC"]
    - Shrink to find the minimum window.
    - i=6 -> Remove B (requiredCount=1) [Window invalid]
Step 4: Output the smallest valid window found: "BANC"
*/
