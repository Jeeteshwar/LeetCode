import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;
        
        // Step 1: Collect all horizontal boundaries
        Set<Integer> hBoundsSet = new HashSet<>();
        for (int fence : hFences) hBoundsSet.add(fence);
        hBoundsSet.add(1);
        hBoundsSet.add(m);
        List<Integer> hBounds = new ArrayList<>(hBoundsSet);
        Collections.sort(hBounds);
        
        // Step 2: Collect all vertical boundaries
        Set<Integer> vBoundsSet = new HashSet<>();
        for (int fence : vFences) vBoundsSet.add(fence);
        vBoundsSet.add(1);
        vBoundsSet.add(n);
        List<Integer> vBounds = new ArrayList<>(vBoundsSet);
        Collections.sort(vBounds);
        
        // Step 3: Compute all horizontal distances
        Set<Integer> hDiffs = new HashSet<>();
        for (int i = 0; i < hBounds.size(); i++) {
            for (int j = i + 1; j < hBounds.size(); j++) {
                hDiffs.add(hBounds.get(j) - hBounds.get(i));
            }
        }
        
        // Step 4: Compute all vertical distances and track max common
        long maxSide = -1;
        for (int i = 0; i < vBounds.size(); i++) {
            for (int j = i + 1; j < vBounds.size(); j++) {
                int diff = vBounds.get(j) - vBounds.get(i);
                if (hDiffs.contains(diff)) {
                    maxSide = Math.max(maxSide, diff);
                }
            }
        }
        
        // Step 5: Return result
        if (maxSide == -1) return -1;
        long area = (maxSide * maxSide) % MOD;
        return (int) area;
    }
}