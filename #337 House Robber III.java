//https://leetcode.com/problems/house-robber-iii/
// M1 - 1087ms
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
    public int rob(TreeNode root) {
        return  helper(root,false);
    }
    public int helper(TreeNode root, boolean robbed) {
        if(root == null) return 0;
        int not = 0 , rob = 0 ;
        if(robbed) return (helper(root.left,false) + helper(root.right,false));
        rob = root.val + helper(root.left,true) + helper(root.right , true);
        not = helper(root.left,false) + helper(root.right,false);
        return Math.max(rob,not);
    }
}
// M2 - 0ms
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
    public int rob(TreeNode root) {
        int[]res = helper(root);
        return Math.max(res[0] , res[1]);
    }
    public int[] helper(TreeNode root) {
        if(root == null) return new int[] {0 ,0};
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        
        int rob = root.val + left[1] + right[1];
        int not_rob = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[] { rob , not_rob };
    }
}