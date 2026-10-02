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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next; 
        }
        ListNode temp = slow.next, head2 = slow.next, prev = slow.next =  null; 
        while(head2 != null){
            temp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = temp;
        }

        ListNode temp2 = prev, temp3 = head;
        temp = head;
        head2 = prev; 
        while(head2 != null){
            temp3 = temp.next;
            temp2 = head2.next;
            temp.next = head2;             
            head2.next = temp3;
            head2 = temp2;
            temp = temp3;
        }
        return;
    }
}
