class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    Node(){}

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

}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word1) {
        Node node = root;
        char[] word = word1.toCharArray();
        for(int i = 0; i < word.length; i++){
            char ch = word[i];
            if(node.links[ch - 'a'] == null){
                node.links[ch - 'a'] = new Node();
            }
            node = node.links[ch - 'a'];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    public boolean dfs(char[] word, int j, Node root){
        Node node = root;
        for(int i = j; i < word.length; i++){
            char ch = word[i];
            if(ch == '.'){
                for(Node link: node.links){
                    if(link != null && dfs(word, i + 1, link)){
                        return true;
                    }
                }
                return false;
            } else {
                if(node.links[ch - 'a'] == null){
                    return false;
                }
                node = node.links[ch - 'a'];
            }
        }
        return node.flag;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */