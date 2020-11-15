//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new LinkedList<>();
            while(size-->0) {
                root = q.poll();
                tmp.add(root.val);
                for(int i = 0 ; i < root.children.size() ; i++) {
                    q.add(root.children.get(i));
                }
            }
            res.add(tmp);
        }
        return res;
    }
}