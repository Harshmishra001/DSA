


import java.util.*;

// BRUTE-FORCE APPROACH

// Time Complexity: O(N+N/2) = O(N) { O(N) for traversing the array once for segregating positives and negatives and another O(N/2) for adding those elements alternatively to the array, where N = size of the array A}.

// Space Complexity:  O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays, where N = size of the array A}.

class RearrangeAltrntlyPosNeg {

    // Method to rearrange the array by sign
    public static int[] RearrangebySign(int[] A, int n) {
        // Define two lists for storing positive and negative elements
       ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>(); 
        
        // Segregate the array into positives and negatives
        for (int i = 0; i < n; i++) {
            if (A[i] > 0)
             pos.add(A[i]); // Add positive numbers to pos list
            else 
             neg.add(A[i]); // Add negative numbers to neg list
        }
        
        // Place positives on even indices and negatives on odd indices
        for (int i = 0; i < n/2; i++) {
            A[2 * i] = pos.get(i); // Fill even indices with positives
            A[2 * i + 1] = neg.get(i); // Fill odd indices with negatives
        }

        return A; // Return the rearranged array
    }    

    public static void main(String args[]) {
        // Array Initialization
        int n = 4;
        int A[] = {1, 2, -4, -5};

        // Call the rearrangement method  FUNCTION KO BHI ARRAY BNAYA H DHYAN SE DEKHO
        int[] ans = RearrangebySign(A, n);   
        
        // Print the rearranged array
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

/*
Dry Run Explanation:
Given the array: {1, 2, -4, -5}

1. Start with two empty lists: pos = [], neg = [].
2. Iterate through the array A:
   - i = 0 (A[0] = 1): Add 1 to pos → pos = [1]
   - i = 1 (A[1] = 2): Add 2 to pos → pos = [1, 2]
   - i = 2 (A[2] = -4): Add -4 to neg → neg = [-4]
   - i = 3 (A[3] = -5): Add -5 to neg → neg = [-4, -5]

3. Now, pos = [1, 2] and neg = [-4, -5].
4. Rearranging the array:
   - For i = 0: A[2 * 0] = pos.get(0) → A[0] = 1
   - For i = 0: A[2 * 0 + 1] = neg.get(0) → A[1] = -4
   - For i = 1: A[2 * 1] = pos.get(1) → A[2] = 2
   - For i = 1: A[2 * 1 + 1] = neg.get(1) → A[3] = -5

Final rearranged array: {1, -4, 2, -5}
*/

