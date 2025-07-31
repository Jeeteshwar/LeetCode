class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        // Set to store all unique bitwise OR results from subarrays
        Set<Integer> res = new HashSet<>();

        // Set to store all OR results of subarrays ending at the previous index
        Set<Integer> cur = new HashSet<>();

        // Iterate through each element in the array
        for (int num : arr) {

            // Temporary set to store OR results of subarrays ending at current index
            Set<Integer> next = new HashSet<>();

            // Every element itself is a subarray → add it
            next.add(num);

            // For each OR result from previous subarrays (ending at previous index),
            // extend the subarray by adding current num, and compute OR
            for (int val : cur) {
                next.add(val | num);  // Add result of extending previous subarray with num
            }

            // Update 'cur' to hold OR results of subarrays ending at current index
            cur = next;

            // Add all current OR results to the final result set
            res.addAll(cur);
        }

        // The size of 'res' is the count of distinct bitwise ORs of all subarrays
        return res.size();
    }
}
