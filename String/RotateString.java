// Given two strings s and goal, return true if and only if s can become goal after some
//  number of shifts on s.

// A shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.
 

// Example 1:

// Input: s = "abcde", goal = "cdeab"
// Output: true
// Example 2:

// Input: s = "abcde", goal = "abced"
// Output: false




// optimal

// Time Complexity:
//  O(n).

// Space Complexity:
//  O(n).
public class RotateString {

    // Method to check if 'goal' is a rotation of string 's'
    public boolean rotateString(String s, String goal) {
        // If lengths are different, 'goal' can't be a rotation of 's'
        if (s.length() != goal.length()) {
            return false;
        }

        // Create a temporary string by concatenating 's' with itself
        String temp = s + s;

        // Check if 'goal' is a substring of 'temp'
        return temp.contains(goal);
    }

    public static void main(String[] args) {
        // Create an instance of RotateString
        RotateString rs = new RotateString();

        // Test case 1: s = "abcde", goal = "cdeab"
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println(rs.rotateString(s1, goal1)); // Expected output: true

        // Test case 2: s = "abcde", goal = "abced"
        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println(rs.rotateString(s2, goal2)); // Expected output: false
    }
}


// ### Dry Run:
// #### Test case 1: `s = "abcde"`, `goal = "cdeab"`
// - The lengths of both strings are equal, so we proceed.
// - We create `temp = s + s = "abcdeabcde"`.
// - We check if `goal` ("cdeab") is a substring of `temp`.
// - `"cdeab"` is a substring of `"abcdeabcde"`, so the method returns `true`.

// #### Test case 2: `s = "abcde"`, `goal = "abced"`
// - The lengths of both strings are equal, so we proceed.
// - We create `temp = s + s = "abcdeabcde"`.
// - We check if `goal` ("abced") is a substring of `temp`.
// - `"abced"` is not a substring of `"abcdeabcde"`, so the method returns `false`.

