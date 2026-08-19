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
    public ListNode removeNodes(ListNode head) {
        if(head.next == null) return head;
        
        int len = 0;
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();

        while(temp != null) {
            len++;
            list.add(temp.val);
            temp = temp.next;
        }

        int max = list.get(len-1);
        for(int i = len - 2; i >= 0; i--) {
            int ele = list.get(i);
            if(ele < max) {
                list.set(i, -1);
            }
            else if(ele > max) {
                max = ele;
            }
        }

        ListNode prev = null;
        temp = head;
        int ind = 0;

        while(temp != null) {
            if(list.get(ind)  == -1) {
                if(prev != null) {
                    prev.next = temp.next;
                }
                temp = temp.next;
            }
            else {
                if(prev == null) {
                    head = temp;
                }
                prev = temp;
                temp = temp.next;
            }
            ind++;
        }
        return head;
    }
}