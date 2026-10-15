// -- Leetcode 2913 -- 
// -- Subarrays Distinct Element Sum of Sqares I -- 


APPROACH I: 
  // Using Simulation + Array(boolean)
  
class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;

        for(int i=0;i<n;i++){
            int count=0;
            boolean[] seen=new boolean[101];
            for(int j=i;j<n;j++){
                if(!seen[nums.get(j)]){
                    seen[nums.get(j)]=true;
                    count++;
                }
                ans+=count*count;
            }
        }
        return ans;
    }
}

/* 
Complexities 

    Time complexity 
        O(n^2) 
    Space complexity
        O(1) 
*/ 


APPROACH II:
  // Using Simulation + HashSet 

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;

        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                ans+=set.size()*set.size();
            }
          
        }
        return ans;
 
    }
}
