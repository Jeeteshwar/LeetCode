class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid

        int[] colCount = new int[n]; // Array to store the number of servers in each column
        int[] rowCount = new int[m]; // Array to store the number of servers in each row

        // Step 1: Count the number of servers in each row and column
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) { // Check if there's a server at (row, col)
                    colCount[col]++; // Increment the server count for this column
                    rowCount[row]++; // Increment the server count for this row
                }
            }
        }

        int resServers = 0; // Variable to store the total number of communicable servers

        // Step 2: Count servers that can communicate
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) { // Check if there's a server at (row, col)
                    // A server can communicate if either its row or column has more than one server
                    if (colCount[col] > 1 || rowCount[row] > 1) {
                        resServers++; // Increment the count of communicable servers
                    }
                }
            }
        }

        return resServers; // Return the total number of communicable servers
    }
}
