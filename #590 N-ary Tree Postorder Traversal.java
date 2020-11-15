//https://leetcode.com/problems/n-ary-tree-postorder-traversal/
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
// M1 Recursive
class Solution {
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new LinkedList<>();
        helper(root);
        return res;
    }
    public void helper(Node root) {
        if(root == null) return;
        Iterator<Node> it = root.children.iterator();
        while(it.hasNext()) {
            helper(it.next());
        }
        res.add(root.val);
    }
}
//M2 - iterative
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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> st = new Stack<>();
        st.push(root);
        st.push(root);
        while(!st.isEmpty()) {
            root = st.pop();
            if(!st.isEmpty() && st.peek() == root) {
                for(int i = root.children.size() - 1 ; i >= 0 ; i--) {
                    st.push(root.children.get(i));
                    st.push(root.children.get(i));
                }
            }
            else {
                res.add(root.val);
                root = null;
            }
            
        }
        return res;
    }
}