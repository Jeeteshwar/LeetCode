class DSU {
    int[] parent;

    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); 
    }

    public void unite(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu = new DSU(n);
        
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                dsu.unite(i, i - 1);
            }
        }
        
        boolean[] ans = new boolean[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            ans[i] = (dsu.find(queries[i][0]) == dsu.find(queries[i][1]));
        }
        
        return ans;
    }
}