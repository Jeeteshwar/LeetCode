class Solution {
    public int[][] highestPeak(int[][] waterGrid) {
        int rows = waterGrid.length;
        int cols = waterGrid[0].length;
        int[][] heightMap = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            Arrays.fill(heightMap[r], -1);
        }

        Queue<int[]> cellQueue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (waterGrid[r][c] == 1) {
                    heightMap[r][c] = 0;
                    cellQueue.add(new int[]{r, c});
                }
            }
        }

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        while (!cellQueue.isEmpty()) {
            int[] currentCell = cellQueue.poll();
            int currentRow = currentCell[0];
            int currentCol = currentCell[1];
            int currentHeight = heightMap[currentRow][currentCol];

            for (int d = 0; d < 4; d++) {
                int newRow = currentRow + rowOffsets[d];
                int newCol = currentCol + colOffsets[d];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && heightMap[newRow][newCol] == -1) {
                    heightMap[newRow][newCol] = currentHeight + 1;
                    cellQueue.add(new int[]{newRow, newCol});
                }
            }
        }

        return heightMap;
    }
}
