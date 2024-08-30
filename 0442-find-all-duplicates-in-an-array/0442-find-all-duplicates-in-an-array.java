class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet <>();
        List<Integer> result = new ArrayList<>();

        for(int n : nums){
            if(seen.contains(n)){
                result.add(n);
            }
            seen.add(n);
        }
        return result;
    }
}