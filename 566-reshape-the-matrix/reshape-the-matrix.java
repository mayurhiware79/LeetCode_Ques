class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        //storing the values of mat matrix
        //i.e m = rows & n = cols
        int rows = mat.length;
        int cols = mat[0].length;

        //if product of rows & cols of mat matrix and new matrix are not same then
        if((rows * cols) != (r * c)) return mat;

        //creating the new matrix
        int[][] output = new int[r][c];
        int output_rows = 0;
        int output_cols = 0;

        //traversing mat matrix and storing its values in new matrix output cols wise
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols;j++){
                output[output_rows][output_cols] = mat[i][j];
                output_cols++;

                //if cols value reached then change the row and set cols value to 0
                if(output_cols == c){
                    output_cols = 0;
                    output_rows++;
                }
            }
        }

        return output;

    }
}