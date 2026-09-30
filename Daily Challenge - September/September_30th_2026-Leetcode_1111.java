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

/*

Complexity Analysis
Let n be the length of the string.

Time complexity: O(n).

We only need to traverse the input string once.

Space complexity: O(1).

Apart from the answer array, we only need a constant number of variables.




*/

APPROACH II: 
  // Find the Pattern 


  class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int length = seq.length();
        int[] ans = new int[length];
        for (int i = 0; i < length; ++i) {
            ans[i] = (i & 1) ^ (seq.charAt(i) == '(' ? 1 : 0);
        }
        return ans;
    }
}

/*

Complexity Analysis
Let n be the length of the string.

Time complexity: O(n).

We only need to traverse the input string once.

Space complexity: O(1).

Apart from the answer array, we only need a constant number of variables.



*/

