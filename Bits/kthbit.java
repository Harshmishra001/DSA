public class kthbit {
    static void kthbitt(int n,int k) 
{ 
	if (((n >> (k - 1))&1) == 1) 
		System.out.println("SET"); 
	else
		System.out.println("NOT SET"); 
} 
// Driver code 
public static void main (String[] args) 
{ 
	int n = 5, k = 1; 
	kthbitt(n, k);
}
}

// Example Walkthrough:

// For n = 5 and k = 1:

// Binary Representation of n:

// n = 5 (decimal) is 101 in binary.
// Right Shift Operation:

// Compute n >> (k - 1):
// k - 1 = 1 - 1 = 0
// n >> 0 means no shift, so 101 remains 101 (binary).
// Bitwise AND Operation:

// Apply (n >> (k - 1)) & 1:
// 101 & 1 isolates the least significant bit.    look below
 
//   101
// & 001
// -----
//   001     Here, the rightmost bit is 1 in both 101 and 001, so the result is 1.

// Result is 1 (binary), which is 1 (decimal).
// Check the Result:

// Since the result is 1, the k-th bit is set.

// Conclusion:

// Output: "SET"