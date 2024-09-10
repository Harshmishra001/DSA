class BinaryToGray {
    // Function to convert binary to Gray code
    int binaryToGray(int n) {
        return n ^ (n >> 1); // XOR between the binary number and the number shifted right by 1 bit
    }
    public static void main(String[] args) {
        // Hardcoded binary number
        int binaryNumber = 0b1011101; // Binary representation (equivalent to 93 in decimal)
        
        // The 0b prefix is used to indicate that the number following it is a binary number (base-2). In Java, binary literals can be
        //  expressed using the 0b or 0B prefix (introduced in Java 7).

        // Create object and calculate Gray code
        BinaryToGray obj = new BinaryToGray();
        int grayCode = obj.binaryToGray(binaryNumber);

        // Output the Gray code
        System.out.println("Gray code is: " + Integer.toBinaryString(grayCode));
    }
}
