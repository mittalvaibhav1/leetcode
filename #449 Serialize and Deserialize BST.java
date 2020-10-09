//https://leetcode.com/problems/serialize-and-deserialize-bst/
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { 
        if(root == null)
            return " ";
        StringBuilder res = new StringBuilder();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()!=0) {
            root = q.pop();
            res.append(root.val).append(" ");
            if(root.left!=null) {
                q.add(root.left);
            }
            if(root.right!=null) {
                q.add(root.right);
            }
        }
        return res.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         String[] tokens = data.split(" ");
         TreeNode root = null;
         for(String token : tokens) {
             root = insertBST(root,Integer.parseInt(token));
         }
         return root;
    }
    public TreeNode insertBST(TreeNode root , int val){
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val > val) {
            root.left = insertBST(root.left,val);
        }
        else {
            root.right = insertBST(root.right,val);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;