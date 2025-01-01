class Solution {
    public int maxScore(String s) {
        int allzeros_ = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') allzeros_++;
        }
        int ans = -1, zeros_ = 0, n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '0') {
                zeros_++;
                allzeros_--;
            }
            ans = Math.max(ans, zeros_ + (n - allzeros_ - i));
        }
        return ans;
    }
}