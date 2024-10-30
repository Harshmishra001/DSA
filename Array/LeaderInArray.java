// Problem Statement: Given an array, print all the elements which are leaders. 
// A Leader is an element that is greater than all of the elements on its right side in the array.

// Examples

// Example 1:
// Input:arr = [4, 7, 1, 0]
// Output: 7 1 0
// Explanation:
//  Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.

// Example 2:
// Input:arr = [10, 22, 12, 3, 0, 6]
// Output:22 12 6
// Explanation:
//  6 is a leader. In addition to that, 12 is greater than all the elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.


// BRUTE-FORCE APPROACH
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.*;

class LeaderInArray {
    

    // Function to find leaders in the array using brute force approach
    public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Traverse each element to check if it is a leader
        for (int i = 0; i < n; i++) {
            boolean leader = true;

            // Check if arr[i] is greater than all elements to its right
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    // If any element to the right is greater, arr[i] is not a leader
                    leader = false;
                    break;
                }
            }

            // If arr[i] is a leader, add it to the answer list
            if (leader) {
                ans.add(arr[i]);
            }
        }

        return ans; // Return the list of leaders
    }

    public static void main(String[] args) {
        // Array Initialization
        int n = 6;
        int arr[] = {10, 22, 12, 3, 0, 6};

        // Finding leaders in the array
        ArrayList<Integer> ans = printLeadersBruteForce(arr, n);

        // Printing leaders
        System.out.print("Leaders in the array: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}


/* Dry Run Example:
   Input: arr = {10, 22, 12, 3, 0, 6}
   
   Step-by-Step:
   - For i = 0, arr[0] = 10: Compare with 22, 12, 3, 0, 6. Not a leader (22 > 10).
   - For i = 1, arr[1] = 22: Compare with 12, 3, 0, 6. Leader (no greater element to its right).
   - For i = 2, arr[2] = 12: Compare with 3, 0, 6. Not a leader (6 > 12).
   - For i = 3, arr[3] = 3: Compare with 0, 6. Not a leader (6 > 3).
   - For i = 4, arr[4] = 0: Compare with 6. Not a leader (6 > 0).
   - For i = 5, arr[5] = 6: No elements to its right, so it's a leader.

   Result: Leaders in the array = [22, 6]
*/




// OPTIMAL APPROACH
// Time Complexity: O(n)
// Space Complexity: O(n)

// class LeaderInArray {

//     // Function to find leaders in the array from the end, making it more efficient
//     public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
//         ArrayList<Integer> ans = new ArrayList<>();
        
//         // Initialize the last element as the current maximum leader
//         int max = arr[n - 1];
//         ans.add(max); // Last element is always a leader

//         // Traverse the array from the second last element to the beginning
//         for (int i = n - 2; i >= 0; i--) {
//             // If the current element is greater than the current max, it is a leader
//             if (arr[i] > max) {
//                 ans.add(arr[i]);
//                 max = arr[i]; // Update the max to the current leader
//             }
//         }

//         return ans;
//     }

//     public static void main(String[] args) {
//         // Array Initialization
//         int n = 6;
//         int arr[] = {10, 22, 12, 3, 0, 6};

//         // Finding leaders in the array
//         ArrayList<Integer> ans = printLeadersBruteForce(arr, n);

//         // Sorting the result in reverse order to match original order from left to right
//         Collections.sort(ans, Collections.reverseOrder());

//         // Printing leaders in the array
//         System.out.print("Leaders in the array: ");
//         for (int i = 0; i < ans.size(); i++) {
//             System.out.print(ans.get(i) + " ");
//         }
//     }
// }

/* Dry Run Example:
   Input: arr = {10, 22, 12, 3, 0, 6}
   
   Step-by-Step:
   - Start from the end:
     - Last element (6) is a leader, add to ans. max = 6.
     - Compare 0 with max (6): Not a leader.
     - Compare 3 with max (6): Not a leader.
     - Compare 12 with max (6): 12 > 6, so add 12 to ans. Update max = 12.
     - Compare 22 with max (12): 22 > 12, so add 22 to ans. Update max = 22.
     - Compare 10 with max (22): Not a leader.
   
   - Result before sorting: [6, 12, 22]
   - After sorting in reverse order: [22, 12, 6]

   Result: Leaders in the array = [22, 12, 6]
*/
