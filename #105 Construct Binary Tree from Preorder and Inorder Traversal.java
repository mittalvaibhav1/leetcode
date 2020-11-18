//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
// M1 3ms
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length - 1 ,0,inorder.length - 1);
    }
    public TreeNode helper(int[] preorder , int[] inorder , int sp , int ep, int si , int ei) {
        if(sp > ep) return null;
        TreeNode root = new TreeNode(preorder[sp]);
        int index = - 1;
        for(int i = si; i <= ei ; i++ ) {
            if(inorder[i] == preorder[sp]) {
                index = i;
                break;
            }
        }
        int sizeLeft = index - si;
        int sizeRight = ei - index;
        int sr = ep - sizeRight + 1;
        int el = sp + sizeLeft;
        root.left = helper(preorder,inorder,sp+1,el,si,index - 1);
        root.right = helper(preorder,inorder,sr,ep,index + 1 , ei);
        return root;
    }
}
// M2 - 1ms
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
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length - 1 ,0,inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int sp , int ep, int si , int ei) {
        if(sp > ep) return null;
        TreeNode root = new TreeNode(preorder[sp]);
        int index = map.get(preorder[sp]);
        int sizeLeft = index - si;
        int sizeRight = ei - index;
        int sr = ep - sizeRight + 1;
        int el = sp + sizeLeft;
        root.left = helper(preorder,sp+1,el,si,index - 1);
        root.right = helper(preorder,sr,ep,index + 1 , ei);
        return root;
    }
}