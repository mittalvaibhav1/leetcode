//https://leetcode.com/problems/reverse-linked-list/
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
//M1 Recursive
class Solution {
    ListNode newHead;
    ListNode prev;
    public ListNode reverseList(ListNode head) {
        helper(head);
        return newHead;
    }
    public void helper(ListNode curr) {
        if(curr == null) {
            newHead = prev;
            return;
        }
        ListNode tmp = curr.next;
        curr.next = prev;
        prev = curr;
        helper(tmp);
    }
}
//M2 Iterative
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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head , prev = null;
        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}