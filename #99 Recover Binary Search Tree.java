//https://leetcode.com/problems/recover-binary-search-tree/
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
// M1
class Solution {
    ArrayList<TreeNode> res;
    TreeNode t1 = null;
    TreeNode t2 = null;
    public void recoverTree(TreeNode root) {
        res = new ArrayList<>();
        inorder(root);
        for(int i = 0 ; i < res.size() ; i++) {
            if((i > 0 && res.get(i-1).val > res.get(i).val )||((i < res.size() - 1) && res.get(i+1).val < res.get(i).val)) {
                if(t1 == null) {
                    t1 = res.get(i);
                }
                else {
                    t2 = res.get(i);
                }
            }
        }
        if(t1 != null && t2!= null) {
            int tmp = t1.val;
            t1.val = t2.val;
            t2.val = tmp;
        }
    }
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        res.add(root);
        inorder(root.right);
    }
}