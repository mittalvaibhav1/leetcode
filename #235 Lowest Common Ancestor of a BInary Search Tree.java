//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        while(!qu.isEmpty()) {
            root = qu.poll();
            if(root.val >= p.val && root.val <= q.val) return root;
            if(root.val <= p.val && root.val >= q.val) return root;
            if(root.left != null) qu.add(root.left);
            if(root.right != null) qu.add(root.right);
        }
        return null;
    }
}