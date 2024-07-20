class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;  // Number of rows in the matrix
        int n = colSum.length;  // Number of columns in the matrix

        int [][] matrix = new int[m][n];  // Initialize the matrix with zeros

        int i = 0, j = 0;  // Start with the first row and the first column

        // Loop until either all rows or all columns are processed
        while(i < m && j < n) {

            // Set the current cell to the minimum of the current row sum and column sum
            matrix[i][j] = Math.min(rowSum[i], colSum[j]);

            // Subtract the value set in the matrix from the corresponding row sum and column sum
            rowSum[i] -= matrix[i][j];
            colSum[j] -= matrix[i][j];

            // If the current row sum becomes zero, move to the next row
            if(rowSum[i] == 0) i++;
            // If the current column sum becomes zero, move to the next column
            if(colSum[j] == 0) j++;
        }

        return matrix;  // Return the constructed matrix
    }
}
