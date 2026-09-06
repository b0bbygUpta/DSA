// -- Leetcode 198 -- 
// -- House_Robber_1.java -- 


class Solution{
  public int rob(int[] nums){
    return max(nums,0,nums.length);
  }
  private int max(int[] nums, int l, int r){
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
