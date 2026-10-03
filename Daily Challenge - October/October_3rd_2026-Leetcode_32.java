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

APPROACH III:
  /*
    A valid parentheses substring must have equal numbers of ( and ).      
      While scanning:      
      If at any point one type of bracket outnumbers the other in a way that makes balance impossible, you reset the counters.      
      You update the maximum length whenever the counts are equal.
  */
class Solution {
    public int longestValidParentheses(String s) {
        int left=0, right=0, count=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                left++;
            }
            else{
                right++;
            }
            if(left == right){
                count=Math.max(count,right*2);
            }
            else if(right>left){
                left=0;
                right=0;
            }
        }
        
        left=0;
        right=0;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '('){
                left++;
            }
            else{
                right++;
            }
            if(left == right){
                count=Math.max(count,left*2);
            }
            else if(right<left){
                left=0;
                right=0;
            }
        }

        return count;
    }
}

/* 
Complexities: 

    Time Complexity: 
        O(n) -> for two linear iterations.

    Space Complexity: 
        O(1) -> only for counter.

*/
