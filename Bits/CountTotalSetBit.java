class CountTotalSetBit {   //tc- o(nlogn)

    // Function to count the set bits for a single number.
    public static int countSetBitsForNumber(int n) {
        int res = 0;
        while (n > 0) {
            n = (n & (n - 1));  // Remove the lowest set bit
            res++;
        }
        return res;
    }
    
    // Function to return the sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n) {
        int totalSetBits = 0;
        
        // Loop through each number from 1 to n and count its set bits.
        for (int i = 1; i <= n; i++) {
            totalSetBits += countSetBitsForNumber(i);
        }
        
        return totalSetBits;
    }

    // Main method to test the function.
    public static void main(String[] args) {
        int n = 4;  // Example input, change for other tests
        System.out.println("Total set bits from 1 to " + n + " is: " + countSetBits(n));
        // Output should be 5 for n = 4
    }
}

// More optimised
// class Solution {  // tc - o(logn)  

//     // Function to count the total number of set bits in all integers from 1 to n.
    
//     static int countSetBits(int n) {
//         if (n <= 0) return 0; // No set bits if n is less than or equal to 0.

//         int count = 0; // Total count of set bits.
//         int x = 1;  // Start with the least significant bit.

//         while (x <= n) {
//             // Number of complete pairs of x bits
//             int total_pairs = (n + 1) / (x * 2);
//             // Set bits contributed by complete pairs
//             count += total_pairs * x;
//             // Set bits contributed by the remainder
//             count += Math.max(0, (n + 1) % (x * 2) - x);
//             x <<= 1;  // Move to the next bit position
//         }

//         return count; // Return the total count of set bits
//     }
// }




// Example Walkthrough for n = 4

// Step 1: Initialize

// Call countSetBits(4).
// Initialize totalSetBits to 0.
// Step 2: Loop through Numbers

// Loop from i = 1 to i = 4.
// Step 3: Count Set Bits for Each Number

// For i = 1:

// Call countSetBitsForNumber(1).
// Initial n = 1.
// Remove Lowest Set Bit:
// n & (n - 1) = 1 & (1 - 1) = 1 & 0 = 0.
// Set bit removed, n becomes 0.
// Increment res to 1.
// Return 1 (total set bits for 1).
// Add 1 to totalSetBits, so totalSetBits = 1.
// For i = 2:

// Call countSetBitsForNumber(2).
// Initial n = 2.
// Remove Lowest Set Bit:
// n & (n - 1) = 2 & (2 - 1) = 2 & 1 = 0.    10 &  01 -> 00 so 0.
// Set bit removed, n becomes 0.
// Increment res to 1.
// Return 1 (total set bits for 2).
// Add 1 to totalSetBits, so totalSetBits = 2.
// For i = 3:

// Call countSetBitsForNumber(3).
// Initial n = 3.
// Remove Lowest Set Bit:
// n & (n - 1) = 3 & (3 - 1) = 3 & 2 = 2.
// n becomes 2.
// Remove Lowest Set Bit Again:
// n & (n - 1) = 2 & (2 - 1) = 2 & 1 = 0.
// Set bit removed, n becomes 0.
// Increment res to 2.
// Return 2 (total set bits for 3).
// Add 2 to totalSetBits, so totalSetBits = 4.
// For i = 4:

// Call countSetBitsForNumber(4).
// Initial n = 4.
// Remove Lowest Set Bit:
// n & (n - 1) = 4 & (4 - 1) = 4 & 3 = 0.
// Set bit removed, n becomes 0.
// Increment res to 1.
// Return 1 (total set bits for 4).
// Add 1 to totalSetBits, so totalSetBits = 5.
// Step 4: Return the Final Result

// Return totalSetBits which is 5.