class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        int n = s.length();
        for(char c : s.toCharArray()){
            if(c == letter)
                count++;
        }
        return (int) (100.0 * count / n);
    }
}