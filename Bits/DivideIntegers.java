public class DivideIntegers {   //o(log(dividend))

    public static int divide(int dividend, int divisor) {
        // Handle overflow for the edge case where dividend is Integer.MIN_VALUE and divisor is -1.
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        // Determine if the result is negative.
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Work with absolute values to avoid overflow.
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        int result = 0;

        // Keep subtracting the divisor's multiples from the dividend.
        while (dividendL >= divisorL) {
            long tempDivisor = divisorL, multiple = 1;

            // Find the largest multiple of divisor that fits into dividend.
            while (dividendL >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest multiple and add it to the result.
            dividendL -= tempDivisor;
            result += multiple;
        }

        // Apply the sign and return the result.
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("10 / 3 = " + divide(10, 3));     // Output: 3
        System.out.println("-10 / -2 = " + divide(-10, -2)); // Output: 5
        System.out.println("MIN_VALUE / -1 = " + divide(Integer.MIN_VALUE, -1)); // Output: Integer.MAX_VALUE
    }
}

// Test Case Walkthrough:

// Example Walkthrough: 10 / 3

// Initial Setup
// Determine Sign:

// Both dividend = 10 and divisor = 3 are positive.
// Therefore, the result will be positive.
// Convert to Absolute Values:

// dividendL = 10 (absolute value of 10)
// divisorL = 3 (absolute value of 3)
// Initialize result = 0.
// First Iteration
// Find Largest Multiple of Divisor:

// Initial Values:
// tempDivisor = 3 (the divisor)
// multiple = 1 (initial multiple of the divisor)
// Double the Divisor:
// Shift tempDivisor left by 1 bit (i.e., 3 << 1), resulting in 6.   (coz 3 ko ek baar shift kr re h or  multiple h so 3 * 2=6)
// Shift multiple left by 1 bit (i.e., 1 << 1), resulting in 2.
// Check if Multiple Fits:

// Compare 10 with 6:
// Since 10 >= 6, subtract 6 from 10, which updates dividendL to 4.
// Add multiple (which is 2) to result, updating result to 2.
// Update Values for Next Iteration:

// dividendL = 4
// tempDivisor = 6 (still as the largest multiple fitting in current dividendL)
// multiple = 2
// Second Iteration
// Continue with Remaining Dividend:

// Current Values:
// tempDivisor = 3 (reset to original divisor)
// multiple = 1
// Check if tempDivisor Fits:
// Compare 4 with 3:
// Since 4 >= 3, subtract 3 from 4, updating dividendL to 1.
// Add multiple (which is 1) to result, updating result to 3.
// Update Values:

// dividendL = 1
// Since 1 is less than 3, we stop the iteration.
// Result
// The final value of result is 3, and since both the original dividend and divisor were positive, the result is positive.
// The quotient of 10 divided by 3 is 3.
// Summary
// In this bit manipulation approach:

// We doubled the divisor (3) as many times as possible without exceeding the current dividend (10).
// We subtracted these largest multiples from the dividend and updated the result accordingly.
// This method efficiently calculates the quotient by leveraging bit shifting to handle larger multiples quickly.
// Output:

// 10 / 3 = 3