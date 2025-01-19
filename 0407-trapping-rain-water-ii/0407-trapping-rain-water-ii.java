class Solution {
    public int trapRainWater(int[][] terrain) {
        if (terrain == null || terrain.length == 0 || terrain[0].length == 0) 
            return 0;

        int rows = terrain.length, cols = terrain[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        PriorityQueue<int[]> boundaryCells = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add edge cells to the heap
        for (int r = 0; r < rows; ++r) {
            for (int c : new int[]{0, cols - 1}) {
                boundaryCells.offer(new int[]{terrain[r][c], r, c});
                isVisited[r][c] = true;
            }
        }
        for (int c = 0; c < cols; ++c) {
            for (int r : new int[]{0, rows - 1}) {
                if (!isVisited[r][c]) {
                    boundaryCells.offer(new int[]{terrain[r][c], r, c});
                    isVisited[r][c] = true;
                }
            }
        }

        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int totalWater = 0;

        while (!boundaryCells.isEmpty()) {
            int[] currentCell = boundaryCells.poll();
            int currentHeight = currentCell[0], currentRow = currentCell[1], currentCol = currentCell[2];

            for (int[] move : moves) {
                int nextRow = currentRow + move[0], nextCol = currentCol + move[1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !isVisited[nextRow][nextCol]) {
                    totalWater += Math.max(0, currentHeight - terrain[nextRow][nextCol]);
                    boundaryCells.offer(new int[]{Math.max(currentHeight, terrain[nextRow][nextCol]), nextRow, nextCol});
                    isVisited[nextRow][nextCol] = true;
                }
            }
        }

        return totalWater;
    }
}