class Solution {
    public int colorTheGrid(int rows, int cols) {
        final int MOD = 1_000_000_007;
        int patternLimit = 1;
        for (int i = 0; i < rows; i++) patternLimit *= 3;

        int[][] dp = new int[cols + 1][patternLimit];
        int[][] isCompatible = new int[patternLimit][patternLimit];
        List<Integer> validPatterns = new ArrayList<>();
        List<Integer>[] patternToColors = new ArrayList[patternLimit];

        for (int i = 0; i < patternLimit; i++) patternToColors[i] = new ArrayList<>();

        for (int i = 0; i < patternLimit; i++) {
            int value = i;
            boolean isValid = true;
            for (int j = 0; j < rows; j++) {
                patternToColors[i].add(value % 3);
                value /= 3;
            }
            for (int j = 1; j < rows; j++) {
                if (patternToColors[i].get(j).equals(patternToColors[i].get(j - 1))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) validPatterns.add(i);
        }

        for (int pattern : validPatterns) dp[1][pattern] = 1;

        for (int p1 : validPatterns) {
            for (int p2 : validPatterns) {
                boolean compatible = true;
                for (int k = 0; k < rows; k++) {
                    if (patternToColors[p1].get(k).equals(patternToColors[p2].get(k))) {
                        compatible = false;
                        break;
                    }
                }
                isCompatible[p1][p2] = compatible ? 1 : 0;
            }
        }

        for (int col = 2; col <= cols; col++) {
            for (int currPattern : validPatterns) {
                long totalWays = 0;
                for (int prevPattern : validPatterns) {
                    if (isCompatible[currPattern][prevPattern] == 1) {
                        totalWays += dp[col - 1][prevPattern];
                    }
                }
                dp[col][currPattern] = (int)(totalWays % MOD);
            }
        }

        long result = 0;
        for (int i = 0; i < patternLimit; i++) result += dp[cols][i];
        return (int)(result % MOD);
    }
}
