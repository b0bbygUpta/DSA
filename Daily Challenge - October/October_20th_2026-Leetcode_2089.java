// -- Leetcode 2089 -- 
// -- Find Target Indices After Sorting Array -- 


APPROACH I:
  // Using Implementation of QuickSort 
  
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        int small=0, cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]<target){
                small++;
            }
            if(nums[i] == target){
                cnt++;
            }
        }
        if(cnt == 0){
            return list;
        }
        for(int i=1;i<=cnt;i++){
            list.add(small++);
        }
        return list;
        
    }
}
