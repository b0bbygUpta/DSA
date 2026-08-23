----- Leetcode 6 -----
-- Zigzag Conversion --

********************** JAVA Solution *********************************

class Solution {
    public String convert(String s, int numRows) {
        int n=numRows;
        if(n == 1 || s.length()<=n){
            return s;
        }
        StringBuilder[] rows=new StringBuilder[n];
        for(int i=0;i<n;i++){
            rows[i]=new StringBuilder();
        }
        int curr=0;
        boolean down=false;
        for(char c: s.toCharArray()){
            rows[curr].append(c);

            if(curr == 0 || curr == n-1){
                down = !down;
            }

            curr+=down?1:-1;

        }   
        StringBuilder res=new StringBuilder();
        for(StringBuilder i: rows){
            res.append(i);
        }             
        return res.toString();
    }
}
