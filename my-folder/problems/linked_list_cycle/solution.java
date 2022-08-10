/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        var nodesTracker = new HashSet<ListNode>();
        while(head != null){
            if(nodesTracker.contains(head)){
                return true;
            }
            nodesTracker.add(head);
            head = head.next;
        }
        return false;
    }
}