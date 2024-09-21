
class McoloringGraph {
    // Function to determine if the graph can be colored with at most M colors
    public boolean graphColoring(boolean[][] graph, int m, int n) {
        // Create an array to store colors assigned to each vertex (initialized to 0, meaning no color assigned)
        int[] colors = new int[n]; 
        // Start the recursive backtracking algorithm to check if the graph can be colored starting from vertex 0
        return canColorGraph(graph, m, colors, 0, n);
    }

    // Helper function to check if coloring the graph is possible using backtracking
    private boolean canColorGraph(boolean[][] graph, int m, int[] colors, int vertex, int n) {
        // If all vertices have been assigned a color, return true (base case)
        if (vertex == n) return true;

        // Try assigning each color (from 1 to m) to the current vertex
        for (int color = 1; color <= m; color++) {
            // Check if it is safe to assign the current color to this vertex
            if (isSafe(graph, colors, vertex, color, n)) {
                // Assign the current color to this vertex
                colors[vertex] = color;

                // Recursively attempt to assign colors to the remaining vertices
                if (canColorGraph(graph, m, colors, vertex + 1, n)) {
                    return true; // If coloring the next vertices is successful, return true
                }

                // Backtrack if no valid color configuration is found for the next vertex
                colors[vertex] = 0; // Reset the color (backtrack)
            }
        }

        // If no valid color can be assigned to the current vertex, return false
        return false;
    }

    // Function to check if it is safe to color the current vertex with the given color
    private boolean isSafe(boolean[][] graph, int[] colors, int vertex, int color, int n) {
        // Iterate through all vertices to check adjacency
        for (int i = 0; i < n; i++) {
            // If there's an edge between the current vertex and the i-th vertex,
            // and the i-th vertex already has the same color, it's not safe to color
            if (graph[vertex][i] && colors[i] == color) {
                return false;
            }
        }
        // If no adjacent vertices have the same color, it's safe to assign this color
        return true;
    }

    // Main method to test the graph coloring function
    public static void main(String[] args) {
        // Create an instance of the  class
        McoloringGraph solver = new McoloringGraph();

        // Input: N = 4, M = 3, E = 5, Edges[] = {(0,1), (1,2), (2,3), (3,0), (0,2)}
        // Number of vertices
        int N = 4;

        // Number of edges
        int E = 5;

        // Number of colors
        int M = 3;

        // Create the graph as an adjacency matrix (4 vertices)
        boolean[][] graph = new boolean[N][N];

        // List of edges
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0},
            {0, 2}
        };

        // Fill the adjacency matrix based on the edges
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u][v] = true;
            graph[v][u] = true; // Since it's an undirected graph
        }

        // Call the graphColoring function and print the result
        if (solver.graphColoring(graph, M, N)) {
            System.out.println("1"); // Output 1 if it's possible to color the graph with M colors
        } else {
            System.out.println("0"); // Output 0 if it's not possible
        }
    }
}

