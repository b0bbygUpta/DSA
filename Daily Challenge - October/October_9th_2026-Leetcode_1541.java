// -- Leetcode 1541 -- 
// -- Minimum Insertions to Balance a Parentheses String -- 

APPROACH I:
  // Using Greedy approach 
  
class Solution {
    public int minInsertions(String s) {
        int insert=0;
        int leftcount=0;
        int len=s.length();
        int idx=0;
        while(idx<len){
            char c=s.charAt(idx);
            if(c == '('){
                leftcount++;
                idx++;
            }
            else{
                if(leftcount>0){
                    leftcount--;
                }else{
                    insert++;
                }
                if(idx<len-1 && s.charAt(idx+1) == ')'){
                    idx+=2;
                }else{
                    insert++;
                    idx++;
                }
            }
        }
        insert+=leftcount*2;
        return insert;
    }
}


/* 
Complexities: 
    Time compleity: 
        O(n)
    Space complexity: 
        O(1)
*/ 


APPROACH II: 
  // Using Stack for this implementation
  
class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int insertions = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push('(');
                i++;
            } else { // c == ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // Found "))"
                    if (!st.isEmpty()) {
                        st.pop(); // match with '('
                    } else {
                        insertions++; // need to insert '('
                    }
                    i += 2; // consume both ')'
                } else {
                    // Single ')'
                    if (!st.isEmpty()) {
                        st.pop(); // match with '('
                        insertions++; // need one more ')'
                    } else {
                        insertions += 2; // need '(' + extra ')'
                    }
                    i++;
                }
            }
        }

        // Any remaining '(' need two ')'
        insertions += st.size() * 2;
        return insertions;
    }
}
