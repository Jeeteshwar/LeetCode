class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int mainSum = 0;
        int currSum = 0;
        for(int i = 0 ; i < n ; i++){
            currSum = currSum + gain[i];
            if(currSum > mainSum ){
                mainSum = currSum;
            }

            
        }
        

        return mainSum;
    }
}