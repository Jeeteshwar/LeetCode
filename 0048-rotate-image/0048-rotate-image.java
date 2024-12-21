class Solution {
    // Helper function to reverse a single row in the matrix
    public void reverseRow(int[] row) {
        int left = 0, right = row.length - 1;
        // Reverse the row using two-pointer approach
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length; // Number of rows (and columns) in the square matrix
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Start from j = i + 1 to avoid redundant swaps
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row to complete the rotation
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }
}
