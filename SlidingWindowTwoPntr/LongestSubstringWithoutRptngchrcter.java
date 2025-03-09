package SlidingWindowTwoPntr;
// Brute Force
// Time Complexity: O( N2 )
// Space Complexity: O(N) 

// package SlidingWindowTwoPntr;
// import java.util.*;

// public class LongestSubstringWithoutRptngchrcter {
//     static int solve(String str) {
//         int maxans = 0; // Stores the maximum length found

//         // Outer loop: Start of the substring
//         for (int i = 0; i < str.length(); i++) {
//             Set<Character> seen = new HashSet<>(); // Set to store unique characters

//             // Inner loop: Expands substring from index `i`
//             for (int j = i; j < str.length(); j++) {
//                 // If character repeats, break out of loop
//                 if (seen.contains(str.charAt(j))) {
//                     break;
//                 }

//                 // Add character to the set
//                 seen.add(str.charAt(j));

//                 // Update the maximum length
//                 maxans = Math.max(maxans, j - i + 1);

//                 // Debugging: Print step-by-step execution
//                 // System.out.println("Checking substring: \"" + str.substring(i, j + 1) + "\"");
//                 // System.out.println("   i = "+ i + ", j = " + j);
//                 // System.out.println("   Unique characters so far: " + seen);
//                 // System.out.println("   Current max length: " + maxans);
//                 // System.out.println();
//             }
//         }

//         return maxans;
//     }

//     public static void main(String args[]) {
//         String str = "takeUforward";
//         System.out.println("The length of the longest substring without repeating characters is: " + solve(str));
//     }
// }
// Why j - i + 1?
// j - i + 1 represents the length of the current substring that we're considering.

// Explanation
// i is the starting index of the substring.
// j is the ending index of the substring.
// To calculate the length of a substring from index i to j, we use:
// Length=j−i+1
// because array indices start from 0.
// Example Walkthrough
// Let's say the input string is "takeUforward", and we are checking the substring "takeUforw".

// i = 0 (Start of substring at 't')
// j = 8 (End of substring at 'w')
// How many characters are in this substring?
// Index of 't' = 0
// Index of 'w' = 8
// Substring: "takeUforw"
// Using j - i + 1:
// 8−0+1=9
// ✔️ Correct! The substring has 9 characters.

// Without +1, What Happens?
// If we just do j - i, let's check:
// 8−0=8
// ❌ Incorrect! This would miss the last character in the count.



// ### **Step-by-step Execution**
// #### **i = 0 → Checking substrings starting from `"t"`**
// | **j** | **Substring Checked** | **Unique?** | **Max Length** |
// |------|---------------------|------------|-------------|
// | 0 | `"t"` | ✅ Yes | `1` |
// | 1 | `"ta"` | ✅ Yes | `2` |
// | 2 | `"tak"` | ✅ Yes | `3` |
// | 3 | `"take"` | ✅ Yes | `4` |
// | 4 | `"takeU"` | ✅ Yes | `5` |
// | 5 | `"takeUf"` | ✅ Yes | `6` |
// | 6 | `"takeUfo"` | ✅ Yes | `7` |
// | 7 | `"takeUfor"` | ✅ Yes | `8` |
// | 8 | `"takeUforw"` | ✅ Yes | `9` |
// | 9 | `"takeUforwa"` | ❌ No (repeats `'a'`) | **Stop** |

// #### **i = 1 → Checking substrings starting from `"a"`**
// | **j** | **Substring Checked** | **Unique?** | **Max Length** |
// |------|---------------------|------------|-------------|
// | 1 | `"a"` | ✅ Yes | `1` |
// | 2 | `"ak"` | ✅ Yes | `2` |
// | 3 | `"ake"` | ✅ Yes | `3` |
// | 4 | `"akeU"` | ✅ Yes | `4` |
// | 5 | `"akeUf"` | ✅ Yes | `5` |
// | 6 | `"akeUfo"` | ✅ Yes | `6` |
// | 7 | `"akeUfor"` | ✅ Yes | `7` |
// | 8 | `"akeUforw"` | ✅ Yes | `8` |
// | 9 | `"akeUforwa"` | ❌ No (repeats `'a'`) | **Stop** |

// #### **i = 2 → Checking substrings starting from `"k"`**
// | **j** | **Substring Checked** | **Unique?** | **Max Length** |
// |------|---------------------|------------|-------------|
// | 2 | `"k"` | ✅ Yes | `1` |
// | 3 | `"ke"` | ✅ Yes | `2` |
// | 4 | `"keU"` | ✅ Yes | `3` |
// | 5 | `"keUf"` | ✅ Yes | `4` |
// | 6 | `"keUfo"` | ✅ Yes | `5` |
// | 7 | `"keUfor"` | ✅ Yes | `6` |
// | 8 | `"keUforw"` | ✅ Yes | `7` |
// | 9 | `"keUforwa"` | ❌ No (repeats `'a'`) | **Stop** |


// ### **Final Output**
// The length of the longest substring without repeating characters is: 9






// Optimal  (Sliding Window)
// Time Complexity: O( N )
// Space Complexity: O(N) 

import java.util.*;

public class LongestSubstringWithoutRptngchrcter {
    static int solve(String str) {
        int start = 0, maxLength = 0;

        // HashMap to store the last index of each character
        Map<Character, Integer> map = new HashMap<>();

        // Iterate through the string
        for (int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);

            // If character is already seen, move start pointer ahead
            if (map.containsKey(ch)) {
                // Move start to avoid duplicate, but ensure it never moves backward
                start = Math.max(start, map.get(ch) + 1);
            }

            // Store the latest index of the character
            map.put(ch, end);

            // Calculate the current substring length and update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String args[]) {
        String str = "abba";
        System.out.println("The length of the longest substring without repeating characters is: " + solve(str));
    }
}

// Here's the **updated dry run for `"abba"`** with each step explained in detail without using a table:

// ---

// ### **Dry Run for `"abba"`**

// #### **Input:** `"abba"`
// We will use two pointers, `start` and `end`, along with a `map` to keep track of the last occurrence of each character.

// ---

// ### **Step-by-Step Execution**

// #### **Step 1: `end = 0`, `ch = 'a'`**
// - `'a'` is **not** in `map`, so we add it.
// - `map = {a: 0}` (stores `'a'` at index `0`).
// - The current window is `"a"` (from index `0` to `0`).
// - **`maxLength` is updated to `1`**.

// #### **Step 2: `end = 1`, `ch = 'b'`**
// - `'b'` is **not** in `map`, so we add it.
// - `map = {a: 0, b: 1}` (stores `'b'` at index `1`).
// - The current window is `"ab"` (from index `0` to `1`).
// - **`maxLength` is updated to `2`**.

// #### **Step 3: `end = 2`, `ch = 'b'` (Duplicate found!)**
// - `'b'` was already seen at index `1`, so we need to move `start`.
// - **Move `start` to `map.get('b') + 1 = 2`** (shift past the previous `'b'` occurrence).
// - Update `'b'` in `map = {a: 0, b: 2}` (now stores `'b'` at index `2`).
// - The current window is `"b"` (from index `2` to `2`).
// - **`maxLength` remains `2`** because `"b"` is smaller than `"ab"`.

// #### **Step 4: `end = 3`, `ch = 'a'` (Duplicate found!)**
// - `'a'` was already seen at index `0`, but since `start` is at `2`, we **do not** move it back.
// - Update `'a'` in `map = {a: 3, b: 2}` (now stores `'a'` at index `3`).
// - The current window is `"ba"` (from index `2` to `3`).
// - **`maxLength` remains `2`**.

// ---

// ### **Final Output**
// At the end of the iteration, the longest substring without repeating characters is **`"ab"` or `"ba"`, both of length `2`**.

// The length of the longest substring without repeating characters is: 2
// ```

