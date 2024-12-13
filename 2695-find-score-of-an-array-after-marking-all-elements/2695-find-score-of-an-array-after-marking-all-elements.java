class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int left = 0, right = 0;

        while (right < n) {
            // Start a new range from the current position
            left = right;

            // Expand the range while nums[right] > nums[right + 1]
            while (right + 1 < n && nums[right] > nums[right + 1]) {
                right++;
            }

            // Add every second element in the range [right, left] to the sum
            for (int i = right; i >= left; i -= 2) {
                sum += nums[i];
            }

            // Move to the next potential range
            right += 2;
        }

        return sum;
    }
}
