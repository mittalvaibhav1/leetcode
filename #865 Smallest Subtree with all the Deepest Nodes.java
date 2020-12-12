//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int depth = getDepth(root);
        int nodesAtDepth = getNodesAtDepth(root,depth,1);
        helper(root,nodesAtDepth,depth,1);
        return res;
    }
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(getDepth(root.left),getDepth(root.right)); 
    }
    public int getNodesAtDepth(TreeNode root, int depth, int currentDepth) {
        if(root == null) return 0;
        if(currentDepth == depth)  return 1;
        else return getNodesAtDepth(root.left,depth,currentDepth+1) + getNodesAtDepth(root.right,depth,currentDepth+1);
    }
    public int helper(TreeNode root , int nodes , int depth , int currDepth) {
        if(root == null) return 0;
        int left = helper(root.left,nodes,depth,currDepth + 1);
        int right = helper(root.right,nodes,depth,currDepth + 1);
        int ans = left + right;
        if(depth == currDepth) ans++;
        if(ans == nodes && this.res == null) this.res = root;
        return ans;
    }
}