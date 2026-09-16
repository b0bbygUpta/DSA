// -- Leetcode 1621 -- 
// -- September_16th_2026-Number_of_Sets_of_K_Non-Overlapping_Line_Sagments.java -- 

class Solution {

    private static final int MOD = 1000000007;

    public int numberOfSets(int n, int k) {
        int[] dp=new int[n];
        int[] prefixSums=new int[n+1];
        for(int i=0;i<n;i++){
            dp[i]=1;
            prefixSums[i+1]=(prefixSums[i]+dp[i])%MOD;
        }    
        for(int i=1;i<=k;i++){
            dp[0]=0;
            for(int j=1;j<n;j++){
                dp[j]=(dp[j-1]+prefixSums[j])%MOD;
            }
            for(int j=0;j<n;j++){
                prefixSums[j+1]=(prefixSums[j]+dp[j])%MOD;
            }
        }
        return dp[n-1];
    }
}
