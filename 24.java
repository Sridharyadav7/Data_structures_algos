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
    public ListNode swapPairs(ListNode head) {
        int count=0;
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode first=head;
        ListNode sec=head.next;
        ListNode prev=null;
        while(first!=null && sec!=null){
            first.next=first.next.next;
            sec.next=first;
            if(count==0){
                head=sec;
                count++;
            }
            if(prev!=null){
                prev.next=sec;
            }
            prev=first;
            first=first.next;
            if(first!=null && first.next!=null) sec=first.next;
            else sec=null;
        }
        return head;
    }
}