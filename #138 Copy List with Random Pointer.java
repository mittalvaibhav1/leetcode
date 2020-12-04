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
		// to convert orignal list nodes into indexes
        HashMap<Node,Integer> nodeToIndex = new HashMap<>(); 
		// to assign indexes to duplicate list nodes
        HashMap<Integer,Node> indexToNode = new HashMap<>();
        Node dummy = new Node(0);
        buildList(head,dummy); // create a duplicate list.
        nodeToIndex(head,nodeToIndex); // convert nodes of orignal list into indexes
        indexToNode(dummy.next,indexToNode); // assign indexes to each node of duplicate list
        Node tmp = dummy.next; // head of the duplicate list.
        while(head != null) {
            if(head.random != null) { // if random node is not null
			    // get the index of the random node from orignal list
                int idx = nodeToIndex.get(head.random); 
				//assign the node with same index number from duplicate list 
				//to the current duplicate list node
                tmp.random = indexToNode.get(idx);
            }
            tmp = tmp.next;
            head = head.next;
        }
        return dummy.next; // return the head of the duplicate list
    }
	//The functions are quite easy to understand but if you have any doubts, feel free to ask me!
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