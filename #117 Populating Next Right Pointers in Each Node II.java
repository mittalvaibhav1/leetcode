//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node n = root;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(n);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                n = q.poll();
                n.next = size != 0 ? q.peek() : null;
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
                
            }
        }
        return root;
    }
}