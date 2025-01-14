class PeakEleIn2D {
    // Main function to find a peak element in the matrix.
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;  // Number of rows in the matrix
        int m = mat[0].length;  // Number of columns in the matrix
        
        int low = 0;  // Left boundary of the search space
        int high = m - 1;  // Right boundary of the search space
        
        // Perform binary search on the columns
        while (low <= high) {
            int mid = (low + high) / 2;  // Mid column

            int row = find_max_in_col(mat, n, mid);  // Find the maximum element in this column


            int left = -1;  // Default value for left neighbor
            int right = -1;  // Default value for right neighbor
            
            // Check the left neighbor if it exists
            if (mid - 1 >= 0) {
                left = mat[row][mid - 1];
            }
            
            // Check the right neighbor if it exists
            if (mid + 1 < m) {
                right = mat[row][mid + 1];
            }
            
            // Check if the current element is a peak
            if (left < mat[row][mid] && mat[row][mid] > right) {
                return new int[] {row, mid};  // Peak found, return its position
            }
            // If the left neighbor is greater, search in the left half
            else if (left > mat[row][mid]) {
                high = mid - 1;
            }
            // If the right neighbor is greater, search in the right half
            else {
                low = mid + 1;
            }
        }
        
        // Return an invalid index if no peak is found (although there will always be a peak)
        return new int[] {-1, -1};
    }

    // Function to find the row with the maximum value in a given column
    public int find_max_in_col(int[][] mat, int n, int col) {
        int idx = 0;  // Index of the maximum element in the column
        int value = mat[0][col];  // Initialize the maximum value to the first element in the column
        
        // Loop through the column to find the maximum element
        for (int i = 1; i < n; i++) {
            if (mat[i][col] > value) {
                value = mat[i][col];  // Update maximum value
                idx = i;  // Update the index of the maximum value
            }
        }
        
        // Return the index of the maximum element in the column
        return idx;
    }

    // Main method to test the findPeakGrid function
    public static void main(String[] args) {
        // Create an object of PeakEleIn2D
        PeakEleIn2D solution = new PeakEleIn2D();
        
        // Example 2D matrix
        int[][] mat = {
            {1, 4, 3},
            {3, 5, 4},
            {4, 2, 6}
        };
        
        // Find the peak element's position
        int[] peak = solution.findPeakGrid(mat);
        
        // Print the position of the peak element
        System.out.println("Peak element is at position: [" + peak[0] + ", " + peak[1] + "]");
    }
}


// ### Dry Run Example:

// Given a matrix:
// mat = [
//     [1, 4, 3],
//     [3, 5, 4],
//     [4, 2, 6]
// ]


// 1. Start with `low = 0` and `high = 2` (the number of columns minus one).
// 2. Calculate the mid column as `(0 + 2) / 2 = 1` (column index 1).
// 3. Find the maximum element in column 1, which is `5` (at row 1).
// 4. The left neighbor is `4` (mat[1][0]), and the right neighbor is `2` (mat[1][2]).
// 5. Since `5` is greater than both its left and right neighbors, it is a peak element. So, return `[1, 1]`.

// ### Final Output:
// The peak element is at `[1, 1]`. This position contains the value `5`.

// ### Corrections for the Dry Run:
// - The dry run is already correct in this case, as it accurately follows the flow of the binary search and matrix checks.
