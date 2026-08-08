import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n + 1];
        Arrays.fill(suf, -1);

        // Step 1: Build suffix array
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j;
        }

        int[] res = new int[m];
        int idx = 0; // pointer in word1
        int used = 0; // mismatch used (0 or 1)

        // Step 2: Greedy selection
        for (int i = 0; i < m; i++) {
            boolean found = false;

            while (idx < n) {
                char c1 = word1.charAt(idx);
                char c2 = word2.charAt(i);

                // Case 1: exact match
                if (c1 == c2) {
                    res[i] = idx;
                    idx++;
                    found = true;
                    break;
                }

                // Case 2: use mismatch
                if (used == 0) {
                    // Check if remaining can match
                    if (suf[idx + 1] <= i) {
                        used = 1;
                        res[i] = idx;
                        idx++;
                        found = true;
                        break;
                    }
                }

                idx++;
            }

            if (!found) return new int[0];
        }

        return res;
    }
}