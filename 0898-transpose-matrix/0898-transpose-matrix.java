class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length; // Number of rows in the input matrix
        int cols = matrix[0].length; // Number of columns in the input matrix

        // Create a new matrix with dimensions swapped
        int[][] transposed = new int[cols][rows];

        // Iterate over each element of the input matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Assign the element at (i, j) in the original matrix
                // to the position (j, i) in the transposed matrix
                transposed[j][i] = matrix[i][j];
            }
        }

        // Return the new transposed matrix
        return transposed;
    }
}
