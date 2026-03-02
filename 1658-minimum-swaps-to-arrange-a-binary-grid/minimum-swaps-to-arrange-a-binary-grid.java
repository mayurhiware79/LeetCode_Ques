class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] maxRight = new int[n];

        // Step 1: Find rightmost 1 in each row
        for (int i = 0; i < n; i++) {
            int rightmost = -1;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    rightmost = j;
                    break;
                }
            }
            maxRight[i] = rightmost;
        }

        int swaps = 0;

        // Step 2: Try to arrange rows
        for (int i = 0; i < n; i++) {

            int j = i;

            // Find row that can satisfy condition
            while (j < n && maxRight[j] > i) {
                j++;
            }

            // If not found
            if (j == n) return -1;

            // Bring row j to position i
            while (j > i) {
                int temp = maxRight[j];
                maxRight[j] = maxRight[j - 1];
                maxRight[j - 1] = temp;

                swaps++;
                j--;
            }
        }

        return swaps;
    }
}