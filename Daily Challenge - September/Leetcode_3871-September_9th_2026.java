// -- Leetcode 3871 -- 
// -- Count Commas in Range 2 -- 

APPROCACH I: 
// Using basic Mathematical operations.
    
class Solution {
    public long countCommas(long n) {
        long p=1000, res=0;
        while(p<=n){
            res+=n-p+1;
            p*=1000;
        }
        return res;
    }
}

APPROACH II:
// Recursive Approach 
    
// Using a helper function using recursion to do this job.

class Solution {
    public long countCommas(long n) {
        return helper(n, 1000);
    }
    private long helper(long n, long p){
        if(p>n) return 0;

        return (n-p+1)+helper(n,p*1000);
    }
}

APPROACH III: 
// Using Backtracking Method

// Using a hepler fuction based on backtracking 

class Solution {
    public long countCommas(long n) {
        return backtracking(n, 1000, 0);
    }
    private long backtracking(long n, long p, long res){
        if(p>n){
            return res;
        }
        long ans=res+(n-p+1);

        return backtracking(n, p*1000, ans);
    }
}


APPROACH IV:
// Using DFS Method

class Solution {
    public long countCommas(long n) {
        return dfs(n, 1000);
    }

    private long dfs(long n, long p) {
        if (p > n) {
            return 0; // base case: stop when p exceeds n
        }
        // process current node (contribution for this p)
        long contribution = n - p + 1;

        // recurse deeper (next power of 1000)
        long deeper = dfs(n, p * 1000);

        // combine current + deeper
        return contribution + deeper;
    }
}
