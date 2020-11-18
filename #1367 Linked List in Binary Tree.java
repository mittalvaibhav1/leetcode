//https://leetcode.com/problems/linked-list-in-binary-tree/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return traverse(root,head);
    }
    public boolean traverse(TreeNode root , ListNode head) {
        if(root == null) return false;
        if(root.val == head.val)
            if(checkList(root,head)) return true;
        return traverse(root.left,head) || traverse(root.right,head);
    }
    public boolean checkList(TreeNode root, ListNode head) {
        if(head == null) return true;
        if(root == null) return false;
        if(root.val != head.val) return false;
        return checkList(root.left,head.next) || checkList(root.right,head.next);
    }
}