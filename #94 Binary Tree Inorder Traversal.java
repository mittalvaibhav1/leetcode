//https://leetcode.com/problems/binary-tree-inorder-traversal/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        while(s.size()!=0 || root!=null)
        {
            while(root !=  null)
            {
                s.add(root);
                root = root.left;
            }
            root = s.pop();
            l.add(root.val);
            root = root.right;
        }
        return l;
    }
}