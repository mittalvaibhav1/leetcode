//https://leetcode.com/problems/longest-univalue-path/
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
    public int longestUnivaluePath(TreeNode root) {
        helper(root,1001);
        return ans;
    }
    public int helper(TreeNode root, int p) {
        if(root == null) return 0;
        int left = helper(root.left,root.val);
        int right = helper(root.right,root.val);
        ans = Math.max(ans, left + right);
        if(root.val == p)
            return 1 + Math.max(left,right);
        else
            return 0;
    }
}