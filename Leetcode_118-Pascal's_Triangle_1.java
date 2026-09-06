// -- Leetcode 118 -- 
// -- Pascal's Triangle -- 

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        
        for(int row=1;row<numRows;row++){
            List<Integer> res=new ArrayList<>();
            List<Integer> prev=ans.get(row-1);
            res.add(1);
            for(int j=1;j<row;j++){
                res.add(prev.get(j-1)+prev.get(j));
            }
            res.add(1);
            ans.add(res);
        }
        return ans;
    }
}
