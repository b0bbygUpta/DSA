// -- Leetcode 1111 -- 
// -- Maximum Nesting Depth of Two Valid Parentheses -- 

APPROACH I: 
  // Using bit-manuplation to fill up int[] arr array with appropriate values 
  
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[] arr=new int[n];
        int open=0;

        for(int i=0;i<n;i++){
            if(seq.charAt(i) == '('){
                arr[i]=open&1;
                open++;
            }
            else{
                open--;
                arr[i]=open&1;
            }
        }
        return arr;
    }
}
