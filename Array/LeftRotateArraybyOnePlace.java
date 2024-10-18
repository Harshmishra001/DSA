// Problem Statement: Given an array of N integers, left rotate the array by one place.

// Example 1:
// Input:
//  N = 5, array[] = {1,2,3,4,5}
// Output:
//  2,3,4,5,1
// Explanation:
 
// Since all the elements in array will be shifted 
// toward left by one so ‘2’ will now become the 
// first index and and ‘1’ which was present at 
// first index will be shifted at last.


// Example 2:
// Input:
//  N = 1, array[] = {3}
// Output:
//  3
// Explanation:
//  Here only element is present and so 
// the element at first index will be shifted to 
// last index which is also by the way the first index.



import java.util.*;

class LeftRotateArraybyOnePlace{
// BRUTE-FORCE APPROACH 

// Time Complexity: O(n), as we iterate through the array only once.
// Space Complexity: O(n) as we are using another array of size, same as the given array.

// static void solve(int arr[], int n) {

//   int temp[]=new int[n];   // SPACE-O(N)

//   for (int i = 1; i < n; i++) {
//     temp[i - 1] = arr[i];
//   }

//   temp[n - 1] = arr[0];

//   for (int i = 0; i < n; i++) {
//     System.out.print(temp[i]+" ");
//   }
  
// }
// public static void main(String args[]) {
//   int n=5;
  
//   int arr[]= {1,2,3,4,5};
//   solve(arr, n);
// }

// OPTIMAL APPROACH

// Time Complexity: O(n), as we iterate through the array only once.

// Space Complexity: O(1) as no extra space is used


static void solve(int arr[], int n) {

  int temp = arr[0]; // storing the first element of array in a variable

  for (int i = 0; i < n - 1; i++) {
    arr[i] = arr[i + 1];
  }

  arr[n - 1] = temp; // assigned the value of variable at the last index

  for (int i = 0; i < n; i++) {
    System.out.print(arr[i]+" ");
  } 
}

public static void main(String args[]) {
  int n=5;
  
  int arr[]= {1,2,3,4,5};
  solve(arr, n);
}

}

