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


/* 
Complexities: 


Let m be the size of nums.

Time complexity: O(m 
2
 )

In Java or C++, a table of Pascal's triangle of size m×m is built, which takes O(m 
2
 ) time.

dfs(nums) recursively calls itself to process the left and right subtrees of the current node nums[0].
Since the total size of the subtrees decreases by 1 at each level of the recursion, the maximum height
of the recursion tree is m. Thus the total time complexity of the recursive solution is O(m^2) 
because in each call we are doing O(m) work creating the subsequences.

Space complexity: O(m^2) or O(m)

In Java or C++, a table of Pascal's triangle of size m×m is built.
The recursive solution uses the call stack to keep track of the current subtree being processed. The 
maximum depth of the call stack is equal to the height of the BST constructed from the input array. I
n the worst case, nums may form a degenerate BST (e.g., a sorted array), which has a height of m−1, 
and the stack can hold up to m−1 calls, resulting in a space complexity of O(m).


*/


APPROACH II: 
  
class Solution {
    private long mod=1000000007;
    private long[][] table;

    public int numOfWays(int[] nums) {
        int n=nums.length;
        table=new long[n][n];

        // Build Pascal's Triangle for nCr combinations
        for(int i=0;i<n;i++){
            table[i][0]=1;
            for(int j=1;j<=i;j++){
                table[i][j]=(table[i-1][j-1]+table[i-1][j])%mod;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i: nums) list.add(i);

        return (int)((ways(list)-1+mod)%mod);

    }

    private long ways(List<Integer> list){
        int n=list.size();

        if(n < 3) return 1;
        int root=list.get(0);
        List<Integer> l=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(list.get(i)<root) l.add(list.get(i));
            else r.add(list.get(i));
        }
        long lw=ways(l);
        long rw=ways(r);
        long totalw=table[n-1][l.size()];

        return (lw*rw%mod)*totalw%mod;
    }
}
