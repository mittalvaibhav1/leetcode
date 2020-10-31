//https://leetcode.com/problems/validate-binary-search-tree/submissions/
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
    TreeNode prev = null;
    Boolean res = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return res;
    }
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && prev.val >= root.val) {
            res = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
    
}