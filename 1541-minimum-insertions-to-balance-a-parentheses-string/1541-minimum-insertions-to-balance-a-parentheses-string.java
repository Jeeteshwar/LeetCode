class Solution {

    public int minInsertions(String s) {

        int n = s.length();

        int ans = 0;
        int open = 0;

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                open++;

            } else {

                // Check whether the next character completes '))'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    ans++; // Insert the missing ')'
                }

                if (open > 0) {
                    open--; // Match this closing pair
                } else {
                    ans++; // Insert a missing '('
                }
            }
        }

        // Each unmatched '(' requires two ')'
        return ans + open * 2;
    }
}