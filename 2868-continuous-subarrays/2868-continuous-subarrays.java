class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<>(); // To track frequency of elements in the current window

        int left = 0, right = 0; // Sliding window pointers
        int n = nums.length;

        long count = 0; // To count the number of valid subarrays

        while (right < n) {
            // Add the current element at `right` to the TreeMap
            tm.put(nums[right], tm.getOrDefault(nums[right], 0) + 1);

            // Shrink the window if the difference between max and min exceeds 2
            while (tm.lastEntry().getKey() - tm.firstEntry().getKey() > 2) {
                tm.put(nums[left], tm.get(nums[left]) - 1); // Decrease frequency of `nums[left]`
                if (tm.get(nums[left]) == 0) {
                    tm.remove(nums[left]); // Remove element if its frequency becomes 0
                }
                left++; // Move the left pointer to shrink the window
            }

            // Add the number of valid subarrays ending at `right`
            count += right - left + 1;

            right++; // Expand the window
        }
        return count; // Return the total count of valid subarrays
    }
}
