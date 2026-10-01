// -- Leetcode 20 -- 
// -- Valid Parentheses -- 

APPROACH I: 
  // Using globally decleared HashMap and Stack to check validity the Parentheses 
  
class Solution {
    private static final HashMap<Character,Character> map=new HashMap<>();
    static{
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
    }
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(!map.containsKey(c)){
                st.push(c);
            }
            else{
                if(st.isEmpty() || map.get(c) != st.pop()){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
