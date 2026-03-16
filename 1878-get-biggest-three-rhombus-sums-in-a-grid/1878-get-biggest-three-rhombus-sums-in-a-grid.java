class Solution {
    
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set = new TreeSet<>() ; 
        int m = grid.length ; 
        int n = grid[0].length ; 
        for (int i = 0 ; i < m ; i++ ) {
            for (int j = 0 ;j < n ; j++ ){

                set.add(grid[i][j]) ;
                for (int k = 1 ; k < 50 ; k++ ) {
                    // boundary Condition 
                    if (i + 2 * k >= m ) break ; 
                    if (j - k < 0 || j + k >= n ) break ; 
                    // now calculation 
                    int sum = 0 ; 
                    // down left -> r++ , c-- 
                    // down right -> r++ , c++ 
                    // up left -> r-- , c-- 
                    // up right -> r-- , c++ 
                    int r = i ; 
                    int c = j ; 
                    for (int a = 0 ; a < k ; a++ ) {
                        sum += grid[r++][c++] ;
                    }
                    for (int a = 0 ; a < k ; a++ ){
                        sum += grid[r++][c--] ; 
                    }
                    for (int a = 0 ; a < k ; a++ ) {
                        sum += grid[r--][c--] ; 
                    }
                    for (int a = 0 ; a < k ; a++ ) {
                        sum += grid[r--][c++] ; 
                    }
                    set.add(sum) ; 
                }
            }
        }
        int size = Math.min(set.size() , 3 ) ; 
        int ans[] = new int[size] ; 
        for (int i = 0 ; i < size ; i++ ){
            ans[i] = set.pollLast() ; 
        }
        return ans ; 
    }
}