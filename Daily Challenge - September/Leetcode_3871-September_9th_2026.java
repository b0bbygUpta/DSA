// -- Leetcode 3871 -- 
// -- Count Commas in Range 2 -- 


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
