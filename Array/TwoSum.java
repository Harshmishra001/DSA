// Given an array arr of positive integers and another number target. 
// Determine whether two elements exist in arr whose sum is exactly target or not. Return a boolean value 
// true if two elements exist in arr else return false.

// Examples:

// Input: arr[] = [1, 4, 45, 6, 10, 8], target =16
// Output: true
// Explanation: arr[3] + arr[4] = 6 + 10 = 16

// Input: arr[] = [1, 2, 4, 3, 6], target = 11
// Output: false
// Explanation: None of the pair makes a sum of 11


// BRUTE FORCE APPROACH
// class 2Sum {
//     boolean twoSum(int arr[], int target) {
//         // code here
//         int sum=0;
//         for(int i=0;i<arr.length-1;i++){     //arr.length-1 mtln n-1-1 => n-2
//          for(int j=i+1;j<arr.length;j++){     //arr.length mtln n-1
//             if(arr[i]+arr[j]==target){
//                 return true;
//             }
//          }
//         }
//         return false;
//     }
// }

// TIME COMPLEXITY: O(n^2)
// SPACE COMPLEXITY: O(1)


// OPTIMAL APPROACH
// Time Complexity: O(N), where N = size of the array.
// Reason: The loop runs N times in the worst case and searching in a hashmap takes O(1) generally. So the time complexity is O(N).

// Note: In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the time complexity will be O(N2). If we use map instead of unordered_map, the time complexity will be O(N* logN) as the map data structure takes logN time to find an element.

// Space Complexity: O(N) as we use the map data structure.


// import java.util.*;
// class TwoSum {
//     boolean twoSum(int arr[], int target) {
//         // code here
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<arr.length;i++){
//             int complement=target-arr[i];
//             if(map.containsKey(complement)){
//                 return true;
//             }
//             map.put(arr[i],i);
//         }
//         return false;
//     }
//     public static void main(String[]args){
//         TwoSum ts=new TwoSum();
//         int arr[]={1,4,45,10,8};
//         int n = arr.length;
//         int target=16;
//         System.out.println(ts.twoSum(arr,target));
        

//     }
// }



// Optimized Approach(using two-pointer): 
// Time Complexity: O(nlogn)
// Space Complexity: 𝑂(1)

import java.util.*;

public class TwoSum {
    public static boolean twoSum(int n, int[] arr, int target) {
        Arrays.sort(arr); // Sort the array to use the two-pointer technique
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true; // Return true if a pair is found
            } else if (sum < target) {
                left++; // Move the left pointer to increase the sum
            } else {
                right--; // Move the right pointer to decrease the sum
            }
        }
        return false; // Return false if no pair is found
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        boolean ans = twoSum(n, arr, target); // Get boolean result
        System.out.println("This is the answer for variant 1: " + (ans ? "YES" : "NO"));
    }
}

// Output: This is the answer for variant 1: YES

// Note: For variant 2, we can store the elements of the array along with its index in a new array. Then the rest of the code will be similar. And while returning, we need to return the stored indices instead of returning “YES”. But for this variant, the recommended approach is approach 2 i.e. hashing approach.

// Time Complexity: O(N) + O(N*logN), where N = size of the array.
// Reason: The loop will run at most N times. And sorting the array will take N*logN time complexity.

// Space Complexity: O(1) as we are not using any extra space.

// Note: Here we are distorting the given array. So, if we need to consider this change, the space complexity will be O(N).

