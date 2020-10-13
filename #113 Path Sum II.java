//https://leetcode.com/problems/path-sum-ii/
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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        helper(root,sum,tmp,0);
        return res;
    }
    public void helper(TreeNode root , int sum , ArrayList<Integer> tmp , int i) {
        if(root == null) {
            return;
        }
        if(root.val == sum && root.left==null && root.right == null) {
            tmp.add(i,sum);
            res.add(new ArrayList(tmp.subList(0,i+1)));
            return;
        }
        tmp.add(i,root.val);
        helper(root.left,sum - root.val, tmp , i+1);
        helper(root.right,sum - root.val, tmp , i+1);
    }
}