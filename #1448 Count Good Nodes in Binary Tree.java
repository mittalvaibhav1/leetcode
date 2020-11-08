//https://leetcode.com/problems/count-good-nodes-in-binary-tree
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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        helper(root,root.val);
        return ans;
    }
    public void helper(TreeNode root , int max) {
        if(root == null) return;
        if(max <= root.val) ans++;
        max = Math.max(max,root.val);
        helper(root.left,max);
        helper(root.right,max);
        return;
    }
}