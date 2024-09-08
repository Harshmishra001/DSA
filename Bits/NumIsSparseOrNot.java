// t.c-o(1) s.c -o(1)

// Your Task: The task is to complete the function checkSparse() that takes n as a parameter and returns 1 
// if the number is sparse else returns 0.

public class NumIsSparseOrNot {

  // Function to check if the number is sparse or not.
  public static boolean isSparse(int n) {
    // Check if there are any consecutive 1s in the binary representation of n
    if ((n & (n >> 1)) >= 1) {
        return false;  // If there are consecutive 1s, the number is not sparse
    }
    return true;  // If there are no consecutive 1s, the number is sparse
   } 

    public static void main(String[] args) {
        
        
        // Test case 1: N = 2
        int n1 = 2;
        // Check if the number is sparse using the Solution class method
        boolean result1 = isSparse(n1);
        // Expected Output: 1 (Sparse number)
        System.out.println("Input: " + n1);
        System.out.println("Output: " + (result1 ? 1 : 0));
        System.out.println("Explanation: Binary Representation of " + n1 + " is 10, which is not having consecutive set bits. So, it is a sparse number.");
        System.out.println();

        // Test case 2: N = 3
        int n2 = 3;
        // Check if the number is sparse using the Solution class method
        boolean result2 = isSparse(n2);
        // Expected Output: 0 (Not a sparse number)
        System.out.println("Input: " + n2);
        System.out.println("Output: " + (result2 ? 1 : 0));
        System.out.println("Explanation: Binary Representation of " + n2 + " is 11, which is having consecutive set bits. So, it is not a sparse number.");
        
       
    }
}

// Example Walkthrough:

// For N = 2 (binary representation: 10):

// Initial Value:

// N = 2, which is 10 in binary.
// Perform N & (N >> 1):

// First, shift N to the right by 1 bit:
// N >> 1 shifts 10 (binary) to 01 (binary).
// Perform the bitwise AND operation between N and N >> 1:
// N = 10 (binary)
// N >> 1 = 01 (binary)
// N & (N >> 1) = 10 & 01 = 00 (binary)
// Result: 00 (binary), which is 0 in decimal.
// Interpret the Result:

// If the result of the bitwise AND operation is 0, it means there are no consecutive 1s in the binary representation of N.
// Since the result is 0, the number is sparse.
// Output:

// Result: 1 (indicating the number is sparse).