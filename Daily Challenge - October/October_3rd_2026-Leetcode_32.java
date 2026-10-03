// -- Leetcode 32 -- 
// -- Longest Valid Parentheses --

APPROACH I:
  // Using Stack basic methods like push() and pop()
  
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int count=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    count = Math.max(count, i-st.peek());
                }
            }
        }

        return count;
    }
}

/* 

Complexities 

  Time Complexity: 
      O(n) -> as only one iteration

  Space Complexity:
      O(n) 

*/

APPROACH II:
  // Using Array to find longest valid parentheses

class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int[] stackArray=new int[n+1];
        int top=-1;

        stackArray[++top]=-1;
        int count=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                stackArray[++top]=i;
            }
            else{
                top--;
                if(top == -1){
                    stackArray[++top]=i;
                }
                else{
                    count=Math.max(count, i-stackArray[top]);
                }
            }
        }
        return count;
    }
}


/* 

Complexities

  Time complexty:
      O(n) 

  Space complexity: 
      O(n) 

*/
