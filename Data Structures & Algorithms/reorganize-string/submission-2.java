class Solution {
    public String reorganizeString(String s) {

        int[] fre = new int[26];
        
        for (char ch:s.toCharArray()) {

            fre[ch - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (b[1] - a[1]));

        for (int i=0; i<26; i++) {

            if (fre[i] > 0) {
                pq.offer(new int[]{i, fre[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        int [] outCharacter = null;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

        
            sb.append((char)('a' + curr[0]));
            curr[1]--;

            if (outCharacter != null && outCharacter[1] >0) {
                pq.offer(outCharacter);
            }

            outCharacter = curr;
        }

        return s.length() == sb.length() ? sb.toString() : "";
    }
}