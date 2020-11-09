//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
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
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        helper(root,root.val,root.val);
        return ans;
    }
    public void helper(TreeNode root, int max , int min) {
        if(root == null) return;
        ans = Math.max(ans,Math.abs(max - root.val));
        ans = Math.max(ans,Math.abs(min - root.val));
        max = Math.max(root.val,max);
        min = Math.min(root.val,min);
        helper(root.left,max,min);
        helper(root.right,max,min);
        return;
    }
}