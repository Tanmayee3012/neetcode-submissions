class Twitter {

    int count; 
    HashMap<Integer, List<int[]>> tweetMap;
    HashMap<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }

    class NewsFeed{
        int timestamp;
        int tweetId;
        int followeeId;
        int index;

        public NewsFeed(int timestamp, int tweetId, int followeeId, int index){
            this.timestamp = timestamp;
            this.tweetId = tweetId;
            this.followeeId = followeeId;
            this.index = index;
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<NewsFeed> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.timestamp, a.timestamp));

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followeeId: followMap.get(userId)){
            if(tweetMap.containsKey(followeeId) && tweetMap.get(followeeId).size() > 0){
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                maxHeap.offer(new NewsFeed(tweets.get(index)[0], tweets.get(index)[1], followeeId, index - 1));
            }
        }

        while(!maxHeap.isEmpty() && res.size() < 10){
            NewsFeed nf = maxHeap.poll();
            res.add(nf.tweetId);
            if(nf.index >= 0){
                int[] temp = tweetMap.get(nf.followeeId).get(nf.index);
                maxHeap.offer(new NewsFeed(temp[0], temp[1], nf.followeeId, nf.index - 1));
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */