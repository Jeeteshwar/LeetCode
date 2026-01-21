class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            if (n == 2) {
                ans[i] = -1;
                continue;
            }
            // n is odd prime
            int k = Integer.numberOfTrailingZeros(n + 1);
            int p = k - 1;
            int candidate = n - (1 << p);
            // For odd primes, candidate >= 0 always true? Let's check n=3: k=2, p=1, cand=1>=0.
            ans[i] = candidate;
        }
        return ans;
    }
}