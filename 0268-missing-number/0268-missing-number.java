class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet <>();
        
            int n = nums.length;
            long total_sum = (long) n * (n + 1) / 2;
            long twice = 0;
            for(int num : nums){
                total_sum -= num;
            }
            for(int num: nums){
               if(set.contains(num)){
                   twice = num;
                   break;
               }
               else{
                   set.add(num);
               }
            } 
            long missing = total_sum + twice;
        
        // Return the repeated and missing numbers as a pair
        return (int) missing;
    }
        
}
