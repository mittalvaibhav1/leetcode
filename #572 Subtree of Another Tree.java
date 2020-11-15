//https://leetcode.com/problems/subtree-of-another-tree/
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean traverse(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(checkSubTree(s,t)) return true;
        return traverse(s.left,t) || traverse(s.right,t);
        
    }
    public boolean checkSubTree(TreeNode s , TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return checkSubTree(s.left,t.left) && checkSubTree(s.right,t.right);
    }
}