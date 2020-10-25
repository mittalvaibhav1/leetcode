//https://leetcode.com/problems/sort-list/
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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = null;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        head = mergeSort(head);
        right = mergeSort(right);
        return merge(head,right);
    }
    public ListNode merge(ListNode l1 , ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode();
        ListNode curr = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) {
            curr.next = l1;
        }
        if(l2 != null) {
            curr.next = l2;
        }
        return head.next;
    }
}