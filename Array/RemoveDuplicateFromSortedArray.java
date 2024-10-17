// Given a sorted array arr. Return the size of the modified array which contains only distinct elements.
// Note:
// 1. Don't use set or HashMap to solve the problem.
// 2. You must return the modified array size only where distinct elements are present and modify 
// the original array such that all the distinct elements come at the beginning of the original array.

// Examples :

// Input: arr = [2, 2, 2, 2, 2]
// Output: [2]
// Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so modified array will contains 2 at first position and you should return 1 after modifying the array, the driver code will print the modified array elements.
// Input: arr = [1, 2, 4]
// Output: [1, 2, 4]
// Explation:  As the array does not contain any duplicates so you should return 3.


// time complexity of O(n) and space complexity of O(1)
public class RemoveDuplicateFromSortedArray {

        public static int removeDuplicates(int[] arr) {
            // If the array is empty or has only one element, it is already unique
            if (arr.length == 0 || arr.length == 1) {
                return arr.length;
            }
    
            int j = 0; // Pointer for storing distinct elements
    
            // Traverse the array
            for (int i = 1; i < arr.length; i++) {
                // If current element is not equal to the last distinct element
                if (arr[i] != arr[j]) {
                    j++; // Move the pointer
                    arr[j] = arr[i]; // Place the distinct element at index j
                }
            }
    
            // j+1 will be the number of distinct elements
            return j + 1;
        }
    
        public static void main(String[] args) {
            int[] arr = {1, 2, 4}; // All distinct elements
            int n = removeDuplicates(arr);
            System.out.println("Modified array size with distinct elements: " + n); // Expected output: 3
    
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " "); // Expected output: 1 2 4
            }
        }
 }
    
    /*
    DRY RUN:
    
    Input: arr = {1, 2, 4}
    
    Initial variables:
    arr = {1, 2, 4}
    j = 0 (pointer to track the last distinct element)
    
    Step-by-step execution:
    
    Iteration 1 (i = 1):
    - Compare arr[1] (2) with arr[j] (arr[0] = 1)
    - Since arr[1] != arr[0], a new distinct element (2) is found.
    - Increment j to 1.
    - arr[j] = arr[1], so arr[1] remains 2.
    - Current array: {1, 2, 4}
    
    Iteration 2 (i = 2):
    - Compare arr[2] (4) with arr[j] (arr[1] = 2)
    - Since arr[2] != arr[1], a new distinct element (4) is found.
    - Increment j to 2.
    - arr[j] = arr[2], so arr[2] remains 4.
    - Current array: {1, 2, 4}
    
    End of loop.
    
    Final Result:
    - All elements were distinct.
    - The modified array is {1, 2, 4}.
    - The method returns j + 1 = 3, indicating the size of the array with distinct elements.
    
    Output:
    Modified array size with distinct elements: 3
    Distinct array elements: 1 2 4
    */
    

    
    


