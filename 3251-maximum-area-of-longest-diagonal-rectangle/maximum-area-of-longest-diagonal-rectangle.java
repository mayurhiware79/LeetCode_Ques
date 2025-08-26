class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonals = -1;
        int maxArea = -1;

        for(int rect[] : dimensions){
            int length = rect[0];
            int width = rect[1];

            int diagonalSq = length * length + width * width; // no sqrt
            int area = length * width;

            if(diagonalSq > maxDiagonals){
                maxDiagonals = diagonalSq;
                maxArea = area;
            }else if(diagonalSq == maxDiagonals){
                maxArea = Math.max(maxArea , area);
            }
        }

        return maxArea;
    }
}