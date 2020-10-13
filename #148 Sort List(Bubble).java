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
        if(head == null || head.next == null) return head;
        ListNode outer  = head;
        ListNode inner = head;
        while(outer != null) {
            int swap = 0;
            while(inner.next != null) {
                if(inner.val > inner.next.val) {
                   int tmp = inner .val;
                    inner.val = inner.next.val;
                    inner.next.val = tmp;
                    swap++;
                }
                inner = inner.next;
            }
            if(swap == 0) break;
            inner = head;
            outer = outer.next;
        }
       return head; 
    }
}