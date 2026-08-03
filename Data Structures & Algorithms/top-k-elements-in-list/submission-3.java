class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer>  mp = new HashMap<>();

        for (int i: nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1); 
        }

        //this earlier loop will key occurence of each number 
        //with the iteration

        PriorityQueue<int[]> mheap  = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> sp :  mp.entrySet()) {
            mheap.offer(new int[] { sp.getKey(), sp.getValue()});

            if(mheap.size() > k) {
                mheap.poll();
            }

        }

        int[] result = new int[k];

        for (int i=0; i<k; i++) {
            result[i] = mheap.poll()[0];
        }

        return result;
        
    }
}
