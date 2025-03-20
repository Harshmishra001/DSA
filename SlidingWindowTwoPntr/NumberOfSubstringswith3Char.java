package SlidingWindowTwoPntr;

class NumberOfSubstringswith3Char{
    public int numberOfSubstrings(String s) {
        int count = 0; // Stores the total count of valid substrings
        int left = 0; // Left pointer for the sliding window
        int[] charCount = new int[3]; // Array to track occurrences of 'a', 'b', and 'c'

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'a']++; // Increment the count of the current character

            // Check if all three characters are present in the window
            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                count += s.length() - right; // Add the count of substrings that can be formed
                charCount[s.charAt(left) - 'a']--; // Shrink the window from the left
                left++; // Move the left pointer forward
            }
        }

        return count; // Return the total count of substrings containing 'a', 'b', and 'c'
    }

    // Main method to test the function
    public static void main(String[] args) {
        NumberOfSubstringswith3Char solution = new NumberOfSubstringswith3Char();
        String testString = "abcabc";
        int result = solution.numberOfSubstrings(testString);
        System.out.println("Number of substrings containing 'a', 'b', and 'c': " + result);
    }

    /*
    Dry Run Example: s = "abcabc"
    -------------------------------------
    Initial State:
    s = "abcabc"
    left = 0, count = 0, charCount = [0, 0, 0]
    
    Step 1: right = 0 ('a')
    charCount = [1, 0, 0]
    No valid substring yet.
    
    Step 2: right = 1 ('b')
    charCount = [1, 1, 0]
    No valid substring yet.
    
    Step 3: right = 2 ('c')
    charCount = [1, 1, 1]
    Found 4 valid substrings: "abc", "abca", "abcab", "abcabc"
    count = 4
    
    Shrinking window:
    - Removing 'a' from charCount
    - Updated charCount = [0, 1, 1]
    - Increment left pointer: left = 1
    
    Step 4: right = 3 ('a')
    charCount = [1, 1, 1]
    Found 3 valid substrings: "bca", "bcab", "bcabc"
    count = 7
    
    Shrinking window:
    - Removing 'b' from charCount
    - Updated charCount = [1, 0, 1]
    - Increment left pointer: left = 2
    
    Step 5: right = 4 ('b')
    charCount = [1, 1, 1]
    Found 2 valid substrings: "cab", "cabc"
    count = 9
    
    Shrinking window:
    - Removing 'c' from charCount
    - Updated charCount = [1, 1, 0]
    - Increment left pointer: left = 3
    
    Step 6: right = 5 ('c')
    charCount = [1, 1, 1]
    Found 1 valid substring: "abc"
    count = 10
    
    Shrinking window:
    - Removing 'a' from charCount
    - Updated charCount = [0, 1, 1]
    - Increment left pointer: left = 4
    
    Final Output: 10
    -------------------------------------
    */

    /*
    Time Complexity: O(N)  
    - Each character is processed once by the right pointer and at most once by the left pointer.
    - Thus, the overall complexity is O(N).

    Space Complexity: O(1) 
    - We use a fixed-size array of length 3, so the space complexity is constant, O(1).
    */
}