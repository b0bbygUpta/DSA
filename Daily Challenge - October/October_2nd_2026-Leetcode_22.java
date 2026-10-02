// -- Leetcode 22 -- 
// -- Generate Parentheses -- 

APPROACH I: 
  // Using backtracking in a helper function 
  
class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans=new ArrayList();
        backtrack(ans,new StringBuilder(),0,0,n);

        return ans;
    }

    private void backtrack(List<String> ans,  StringBuilder curr, int open, int close, int max){
        if(curr.length() == max*2){
            ans.add(curr.toString());
            return ;
        }

        if(open<max){
            curr.append('(');
            backtrack(ans,curr,open+1,close,max);
            curr.deleteCharAt(curr.length()-1);

        }

        if(close<open){
            curr.append(')');
            backtrack(ans,curr,open,close+1,max);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
