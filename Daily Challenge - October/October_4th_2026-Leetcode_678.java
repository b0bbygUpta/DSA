// -- Leetcode 678 -- 
// -- Valid Parentheses String --


APPROACH I: 
  // Using Greedy approach for faster and better results
  
class Solution {
    public boolean checkValidString(String s) {
        int low=0, high=0;

        for(char c: s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }
            else if(c == ')'){
                if(low>0) low--;
                high--;
            }
            else{
                if(low>0) low--;
                high++;
            }

            if(high<0) return false;


        }

        return low == 0;
    }
}


APPROACH II:
  // Using Greedy Algorithum 

class Solution {
    public boolean checkValidString(String s) {
        int low=0, high=0;

        for(char c: s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }
            else if(c == ')'){
                low--;
                high--;
            }
            else{
                low--;
                high++;
            }
            if(high<0) return false;
            low=Math.max(low,0);
        }
        return low == 0;
    }
}
