// -- Leetcode 1448 --
// --  Leetcode_1448-Count_Good_Nodes_in_Binary_Tree.java --

// ******************************** JAVA SOLUTION **********************************


//  APPROACH I: 
class Solution{
  public int goodNodes(TreeNode root){
    return goofNodesHelper(root,new ArrayList<>());
  }
  private int goodNodesHelper(TreeNode node, List<Integer> maxStack){
    if(maxStack.size() == 0){
      maxStack.add(current.val);
    }else{
      maxStack.add(Math.max(current.val,maxStack.get(maxStack()-1));
    }
    final int leftGoodNodes = (current.left == null) ? 0 : goodNodesHelper(current.left, maxStack);
    final int rightGoodNodes = (current.right == null) ? 0 : goodNodesHelper(current.right, maxStack);

    final int latestMax = maxStack.removeLast();

    return ((latestMax <= current.val) ? 1 : 0) + leftGoodNodes + rightGoodNodes;
    }
}
