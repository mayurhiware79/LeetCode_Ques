class Solution {

    //Approach-1 (Simple Simulation)
    //T.C : O(m*n + G*(m+n)), where G =  size of guards
    //S.C : O(m*n), considering the size of grid we took

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        //declare a grid
        int[][] grid = new int[m][n];

        //mark guard position
        for(int[] guard : guards){
            int i=guard[0];
            int j=guard[1];
            grid[i][j] = 2; //guard
        }

        //mark wall position
        for(int[] wall : walls){
            int i=wall[0];
            int j=wall[1];
            grid[i][j] = 3; //walls
        }

        //mark cells guarded by each guard
        for(int[] guard : guards){
            int i=guard[0];
            int j=guard[1];
            markGuarded(i,j,grid);
        }

        //count unguarded cells
        int count =0;
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){ //unguarded
                    count++;
                }
            }
        }

        return count;
    }

    public void markGuarded(int row, int col, int[][] grid){

        //Up
        for(int i=row-1; i>=0;i--){
            if(grid[i][col] ==2 || grid[i][col] == 3){
                break;
            }
            grid[i][col] =1; //marking as guarded
        }

        //Down
        for(int i=row+1; i< grid.length;i++){
            if(grid[i][col] ==2 || grid[i][col] == 3){
                break;
            }
            grid[i][col] =1; //marking as guarded
        }

        //left
        for(int j=col-1; j >=0;j--){
            if(grid[row][j] ==2 || grid[row][j] == 3){
                break;
            }
            grid[row][j] =1; //marking as guarded
        }

        //right
        for(int j=col+1; j < grid[0].length;j++){
            if(grid[row][j] ==2 || grid[row][j] == 3){
                break;
            }
            grid[row][j] =1; //marking as guarded
        }
    }
}