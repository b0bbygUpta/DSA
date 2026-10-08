// -- Leetcode 1021 -- 
// -- Remove Outermost Parentheses -- 

APPROACH I: 
  // Using Stack 
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(char c: s.toCharArray()){
            if(c == '('){
                if(!st.isEmpty()){
                    // st.push(c);
                    sb.append(c);
                }
                // sb.append(c);
                st.push(c);
            }else{
                st.pop();
                // sb.append(c);
                if(!st.isEmpty()){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
