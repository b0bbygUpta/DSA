// -- Leetcode 2265 -- 
// -- Count Nodes Equal to Average of Subtree -- 

APPROCAH I: 
  
// Using alot of helper function to solve this particular problem like sum(), child(), avg() and dfs();
// This approach is really very time taking #brute_force approcah

  
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
    int count;

    public int averageOfSubtree(TreeNode root) {
                      
        count=0;

        // if(avg(root)){
        //     count+=1;
        // }
        dfs(root);
        return count;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        if(avg(root)){
            count++;
        }
        dfs(root.left);
        dfs(root.right);

    }

    public boolean avg(TreeNode root){
        
        int s=sum(root);
        int c=child(root);
        int mean=s/c;
        // if(mean == root.val){
        //     return true;
        // }
        return mean == root.val;
    }
    public int child(TreeNode root){
        int childcount=1;

        if(root == null) return 0;

        // childcount+=child(root.left);
        // childcount+=child(root.right);

        return childcount+child(root.left)+child(root.right);

    }
    public int sum(TreeNode root){
        // int sum=0;
        if(root == null) return 0;
        // sum+=Integer.valueOf(root.val);
        // sum+=sum(root.left,sum);
        // sum+=sum(root.right,sum);
        // return sum;

        return root.val+sum(root.left)+sum(root.right);

    }
}


APPROACH II: 
// Using class Pair to store child-count and sum-of-subtree
// Really good approach while keeping time-taken and storage used in mind
  
class Solution {
    class pair{
        int sum,c; 
        pair(int sum, int c){
            this.sum=sum;
            this.c=c;
        }
    }
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return count;
    }
    
    pair dfs(TreeNode root){
        if(root == null) return new pair(0,0);
        pair p1=dfs(root.left);
        pair p2=dfs(root.right);
        int sum=p1.sum+p2.sum+root.val;
        int c=p1.c+p2.c+1;
        if(sum/c == root.val) count++;
        return new pair(sum,c);
    }
}
