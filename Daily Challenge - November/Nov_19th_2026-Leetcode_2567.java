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

APPROACH II: 
  // Using One Pass and storing the max vlaues (as mx1, mx2 and mx3) & min values (as mn1, mn2 and mn3)
  
class Solution {
    public int minimizeSum(int[] nums) {
        int mn1=Integer.MAX_VALUE, 
            mn2=Integer.MAX_VALUE, 
            mn3=Integer.MAX_VALUE;
        int mx1=Integer.MIN_VALUE, 
            mx2=Integer.MIN_VALUE, 
            mx3=Integer.MIN_VALUE;  

        for(int x: nums){
            if(x>mx1){
                mx3=mx2;
                mx2=mx1;
                mx1=x;
            }
            else if(x>mx2){
                mx3=mx2;
                mx2=x;
            }
            else if(x>mx3){
                mx3=x;
            }

            if(x<mn1){
                mn3=mn2;
                mn2=mn1;
                mn1=x;
            }else if(x<mn2){
                mn3=mn2;
                mn2=x;
            }else if(x<mn3){
                mn3=x;
            }
        }

        return Math.min(mx1-mn3,Math.min(mx2-mn2,mx3-mn1));
            
    }
}
