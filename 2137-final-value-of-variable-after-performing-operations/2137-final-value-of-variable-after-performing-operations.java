class Solution {
    public int finalValueAfterOperations(String[] s) {
        int n = s.length;

        int count  = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("++X") || s[i].equals("X++")) {
                count++;
            } else if (s[i].equals("--X") || s[i].equals("X--")) {
                count--;
            }
        }
        return count;
    }
}