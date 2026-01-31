class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        char ans = '{';

        for (int i = 0; i < n; i++) {
            char ch = letters[i];
            if (ch > target && ch < ans) {
                ans = ch;
            }
        }

        if (ans == '{') {
            ans = letters[0];
        }

        return ans;
    }
}
