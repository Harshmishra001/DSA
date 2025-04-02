
// Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the platform. 
// We need to find the minimum number of platforms needed at the railway station so that no train has to wait.

// Examples 1:

// Input: N=6, 
// arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00} 
// dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}

// Output:3
// Explanation: There are at-most three trains at a time. The train at 11:00 arrived but the trains which had arrived at 9:45
//  and 9:55 have still not departed. So, we need at least three platforms here.


// Brute force approach:
// Minimum number of Platforms required 3
// Time Complexity: O(n^2)  (due to two nested loops).
// Space Complexity: O(1)  (no extra space used).

// import java.util.*;
// class MinNoOfPlatform {
// static int countPlatforms(int n,int arr[],int dep[])
//  {
//     int ans=1; //final value
//     for(int i=0;i<=n-1;i++)
//     {
//         int count=1; // count of overlapping interval of only this   iteration
//         for(int j=i+1;j<=n-1;j++)
//         {
//             if((arr[i]>=arr[j] && arr[i]<=dep[j]) ||
//            (arr[j]>=arr[i] && arr[j]<=dep[i]))
//            {
//                count++;
//            }
//         }
//         ans=Math.max(ans,count); //updating the value
//     }
//     return ans;
//  }
 
 
// public static void main (String[] args) {
		
// 		int[] arr ={900,945,955,1100,1500,1800};
// 		int[] dep={920,1200,1130,1150,1900,2000};
// 		int n=arr.length;
// 		int totalCount=countPlatforms(n,arr,dep);
// 		System.out.println("Minimum number of Platforms required "+totalCount);
// 	}
// }

// Optimized approach:
// Time Complexity: O(nlogn)   (Sorting takes O(nlogn) and traversal of arrays takes O(n) so overall time complexity is O(nlogn)).
// Space complexity: O(1)   (No extra space used).

import java.util.*;
class MinNoOfPlatform {
    // Function to find the minimum number of platforms required at the railway station
    // such that no train waits.
    // arr[]: arrival time of trains
    // dep[]: departure time of trains
    // n: number of trains
    static int findPlatform(int arr[], int dep[], int n) {
        // Sort both arrival and departure arrays
        Arrays.sort(arr); 
        Arrays.sort(dep); 
  
        // Initialize variables:
        // plat_needed keeps track of platforms needed at a time
        // result stores the maximum platforms needed
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0; 
  
        // Traverse through all arrival and departure times
        while (i < n && j < n) { 
            // If the next train arrives before or when the current train departs,
            // increment the platform count
            if (arr[i] <= dep[j]) { 
                plat_needed++; 
                i++; // Move to the next arrival
            } 
            // If the next train arrives after the current train departs,
            // decrement the platform count
            else if (arr[i] > dep[j]) { 
                plat_needed--; 
                j++; // Move to the next departure
            } 
  
            // Update the result if the current platform count is greater than the result
            if (plat_needed > result) 
                result = plat_needed; 
        } 
  
        // Return the maximum number of platforms needed
        return result; 
    }

    public static void main (String[] args) {
        // Example input: arrival and departure times of trains
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int n = arr.length;

        // Call the function to find the minimum number of platforms required
        int totalCount = findPlatform(arr, dep, n);

        // Print the result
        System.out.println("Minimum number of Platforms required " + totalCount);
    }
}
// Output:

// Minimum number of Platforms required 3

