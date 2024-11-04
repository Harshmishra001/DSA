
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



import java.util.*;
// BRUTE-FORCE APPROACH

// Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.
// Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

// Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
public class ThreeSum {
    public static List<List<Integer>> triplet(int n, int[] arr) {

        // Using a set to avoid duplicate triplets
        Set<List<Integer>> st = new HashSet<>();

        // Check all possible triplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Check if the triplet sums up to zero
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        // Create a list to store the triplet
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        // Sort the triplet to maintain consistency
                        temp.sort(null);
                        // Add the sorted triplet to the set to ensure uniqueness
                        st.add(temp);
                    }
                }
            }
        }

        // Convert the set to a list for the final answer
        return new ArrayList<>(st);
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = triplet(n, arr);
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
