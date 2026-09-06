// -- Leetcode 213 -- 
// -- House Robber 2 -- 

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n == 1){
            return nums[0];
        }
        int max1=max(nums,0,n-1);
        int max2=max(nums,1,n);
        int ans=Math.max(max1,max2);
        return ans;
    }
    private int max(int[] nums,int l, int r){
        int rob1=0; 
        int rob2=0;
        int max=0;
        for(int i=l;i<r;i++){
            max=Math.max(rob1+nums[i],rob2);
            rob1=rob2;
            rob2=max;
        }
        return max;
    }
}
