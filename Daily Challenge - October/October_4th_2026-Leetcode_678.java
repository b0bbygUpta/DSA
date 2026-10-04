// -- Leetcode 678 -- 
// -- Valid Parentheses String --


APPROACH I: 
  // Using Greedy approach for faster and better results
  
class Solution {
    public boolean checkValidString(String s) {
        int low=0, high=0;

        for(char c: s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }
            else if(c == ')'){
                if(low>0) low--;
                high--;
            }
            else{
                if(low>0) low--;
                high++;
            }

            if(high<0) return false;


        }

        return low == 0;
    }
}


APPROACH II:
  // Using Greedy Algorithum 

class Solution {
    public boolean checkValidString(String s) {
        int low=0, high=0;

        for(char c: s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }
            else if(c == ')'){
                low--;
                high--;
            }
            else{
                low--;
                high++;
            }
            if(high<0) return false;
            low=Math.max(low,0);
        }
        return low == 0;
    }
}


Complexities 
  Time Complexity: 
      O(n) 
  Space Comoplexity: 
      O(1) -> because only variables are getting stored
  
APPROACH III:
  // Using 2D Dynamic Programming 

class Solution {
    public boolean checkValidString(String s) {
        int l=s.length();

        boolean[][] dp=new boolean[l+1][l+1];
        dp[0][0]=true;

        for(int i=0;i<l;i++){
            for(int j=0;j<=l;j++){
                if(!dp[i][j]){
                    continue;
                }
                if(s.charAt(i) == '('){
                    dp[i+1][j+1]=true;
                }
                else if(s.charAt(i) == ')'){
                    // dp[i+1][j+1]=true;
                    if(j>0){
                        dp[i+1][j-1]=true;
                    }
                }
                else{
                    dp[i+1][j]=true;
                    dp[i+1][j+1]=true;
                    if(j>0){
                        dp[i+1][j-1]=true;
                    }
                }
            }
        }
        return dp[l][0];
    }
}
