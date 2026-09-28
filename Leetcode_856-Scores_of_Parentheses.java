// -- Leetcode 856 -- 
// Scores of Parentheses -- 

APPROACH I :
  // Using Stack and Math.max(2*st.pop(),1) as per observation 
  
class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        st.push(0);

        for(char c: s.toCharArray()){
            if(c == '('){
                st.push(0);
            }
            else{
                int val=Math.max(2*st.pop(), 1);
                st.push(st.pop()+val);
            }
        }
        
        return st.pop();


    }
}
