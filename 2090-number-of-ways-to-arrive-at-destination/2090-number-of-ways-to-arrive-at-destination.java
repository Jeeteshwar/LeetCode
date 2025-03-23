class Solution {
    public int countPaths(int n, int[][] roads) {
        // Create adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time}); // undirected graph
        }
        
        // Array to store minimum time to reach each node
        long[] times = new long[n];
        // Array to store number of ways to reach each node
        int[] ways = new int[n];
        // Priority queue to process nodes with minimum time first
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        
        // Initialize arrays
        Arrays.fill(times, Long.MAX_VALUE);
        times[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); // {node, time}
        
        int MOD = 1_000_000_007;
        
        // Process nodes
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int)curr[0];
            long time = curr[1];
            
            // If we've found a longer path, skip
            if (time > times[node]) continue;
            
            // Explore neighbors
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];
                long newTime = time + travelTime;
                
                if (newTime < times[nextNode]) {
                    // Found a shorter path
                    times[nextNode] = newTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{nextNode, newTime});
                } else if (newTime == times[nextNode]) {
                    // Found another path with same time
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[n-1];
    }
}