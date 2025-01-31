class Solution {
    public int exploreIsland(int x, int y, int[][] matrix, int totalRows, int totalCols, int marker) {
        if (x < 0 || x >= totalRows || y < 0 || y >= totalCols)
            return 0;
        if (matrix[x][y] == 0 || matrix[x][y] == marker)
            return 0;
        
        matrix[x][y] = marker;
        int size = 1;
        
        size += exploreIsland(x + 1, y, matrix, totalRows, totalCols, marker);
        size += exploreIsland(x - 1, y, matrix, totalRows, totalCols, marker);
        size += exploreIsland(x, y - 1, matrix, totalRows, totalCols, marker);
        size += exploreIsland(x, y + 1, matrix, totalRows, totalCols, marker);
        
        return size;
    }

    public int largestIsland(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        
        HashMap<Integer, Integer> islandSizes = new HashMap<>();
        int marker = 2;
        
        for (int x = 0; x < totalRows; x++) {
            for (int y = 0; y < totalCols; y++) {
                if (grid[x][y] == 1) {
                    int size = exploreIsland(x, y, grid, totalRows, totalCols, marker);
                    islandSizes.put(marker, size);
                    marker++;
                }
            }
        }
        
        int maxSize = 0;
        
        for (int x = 0; x < totalRows; x++) {
            for (int y = 0; y < totalCols; y++) {
                if (grid[x][y] == 0) {
                    HashSet<Integer> neighboringIslands = new HashSet<>();
                    
                    if (x - 1 >= 0 && grid[x - 1][y] != 0)
                        neighboringIslands.add(grid[x - 1][y]);
                    if (x + 1 < totalRows && grid[x + 1][y] != 0)
                        neighboringIslands.add(grid[x + 1][y]);
                    if (y - 1 >= 0 && grid[x][y - 1] != 0)
                        neighboringIslands.add(grid[x][y - 1]);
                    if (y + 1 < totalCols && grid[x][y + 1] != 0)
                        neighboringIslands.add(grid[x][y + 1]);
                    
                    int potentialSize = 1;
                    for (int id : neighboringIslands)
                        potentialSize += islandSizes.get(id);
                    
                    maxSize = Math.max(maxSize, potentialSize);
                }
            }
        }
        
        return maxSize == 0 ? (totalRows * totalCols) : maxSize;
    }
}
