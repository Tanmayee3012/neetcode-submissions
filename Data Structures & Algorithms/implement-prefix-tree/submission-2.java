class Node{
    Node[] links = new Node[26];
    Boolean flag = false;

    Node(){ }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    public Node get(char ch){
        return links[ch - 'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag == true;
    }

}

class PrefixTree {
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word1) {
        Node node = root;
        char[] word = word1.toCharArray();
        for(int i = 0; i < word.length; i++){
            if(!node.containsKey(word[i])){
                node.put(word[i], new Node());
            }
            node = node.get(word[i]);
        }
        node.setEnd();
    }
    
    public boolean search(String word1) {
        Node node = root;
        char[] word = word1.toCharArray();
        for(int i = 0; i < word.length; i++){
            if(!node.containsKey(word[i])) return false;
            node = node.get(word[i]);
        }   
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        char[] word = prefix.toCharArray();
        for(int i = 0; i < word.length; i++){
            if(!node.containsKey(word[i])) return false;
            node = node.get(word[i]);
        } 
        return true;
    }
}
