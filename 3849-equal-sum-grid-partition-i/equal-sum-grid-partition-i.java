class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        // Total sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        // If odd → impossible
        if (total % 2 != 0) return false;
        long target = total / 2;

         // Horizontal cuts
        long curr = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                curr += grid[i][j];
            }
            if (curr == target) return true;
        }

        // Vertical cuts
        long[] colSum = new long[n];

        // Compute column sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colSum[j] += grid[i][j];
            }
        }

        curr = 0;
        for (int j = 0; j < n - 1; j++) {
            curr += colSum[j];
            if (curr == target) return true;
        }

        return false;
    }
}