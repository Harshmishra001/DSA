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
import java.util.*;
class TwoSum {
    boolean twoSum(int arr[], int target) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement=target-arr[i];
            if(map.containsKey(complement)){
                return true;
            }
            map.put(arr[i],i);
        }
        return false;
    }
    public static void main(String[]args){
        TwoSum ts=new TwoSum();
        int arr[]={1,4,45,10,8};
        int n = arr.length;
        int target=16;
        System.out.println(ts.twoSum(arr,target));
        

    }
}

