import java.util.*;

class Solution {
    private List<List<Integer>> toAdjList(int[][] e) {
        int n = 0;
        for (int[] edge : e)
            n = Math.max(n, Math.max(edge[0], edge[1]));
        n++;

        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int[] edge : e) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        return g;
    }

    private int dfs(List<List<Integer>> g, int u, int p, int d) {
        if (d < 0) return 0;
        int c = 1;
        for (int v : g.get(u))
            if (v != p)
                c += dfs(g, v, u, d - 1);
        return c;
    }

    public int[] maxTargetNodes(int[][] e1, int[][] e2, int k) {
        List<List<Integer>> g2 = toAdjList(e2);
        int maxB = 0;
        for (int i = 0; i < g2.size(); i++)
            maxB = Math.max(maxB, dfs(g2, i, -1, k - 1));

        List<List<Integer>> g1 = toAdjList(e1);
        int[] res = new int[g1.size()];
        for (int i = 0; i < g1.size(); i++)
            res[i] = dfs(g1, i, -1, k) + maxB;

        return res;
    }
}
