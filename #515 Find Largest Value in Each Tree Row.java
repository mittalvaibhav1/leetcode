//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while(size-- > 0) {
                root = q.poll();
                max = Math.max(root.val,max);
                if(root.left != null) q.add(root.left);
                if(root.right !=null) q.add(root.right);
            }
            res.add(max);
        } 
        return res;
    }
}