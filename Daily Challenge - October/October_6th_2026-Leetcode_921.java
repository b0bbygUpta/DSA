// -- Leetcode 921 -- 
// -- Minimum Add to Make Parentheses valid -- 

APPROACH I: 
  // Using counter as count and required & return count+required 
  
class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int open=0;
        int req=0;

        for(char c: s.toCharArray()){
            if(c == '('){
                open++;
            }
            else{
                if(open>0){
                    open--;
                }else{
                    req++;
                }
            }
        }
        return req+open;

    }
}


/* 
Complexities

    Time complexity: 
        O(n)
    Space complexity: 
        O(1)
*/
