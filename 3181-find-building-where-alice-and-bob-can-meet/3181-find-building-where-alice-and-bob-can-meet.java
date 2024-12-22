class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[][] sparseTable = buildSparseTable(heights, n);
        int[] log = computeLogs(n);

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            results[i] = processQuery(queries[i], heights, sparseTable, log, n);
        }

        return results;
    }

    private int[][] buildSparseTable(int[] heights, int n) {
        int[][] st = new int[n][20];
        for (int i = 0; i < n; i++) {
            st[i][0] = heights[i];
        }

        for (int j = 1; j < 20; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[i][j] = Math.max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }

        return st;
    }

    private int[] computeLogs(int n) {
        int[] log = new int[n + 1];
        log[0] = -1;
        for (int i = 1; i <= n; i++) {
            log[i] = log[i >> 1] + 1;
        }
        return log;
    }

    private int processQuery(int[] query, int[] heights, int[][] sparseTable, int[] log, int n) {
        int l = query[0];
        int r = query[1];

        if (l > r) {
            int temp = l;
            l = r;
            r = temp;
        }

        if (l == r) {
            return l;
        }

        if (heights[r] > heights[l]) {
            return r;
        }

        int maxHeight = Math.max(heights[l], heights[r]);
        int leftmost = findLeftmostBuilding(r, n, maxHeight, sparseTable, log);
        return leftmost;
    }

    private int findLeftmostBuilding(int r, int n, int maxHeight, int[][] sparseTable, int[] log) {
        int left = r + 1, right = n, mid;

        while (left < right) {
            mid = (left + right) / 2;
            int k = log[mid - r + 1];
            int maxInRange = Math.max(sparseTable[r][k], sparseTable[mid - (1 << k) + 1][k]);

            if (maxInRange > maxHeight) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left == n ? -1 : left;
    }
}
