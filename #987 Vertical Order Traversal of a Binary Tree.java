//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
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
class Pair {
    TreeNode node;
    int hd;
    int vd;
    public Pair(TreeNode node, int hd, int vd) {
        this.node = node;
        this.hd = hd;
        this.vd = vd;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        TreeMap<Integer, LinkedList<Pair>> map = new TreeMap<>();
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        while(!q.isEmpty()) {
            Pair node = q.poll();
            if(!map.containsKey(node.hd)) {
                map.put(node.hd, new LinkedList<Pair>());
            }
            map.get(node.hd).add(node);
            if(node.node.left != null) {
                q.add(new Pair(node.node.left, node.hd - 1, node.vd + 1));
            }
            if(node.node.right != null) {
                q.add(new Pair(node.node.right, node.hd + 1, node.vd + 1));
            }
        }
        for(Map.Entry<Integer, LinkedList<Pair>> entry : map.entrySet()) {
            LinkedList<Pair> tmp = entry.getValue();
            Collections.sort(tmp, (a,b) -> a.vd == b.vd ? a.node.val - b.node.val : a.vd - b.vd);
            LinkedList<Integer> ints = new LinkedList<>();
            for(Pair i : tmp) {
                ints.add(i.node.val);
            }
            res.add(ints);
            
        }
        return res;
    }
}