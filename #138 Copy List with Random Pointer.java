//https://leetcode.com/problems/copy-list-with-random-pointer/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Integer> nodeToIndex = new HashMap<>();
        HashMap<Integer,Node> indexToNode = new HashMap<>();
        Node dummy = new Node(0);
        buildList(head,dummy);
        nodeToIndex(head,nodeToIndex);
        indexToNode(dummy.next,indexToNode);
        Node tmp = dummy.next;
        while(head != null) {
            if(head.random != null) {
                int idx = nodeToIndex.get(head.random);
                tmp.random = indexToNode.get(idx);
            }
            tmp = tmp.next;
            head = head.next;
        }
        return dummy.next;
    }
    public void buildList(Node head ,Node dummy) {
        while(head != null) {
            dummy.next = new Node(head.val);
            dummy = dummy.next;
            head = head.next;
        }
    }
    public void nodeToIndex(Node head ,HashMap<Node,Integer> map) {
        int i  = 0;
        while(head != null) {
            map.put(head,i);
            i++;
            head = head.next;
        }
    }
    public void indexToNode(Node head ,HashMap<Integer,Node> map) {
        int i  = 0;
        while(head != null) {
            map.put(i,head);
            i++;
            head = head.next;
        }
    }
}