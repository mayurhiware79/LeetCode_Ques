class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int r, int c) {
        // Collect numbers and check distinct + range 1-9
        boolean[] seen = new boolean[10]; // index 1-9 used
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        // Check center must be 5
        if (grid[r+1][c+1] != 5) return false;

        // Check sums of rows, columns, diagonals = 15
        return (
            // Rows
            grid[r][c] + grid[r][c+1] + grid[r][c+2] == 15 &&
            grid[r+1][c] + grid[r+1][c+1] + grid[r+1][c+2] == 15 &&
            grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2] == 15 &&
            // Cols
            grid[r][c] + grid[r+1][c] + grid[r+2][c] == 15 &&
            grid[r][c+1] + grid[r+1][c+1] + grid[r+2][c+1] == 15 &&
            grid[r][c+2] + grid[r+1][c+2] + grid[r+2][c+2] == 15 &&
            // Diagonals
            grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] == 15 &&
            grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] == 15
        );
    }
}
