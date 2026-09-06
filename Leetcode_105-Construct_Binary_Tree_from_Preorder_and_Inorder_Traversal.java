// -- Leetcode 105 -- 
// -- Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.java -- 

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
class Solution {
    int preIndex;
    Map<Integer,Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preIndex=0; 
        inorderMap=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }

        return arrayToTree(preorder,0,preorder.length-1);

    }
    private TreeNode arrayToTree(int[] preorder,int l, int r){
        //  l -> left ; r -> right
        if(l>r){
            return null;
        }
        int rootvalue=preorder[preIndex];
        preIndex++;
        // TreeNode node=new TreeNode(node);
        TreeNode node=new TreeNode(rootvalue);
        node.left=arrayToTree(preorder,l,inorderMap.get(rootvalue)-1);
        node.right=arrayToTree(preorder,inorderMap.get(rootvalue)+1,r);

        return node;
    }
}
