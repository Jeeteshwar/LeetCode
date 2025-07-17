
class Solution {
    public int maximumLength(int[] nums, int k) {
        int maxlen = 2;

        for (int targetMod = 0; targetMod < k; targetMod++) {
            int[] remainderDP = new int[k];

            for (int num : nums) {
                int nmmod = num % k;
                int requiredMod = (targetMod - nmmod + k) % k;
                remainderDP[nmmod] = remainderDP[requiredMod] + 1;
            }

            for (int length : remainderDP) {
                maxlen = Math.max(maxlen, length);
            }
        }

        return maxlen;
    }
}