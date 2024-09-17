class WordSearch
{
    // Function to check if the given word exists in the board
    public boolean isWordExist(char[][] board, String word)
    {
        // Get the number of rows (m) and columns (n) in the board
        int m = board.length;
        int n = board[0].length;

        // A 2D boolean array to track visited cells in the board
        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        
        // Traverse each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current board cell matches the first character of the word
                if (board[i][j] == word.charAt(0)) {
                    // Start the backtracking search from this cell
                    result = backtrack(board, word, visited, i, j, 0);
                    // If the word is found, return true
                    if (result) return true;
                }
            }
        }
        
        // If the word is not found after searching the entire board, return false
        return false;
    }
    
    // Helper function to perform backtracking search
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        // Base case: If the entire word is found (index matches word length)
        if (index == word.length()) {
            return true;
        }
        
        // Boundary checks and validations:
        // 1. Check if the current cell is out of bounds
        // 2. Check if the cell is already visited
        // 3. Check if the current cell doesn't match the character at the given index in the word
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Mark the current cell as visited
        visited[i][j] = true;
        
        // Recursively search the next character in all 4 possible directions: down, up, right, left
        if (backtrack(board, word, visited, i + 1, j, index + 1) || // Move down
            backtrack(board, word, visited, i - 1, j, index + 1) || // Move up
            backtrack(board, word, visited, i, j + 1, index + 1) || // Move right
            backtrack(board, word, visited, i, j - 1, index + 1)) { // Move left
            return true; // If any of the recursive calls find the word, return true
        }
        
        // Unmark the current cell (backtrack) before returning, as we may need to explore other paths
        visited[i][j] = false;
        return false; // Return false if the word is not found from this path
    }
    
    // Main method to test the solution
    public static void main(String[] args) {
        // Hardcoded board for testing
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        
        // Hardcoded word to search for
        String word = "ABCCED";
        
        // Create an instance of WordSearch class
        WordSearch ws = new WordSearch();
        
        // Call the isWordExist method and print the result
        boolean result = ws.isWordExist(board, word);
        if (result) {
            System.out.println("The word exists in the board.");
        } else {
            System.out.println("The word does not exist in the board.");
        }
    }
}
