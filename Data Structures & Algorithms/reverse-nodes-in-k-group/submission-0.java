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
    public ListNode reverseLL(ListNode head){
        ListNode temp = head, prev = null; 
        while(head != null){
            temp = head.next; 
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public ListNode findKthNode(ListNode temp, int k){
        int count = 0;
        while(temp != null){
            count++;
            if(count == k) return temp;
            temp = temp.next;
        } 
        return null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevNode = null, nextNode = null, temp = head, kthNode = null;
        
        while(temp != null){
            kthNode = findKthNode(temp, k);
            if(kthNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            } else{
                if(head == temp){ 
                    head = kthNode;
                } else prevNode.next = kthNode;
                nextNode = kthNode.next;
                kthNode.next = null;
                reverseLL(temp);
                prevNode = temp;
                temp = nextNode; 
            }
        }
        return head;
    }
}
