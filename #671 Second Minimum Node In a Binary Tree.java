//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
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
    int min = -1;
    int secondMin = -1;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return secondMin;
    }
    public void helper(TreeNode root) {
        if(root == null) return;
        min = min == -1 ? root.val : Math.min(root.val,min);
        if(root.val > min) {
            secondMin = secondMin == -1 ? root.val : Math.min(root.val,secondMin);
        }
        helper(root.left);
        helper(root.right);
    }
}