class Solution {
    public int longestBalanced(int[] nums) {
     int n = nums.length;
        int maxLen = 0;

        for (int start = 0; start < n; start++) {
            boolean[] seenEven = new boolean[100001];
            boolean[] seenOdd = new boolean[100001];

            int distinctEven = 0;
            int distinctOdd = 0;

            for (int end = start; end < n; end++) {
                int val = nums[end];

                if (val % 2 == 0) {
                    if (!seenEven[val]) {
                        seenEven[val] = true;
                        distinctEven++;
                    }
                } else {
                    if (!seenOdd[val]) {
                        seenOdd[val] = true;
                        distinctOdd++;
                    }
                }

                if (distinctEven == distinctOdd) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }

        return maxLen;
    }
}