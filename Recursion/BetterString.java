import java.util.HashMap;
import java.util.Map;
class BetterString {
    // Function to count distinct subsequences of a given string 's'
    public static int countDistinctSubsequences(String s) {
        int n = s.length();
        
        // dp[i] will store the number of distinct subsequences in the substring s[0...i-1]
        int[] dp = new int[n + 1];
        
        // Base case: An empty string has exactly 1 subsequence: the empty subsequence itself
        dp[0] = 1;
        
        // A map to track the last occurrence of each character
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        
        // Iterate over the string to fill the dp array
        for (int i = 1; i <= n; i++) {
            // Current character in the string
            char ch = s.charAt(i - 1);
            
            // Each subsequence can be formed with or without the current character,
            // hence we double the number of subsequences from the previous index.
            dp[i] = 2 * dp[i - 1];
            
            // If the character has appeared before, we subtract the subsequences that
            // were already counted for the previous occurrence to avoid overcounting.
            if (lastOccurrence.containsKey(ch)) {
                dp[i] -= dp[lastOccurrence.get(ch) - 1];
            }
            
            // Update the last occurrence of the current character
            lastOccurrence.put(ch, i);
        }
        
        // The answer is the number of distinct subsequences for the entire string
        return dp[n];
    }
    
    // Function to determine which string has more distinct subsequences
    public static String betterString(String str1, String str2) {
        // Get the number of distinct subsequences for both strings
        int count1 = countDistinctSubsequences(str1);
        int count2 = countDistinctSubsequences(str2);
        
        // Compare the counts and return the "better" string, which is the one with more subsequences
        if (count1 > count2) {
            return str1;
        } else if (count2 > count1) {
            return str2;
        } else {
            // If both have the same number of subsequences, return the first string by default
            return str1;
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        String str1 = "gfg";
        String str2 = "ggg";
        
        // Calling the betterString function to determine which string has more distinct subsequences
        String result = betterString(str1, str2);
        
        // Output the result
        System.out.println("The better string is: " + result);
    }
}

// Test Case Explanation:

// Let's understand with an example.

// Assume we are given two strings:

// str1 = "abc"
// str2 = "aab"
// We want to find out which string has more distinct subsequences.

// str1 = "abc":
// Subsequences: "", "a", "b", "c", "ab", "ac", "bc", "abc"
// Total distinct subsequences = 8
// str2 = "aab":
// Subsequences: "", "a", "a", "b", "aa", "ab", "ab", "aab"
// However, we remove duplicates like "a" and "ab", so the total distinct subsequences are: "", "a", "b", "aa", "ab", "aab"
// Total distinct subsequences = 6
// Since str1 has more distinct subsequences (8) compared to str2 (6), the function betterString(str1, str2) will return "abc" as the better string.



// Let's step through the test case and debug the code with detailed steps.

// ### Test Case:

// We have two strings:

// - `str1 = "abc"`
// - `str2 = "aab"`

// We want to find out which string has more distinct subsequences.

// ### Code Debugging:

// 1. **For `str1 = "abc"`:**
//    - **Initial setup:**
//      - Length (`n`) of string `str1` = 3
//      - `dp[0] = 1` (Base case: the empty subsequence)
//      - `lastOccurrence = {}` (Initial empty map for tracking last occurrence of characters)

//    - **First iteration (`i = 1`, `ch = 'a'`):**
//      - `dp[1] = 2 * dp[0] = 2 * 1 = 2` (Every subsequence can include or exclude 'a')
//      - `lastOccurrence = { 'a' : 1 }` (Update last occurrence of 'a')
     
//      **dp array:** `[1, 2]`

//    - **Second iteration (`i = 2`, `ch = 'b'`):**
//      - `dp[2] = 2 * dp[1] = 2 * 2 = 4` (Subsequences include or exclude 'b')
//      - `lastOccurrence = { 'a' : 1, 'b' : 2 }` (Update last occurrence of 'b')
     
//      **dp array:** `[1, 2, 4]`

//    - **Third iteration (`i = 3`, `ch = 'c'`):**
//      - `dp[3] = 2 * dp[2] = 2 * 4 = 8` (Subsequences include or exclude 'c')
//      - `lastOccurrence = { 'a' : 1, 'b' : 2, 'c' : 3 }` (Update last occurrence of 'c')
     
//      **dp array:** `[1, 2, 4, 8]`

//    - **Final result for `str1`:**
//      - `countDistinctSubsequences("abc") = dp[3] = 8`
//      - Distinct subsequences: `""`, `"a"`, `"b"`, `"c"`, `"ab"`, `"ac"`, `"bc"`, `"abc"`

// 2. **For `str2 = "aab"`:**
//    - **Initial setup:**
//      - Length (`n`) of string `str2` = 3
//      - `dp[0] = 1` (Base case: the empty subsequence)
//      - `lastOccurrence = {}`

//    - **First iteration (`i = 1`, `ch = 'a'`):**
//      - `dp[1] = 2 * dp[0] = 2 * 1 = 2`
//      - `lastOccurrence = { 'a' : 1 }`
     
//      **dp array:** `[1, 2]`

//    - **Second iteration (`i = 2`, `ch = 'a'`):**
//      - `dp[2] = 2 * dp[1] = 2 * 2 = 4`
//      - Since `'a'` occurred earlier at index 1, we subtract subsequences before that occurrence:
//        - `dp[2] -= dp[lastOccurrence.get('a') - 1] = 4 - dp[0] = 4 - 1 = 3`
//      - `lastOccurrence = { 'a' : 2 }`
     
//      **dp array:** `[1, 2, 3]`

//    - **Third iteration (`i = 3`, `ch = 'b'`):**
//      - `dp[3] = 2 * dp[2] = 2 * 3 = 6`
//      - `lastOccurrence = { 'a' : 2, 'b' : 3 }`
     
//      **dp array:** `[1, 2, 3, 6]`

//    - **Final result for `str2`:**
//      - `countDistinctSubsequences("aab") = dp[3] = 6`
//      - Distinct subsequences: `""`, `"a"`, `"b"`, `"aa"`, `"ab"`, `"aab"`

// ### Comparison:

// - `countDistinctSubsequences("abc") = 8`
// - `countDistinctSubsequences("aab") = 6`

// Since `abc` has more distinct subsequences than `aab`, the `betterString` function correctly returns `"abc"`.

// ### Debug Summary:

// The logic is working correctly based on the test case. The result will be:

// ```
// The better string is: abc
// ```

// This confirms that `"abc"` has more distinct subsequences than `"aab"`, and the function behaves as expected.