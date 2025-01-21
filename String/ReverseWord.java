
// * ALSO KNONE AS PALINDROME QN.

// Problem Statement: Given a string s, reverse the words of the string.

// Examples:

// Example 1:
// Input: s=”this is an amazing program”
// Output: “program amazing an is this”

// Example 2:
// Input: s=”This is decent”
// Output: “decent is This”


// Final Complexity:
// Time Complexity (TC): O(n), where n is the length of the input string.
// Space Complexity (SC): O(n), due to the space used by the ans and temp StringBuilder objects.

public class ReverseWord {

    // Method to reverse a string (StringBuilder) in-place
    public static void reverseString(StringBuilder str) {
        int start = 0;
        int end = str.length() - 1;
        
        // Reverse the string by swapping characters from start and end
        while (start < end) {
            // Temporary variable to hold the character at start position
            char temp = str.charAt(start);
            
            // Swap characters between start and end
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, temp);
            
            // Move the start pointer forward and the end pointer backward
            start++;
            end--;
        }
    }

    // Method to reverse the words in a given string
    public static String reverseWords(String str) {
        // StringBuilder to hold the final result with reversed words
        StringBuilder ans = new StringBuilder();
        
        // StringBuilder to temporarily hold each word while processing
        StringBuilder temp = new StringBuilder();
        
        // Loop through the string in reverse order (starting from the end)
        for (int i = str.length() - 1; i >= 0; i--) {
            // If the current character is a space and the temporary word is empty, continue to next character
            if (str.charAt(i) == ' ' && temp.length() == 0) {
                continue; // Skip leading spaces between words
            } 
            // If the current character is a space and the temporary word has characters, reverse it and add to the result
            else if (str.charAt(i) == ' ') {
                // Reverse the word in the 'temp' StringBuilder
                reverseString(temp);
                
                // Append the reversed word to the result and add a space after it
                ans.append(temp).append(" ");
                
                // Clear the 'temp' StringBuilder to hold the next word
                temp.setLength(0);
            } else {
                // If it's not a space, keep appending the character to 'temp' to form a word
                temp.append(str.charAt(i));
            }
        }

        // After the loop, 'temp' contains the last word which is not yet added to 'ans'
        reverseString(temp);
        ans.append(temp);

        // Remove any trailing space from 'ans' (if it exists)
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') {
            ans.deleteCharAt(ans.length() - 1);
        }

        // Return the final string with reversed words
        return ans.toString();
    }

    public static void main(String[] args) {
        // Input string to be processed
        String input = "hello world";
        
        // Call the method to reverse words in the input string
        String result = reverseWords(input);
        
        // Output the result
        System.out.println(result); // Output: "world hello"
    }
}



// ### Input:
// ```
// "  hello world  "
// ```

// ### Initialization:
// 1. `ans = ""` (empty StringBuilder to store the final result)
// 2. `temp = ""` (empty StringBuilder to store the current word being processed)

// ---

// ### Loop (Iterating through the string from the last character to the first):

// We start with `i = 14` (last index of the string).

// ---

// ### Iteration 1 (`i = 14`):
// - `str.charAt(14) = ' '`
// - It's a space, but `temp` is empty (no word yet). So, continue to the next character.

// ---

// ### Iteration 2 (`i = 13`):
// - `str.charAt(13) = ' '`
// - It's a space again, and `temp` is still empty. So, continue to the next character.

// ---

// ### Iteration 3 (`i = 12`):
// - `str.charAt(12) = 'd'`
// - Since it's not a space, append `'d'` to `temp`:  
//   `temp = "d"`

// ---

// ### Iteration 4 (`i = 11`):
// - `str.charAt(11) = 'l'`
// - Since it's not a space, append `'l'` to `temp`:  
//   `temp = "dl"`

// ---

// ### Iteration 5 (`i = 10`):
// - `str.charAt(10) = 'r'`
// - Since it's not a space, append `'r'` to `temp`:  
//   `temp = "dlr"`

// ---

// ### Iteration 6 (`i = 9`):
// - `str.charAt(9) = 'o'`
// - Since it's not a space, append `'o'` to `temp`:  
//   `temp = "dlro"`

// ---

// ### Iteration 7 (`i = 8`):
// - `str.charAt(8) = 'w'`
// - Since it's not a space, append `'w'` to `temp`:  
//   `temp = "dlrow"`

// ---

// ### Iteration 8 (`i = 7`):
// - `str.charAt(7) = ' '`
// - Since it's a space, and `temp` contains `"dlrow"`, reverse the word in `temp`:
//   - Call `reverseString(temp)`:
//     - `temp = "dlrow"` → reversed to `"world"`
//   - Append the reversed word `"world"` followed by a space to `ans`:
//     - `ans = "world "`
//   - Clear `temp` to start processing the next word:
//     - `temp = ""`

// ---

// ### Iteration 9 (`i = 6`):
// - `str.charAt(6) = 'o'`
// - Since it's not a space, append `'o'` to `temp`:  
//   `temp = "o"`

// ---

// ### Iteration 10 (`i = 5`):
// - `str.charAt(5) = 'l'`
// - Since it's not a space, append `'l'` to `temp`:  
//   `temp = "ol"`

// ---

// ### Iteration 11 (`i = 4`):
// - `str.charAt(4) = 'l'`
// - Since it's not a space, append `'l'` to `temp`:  
//   `temp = "oll"`

// ---

// ### Iteration 12 (`i = 3`):
// - `str.charAt(3) = 'e'`
// - Since it's not a space, append `'e'` to `temp`:  
//   `temp = "olle"`

// ---

// ### Iteration 13 (`i = 2`):
// - `str.charAt(2) = 'h'`
// - Since it's not a space, append `'h'` to `temp`:  
//   `temp = "olleh"`

// ---

// ### Iteration 14 (`i = 1`):
// - `str.charAt(1) = ' '`
// - Since it's a space, and `temp` contains `"olleh"`, reverse the word in `temp`:
//   - Call `reverseString(temp)`:
//     - `temp = "olleh"` → reversed to `"hello"`
//   - Append the reversed word `"hello"` followed by a space to `ans`:
//     - `ans = "world hello "`
//   - Clear `temp` to start processing the next word:
//     - `temp = ""`


// End of Loop:
// The loop has finished iterating through the string. Now, temp is empty and no word is left to reverse.

// Final Cleanup:
// The final result stored in ans is "world hello ", but there is a trailing space.

// Remove the trailing space from ans:
// ans.deleteCharAt(ans.length() - 1)
// After removing the trailing space, ans = "world hello"

// Final Output:
// "world hello"
