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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current1=list1,current2=list2;
        ListNode ans=new ListNode(),curM=ans;
        if(current1==null&&current2==null){
            return null;
        }
        if(current1==null){
            return current2;
        }
        if(current2==null){
            return current1;
        }
        if(current1.val>current2.val){
            curM.val=current2.val;
            current2=current2.next;
        }
        else{
            curM.val=current1.val;
            current1=current1.next;
        }
        while(current1!=null&&current2!=null){
            if(current1.val>current2.val){
                curM.next=new ListNode(current2.val);
               curM= curM.next;            
                current2=current2.next;
            }
            else{
                 curM.next=new ListNode(current1.val);
               curM= curM.next; 
                current1=current1.next;
            }
        }
        while(current1!=null){
            curM.next=new ListNode(current1.val);
            curM= curM.next; 
            current1=current1.next;
        }
        while(current2!=null){
            curM.next=new ListNode(current2.val);
            curM= curM.next; 
            current2=current2.next;
        }
    return ans;
        
    }
}