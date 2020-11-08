//https://leetcode.com/problems/binary-tree-pruning/
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
    public TreeNode pruneTree(TreeNode root) {
      return helper(root) ? root : null; 
    }
    public boolean helper(TreeNode root) {
        if(root == null) return false;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(!left) root.left = null;
        if(!right) root.right = null;
        return root.val == 1 || left || right;
    }
}