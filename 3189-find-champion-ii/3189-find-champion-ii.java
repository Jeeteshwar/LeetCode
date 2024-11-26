class Solution {
    public int findChampion(int n, int[][] edges) {
        // Array to track the number of incoming edges for each node
        int[] incomingEdges = new int[n];

        // Process each edge to calculate incoming edges for each node
        for (int[] edge : edges) {
            int fromNode = edge[0];
            int toNode = edge[1];
            
            // Increment the indegree of the destination node
            incomingEdges[toNode]++;
        }

        int potentialChampion = -1;
        int zeroIndegreeCount = 0;

        // Identify the node with no incoming edges (indegree = 0)
        for (int node = 0; node < n; node++) {
            if (incomingEdges[node] == 0) {
                zeroIndegreeCount++;
                potentialChampion = node;

                // If more than one node has indegree 0, no unique champion exists
                if (zeroIndegreeCount > 1) {
                    return -1;
                }
            }
        }

        // Return the champion node if it exists, otherwise -1
        return potentialChampion;
    }
}
