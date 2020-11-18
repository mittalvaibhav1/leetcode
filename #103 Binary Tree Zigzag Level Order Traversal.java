//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            while(size-- > 0) {
                root = q.poll();
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
                if(level % 2 == 0) {
                    tmp.addLast(root.val);
                }
                else {
                    tmp.addFirst(root.val);
                }
            }
            res.add(tmp);
            level++;
        }
        return res;
    }
}