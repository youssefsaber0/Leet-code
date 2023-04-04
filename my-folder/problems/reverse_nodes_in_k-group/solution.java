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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(count < k && cur !=null){
            cur = cur.next;
            count++;
        }
        if(count == k){
            cur = reverseKGroup(cur, k);
            head = reverseList(head, cur, k);
        }
        return head;
    }
}