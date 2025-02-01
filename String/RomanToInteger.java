// Given a string in roman form, the task is to convert this given roman string into an integer.

// Roman numerals are based on the symbols I, V, X, L, C, D, and M, which represent 1, 5, 10, 50, 100, 500, and 1,000
//  respectively. Different arrangements of these symbols represent different numbers. The roman numbers
//  I, II, III, IV, V, VI, VII, VIII, IX, and X represent 1, 2, 3, 4, 5, 6, 7, 8, 9 and 10 respectively.

// How does the conversion work?

// If a smaller value symbol comes before, we subtract. Otherwise, we add.
// In IV, I comes before V and V has a larger value 5. So our result is 5 – 1 = 4.
// In VI, V comes before I and I has a smaller value 1. So our result is 5 + 1 = 6.
// In II, we have same values, so we add and get 1 + 1 = 2
// In case of more than 2 characters, we traverse from left to right and group only when we see 
// a greater value character after a smaller value character. For example MXVII is 1000 + 10 + 5 + 1 + 1 = 1017.
//  And XLVII is (50 – 10) + 5 + 1 + 1 = 47. Note that L is larger and comes after X.
// Examples:

// Input: s = “IX”
// Output: 9
// Explanation: IX is a Roman symbol which represents 10 – 1 = 9


// Input: s = “XL”
// Output: 40
// Explanation: XL is a Roman symbol which represents 50 – 10 = 40


// Input: s = “MCMIV”
// Output: 1904
// Explanation: M is 1000, CM is 1000 – 100 = 900, and IV is 4. So we have total as 1000 + 900 + 4 = 1904
import java.util.HashMap;

class RomanToInteger  {
    /**
     * Converts a Roman numeral to its decimal (integer) representation.
     * 
     * @param str The Roman numeral as a string
     * @return The integer value of the Roman numeral
     */
    public int romanToDecimal(String str) {
        // Step 1: Create a map to store Roman numeral values
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = str.length(); // Length of the Roman numeral string
        int sum = 0; // Variable to store the final decimal value

        // Step 2: Iterate through the Roman numeral string
        for (int i = 0; i < n - 1; i++) {
            // If the current numeral is less than the next numeral, subtract it
            if (map.get(str.charAt(i)) < map.get(str.charAt(i + 1))) {
                sum -= map.get(str.charAt(i));
                // Example: When processing "CM" in "MCMXCIV"
                // Current: C (100), Next: M (1000)
                // Action: Subtract 100, sum -= 100
            } 
            // Otherwise, add the current numeral's value
            else {
                sum += map.get(str.charAt(i));
                // Example: When processing "M" in "MCMXCIV"
                // Current: M (1000), Next: C (100)
                // Action: Add 1000, sum += 1000
            }
        }

        // Step 3: Add the value of the last Roman numeral
        sum += map.get(str.charAt(n - 1));
        // Example: Add the last numeral "V" (5) to the sum

        return sum; // Return the decimal value
    }

    public static void main(String[] args) {
        RomanToInteger  solution = new RomanToInteger ();

        // Test case: "MCMXCIV"
        String roman = "MCMXCIV"; // Expected result: 1994

        System.out.println("Roman numeral: " + roman + ", Decimal: " + solution.romanToDecimal(roman));

        // Stepwise Walkthrough for "MCMXCIV":
        /*
        Step 1: Initialize sum = 0 and map Roman numerals to values.

        Step 2: Process the Roman numeral string:
                - Iteration 1: Process 'M' (1000) and 'C' (100)
                              Current: 1000 >= 100
                              Action: Add 1000
                              sum = 1000

                - Iteration 2: Process 'C' (100) and 'M' (1000)
                              Current: 100 < 1000
                              Action: Subtract 100
                              sum = 900

                - Iteration 3: Process 'M' (1000) and 'X' (10)
                              Current: 1000 >= 10
                              Action: Add 1000
                              sum = 1900

                - Iteration 4: Process 'X' (10) and 'C' (100)
                              Current: 10 < 100
                              Action: Subtract 10
                              sum = 1890

                - Iteration 5: Process 'C' (100) and 'I' (1)
                              Current: 100 >= 1
                              Action: Add 100
                              sum = 1990

                - Iteration 6: Process 'I' (1) and 'V' (5)
                              Current: 1 < 5
                              Action: Subtract 1
                              sum = 1989

        Step 3: Add the last numeral 'V' (5) to the sum.
                Final sum = 1994
        */
    }
}
