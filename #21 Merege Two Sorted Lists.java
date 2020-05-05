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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0) ;
        ListNode n = head;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                n.next=l1;
                l1=l1.next;
            }
            else
            {
                n.next=l2;
                l2=l2.next;
            }
            n=n.next;
        }
        while(l1!=null)
        {
           n.next=l1;
           l1=l1.next;
           n=n.next; 
        }
        while(l2!=null)
        {
           n.next=l2;
           l2=l2.next;
           n=n.next; 
        }
        
        return head.next;
    }
}