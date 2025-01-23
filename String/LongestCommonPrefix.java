
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.



// Brute force 

// Time Complexity (TC): O(n log n * m)
// Space Complexity (SC): O(n + m)

// import java.util.Arrays;

// public class LongestCommonPrefix {

//     // Method to find the longest common prefix in an array of strings
//     public String longestCommonPrefix(String[] strs) {

//         // Initialize a StringBuilder to store the result
//         StringBuilder result = new StringBuilder();

//         // Edge case: if the input array is empty, return an empty string
//         if (strs == null || strs.length == 0) {
//             return "";
//         }

//         // Sort the array of strings
//         Arrays.sort(strs);

//         // Convert the first and the last strings to character arrays
//         char[] first = strs[0].toCharArray();
//         char[] last = strs[strs.length - 1].toCharArray();

//         // Compare the first and last strings character by character
//         for (int i = 0; i < first.length; i++) {
//             // If characters at the same position in both strings are not equal, break the loop
//             if (first[i] != last[i]) {
//                 break;
//             }
//             // Append the matching character to the result
//             result.append(first[i]);
//         }

//         // Return the common prefix as a string
//         return result.toString();
//     }

//     // Main method to test the function
//     public static void main(String[] args) {
//         LongestCommonPrefix solution = new LongestCommonPrefix();

//         // Test case 1: Common prefix is "fl"
//         String[] strs1 = {"flower", "flow", "flight"};
//         System.out.println(solution.longestCommonPrefix(strs1));  // Output: "fl"

//         // Test case 2: No common prefix
//         String[] strs2 = {"dog", "racecar", "car"};
//         System.out.println(solution.longestCommonPrefix(strs2));  // Output: ""

//         // Test case 3: Common prefix is "a"
//         String[] strs3 = {"apple", "ape", "april"};
//         System.out.println(solution.longestCommonPrefix(strs3));  // Output: "ap"

//         // Test case 4: Common prefix is "inter"
//         String[] strs4 = {"internet", "internal", "interval"};
//         System.out.println(solution.longestCommonPrefix(strs4));  // Output: "inter"

//         // Test case 5: Single string, return the string itself
//         String[] strs5 = {"hello"};
//         System.out.println(solution.longestCommonPrefix(strs5));  // Output: "hello"
        
//         // Dry Run for test case 1: ["flower", "flow", "flight"]
//         // 1. Sort the array: ["flight", "flower", "flow"]
//         // 2. Compare the first string "flight" and the last string "flow"
//         //    Compare character by character:
//         //    - 'f' == 'f', add 'f' to result
//         //    - 'l' == 'l', add 'l' to result
//         //    - 'i' != 'o', break the loop
//         // 3. Result is "fl"
//     }
// }




// Optimal Approach

//  O(n * m) and O(n)
import java.util.*;

public class LongestCommonPrefix{

    // Function to find the longest common prefix
    public static String longestCommonPrefix(List<String> strs) {
        String ans = "";  // Initialize an empty string to store the common prefix
        
        // Iterate over each character of the first string
        for (int i = 0; i < strs.get(0).length(); i++) {
            // Check each string in the list for the character at the same position
            for (String s : strs) {
                // If the character at the current position doesn't match, return the current result
                if (s.charAt(i) != strs.get(0).charAt(i)) {
                    return ans;
                }
            }
            // If all strings match, append the character to the answer string
            ans += strs.get(0).charAt(i);
        }
        return ans;  // Return the common prefix found
    }

    public static void main(String[] args) {
        // Test case
        List<String> strs = Arrays.asList("flower", "flow", "floght");
        
        // Calling the function to get the longest common prefix
        String result = longestCommonPrefix(strs);
        
        // Printing the result
        System.out.println("Longest Common Prefix: " + result);
    }
}

/* Dry Run:
Test case: strs = ["flower", "flow", "floght"]

Step-by-step:

1. Start with the first character of the first string (index 0), which is 'f'.
    - Compare 'f' with the first character of all other strings.
    - 'f' == 'f' in "flower", 'f' == 'f' in "flow", 'f' == 'f' in "floght".
    - All match, so we add 'f' to the result.

2. Move to the next character (index 1), which is 'l'.
    - Compare 'l' with the second character of all other strings.
    - 'l' == 'l' in "flower", 'l' == 'l' in "flow", 'l' == 'l' in "floght".
    - All match, so we add 'l' to the result.

3. Move to the next character (index 2), which is 'o'.
    - Compare 'o' with the third character of all other strings.
    - 'o' == 'o' in "flower", 'o' == 'o' in "flow", 'o' == 'o' in "floght".
    - All match, so we add 'o' to the result.

4. Move to the next character (index 3), which is 'w'.
    - Compare 'w' with the fourth character of all other strings.
    - 'w' == 'w' in "flower", 'w' == 'w' in "flow", 'w' != 'g' in "floght".
    - Mismatch found at "floght", so the function returns the current result, which is "flo".

5. Final Result: The longest common prefix is "flo".
*/


