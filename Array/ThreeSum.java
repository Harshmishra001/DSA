
// Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a 
// sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] 
// such that i!=j, j!=k, k!=i, and their sum is equal to zero.

//* Pre-requisite: 2 Sum Problem

// Examples
// Example 1:
// Input:nums = [-1,0,1,2,-1,-4]
// Output:[[-1,-1,2],[-1,0,1]]
// Explanation:
//  Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k

// Example 2:
// Input:nums=[-1,0,1,0]
// Output: [[-1,0,1],[-1,1,0]]
// Explanation:
//  Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k



// import java.util.*;
// // BRUTE-FORCE APPROACH

// // Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.
// // Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

// // Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
// public class ThreeSum {
//     public static List<List<Integer>> triplet(int n, int[] arr) {

//         // Using a set to avoid duplicate triplets
//         Set<List<Integer>> st = new HashSet<>();

//         // Check all possible triplets
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     // Check if the triplet sums up to zero
//                     if (arr[i] + arr[j] + arr[k] == 0) {
//                         // Create a list to store the triplet
//                         List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
//                         // Sort the triplet to maintain consistency
//                         temp.sort(null);
//                         // Add the sorted triplet to the set to ensure uniqueness
//                         st.add(temp);
//                     }
//                 }
//             }
//         }

//         // Convert the set to a list for the final answer
//         return new ArrayList<>(st);
//     }

//     public static void main(String[] args) {
//         int[] arr = { -1, 0, 1, 2, -1, -4};
//         int n = arr.length;
//         List<List<Integer>> ans = triplet(n, arr);
//         for (List<Integer> it : ans) {
//             System.out.print("[");
//             for (Integer i : it) {
//                 System.out.print(i + " ");
//             }
//             System.out.print("] ");
//         }
//         System.out.println();
//     }
// }

/* 
Dry Run:
Input: arr = { -1, 0, 1, 2, -1, -4 }
       n = 6

1. Initialize:
   - st = {} (empty set to store unique triplets)

2. Iterate through all possible triplets with nested loops:

   - i = 0:
     - j = 1:
       - k = 2:
         - arr[i] + arr[j] + arr[k] = -1 + 0 + 1 = 0
         - Triplet found: [-1, 0, 1]
         - Sort and add to set `st` -> st = {[-1, 0, 1]}

       - k = 3:
         - arr[i] + arr[j] + arr[k] = -1 + 0 + 2 = 1 (not zero)

       - k = 4:
         - arr[i] + arr[j] + arr[k] = -1 + 0 + -1 = -2 (not zero)

       - k = 5:
         - arr[i] + arr[j] + arr[k] = -1 + 0 + -4 = -5 (not zero)

     - j = 2:
       - k = 3:
         - arr[i] + arr[j] + arr[k] = -1 + 1 + 2 = 2 (not zero)

       - k = 4:
         - arr[i] + arr[j] + arr[k] = -1 + 1 + -1 = -1 (not zero)

       - k = 5:
         - arr[i] + arr[j] + arr[k] = -1 + 1 + -4 = -4 (not zero)

     - j = 3:
       - k = 4:
         - arr[i] + arr[j] + arr[k] = -1 + 2 + -1 = 0
         - Triplet found: [-1, 2, -1]
         - Sort and add to set `st` -> st = {[-1, 0, 1], [-1, -1, 2]}

       - k = 5:
         - arr[i] + arr[j] + arr[k] = -1 + 2 + -4 = -3 (not zero)

     - j = 4:
       - k = 5:
         - arr[i] + arr[j] + arr[k] = -1 + -1 + -4 = -6 (not zero)

   - i = 1:
     - j = 2:
       - k = 3:
         - arr[i] + arr[j] + arr[k] = 0 + 1 + 2 = 3 (not zero)

       - k = 4:
         - arr[i] + arr[j] + arr[k] = 0 + 1 + -1 = 0
         - Triplet found: [0, 1, -1]
         - Sort and add to set `st` -> `st` already contains [-1, 0, 1]

       - k = 5:
         - arr[i] + arr[j] + arr[k] = 0 + 1 + -4 = -3 (not zero)

     - j = 3, 4, 5:
       - These indices produce no new zero-sum triplets.

3. Convert set `st` to a list `ans`:
   - ans = [[-1, 0, 1], [-1, -1, 2]]

Output:
The majority elements are: [-1 0 1] [-1 -1 2]
*/




// BETTER-APPROACH

// Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array.
// Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

// Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.
// import java.util.*;

// public class ThreeSum {
//     public static List<List<Integer>> triplet(int n, int[] arr) {
//         // Using a set to avoid duplicate triplets
//         Set<List<Integer>> st = new HashSet<>();

//         for (int i = 0; i < n; i++) {
//             /*
//             Explanation of hashset:
//             - The `hashset` is created within the outer loop, so each new `arr[i]` starts with an empty `hashset`.
//             - As `j` moves forward from `i + 1`:
//               1. The `third` element required to make the triplet sum to zero is calculated.
//               2. The code checks if `third` already exists in `hashset`.
//                  - If it does, we’ve found a triplet with `arr[i]`, `arr[j]`, and `third`.
//               3. Then, `arr[j]` is added to `hashset` so that we remember this number was seen.
            
//             This approach avoids rechecking previous elements and ensures efficient lookups in O(1) time.
//             */
//             Set<Integer> hashset = new HashSet<>();
            
//             for (int j = i + 1; j < n; j++) {
//                 // Calculate the third element to make the sum zero
//                 int third = -(arr[i] + arr[j]);

//                 // If the third element is already in the set, we found a triplet
//                 if (hashset.contains(third)) {
//                     List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
//                     temp.sort(null); // Sort to avoid duplicate orders
//                     st.add(temp);     // Add sorted triplet to the set
//                 }
//                 hashset.add(arr[j]); // Add the current element to the set
//             }
//         }

//         // Convert the set of triplets to a list
//         return new ArrayList<>(st);
//     }

//     public static void main(String[] args) {
//         int[] arr = { -1, 0, 1, 2, -1, -4 };
//         int n = arr.length;
//         List<List<Integer>> ans = triplet(n, arr);
        
//         // Print each triplet in the answer
//         for (List<Integer> triplet : ans) {
//             System.out.println(triplet);
//         }
//     }
// }

/*
Dry Run:

Array: { -1, 0, 1, 2, -1, -4 }

1. i = 0, arr[i] = -1
    - j = 1, arr[j] = 0
        - third = -(arr[i] + arr[j]) = -(-1 + 0) = 1
        - hashset = {0}
    - j = 2, arr[j] = 1
        - third = -(arr[i] + arr[j]) = -(-1 + 1) = 0
        - hashset contains 0, so triplet = [-1, 1, 0]
        - Add sorted triplet [-1, 0, 1] to set st
        - hashset = {0, 1}
    - j = 3, arr[j] = 2
        - third = -(arr[i] + arr[j]) = -(-1 + 2) = -1
        - hashset = {0, 1, 2}
    - j = 4, arr[j] = -1
        - third = -(arr[i] + arr[j]) = -(-1 + -1) = 2
        - hashset contains 2, so triplet = [-1, -1, 2]
        - Add sorted triplet [-1, -1, 2] to set st
        - hashset = {0, 1, 2, -1}
    - j = 5, arr[j] = -4
        - third = -(arr[i] + arr[j]) = -(-1 + -4) = 5
        - hashset = {0, 1, 2, -1, -4}

2. i = 1, arr[i] = 0
    - j = 2, arr[j] = 1
        - third = -(arr[i] + arr[j]) = -(0 + 1) = -1
        - hashset = {1}
    - j = 3, arr[j] = 2
        - third = -(arr[i] + arr[j]) = -(0 + 2) = -2
        - hashset = {1, 2}
    - j = 4, arr[j] = -1
        - third = -(arr[i] + arr[j]) = -(0 + -1) = 1
        - hashset contains 1, so triplet = [0, -1, 1]
        - Add sorted triplet [-1, 0, 1] to set st (already exists, so no change)
        - hashset = {1, 2, -1}
    - j = 5, arr[j] = -4
        - third = -(arr[i] + arr[j]) = -(0 + -4) = 4
        - hashset = {1, 2, -1, -4}

3. i = 2, arr[i] = 1
    - j = 3, arr[j] = 2
        - third = -(arr[i] + arr[j]) = -(1 + 2) = -3
        - hashset = {2}
    - j = 4, arr[j] = -1
        - third = -(arr[i] + arr[j]) = -(1 + -1) = 0
        - hashset = {2, -1}
    - j = 5, arr[j] = -4
        - third = -(arr[i] + arr[j]) = -(1 + -4) = 3
        - hashset = {2, -1, -4}

4. i = 3, arr[i] = 2
    - j = 4, arr[j] = -1
        - third = -(arr[i] + arr[j]) = -(2 + -1) = -1
        - hashset = {-1}
    - j = 5, arr[j] = -4
        - third = -(arr[i] + arr[j]) = -(2 + -4) = 2
        - hashset = {-1, -4}

5. i = 4, arr[i] = -1
    - j = 5, arr[j] = -4
        - third = -(arr[i] + arr[j]) = -(-1 + -4) = 5
        - hashset = {-4}

Final Output:
Set st = {[-1, 0, 1], [-1, -1, 2]}
Answer = [[-1, 0, 1], [-1, -1, 2]]
*/




// OPTIMAL - APPROACH
// Time Complexity: O(NlogN)+O(N2), where N = size of the array.
// Reason: The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 

// Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> triplet(int n, int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);  // Sort the array to make it easier to skip duplicates and use two pointers

        for (int i = 0; i < n; i++) {
            // Skip duplicates for the `i` index to avoid repeated triplets
            if (i != 0 && arr[i] == arr[i - 1]) continue;   //*i != 0: Ye ensure karta hai ki hum array ke starting index i = 0 pe pehle check na karein kyunki i - 1 out of bounds hoga (i.e., array ke range ke bahar).

            // Initialize two pointers: `j` starts right after `i`, `k` starts at the end of the array
            int j = i + 1;
            int k = n - 1;

            // Move the two pointers to find triplets with sum equal to zero
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0) {  // Sum is too small, move `j` to the right to increase it
                    j++;
                } else if (sum > 0) {  // Sum is too large, move `k` to the left to decrease it
                    k--;
                } else {  // Found a triplet with sum equal to zero
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);

                    // Move both pointers to look for the next unique triplet
                    j++;
                    k--;

                     // Ye check karta hai ki kya current value arr[j] pichle value arr[j - 1] ke barabar hai ya nahi.
                     // Agar barabar hai, toh j ko increment karte hain taaki next distinct value pe chale jaaye.
                     // Isse duplicate triplets result mein nahi aate.
                     // while (j < k && arr[k] == arr[k + 1]) k--;:
                     
                     // Ye check karta hai ki kya current value arr[k] agle value arr[k + 1] ke barabar hai ya nahi.
                     // Agar barabar hai, toh k ko decrement karte hain taaki next distinct value pe chale jaaye.
                     // Isse right side se bhi duplicate triplets avoid hote hain.
                    // Skip duplicate values for `j` and `k` to avoid repeated triplets
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int n = arr.length;
        List<List<Integer>> ans = triplet(n, arr);

        // Print each triplet in the answer
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
