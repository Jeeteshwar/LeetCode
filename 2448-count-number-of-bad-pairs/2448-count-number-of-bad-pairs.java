import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2; // Total possible pairs
        long goodPairs = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int j = 0; j < n; j++) {
            int key = nums[j] - j;
            goodPairs += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        return totalPairs - goodPairs; // Bad pairs = Total pairs - Good pairs
    }
}
