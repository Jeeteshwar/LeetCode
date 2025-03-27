class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Find the dominant element in the entire array
        int dominant = findDominant(nums, 0, n - 1);
        
        // Step 2: Count total occurrences of dominant element
        int totalCount = 0;
        for (int num : nums) {
            if (num == dominant) totalCount++;
        }
        
        // Step 3: Try each split point and check validity
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) leftCount++;
            
            int leftSize = i + 1;
            int rightSize = n - (i + 1);
            int rightCount = totalCount - leftCount;
            
            // Check if dominant in both subarrays
            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }
        
        return -1;
    }
    
    private int findDominant(List<Integer> nums, int start, int end) {
        // Using majority element algorithm (Boyer-Moore Voting Algorithm)
        int candidate = nums.get(start);
        int count = 1;
        
        for (int i = start + 1; i <= end; i++) {
            if (count == 0) {
                candidate = nums.get(i);
            }
            count += (nums.get(i) == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
}