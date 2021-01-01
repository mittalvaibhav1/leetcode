//https://leetcode.com/problems/merge-in-between-linked-lists/
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list2; // Start of list2
        while(list2.next!= null) {
            list2 = list2.next;
        }
        ListNode end = list2; // End of list2
        ListNode copy = list1;
        ListNode beforeA = null;
        ListNode afterB = null;
        int idx = 0;
        for(int i = 0 ; i <= b ; i++) {
            if(idx == a - 1) {
                beforeA = copy;
            }
            if(idx == b) {
                afterB = copy.next;
                break;
            }
            copy = copy.next;
            idx++;
        }
        beforeA.next = start;
        end.next = afterB;
        return list1;
    }
}