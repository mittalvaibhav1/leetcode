//https://leetcode.com/problems/add-one-row-to-tree/
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        helper(root,v,d-1,1);
        return root;
    }
    public void helper(TreeNode root , int v , int d, int currDepth) {
        if(root == null || currDepth > d) return;
        if(currDepth == d) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            return;
        }
        helper(root.left,v,d,currDepth+1);
        helper(root.right,v,d,currDepth+1);
    }
}