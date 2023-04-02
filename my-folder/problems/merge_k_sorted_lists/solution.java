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
    ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null)
            return null;
        ListNode p1 = l1, p2 = l2;
        ListNode ans = new ListNode();
        ListNode head = ans;
        while(p1 != null && p2 != null){
            if(p1.val > p2.val ){
                ans.val = p2.val;
                p2 = p2.next;
                ans.next = new ListNode();
                ans = ans.next;
            }
            else{
                ans.val = p1.val;
                p1 = p1.next;
                ans.next = new ListNode();
                ans = ans.next;
            }
        }
        if(p1 == null){
            ans.val = p2.val;
            ans.next = p2.next;
        }
        if(p2 == null){
            ans.val = p1.val;
            ans.next = p1.next;
        }
        return head;
    }
    ListNode mergeKLists(ListNode[] lists, int st, int end){
        if(st == end)
            return lists[st];
        if(end - st == 1 ){
            return mergeTwo(lists[st],lists[end]);
        }
        int mid = (st + end) / 2; 
        ListNode right =  mergeKLists( lists,  st,  mid); 
        ListNode left =  mergeKLists( lists,  mid + 1,  end); 
        return mergeTwo(right, left);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        System.out.println(lists.length);
        if(lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
}