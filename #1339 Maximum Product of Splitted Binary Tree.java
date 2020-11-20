//https://leetcode.com/problems/maximum-product-of-splitted-binary-tree
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
    int sum;
    long product;
    public int maxProduct(TreeNode root) {
        sum = 0;
        product = 0;
        sum(root);
        helper(root);
        return (int)(product % ((int)Math.pow(10, 9) + 7));
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        product = Math.max(product , (root.val + left + right)* 1L * (sum - root.val - left - right));
        return root.val + left + right;
    }
    public void sum(TreeNode root) {
        if(root == null) return;
        sum += root.val;
        sum(root.left);
        sum(root.right);
    }
}