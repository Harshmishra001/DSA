// User function Template for Java



// BRUTE FORCE APPROACH
// For finding, all possible permutations, it is taking N!xN. N represents the number of elements present in the input array. Also for searching input arrays from all possible permutations will take N!.
//  Therefore, it has a Time complexity of O(N!xN).

// Space Complexity :

// Since we are not using any extra spaces except stack spaces for recursion calls. So, it has a space complexity of O(1).

// Approach :

// Step 1: Find all possible permutations of elements present and store them.

// Step 2: Search input from all possible permutations.

// Step 3: Print the next permutation present right after it.






// OPTIMAL APPROACH
// Time Complexity: O(3N), where N = size of the given array
// Finding the break-point, finding the next greater element, and reversal at the end takes O(N) for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(3N).

// Space Complexity: Since no extra storage is required. Thus, its space complexity is O(1).
class NextPermutation {
    void nextPermutation(int[] arr) {
        int ind = -1;
        int n = arr.length;
        // Step 1: Find the rightmost element which is smaller than its next element.
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i; // This is the index to swap
                break;
            }
        }
        // Step 2: If no such element is found, reverse the array to get the smallest permutation
        if (ind == -1) {
            reverse(arr, 0, n - 1);
        } else {
            // Step 3: Find the smallest element to the right of 'ind' that is larger than arr[ind]
            for (int i = n - 1; i >= ind; i--) {
                if (arr[i] > arr[ind]) {
                    // Swap the elements at 'ind' and 'i'
                    int temp = arr[i];
                    arr[i] = arr[ind];
                    arr[ind] = temp;
                    break;
                }
            }
            // Step 4: Reverse the sequence to the right of 'ind' to get the next lexicographical permutation
            reverse(arr, ind + 1, n - 1);
        }
    }

    // Helper function to reverse a portion of the array
    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] arr = {1, 2, 3};

        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        np.nextPermutation(arr);

        System.out.print("\nNext Permutation: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/* Dry Run Example:
   Input: arr = [1, 2, 3]
   
   Step-by-Step:
   - Initial array: [1, 2, 3]
   - Step 1: Find the rightmost element smaller than its next, here 2 < 3, so ind = 1.
   - Step 2: Find the smallest element on the right of ind which is larger than arr[ind] (2), found 3 at index 2.
   - Step 3: Swap arr[ind] with arr[2]: [1, 3, 2].
   - Step 4: Reverse elements to the right of index 1, but it's already in smallest order.
   - Result: Next permutation of [1, 2, 3] is [1, 3, 2].
*/
