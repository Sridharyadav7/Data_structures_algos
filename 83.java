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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        ListNode prev=head;
        while(temp!=null){
            while(temp.next!=null && temp.val==temp.next.val){
                temp=temp.next;
            }
            if(temp.next!=null) temp=temp.next;
            else temp=null;
            prev.next=temp;
            prev=temp;
        }
        return head;
    }
}