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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null) {
            return new int[] {-1, -1};
        }
        ListNode prev = null;
        ListNode temp = head;
        ListNode forw = head.next;
        int ind = 0;
        List<Integer> criticals = new ArrayList<>();

        while(forw != null) {
            ind++;
            if(prev != null) {
                if(temp.val > prev.val && temp.val > forw.val) {
                    criticals.add(ind);
                }
                else if(temp.val < prev.val && temp.val < forw.val) {
                    criticals.add(ind);
                }
            }
            prev = temp;
            temp = forw;
            forw = forw.next;
        }

        int len = criticals.size();
        if(len < 2) {
            return new int[] {-1, -1};
        }
        int minDis = 1000000;
        int maxDis = criticals.get(len-1) - criticals.get(0);

        for(int i = 1; i < len; i++) {
            minDis = Math.min(minDis, criticals.get(i) - criticals.get(i-1));
        }

        return new int[] {minDis, maxDis};
    }
}