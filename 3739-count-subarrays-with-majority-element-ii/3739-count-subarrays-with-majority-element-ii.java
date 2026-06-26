class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int prefix = 0;
        long ans = 0;
        long valid = 0;
        hm.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                valid+=hm.getOrDefault(prefix,0);
                prefix++;
            }
            else
            {
                prefix--;
                valid-=hm.getOrDefault(prefix,0);
            }
            ans+=valid;
            hm.put(prefix,hm.getOrDefault(prefix,0)+1);
        }
        return ans;
    }
}