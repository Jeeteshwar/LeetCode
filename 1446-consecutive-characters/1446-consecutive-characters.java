class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int currLen = 1;
        int maxLen = 1;
        for(int i  = 1 ; i < n ; i++){
            char ch = s.charAt(i); //current
            char zh = s.charAt(i-1); // previous
            
            if(ch == zh){
                currLen++;
            }
            else{
                currLen  = 1;
            }
            maxLen = Math.max(maxLen , currLen);
        }
        return maxLen;
    }
}