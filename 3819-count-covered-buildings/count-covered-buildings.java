class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;
        // Use 1..n indices (given in problem). Initialize mins to large, maxs to small.
        int INF = Integer.MAX_VALUE;
        int[] minColInRow = new int[n + 1]; // min y for each row x
        int[] maxColInRow = new int[n + 1]; // max y for each row x
        int[] minRowInCol = new int[n + 1]; // min x for each col y
        int[] maxRowInCol = new int[n + 1]; // max x for each col y

        // init
        for (int i = 1; i <= n; i++) {
            minColInRow[i] = INF;
            maxColInRow[i] = -INF;
            minRowInCol[i] = INF;
            maxRowInCol[i] = -INF;
        }

        // First pass: compute min/max per row and per column
        for (int[] b : buildings) {
            int x = b[0]; // row
            int y = b[1]; // col

            if (y < minColInRow[x]) minColInRow[x] = y;
            if (y > maxColInRow[x]) maxColInRow[x] = y;

            if (x < minRowInCol[y]) minRowInCol[y] = x;
            if (x > maxRowInCol[y]) maxRowInCol[y] = x;
        }

        // Second pass: check each building
        int covered = 0;
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            boolean hasAboveAndBelow = (minRowInCol[y] < x && maxRowInCol[y] > x);
            boolean hasLeftAndRight = (minColInRow[x] < y && maxColInRow[x] > y);

            if (hasAboveAndBelow && hasLeftAndRight) covered++;
        }

        return covered;
    }
}


// Brute Force O(N^2)

// class Solution {
//     public int countCoveredBuildings(int n, int[][] buildings) {
//         int m = buildings.length;  // Number of buildings
//         int count = 0;

//         for (int i = 0; i < m; i++) {
//             int x = buildings[i][0];
//             int y = buildings[i][1];

//             boolean hasAbove = false;
//             boolean hasBelow = false;
//             boolean hasLeft = false;
//             boolean hasRight = false;

//             for (int j = 0; j < m; j++) {
//                 if (i == j) continue;

//                 int u = buildings[j][0];
//                 int v = buildings[j][1];

//                 if (v == y) {
//                     if (u < x) hasAbove = true;
//                     if (u > x) hasBelow = true;
//                 }

//                 if (u == x) {
//                     if (v < y) hasLeft = true;
//                     if (v > y) hasRight = true;
//                 }
//             }

//             if (hasAbove && hasBelow && hasLeft && hasRight) {
//                 count++;
//             }
//         }

//         return count;
//     }
// }

