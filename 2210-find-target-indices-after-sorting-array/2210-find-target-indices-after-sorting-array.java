class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0, lesscount = 0;

        // First loop: Count the number of target elements and elements less than the target
        for (int n : nums) {
            if (n == target) count++;     // Increment count if the element is equal to target
            if (n < target) lesscount++;  // Increment lesscount if the element is less than target
        }

        List<Integer> result = new ArrayList<>();
        // Second loop: Add the indices to the result list
        for (int i = 0; i < count; i++) {
            result.add(lesscount++); // Start from lesscount and add indices up to lesscount + count - 1
        }

        return result; // Return the result list containing the target indices
    }
}