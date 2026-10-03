class Node{
    int val;
    int key;
    Node next; 
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    HashMap<Integer, Node> hm;
    int capacity; 
    Node head, tail;

    private void deleteNode(Node node){
        if(node.prev == null){
            node.next.prev = null;
            node.next = null;
        } else if(node.next == null){
            node.prev.next = null;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
        return ;
    }

    private void insertAfterHead(Node node){
        node.prev = head;
        node.next = head.next; 
        head.next.prev = node;
        head.next = node;
        return ;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        head = tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1; 
        Node temp = hm.get(key);
        deleteNode(temp);
        insertAfterHead(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            temp.val = value; 
            deleteNode(temp);
            insertAfterHead(temp);
        } else {
            Node temp = new Node(key, value);
            if(capacity == hm.size()){
                Node del = tail.prev;
                hm.remove(del.key);
                deleteNode(del);
                hm.put(key,temp);
                insertAfterHead(temp);
            } else {
                hm.put(key,temp);
                insertAfterHead(temp);
            }
        }
    }
}
