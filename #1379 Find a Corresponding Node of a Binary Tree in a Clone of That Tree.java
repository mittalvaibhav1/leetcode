//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        int idx = getIndex(original,target);
        return getNode(cloned,idx);
    }
    public int getIndex(TreeNode root, TreeNode t) {
        Pair node = new Pair(root,0);
        LinkedList<Pair> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            node = q.poll();
            if(node.node == t)
                return node.idx;
            if(node.node.left != null) 
                q.add(new Pair(node.node.left, 2 * node.idx + 1));
            if(node.node.right != null) 
                q.add(new Pair(node.node.right, 2 * node.idx + 2));
        }
        return -1;
    }
    public TreeNode getNode(TreeNode root,int idx) {
        Pair node = new Pair(root,0);
        LinkedList<Pair> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            node = q.poll();
            if(node.idx == idx)
                return node.node;
            if(node.node.left != null) 
                q.add(new Pair(node.node.left, 2 * node.idx + 1));
            if(node.node.right != null) 
                q.add(new Pair(node.node.right, 2 * node.idx + 2));
        }
        return null;
    }
}
class Pair {
    TreeNode node;
    int idx;
    public Pair(TreeNode node , int idx) {
        this.node = node;
        this.idx = idx;
    }
}