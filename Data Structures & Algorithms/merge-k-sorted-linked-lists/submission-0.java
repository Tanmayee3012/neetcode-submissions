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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummy = new ListNode(0), tmp = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next; 
            } else {
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next; 
            }
        }

        if(list1 != null){
            tmp.next = list1;
        } else if(list2 != null){
            tmp.next = list2;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        else if(lists[0] == null && lists.length == 1) return null; 
        else if(lists.length == 1) return lists[0];
        ListNode res = lists[0];
        for(int i = 1; i < lists.length; i++){
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }
}