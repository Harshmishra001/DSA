class OddOccurrence {
    
    // Function to find the number that occurs an odd number of times in the array
    int getOddOccurrence(int[] arr, int n) {
        int oddOccurrence = 0;

        // XOR all elements
        for (int i = 0; i < arr.length; i++) {
            oddOccurrence ^= arr[i];
        }

        return oddOccurrence;
    }

    public static void main(String[] args) {
        OddOccurrence sol = new OddOccurrence();

        // Test case 1
        int[] arr1 = {1, 2, 3, 2, 1, 3, 3};  // 3 occurs 3 times (odd)
        System.out.println("Number with odd occurrences: " + sol.getOddOccurrence(arr1, arr1.length)); // Output: 3

        // Test case 2
        int[] arr2 = {4, 5, 4, 6, 6};        // 5 occurs 1 time (odd)
        System.out.println("Number with odd occurrences: " + sol.getOddOccurrence(arr2, arr2.length)); // Output: 5

        // Test case 3
        int[] arr3 = {7, 8, 8, 7, 7};        // 7 occurs 3 times (odd)
        System.out.println("Number with odd occurrences: " + sol.getOddOccurrence(arr3, arr3.length)); // Output: 7
    }
}
