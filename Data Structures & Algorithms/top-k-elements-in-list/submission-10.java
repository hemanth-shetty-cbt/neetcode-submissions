class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i=0; i<n; i++) {

            mp.put(nums[i], mp.getOrDefault(nums[i],0) + 1);

        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) ->mp.get(a) - mp.get(b));

        for (int i:mp.keySet()) {

            pq.offer(i);

            if (pq.size() > k) {
                pq.poll();
            }

        }

        int[] result = new int[k];

        for (int i=0; i<k; i++) {
            result[i] = pq.poll();
        }

        return result;
        
    }
}
