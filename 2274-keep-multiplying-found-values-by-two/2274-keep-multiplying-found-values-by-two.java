class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        boolean found  = true; // taking a boolean
        while(found){ // condition will look for a boolean true
            found = false; // initial it is false
        for(int i = 0 ; i < n ; i++){ // running the loop
            if(nums[i] == original){ // if we found the original in array
                original *= 2; // replace the Real variable with the condition original * 2; 
                found = true; // if found then flag it as true;
                break;
            
            }
        }
    }
        return original;
    }
}