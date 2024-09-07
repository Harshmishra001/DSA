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
