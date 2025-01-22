// You are given a string num, representing a large integer. Return the largest-valued odd integer
//  (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

// A substring is a contiguous sequence of characters within a string.

// Example 1:

// Input: num = "52"
// Output: "5"
// Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
// Example 2:

// Input: num = "4206"
// Output: ""
// Explanation: There are no odd numbers in "4206".
// Example 3:

// Input: num = "35427"
// Output: "35427"
// Explanation: "35427" is already an odd number.



class LargestOddNo {
    
    public String largestOddNumber(String num) {
        // Start from the last character of the string
        int i = num.length() - 1;
        
        // Loop through the string from the end to the beginning
        while (i >= 0) {
            // Get the character at index i and convert it to an integer
            int n = num.charAt(i) - '0';  // Subtract '0' to convert char to int
            
            // Check if the character corresponds to an odd number
            if (n % 2 == 1) {
                // If odd, return the substring from the start to this index (inclusive)
                return num.substring(0, i + 1);
            }
            i--;  // Move to the next character towards the left
        }
        
        // Return an empty string if no odd number was found
        return "";
    }
    
    // Main method to test the function
    public static void main(String[] args) {
        LargestOddNo solution = new LargestOddNo();
        
        // Test case 1: Example where the largest odd number is "5"
        System.out.println(solution.largestOddNumber("52"));  // Output: "5"
        
        // Test case 2: Example where no odd number exists
        System.out.println(solution.largestOddNumber("4206"));  // Output: ""
        
        // Test case 3: Example where the entire number is already odd
        System.out.println(solution.largestOddNumber("35427"));  // Output: "35427"
        
        // Dry Run for input "52":
        // Let's perform a dry run for the input "52":
        
        // i = num.length() - 1 = 2 - 1 = 1 (Starting from the last character)
        // num.charAt(1) = '2'  
        // n = '2' - '0' = 2  
        // 2 % 2 == 0, so it's not an odd number. We move to the previous character.
        
        // Now, i = 0 (moving left)
        // num.charAt(0) = '5'  
        // n = '5' - '0' = 5  
        // 5 % 2 == 1, which means 5 is odd.
        
        // Since we found an odd number, return the substring from index 0 to i+1 (index  = (0 + 1)=1).
        // So, we return "5" (substring from index 0 to 1).
        // Result: "5"
    }
}
