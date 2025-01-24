// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of 
// characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:
// Input: s = "egg", t = "add"
// Output: true
// Explanation:
// The strings s and t can be made identical by:
// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.

// Example 2:
// Input: s = "foo", t = "bar"
// Output: false
// Explanation:
// The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

// Example 3:
// Input: s = "paper", t = "title"
// Output: true
// Mapping 'p' to 't'.
// Mapping 'a' to 'i'.
// Mapping 'p' to 't'.
// Mapping 'e' to 'l'.
// Mapping 'r' to 'e'.

// Time Complexity (TC):
// O(n), where n is the length of the strings. We iterate through the strings once.
// Space Complexity (SC):
// O(1), as the size of the arrays arr1 and arr2 is fixed (256 elements), regardless of the length of the input strings.

public class IsomorphicString {
     public static boolean isIsomorphic(String s, String t) {
      // Arrays to store the mappings of characters
      int[] arr1 = new int[256]; // For string s
      int[] arr2 = new int[256]; // For string t
      
      // Iterate over both strings character by character
      for (int i = 0; i < s.length(); i++) {
          // If the current characters are not mapping to the same positions, return false
          if (arr1[s.charAt(i)] != arr2[t.charAt(i)]) {
              return false;
          }
          
          // Map the current character positions in both strings
          arr1[s.charAt(i)] = i + 1; // Using i+1 to ensure position is not zero (for uninitialized)
          arr2[t.charAt(i)] = i + 1;
      }
      
      // If we reach here, it means the strings are isomorphic
      return true;
  }

  public static void main(String[] args) {
      // Test case
      String s = "paper";
      String t = "title";

      // Checking if the strings are isomorphic
      if (isIsomorphic(s, t)) {
          System.out.println("Strings are isomorphic!");
      } else {
          System.out.println("Strings are not isomorphic!");
      }
  }

}


   

