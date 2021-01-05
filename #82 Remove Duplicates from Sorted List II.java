//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
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
        
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        ListNode current = head;
        while(current != null && current.next!= null) {
            if(current.val != current.next.val) {
                dummy.next = current;
                dummy = dummy.next;
                current = current.next;  
            }
            else {
                int val = current.val;
                while(current != null && current.val == val) {
                    current = current.next;
                    
                }
            }
        }
        if(current != null) {
            dummy.next = current;
            dummy = dummy.next;
        }
        dummy.next = null;
        return res.next;
        
    }
}