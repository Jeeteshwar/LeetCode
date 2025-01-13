class Solution {
    public boolean canAliceWin(int[] nums) {
       int sumSingle = 0; 
       int sumDouble = 0;

       for(int num : nums){
        if(num < 10){
            sumDouble += num;
        }
        else{
            sumSingle += num;
        }
        
       } 
       if(sumSingle == sumDouble) return false;
       
      return true;
    }
}