
// Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

//* Pre-requisite: Find the number of subarrays with the sum K  || COUNTSUBARRAYSUMK
// SAME NO. KA XOR ZERO HOTA HAI    

// Examples
// Example 1:
// Input Format:
//  A = [4, 2, 2, 6, 4] , k = 6
// Result:
//  4
// Explanation:
//  The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

// Example 2:
// Input Format:
//  A = [5, 6, 7, 8, 9], k = 5
// Result:
//  2
// Explanation:
//  The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9] 


// BRUTE FORCE APPROACH

// Time Complexity: O(N3) approx., where N = size of the array.
// Reason: We are using three nested loops, each running approximately N times.

// Space Complexity: O(1) as we are not using any extra space.

// import java.util.*;

// public class  CountNoOfSubarrayWithXorK {

//     public static int subarraysWithXorK(int []a, int k) {
//         int n = a.length; //size of the given array.
//         int cnt = 0;

//         // Step 1: Generating subarrays:
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {

//                 //step 2:calculate XOR of all
//                 // elements:
//                 int xorr = 0;
//                 for (int K = i; K <= j; K++) {
//                     xorr = xorr ^ a[K];
//                 }

//                 // step 3:check XOR and count:
//                 if (xorr == k) cnt++;
//             }
//         }
//         return cnt;
//     }

//     public static void main(String[] args) {
//         int[] a = {4, 2, 2, 6, 4};
//         int k = 6;
//         int ans = subarraysWithXorK(a, k);
//         System.out.println("The number of subarrays with XOR k is: " + ans);
//     }
// }

// BETTER APPROACH

// Time Complexity: O(N2), where N = size of the array.
// Reason: We are using two nested loops here. As each of them is running for N times, the time complexity will be approximately O(N2).

// Space Complexity: O(1) as we are not using any extra space.


// import java.util.*;

// public class  CountNoOfSubarrayWithXorK{

//     public static int subarraysWithXorK(int []a, int k) {
//         int n = a.length; //size of the given array.
//         int cnt = 0;

//         // Step 1: Generating subarrays:
//         for (int i = 0; i < n; i++) {
//             int xorr = 0;
//             for (int j = i; j < n; j++) {

//                 //step 2:calculate XOR of all
//                 // elements:
//                 xorr = xorr ^ a[j];

//                 // step 3:check XOR and count:
//                 if (xorr == k) cnt++;
//             }
//         }
//         return cnt;
//     }

//     public static void main(String[] args) {
//         int[] a = {4, 2, 2, 6, 4};
//         int k = 6;
//         int ans = subarraysWithXorK(a, k);
//         System.out.println("The number of subarrays with XOR k is: " + ans);
//     }
// }  




// OPTIMAL APPROACH

// Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
// Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array. Point to remember for unordered_map in the worst case, the searching time increases to O(N), and hence the overall time complexity increases to O(N2). 

// Space Complexity: O(N) as we are using a map data structure.


import java.util.*;

public class CountNoOfSubarrayWithXorK {

    // Function to count the number of subarrays with XOR equal to k
    public static int subarraysWithXorK(int[] a, int k) {
        int n = a.length; // Size of the array
        Map<Integer, Integer> mpp = new HashMap<>(); // Map to store frequency of prefix XOR values
        mpp.put(0, 1); // Initializing with prefix XOR 0 having frequency 1
        int xr = 0; // Prefix XOR
        int cnt = 0; // Count of subarrays with XOR equal to k

        for (int i = 0; i < n; i++) {
            // Update the prefix XOR with the current element
            xr = xr ^ a[i];

            // Calculate the required XOR using the formula: x = xr ^ k
            int x = xr ^ k;

            // Check if the required XOR value exists in the map
            if (mpp.containsKey(x)) {
                // If yes, add its frequency to the count
                cnt += mpp.get(x);
            }

            // Update the frequency of the current prefix XOR in the map
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt; // Return the total count
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4}; // Input array
        int k = 6; // Target XOR
        int ans = subarraysWithXorK(a, k); // Calculate the result
        System.out.println("The number of subarrays with XOR k is: " + ans); // Print the result
    }
}

/*
DRY RUN:

Input array: a = {4, 2, 2, 6, 4}
Target XOR: k = 6

Initial values:
xr = 0, cnt = 0, mpp = {0: 1}

Iteration 1 (i = 0):
- Current element: a[i] = 4
- xr = xr ^ a[i] = 0 ^ 4 = 4
- x = xr ^ k = 4 ^ 6 = 2
- mpp does not contain 2, so cnt remains 0
- Update mpp: mpp[4] = 1
  mpp = {0: 1, 4: 1}

Iteration 2 (i = 1):
- Current element: a[i] = 2
- xr = xr ^ a[i] = 4 ^ 2 = 6
- x = xr ^ k = 6 ^ 6 = 0
- mpp contains 0 with frequency 1, so cnt += 1 -> cnt = 1
- Update mpp: mpp[6] = 1
  mpp = {0: 1, 4: 1, 6: 1}

Iteration 3 (i = 2):
- Current element: a[i] = 2
- xr = xr ^ a[i] = 6 ^ 2 = 4
- x = xr ^ k = 4 ^ 6 = 2
- mpp does not contain 2, so cnt remains 1
- Update mpp: mpp[4] = 2
  mpp = {0: 1, 4: 2, 6: 1}

Iteration 4 (i = 3):
- Current element: a[i] = 6
- xr = xr ^ a[i] = 4 ^ 6 = 2
- x = xr ^ k = 2 ^ 6 = 4
- mpp contains 4 with frequency 2, so cnt += 2 -> cnt = 3
- Update mpp: mpp[2] = 1
  mpp = {0: 1, 4: 2, 6: 1, 2: 1}

Iteration 5 (i = 4):
- Current element: a[i] = 4
- xr = xr ^ a[i] = 2 ^ 4 = 6
- x = xr ^ k = 6 ^ 6 = 0
- mpp contains 0 with frequency 1, so cnt += 1 -> cnt = 4
- Update mpp: mpp[6] = 2
  mpp = {0: 1, 4: 2, 6: 2, 2: 1}

Final Result:
cnt = 4
The number of subarrays with XOR k is: 4
*/









