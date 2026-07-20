class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int n = row * col;

        k = k % n;

        if (k != 0) {
            reverse(grid, col, 0, n - 1);
            reverse(grid, col, 0, k - 1);
            reverse(grid, col, k, n - 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int[] r : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int val : r) {
                rowList.add(val);
            }
            result.add(rowList);
        }
        return result;
    }

    private void reverse(int[][] grid, int col, int i, int j) {
        while (i < j) {
            int temp = grid[i / col][i % col];

            grid[i / col][i % col] = grid[j / col][j % col];

            grid[j / col][j % col] = temp;
            
            i++;
            j--;
        }
    }
}