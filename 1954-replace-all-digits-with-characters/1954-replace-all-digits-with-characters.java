class Solution {
    private char ascii(char x , char c){
        int asc = x - '0'; // a - 0 = 
        return (char) (c + asc);
    }
    public String replaceDigits(String s) {
        int n = s.length();
        char[] res = s.toCharArray();

        for(int i = 1 ; i < n ; i+=2){
            char prev = s.charAt(i-1);

            char curr = s.charAt(i);

            char neww =  ascii(prev,curr);

            res[i] = neww;
        }
        return new String (res);
    }
}