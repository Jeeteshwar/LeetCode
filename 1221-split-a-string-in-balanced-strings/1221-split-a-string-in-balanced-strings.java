class Solution {
    public int balancedStringSplit(String s) {
        int l_bal = 0;
        int ans = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(l_bal == 0){
                ans += 1;
            }
            if(s.charAt(i) != 'L'){
                l_bal--;
            }
            else{
                l_bal++;
            }
        }
        return ans;
    }
}