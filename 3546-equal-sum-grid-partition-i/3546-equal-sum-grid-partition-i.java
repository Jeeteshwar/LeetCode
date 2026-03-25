class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long sum =0;
        for(int[] xy : grid){
            for(int x : xy) sum+= x;
        }
        if(sum % 2 != 0) return false; // if odd sum.. we cannot split it 
        long target = sum/2;
        // if we can get this target sum.. we can return true

        // try horizontally 
        int row =0;
        long rowsum = 0;
        while(row < m-1){
            for(int j=0;j<n;j++){
                rowsum += grid[row][j];
            }
            if(rowsum == target) return true;
            if(rowsum > target) break;
            row++;
        }

        // try vertically
        int col = 0;
        long colsum =0;
        while(col <n-1){
            for(int i=0;i<m;i++){
                colsum += grid[i][col];
            }
            if(colsum == target) return true;
            if(colsum > target) break;
            col++;
        }
        return false;   
    }
}