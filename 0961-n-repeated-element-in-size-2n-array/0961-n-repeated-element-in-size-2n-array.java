class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int[] freq = new int[10001];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        int maxFreq = 0;
        int maxElement = 0; // Initialize with first element (0)

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) { // Compare frequency with maxFreq
                maxFreq = freq[i]; // Update max frequency
                maxElement = i; // Update element with max frequency
            }
        }

        return maxElement;
    }
}