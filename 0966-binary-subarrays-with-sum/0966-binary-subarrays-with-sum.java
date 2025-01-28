class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        
  int res = 0;
        int curr = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            curr += num;

            res += map.getOrDefault(curr - k , 0);

            map.put(curr, map.getOrDefault(curr, 0) + 1);
         }
        return res;
    }
}