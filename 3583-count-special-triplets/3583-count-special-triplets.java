class Solution {

    static final long M = 1000000007;

    public int specialTriplets(int[] nums) {

        HashMap<Integer, Integer> mp_left = new HashMap<>();
        HashMap<Integer, Integer> mp_right = new HashMap<>();

        long result = 0;

        // Count all numbers into mp_right
        for (int num : nums) {
            mp_right.put(num, mp_right.getOrDefault(num, 0) + 1);
        }

        // Iterate nums again
        for (int num : nums) {

            // Remove current num from right map
            mp_right.put(num, mp_right.get(num) - 1);

            int left = mp_left.getOrDefault(num * 2, 0);
            int right = mp_right.getOrDefault(num * 2, 0);

            result = (result + (1L * left * right) % M) % M;

            // Add current num to left map
            mp_left.put(num, mp_left.getOrDefault(num, 0) + 1);
        }

        return (int) result;
    }
}
