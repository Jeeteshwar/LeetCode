
class DisjointSet {
    int[] parent, rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void unite(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;
        if (rank[pa] == rank[pb]) {
            rank[pa]++;
            parent[pb] = pa;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

    boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        DisjointSet ds = new DisjointSet(n);
        List<Integer> optionalWeights = new ArrayList<>();
        int edgesUsed = 0;
        int minForcedWeight = Integer.MAX_VALUE;

        Arrays.sort(edges, (a, b) -> (a[3] == b[3]) ? b[2] - a[2] : b[3] - a[3]);

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2], isForced = edge[3];

            if (isForced == 1) {
                if (ds.isConnected(u, v)) return -1;
                ds.unite(u, v);
                minForcedWeight = weight;
                edgesUsed++;
            } else {
                if (!ds.isConnected(u, v)) {
                    ds.unite(u, v);
                    optionalWeights.add(weight);
                    edgesUsed++;
                }
                if (edgesUsed == n - 1) break;
            }
        }

        if (edgesUsed != n - 1) return -1;
        if (optionalWeights.isEmpty()) return minForcedWeight;

        int p = optionalWeights.size();
        if (p > k)
            return Math.min(Math.min(optionalWeights.get(p - k - 1), 2 * optionalWeights.get(p - 1)), minForcedWeight);
        return Math.min(2 * optionalWeights.get(p - 1), minForcedWeight);
    }
}