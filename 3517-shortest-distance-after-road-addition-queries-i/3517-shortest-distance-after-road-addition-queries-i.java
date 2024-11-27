import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> adj;

    // Method for performing BFS to find the shortest path from node 0 to node n-1
    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0); // Start from node 0
        visited[0] = true;

        int level = 0; // Track the number of levels (distance in edges)
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                // If we reach the destination node, return the current level
                if (node == n - 1) {
                    return level;
                }

                // Traverse neighbors of the current node
                for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            level++; // Increment level after processing all nodes at the current level
        }

        return -1; // Return -1 if the destination node is unreachable
    }

    // Method to process queries and find shortest paths
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize adjacency list
        adj = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);

            // Perform BFS to compute shortest distance
            result[i] = bfs(n);
        }

        return result;
    }
}
