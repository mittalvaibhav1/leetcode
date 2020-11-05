//https://leetcode.com/problems/insertion-sort-list/
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
    public ListNode insertionSortList(ListNode head) {
        ListNode main = new ListNode();
        main.next = head;
        ListNode res = new ListNode();
        while(main.next!=null) {
            ListNode itr = res;
            while(itr.next != null) {
                if(itr.next.val >= main.next.val) {
                    break;
                }
                itr = itr.next;
            }
            ListNode tmp = main.next;
            main.next = main.next.next;
            tmp.next = itr.next;
            itr.next = tmp;
        }
        return res.next;
    }
}