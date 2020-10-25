//https://leetcode.com/problems/merge-k-sorted-lists/
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(new ListNodeComparator());
        for(ListNode tmp : lists) {
            if(tmp!=null) {
                q.add(tmp);
            }
        }
        ListNode head =  new ListNode();
        ListNode curr = head;
        while(q.size()!=0) {
            curr.next = q.poll(); 
            curr=curr.next;
            if(curr.next!=null) {
                q.add(curr.next);
            }
        }
        return head.next;
    }
    class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode l1 , ListNode l2) {
            return l1.val - l2.val;
        }
    }
}