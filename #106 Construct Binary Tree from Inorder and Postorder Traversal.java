//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
// M1 - 3ms
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode helper(int[] in, int[] post, int si, int ei, int sp, int ep) {
        if(sp > ep) return null;
        TreeNode root = new TreeNode(post[ep]);
        int index = - 1;
        for(int i = si ; i <= ei ; i++) {
            if(in[i] == post[ep]) {
                index = i;
                break;
            }
        }
        int sizeLeft = index - si;
        int sizeRight = ei - index;
        int el = sp + sizeLeft - 1;
        int sr = ep - sizeRight;
        root.left = helper(in,post,si,index-1,sp,el);
        root.right = helper(in,post,index+1,ei,sr,ep-1);
        return root;
    }
}
//M2 - 1ms
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
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++) {
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode helper(int[] post, int si, int ei, int sp, int ep) {
        if(sp > ep) return null;
        TreeNode root = new TreeNode(post[ep]);
        int index = map.get(post[ep]);
        int sizeLeft = index - si;
        int sizeRight = ei - index;
        int el = sp + sizeLeft - 1;
        int sr = ep - sizeRight;
        root.left = helper(post,si,index-1,sp,el);
        root.right = helper(post,index+1,ei,sr,ep-1);
        return root;
    }
}