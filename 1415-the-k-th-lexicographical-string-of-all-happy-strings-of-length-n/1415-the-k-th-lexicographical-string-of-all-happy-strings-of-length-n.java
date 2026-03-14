class Solution {
    private int count = 0;
    private String result = "";

    public String getHappyString(int n, int k) {
        backtrack(n, k, new StringBuilder());
        return result;
    }

    private void backtrack(int n, int k, StringBuilder current) {
        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current.toString();
            }
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (current.length() == 0 || current.charAt(current.length() - 1) != ch) {
                current.append(ch);
                backtrack(n, k, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}