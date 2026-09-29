class Twitter {

    class Tweet {
        int timeStamp;
        int tweetId;
        Tweet prev;

        Tweet(int timeStamp, int tweetId) {
            this.timeStamp = timeStamp;
            this.tweetId = tweetId;
        }

    }
    
    //maintain the userId -> Tweets he did
    private Map<Integer, Tweet> tweetHeads;

    //maintain the userId and people he follows
    private Map<Integer, Set<Integer>> followers;

    private int timeStamp = 0;


    public Twitter() {

        tweetHeads = new HashMap<>();
        followers = new HashMap<>();    
        
    }
    
    public void postTweet(int userId, int tweetId) {

        Tweet newTweet = new Tweet(timeStamp++, tweetId);
        newTweet.prev = tweetHeads.get(userId);

        tweetHeads.put(userId, newTweet);

    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> heap =
            new PriorityQueue<>((a, b) -> b.timeStamp - a.timeStamp);

        // relevant users = self + everyone they follow
        Set<Integer> users = new HashSet<>(followers.getOrDefault(userId, new HashSet<>()));
        users.add(userId);

        // seed heap with each user's newest tweet (the head of their list)
        for (int u : users) {
            Tweet head = tweetHeads.get(u);
            if (head != null) heap.offer(head);
        }

        List<Integer> feed = new ArrayList<>();
        while (!heap.isEmpty() && feed.size() < 10) {
            Tweet t = heap.poll();     // the most recent tweet overall
            feed.add(t.tweetId);
            if (t.prev != null)        // push this user's next-older tweet
                heap.offer(t.prev);
        }
        return feed;

        
    }
    
    public void follow(int followerId, int followeeId) {

        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {

        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
        
    }
}
