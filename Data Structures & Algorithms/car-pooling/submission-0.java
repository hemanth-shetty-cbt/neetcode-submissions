class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a,b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]);

        int currentCount = 0;

        for(int[] trip:trips) {

            int count = trip[0];
            int from = trip[1];

            
            while (!pq.isEmpty() && pq.peek()[1] <= from) {
                currentCount -= pq.poll()[0];
            }

            currentCount +=count;

            if (currentCount > capacity) 
                return false;
            
            
            pq.offer(new int[] {count, trip[2]});

        }

        return true;
        
    }
}