class Solution {
    public String reorganizeString(String s) {

        int[] fre = new int[26];
        //count the frequency
        for (char ch: s.toCharArray()) {
            fre[ch - 'a']++;
        }

        //we maintain {character and count}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
        b[1] - a[1]
        );


        StringBuilder sb = new StringBuilder();
        for (int i=0;i<26;i++) {

            if(fre[i] > 0) {
                pq.offer(new int[]{i, fre[i]});
             }
        }

        int[] currOut = null;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            sb.append((char)('a' + curr[0]));
            curr[1]--;

            //release the prev to heap

            if(currOut != null && currOut[1] >0) {
                pq.offer(currOut);
            }

            currOut = curr;

        }


        return sb.length() == s.length() ?sb.toString() : "";

        
    }
}