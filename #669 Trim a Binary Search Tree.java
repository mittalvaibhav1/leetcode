//https://leetcode.com/problems/trim-a-binary-search-tree/
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helper(root, low , high);
    }
    public TreeNode helper(TreeNode root ,int low , int high) {
        if(root == null) return null;
        if(root.val < low) {
            return helper(root.right , low , high);
        }
        else if(root.val > high) {
            return helper(root.left , low , high);
        }
        else {
            root.left = helper(root.left , low , high);
            root.right = helper(root.right , low , high);
            return root;
        }
    }
}