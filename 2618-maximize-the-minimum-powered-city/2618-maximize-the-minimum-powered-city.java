class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];
        
        // Step 1: compute initial power using sliding window
        long curr = 0;
        for (int i = 0; i <= Math.min(n - 1, r); i++) {
            curr += stations[i];
        }
        power[0] = curr;
        
        for (int i = 1; i < n; i++) {
            if (i + r < n) curr += stations[i + r];
            if (i - r - 1 >= 0) curr -= stations[i - r - 1];
            power[i] = curr;
        }
        
        // Step 2: binary search
        long low = 0, high = (long) 1e15; // upper bound large enough
        long ans = 0;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canAchieve(power, n, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canAchieve(long[] power, int n, int r, int k, long minPower) {
        long[] add = new long[n];
        long currAdd = 0;
        long used = 0;
        
        for (int i = 0; i < n; i++) {
            // Add the effect of stations added at i
            currAdd += add[i];
            long total = power[i] + currAdd;
            
            if (total < minPower) {
                long need = minPower - total;
                if (need > k - used) return false; // Not enough stations left
                used += need;
                currAdd += need;
                // This station's effect ends at i + 2*r + 1
                if (i + 2*r + 1 < n) {
                    add[i + 2*r + 1] -= need;
                }
            }
        }
        return true;
    }
}