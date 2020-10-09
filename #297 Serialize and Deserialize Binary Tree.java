//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
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
        StringBuilder res = new StringBuilder();
        preOrder(root,res);
        return res.toString().trim();
        
    }
    public void preOrder(TreeNode root, StringBuilder res) {
        if(root == null) {
            res.append(",");
            return;
        }
        res.append(root.val).append(",");
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for(String token : tokens) {
            nodes.add(token);
        }
        TreeNode root = createTree(nodes);
        return root;
    }
    public TreeNode createTree(LinkedList<String> nodes) {
        if(nodes.isEmpty())
            return null;
        String val = nodes.poll();
        if(val.equals(""))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = createTree(nodes);
        root.right = createTree(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));