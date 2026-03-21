class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] ans = new int[m - k + 1][n - k + 1];
        
        // Traverse all possible k x k submatrices
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                
                // Step 1: Collect elements in submatrix
                List<Integer> list = new ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        list.add(grid[x][y]);
                    }
                }
                
                // Step 2: Remove duplicates
                Set<Integer> set = new HashSet<>(list);
                
                // If only one unique element → answer = 0
                if (set.size() <= 1) {
                    ans[i][j] = 0;
                    continue;
                }
                
                // Step 3: Convert to list and sort
                List<Integer> uniqueList = new ArrayList<>(set);
                Collections.sort(uniqueList);
                
                // Step 4: Find minimum difference between adjacent elements
                int minDiff = Integer.MAX_VALUE;
                for (int t = 1; t < uniqueList.size(); t++) {
                    minDiff = Math.min(minDiff, 
                        uniqueList.get(t) - uniqueList.get(t - 1));
                }
                
                // Step 5: Store result
                ans[i][j] = minDiff;
            }
        }
        
        return ans;
    }
}