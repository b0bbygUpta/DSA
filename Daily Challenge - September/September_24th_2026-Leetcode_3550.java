// -- Leetcode 3550 -- 
// -- Smallest Index With Digit Sum Equal to Index -- 

APPROACH I: 
  
class Solution {
    public int smallestIndex(int[] nums) {
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            int a=findSum(nums[i]);
            if(a == i){
                ans=i;
                break;
            }
        }
        return ans;
    }

    private int findSum(int ele){
        int t=ele;
        int sum=0;
        while(t>0){
            sum+=t%10;
            t/=10;
        }
        return sum;
    }
}


APPROACH II: 
  
class Solution {
    public int smallestIndex(int[] nums) {
        // int ans=-1;
        for(int i=0;i<nums.length;i++){
            int a=findSum(nums[i]);
            if(a == i){
                // ans=i;
                // break;
                return i;
            }
        }
        return -1; // ans;
    }

    private int findSum(int ele){
        int t=ele;
        int sum=0;
        while(t>0){
            sum+=t%10;
            t/=10;
        }
        return sum;
    }
}

APPROACH III: 
  
class Solution {
    public int smallestIndex(int[] nums) {
        // int ans=-1;
        for(int i=0;i<nums.length;i++){
            int t=nums[i]; // ele;
            int sum=0;
            while(t>0){
                sum+=t%10;
                t/=10;
            }
            int a=sum; // findSum(nums[i]);
            if(a == i){
                // ans=i;
                // break;
                return i;
            }
        }
        return -1; // ans;
    }

    // private int findSum(int ele){
    //     int t=ele;
    //     int sum=0;
    //     while(t>0){
    //         sum+=t%10;
    //         t/=10;
    //     }
    //     return sum;
    // }
}


APPROACH IV: 
  
class Solution {
    public int smallestIndex(int[] nums) {
        // int ans=-1;
        for(int i=0;i<nums.length;i++){
            int t=nums[i]; // ele;
            int sum=0;
            while(t>0){
                sum+=t%10;
                t/=10;
            }
            // int a=sum; // findSum(nums[i]);
            if(sum == i){
                // ans=i;
                // break;
                return i;
            }
        }
        return -1; // ans;
    }

    // private int findSum(int ele){
    //     int t=ele;
    //     int sum=0;
    //     while(t>0){
    //         sum+=t%10;
    //         t/=10;
    //     }
    //     return sum;
    // }
}
