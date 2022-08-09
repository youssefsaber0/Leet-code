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
    public ListNode addTwoNumbers(ListNode r1, ListNode r2) {
    int carry = 0;
    List<Integer> list = new ArrayList<>();
    
    while(r1!=null || r2!=null){
        int sum = 0;
        if(r1 != null){ 
            sum += r1.val;
            r1 = r1.next;
        }
        if(r2 != null){
            sum += r2.val;
            r2 = r2.next;
        }
        sum += carry;
        
        if(sum>9){
            int n = sum%10;
            carry = sum/10;
            list.add(n);
        }else{
            list.add(sum);
            carry = 0;
        }
    }
    
    if(carry!=0){
        list.add(carry);
    }
    
    ListNode output = null;
    for(int i=list.size()-1; i>=0; i--){
        ListNode n = new ListNode(list.get(i), output);
        output = n;   
    }
    return output;  
}   
}