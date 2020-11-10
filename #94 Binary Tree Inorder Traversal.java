//https://leetcode.com/problems/binary-tree-inorder-traversal/
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
// M1 RECUSRIVE
class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        inorder(root);
        return res;
    }
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
        return;
    }
}

// M2 Iterative
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
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root!= null) {
            while(root != null) {
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}