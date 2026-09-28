// -- Leetcode 1614 --
// -- Maximum Nested Depth of the Parentheses -- 

class Solution {
    public int maxDepth(String s) {
      Stack<Character> st=new Stack<>();
      int count=0;
      int max=0;

      for(char c: s.toCharArray()){
        if(c == '('){
            count++;
            max=Math.max(count,max);
        }
        if(c == ')'){
            count--;
        }
      }

      return max;


    }
}
