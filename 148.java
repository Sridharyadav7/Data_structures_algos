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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode middle=findmiddle(head);
        ListNode lefthead=head;
        ListNode righthead=middle.next;
        middle.next=null;
        lefthead=sortList(lefthead);
        righthead=sortList(righthead);
        return merge(lefthead,righthead);
    }
    public ListNode findmiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode temp1=head1;
        ListNode temp2=head2;
        ListNode merged=new ListNode();
        ListNode curr=merged;
        if(temp1.val<=temp2.val){
            merged.val=temp1.val;
            temp1=temp1.next;
        }
        else{
            merged.val=temp2.val;
            temp2=temp2.next;
        }
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                curr.next=new ListNode(temp1.val);
                curr=curr.next;
                temp1=temp1.next;
            }
            else{
                curr.next=new ListNode(temp2.val);
                curr=curr.next;
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            curr.next=new ListNode(temp1.val);
            curr=curr.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            curr.next=new ListNode(temp2.val);
            curr=curr.next;
            temp2=temp2.next;
        }
        return merged;
    }
}