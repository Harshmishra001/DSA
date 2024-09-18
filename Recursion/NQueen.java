import java.util.*;
// Time Complexity: Exponential in nature since we are trying out all ways, to be precise its O(N! * N).
// Space Complexity: O(N)
class NQueen {

    // This function solves the N-Queens problem and returns all possible arrangements.
    public static List<List<String>> solveNQueens(int n) {
        // Initialize an empty chess board represented by '.' for each cell.
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // '.' means an empty cell.
            }
        }

        // List to store all valid N-Queens solutions.
        List<List<String>> res = new ArrayList<List<String>>();

        // Arrays to keep track of queens' presence in rows and diagonals.
        int leftRow[] = new int[n]; // To check if a queen is placed in the row.
        int upperDiagonal[] = new int[2 * n - 1]; // For upper diagonals (row - col is constant).
        int lowerDiagonal[] = new int[2 * n - 1]; // For lower diagonals (row + col is constant).

        // Start solving from the first column.
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        
        return res; // Return the list of all possible solutions.
    }

    // Recursive function to place queens in columns and check for valid configurations.
    static void solve(int col, char[][] board, List<List<String>> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        // Base case: If all columns are filled, a valid solution is found.
        if (col == board.length) {
            res.add(construct(board)); // Add the current board configuration to the result.
            return;
        }

        // Try placing a queen in each row for the current column.
        for (int row = 0; row < board.length; row++) {
            // Check if placing a queen at (row, col) is safe by ensuring no queens in the same row or diagonals.
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                // Place the queen.
                board[row][col] = 'Q';
                leftRow[row] = 1; // Mark row as occupied.
                lowerDiagonal[row + col] = 1; // Mark lower diagonal as occupied.
                upperDiagonal[board.length - 1 + col - row] = 1; // Mark upper diagonal as occupied.

                // Recur to place the next queen in the next column.
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);

                // Backtrack: Remove the queen and reset the markers.
                board[row][col] = '.';
                leftRow[row] = 0; // Unmark the row.
                lowerDiagonal[row + col] = 0; // Unmark the lower diagonal.
                upperDiagonal[board.length - 1 + col - row] = 0; // Unmark the upper diagonal.
            }
        }
    }

    // Helper function to convert the board configuration into a list of strings for easier output.
    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>(); // List to hold the current board configuration.
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]); // Convert each row to a string.
            res.add(s); // Add the row string to the list.
        }
        return res; // Return the board as a list of strings.
    }

    // Main function to test the N-Queens solution.
    public static void main(String[] args) {
        int n = 4;  // Size of the chessboard  n=4 so (4x4).
    
        // Get all valid solutions for the N-Queens problem.
        List<List<String>> solutions = solveNQueens(n);
    
        // Counter to track the solution number.
        int solutionNumber = 1;
    
        // Iterate through each solution and print it.
        for (List<String> solution : solutions) {
            System.out.println("Solution #" + solutionNumber + ":"); // Print solution label.
    
            // Print each row of the chessboard for the current solution.
            for (String row : solution) {
                System.out.println(row);
            }
    
            System.out.println();  // Print an empty line between solutions.
            solutionNumber++;      // Increment the solution counter.
        }
    }
    
}
