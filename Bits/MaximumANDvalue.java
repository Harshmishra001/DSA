public class MaximumANDvalue {

    public static int maxAND(int arr[], int N) {
        // Initialize the result to 0. This will store the maximum AND value found.
        int result = 0;
        
        // Iterate over each bit position from the most significant bit (31) to the least significant bit (0).
        for (int bit = 31; bit >= 0; bit--) {
            // Create a temporary result by setting the current bit position in the result.
            int tempResult = result | (1 << bit);
            
            // Count how many numbers in the array have all bits in tempResult set.
            int count = 0;
            
            // Check each number in the array.
            for (int i = 0; i < N; i++) {
                // If the current number AND tempResult equals tempResult, it means the number has all bits set as in tempResult.
                if ((arr[i] & tempResult) == tempResult) {
                    count++;
                }
                
                // If more than one number has all bits set, update the result and break the loop.
                if (count > 1) {
                    result = tempResult;
                    break;
                }
            }
        }
        
        // Return the maximum AND value found.
        return result;
    }

    public static void main(String[] args) {
        // Example input
        int arr[] = {4, 8, 12, 16};
        int N = arr.length;
        
        // Compute and print the maximum AND value
        System.out.println(maxAND(arr, N)); // Output: 8
    }
}

