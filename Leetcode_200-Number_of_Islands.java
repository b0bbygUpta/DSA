// -- Leetcode 200 --
// -- Number of Islands -- 

class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int island=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    island++;
                    dfs(i,j,grid);
                }
            }
        }
        return island;
    }
    private void dfs(int row, int col, char[][] grid){
        int newRow=grid.length;
        int newCol=grid[0].length;

        int[][] dir=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        if(row<0 || col<0 || row>=newRow || col>=newCol || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        for(int[] i: dir){
            dfs(row+i[0], col+i[1], grid);
        }
    }
}
