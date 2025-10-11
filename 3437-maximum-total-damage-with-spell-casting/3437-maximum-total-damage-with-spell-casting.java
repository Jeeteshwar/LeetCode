import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) freq.put(p, freq.getOrDefault(p, 0L) + 1);
        
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);
        
        int n = keys.size();
        long[] dp = new long[n];
        
        dp[0] = keys.get(0) * freq.get(keys.get(0));
        
        for (int i = 1; i < n; i++) {
            long currDamage = keys.get(i) * freq.get(keys.get(i));
            int j = i - 1;
            while (j >= 0 && keys.get(i) - keys.get(j) <= 2) j--;
            
            long include = currDamage + (j >= 0 ? dp[j] : 0);
            long exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }
        
        return dp[n - 1];
    }
}
