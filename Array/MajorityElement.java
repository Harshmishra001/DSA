// Problem Statement: Given an array of N integers,
//  write a program to return an element that occurs more than N/2 times in the given array. 
//  You may consider that such an element always exists in the array.

// Example 1:
// Input Format
// : N = 3, nums[] = {3,2,3}
// Result
// : 3
// Explanation
// : When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

// Example 2:
// Input Format:
//   N = 7, nums[] = {2,2,1,1,1,2,2}

// Result
// : 2

// Explanation
// : After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

// Example 3:
// Input Format:
//   N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}

// Result
// : 4


// BRUTE-FORCE APPROACH

// Time Complexity: O(N2) Space Complexity: O(1) 

import java.util.*;

// public class MajorityElement {
//     // Method to find the majority element in an array
//     public static int majorityElement(int []arr) {
//         // Size of the given array:
//         int n = arr.length;

//         // Iterate through each element in the array
//         for (int i = 0; i < n; i++) {
//             // Selected element is arr[i]
//             int cnt = 0; // Counter to keep track of occurrences of arr[i]

//             // Count the frequency of arr[i]
//             for (int j = 0; j < n; j++) {
//                 // If current element matches arr[i], increment count
//                 if (arr[j] == arr[i]) {
//                     cnt++;
//                 }
//             }

//             // Check if the frequency is greater than n/2
//             if (cnt > (n / 2))
//                 return arr[i]; // Return arr[i] if it's the majority element
//         }

//         // Return -1 if no majority element exists
//         return -1;
//     }

//     // Main method to test the majorityElement function
//     public static void main(String args[]) {
//         int[] arr = {2, 2, 1, 1, 1, 2, 2}; // Example input array
//         int ans = majorityElement(arr); // Call the method
//         System.out.println("The majority element is: " + ans); // Output the result
//     }
// }


//OPTIMAL APPROACH

// Moore’s Voting Algorithm:     For better understanding watch striver video

// Time Complexity: O(N) Space Complexity: O(1)



public class MajorityElement {
    // Method to find the majority element in an array
    public static int majorityElement(int []arr) {
        // Size of the given array:
        int n = arr.length;
        int cnt = 0; // Counter for occurrences
        int el = 0; // Variable to store potential majority element

        // Applying the Boyer-Moore Voting Algorithm:
        for (int i = 0; i < n; i++) {
            // If count is zero, pick the current element as the candidate
            if (cnt == 0) {
                cnt = 1; // Reset count
                el = arr[i]; // Update the candidate element
            } 
            // If current element matches candidate, increase count
            else if (el == arr[i]) {
                cnt++;
            } 
            // Otherwise, decrease count
            else {
                cnt--;
            }
        }//iss loop s ek majority element mil jayega fir usse verify krenge ki vhi h majority ya nhi

        // Checking if the stored element is indeed the majority element:
        int cnt1 = 0; // Counter to verify majority
        for (int i = 0; i < n; i++) {
            // Count occurrences of the candidate element
            if (arr[i] == el) {
                cnt1++;
            }
        }

        // If the count of the candidate is greater than n/2, return it
        if (cnt1 > n / 2) return el;
        return -1; // Return -1 if no majority element exists
    }

    // Main method to test the majorityElement function
    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2}; // Example input array
        int ans = majorityElement(arr); // Call the method
        System.out.println("The majority element is: " + ans); // Output the result
    }
}

/*
Dry Run:
Input Array: {2, 2, 1, 1, 1, 2, 2}
Length (n): 7

1. Initialize: cnt = 0, el = 0

2. Iterate through the array (i from 0 to 6):
   - i = 0: arr[0] = 2
     - cnt == 0 → Set el = 2, cnt = 1
   - i = 1: arr[1] = 2
     - el == arr[1] → cnt = 2
   - i = 2: arr[2] = 1
     - el != arr[2] → cnt = 1
   - i = 3: arr[3] = 1
     - el != arr[3] → cnt = 0
   - i = 4: arr[4] = 1
     - cnt == 0 → Set el = 1, cnt = 1
   - i = 5: arr[5] = 2
     - el != arr[5] → cnt = 0
   - i = 6: arr[6] = 2
     - cnt == 0 → Set el = 2, cnt = 1

3. Candidate element after the first loop: el = 2, cnt = 1

4. Verify if el (2) is the majority:
   - Count occurrences of 2:
     - cnt1 = 0
     - Check: arr[0] = 2 → cnt1 = 1
     - Check: arr[1] = 2 → cnt1 = 2
     - Check: arr[2] = 1 → cnt1 = 2
     - Check: arr[3] = 1 → cnt1 = 2
     - Check: arr[4] = 1 → cnt1 = 2
     - Check: arr[5] = 2 → cnt1 = 3
     - Check: arr[6] = 2 → cnt1 = 4
   - Final cnt1 = 4

5. Check if cnt1 > n/2:
   - 4 > (7/2) = 3.5 → **True** 

Output: The majority element is: 2
*/


