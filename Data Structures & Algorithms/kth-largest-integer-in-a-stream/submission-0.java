class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        pq = new PriorityQueue<>(); //by default it will be a min heap 


        for (int num: nums) {
            add(num);
        }

        
    }
    
    public int add(int val) {

        pq.offer(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
        
    }
}
