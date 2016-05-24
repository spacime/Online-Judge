/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newhead = null;
        ListNode curr = slow;

        while(curr != null) {
            ListNode temp = curr.next;;
            curr.next = newhead;
            newhead = curr;
            curr = temp;
        }

        ListNode p = head;

        while(p != null) {
            ListNode temp1 = p.next;
            ListNode temp2 = newhead.next;
            p.next = newhead;
            newhead.next = temp1;
            p = temp1;
            newhead = temp2;
        }
    }
}
