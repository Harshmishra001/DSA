public class twoNoAppearOddTimes {
    
    // Function to find two numbers that appear an odd number of times in the array
    public int[] twoOddNum(int Arr[], int N) {
        
        int xorr = 0;
        
        // Sabhi elements ko XOR karo, jo do odd numbers hain unka XOR result milega
        for (int i = 0; i < N; i++) {
            xorr ^= Arr[i];
        }
        
        // Rightmost set bit nikalna jo do odd numbers mein different hai
        int rightmost = xorr & -xorr;
        
        int b1 = 0, b2 = 0;
        
        // Array ko do groups mein divide karo based on rightmost set bit
        for (int i = 0; i < N; i++) {
            if ((Arr[i] & rightmost) != 0) {
                b1 ^= Arr[i]; // Jahan bit set hai wahan XOR karo
            } else {
                b2 ^= Arr[i]; // Jahan bit set nahi hai wahan XOR karo
            }
        }
        
        // Do odd numbers ko sorted order mein return karo
        int[] ans = new int[2];
        if (b1 > b2) {
            ans[0] = b1;
            ans[1] = b2;
        } else {
            ans[0] = b2;
            ans[1] = b1;
        }
        return ans;
    }

    public static void main(String[] args) {
        twoNoAppearOddTimes sol = new twoNoAppearOddTimes();

        // Test case 1
        int[] arr1 = {1, 2, 1, 3, 2, 5};
        int[] result1 = sol.twoOddNum(arr1, arr1.length);
        System.out.println("Two odd occurring numbers: " + result1[0] + ", " + result1[1]);
        // Expected Output: Two odd occurring numbers: 3, 5

        // Test case 2
        int[] arr2 = {4, 5, 6, 7, 4, 5};
        int[] result2 = sol.twoOddNum(arr2, arr2.length);
        System.out.println("Two odd occurring numbers: " + result2[0] + ", " + result2[1]);
        // Expected Output: Two odd occurring numbers: 6, 7

        // Test case 3
        int[] arr3 = {10, 20, 10, 30, 40, 20, 30};
        int[] result3 = sol.twoOddNum(arr3, arr3.length);
        System.out.println("Two odd occurring numbers: " + result3[0] + ", " + result3[1]);
        // Expected Output: Two odd occurring numbers: 40, 30
    }
}
