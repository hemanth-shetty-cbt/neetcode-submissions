class Solution {
    public int[] getOrder(int[][] tasks) {

    int n = tasks.length;

    int[][] sorted = new int[n][3];

    for (int i=0;i<n;i++) {
        sorted[i]= new int [] {tasks[i][0], tasks[i][1], i};
    }

    Arrays.sort(sorted, (a,b) ->(a[0]-b[0]));

    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] -b[1]);


    int next = 0;
    int[] result = new int[n];
    int resIndex = 0;
    long time = 0;

    while(resIndex < n) {

        //CPU is idle we will jump to next's time

        if (pq.isEmpty() && time < sorted[next][0]) {
            time = sorted[next][0];
        }

        // Add every task that has arrived by the current time

        while(next <n && sorted[next][0] <= time) {
            pq.offer(new int[] {sorted[next][1], sorted[next][2]});
            next++;
        }

        int [] task = pq.poll();
        result[resIndex++] = task[1];
        time = time + task[0];
    }

    return result;

    }
}