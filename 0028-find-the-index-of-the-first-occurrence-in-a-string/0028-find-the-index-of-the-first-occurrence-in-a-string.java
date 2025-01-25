class Solution {
    public int strStr(String h, String n) {
        int x = n.length();
        if(h.length() == 1) return 0;
        if(n.length() > h.length()) return -1;
        for(int i = 0 ; i <= h.length() - x ; i++){
            if(h.substring(i,i + x).equals(n)){
                
                return i;
            }
            
        }
        return -1;
    }
}