// https://leetcode.com/problems/palindrome-linked-list/
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode reversedSecondHalf = reverseList(secondHalf);
        ListNode n = head;
        while(n != null && reversedSecondHalf != null) {
            if(n.val != reversedSecondHalf.val)
                return false;
            n = n.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;        
        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}