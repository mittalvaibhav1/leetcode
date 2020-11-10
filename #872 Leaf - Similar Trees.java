//https://leetcode.com/problems/leaf-similar-trees/
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaves1 = new ArrayList<>();
        ArrayList<Integer> leaves2 = new ArrayList<>();
        helper(root1,leaves1);
        helper(root2,leaves2);
        return leaves1.equals(leaves2);
        
    }
    public void helper(TreeNode root, ArrayList<Integer> leaves) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        helper(root.left,leaves);
        helper(root.right,leaves);
        return;
    }
}