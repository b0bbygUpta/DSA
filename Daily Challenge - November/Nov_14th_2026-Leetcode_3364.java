// -- Leetcode 3364 -- 
// -- Minimum Positive Sum Subarray 

APPROACH I:
  // Using fixed size Sliding Window
  
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int ans=Integer.MAX_VALUE;

        for(int len=l;len<=r;len++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=nums.get(i);
                if(i>=len) sum-=nums.get(i-len);
                if(i>=len-1 && sum>0 && sum<ans) ans=sum;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}

/* 
Complexity
      Time complexity:
          O(1)
      Space complexity: 
          O(1)
*/


APPROACH II:
  // Using Brute Force 

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int min=Integer.MAX_VALUE;

        for(int len=l;len<=r;len++){
            for(int i=0;i+len<=n;i++){
                int sum=0;
                for(int k=i;k<i+len;k++){
                    sum+=nums.get(k);
                }
                if(sum>0 && sum<min) min=sum;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;

    }
}

/*
Complexity
    Time complexity: 
        O(len)
    Space complexity: 
        O(1)
*/
