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
    public ListNode reverse(ListNode head){
        ListNode tmp = head, prev = null; 
        while(head != null){
            tmp = head.next; 
            head.next = prev; 
            prev = head; 
            head = tmp; 
        }
        return prev; 
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null && n == 1)) return null;
        head = reverse(head);
        if(n == 1) {
            head = head.next; 
            return reverse(head);
        }
        ListNode tmp = head, prev = null; 
        while(tmp != null){
            n--;
            if(n == 0){
                prev.next = tmp.next;
                break;
            }
            prev = tmp;
            tmp = tmp.next;
        }
        head = reverse(head);
        return head;
    }
}
