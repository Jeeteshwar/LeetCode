class Solution {
    private boolean checkMagic(String s ){ // helper function to check wether the following code has the magic itentity
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(i - 1)){
                return false;
            }
        }
        return true;
    }
    public int maximumLength(String s) {
        HashMap<String,Integer> map = new HashMap<>();

        int n  = s.length();
        int res = -1;

        for(int i = 0 ; i < n ; i++){
            String str= "";
            for(int j = i ; j < n ; j++){
                str +=s.charAt(j);
                map.put(str,map.getOrDefault(str,0) + 1);
            }
        }

        for(String st : map.keySet()){
            if(map.get(st) >= 3){
                if(checkMagic(st)){
                    res = Math.max(res,st.length());
                }
            }
        }
        return res;
        
            }
}