//https://leetcode.com/problems/binary-search-tree-iterator
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
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode node;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    } 
    /** @return the next smallest number */
    public int next() {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        TreeNode curr = stack.pop();
        node = curr.right;
        return curr.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.node != null || !this.stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */