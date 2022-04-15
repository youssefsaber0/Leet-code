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
    public ListNode insertionSortList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        stack.push(head);
        while(stack.peek()!=null){
            int i=stack.size()-2;
            int n=stack.size();
            ListNode temp=stack.get(n-1);
            while(i>=0&&temp.val<stack.get(i).val){
                stack.get(i).next=temp.next;
                temp.next=stack.get(i);
                stack.set(i+1,stack.get(i));
                stack.set(i,temp);
                if(i!=0){
                    stack.get(i-1).next=temp;    
                }
                i--;
            }
          stack.push(stack.get(n-1).next);
        }
        head=stack.get(0);
        return head;
    }
}