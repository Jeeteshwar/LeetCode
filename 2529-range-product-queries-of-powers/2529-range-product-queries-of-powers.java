class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;
        
        // Step 1: Extract powers of two from n
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }
        
        // Step 2: Answer queries
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0], r = queries[q][1];
            long product = 1;
            for (int i = l; i <= r; i++) {
                product = (product * powers.get(i)) % MOD;
            }
            ans[q] = (int) product;
        }
        
        return ans;
    }
}
