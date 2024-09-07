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
