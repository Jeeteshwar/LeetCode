class Solution {
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        char [] ch = s.toCharArray();
        int count = 0;
        for(char c : ch){
            if( c == letter){
                count++;
            }
        }
        return (int) (100.0 * count / n );
     }
}