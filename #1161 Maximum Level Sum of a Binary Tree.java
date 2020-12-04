//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
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
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int ans = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            level++;
            sum =  0;
            int size = q.size();
            while(size-- > 0) {
                root = q.poll();
                sum += root.val;
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            }
            if(sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
        }
        return ans;
    }
}