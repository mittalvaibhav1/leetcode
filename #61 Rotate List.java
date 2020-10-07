//https://leetcode.com/problems/rotate-list/
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null)
            return head; // 0 or 1 Node.
        int len = 1;
        ListNode n = head;
        while(n.next!=null){
            len++;
            n=n.next;
        }
        n.next = head; // Connecting Last Node to the First Node.
        k = k%len;
        for(int i = 0 ; i <len -k ; i++) {
            n = n.next;
        }
        ListNode newHead = n.next;
        n.next = null;
        return newHead;
    }
}