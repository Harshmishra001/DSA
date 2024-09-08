  //QN NAME - SET/UNSET RIGHTMOST BIT

//   Input: n = 6
// Output: 7
// Explanation: The binary representation of 6 is 110. After setting right most bit it becomes 111 which is 7.

class setrghtmstbit {
    // Function to set the rightmost unset bit in the binary representation of n.
    static int setBit(int n) {
        // Find the position of the rightmost unset bit.
        // ~n flips all bits of n (0 becomes 1, and 1 becomes 0).
        // n + 1 flips the bits up to the first 0 and turns it into 1.
        // Combining these gives us a mask that isolates the rightmost unset bit.
        int mask = (~n) & (n + 1);
        
        // Use the mask to set the rightmost unset bit in n.
        // OR operation sets the bit without changing other bits.
        return n | mask;
    }

    // Main method to test the setBit function.
    public static void main(String[] args) {
        // Example inputs
        int[] testValues = {6, 14, 1, 0, 15};
        
        for (int n : testValues) {
            // Print the original number and the result after setting the rightmost unset bit.
            System.out.println("Original number: " + n + ", After setting rightmost unset bit: " + setBit(n));
        }
    }
}


// Example Walkthrough for n = 6
// Binary Representation of 6:

// Decimal 6 in binary is 0110.
// Step 1: Compute ~n (bitwise NOT of 6):

// The bitwise NOT operation flips all the bits.
// For a 4-bit representation, 0110 (binary for 6) becomes 1001 when all bits are flipped.
// Note: In practice, this operation depends on the bit-width of the data type (e.g., 32-bit integers). For clarity, we're using a 4-bit representation here.
// Step 2: Compute n + 1:

// Adding 1 to 6 gives 7.

// In binary, 7 is 0111.

// Step 3: Find the mask using (~n) & (n + 1):

// ~n is 1001 (from Step 1).
// n + 1 is 0111 (from Step 2).
// Perform the bitwise AND operation between 1001 and 0111:


// 1001
//&0111
// ----
// 0001

// The result is 0001. This mask isolates the rightmost unset bit in the original number 6.
// Step 4: Set the bit using n | mask:

// n is 0110.
// mask is 0001.
// Perform the bitwise OR operation to set the rightmost unset bit:

//  0110
// |0001
//  ----
// 0111

// The result is 0111, which is 7 in decimal.