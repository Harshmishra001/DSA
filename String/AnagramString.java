// Problem Statement: Given two strings, check if two strings are anagrams of each other or not.

// Examples:

// Example 1:
// Input: CAT, ACT
// Output: true
// Explanation: Since the count of every letter of both strings are equal.

// Example 2:
// Input: RULES, LESRT 
// Output: false
// Explanation: Since the count of U and T  is not equal in both strings.




//Brute Soltn

// Time Complexity (TC):(O(n log n)), where ( n) is the length of the strings, due to sorting.  
// Space Complexity (SC):(O(n)), for storing the character arrays.

// import java.util.*;
// public class AnagramString {
//     /**
//      * Checks if two strings are anagrams of each other.
//      * An anagram means the strings have the same characters in the same frequency,
//      * but possibly in a different order.
//      *
//      * @param s First string
//      * @param t Second string
//      * @return true if s and t are anagrams, false otherwise
//      */
//     public static boolean isAnagram(String s, String t) {
//         // If lengths are different, they cannot be anagrams
//         if (s.length() != t.length()) return false;

//         // Convert strings to character arrays and sort them
//         char[] sArray = s.toCharArray();
//         char[] tArray = t.toCharArray();
//         Arrays.sort(sArray);
//         Arrays.sort(tArray);

//         // Compare sorted arrays
//         return Arrays.equals(sArray, tArray);
//     }

//     public static void main(String[] args) {
//         // Test cases for the isAnagram function
//         String str1 = "listen";
//         String str2 = "silent";

//         // Checking if str1 and str2 are anagrams
//         if (isAnagram(str1, str2)) {
//             System.out.println(str1 + " and " + str2 + " are anagrams.");
//         } else {
//             System.out.println(str1 + " and " + str2 + " are not anagrams.");
//         }

//         // Additional test case
//         String str3 = "hello";
//         String str4 = "world";

//         if (isAnagram(str3, str4)) {
//             System.out.println(str3 + " and " + str4 + " are anagrams.");
//         } else {
//             System.out.println(str3 + " and " + str4 + " are not anagrams.");
//         }
//     }

    /**
     * Dry Run:
     * Input: str1 = "listen", str2 = "silent"
     * Step 1: Check lengths of str1 and str2: Both have length 6 (Equal).
     * Step 2: Convert to character arrays: sArray = ['l', 'i', 's', 't', 'e', 'n'], tArray = ['s', 'i', 'l', 'e', 'n', 't']
     * Step 3: Sort arrays: 
     *          sArray = ['e', 'i', 'l', 'n', 's', 't']
     *          tArray = ['e', 'i', 'l', 'n', 's', 't']
     * Step 4: Compare sorted arrays: Arrays are equal, so str1 and str2 are anagrams.
     * Output: "listen and silent are anagrams."
     *
     * Input: str3 = "hello", str4 = "world"
     * Step 1: Check lengths of str3 and str4: Both have length 5 (Equal).
     * Step 2: Convert to character arrays: sArray = ['h', 'e', 'l', 'l', 'o'], tArray = ['w', 'o', 'r', 'l', 'd']
     * Step 3: Sort arrays: 
     *          sArray = ['e', 'h', 'l', 'l', 'o']
     *          tArray = ['d', 'l', 'o', 'r', 'w']
     * Step 4: Compare sorted arrays: Arrays are not equal, so str3 and str4 are not anagrams.
     * Output: "hello and world are not anagrams."
     */

// }


public class AnagramString {

    /**
     * Optimal approach to check if two strings are anagrams.
     * Uses a fixed-size frequency array for characters, achieving O(n) time and O(1) space.
     *
     * @param s First string
     * @param t Second string
     * @return true if s and t are anagrams, false otherwise
     */
    public static boolean isAnagram2(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) return false;

        // Frequency array to track character counts (assuming lowercase a-z)
        int[] freq = new int[26];

        // Increment for characters in s and decrement for characters in t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // Check if all counts in the frequency array are zero
        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases for the isAnagram2 function
        String str1 = "listen";
        String str2 = "silent";

        if (isAnagram2(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }

        // Additional test case
        String str3 = "hello";
        String str4 = "world";

        if (isAnagram2(str3, str4)) {
            System.out.println(str3 + " and " + str4 + " are anagrams.");
        } else {
            System.out.println(str3 + " and " + str4 + " are not anagrams.");
        }
    }

    /**
     * Dry Run:
     * Input: s = "listen", t = "silent"
     * 
     * Initial Step:
     * - Lengths of s and t: Both are 6 (Equal).
     * - Initialize frequency array: freq = [0, 0, 0, ..., 0] (26 zeros).
     * 
     * Step-by-Step Iteration:
     * 
     * i = 0:
     * - s[0] = 'l', t[0] = 's'
     * - freq['l' - 'a']++ → freq[11] = 1
     * - freq['s' - 'a']-- → freq[18] = -1
     * 
     * i = 1:
     * - s[1] = 'i', t[1] = 'i'
     * - freq['i' - 'a']++ → freq[8] = 1
     * - freq['i' - 'a']-- → freq[8] = 0
     * 
     * i = 2:
     * - s[2] = 's', t[2] = 'l'
     * - freq['s' - 'a']++ → freq[18] = 0
     * - freq['l' - 'a']-- → freq[11] = 0
     * 
     * i = 3:
     * - s[3] = 't', t[3] = 'e'
     * - freq['t' - 'a']++ → freq[19] = 1
     * - freq['e' - 'a']-- → freq[4] = -1
     * 
     * i = 4:
     * - s[4] = 'e', t[4] = 'n'
     * - freq['e' - 'a']++ → freq[4] = 0
     * - freq['n' - 'a']-- → freq[13] = -1
     * 
     * i = 5:
     * - s[5] = 'n', t[5] = 't'
     * - freq['n' - 'a']++ → freq[13] = 0
     * - freq['t' - 'a']-- → freq[19] = 0
     * 
     * Final Step:
     * - Check the freq array: All elements are 0.
     * 
     * Output: "listen and silent are anagrams."
     */
}
