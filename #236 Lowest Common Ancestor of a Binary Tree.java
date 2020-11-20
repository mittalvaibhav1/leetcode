//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    }
    public boolean helper(TreeNode root , TreeNode p , TreeNode q) {
        if(root == null) return false;
        boolean left = helper(root.left,p,q);
        boolean right = helper(root.right,p,q);
        boolean curr = root.val == p.val || root.val == q.val;
        if(left && right || left && curr || right && curr) {
            ans = root;
        }
        return curr || left || right;
        
    }
}