class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

    Arrays.sort(trips,(a,b) -> a[1] - b[1]);

    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a,b) -> a[1] - b[1]);
    
    int currentCapacity = 0;

    for (int[] trip: trips) {

        int cap = trip[0];
        int fromLoc =  trip[1];

        while (!pq.isEmpty() && pq.peek()[1] <= fromLoc) {

            currentCapacity -=pq.poll()[0];

        }

        currentCapacity += cap;

        if (currentCapacity > capacity)
            return false;

        pq.offer(new int[] {cap, trip[2]});
    
    }

     return true;

    }
}