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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        if(head.next==null && n==1){
            return head.next;
        }
        else{
            int size=length(head);
            int count=0;
            ListNode temp=head;
            while(temp!=null){
                if(size-count==n){
                    head=removekth(head,count+1);
                    break;
                }
                count++;
                temp=temp.next;
            }
            return head;
        }
    }
    public ListNode removekth(ListNode head, int k){
        if(k==1){
            head=head.next;
            return head;
        }
        else{
            ListNode temp=head;
            int count=1;
            while(temp!=null){
                if(k-1==count){
                    temp.next=temp.next.next;
                    break;
                }
                count++;
                temp=temp.next;
            }
            return head;
        }
    }
    public int length(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}