

// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element
//  of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

// Example 1:

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// Example 2:

// Input: nums1 = [2,4], nums2 = [1,2,3,4]
// Output: [3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
// - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
import java.util.Stack;

public class NextGreaterElement {
    // Brute Force Approach - O(n^2) Time | O(n) Space
    static int[] nextGreaterElementBrute(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default -1 if no greater element is found
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    // Optimal Approach - O(n) Time | O(n) Space using Stack
static int[] nextGreaterElementOptimal(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];  // Array to store the next greater elements
    Stack<Integer> stack = new Stack<>();  // Stack to maintain potential next greater elements

    // Traverse the array from right to left
    for (int i = n - 1; i >= 0; i--) {
        // Remove all elements from the stack that are smaller or equal to the current element
        while (!stack.isEmpty() && stack.peek() <= arr[i]) {
            stack.pop();
        }

        // If stack is not empty, the top element is the next greater element
        result[i] = stack.isEmpty() ? -1 : stack.peek();

        // Push the current element onto the stack for future comparisons
        stack.push(arr[i]);
    }

    return result;
}
    // Function to print array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};

        System.out.print("Brute Force: ");
        printArray(nextGreaterElementBrute(arr));

        System.out.print("Optimal: ");
        printArray(nextGreaterElementOptimal(arr));
    }
}
// ### **Visual Dry Run for Next Greater Element (Optimal Approach using Stack)**  
// #### **Given Input:** `arr = {4, 5, 2, 10, 8}`  
// #### **Logic:**  
// - We traverse **from right to left**.  
// - Use a **monotonic decreasing stack** to store elements while maintaining the **next greater element** information.

// ---

// ### **Step-by-Step Stack Operations**

// | Step | Current Element | Stack Before | Action Taken                                                | Stack After | Next Greater Element |
// |------|----------------|--------------|--------------|--------------------------------------------------------------------------------------    |
// | 1    | **8**          | `Empty`      | No greater element, push `8`                                 | `[8]`          | `-1` |
// | 2    | **10**         | `[8]`        | `8` is **smaller**, pop `8`, push `10`                       | `[10]`         | `-1` |
// | 3    | **2**          | `[10]`       | `10` is greater, **next greater = 10**, push `2`             | `[10, 2]`      | `10` |
// | 4    | **5**          | `[10, 2]`    | `2` is **smaller**, pop `2`, `10` is greater, push `5`       | `[10, 5]`      | `10` |
// | 5    | **4**          | `[10, 5]`    | `5` is greater, **next greater = 5**, push `4`               | `[10, 5, 4]`   | `5` |

// ---

// ### **Final Output (Next Greater Elements)**
// | **Index** | **Element** | **Next Greater Element** |
// |-----------|------------|--------------------------|
// | 0         | **4**      | **5**                    |
// | 1         | **5**      | **10**                   |
// | 2         | **2**      | **10**                   |
// | 3         | **10**     | **-1**                   |
// | 4         | **8**      | **-1**                   |

// ---
// ### **Final Output Array:**  
// ✅ **`[5, 10, 10, -1, -1]`**
