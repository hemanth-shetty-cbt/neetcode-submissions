class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num: nums) {
           //this one for the frequency
            mp.put(num, mp.getOrDefault(num,0) +1);
        }
        
        //defining a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(

          (a,b) -> mp.get(a) -mp.get(b)
        );

        for(int i:mp.keySet()) {
            
            pq.offer(i);

            if(pq.size() > k) {

                pq.poll();
            }
        }


        int result[] = new int[k];

        for(int i=0; i<k; i++) {

            result[i] = pq.poll();
        }

        return result;
        
    }
}
