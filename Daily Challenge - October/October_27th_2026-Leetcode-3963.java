// -- Leetcode 3963 -- 
// -- Create Grid With Exactly One Path -- 

APPROACH I:
  // Usign 2-Dimensional Grid

class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid=new String[m];
        grid[0]=".".repeat(n);
        String row="#".repeat(n-1)+".";
        for(int i=1;i<m;i++){
            grid[i]=row;
        }
        return grid;
    }
}


/* 
Complexities: 
    Time complexity 
        O(m.n)
    Space complexity
        O(n)
*/
