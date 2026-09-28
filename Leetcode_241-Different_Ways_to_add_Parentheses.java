// -- Leetcode 241 -- 
// -- Different Ways to add Parentheses -- 

class Solution {

    Map<String, List<Integer>> map=new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {

        int n=expression.length();

        if(map.containsKey(expression)){
            return map.get(expression);
        }    

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            char c=expression.charAt(i);
            if(c == '*' || c == '+' || c == '-'){
                List<Integer>left=diffWaysToCompute(expression.substring(0,i));
                List<Integer>right=diffWaysToCompute(expression.substring(i+1));

                for(int l: left){
                    for(int r: right){
                        if(c == '*'){
                            res.add(l*r);
                        }
                        else if(c == '+'){
                            res.add(l+r);
                        }
                        else if(c == '-'){
                            res.add(l-r);
                        }
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        map.put(expression,res);

        return res;


    }
}
