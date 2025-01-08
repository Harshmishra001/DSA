package BinarySearch;

// Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
// Allocate books in such a way that:

// Each student gets at least one book.
// Each book should be allocated to only one student.
// Book allocation should be in a contiguous manner.
// You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1

// Examples
// Example 1:
// Input Format:
//  n = 4, m = 2, arr[] = {12, 34, 67, 90}
// Result:
//  113
// Explanation:
//  The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

// Example 2:
// Input Format:
//  n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
// Result:
//  71
// Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.



// brute force 

// Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible numbers of pages. Inside the loop, we are calling the countStudents() function for each number. Now, inside the countStudents() function, we are using a loop that runs for N times.

// Space Complexity:  O(1) as we are not using any extra space to solve this problem.

// import java.util.*;

// public class BookAllocation {

//     // Function to count the number of students required to allocate books
//     public static int countStudents(int[] arr, int pages) {
//         int n = arr.length; // size of array
//         int students = 1; // At least one student is needed
//         long pagesStudent = 0; // Pages assigned to the current student
        
//         // Iterate through each book
//         for (int i = 0; i < n; i++) {
//             if (pagesStudent + arr[i] <= pages) {
//                 // If the current student can take the book
//                 pagesStudent += arr[i];
//             } else {
//                 // If the current student can't take the book, assign it to the next student
//                 students++;
//                 pagesStudent = arr[i];
//             }
//         }
//         return students; // Return the number of students required
//     }

//     // Function to find the minimum number of pages
//     public static int findPages(int[] arr, int n, int m) {
//         // If the number of students is greater than the number of books, it's impossible to allocate
//         if (m > n) 
//             return -1;

//         // Initialize the low and high bounds for binary search
//         int low = Arrays.stream(arr).max().getAsInt(); // The max pages in a single book
//         int high = Arrays.stream(arr).sum(); // The total sum of all book pages

//         // Perform brute-force search to find the optimal solution
//         for (int pages = low; pages <= high; pages++) {
//             if (countStudents(arr, pages) == m) {
//                 return pages; // Return the minimum pages that can be allocated to a student
//             }
//         }
//         return low; // Return the lowest possible pages as a fallback
//     }

//     public static void main(String[] args) {
//         // Array representing book pages
//         int[] arr = {12, 34, 67, 90};
//         int n = 4; // Number of books
//         int m = 2; // Number of students

//         // Find the optimal page allocation
//         int ans = findPages(arr, n, m);

//         // Print the result
//         System.out.println("The answer is: " + ans);
//     }
// }

/* 
Test Case:
n = 4, m = 2, arr[] = {12, 34, 67, 90}

Steps:
1. Initial Setup:
Books: {12, 34, 67, 90}
Number of books: n = 4
Number of students: m = 2

2. Calling findPages Function:

Step 1: Checking for Validity:
We first check if m > n. If m is greater than n, it's impossible to allocate books, but here m = 2 and n = 4, so it's valid.

Step 2: Set low and high:
low = max(arr) = 90 (The book with the maximum number of pages)
high = sum(arr) = 12 + 34 + 67 + 90 = 203 (The total sum of all book pages)
We need to perform a brute-force search to find the minimum value for the maximum pages a student gets.

3. Performing the Search for pages (Brute Force Loop):
We will iterate over the possible values of pages from low = 90 to high = 203.

For pages = 90:
Calling countStudents(arr, 90):

We want to check if we can allocate books to 2 students such that no student gets more than 90 pages.
Steps for Allocation:

First student: pagesStudent = 0
Assign 12 → pagesStudent = 12
Assign 34 → pagesStudent = 12 + 34 = 46
Assign 67 → pagesStudent = 46 + 67 = 113 (this exceeds 90, so we allocate the next book to the next student)
Second student: pagesStudent = 0
Assign 67 → pagesStudent = 67
Assign 90 → pagesStudent = 90
We require 2 students, but the total pages for the second student is 67 + 90 = 157, which exceeds 90. This is not valid.

For pages = 113:
Calling countStudents(arr, 113):

We want to check if we can allocate books to 2 students such that no student gets more than 113 pages.
Steps for Allocation:

First student: pagesStudent = 0
Assign 12 → pagesStudent = 12
Assign 34 → pagesStudent = 12 + 34 = 46
Assign 67 → pagesStudent = 46 + 67 = 113
Second student: pagesStudent = 0
Assign 90 → pagesStudent = 90
We now have allocated the books to exactly 2 students:

First student gets books with pages 12 + 34 + 67 = 113.
Second student gets books with pages 90.
The number of students required is exactly 2, and the maximum pages given to any student is 113. So, this is valid.

For pages = 114 to 203:
We keep increasing the value of pages and calling countStudents, but the result for pages = 113 will already be the minimal valid allocation because any higher value would give the same or a larger value for the maximum pages allocated to the students.

Conclusion:
The correct answer is 113, as the minimum possible maximum pages a student will have to read is 113.

Final Output:
The answer is: 113
*/




// Optimal Approach

// Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the countStudents() function for the value of ‘mid’. Now, inside the countStudents() function, we are using a loop that runs for N times.

// Space Complexity:  O(1) as we are not using any extra space to solve this problem.



import java.util.*;

public class BookAllocation {

    public static int countStudents(int[] arr, int pages) {
        
        int n = arr.length; // size of array
        int students = 1; // Start with one student
        long pagesStudent = 0; // Pages assigned to the current student
        
        // Iterate through the books array
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr[i] <= pages) {
                // If the current student can take the book, add its pages
                pagesStudent += arr[i];
            } else {
                // If the current student can't take the book, allocate to the next student
                students++;
                pagesStudent = arr[i];
            }
        }
        return students; // Return the number of students needed
    }

    public static int findPages(int[] arr, int n, int m) {
        // If there are more students than books, it's not possible
        if (m > n) 
            return -1;

        // Set the bounds for binary search
        int low = Arrays.stream(arr).max().getAsInt(); // Max pages of a single book
        int high = Arrays.stream(arr).sum(); // Sum of all book pages

        // Perform binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1; // If more than m students, try higher pages      ( remember)
            } else {
                high = mid - 1; // Otherwise, try lower pages
            }
        }
        return low; // Return the optimal max pages a student can take
    }

    public static void main(String[] args) {
        // Input array
        int[] arr = {25, 46, 28, 49, 24};
        int n = 5; // Number of books
        int m = 4; // Number of students

        // Calculate the optimal page allocation
        int ans = findPages(arr, n, m);

        // Print the result
        System.out.println("The answer is: " + ans);
    }
}
