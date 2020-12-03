//https://leetcode.com/problems/increasing-order-search-tree/
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
    TreeNode newHead;
    TreeNode prev;
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return newHead;
    }
    public void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        TreeNode newNode = new TreeNode(root.val);
        if(newHead == null) newHead = newNode;
        if(prev != null) prev.right = newNode;
        prev = newNode;
        helper(root.right);
    }
}