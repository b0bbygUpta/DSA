// -- Leetcode 3619 -- 
// -- Count Islands With Total Value Divisible by K -- 

APPROACH I: 
  // Using Depth First Search 
  
// DFS

class Solution {
    private int m,n;
    private final int[] dir={-1,0,1,0,-1};
    
    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0 && dfs(grid,i,j)%k == 0){
                    ++ans;
                }
            }
        }
        return ans;
    }

    private long dfs(int[][] grid, int i, int j){
        long sum=grid[i][j];
        grid[i][j]=0;
        for(int d=0;d<4;d++){
            int x=i+dir[d], y=j+dir[d+1];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]>0){
                sum+=dfs(grid,x,y);
            }
        }
        return sum;

    }
}

/* 
Complexities: 
    Time complexity
        O(m.n)
    Space complexity
        O(m.n)

*/ 

APPROACH II: 
  // Using Breath First Search 

// BFS 
  
class Solution {
    private int m,n;
    private final int[] dir={-1,0,1,0,-1};

    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long sum=bfs(grid,i,j);
                    if(sum%k == 0){
                        ans++;
                    }
                }
            }
        }    
        return ans;

    }

    private long bfs(int[][] grid, int i, int j){
        Queue<int[]> q=new LinkedList<>();
        long sum=grid[i][j];
        q.offer(new int[]{i,j});
        grid[i][j]=0;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];

            for(int d=0;d<4;d++){
                int a=x+dir[d], b=y+dir[d+1];
                if(a>=0 && a<m && b>=0 && b<n && grid[a][b]>0){
                    sum += grid[a][b];
                    q.offer(new int[]{a,b});
                    grid[a][b]=0;
                }
            }
        }
        return sum;

    }
}

/* 
Complexities: 
    Time complexity
        O(m.n)
    Space complexity
        O(m.n)

*/ 

