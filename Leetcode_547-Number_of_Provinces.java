// -- Leetcode 547 -- 
// -- Number of Porvinces -- 

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int p=0; // p = provinces

        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(isConnected, visited, i);
                p++;

            }
        }
        return p;
    }

    private void bfs(int[][] isConnected, boolean[] vis, int start){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        vis[start]=true;

        while(!q.isEmpty()){
            int city=q.poll();
            for(int i=0;i<isConnected.length;i++){
                if(isConnected[city][i] == 1 && !vis[i]){
                    vis[i]=true;
                    q.offer(i);
                }
            }
        }
    }
}
