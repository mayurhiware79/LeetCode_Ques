class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Step 1: Build histogram for this row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            // Step 2: Find max rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }

    // LC 84 logic
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                maxArea = Math.max(maxArea, h * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
