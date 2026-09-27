// -- Leetcode 1190 -- 
// -- Reverse Substrings Between Each Pair of Paranthesis -- 

APPROACH I :
  // Using Straightforword approach 
  
class Solution {
    public String reverseParentheses(String s) {
        StringBuilder res=new StringBuilder();
        Stack<Integer> open=new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '('){
                open.push(res.length());
            }
            else if(c == ')'){
                int start=open.pop();
                reverse(res, start, res.length()-1);
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }


    private void reverse(StringBuilder sb, int s, int e){
        while(s<e){
            char temp=sb.charAt(s);
            sb.setCharAt(s++, sb.charAt(e));
            sb.setCharAt(e--, temp);
        }
    }
}

/*

COMPLEXITY 

TIME COMPLEXITY: O(n^2)

SPACE COMPLEXITY: O(n)


*/



