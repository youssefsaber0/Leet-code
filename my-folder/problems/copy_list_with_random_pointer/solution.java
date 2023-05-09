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
        if(head==null){
            return null;
        }
        Node interweave = head;
        while(interweave != null){
            Node n = new Node(interweave.val);
            n.next = interweave.next;
            interweave.next = n;
            interweave = interweave.next.next;

        }            

        Node cur = head;
        while(cur != null){
            if(cur.random == null){
                cur.next.random = null;
            }
            else cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        Node newHead = head.next;
        cur = head;
        Node newCur = newHead;
        cur.next= cur.next.next;
        cur = cur.next;
        while(cur != null){
            Node temp = cur.next;
            cur.next= cur.next.next;
            newCur.next = temp;
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}