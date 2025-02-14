// **Time Complexity**: (O(n^3)) (nested loops and \(O(n)\) palindrome check).  
// **Space Complexity**: (O(1)) (no extra space used).

// Given a string s, return the longest 
// palindromic
 
// substring
//  in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"
 

// *solved without dp

class LongestPalindromicSubstring {
    int max = 0, start = 0, end = 0;

    // Method to check if a substring is a palindrome
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 != ch2)
                return false;
            i++;
            j--;
        }
        return true;
    }

    // Method to find the longest palindromic substring
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if ((j - i + 1) > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    // Main method for testing
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "babad"; // Example input string
        String result = lps.longestPalindrome(s);
        System.out.println("The longest palindromic substring of \"" + s + "\" is: \"" + result + "\"");
    }
}
// Dry Run for Input s = "babad"
// Initialization:

// max = 0, start = 0, end = 0.
// Outer Loop (i from 0 to 4):

// For i = 0, inner loop (j from 0 to 4):

// Substring "b" (i = 0, j = 0): Palindrome → max = 1, start = 0, end = 0.
// Substring "ba" (i = 0, j = 1): Not a palindrome.
// Substring "bab" (i = 0, j = 2): Palindrome → max = 3, start = 0, end = 2.
// Substring "baba" (i = 0, j = 3): Not a palindrome.
// Substring "babad" (i = 0, j = 4): Not a palindrome.
// For i = 1, inner loop (j from 1 to 4):

// Substring "a" (i = 1, j = 1): Palindrome → max remains 3.
// Substring "ab" (i = 1, j = 2): Not a palindrome.
// Substring "aba" (i = 1, j = 3): Palindrome → max = 3, start = 1, end = 3.
// Substring "abad" (i = 1, j = 4): Not a palindrome.
// For i = 2, inner loop (j from 2 to 4):

// Substring "b" (i = 2, j = 2): Palindrome → max remains 3.
// Substring "ba" (i = 2, j = 3): Not a palindrome.
// Substring "bad" (i = 2, j = 4): Not a palindrome.
// For i = 3, inner loop (j from 3 to 4):

// Substring "a" (i = 3, j = 3): Palindrome → max remains 3.
// Substring "ad" (i = 3, j = 4): Not a palindrome.
// For i = 4, inner loop (j = 4):

// Substring "d" (i = 4, j = 4): Palindrome → max remains 3.
// Final Output: Substring "aba" or "bab" (either can be valid).