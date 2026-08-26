class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int x,y = 0;

        for (int num:stones) {
            pq.offer(num);

        }

        while(pq.size() > 1) {

            y = pq.poll();
            x = pq.poll();

            if (x != y) {

                pq.offer(y-x);
            }
            
        }

        return pq.size() == 0 ? 0 :pq.peek();

        
    }
}
