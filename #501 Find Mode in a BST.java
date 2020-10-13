//https://leetcode.com/problems/find-mode-in-binary-search-tree/
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
    HashMap<Integer,Integer> map;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        helper(root);
        int max  = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(),max);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                s.add(entry.getKey());
            }
        }
        int[] res = new int[s.size()];
        int k = 0;
        for(int i : s) {
            res[k++] = i;
        }
        return res;
    }
    public void helper(TreeNode root) {
        if(root == null) return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        helper(root.left);
        helper(root.right);
    }
}