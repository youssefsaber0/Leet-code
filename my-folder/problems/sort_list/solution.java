class Solution {
    public ListNode sortList(ListNode head) {
        ListNode current = head;
        ListNode lastSorted =head;
        while(current != null ){
            if(current.val>= lastSorted.val){
                lastSorted = current;
                current = current.next;
                continue;
            }
            else{
                ListNode newIndex = head;
                lastSorted.next = current.next;
                if(current.val < head.val){
                    current.next = head;
                    head = current;
                    current = lastSorted.next;
                    continue;
                }
                while(current.val > newIndex.next.val ){
                    newIndex = newIndex.next;
                }
                current.next = newIndex.next;
                newIndex.next = current;
                current = lastSorted.next;
            }
        }
        return head;
    }
}