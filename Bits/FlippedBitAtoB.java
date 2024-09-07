class FlippedBitAtoB {
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b) {
        // XOR to find differing bits between a and b
        int flippedbit = a ^ b;
        int count = 0;

        // Count the number of set bits in flippedbit (those that differ)
        while (flippedbit != 0) {
            // Check if the least significant bit is 1
            if ((flippedbit & 1) == 1) {
                count++;
            }
            // Right shift to check the next bit
            flippedbit >>= 1;     //flippedbit=flippedbit>>1
        }

        return count;
    }
    public static void main(String[] args) {
        // Test case 1
        int a = 29;  // Binary: 11101
        int b = 15;  // Binary: 01111
        System.out.println("Bits to be flipped to convert " + a + " to " + b + " = " + countBitsFlip(a, b));
        // Output: 2 (since bits 2 and 4 differ)

        // Test case 2
        a = 10;  // Binary: 1010
        b = 20;  // Binary: 10100
        System.out.println("Bits to be flipped to convert " + a + " to " + b + " = " + countBitsFlip(a, b));
        // Output: 4

        // Test case 3 (same numbers, no flip needed)
        a = 7;  // Binary: 111
        b = 7;  // Binary: 111
        System.out.println("Bits to be flipped to convert " + a + " to " + b + " = " + countBitsFlip(a, b));
        // Output: 0
    }
}
