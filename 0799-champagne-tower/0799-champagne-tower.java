class Solution {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[] currentRow = new double[queryRow + 2];
        currentRow[0] = poured;

        for (int row = 0; row < queryRow; row++) {
            double[] nextRow = new double[queryRow + 2];
            
            for (int glass = 0; glass <= row; glass++) {
                double champagneAmount = currentRow[glass];
                
                if (champagneAmount > 1.0) {
                    double overflow = (champagneAmount - 1.0) / 2.0;
                    nextRow[glass] += overflow;
                    nextRow[glass + 1] += overflow;
                }
            }
            
            currentRow = nextRow;
        }

        return Math.min(currentRow[queryGlass], 1.0);
    }
}