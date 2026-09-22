// -- Leetcode 684 -- 
// -- Redundant Connection -- 

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents=new int[edges.length+1];
        for(int i=1;i<=edges.length;i++){
            parents[i]=i;
        }

        for(int[] e: edges){
            int node1=e[0];
            int node2=e[1];

            int root1=find(parents, node1);
            int root2=find(parents, node2);

            if(root1 == root2){
                return e;
            }

            parents[root2]=root1;
        }

        return new int[0];
    }

    private int find(int[] parents, int node){
        while(node != parents[node]){
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }
}
