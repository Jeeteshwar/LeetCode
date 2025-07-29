class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; ++i) {
            int current = nums[i];
            result[i] = 1;

            for (int j = i - 1; j >= 0 && (nums[j] | current) != nums[j]; --j) {
                nums[j] |= current;
                result[j] = i - j + 1;
            }
        }

        return result;
    }
}