class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    public boolean backtrack(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') { // empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValidPlacement(board, row, col, num)) {
                            board[row][col] = num; // place number
                            if (backtrack(board)) {
                                return true; // solution found
                            } else {
                                board[row][col] = '.'; // undo placement
                            }
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // board filled
    }

    public boolean isValidPlacement(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // column check
            if (board[i][col] == num) {
                return false;
            }
            // row check
            if (board[row][i] == num) {
                return false;
            }
            // 3x3 subgrid check
            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 3;
            if (board[subgridRow][subgridCol] == num) {
                return false;
            }
        }
        return true;
    }
}
