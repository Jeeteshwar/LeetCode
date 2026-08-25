class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int num : nums){
            max = Math.max(num,max);
            set.add(num);
        }
        for(int i = k ; i <= max + k ; i +=k){
            if(!set.contains(i)){
                return i;
            }
        }
        return max + k;
    }
}