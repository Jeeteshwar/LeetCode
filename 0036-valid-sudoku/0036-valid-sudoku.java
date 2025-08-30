class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSets = new HashSet[9];
        HashSet<Character>[] colSets = new HashSet[9];
        HashSet<Character>[] boxSets = new HashSet[9];

        for (int index = 0; index < 9; index++) {
            rowSets[index] = new HashSet<>();
            colSets[index] = new HashSet<>();
            boxSets[index] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char currentCell = board[row][col];
                if (currentCell == '.') continue;

                int boxIndex = (row / 3) * 3 + (col / 3);

                if (rowSets[row].contains(currentCell) || 
                    colSets[col].contains(currentCell) || 
                    boxSets[boxIndex].contains(currentCell)) {
                    return false;
                }

                rowSets[row].add(currentCell);
                colSets[col].add(currentCell);
                boxSets[boxIndex].add(currentCell);
            }
        }

        return true;
    }
}
