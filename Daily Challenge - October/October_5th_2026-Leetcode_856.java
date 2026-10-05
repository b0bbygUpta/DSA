// -- Leetcode 856 --
// -- Score of Parentheses -- 

// Using Stack 

class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        int ans=0;

        Stack<Integer> st=new Stack<>();
        st.push(0);
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
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
