class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        long currWinSum = 0;
        int i = 0 , j = 0;
        HashSet<Integer> set =  new HashSet<>();
        
        while(j < n){
            while(set.contains(nums[j])){ // if the curr element is duplicate 
                currWinSum -= nums[i]; // remove the ith pointer element from curr sum
                set.remove(nums[i]);  // remove the ith pointer element from set
                i++; // shrink the sliding window
            }
            currWinSum += nums[j]; // if not add the curr Jth pointer the curr currWinSum
            set.add(nums[j]); // add the element to maintain the distint element sequence

            if(j - i + 1 == k){ // if the subarray size becomes like the required size
                res =  Math.max(res,currWinSum); // add the currWinSum to the res var to keep the record of maximumSubarraySum
                currWinSum -= nums[i]; // remove the ith pointer element as we need to shrink the window size
                set.remove(nums[i]); // remove the element from set as well
                i++; // move forward the ith pointer
            }
            j++; // move forward the j pointer to keep going with the window
        }
        //n - k + 1
        return res; // return the res

    }
}