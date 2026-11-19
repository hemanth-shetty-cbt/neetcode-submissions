class Solution {
    public int leastInterval(char[] tasks, int n) {

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    Queue<int[]> qu = new LinkedList<>();

    int fre[] = new int[26];

    for (int i:tasks) {
        fre[i - 'A']++;
    }

    for (int i:fre) {

        if (i > 0) {
            pq.offer(i);
        }
    }

    int cycles = 0;

        while (!pq.isEmpty() || !qu.isEmpty()) {

                cycles++;

                if(!pq.isEmpty()) {

                    int count = pq.poll() -1 ;
                    if (count > 0) {
                        qu.offer(new int[]{count, cycles + n});
                    }
                }

            //idle situation

            if(!qu.isEmpty() && qu.peek()[1] == cycles) {
                pq.offer(qu.poll()[0]);
            }

                
        }
    
    return cycles;
        
    }
}
