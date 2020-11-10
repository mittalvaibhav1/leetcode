httpsleetcode.comproblemsbinary-tree-postorder-traversal

  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    ListInteger res;
    public ListInteger postorderTraversal(TreeNode root) {
        res = new LinkedListInteger();
        helper(root);
        return res;
    }
    public void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}