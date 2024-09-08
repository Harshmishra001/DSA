public class LongestConsecutive1 {     //t.c-O(log N).   s.c-O(1)
    
    public static int maxConsecutiveOnes(int N) {
        
        int count = 0;  // Initialize a counter to keep track of the maximum number of consecutive 1s
        
        // Loop until N becomes 0
        while (N != 0) {
            // Perform bitwise AND operation between N and (N left-shifted by 1)
            // This operation removes the rightmost 1 from the sequence of consecutive 1s
            N = (N & (N << 1));
            count++;  // Increment the counter for each sequence of consecutive 1s found
        }
        
        return count;  // Return the maximum count of consecutive 1s
    }
    public static void main(String[] args) {
        int N = 14;  // Input number
        System.out.println("Maximum consecutive 1s in " + N + " is " + maxConsecutiveOnes(N));
    }
}
    
    
// Example Walkthrough:
// For N = 14 (binary representation: 1110):

// Initially, N = 1110. After N = N & (N << 1), the new value of N becomes 1100.
// On the next iteration, N = 1100. After N = N & (N << 1), the new value of N becomes 1000.
// On the next iteration, N = 1000. After N = N & (N << 1), N becomes 0, and the loop stops.
// The counter count was incremented 3 times, so the longest sequence of consecutive 1s is 3.
