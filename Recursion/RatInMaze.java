import java.util.ArrayList;

class RatInMaze {

// Function to find all possible paths in the maze
public ArrayList<String> findPath(int[][] mat) {
    
    ArrayList<String> res = new ArrayList<>();

    int n = mat.length;

    // If the starting cell is blocked, return an empty result
    if (mat[0][0] == 0) return res;
    
    // Call the helper function to start exploring from the top-left corner
    solve(mat, 0, 0, n, "", res);

    return res;
}



    // Helper function to recursively find all paths
    public void solve(int[][] maze, int row, int col, int n, String path, ArrayList<String> res) {
        // Base conditions: return if out of bounds or cell is blocked
        if (row < 0 || col < 0 || row == n || col == n || maze[row][col] == 0) return;
        
        // If we reach the bottom-right corner, add the current path to result
        if (row == n - 1 && col == n - 1) {
            res.add(path);
            return;
        }
        
        // Mark the cell as visited by setting it to 0
        maze[row][col] = 0;
        
        // Explore all four directions:
        
        // Move Down (D)
        solve(maze, row + 1, col, n, path + 'D', res);
        
        // Move Left (L)
        solve(maze, row, col - 1, n, path + 'L', res);
        
        // Move Right (R)
        solve(maze, row, col + 1, n, path + 'R', res);
        
        // Move Up (U)
        solve(maze, row - 1, col, n, path + 'U', res);
        
        // Backtrack: unmark the current cell by restoring its value to 1
        maze[row][col] = 1;
    }

    

    // Main method to test the function
    public static void main(String[] args) {
        RatInMaze solution = new RatInMaze();

        // Example maze (1 = open path, 0 = blocked path)
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        // Find all paths
        ArrayList<String> result = solution.findPath(maze);

        // Print the paths
        if (result.isEmpty()) {
            System.out.println("No paths found.");
        } else {
            System.out.println("Possible paths: " + result);
        }
    }
}
