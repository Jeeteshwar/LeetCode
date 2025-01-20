class Solution {
   
    private boolean checkrow(int[][] matirx, int row) {
        for (int col = 0; col < matirx[0].length; col++) {
            if (matirx[row][col] > 0) { // not painted
                return false;
            }
        }
        return true;
    }

    private boolean checkcol(int[][] matirx, int col) {
        for (int row = 0; row < matirx.length; row++) {
            if (matirx[row][col] > 0) { // not painted
                return false;
            }
        }
        return true;
    }
    public int firstCompleteIndex(int[] arr, int[][] matirx) {
        int m = matirx.length;
        int n = matirx[0].length;

        Map<Integer, int[]> mp = new HashMap<>(); // stores value to cell-coordinate [i][j]

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matirx[i][j];
                mp.put(val, new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int[] coordinates = mp.get(val);
            int row = coordinates[0], col = coordinates[1];
            matirx[row][col] *= -1; // painted

            if (checkrow(matirx, row) || checkcol(matirx, col)) {
                return i;
            }
        }

        return -1;
    }
}
    
