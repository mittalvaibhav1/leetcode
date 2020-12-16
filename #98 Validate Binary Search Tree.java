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
//M2
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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    public boolean helper(TreeNode root) {
        if(root == null) return true;
        boolean left = helper(root.left);
        if(prev!= null && root.val <= prev) return false;
        prev = root.val;
        return left && helper(root.right);
    }
}