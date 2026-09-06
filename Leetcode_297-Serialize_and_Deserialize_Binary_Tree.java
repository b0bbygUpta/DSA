// -- Leetcode 297 --
// -- Serialize_and_Deserialize_Binary_Tree.java -- 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String recser(TreeNode root, String str){
        if(root == null){
            str+="null,";
        }
        else{
            str+=str.valueOf((root.val)+",");
            str=recser(root.left,str);
            str=recser(root.right,str);
        }
        return str;
    }
    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recser(root,"");
    }
    private TreeNode recdes(List<String> str){
        if(str.get(0).equals("null")){
            str.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(str.get(0)));
        str.remove(0);
        root.left=recdes(str);
        root.right=recdes(str);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray=data.split(",");
        List<String> strList=new LinkedList<String>(Arrays.asList(strArray));
        return recdes(strList);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

