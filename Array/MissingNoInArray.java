class MissingNoInArray {

    // TC.-> O(N),SC->O(1) FOR BOTH APPROACH

   static int missingNumber(int arr1[], int n) {
        // Calculate the sum of first n natural numbers
        int ans = n * (n + 1) / 2;
        
        // Subtract each element of the array from the ans
        for (int i = 0; i < arr1.length; i++) {
            ans = ans - arr1[i]; // Reduce ans by the value of each element
        }
        
        // The remaining value in ans is the missing number
        return ans;
    }

    public static void main(String[] args) {
        MissingNoInArray   solution = new MissingNoInArray ();
        
        // Example 1
        int arr1[] = {1, 2, 3, 5};
        int result1 = solution.missingNumber(arr1, 5); // n is 5
        System.out.println("Missing number in array [1, 2, 3, 5]: " + result1); // Output: 4
        
     
    }
}

/*
Dry Run Example with arr1 = [1, 2, 3, 5] and n = 5
1. Calculate the expected sum of first n natural numbers:
   ans = 5 * (5 + 1) / 2 = 15

2. Iterate through the array:
   a. For i = 0: array[0] = 1
      ans = ans - 1 => ans = 15 - 1 = 14
   b. For i = 1: array[1] = 2
      ans = ans - 2 => ans = 14 - 2 = 12
   c. For i = 2: array[2] = 3
      ans = ans - 3 => ans = 12 - 3 = 9
   d. For i = 3: array[3] = 5
      ans = ans - 5 => ans = 9 - 5 = 4

3. Return ans, which is 4. This is the missing number.
*/



// USING XOR

// public class MissingNumber {
//     public int missingNumber(int[] arr) {
//         int n = arr.length + 1;  // Since the array has size n - 1
//         int xor1 = 0;  // XOR of all numbers from 1 to n
//         int xor2 = 0;  // XOR of all elements in the array

//         // XOR all numbers from 1 to n
//         for (int i = 1; i <= n; i++) {
//             xor1 = xor1 ^ i;
//         }

//         // XOR all elements in the array
//         for (int i = 0; i < arr.length; i++) {
//             xor2 = xor2 ^ arr[i];
//         }

//         // The missing number is the XOR of xor1 and xor2
//         return xor1 ^ xor2;
//     }

//     public static void main(String[] args) {
//         MissingNumber solution = new MissingNumber();

//         // Example 1
//         int arr1[] = {1, 2, 3, 5};  // Missing number = 4
//         System.out.println("Missing number: " + solution.missingNumber(arr1));  // Output: 4

//         // Example 2
//         int arr2[] = {1};  // Missing number = 2
//         System.out.println("Missing number: " + solution.missingNumber(arr2));  // Output: 2
//     }
// }




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