class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int sz = nums.length;
        Map<Integer, List<Integer>> indices = new HashMap<>();
        
        // 1. Group indices by their values
        for (int i = 0; i < sz; i++) {
            indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        // 2. Calculate minimum circular distances
        for (List<Integer> arr : indices.values()) {
            int m = arr.size();
            
            // If the element is unique, the distance is -1
            if (m == 1) {
                nums[arr.get(0)] = -1;
                continue;
            }
            
            for (int i = 0; i < m; i++) {
                int j = arr.get(i);
                
                // Get immediate neighbors in the list (with wrap-around)
                int f = arr.get((i + 1) % m);
                int b = arr.get((i - 1 + m) % m);
                
                // Calculate circular distances
                int forward = Math.min(sz - j + f, Math.abs(j - f));
                int backward = Math.min(Math.abs(b - j), j + (sz - b));
                
                // Overwrite the original array to save space!
                nums[j] = Math.min(backward, forward);
            }
        }
        
        // 3. Answer the queries in O(1) time each
        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            res.add(nums[q]);
        }
        return res;
    }
}