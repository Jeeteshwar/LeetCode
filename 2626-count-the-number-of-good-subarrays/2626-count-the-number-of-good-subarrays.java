class Solution {
    public long countGood(int[] nums, int k) {
        int n  = nums.length;
        HashMap<Integer , Integer> freq =  new HashMap<>();
        int left = 0;
        long currPair = 0;
        long res = 0;
        for(int right = 0; right < n ; right++){
            currPair += freq.getOrDefault(nums[right], 0); // valid pairs that are in the hashmap and getting fetched and adding to currpair
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1); // increasing the frequency 
        
        while(currPair >= k){
             res += n - right;
            freq.put(nums[left], freq.getOrDefault(nums[left], 0) - 1);
            currPair -= freq.getOrDefault(nums[left], 0); 
            left++;
        }
        }
        return res;
    }
}