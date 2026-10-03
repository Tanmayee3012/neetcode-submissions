/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node tmp = head, lat; 

        // insert clone nodes next to original node
        while(tmp != null){
            Node newNode = new Node(tmp.val);
            newNode.next =  tmp.next;
            tmp.next = newNode;
            tmp = tmp.next.next;
        }

        // connect random pointers 
        tmp = head;
        while(tmp != null){
            if(tmp.random != null)
                tmp.next.random = tmp.random.next;
            else tmp.next.random = null;
            tmp = tmp.next.next;
        }

        // connect next pointers
        tmp = head;
        Node dummyNode = new Node(0), tmpClone = dummyNode;
        while(tmp != null){
            tmpClone.next = tmp.next;
            tmp.next = tmp.next.next;
            tmpClone = tmpClone.next;
            tmp = tmp.next;
        }
        return dummyNode.next;
    }
}