// -- Leetcode 235 -- 
// -- Lowest_Common_Ancestor_of_a_Binary_Search_Tree.java --


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal=root.val;
        int pVal=p.val;
        int qVal=q.val;

        if(pVal>rootVal && qVal>rootVal){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(pVal<rootVal && qVal<rootVal){
            return lowestCommonAncestor(root.left,p,q);
        }
        else{
            return root;
        }
    
    // return root;     // better here
    
    }
}
