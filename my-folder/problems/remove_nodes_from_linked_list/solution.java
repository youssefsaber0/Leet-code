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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> s = new Stack<>();
       
        while(head!= null){

        while(!s.isEmpty() && s.peek().val < head.val){
             s.pop();
         }
             s.push(head);
         
         head = head.next;
        }
        ListNode n = null;
        ListNode prev = null;
        while(!s.isEmpty()){
             
            prev = s.pop();
            prev.next = n;
            n = prev;
        }
        
        return n;
    }
}