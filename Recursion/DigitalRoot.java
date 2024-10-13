// You are given a number n. You need to find the digital root of n. DigitalRoot of a number is the recursive sum of its digits until we get a single digit number.
// Time Complexity: O(d²) where d is the number of digits.
// Auxiliary Space: O(d) due to the recursive calls.

class DigitalRoot {
    
    // Function to calculate the digital root of a number
    public int digitalRoot(int n) {
        // Base case: If the number is a single digit, return it
        if (n < 10) {
            return n;
        }

        // Recursive case: Calculate the sum of the digits
        int sumOfDigits = 0;
        while (n > 0) {
            sumOfDigits += n % 10;  // Add the last digit to sum
            n =n/10;  // Remove the last digit from n
        }
        
        // Call the digitalRoot function recursively with the sum of digits
        return digitalRoot(sumOfDigits);
    }
    
    public static void main(String[] args) {
        DigitalRoot solution = new DigitalRoot();
        
        // Example 1
        int n1 = 1;
        System.out.println("Digital root of " + n1 + " is: " + solution.digitalRoot(n1));  // Output: 1
        
        // Example 2
        int n2 = 99999;
        System.out.println("Digital root of " + n2 + " is: " + solution.digitalRoot(n2));  // Output: 9
    }
}
// Input:
// n = 1
// Output:  1
// Explanation: Digital root of 1 is 1
// Example 2:

// Input:
// n = 99999
// Output: 9
// Explanation: Sum of digits of 99999 is 45
// which is not a single digit number, hence
// sum of digit of 45 is 9 which is a single
// digit number.