// Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times 
// in the array. If no such element exists, return an empty vector.

//*Pre-requisite: Majority Element(>N/2 times)

// Examples
// Example 1:
// Input Format
// : N = 5, array[] = {1,2,2,3,2}
// Result
// : 2
// Explanation:
//  Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

// Example 2:
// Input Format
// :  N = 6, array[] = {11,33,33,11,33,11}
// Result:
//  11 33
// Explanation:
//  Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.


// BRUTE-FORCE APPROACH

// Time Complexity: O(N2), where N = size of the given array.
// Reason: For every element of the array the inner loop runs for N times. And there are N elements in the array. So, the total time complexity is O(N2).

// *Space Complexity: O(1) as we are using a list that stores a maximum of 2 elements. The space used is so small that it can be considered constan

// import java.util.*;
// public class MajorityElementTwo {
//     public static List<Integer> majorityElement(int []v) {
        
//         int n = v.length; // size of the array
//         List<Integer> ls = new ArrayList<>(); // list of answers

//         for (int i = 0; i < n; i++) {
//             // selected element is v[i]:
//             // Checking if v[i] is not already
//             // a part of the answer:
//             if (ls.size() == 0 || ls.get(0) != v[i]) {   //MTLB LIST  KHALI H   OR  JO LIST MILI H FINAL OUTPUT M USME JO MAJORITY ELEMENT ADD KIYE H HUMNE VO DUPLICATE TOH NHI KIYE VO CHECK KR RE H 
//                 int cnt = 0;
//                 for (int j = 0; j < n; j++) {
//                     // counting the frequency of v[i]
//                     if (v[j] == v[i]) {
//                         cnt++;
//                     }
//                 }

//                 // check if frequency is greater than n/3:
//                 if (cnt > (n / 3))
//                     ls.add(v[i]);
//             }

//             if (ls.size() == 2) break;  //JESE HI 2 ELEMENT HOJAYE TOTAL LIST M TOH RUK JAO BS 2 HI CHAHIYE
//         }

//         return ls;
//     }

//     public static void main(String args[]) {
//         int[] arr = {11, 33, 33, 11, 33, 11};
//         List<Integer> ans = majorityElement(arr);
//         System.out.print("The majority elements are: ");
//         for (int i = 0; i < ans.size(); i++) {
//             System.out.print(ans.get(i) + " ");
//         }
//         System.out.println();
//     }
// }

/* 
Dry Run:
Input: arr = {11, 33, 33, 11, 33, 11}

1. Initialize:
   - n = 6
   - ls = []

2. i = 0:
   - v[i] = 11
   - ls is empty, so proceed to count occurrences of 11.
   - cnt = 0
   - Loop through array to count 11:
     - arr[0] == 11 -> cnt = 1
     - arr[1] != 11
     - arr[2] != 11
     - arr[3] == 11 -> cnt = 2
     - arr[4] != 11
     - arr[5] == 11 -> cnt = 3
   - cnt = 3, which is greater than n/3 (6/3 = 2).
   - Add 11 to ls -> ls = [11]

3. i = 1:
   - v[i] = 33
   - ls contains 11, not 33, so proceed to count occurrences of 33.
   - cnt = 0
   - Loop through array to count 33:
     - arr[0] != 33
     - arr[1] == 33 -> cnt = 1
     - arr[2] == 33 -> cnt = 2
     - arr[3] != 33
     - arr[4] == 33 -> cnt = 3
     - arr[5] != 33
   - cnt = 3, which is greater than n/3 (6/3 = 2).
   - Add 33 to ls -> ls = [11, 33]

4. i = 2:
   - ls size is 2, so the loop breaks.

Output:
The majority elements are: 11 33
*/




// BETTER APPROACH (USING HASHING)

// Time Complexity: O(N*logN), where N = size of the given array.
// Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN).
// If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

// Space Complexity: O(N) as we are using a map data structure. We are also using a list that stores a maximum of 2 elements. That space used is so small that it can be considered constant.


// import java.util.*;

// public class MajorityElementTwo {
//     public static List<Integer> majorityElement(int []v) {

//         int n = v.length; // size of the array
//         List<Integer> ls = new ArrayList<>(); // list to store results

//         // Declaring a map to store occurrences of each element
//         HashMap<Integer, Integer> mpp = new HashMap<>();

//         // Minimum occurrences for an element to be considered a majority element
//         int mini = (int)(n / 3) + 1;

//         // Storing elements and their occurrences
//         for (int i = 0; i < n; i++) {
//             // Update the occurrence count for v[i] in the map
//             int value = mpp.getOrDefault(v[i], 0);
//             mpp.put(v[i], value + 1);

//             // Check if v[i] has reached the minimum count to be a majority element
//             if (mpp.get(v[i]) == mini) {
//                 ls.add(v[i]);
//             }

//             // Break if we already have 2 majority elements
//             if (ls.size() == 2) break;
//         }

//         return ls;
//     }

//     public static void main(String args[]) {
//         int[] arr = {11, 33, 33, 11, 33, 11};
//         List<Integer> ans = majorityElement(arr);
//         System.out.print("The majority elements are: ");
//         for (int i = 0; i < ans.size(); i++) {
//             System.out.print(ans.get(i) + " ");
//         }
//         System.out.println();
//     }
// }

/* 
Dry Run:
Input: arr = {11, 33, 33, 11, 33, 11}

1. Initialize:
   - n = 6
   - ls = []
   - mpp = {} (empty map)
   - mini = (n / 3) + 1 = 6 / 3 + 1 = 2 + 1 = 3

2. Iterate through each element in the array:

   - i = 0:
     - v[i] = 11
     - Current map: mpp = {}
     - Update occurrence: mpp[11] = 1
     - mpp[11] < mini, so no addition to `ls`.

   - i = 1:
     - v[i] = 33
     - Current map: mpp = {11=1}
     - Update occurrence: mpp[33] = 1
     - mpp[33] < mini, so no addition to `ls`.

   - i = 2:
     - v[i] = 33
     - Current map: mpp = {11=1, 33=1}
     - Update occurrence: mpp[33] = 2
     - mpp[33] < mini, so no addition to `ls`.

   - i = 3:
     - v[i] = 11
     - Current map: mpp = {11=1, 33=2}
     - Update occurrence: mpp[11] = 2
     - mpp[11] < mini, so no addition to `ls`.

   - i = 4:
     - v[i] = 33
     - Current map: mpp = {11=2, 33=2}
     - Update occurrence: mpp[33] = 3
     - mpp[33] == mini, so add 33 to `ls` -> ls = [33]

   - i = 5:
     - v[i] = 11
     - Current map: mpp = {11=2, 33=3}
     - Update occurrence: mpp[11] = 3
     - mpp[11] == mini, so add 11 to `ls` -> ls = [33, 11]

3. Terminate loop as `ls.size() == 2`.

Output:
The majority elements are: 33 11
*/



// OPTIMAL APPROACH

// Time Complexity: O(N) + O(N), where N = size of the given array.
// Reason: The first O(N) is to calculate the counts and find the expected majority elements. The second one is to check if the calculated elements are the majority ones or not.

// Space Complexity: O(1) as we are only using a list that stores a maximum of 2 elements. The space used is so small that it can be considered constant.


import java.util.*;

public class MajorityElementTwo {
    public static List<Integer> majorityElement(int []v) {
        int n = v.length; // size of the array

        int cnt1 = 0, cnt2 = 0; // counts for two candidates
        int el1 = Integer.MIN_VALUE; // first potential majority element
        int el2 = Integer.MIN_VALUE; // second potential majority element

        // Applying the Extended Boyer-Moore Voting Algorithm
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != v[i]) {
                // Assign v[i] as the first candidate if cnt1 is zero
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && el1 != v[i]) {
                // Assign v[i] as the second candidate if cnt2 is zero
                cnt2 = 1;
                el2 = v[i];
            } else if (el1 == v[i]) {
                // Increment cnt1 if v[i] matches el1
                cnt1++;
            } else if (el2 == v[i]) {
                // Increment cnt2 if v[i] matches el2
                cnt2++;
            } else {
                // Decrement both counts if v[i] matches neither candidate
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list to store results

        // Reset counts to verify if el1 and el2 occur more than n/3 times
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1) cnt1++;
            if (v[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini && el2 != el1) ls.add(el2);

        return ls;
    }

    public static void main(String args[]) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

/* 
Dry Run:
Input: arr = {11, 33, 33, 11, 33, 11}

1. Initialize:
   - n = 6
   - cnt1 = 0, cnt2 = 0
   - el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE

2. First Pass: Identifying potential majority candidates
   - i = 0:
     - v[i] = 11
     - cnt1 == 0 and el2 != 11, so:
       - cnt1 = 1, el1 = 11

   - i = 1:
     - v[i] = 33
     - cnt2 == 0 and el1 != 33, so:
       - cnt2 = 1, el2 = 33

   - i = 2:
     - v[i] = 33
     - v[i] == el2, so:
       - cnt2 = 2

   - i = 3:
     - v[i] = 11
     - v[i] == el1, so:
       - cnt1 = 2

   - i = 4:
     - v[i] = 33
     - v[i] == el2, so:
       - cnt2 = 3

   - i = 5:
     - v[i] = 11
     - v[i] == el1, so:
       - cnt1 = 3

   After the first pass:
   - el1 = 11, cnt1 = 3
   - el2 = 33, cnt2 = 3

3. Second Pass: Verify counts of el1 and el2
   - Reset cnt1 = 0, cnt2 = 0
   - Count occurrences of el1 (11) and el2 (33) in the array:
     - 11 appears 3 times -> cnt1 = 3
     - 33 appears 3 times -> cnt2 = 3

4. Check if counts meet the majority condition:
   - mini = (n / 3) + 1 = (6 / 3) + 1 = 2 + 1 = 3
   - cnt1 >= mini, so add el1 (11) to `ls`
   - cnt2 >= mini, so add el2 (33) to `ls`

5. Result:
   - ls = [11, 33]

Output:
The majority elements are: 11 33
*/
