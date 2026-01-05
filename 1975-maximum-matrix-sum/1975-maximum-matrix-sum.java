class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minAbsoluteValue = Integer.MAX_VALUE; // Smallest absolute value in the matrix
        long totalSum = 0; // Sum of absolute values of all elements
        int negativeCount = 0; // Count of negative numbers in the matrix
        
        // Iterate through the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                
                // Count negative numbers
                if (value < 0) {
                    negativeCount++;
                }
                
                // Update the smallest absolute value
                int absoluteValue = Math.abs(value);
                minAbsoluteValue = Math.min(minAbsoluteValue, absoluteValue);
                
                // Add the absolute value to the total sum
                totalSum += absoluteValue;
            }
        }
        
        // If the count of negative numbers is even, we can make all elements positive
        if (negativeCount % 2 == 0) {
            return totalSum;
        }
        
        // If the count of negative numbers is odd, subtract twice the smallest absolute value
        return totalSum - 2 * minAbsoluteValue;
    }
}
