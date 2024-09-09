class graytobinary {

    // Function to convert a given Gray code (n) to its binary equivalent.
    public static int grayToBinary(int n) {
        // Initialize ans to store the result (binary equivalent).
        int ans = 0;
        
        // Loop until n becomes 0
        while (n > 0) {
            // XOR current ans with n, updating ans
            ans ^= n;
            
            // Right shift n by 1 to process the next bit
            n = n >> 1;
        }
        
        // Return the binary equivalent (in decimal format)
        return ans;
    }

    public static void main(String[] args) {
        // Example 1: n = 4 (Gray code 110)
        int n1 = 4;
        int result1 = grayToBinary(n1);
        System.out.println("Binary equivalent of Gray code for n = " + n1 + " is: " + result1);
        // Expected output: 7 (binary 111)

        // Example 2: n = 15 (Gray code 1000)
        int n2 = 15;
        int result2 = grayToBinary(n2);
        System.out.println("Binary equivalent of Gray code for n = " + n2 + " is: " + result2);
        // Expected output: 10 (binary 1010)
    }
}

// Step-by-Step Execution of the grayToBinary Function:

// Initial State:
// n = 4 (Gray code in decimal).
// ans = 0 (this variable will store the binary equivalent as we calculate it).
// Now let's begin the loop, where we perform ans ^= n (XOR operation) and right shift n in each iteration until n becomes 0.

// Iteration 1:

// Current value of n: 4 (binary 100).
// Operation: ans ^= n.
// ans = 0 (binary 000).
// n = 4 (binary 100).
// ans = ans ^ n = 0 ^ 4 = 4 (binary 100).
// Explanation:
// The XOR operation compares each bit of ans and n. If the bits are different, the result is 1; if they are the same, the result is 0.
// So, 000 ^ 100 = 100, which gives us 4 (in decimal).
// Right Shift: Shift n by 1 position.
// n = n >> 1 = 4 >> 1 = 2 (binary 010).
// Iteration 2:

// Current value of n: 2 (binary 010).
// Operation: ans ^= n.
// ans = 4 (binary 100).
// n = 2 (binary 010).
// ans = ans ^ n = 4 ^ 2 = 6 (binary 110).
// Explanation:
// 100 ^ 010 = 110, which gives 6 in decimal.
// Right Shift: Shift n by 1 position.
// n = n >> 1 = 2 >> 1 = 1 (binary 001).
// Iteration 3:

// Current value of n: 1 (binary 001).
// Operation: ans ^= n.
// ans = 6 (binary 110).
// n = 1 (binary 001).
// ans = ans ^ n = 6 ^ 1 = 7 (binary 111).
// Explanation:
// 110 ^ 001 = 111, which gives 7 in decimal.
// Right Shift: Shift n by 1 position.
// n = n >> 1 = 1 >> 1 = 0 (binary 000).
// Final State:

// n = 0, so the loop terminates.
// The value of ans = 7.
// Thus, the binary equivalent of the Gray code 110 (which was n = 4 in decimal) is 111, which is 7 in decimal.