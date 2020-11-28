//https://leetcode.com/problems/maximum-width-of-binary-tree/
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
    class Pair {
        TreeNode node;
        int idx;
        public Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        Pair node = new Pair(root , 0);
        q.add(node);
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while(size -- > 0) {
                node = q.pop();
                min = Math.min(min, node.idx);
                max = Math.max(max, node.idx);
                if(node.node.left !=  null) q.add(new Pair(node.node.left, node.idx * 2 + 1));
                if(node.node.right != null) q.add(new Pair(node.node.right, node.idx * 2 + 2));
            }
            ans = Math.max(max - min + 1 , ans);
        }
        return ans;
    }
}