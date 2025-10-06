class Solution {
    int directions[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public int swimInWater(int[][] terrain) {
        int size = terrain.length;
        int result = Integer.MAX_VALUE;
        int left = 0, right = size * size - 1;

        while (left <= right) {
            int midLevel = (left + right) / 2;
            boolean visited[][] = new boolean[size][size];
            if (terrain[0][0] <= midLevel && canReachEnd(0, 0, midLevel, terrain, visited)) {
                result = midLevel;
                right = midLevel - 1;
            } else {
                left = midLevel + 1;
            }
        }
        return result;
    }

    boolean canReachEnd(int row, int col, int time, int[][] terrain, boolean[][] visited) {
        int size = terrain.length;
        visited[row][col] = true;
        if (row == size - 1 && col == size - 1) return true;

        for (int[] dir : directions) {
            int nextRow = row + dir[0], nextCol = col + dir[1];
            if (nextRow >= 0 && nextRow < size && nextCol >= 0 && nextCol < size &&
                !visited[nextRow][nextCol] && terrain[nextRow][nextCol] <= time) {
                if (canReachEnd(nextRow, nextCol, time, terrain, visited)) return true;
            }
        }
        return false;
    }
}
