class Solution {
    public int tupleSameProduct(int[] nums) {
        // Map to store the frequency of products of pairs
        Map<Integer, Integer> productMap = new HashMap<>();
        int n = nums.length;

        // Compute all possible products of pairs and store their frequencies
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }

        // Calculate the number of valid tuples
        int count = 0;
        for (int freq : productMap.values()) {
            if (freq >= 2) {
                // Number of ways to choose 2 pairs from `freq` pairs
                count += freq * (freq - 1) / 2;
            }
        }

        // Each tuple can be rearranged in 8 ways
        return count * 8;
    }
}