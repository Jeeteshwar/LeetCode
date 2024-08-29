class Solution {
    private int n; // Variable to store the number of stones

    // Depth-First Search (DFS) helper function
    private void dfs(int [][] stones, int index, boolean[] visited){
        visited[index] = true; // Mark the current stone as visited

        // Traverse all stones to find connected stones
        for(int i = 0; i < stones.length; i++){

            int r = stones[index][0]; // Row position of the current stone
            int c = stones[index][1]; // Column position of the current stone

            // If the stone is not visited and shares the same row or column with the current stone
            if(!visited[i] && (stones[i][0] == r || stones[i][1] == c)) {  
                // Perform DFS on the connected stone
                dfs(stones, i, visited);
            }
        }
    }

    // Function to calculate the maximum number of stones that can be removed
    public int removeStones(int[][] stones) {
        n = stones.length; // Get the number of stones
        boolean[] visited = new boolean[n]; // Array to track visited stones

        int gang = 0; // Counter for the number of connected components (groups of connected stones)
        for(int i = 0; i < n; i++){
            if(visited[i]) continue; // Skip if the stone is already visited

            // Perform DFS on the unvisited stone
            dfs(stones, i, visited);

            gang++; // Increment the number of groups
        }

        // The result is the total number of stones minus the number of groups
        return n - gang;
    }
}
