//* Pre-requisite: Median of 2 sorted arrays

// Problem Statement: Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at 
// the kth position of the final sorted array.

// Disclaimer: Don’t jump directly to the solution, try it out yourself first. Problem Link




// Brute Force 

// Time Complexity: O(m+n), where m and n are the sizes of the given arrays.
// Reason: We traverse through both arrays linearly.

// Space Complexity: O(m+n), where m and n are the sizes of the given arrays.

// Reason: We are using an extra array of size (m+n) to solve this problem.

// import java.util.*;

// public class  KthEleOfTwoSortedArray {
    
//     // Function to find the k-th element from two sorted arrays
//     public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        
//         // Create a new ArrayList to store the merged elements
//         ArrayList<Integer> arr3 = new ArrayList<>();
        
//         // Initialize two pointers i and j for both arrays a and b respectively
//         int i = 0, j = 0;
        
//         // Merge the two sorted arrays a and b into arr3
//         while (i < m && j < n) {
//             // If the current element in a is smaller, add it to arr3
//             if (a.get(i) < b.get(j)) {
//                 arr3.add(a.get(i++));
//             }
//             // Otherwise, add the current element in b to arr3
//             else {
//                 arr3.add(b.get(j++));
//             }
//         }

//         // If there are remaining elements in a, add them to arr3
//         while (i < m) {
//             arr3.add(a.get(i++));
//         }
        
//         // If there are remaining elements in b, add them to arr3
//         while (j < n) {
//             arr3.add(b.get(j++));
//         }
        
//         // Return the k-th element (k-1 due to 0-based index in ArrayList)
//         return arr3.get(k - 1);
//     }
    
//     // Main method to test the kthElement function
//     public static void main(String[] args) {
        
//         // Create two sorted ArrayLists a and b
//         ArrayList<Integer> a = new ArrayList<>();
//         a.add(2); a.add(3); a.add(6); a.add(7); a.add(9);
        
//         ArrayList<Integer> b = new ArrayList<>();
//         b.add(1); b.add(4); b.add(8); b.add(10);
        
//         // Call the kthElement function and print the result
//         System.out.println("The k-th element of two sorted arrays is: " +
//                            kthElement(a, b, a.size(), b.size(), 5)); // Looking for the 5th element
//     }
// }

// Example Walkthrough (for k = 5):
// Initial Arrays:

// a = [2, 3, 6, 7, 9]
// b = [1, 4, 8, 10]
// Step 1: Start Merging:

// Initialize pointers: i = 0, j = 0
// Compare a[i] and b[j]:
// a[0] = 2 and b[0] = 1: b[0] < a[0], so add 1 to arr3.
// arr3 = [1], increment j.
// a[0] = 2 and b[1] = 4: a[0] < b[1], so add 2 to arr3.
// arr3 = [1, 2], increment i.
// a[1] = 3 and b[1] = 4: a[1] < b[1], so add 3 to arr3.
// arr3 = [1, 2, 3], increment i.
// a[2] = 6 and b[1] = 4: b[1] < a[2], so add 4 to arr3.
// arr3 = [1, 2, 3, 4], increment j.
// a[2] = 6 and b[2] = 8: a[2] < b[2], so add 6 to arr3.
// arr3 = [1, 2, 3, 4, 6], increment i.
// Step 2: Remaining Elements:

// Now, i = 3, j = 2, and we still have elements in a:
// a[3] = 7 and b[2] = 8: a[3] < b[2], so add 7 to arr3.
// arr3 = [1, 2, 3, 4, 6, 7], increment i.
// Now, i = 4, j = 2, and we still have elements in a:
// a[4] = 9 and b[2] = 8: b[2] < a[4], so add 8 to arr3.
// arr3 = [1, 2, 3, 4, 6, 7, 8], increment j.
// Now, i = 4, j = 3, and we still have elements in a:
// a[4] = 9 and b[3] = 10: a[4] < b[3], so add 9 to arr3.
// arr3 = [1, 2, 3, 4, 6, 7, 8, 9], increment i.
// Now, i = 5, j = 3, and we are done merging.
// Step 3: Merged Array:

// The merged array arr3 is: [1, 2, 3, 4, 6, 7, 8, 9, 10].
// Step 4: Return the k-th Element:

// We want the 5th element (k = 5), so we return arr3[4] which is 6.

// Final Output:
// The k-th element of two sorted arrays is: 6









// Optimal Approach

// Time Complexity: O(log(min(m, n))), where m and n are the sizes of two given arrays.
// Reason: We are applying binary search on the range [max(0, k-n2), min(k, n1)]. The range length <= min(m, n).

// Space Complexity: O(1), as we are not using any extra space to solve this problem.


import java.util.*;

public class KthEleOfTwoSortedArray {

    // Function to find the k-th element from two sorted arrays using binary search
    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        
        // Ensure that the first array is the smaller one
        if (m > n) return kthElement(b, a, n, m, k); // If m is greater than n, swap arrays

        int left = k; // The length of the left half of the merged array
        
        // Binary search initialization: low and high represent the range in the smaller array (a)
        int low = Math.max(0, k - n); // low cannot be less than 0, and must be at least k - n
        int high = Math.min(k, m); // high cannot exceed k or m
        
        // Binary search loop
        while (low <= high) {
            int mid1 = (low + high) / 2; // Midpoint in array a using division
            int mid2 = left - mid1; // Corresponding midpoint in array b

            // Calculate the boundary elements: l1, l2, r1, r2
            int l1 = (mid1 > 0) ? a.get(mid1 - 1) : Integer.MIN_VALUE;  // Left element of a
            int l2 = (mid2 > 0) ? b.get(mid2 - 1) : Integer.MIN_VALUE;  // Left element of b
            int r1 = (mid1 < m) ? a.get(mid1) : Integer.MAX_VALUE;       // Right element of a
            int r2 = (mid2 < n) ? b.get(mid2) : Integer.MAX_VALUE;       // Right element of b

            // Check if the partition is correct:
            if (l1 <= r2 && l2 <= r1) {
                // The k-th element is the maximum of the left elements (l1, l2)
                return Math.max(l1, l2);
            }
            
            // If the left element of a (l1) is too large, reduce the range in a (move left)
            else if (l1 > r2) 
               high = mid1 - 1;
            
            // Otherwise, increase the range in a (move right)
            else low = mid1 + 1;
        }

        return 0; // Dummy statement, this should never be reached if inputs are valid
    }

    // Main method to test the kthElement function
    public static void main(String[] args) {
        // Create two sorted ArrayLists a and b
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2); a.add(3); a.add(6); a.add(7); a.add(9);
        
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1); b.add(4); b.add(8); b.add(10);
        
        // Call the kthElement function and print the result
        System.out.println("The k-th element of two sorted arrays is: " +
                           kthElement(a, b, a.size(), b.size(), 5)); // Looking for the 5th element
    }
}
