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
// Goal

// To find the XOR of numbers in the range [3, 9],

// we use the formula:

// XOR from l to r=XOR(0 to r)⊕XOR(0 to (l−1))

// Steps
// Compute XOR from 0 to 9:

// Using fun(9):

// Compute the value of fun(9) based on the remainder of 9 divided by 4.
// 9 % 4 == 1, so according to the function: 
// fun(9)=1
// This means XOR from 0 to 9 is 1.
// Compute XOR from 0 to 2:

// Using fun(2):

// Compute the value of fun(2) based on the remainder of 2 divided by 4.
// 2 % 4 == 2, so according to the function: 
// fun(2)=2+1=3
// This means XOR from 0 to 2 is 3.

// Calculate XOR of the two results:

// Result from 0 to 9: 1
// Result from 0 to 2: 3

// Compute the XOR between these two results: 
// 1⊕3
// In binary, 1 is 0001 and 3 is 0011.
// Perform XOR:
//       0001
//        ⊕
//       0011
//       ------
//       0010

// The result is 0010 in binary, which is 2 in decimal.
// Output
// The XOR of numbers from 3 to 9 is 2.
