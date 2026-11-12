class Solution {
    class Pair{
        String word;
        int level;

        public Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) { 
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.word;
            int l = p.level;
            if(s.equals(endWord)) return l;

            for(int c = 0; c < s.length(); c++){
                StringBuilder temp = new StringBuilder(s);
                for(int j = 0; j < 26; j++){
                    temp.setCharAt(c, (char) ('a' + j));
                    String newWord = temp.toString();
                    if(set.contains(newWord)){
                        q.offer(new Pair(newWord, l + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}