class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxK = Math.min(m, n);
        int ans = 1; // 1x1 is always magic

        for (int k = 1; k <= maxK; k++) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    if (isMagic(grid, i, j, k)) {
                        ans = Math.max(ans, k);
                    }
                }
            }
        }
        return ans;
    }

    private boolean isMagic(int[][] g, int r, int c, int k) {
        int target = 0;

        // sum of first row
        for (int j = 0; j < k; j++) {
            target += g[r][c + j];
        }

        // Check all rows
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += g[r + i][c + j];
            }
            if (sum != target) return false;
        }

        // Check all columns
        for (int j = 0; j < k; j++) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += g[r + i][c + j];
            }
            if (sum != target) return false;
        }

        // Check main diagonal
        int d1 = 0;
        for (int i = 0; i < k; i++) {
            d1 += g[r + i][c + i];
        }
        if (d1 != target) return false;

        // Check anti-diagonal
        int d2 = 0;
        for (int i = 0; i < k; i++) {
            d2 += g[r + i][c + k - 1 - i];
        }
        return d2 == target;
    }
}
