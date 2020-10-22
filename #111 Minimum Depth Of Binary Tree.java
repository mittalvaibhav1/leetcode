//https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int level = 1;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()!=0) {
            int size = q.size();
            while(size-->0) {
                root = q.poll();
                if(root.left == null && root.right == null) return level;
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            }
            level++;
        }
        return 0;
    }
}