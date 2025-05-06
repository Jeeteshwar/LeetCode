class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){  // Left half is sorted
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;  // Target is in left half
                } else {
                    left = mid + 1;  // Target is in right half
                }
            } else if (nums[right] >= nums[mid]) {  // Right half is sorted
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;  // Target is in right half
                } else {
                    right = mid - 1;  // Target is in left half
                }
            }
        }
        return -1;
    }
}