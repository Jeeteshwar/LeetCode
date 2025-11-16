class Solution {
    public int getMaxLen(int[] nums) {

        int pos = 0;
        int neg = 0;
        int res = 0;
        
            for(int num:nums){
            if(num > 0) {
                pos = 1 + pos;
                neg = (neg > 0) ? 1 + neg : 0;
            }
            else if(num < 0){
                int newPos = (neg > 0) ? 1 + neg : 0;
                int newNeg = 1 + pos; 
                pos = newPos;
                neg = newNeg;
            }
            else{
                pos = 0;
                neg = 0;
            }
            res = Math.max(res,pos);
            }
            return res;
        }
}