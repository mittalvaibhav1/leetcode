//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> res;
    public List<Integer> preorder(Node root) {
        res = new LinkedList<>();
        helper(root);
        return res;
    }
    public void helper(Node root) {
        if(root == null) return;
        res.add(root.val);
        Iterator<Node> it = root.children.iterator();
        while(it.hasNext()) {
            helper(it.next());
        }
    }
}