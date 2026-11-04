class Solution {
    private int ROWS,COLS;
    class Node{
        Node[] links;
        boolean flag;

        Node(){
            links = new Node[26];
            flag = false;
        }

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

        public boolean isEnd(Node node){
            return node.flag == true;
        }

        public void setFlag(Node node, boolean check){
            node.flag = check;
        }
    }

    class Trie{
        Node root;

        Trie(){
            root = new Node();
        }

        public void addWord(String word){
            Node node = root;
            char[] word1 = word.toCharArray();
            for(int i = 0; i < word1.length; i++){
                char ch = word1[i];
                if(!node.containsKey(ch)){
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++){
            trie.addWord(words[i]);
        }
        List<String> res = new ArrayList<>();
        StringBuilder subset = new StringBuilder();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                dfs(res, subset, words, trie.root, r, c, board);
            }
        }
        return res;
    }

    public void dfs(List<String> res, StringBuilder subset, String[] words, Node node, int r, int c, char[][] board){
        if(node.isEnd(node)){
            res.add(new String(subset.toString()));
            node.setFlag(node, false);
        }

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] == '#' || !node.containsKey(board[r][c])) return;

        subset.append(board[r][c]);
        node = node.get(board[r][c]);
        char temp = board[r][c];
        board[r][c] = '#';
        dfs(res, subset, words, node, r + 1, c, board);
        dfs(res, subset, words, node, r, c + 1, board);
        dfs(res, subset, words, node, r - 1, c, board);
        dfs(res, subset, words, node, r, c - 1, board);
        board[r][c] = temp;
        subset.deleteCharAt(subset.length() - 1);
    }
}
