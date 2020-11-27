//https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return ans;
    }
    public int helper(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        int left = helper(root.left);
        int right = helper(root.right);
        int max = Integer.MIN_VALUE;
        ans = Math.max(left,ans);
        ans = Math.max(right,ans);
        if(left == Integer.MIN_VALUE) left = 0;
        if(right == Integer.MIN_VALUE) right = 0;
        ans = Math.max(left + right + root.val,ans);
        max = Math.max(left + root.val,max);
        max = Math.max(right + root.val,max);
        max = Math.max(root.val,max);
        ans = Math.max(ans,max);
        return max;
    }
}