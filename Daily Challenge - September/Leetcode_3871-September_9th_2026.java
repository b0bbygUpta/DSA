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
