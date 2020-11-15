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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null) {
            while(root != null) {
                st.push(root);
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(!st.isEmpty() && st.peek() == root) {
               root = root.right; 
            }
            else {
                res.add(root.val);
                root = null;
            }
        }
        return res;
    }
}