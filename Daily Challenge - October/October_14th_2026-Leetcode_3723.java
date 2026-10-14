// -- Leetcode 3723 -- 
// -- Maximize Sum of Squares of Digits -- 

APPROACH I: 
  // Using Greedy apprach 

class Solution {
    public String maxSumOfSquares(int num, int sum) {
      if(sum > 9*num){
        return "";
      }  
      int rem=sum%9;
      StringBuilder ans=new StringBuilder();
      int nines=sum/9;
      for(int i=0;i<nines;i++){
        ans.append('9');
      }
      if(rem>0){
        ans.append((char)('0'+rem));
      }
      int zeros=num-ans.length();
      for(int i=0;i<zeros;i++){
        ans.append('0');
      }
      return ans.toString();
    }
}

/* 
Complexities: 

   Let 'n' be the required number of digits.

   Time Complexity:
       O(n) --> We need to construct an answer string of length 'n'

   Space Complexity: 
       O(1) --> We use only a constant number of variables, excluding the space for the return value.
       
*/
