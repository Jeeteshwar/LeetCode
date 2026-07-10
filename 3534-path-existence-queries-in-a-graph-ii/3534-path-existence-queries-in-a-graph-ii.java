import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        // Step 1: Sort indices according to their values
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));

        // pos[originalIndex] = position in sorted array
        // val[sortedPosition] = value at sorted position
        int[] pos = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            pos[order[i]] = i;
            val[i] = nums[order[i]];
        }

        // Step 2: Sliding Window
        // reach[i] = farthest position reachable from i in one jump
        int[] reach = new int[n];

        for (int i = 0, j = 0; i < n; i++) {
            if (j < i) j = i;

            while (j + 1 < n && val[j + 1] - val[i] <= maxDiff) {
                j++;
            }

            reach[i] = j;
        }

        // Step 3: Build Connected Components
        int[] comp = new int[n];

        for (int i = 1; i < n; i++) {
            comp[i] = comp[i - 1];

            if (val[i] - val[i - 1] > maxDiff) {
                comp[i]++;
            }
        }

        // Step 4: Binary Lifting
        int LOG = 1;
        while ((1 << LOG) < n) {
            LOG++;
        }

        int[][] jump = new int[LOG][n];

        jump[0] = reach.clone();

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        // Step 5: Answer Queries
        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int u = queries[qi][0];
            int v = queries[qi][1];

            int pu = pos[u];
            int pv = pos[v];

            // Different connected components
            if (comp[pu] != comp[pv]) {
                ans[qi] = -1;
                continue;
            }

            // Same node
            if (pu == pv) {
                ans[qi] = 0;
                continue;
            }

            // Always move left -> right
            if (pu > pv) {
                int temp = pu;
                pu = pv;
                pv = temp;
            }

            int cur = pu;
            int dist = 0;

            // Binary lifting
            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < pv) {
                    cur = jump[k][cur];
                    dist += 1 << k;
                }
            }

            if (cur < pv) {
                dist++;
            }

            ans[qi] = dist;
        }

        return ans;
    }
}