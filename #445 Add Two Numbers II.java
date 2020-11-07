//https://leetcode.com/problems/add-two-numbers-ii/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode itr1 = l1;
        ListNode itr2 = l2;
        int len1 = 0;
        int len2 = 0;
        while(itr1 != null) {
            len1++;
            itr1 = itr1.next;
        }
        while(itr2 != null) {
            len2++;
            itr2 = itr2.next;
        }
        ListNode res = new ListNode(0);
        res.next = len1 > len2 ? l1 : l2;
        itr1 = res.next;
        itr2 = len1 <= len2 ? l1 : l2;
        int gap = Math.abs(len1 - len2);
        while(gap-- > 0) {
            itr1 = itr1.next;
        }
        while(itr1!=null) {
            itr1.val += itr2.val;
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        helper(res);
        return res.val == 0 ? res.next : res;
    }
    public int helper(ListNode head) {
        if(head == null) return 0;
        int carry = helper(head.next);
        int val = head.val + carry;
        head.val = val % 10;
        return val / 10;
    }
}