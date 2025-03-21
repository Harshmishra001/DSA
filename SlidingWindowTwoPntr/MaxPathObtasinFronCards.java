// **Time Complexity:** \(O(k)\) (since we iterate over at most \(k\) elements).  
// **Space Complexity:** \(O(1)\) (only a few integer variables are used).

package SlidingWindowTwoPntr;
class MaxPathObtasinFronCards {
    // Method to find the maximum score by picking k cards from the start or end
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0, rightSum = 0;

        // Compute the sum of the first k elements (taking all from the left initially)
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int result = leftSum;

        // Now, gradually shift elements from left to right
        for (int i = 0; i < k; i++) {
            leftSum -= cardPoints[k - i - 1];  // Remove one element from the left
            rightSum += cardPoints[n - i - 1]; // Add one element from the right
            result = Math.max(result, leftSum + rightSum); // Track max sum
        }

        return result;
    }

    // Main method to test the function
    public static void main(String[] args) {
        MaxPathObtasinFronCards sol = new MaxPathObtasinFronCards();
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println("Maximum Score: " + sol.maxScore(cardPoints, k));
    }
}
// ```

// ---

// ### **Dry Run Example**
// #### **Input:**
// ```java
// cardPoints = {1, 2, 3, 4, 5, 6, 1}
// k = 3
// ```

// #### **Step-by-Step Execution:**
// 1. Compute the sum of the first `k=3` elements (left sum):
//    - `leftSum = 1 + 2 + 3 = 6`
//    - `result = 6`

// 2. Shift elements from left to right:
//    - Remove `3` from `leftSum`, add `1` from right:
//      - `leftSum = 6 - 3 = 3`
//      - `rightSum = 0 + 1 = 1`
//      - `result = max(6, 3 + 1) = 6`
//    - Remove `2`, add `6`:
//      - `leftSum = 3 - 2 = 1`
//      - `rightSum = 1 + 6 = 7`
//      - `result = max(6, 1 + 7) = 8`
//    - Remove `1`, add `5`:
//      - `leftSum = 1 - 1 = 0`
//      - `rightSum = 7 + 5 = 12`
//      - `result = max(8, 0 + 12) = 12`

// #### **Final Output:**
// ```
// Maximum Score: 12
// ```

// This approach efficiently computes the maximum sum using a **sliding window** technique in **O(k) time**. 🚀