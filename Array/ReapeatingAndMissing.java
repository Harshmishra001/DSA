
import java.util.*;

// Class to find the repeating and missing numbers
public class ReapeatingAndMissing {

    // Brute Force: O(n^2) time complexity, O(1) space complexity
    public static int[] findMissingRepeatingNumbers(int[] arr) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        // Check each number from 1 to n
        for (int i = 1; i <= n; i++) {

            int count = 0;
            // Count occurrences of i in the array
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }

            // If the count is 2, it's the repeating number
            if (count == 2) {
                repeating = i;
            } 
            // If the count is 0, it's the missing number
            else if (count == 0) {
                missing = i;
            }

            // Break if both are found
            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    // Dry Run for Brute Force:
    /*
    Input: arr = {3, 1, 2, 8, 4, 6, 7, 8}
    Step 1: Check each number from 1 to 8:
        - For i = 1: Count in arr = 1 (OK)
        - For i = 2: Count in arr = 1 (OK)
        - For i = 3: Count in arr = 1 (OK)
        - For i = 4: Count in arr = 1 (OK)
        - For i = 5: Count in arr = 0 (Missing = 5)
        - For i = 6: Count in arr = 1 (OK)
        - For i = 7: Count in arr = 1 (OK)
        - For i = 8: Count in arr = 2 (Repeating = 8)
    Output: {8, 5}
    */

    // Better Approach: O(2n) time complexity, O(n) space complexity
    public static int[] findMissingRepeatingNumbers2(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n + 1];
        int repeating = -1, missing = -1;

        // Build a frequency array
        for (int num : arr) {
            hash[num]++;
        }

        // Find repeating and missing numbers
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    // Optimal Approach: O(n) time complexity, O(1) space complexity
    public static int[] findMissingRepeatingNumbers3(int[] arr) {
        long n = arr.length;

        // Calculate sum of first n natural numbers (Sn) and sum of their squares (S2n)
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate sum of array elements (S) and their squares (S2)
        long S = 0, S2 = 0;
        for (int num : arr) {
            S += num;
            S2 += (long) num * num;
        }

        // S - SN = X - Y
        long diff = S - SN;

        // S2 - S2N = X^2 - Y^2
        long sumDiff = S2 - S2N;

        // X + Y = (X^2 - Y^2) / (X - Y)
        long sum = sumDiff / diff;

        // Solve equations: X = (sum + diff) / 2, Y = X - diff
        long x = (sum + diff) / 2;
        long y = x - diff;

        return new int[]{(int) x, (int) y};
    }

    // Dry Run for Optimal Approach:
    /*
    Input: arr = {3, 1, 2, 8, 4, 6, 7, 8}
    Step 1: Calculate Sn and S2n for n = 8:
        - SN = (8 * (8 + 1)) / 2 = 36
        - S2N = (8 * (8 + 1) * (2 * 8 + 1)) / 6 = 204
    Step 2: Calculate S and S2 from the array:
        - S = 3 + 1 + 2 + 8 + 4 + 6 + 7 + 8 = 39
        - S2 = 3^2 + 1^2 + 2^2 + 8^2 + 4^2 + 6^2 + 7^2 + 8^2 = 268
    Step 3: Calculate differences:
        - diff = S - SN = 39 - 36 = 3
        - sumDiff = S2 - S2N = 268 - 204 = 64
    Step 4: Solve for repeating (X) and missing (Y):
        - sum = sumDiff / diff = 64 / 3 = 21
        - X = (sum + diff) / 2 = (21 + 3) / 2 = 12
        - Y = X - diff = 12 - 3 = 5
    Output: {8, 5}
    */

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 8, 4, 6, 7, 8};

        // Brute Force
        int[] result1 = findMissingRepeatingNumbers(arr);
        System.out.println("Brute Force: Repeating = " + result1[0] + ", Missing = " + result1[1]);

        // Better Approach
        int[] result2 = findMissingRepeatingNumbers2(arr);
        System.out.println("Better Approach: Repeating = " + result2[0] + ", Missing = " + result2[1]);

        // Optimal Approach
        int[] result3 = findMissingRepeatingNumbers3(arr);
        System.out.println("Optimal Approach: Repeating = " + result3[0] + ", Missing = " + result3[1]);
    }
}
