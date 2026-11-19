// -- Leetcode 2567 -- 
// -- Minimum Score by Changing Two Elements -- 

APPROACH I: 
  // Using Sorting + Greedy

class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return Math.min(
            Math.min(nums[n-3]-nums[0],nums[n-2]-nums[1]),
            nums[n-1]-nums[2]
        );
    }
}

/*
Complexity: 
    Time complexity
        O(nlogn)
    Space complexity
        O(log n)
*/
