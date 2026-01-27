class Solution {
    public int minCost(int n, int[][] edges) {
        // adjacency list for original graph: u -> [(v, w), ...]
        List<int[]>[] graph = new List[n];
        // incoming edges: v -> [(u, w), ...]
        List<int[]>[] incoming = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            incoming[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new int[]{v, w});
            incoming[v].add(new int[]{u, w});
        }
        
        // Dijkstra on state graph: (node, switchUsedAtThisNode) -> dist
        int INF = Integer.MAX_VALUE / 2;
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][0] = INF;
            dist[i][1] = INF;
        }
        dist[0][0] = 0;
        
        // priority queue: (cost, node, switchUsedAtNode)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1], su = cur[2];
            if (d > dist[u][su]) continue;
            
            // normal moves along outgoing edges from u
            for (int[] edge : graph[u]) {
                int v = edge[0], w = edge[1];
                // going to v, v's switch is initially unused
                if (dist[v][0] > d + w) {
                    dist[v][0] = d + w;
                    pq.offer(new int[]{dist[v][0], v, 0});
                }
            }
            
            // switch move: only if switch unused at u (su == 0)
            if (su == 0) {
                for (int[] inc : incoming[u]) {
                    int x = inc[0], w = inc[1];
                    // we use u's switch, go to x, x's switch unused
                    if (dist[x][0] > d + 2 * w) {
                        dist[x][0] = d + 2 * w;
                        pq.offer(new int[]{dist[x][0], x, 0});
                    }
                }
            }
        }
        
        int ans = Math.min(dist[n-1][0], dist[n-1][1]);
        return ans >= INF ? -1 : ans;
    }
}