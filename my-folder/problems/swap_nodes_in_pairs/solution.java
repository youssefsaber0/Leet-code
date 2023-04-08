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
       public ListNode reverseList(ListNode head, ListNode prev,int count) {
        
        ListNode curr = head;

        while (count-- >0) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(count < 2 && cur !=null){
            cur = cur.next;
            count++;
        }
        if(count == 2){
            cur = swapPairs(cur);
            head = reverseList(head, cur, 2);
        }
        return head;
    }
}