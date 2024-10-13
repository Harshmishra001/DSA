// Time Complexity:
// The time complexity is O(√N) because the recursive process eliminates numbers gradually, and at each step, the number of numbers decreases significantly.
// Auxiliary Space:
// The auxiliary space is O(√N) because of the recursive stack and the depth of the recursion


class LuckyNumber {

    // Recursive function to check if N is lucky
    public boolean isLucky(int N) {
        // Start the process from position 2 (since every 2nd number is deleted first)
        return isLuckyHelper(N, 2);
    }
    
    // Helper function to recursively check the lucky status
    private boolean isLuckyHelper(int N, int pos) {
        // Base case: If position exceeds N, N is still in the list and is lucky
        if (pos > N) {
            return true;
        }
        
        // If N is divisible by the current position (pos), it means N would be deleted
        if (N % pos == 0) {
            return false; // N is not lucky
        }
        
        // Calculate the new value of N after removing numbers
        N = N - (N / pos);
        
        // Recur for the next position (pos + 1)
        return isLuckyHelper(N, pos + 1);
    }
    
    public static void main(String[] args) {
        LuckyNumber solution = new LuckyNumber();
        
        // Test cases
        int N1 = 5;
        System.out.println("Is " + N1 + " a lucky number? " + solution.isLucky(N1));  // Output: false (0)
        
        int N2 = 19;
        System.out.println("Is " + N2 + " a lucky number? " + solution.isLucky(N2));  // Output: true (1)
    }
}
/*Let's go through a **dry run** of the `isLucky` function for the two examples provided: `N = 5` and `N = 19`.

### Example 1: `N = 5`

1. **Initial Call:**
   - Call `isLucky(5)`.
   - `isLuckyHelper(5, 2)` is invoked, starting the process from position 2.

2. **First Recursive Call (`pos = 2`):**
   - Current number: `N = 5`.
   - Check if `5 % 2 == 0`. Since `5` is **not divisible** by `2`, it is not deleted in this iteration.
   - Update `N`: Remove numbers that would have been deleted up to this point.
     - `N = N - (N / 2) = 5 - (5 / 2) = 5 - 2 = 3` (integer division).
   - Move to the next position and call `isLuckyHelper(3, 3)`.

3. **Second Recursive Call (`pos = 3`):**
   - Current number: `N = 3`.
   - Check if `3 % 3 == 0`. Since `3` **is divisible** by `3`, it would be deleted in this iteration.
   - **Return `false`** because `5` (after reduction) would be deleted at position 3.

### Final Output for `N = 5`:
- The function returns `false`, so `5` is **not a lucky number**.

### Example 2: `N = 19`

1. **Initial Call:**
   - Call `isLucky(19)`.
   - `isLuckyHelper(19, 2)` is invoked, starting the process from position 2.

2. **First Recursive Call (`pos = 2`):**
   - Current number: `N = 19`.
   - Check if `19 % 2 == 0`. Since `19` is **not divisible** by `2`, it is not deleted in this iteration.
   - Update `N`: Remove numbers that would have been deleted up to this point.
     - `N = N - (N / 2) = 19 - (19 / 2) = 19 - 9 = 10`.
   - Move to the next position and call `isLuckyHelper(10, 3)`.

3. **Second Recursive Call (`pos = 3`):**
   - Current number: `N = 10`.
   - Check if `10 % 3 == 0`. Since `10` is **not divisible** by `3`, it is not deleted in this iteration.
   - Update `N`: Remove numbers that would have been deleted up to this point.
     - `N = N - (N / 3) = 10 - (10 / 3) = 10 - 3 = 7`.
   - Move to the next position and call `isLuckyHelper(7, 4)`.

4. **Third Recursive Call (`pos = 4`):**
   - Current number: `N = 7`.
   - Check if `7 % 4 == 0`. Since `7` is **not divisible** by `4`, it is not deleted in this iteration.
   - Update `N`: Remove numbers that would have been deleted up to this point.
     - `N = N - (N / 4) = 7 - (7 / 4) = 7 - 1 = 6`.
   - Move to the next position and call `isLuckyHelper(6, 5)`.

5. **Fourth Recursive Call (`pos = 5`):**
   - Current number: `N = 6`.
   - Check if `6 % 5 == 0`. Since `6` is **not divisible** by `5`, it is not deleted in this iteration.
   - Update `N`: Remove numbers that would have been deleted up to this point.
     - `N = N - (N / 5) = 6 - (6 / 5) = 6 - 1 = 5`.
   - Move to the next position and call `isLuckyHelper(5, 6)`.

6. **Fifth Recursive Call (`pos = 6`):**
   - Current number: `N = 5`.
   - Check if `5 % 6 == 0`. Since `6` is greater than `5`, this means `5` would not be deleted anymore.
   - **Return `true`** because `19` has survived all deletions.

### Final Output for `N = 19`:
- The function returns `true`, so `19` is a **lucky number**.

### Summary of Dry Runs:

- For `N = 5`, it gets deleted in the third iteration, so the result is **false** (not a lucky number).
- For `N = 19`, it survives all iterations and is a **lucky number**, resulting in **true**.*/