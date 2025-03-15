package SlidingWindowTwoPntr;

public class LongestRepeatingCharacterReplacement {

    /*
    Time Complexity (TC): O(N)
    - Each character is processed at most twice (once when right expands, once when left shrinks).
    - O(N) in worst case.

    Space Complexity (SC): O(1)
    - Uses a fixed-size array `freq[26]`, independent of input size.
    */

    int characterReplacement(String s, int k) {
        
        int[] freq = new int[26]; // Frequency array for A-Z
        int left = 0; // Left pointer
        int maxFreq = 0; // Maximum frequency of any character in the window
        int maxWindow = 0; // Stores the maximum valid window length

        // Iterate with right pointer over the string
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right); // Current character 
            freq[currChar - 'A']++; // Increase frequency count

            // Update maxFreq with the highest frequency character in the window
            maxFreq = Math.max(maxFreq, freq[currChar - 'A']);

            int windowLength = right - left + 1; // Current window length

            // If non-dominant characters (windowLength - maxFreq) exceed k, shrink window
            if (windowLength - maxFreq > k) {
                // Remove leftmost character from frequency count
                freq[s.charAt(left) - 'A']--;
                left++; // Move left pointer to reduce window size
            }

            // Update the max window length
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow; // Maximum valid window length
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();

        // Example test cases
        System.out.println("Final Answer: " + solution.characterReplacement("AABABBA", 1)); // Output: 4
        System.out.println("Final Answer: " + solution.characterReplacement("ABAB", 2));    // Output: 4
        System.out.println("Final Answer: " + solution.characterReplacement("AABCABB", 2)); // Output: 5
    }
}

// 🔹 Given Input
// s = "AABABBA", k = 1

// 🔹 Initial Setup
// Variable	Value	Description
// left	0	Left pointer (start of the window)
// right	0	Right pointer (expanding the window)
// maxFreq	0	Tracks max occurrences of a character in the window
// maxWindow	0	Stores the longest valid window size
// freq[]	[0,0,0,...,0]	Frequency array of 26 letters

// 🔷 Step-by-Step Execution
// I'll show each iteration, how variables update, and why we make certain decisions.

// 🟢 Iteration 1: (right = 0, s[right] = 'A')
// Update freq['A'] → freq['A'] = 1
// Update maxFreq → maxFreq = 1 (highest frequency in window)
// Compute windowLength = right - left + 1 = 0 - 0 + 1 = 1
// Check Validity: windowLength - maxFreq = 1 - 1 = 0 ≤ k ✅ → Window is valid.
// Update maxWindow = max(0, 1) = 1
// Move Right Pointer to 1
// 🟢 Iteration 2: (right = 1, s[right] = 'A')
// Update freq['A'] → freq['A'] = 2
// Update maxFreq → maxFreq = 2
// Compute windowLength = right - left + 1 = 1 - 0 + 1 = 2
// Check Validity: windowLength - maxFreq = 2 - 2 = 0 ≤ k ✅
// Update maxWindow = max(1, 2) = 2
// Move Right Pointer to 2
// 🟢 Iteration 3: (right = 2, s[right] = 'B')
// Update freq['B'] → freq['B'] = 1
// maxFreq remains 2 (since 'A' is still the most frequent)
// Compute windowLength = right - left + 1 = 2 - 0 + 1 = 3
// Check Validity: windowLength - maxFreq = 3 - 2 = 1 ≤ k ✅
// Update maxWindow = max(2, 3) = 3
// Move Right Pointer to 3
// 🟢 Iteration 4: (right = 3, s[right] = 'A')
// Update freq['A'] → freq['A'] = 3
// Update maxFreq → maxFreq = 3
// Compute windowLength = right - left + 1 = 3 - 0 + 1 = 4
// Check Validity: windowLength - maxFreq = 4 - 3 = 1 ≤ k ✅
// Update maxWindow = max(3, 4) = 4
// Move Right Pointer to 4
// 🟢 Iteration 5: (right = 4, s[right] = 'B')
// Update freq['B'] → freq['B'] = 2
// maxFreq remains 3
// Compute windowLength = right - left + 1 = 4 - 0 + 1 = 5
// Check Validity: windowLength - maxFreq = 5 - 3 = 2 > k ❌ (invalid window)
// We need to shrink the window from the left:
// Remove s[left] = 'A', so freq['A'] = 2
// Move Left Pointer to 1
// Compute new windowLength = right - left + 1 = 4 - 1 + 1 = 4
// maxWindow remains 4
// Move Right Pointer to 5
// 🟢 Iteration 6: (right = 5, s[right] = 'B')
// Update freq['B'] → freq['B'] = 3
// maxFreq remains 3
// Compute windowLength = right - left + 1 = 5 - 1 + 1 = 5
// Check Validity: windowLength - maxFreq = 5 - 3 = 2 > k ❌
// Shrink Window:
// Remove s[left] = 'A', so freq['A'] = 1
// Move Left Pointer to 2
// Compute new windowLength = right - left + 1 = 5 - 2 + 1 = 4
// maxWindow remains 4
// Move Right Pointer to 6
// 🟢 Iteration 7: (right = 6, s[right] = 'A')
// Update freq['A'] → freq['A'] = 2
// maxFreq remains 3
// Compute windowLength = right - left + 1 = 6 - 2 + 1 = 5
// Check Validity: windowLength - maxFreq = 5 - 3 = 2 > k ❌
// Shrink Window:
// Remove s[left] = 'B', so freq['B'] = 2
// Move Left Pointer to 3
// Compute new windowLength = right - left + 1 = 6 - 3 + 1 = 4
// maxWindow remains 4
// End of Loop (since right = s.length() - 1)
// 🔹 Final Output
// maxWindow = 4

// Final Answer: 4

