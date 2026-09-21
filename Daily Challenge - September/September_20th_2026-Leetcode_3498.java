// -- Leetcode 3498 -- 
// -- Reverse Degree of a String -- 

class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        for(int i=1;i<=s.length();i++){
            ans+=(26-(s.charAt(i-1)-'a'))*i;
        }
        return ans;
    }
}


/* 

Complexity Analysis :- 


    Time complexity: O(n). 
        We traverse the string once. 

    Space complexity: O(1).
        We are just using couple of variables.

*/
