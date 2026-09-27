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
   T         sb.setCharAt(s++, sb.charAt(e));
            sb.setCharAt(e--, temp);
        }
    }
}

/*

COMPLEXITY 

TIME COMPLEXITY: O(n^2)

SPACE COMPLEXITY: O(n)


*/


APPROACH II :
  // Using Wormhole Teleportation Technique 
  
class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<Integer> open=new Stack<>();
        int[] pair=new int[n];

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                open.push(i);
            }
            if(s.charAt(i) == ')'){
                int j=open.pop();
                pair[i]=j;
                pair[j]=i;
            }
        }
        StringBuilder res=new StringBuilder();

        for(int curr=0, dir=1; curr<n; curr+=dir){
            if(s.charAt(curr) == '(' || s.charAt(curr) == ')'){
                curr=pair[curr];
                dir=-dir;
            }
            else{
                res.append(s.charAt(curr));
            }
        }

        return res.toString();
    }
}


