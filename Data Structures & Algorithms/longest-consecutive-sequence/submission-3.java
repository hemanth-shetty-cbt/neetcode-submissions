class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int maxcount = 1;
        
        Set<Integer> mp = new HashSet<>();

        for (int i: nums) {
            mp.add(i);
        }

        for (int i: nums) {

            if(mp.contains(i-1)) {
                continue;
            } else {

                int count = 1;
                int cnum = i;

                while (mp.contains(cnum+1)) {

                    cnum ++;
                    count++;
                }

                maxcount = Math.max(maxcount, count);
            }
        }

    return maxcount;
    }
}
