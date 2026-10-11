// -- Leetcode 2778 -- 
// -- Sum of Squares of Special Elements -- 

APPROACH I: 
  // Using Iterative approach 
  
class Solution {
    public int sumOfSquares(int[] nums) {
       int n=nums.length;
       int ans=0;

        for(int i=0;i<n;i++){
            if(n%(i+1) == 0){
                ans+=(int)nums[i]*nums[i];
            }
        }

    return ans;

    }
}
