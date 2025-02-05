class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        int n = s1.length();
        int difference = 0 , diff1 = -1 , diff2 = -1;

        for(int i = 0 ; i < n ; i++){
            if(s1.charAt(i)!= s2.charAt(i)){
                difference++;
                if(diff1 == -1){
                    diff1 = i;
                }
                else
                    diff2 = i;
            }
        }
        if(difference != 2) return false;

        return s1.charAt(diff1) == s2.charAt(diff2) && s2.charAt(diff1) == s1.charAt(diff2);
    }
}