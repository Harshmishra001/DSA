class MoveAllZerosToEnd {
    // Function to push all zeros in an array to the end
    void pushZerosToEnd(int[] arr, int n) {
        // Count keeps track of the index to place the next non-zero element
        int count = 0; 
        
        // Traverse through the array
        for (int i = 0; i < n; i++) {
            // If the current element is non-zero
            if (arr[i] != 0) {
                // Swap the current element with the element at 'count' index
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                // Move the count to the next index
                count++;
            }
        }
        // After this function completes, all non-zero elements are at the front 
        // of the array and all zeros are pushed towards the end.
    }



    public static void main(String[] args) {
        MoveAllZerosToEnd  sol = new MoveAllZerosToEnd ();
        int[] arr = {0, 1, 0, 3, 12};
        int n = arr.length;

        // Before pushing zeros to the end
        System.out.println("Array before pushing zeros to the end: ");
        printArray(arr);

        // Push zeros to the end
        sol.pushZerosToEnd(arr, n);

        // After pushing zeros to the end
        System.out.println("Array after pushing zeros to the end: ");
        printArray(arr);
    }

    // Utility function to print array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Dry Run

/*
Input: arr = [0, 1, 0, 3, 12], n = 5

Initial State:
- arr = [0, 1, 0, 3, 12]
- count = 0

Step-by-Step Execution:
1. i = 0: arr[0] = 0 (skip it; count remains 0) 
   - arr = [0, 1, 0, 3, 12]

2. i = 1: arr[1] = 1 (swap arr[1] with arr[count], count = 0)
   - Swap arr[1] (1) with arr[0] (0)
   - arr = [1, 0, 0, 3, 12]
   - Increment count to 1

3. i = 2: arr[2] = 0 (skip it; count remains 1) 
   - arr = [1, 0, 0, 3, 12]

4. i = 3: arr[3] = 3 (swap arr[3] with arr[count], count = 1)
   - Swap arr[3] (3) with arr[1] (0)
   - arr = [1, 3, 0, 0, 12]
   - Increment count to 2

5. i = 4: arr[4] = 12 (swap arr[4] with arr[count], count = 2)
   - Swap arr[4] (12) with arr[2] (0)
   - arr = [1, 3, 12, 0, 0]
   - Increment count to 3

Final State:
- arr = [1, 3, 12, 0, 0]
- All non-zero elements are now at the front, and all zeros are pushed to the end.
*/