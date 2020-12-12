//https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
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
    TreeNode res;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = getDepth(root);
        int nodes = getDepthNodes(root,depth,1);
        res = null;
        helper(root,depth,nodes,1);
        return res;
    }
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(getDepth(root.left),getDepth(root.right));
    }
    public int getDepthNodes(TreeNode root , int depth , int currDepth) {
        if(root == null) return 0;
        if(currDepth == depth) return 1;
        else return getDepthNodes(root.left,depth,currDepth + 1) + getDepthNodes(root.right,depth,currDepth + 1);
    }
    public int helper(TreeNode root,int depth,int nodes,int currDepth) {
        if(root == null) return 0;
        int left = helper(root.left,depth,nodes,currDepth + 1);
        int right = helper(root.right,depth,nodes,currDepth + 1);
        int ans = left + right;
        if(depth == currDepth) ans++;
        if(ans == nodes && res == null) res = root; 
        return ans;
    }
}