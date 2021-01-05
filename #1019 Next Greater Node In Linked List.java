//https://leetcode.com/problems/next-greater-node-in-linked-list
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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Pair> stack = new LinkedList<>();
        int idx = 0;
        while(head != null) {
            res.add(0);
            while(!stack.isEmpty() && stack.peek().val < head.val) {
                res.set(stack.peek().idx,head.val);
                stack.pop();
            }
            stack.push(new Pair(idx++,head.val));
            head = head.next;
        }
        idx =0;
        int[] ans = new int[res.size()];
        for(int val : res) {
            ans[idx++] = val;
        }
        return ans;
    }
}
class Pair {
    int val;
    int idx;
    public Pair(int idx, int val) {
        this.val = val;
        this.idx = idx;
    }
}