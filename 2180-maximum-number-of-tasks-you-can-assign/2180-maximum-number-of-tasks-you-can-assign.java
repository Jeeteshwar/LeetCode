import java.util.Arrays;

class Solution {
    public int maxTaskAssign(int[] t, int[] w, int p, int s) {
        Arrays.sort(t);
        Arrays.sort(w);

        int l = 0, r = Math.min(t.length, w.length);
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (can(t, w, p, s, m)) l = m;
            else r = m - 1;
        }

        return l;
    }

    private boolean can(int[] t, int[] w, int p, int s, int k) {
        int[] ts = Arrays.copyOfRange(t, 0, k);
        int[] ws = Arrays.copyOfRange(w, w.length - k, w.length);

        int pl = p, ti = k - 1, wi = k - 1;

        while (ti >= 0) {
            if (ws[wi] >= ts[ti]) {
                wi--;
                ti--;
            } else {
                if (pl == 0) return false;

                int idx = Arrays.binarySearch(ws, 0, wi + 1, ts[ti] - s);
                if (idx < 0) idx = -idx - 1;
                if (idx > wi) return false;

                for (int i = idx; i < wi; i++) {
                    ws[i] = ws[i + 1];
                }

                wi--;
                ti--;
                pl--;
            }
        }

        return true;
    }
}
