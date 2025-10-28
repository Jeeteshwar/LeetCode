class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        // Try each possible starting position and direction
        for (int start = 0; start < n; start++) {
            if (nums[start] == 0) {
                // Try starting with left direction
                if (simulate(nums.clone(), start, -1)) {
                    count++;
                }
                
                // Try starting with right direction  
                if (simulate(nums.clone(), start, 1)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean simulate(int[] arr, int start, int dir) {
        int n = arr.length;
        int pos = start;
        
        while (pos >= 0 && pos < n) {
            if (arr[pos] == 0) {
                // Move in current direction
                pos += dir;
            } else {
                // Decrement current cell
                arr[pos]--;
                // Reverse direction
                dir = -dir;
                // Move in new direction
                pos += dir;
            }
        }
        
        // Check if all elements are zero
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}