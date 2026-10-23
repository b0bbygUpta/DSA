// -- Leetcode 3644 --
// -- Maximum K to Sort a Permutation -- 


APPROACH I:
  // Using Traverse and Compute the Bitwise AND
  
class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;

        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] == i){
                continue;
            }
            res &= nums[i];
        }

        return res == Integer.MAX_VALUE ? 0 : res;
        
    }
}
