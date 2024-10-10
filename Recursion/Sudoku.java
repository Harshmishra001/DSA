public class Sudoku {

    // Public method to initiate solving the Sudoku board
    public void solveSudoku(char[][] board) {
        // Start solving from the first cell (0, 0)
        solve(board, 0, 0);
    }

    // Recursive method to solve the Sudoku board using backtracking
    private boolean solve(char[][] board, int row, int col) {
        // Base case: If row equals board length, we have filled the board completely
        if (row == board.length) {
            return true; // Solution found
        }

        // Move to the next row if the current row is fully filled
        if (col == board[0].length) {
            return solve(board, row + 1, 0); // Move to the first column of the next row
        }

        // Skip cells that are already filled with a number
        if (board[row][col] != '.') {
            return solve(board, row, col + 1); // Move to the next cell in the current row
        }

        // Try placing digits '1' to '9' in the current empty cell
        for (char num = '1'; num <= '9'; num++) {
            // Check if placing 'num' in board[row][col] is valid
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num; // Place the number

                // Recursively solve the next cells
                if (solve(board, row, col + 1)) {
                    return true; // Solution found, no need to backtrack
                }

                // Backtrack: Undo the move if it doesn't lead to a solution
                board[row][col] = '.';
            }
        }

        // If no number can be placed in the current cell, return false to backtrack
        return false;
    }

    // Method to check if placing 'num' in board[row][col] is valid
    private boolean isValidPlacement(char[][] board, int row, int col, char num) {
        // Check the current row and column for any duplicates of 'num'
        for (int i = 0; i < board.length; i++) {
            // Check if 'num' is already present in the row or column
            if (board[row][i] == num || board[i][col] == num) {
                return false; // Invalid placement
            }

            // Check the 3x3 subgrid for duplicates
            int subgridRow = 3 * (row / 3) + i / 3; // Calculate row of the subgrid
            int subgridCol = 3 * (col / 3) + i % 3; // Calculate column of the subgrid
            if (board[subgridRow][subgridCol] == num) {
                return false; // Invalid placement
            }
        }

        // If no conflicts, the placement is valid
        return true;
    }

      // Main method to start the Sudoku solver
      public static void main(String[] args) {
        // Define the Sudoku board with '.' representing empty cells
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        // Display initial board
        System.out.println("Initial Sudoku Board:");
        printBoard(board);

        // Create an instance of the Solution class and solve the board
        Sudoku solver = new Sudoku();
        solver.solveSudoku(board);

        // Display the solved board
        System.out.println("\nSolved Sudoku Board:");
        printBoard(board);
    }

    // Method to print the Sudoku board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < board[0].length; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
