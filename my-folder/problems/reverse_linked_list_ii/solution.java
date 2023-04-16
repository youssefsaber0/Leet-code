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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftN = head;
        int i = 1;
        if(left == right){
            return head;
        }
        if(left == 1){
            ListNode rightN = head;
            int j = i;
            while(j != right ){
                rightN = rightN.next;
                j++;
            }
            head = reverseList(head,rightN.next,right - left +1);
            return head; 
        }

        while(i != left - 1){
            leftN = leftN.next;
            i++;
        }
        ListNode rightN = leftN.next;
        int j = i;
        while(j != right ){
            rightN = rightN.next;
            j++;
        }
        leftN.next = reverseList(leftN.next,rightN,right - left +1);
        return head;
    }
}