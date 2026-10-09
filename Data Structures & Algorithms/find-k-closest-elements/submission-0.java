class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]
        );

        int n = arr.length;

        for ( int i=0; i<n; i++) {
            pq.offer(new int[] {arr[i], Math.abs(arr[i] - x)});
        }

        List<Integer> result = new ArrayList<>();


        for (int i = 0; i<k; i++) {
            result.add(pq.poll()[0]);
        }

        Collections.sort(result);

        return result;
        
    }
}