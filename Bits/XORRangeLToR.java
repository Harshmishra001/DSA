class XORRangeLToR { //t.c->o(1)
    
    // Helper function to compute XOR from 0 to n
    public static int fun(int n) {
        // Compute the result based on the remainder of n divided by 4
        if (n % 4 == 1) return 1;      // If n % 4 == 1, return 1
        if (n % 4 == 2) return n + 1;  // If n % 4 == 2, return n + 1
        if (n % 4 == 3) return 0;      // If n % 4 == 3, return 0
        else return n;                 // If n % 4 == 0, return n
    }

    // Function to find XOR of numbers in range [l, r]
    public static int findXOR(int l, int r) {
        // XOR from 0 to r XOR XOR from 0 to l-1 gives XOR of numbers in range [l, r]
        return fun(l - 1) ^ fun(r);
    }

    public static void main(String[] args) {
        // Test case 1
        int l1 = 3;
        int r1 = 9;
        System.out.println("XOR from " + l1 + " to " + r1 + " = " + findXOR(l1, r1));
        // Explanation: XOR from 0 to 9 is 9, XOR from 0 to 2 is 3, so result is 9 ^ 3 = 10

        // Test case 2
        int l2 = 5;
        int r2 = 8;
        System.out.println("XOR from " + l2 + " to " + r2 + " = " + findXOR(l2, r2));
        // Explanation: XOR from 0 to 8 is 8, XOR from 0 to 4 is 4, so result is 8 ^ 4 = 12

        // Test case 3
        int l3 = 0;
        int r3 = 7;
        System.out.println("XOR from " + l3 + " to " + r3 + " = " + findXOR(l3, r3));
        // Explanation: XOR from 0 to 7 is 7, XOR from 0 to -1 is 0, so result is 7 ^ 0 = 7
    }
}
