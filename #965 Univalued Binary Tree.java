//https://leetcode.com/problems/univalued-binary-tree/
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
    int uniVal;
    public boolean isUnivalTree(TreeNode root) {
        uniVal = root.val;
        return helper(root);
    }
    public boolean helper(TreeNode root) {
        if(root ==  null) return true;
        if(root.val != uniVal) return false;
        return helper(root.left) && helper(root.right);
    }
}