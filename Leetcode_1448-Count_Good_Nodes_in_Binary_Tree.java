// -- Leetcode 1448 --
// --  Leetcode_1448-Count_Good_Nodes_in_Binary_Tree.java --

// ******************************** JAVA SOLUTION **********************************

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


//  APPROACH I:

class Solution{
  public int goodNodes(TreeNode root){
    return countNode(root, Integer.MIN_VALUE);
  }
  private int countNode(TreeNode node, int max){
    if(node == null) return 0;
    int count=0;
    if(node.val >= max){
      count=1;
      max=node.val;
    }
    count+=countNode(node.left, max);
    count+=countNode(node.right, max);

    return count;
  }
}


//  APPROACH II: 
class Solution{
  public int goodNodes(TreeNode root){
    return goodNodesHelper(root,new ArrayList<>());
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
