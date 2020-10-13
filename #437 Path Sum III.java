//https://leetcode.com/problems/path-sum-iii/
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
    HashMap<Integer,Integer> map ;
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        map = new HashMap<>();
        map.put(0,1);
        pathSum(root,sum,0);
        return res;
    }
    public void pathSum(TreeNode root, int sum , int currSum) {
        if(root == null) return;
        currSum+=root.val;
        if(map.containsKey(currSum-sum)) res+= map.get(currSum-sum);
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        pathSum(root.left,sum,currSum);
        pathSum(root.right,sum,currSum);
        map.put(currSum,map.get(currSum)-1);
        currSum -= root.val;
    }
}