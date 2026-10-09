// -- Leetcode 1541 -- 
// -- Minimum Insertions to Balance a Parentheses String -- 

APPROACH I:
  // Using Greedy approach 
  
class Solution {
    public int minInsertions(String s) {
        int insert=0;
        int leftcount=0;
        int len=s.length();
        int idx=0;
        while(idx<len){
            char c=s.charAt(idx);
            if(c == '('){
                leftcount++;
                idx++;
            }
            else{
                if(leftcount>0){
                    leftcount--;
                }else{
                    insert++;
                }
                if(idx<len-1 && s.charAt(idx+1) == ')'){
                    idx+=2;
                }else{
                    insert++;
                    idx++;
                }
            }
        }
        insert+=leftcount*2;
        return insert;
    }
}


/* 
Complexities: 
    Time compleity: 
        O(n)
    Space complexity: 
        O(1)
*/ 
