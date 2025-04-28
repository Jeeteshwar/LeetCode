class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long sum = 0;
        long res = 0;

        int i = 0;
        int j = 0;
        while(j < n){
            sum += nums[j]; // add the current sum
            while(i <= j && sum * (j - i + 1) >= k){ //check if curr sub array is strictly less than k
                sum -= nums[i]; // if not then remove surr sum
                i++; // increment the ith pointer
            } 
            res += (j - i + 1); // add the curr subarray length into the res
             j++; // move the j pointer to right
        }
        return res; // finallyr return the count;
       
    }
}