public class MissingNumber {
    public int missingNumber(int[] arr) {
        int n = arr.length + 1;  // Since the array has size n - 1
        int xor1 = 0;  // XOR of all numbers from 1 to n
        int xor2 = 0;  // XOR of all elements in the array

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        // XOR all elements in the array
        for (int i = 0; i < arr.length; i++) {
            xor2 = xor2 ^ arr[i];
        }

        // The missing number is the XOR of xor1 and xor2
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();

        // Example 1
        int arr1[] = {1, 2, 3, 5};  // Missing number = 4
        System.out.println("Missing number: " + solution.missingNumber(arr1));  // Output: 4

        // Example 2
        int arr2[] = {1};  // Missing number = 2
        System.out.println("Missing number: " + solution.missingNumber(arr2));  // Output: 2
    }
}




// Dry Run Example:
// For the input arr = [1, 2, 3, 5]:

// n = 5 (since the array has size 4, and we expect numbers from 1 to 5).
// XOR all numbers from 1 to 5:
// xor1 = 1 ^ 2 ^ 3 ^ 4 ^ 5 = 1
// XOR all elements in the array [1, 2, 3, 5]:
// xor2 = 1 ^ 2 ^ 3 ^ 5 = 5
// XOR xor1 and xor2:
// missing = xor1 ^ xor2 = 1 ^ 5 = 4
// Thus, the missing number is 4.