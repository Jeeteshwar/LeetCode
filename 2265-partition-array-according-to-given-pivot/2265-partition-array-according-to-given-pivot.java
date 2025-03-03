class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        
        // First, count numbers less than, equal to, and greater than pivot
        int lessCount = 0;
        int equalCount = 0;
        
        for (int num : nums) {
            if (num < pivot) lessCount++;
            else if (num == pivot) equalCount++;
        }
        
        // Place elements in result array
        int lessIndex = 0;          // index for numbers < pivot
        int equalIndex = lessCount; // index for numbers = pivot
        int greaterIndex = lessCount + equalCount; // index for numbers > pivot
        
        for (int num : nums) {
            if (num < pivot) {
                result[lessIndex++] = num;
            } else if (num == pivot) {
                result[equalIndex++] = num;
            } else {
                result[greaterIndex++] = num;
            }
        }
        
        return result;
    }
}