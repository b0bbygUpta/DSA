// -- Leetcode 1569 -- 
// -- Number of Ways to Reorder Arrays to Get Same BST -- 


APPROACH I:
  // Using Recursion
  
class Solution {
    private long mod=1000000007;
    private long[][] table;

    public int numOfWays(int[] nums) {
        int n=nums.length;
        table=new long[n][n];
        // Pascel's triangle for nCr combination
        for(int i=0;i<n;i++){
            table[i][0]=1;
            for(int j=1;j<=i;j++){
                table[i][j]=(table[i-1][j-1]+table[i-1][j])%mod;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i: nums){
            list.add(i);
        }

        return (int)((ways(list)-1+mod)%mod);
    }

    private long ways(List<Integer> list){
        int n=list.size();
        if(n<3) return 1;
        int root=list.get(0);
        List<Integer> l=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(list.get(i)<root) l.add(list.get(i));
            else r.add(list.get(i));
        }
        long lw=ways(l);
        long rw=ways(r);
        long total=table[n-1][l.size()];

        return (lw*rw%mod)*total%mod;


    }
}
