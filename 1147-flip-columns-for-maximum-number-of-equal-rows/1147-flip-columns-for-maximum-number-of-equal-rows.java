class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int maxrows = 0;

        for (int[] curr : matrix) {
            int[] invert = new int[n];
            int count = 0;

            // Generate the invert row
            for (int col = 0; col < n; col++) {
                invert[col] = curr[col] == 0 ? 1 : 0;
            }

            // Count matching rows (either equal to curr or invert)
            for (int[] row : matrix) {
                if (Arrays.equals(row, curr) || Arrays.equals(row, invert)) {
                    count++;
                }
            }

            maxrows = Math.max(maxrows, count);
        }

        return maxrows;
    }
}