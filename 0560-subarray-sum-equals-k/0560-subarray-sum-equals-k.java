class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0; // This will store the total number of subarrays that sum to 'k'
        int curr = 0; // This keeps track of the cumulative sum up to the current element
        HashMap<Integer, Integer> map = new HashMap<>(); // This map stores the frequency of prefix sums encountered so far

        // Initialize the map with (0, 1) because a sum of 0 has occurred once before processing any elements
        // This handles the case where a subarray starts from the beginning of the array
        map.put(0, 1);

        // Iterate through each number in the array
        for (int num : nums) {
            // Update the cumulative sum by adding the current number
            curr += num;

            // Check if (curr - k) exists in the map. If it does, it means there are subarrays ending at the current index that sum to 'k'
            // The number of such subarrays is the value associated with (curr - k) in the map
            res += map.getOrDefault(curr - k, 0);

            // Update the map with the current cumulative sum, incrementing its count by 1 (or initializing it to 1 if it doesn't exist)
            // This ensures that future iterations can check against this sum
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        // Return the total count of subarrays that sum to 'k'
        return res;
    }
}