class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') { // empty cell
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isSafe(board, row, col, digit)) {
                            board[row][col] = digit; // place digit
                            
                            if (solve(board)) {
                                return true; // solution found
                            }
                            
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid digit → backtrack
                }
            }
        }
        return true; // board is completely filled
    }

    private boolean isSafe(char[][] board, int row, int col, char digit) {
        // check row & column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }
        // check 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

}