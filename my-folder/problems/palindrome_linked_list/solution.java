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
    public boolean isPalindrome(ListNode head) {
        ListNode cur1 = head;
        ListNode newList = new ListNode(head.val);
        while(cur1 != null && cur1.next != null){
            ListNode temp = new ListNode(cur1.next.val, newList);
            newList = temp;
            cur1 = cur1.next;
        }
        ListNode cur2 = newList;
        cur1 = head;
        while(cur1 != null){
            if(cur1.val != cur2.val)
                return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }
}