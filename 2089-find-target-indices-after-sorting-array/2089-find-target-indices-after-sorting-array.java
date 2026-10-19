class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length , smaller = 0 , larger = 0;
        
        for(int i : nums){
            if(i < target) // if the curr element less than target
                smaller++; // increment smaller;
            else if(i > target)  // if the curr element greater than target
                larger++;   // increment smaller;
        }
        for(int i = smaller ; i < n - larger; i++) // start from target less cutting the range from 
        // nums.length larger
            res.add(i); // add the elements to arraylist
        
        return res;
    }
}
