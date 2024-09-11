import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(2^n)  
// Space Complexity: O(n * 2^n)

class GenerateAllBinaryString {
  // List to store the final results
  static List<String> result = new ArrayList<>();
  
  // Function to generate binary strings of length n
  public static List<String> generateBinaryStrings(int n) {
    // Reset the result list for each call
    result = new ArrayList<>();
    
    // Initialize a word starting with '0'
    String word = "";
    word = "0";  // First case starting with '0'
    generateBinaryStringsHelper(word, n);  // Recursive helper function
    
    // Initialize a word starting with '1'
    word = "1";  // Second case starting with '1'
    generateBinaryStringsHelper(word, n);  // Recursive helper function
    
    return result;
  }
  
  // Helper function to generate binary strings based on the last character
  public static void generateBinaryStringsHelper(String word, int n) {
    int len = word.length();  // Get the current length of the string
    
    // Base case: if the length matches the desired length n, add to result
    if(n == len){
        result.add(word);  // Add the complete string to the result
        return;
    } 
    // If the last character is '1', only '0' can follow
    else if (word.charAt(len - 1) == '1') {
        generateBinaryStringsHelper(word + '0', n);  // Add '0' and recurse
    } 
    // If the last character is '0', both '0' and '1' can follow
    else {
        generateBinaryStringsHelper(word + '0', n);  // Add '0' and recurse
        generateBinaryStringsHelper(word + '1', n);  // Add '1' and recurse
    }
  }
  
  public static void main(String[] args) {
    int testN = 3;  // Example test case with n = 3
    List<String> result = generateBinaryStrings(testN);
    
    // Debugging: Print the result for the test case
    System.out.println("Generated binary strings for n = " + testN + ": " + result);
  }
}

// Initial Setup:

// Input: n = 3
// We call generateBinaryStrings(3), which initializes the result list and starts the first recursive calls with the binary string "0" and "1".
// Step-by-Step Execution:
// Step 1: Start with "0"
// Call generateBinaryStringsHelper("0", 3):
// Length of "0" is 1, less than 3.
// Last character is '0', so we can append both '0' and '1'.
// Step 1.1: Append "0" to "0"
// Call generateBinaryStringsHelper("00", 3):
// Length of "00" is 2, less than 3.
// Last character is '0', so we can append both '0' and '1'.
// Step 1.1.1: Append "0" to "00"
// Call generateBinaryStringsHelper("000", 3):
// Length of "000" is 3, equal to n, so we add "000" to the result.
// Step 1.1.2: Append "1" to "00"
// Call generateBinaryStringsHelper("001", 3):
// Length of "001" is 3, equal to n, so we add "001" to the result.
// Step 1.2: Append "1" to "0"
// Call generateBinaryStringsHelper("01", 3):
// Length of "01" is 2, less than 3.
// Last character is '1', so we can only append '0'.
// Step 1.2.1: Append "0" to "01"
// Call generateBinaryStringsHelper("010", 3):
// Length of "010" is 3, equal to n, so we add "010" to the result.
// Step 2: Start with "1"
// Call generateBinaryStringsHelper("1", 3):
// Length of "1" is 1, less than 3.
// Last character is '1', so we can only append '0'.
// Step 2.1: Append "0" to "1"
// Call generateBinaryStringsHelper("10", 3):
// Length of "10" is 2, less than 3.
// Last character is '0', so we can append both '0' and '1'.
// Step 2.1.1: Append "0" to "10"
// Call generateBinaryStringsHelper("100", 3):
// Length of "100" is 3, equal to n, so we add "100" to the result.
// Step 2.1.2: Append "1" to "10"
// Call generateBinaryStringsHelper("101", 3):
// Length of "101" is 3, equal to n, so we add "101" to the result.
// Final Result:
// At the end of all recursive calls, the result list contains the following binary strings:


// ["000", "001", "010", "100", "101"]
// These strings are the binary strings of length 3 where no two consecutive '1's appear.

// Summary of Recursive Calls:

// generateBinaryStringsHelper("0", 3):
// Calls for "00", which generates "000" and "001".
// Calls for "01", which generates "010".
// generateBinaryStringsHelper("1", 3):
// Calls for "10", which generates "100" and "101".
// The strings are added to the result list in the following order:

// "000", "001", "010", "100", "101".
// This matches the expected output for n = 3.

