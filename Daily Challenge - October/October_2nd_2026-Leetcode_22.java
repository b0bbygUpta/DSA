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


/*

Complexities 
    
    Time Complexiy:
        𝑂(𝐶𝑛⋅𝑛)
    
    Space Complexity:
        𝑂(𝐶𝑛⋅𝑛)(for result) + O(n)(for recursion)


*/ 

APPROACH II: 
  // Using Dynamic-Programming 
  
class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> ans=new ArrayList<>();
        ans.add(Arrays.asList(""));

        for(int i=1;i<=n;i++){
            List<String> curr=new ArrayList<>();
            for(int j=0;j<i;j++){
                for(String left: ans.get(j)){
                    for(String right: ans.get(i-1-j)){
                        curr.add('('+left+')'+right);
                    }
                }
            }
            ans.add(curr);
        }

        return ans.get(n);

    }
}


/* 

Complexities: 

    Time Complexity:
        O(Cn.n)

    Space Complexity:
        O(Cn.n) (for resulT+DP table)


*/ 
