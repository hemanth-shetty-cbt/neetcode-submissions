class Solution {
    public int leastInterval(char[] tasks, int n) {

        int freq[] = new int[26];

        for(int arr:tasks) {

            freq[arr - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder());

        for (int arr:freq) {
            if (arr > 0) {
                pq.offer(arr);
            }
        }

        int cycles = 0;

        Queue<int[]> queue = new LinkedList<>();

        while (!pq.isEmpty() || !queue.isEmpty()) {
            cycles++;

            if(!pq.isEmpty()) {
                int count = pq.poll() -1 ;
                if (count > 0) {
                queue.offer(new int[]{count, cycles + n});
               }
            }

            //idle situation

            if(!queue.isEmpty() && queue.peek()[1] == cycles) {
                pq.offer(queue.poll()[0]);
            }
        }

        return cycles;

        
    }
}
