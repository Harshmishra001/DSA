public class firstsetbit {
   // Function to find position of the first set bit in the given number.
   public static int getFirstSetBit(int n) {
    // If n is 0, the first set bit position is also 0.
    if (n == 0)
        return 0;

    // Variable to store the position of the first set bit.
    int count = 0;

    // Convert the integer to its binary representation.
    String binary = Integer.toBinaryString(n);

    // Get the length of the binary string.
    int len = binary.length();

    // Loop through the binary string from right to left.
    for (int i = len - 1; i >= 0; i--) {
        count++;

        // If we encounter the first set bit (1), return its position.
        if (binary.charAt(i) == '1') {
            return count;
        }
    }

    // If no set bit is found, return 0.
    return 0;
}

// Main method to test the function.
public static void main(String[] args) {
    int n = 18; // Example number, change this for other tests
    int result = getFirstSetBit(n);
    System.out.println("The position of the first set bit is: " + result);
} 
}

    

