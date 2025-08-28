//Approach - Without Map - Simulation
//T.C : O(n^2 * logn)
//S.C : O(n)
class Solution {
    private int n;

    private void sortDiagonal(int r, int c, int[][] grid, boolean asc) {
        List<Integer> vec = new ArrayList<>();

        int i = r, j = c;
        while (i < n && j < n) {
            vec.add(grid[i][j]);
            i++;
            j++;
        }

        if (asc) {
            Collections.sort(vec); // ascending
        } else {
            vec.sort(Collections.reverseOrder()); // descending
        }

        i = r;
        j = c;
        for (int val : vec) {
            grid[i][j] = val;
            i++;
            j++;
        }
    }

    public int[][] sortMatrix(int[][] grid) {
        n = grid.length;

        // Bottom-left diagonals → sort in non-increasing order
        for (int row = 0; row < n; row++) {
            sortDiagonal(row, 0, grid, false);
        }

        // Top-right diagonals → sort in non-decreasing order
        for (int col = 1; col < n; col++) {
            sortDiagonal(0, col, grid, true);
        }

        return grid;
    }
}
