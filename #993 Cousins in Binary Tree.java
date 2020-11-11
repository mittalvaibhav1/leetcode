//https://leetcode.com/problems/cousins-in-binary-tree/
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
    int px = -1;
    int py = -1;
    int dx = -1;
    int dy = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,-1);
        if(px != py && dx == dy) {
            return true;
        }
        return false;
    }
    public void helper(TreeNode root , int x , int y, int d, int p) {
        if(root == null) return;
        if(root.val == x) {
            px = p;
            dx = d;
        }
        else if(root.val == y) {
            py = p;
            dy = d;
        }
        helper(root.left,x,y,d+1,root.val);
        helper(root.right,x,y,d+1,root.val);
    }
}