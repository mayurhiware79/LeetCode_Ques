class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int MAXV = 100000;
        long totalRowSum = 0L, totalColSum = 0L;

        long[] prefixRowWise = new long[n];
        long[] prefixColWise = new long[m];

        int[] minRow = new int[MAXV + 1];
        int[] maxRow = new int[MAXV + 1];
        int[] minCol = new int[MAXV + 1];
        int[] maxCol = new int[MAXV + 1];

        Arrays.fill(minRow, -1);
        Arrays.fill(maxRow, -1);
        Arrays.fill(minCol, -1);
        Arrays.fill(maxCol, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = grid[i][j];
                long val = v;

                prefixRowWise[i] += val;
                prefixColWise[j] += val;

                if (minRow[v] == -1) {
                    minRow[v] = maxRow[v] = i;
                    minCol[v] = maxCol[v] = j;
                } else {
                    minRow[v] = Math.min(minRow[v], i);
                    maxRow[v] = Math.max(maxRow[v], i);
                    minCol[v] = Math.min(minCol[v], j);
                    maxCol[v] = Math.max(maxCol[v], j);
                }
            }
        }

        for (long r : prefixRowWise) totalRowSum += r;
        totalColSum = totalRowSum;

        long currentRowUpperSum = 0;
        for (int i = 0; i < n - 1; i++) {
            currentRowUpperSum += prefixRowWise[i];
            long lowerSegmentSum = totalRowSum - currentRowUpperSum;

            if (currentRowUpperSum == lowerSegmentSum) return true;

            if (currentRowUpperSum > lowerSegmentSum) {
                long diff = currentRowUpperSum - lowerSegmentSum;

                if (diff <= MAXV && minRow[(int) diff] != -1) {
                    if (i == 0 || m == 1) {
                        if (diff == grid[0][0] || diff == grid[0][m - 1] || diff == grid[i][0])
                            return true;
                    } else if (minRow[(int) diff] <= i) {
                        return true;
                    }
                }
            } else {
                long diff = lowerSegmentSum - currentRowUpperSum;

                if (diff <= MAXV && maxRow[(int) diff] != -1) {
                    if (i == n - 2 || m == 1) {
                        if (diff == grid[i + 1][0] || diff == grid[i + 1][m - 1] || diff == grid[n - 1][0])
                            return true;
                    } else if (maxRow[(int) diff] > i) {
                        return true;
                    }
                }
            }
        }

        long currentColLeftSum = 0;
        for (int j = 0; j < m - 1; j++) {
            currentColLeftSum += prefixColWise[j];
            long rightSegmentSum = totalColSum - currentColLeftSum;

            if (currentColLeftSum == rightSegmentSum) return true;

            if (currentColLeftSum > rightSegmentSum) {
                long diff = currentColLeftSum - rightSegmentSum;

                if (diff <= MAXV && minCol[(int) diff] != -1) {
                    if (j == 0 || n == 1) {
                        if (diff == grid[0][0] || diff == grid[n - 1][0] || diff == grid[0][j])
                            return true;
                    } else if (minCol[(int) diff] <= j) {
                        return true;
                    }
                }
            } else {
                long diff = rightSegmentSum - currentColLeftSum;

                if (diff <= MAXV && maxCol[(int) diff] != -1) {
                    if (j == m - 2 || n == 1) {
                        if (diff == grid[0][j + 1] || diff == grid[n - 1][j + 1] || diff == grid[0][m - 1])
                            return true;
                    } else if (maxCol[(int) diff] > j) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}