//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        helper(head,null);
        return head;
    }
    public ListNode helper(ListNode head, ListNode prev) {
        if(head == null) return null;
        if(prev != null && head.val == prev.val) {
            prev.next = head.next;
            return helper(prev.next,prev);
        }
        return helper(head.next,head);
    }
}