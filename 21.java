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
        if(list1==null && list2==null) return list1;
        if(list1==null && list2!=null) return list2;
        if(list1!=null && list2==null) return list1;

        else{
            ListNode temp1=list1;
            ListNode temp2=list2;
            ListNode list3=new ListNode();
            ListNode curr=list3;
            if(temp1.val<=temp2.val){
                list3.val=temp1.val;
                temp1=temp1.next;
            }
            else{
                list3.val=temp2.val;
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
            if(temp1!=null){
                while(temp1!=null){
                    curr.next=new ListNode(temp1.val);
                    temp1=temp1.next;
                    curr=curr.next;
                }
            }
            if(temp2!=null){
                while(temp2!=null){
                    curr.next=new ListNode(temp2.val);
                    temp2=temp2.next;
                    curr=curr.next;
                }
            }
            return list3;
    }
}}