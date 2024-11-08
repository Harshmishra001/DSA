
// Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a 
// target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], 
// arr[d]] such that their sum is equal to a given target.

// * Pre-req: 3-sum problem and 2-sum problem

// Note:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// arr[a] + arr[b] + arr[c] + arr[d] == target

// Examples
// Example 1:
// Input Format:
//  arr[] = [1,0,-1,0,-2,2], target = 0
// Result:
//  [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Explanation:
//  We have to find unique quadruplets from the array such that the sum of those elements is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

// Example 2:
// Input Format:
//  arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
// Result:
//  [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
// Explanation:
//  The sum of all the quadruplets is equal to the target i.e. 9.


//BRUTE - FORCE APPROACH 

// Time Complexity: O(N4), where N = size of the array.
// Reason: Here, we are mainly using 4 nested loops. But we not considering the time complexity of sorting
//  as we are just sorting 4 elements every time.

// Space Complexity: O(2 * no. of the quadruplets) as we are using a set data structure and a list to store the quads.


// import java.util.*;

// public class FourSum {

//     public static List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length; // size of the array
//         Set<List<Integer>> set = new HashSet<>();

//         // checking all possible quadruplets:
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     for (int l = k + 1; l < n; l++) {
//                         // taking bigger data type
//                         // to avoid integer overflow:
//                         long sum = (long)nums[i] + nums[j];
//                         sum += nums[k];
//                         sum += nums[l];

//                         if (sum == target) {
//                             List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                             Collections.sort(temp);
//                             set.add(temp);
//                         }
//                     }
//                 }
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>(set);
//         return ans;
//     }

//     public static void main(String[] args) {
//         int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
//         int target = 9;
//         List<List<Integer>> ans = fourSum(nums, target);
//         System.out.println("The quadruplets are: ");
//         for (List<Integer> it : ans) {
//             System.out.print("[");
//             for (int ele : it) {
//                 System.out.print(ele + " ");
//             }
//             System.out.print("] ");
//         }
//         System.out.println();
//     }
// }








//  BETTER-APPROACH

// Time Complexity: O(N3*log(M)), where N = size of the array, M = no. of elements in the set.
// Reason: Here, we are mainly using 3 nested loops, and inside the loops there are some operations on the set data structure which take log(M) time complexity.

// Space Complexity: O(2 * no. of the quadruplets)+O(N)
// Reason: we are using a set data structure and a list to store the quads. This results in the first term. And the second space is taken by the set data structure we are using to store the array elements. At most, the set can contain approximately all the array elements and so the space complexity is O(N).

// import java.util.*;

// public class FourSum {
//     // Function to find all unique quadruplets that sum up to the target.
//     public static List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length; // Size of the array
//         Set<List<Integer>> st = new HashSet<>(); // Set to store unique quadruplets
//         // Checking all possible quadruplets:
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 Set<Long> hashset = new HashSet<>(); // HashSet to check for the fourth element
//                 for (int k = j + 1; k < n; k++) {
//                     // Using long to avoid integer overflow
//                     long sum = nums[i] + nums[j];
//                     sum += nums[k];
//                     long fourth = target - sum; // Calculate the fourth element needed
//                     // Check if the fourth element exists in the hashset
//                     if (hashset.contains(fourth)) {
//                         List<Integer> temp = new ArrayList<>();
//                         temp.add(nums[i]);
//                         temp.add(nums[j]);
//                         temp.add(nums[k]);
//                         temp.add((int) fourth);
//                         temp.sort(Integer::compareTo); // Sort to avoid duplicate order
//                         st.add(temp); // Add the sorted quadruplet to the set
//                     }
//                     // Add the current element to the hashset
//                     hashset.add((long) nums[k]);
//                 }
//             }
//         }
//         // Convert the set to a list and return
//         List<List<Integer>> ans = new ArrayList<>(st);
//         return ans;
//     }

//     public static void main(String[] args) {
//         int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
//         int target = 9;
//         List<List<Integer>> ans = fourSum(nums, target);

//         System.out.println("The quadruplets are: ");
//         for (List<Integer> it : ans) {
//             System.out.print("[");
//             for (Integer ele : it) {
//                 System.out.print(ele + " ");
//             }
//             System.out.print("] ");
//         }
//         System.out.println();
//     }
// }

/*
DRY RUN:
Input:
nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1}
target = 9

Step-by-Step Execution:

1. i = 0, nums[i] = 4
   - j = 1, nums[j] = 3
     - Initialize hashset
     - k = 2, nums[k] = 3
       - sum = 4 + 3 + 3 = 10
       - fourth = target - sum = 9 - 10 = -1 (not in hashset)
       - Add nums[k] (3) to hashset
     - k = 3, nums[k] = 4
       - sum = 4 + 3 + 4 = 11
       - fourth = target - sum = 9 - 11 = -2 (not in hashset)
       - Add nums[k] (4) to hashset
     - k = 4, nums[k] = 4
       - sum = 4 + 3 + 4 = 11
       - fourth = 9 - 11 = -2 (not in hashset)
       - Add nums[k] (4) to hashset
     - k = 5, nums[k] = 2
       - sum = 4 + 3 + 2 = 9
       - fourth = 9 - 9 = 0 (not in hashset)
       - Add nums[k] (2) to hashset
     - k = 6, nums[k] = 1
       - sum = 4 + 3 + 1 = 8
       - fourth = 9 - 8 = 1 (in hashset)
       - Found quadruplet: [4, 3, 1, 1], add to set (sorted as [1, 1, 3, 4])
     - k = 7, nums[k] = 2
       - sum = 4 + 3 + 2 = 9
       - fourth = 9 - 9 = 0 (not in hashset)
       - Add nums[k] (2) to hashset
     - k = 8, nums[k] = 1
       - sum = 4 + 3 + 1 = 8
       - fourth = 9 - 8 = 1 (in hashset)
       - Found quadruplet: [4, 3, 1, 1], add to set (already exists, skipped)
     - k = 9, nums[k] = 1
       - sum = 4 + 3 + 1 = 8
       - fourth = 9 - 8 = 1 (in hashset)
       - Found quadruplet: [4, 3, 1, 1], add to set (already exists, skipped)

2. Continue with next iterations for i, j pairs...

Final Result:
The quadruplets are: [1, 1, 3, 4] [1, 2, 2, 4]

Output:
The quadruplets are:
[1 1 3 4] [1 2 2 4]
*/


// OPTIMAL APPROACH








