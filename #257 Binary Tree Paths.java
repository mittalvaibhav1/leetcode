//https://leetcode.com/problems/binary-tree-paths
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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new LinkedList<>();
        if(root == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return res;
    }
    public void helper(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        int start = sb.length();
        if(sb.length() == 0) sb.append(root.val);
        else sb.append("->").append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        helper(root.left,sb);
        helper(root.right,sb);
        sb.setLength(start);
        return;
    }
}