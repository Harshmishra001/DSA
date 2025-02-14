// * QN. aka    Substrings with K Distinct


// Given a string s of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

// Examples :

// Input: s = "aba", k = 2
// Output: 3
// Explanation: The substrings are: "ab", "ba" and "aba".
// Input: s = "abaaca", k = 1
// Output: 7
// Explanation: The substrings are: "a", "b", "a", "aa", "a", "c", "a".
// Input: s = "cdad", k = 4
// Output: 0

// **Time Complexity:** O(n²)  
// **Space Complexity:** O(k) (for the frequency map).
import java.util.HashMap;

public class CountNoOfSubstring {
    public int strCount(String s, int k) {
        int sum = 0; // Initialize the total count of substrings with exactly k distinct characters.

        // Outer loop: Iterate over each starting character in the string.
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> freqMap = new HashMap<>();
            // Initialize the frequency map to count occurrences of characters in the current substring.

            // Inner loop: Extend the substring starting from index i.
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j); // Current character in the substring.
                // Update the frequency map with the current character.
                freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);

                // Step 1: Count distinct characters in the current substring.
                int distinctCount = 0;
                for (int count : freqMap.values()) {
                    if (count > 0) {
                        distinctCount++; // Increment distinctCount for every unique character.
                    }
                }

                // Step 2: Check if the number of distinct characters matches k.
                if (distinctCount == k) {
                    sum++; // Increment sum if the condition is met.
                }
            }
        }
        
        return sum; // Return the total count of substrings.
    }

    public static void main(String[] args) {
        CountNoOfSubstring solution = new CountNoOfSubstring();
        String input = "aba";
        int k = 2;

        // Calculate the result.
        int result = solution.strCount(input, k);

        // Print the result.
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + result);

        
    }
}
// Let’s perform a **dry run** step-by-step for the input string `"aba"` with `k = 2`.

// ---

// ### Input:
// - **String:** `"aba"`  
// - **k:** `2`  
// - **Goal:** Count the number of substrings with exactly `k = 2` distinct characters.  

// ---

// ### Outer Loop and Inner Loop Breakdown:

// #### **Outer Loop (i = 0): Start with the first character `'a'`**
// 1. Initialize `freqMap = {}`.  
// 2. **Inner Loop (j = 0): Substring `"a"`**  
//    - Current character: `'a'`.  
//    - Update `freqMap`: `{a: 1}`.  
//    - **Distinct count:** `1` (only `'a'`).  
//    - Not counted because `distinctCount != k`.

// 3. **Inner Loop (j = 1): Substring `"ab"`**  
//    - Current character: `'b'`.  
//    - Update `freqMap`: `{a: 1, b: 1}`.  
//    - **Distinct count:** `2` (characters `'a'` and `'b'`).  
//    - **Counted!** Increment `sum = 1`.

// 4. **Inner Loop (j = 2): Substring `"aba"`**  
//    - Current character: `'a'`.  
//    - Update `freqMap`: `{a: 2, b: 1}`.  
//    - **Distinct count:** `2` (characters `'a'` and `'b'`).  
//    - **Counted!** Increment `sum = 2`.

// ---

// #### **Outer Loop (i = 1): Start with the second character `'b'`**
// 1. Initialize `freqMap = {}`.  
// 2. **Inner Loop (j = 1): Substring `"b"`**  
//    - Current character: `'b'`.  
//    - Update `freqMap`: `{b: 1}`.  
//    - **Distinct count:** `1` (only `'b'`).  
//    - Not counted because `distinctCount != k`.

// 3. **Inner Loop (j = 2): Substring `"ba"`**  
//    - Current character: `'a'`.  
//    - Update `freqMap`: `{b: 1, a: 1}`.  
//    - **Distinct count:** `2` (characters `'b'` and `'a'`).  
//    - **Counted!** Increment `sum = 3`.

// ---

// #### **Outer Loop (i = 2): Start with the third character `'a'`**
// 1. Initialize `freqMap = {}`.  
// 2. **Inner Loop (j = 2): Substring `"a"`**  
//    - Current character: `'a'`.  
//    - Update `freqMap`: `{a: 1}`.  
//    - **Distinct count:** `1` (only `'a'`).  
//    - Not counted because `distinctCount != k`.

// ---

// ### **Final Count**
// - **Total substrings with exactly `k = 2` distinct characters:** `3`.

// ---

// ### Walkthrough Summary:
// | **i** | **j** | **Substring** | **Distinct Characters** | **Counted?** | **Sum** |
// |-------|-------|---------------|--------------------------|--------------|---------|
// | 0     | 0     | `"a"`         | 1                        | No           | 0       |
// | 0     | 1     | `"ab"`        | 2                        | Yes          | 1       |
// | 0     | 2     | `"aba"`       | 2                        | Yes          | 2       |
// | 1     | 1     | `"b"`         | 1                        | No           | 2       |
// | 1     | 2     | `"ba"`        | 2                        | Yes          | 3       |
// | 2     | 2     | `"a"`         | 1                        | No           | 3       |

// ---

// ### Output:
// The program will output:  
// **`Number of substrings with exactly 2 distinct characters: 3`**.