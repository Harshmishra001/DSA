public class rightmostdiffbit {
    // Function to find the position of the rightmost differing bit between two integers.
    // Returns the position of the first differing bit, counting from the right (starting from 1).
    // If no differing bit is found, returns -1.
    public static int posOfRightMostDiffBit(int m, int n) {
        int pos = 1;
        
        // Iterate until at least one of m or n becomes 0.
        while (m != 0 || n != 0) {
            // Extract the least significant bits of m and n.
            int a = m & 1;
            int b = n & 1;
            
            // If the bits are different, return the position.
            if (a != b) {
                return pos;
            }
            
            // Right shift m and n.
            m >>= 1;
            n >>= 1;
            
            // Increment the position.
            pos++;
        }
        
        // If no differing bits are found, return -1.
        return -1;
    }
   public static void main(String[] args) {
    int m = 11, n = 9;
    System.out.println(posOfRightMostDiffBit( m, n));
   }

}
