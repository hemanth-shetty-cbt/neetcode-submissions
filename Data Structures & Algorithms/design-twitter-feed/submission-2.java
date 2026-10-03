class Twitter {

    private Map<Integer, Set<Integer>> followers = new HashMap<>(); //[userId -> <userId..>]
    private Map<Integer, List<int[]>> tweets = new HashMap<>(); //[userId -> [timeStamp, tweetId]];
    private int timeStamp = 0;


    public Twitter() {    
    }
    
    public void postTweet(int userId, int tweetId) {
        
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[] {timeStamp++, tweetId});
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0] - a[0]);

        //adding into heap the details of the user
        if(tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));

        }
        
        //get all the related people

        Set<Integer> relatesPeople = followers.getOrDefault(userId, new HashSet<>());

        for (int people:relatesPeople) {

            if(tweets.containsKey(people))
                pq.addAll(tweets.get(people));
        }

        List<Integer> result = new ArrayList<>();

        while(!pq.isEmpty() && result.size() < 10) {

            int[] poll = pq.poll();

           result.add(poll[1]);

        }

        return result;

        
    }
    
    public void follow(int followerId, int followeeId) {

        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {

        if (followers.containsKey(followerId))
            followers.get(followerId).remove(followeeId);
        
    }
}
