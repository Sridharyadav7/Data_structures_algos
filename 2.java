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

// Cleared 1565 testcases out of 1569

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String n1="";
        String n2="";
        ListNode temp=l1;
        while(temp!=null){
            int curr=temp.val;
            n1=n1+(Integer.toString(curr));
            temp=temp.next;
        }

        temp=l2;
        while(temp!=null){
            int curr=temp.val;
            n2=n2+(Integer.toString(curr));
            temp=temp.next;
        }
        long num1=reverse(n1);
        long num2=reverse(n2);
        long result=num1+num2;
        int curr=(int)(result%10);
        result=result/10;
        ListNode l3=new ListNode(curr);
        ListNode node=l3;
        while(result>0){
            int value=(int)(result%10);
            node.next=new ListNode(value);
            node=node.next;
            result=result/10;
        }
        return l3;
    }

    public long reverse(String num){
        int j=num.length()-1;
        String newstr="";
        while(j>=0){
            newstr=newstr+num.charAt(j);
            j--;
        }

        return Long.parseLong(newstr);
    }
}