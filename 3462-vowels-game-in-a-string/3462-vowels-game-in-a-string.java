class Solution {
    public boolean doesAliceWin(String s) {
        int n = s.length();
        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                pre[i+1] = pre[i] + 1;
            } else {
                pre[i+1] = pre[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if ((pre[i] % 2) != (pre[i+1] % 2)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}