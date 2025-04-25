import java.util.Stack;
// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

// Example 1:

// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
class SumOfSubarrayMinimum {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] right = new int[len];
        int[] left = new int[len];

        Stack<Integer> stk = new Stack<>();
        // Stack to keep track of indices of elements in the array

        // Fill the 'right' array for the next smaller element on the right
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }
            // Pop elements until a smaller one is found

            if (stk.isEmpty()) {
                right[i] = len;
            } else {
                right[i] = stk.peek();
            }
            // If no smaller element is found, use len; otherwise, use the next smaller index

            stk.push(i);
            // Push the current index onto the stack
        }

        stk.clear();
        // Reuse the stack to calculate the 'left' array for the previous smaller element

        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                stk.pop();
            }
            // Pop elements until a smaller one is found

            if (stk.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stk.peek();
            }
            // If no smaller element is found, use -1; otherwise, use the previous smaller index

            stk.push(i);
            // Push the current index onto the stack
        }

        long total = 0;  // Use 'long' to avoid overflow during multiplication
        int mod = 1000000007;
        // 'mod' is used to ensure the result stays within bounds of the problem constraints

        for (int i = 0; i < len; i++) {
            total = (total + (long) (i - left[i]) * (right[i] - i) * arr[i]) % mod;
        }
        // Calculate the sum of minimums of all subarrays using formula:
        // Contribution = (i - left[i]) * (right[i] - i) * arr[i]
        // Total modulo 10^9+7 ensures result fits within bounds

        return (int) total;
        // Convert 'long' to 'int' before returning as the function's return type is 'int'
    }


    public static void main(String[] args) {
        SumOfSubarrayMinimum  solution = new SumOfSubarrayMinimum ();
        int[] arr = {3, 1, 2, 4};
        System.out.println("Sum of Subarray Minimums: " + solution.sumSubarrayMins(arr));
        // Output: 17
    }
}

// ### Answer to your questions
// 1. **Can we use `HashMap` instead of index arrays (`left`, `right`)?**
//    Using `HashMap` to store indices would work in principle but will make the implementation less efficient. Arrays provide `O(1)` access time compared to `O(log n)` or worse in `HashMap`, depending on collisions.

// 2. **Why use `long` for `total` and convert back to `int`?**
//    Using `long` prevents integer overflow during calculations. Since multiplication of `(i - left[i])`, `(right[i] - i)`, and `arr[i]` can exceed the range of `int`, `long` ensures we handle larger numbers safely. After modulo operation, converting back to `int` is safe because the result fits within `int` bounds.

// ### Dry Run Explanation
// Let’s dry-run the code with `arr = {3, 1, 2, 4}`:
// 1. **First `for` loop (Find `right`):**
//    - `i = 3`, `stk = []`, no smaller element; `right[3] = 4`.
//    - `i = 2`, `stk = [3]`, `arr[3] > arr[2]`; `right[2] = 3`.
//    - `i = 1`, `stk = [2]`, `arr[2] > arr[1]`; `right[1] = 4`.
//    - `i = 0`, `stk = [1]`, `arr[1] > arr[0]`; `right[0] = 1`.

//    Final `right = {1, 4, 3, 4}`.

// 2. **Second `for` loop (Find `left`):**
//    - `i = 0`, `stk = []`, no smaller element; `left[0] = -1`.
//    - `i = 1`, `stk = [0]`, `arr[0] > arr[1]`; `left[1] = -1`.
//    - `i = 2`, `stk = [1]`, `arr[1] <= arr[2]`; `left[2] = 1`.
//    - `i = 3`, `stk = [2]`, `arr[2] <= arr[3]`; `left[3] = 2`.

//    Final `left = {-1, -1, 1, 2}`.

// 3. **Calculate `total`:**
//    Contribution for each index:
//    - `i = 0`: `(0 - (-1)) * (1 - 0) * 3 = 3`.
//    - `i = 1`: `(1 - (-1)) * (4 - 1) * 1 = 6`.
//    - `i = 2`: `(2 - 1) * (3 - 2) * 2 = 2`.
//    - `i = 3`: `(3 - 2) * (4 - 3) * 4 = 4`.

//    Total: `(3 + 6 + 2 + 4) % mod = 17`.
   
//    the overall time complexity is **O(n)**.
//    the total space complexity is **O(n)**.
   
   