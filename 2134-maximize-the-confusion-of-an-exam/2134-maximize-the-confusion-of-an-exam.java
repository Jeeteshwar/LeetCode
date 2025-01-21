class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxLength(answerKey, k, 'T'), maxLength(answerKey, k, 'F'));
    }

    private int maxLength(String answerKey, int k, char target) {
        int left = 0, maxLen = 0, flips = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) != target) {
                flips++;
            }

            while (flips > k) {
                if (answerKey.charAt(left) != target) {
                    flips--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
