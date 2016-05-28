/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;

            while(pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }


            curr.next = pre.next;
            pre.next = curr;
            pre = dummy;
            curr = next;
        }

        return dummy.next;
    }
}
