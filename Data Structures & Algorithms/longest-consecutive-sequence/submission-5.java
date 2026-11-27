class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0 ){
            return 0;
        }

        Set<Integer> st = new HashSet<>();

        for (int i: nums) {
            st.add(i);
        }

        int maxcount =1;

        for (int i : nums) {

            if (st.contains(i-1)) {
                continue;
            } else {

                int count = 1;
                int cnum = i;

                while (st.contains(cnum+1)) {
                    count++;
                    cnum++;
                }

                maxcount = Math.max(maxcount, count);

            }
        }



        return maxcount;


        
    }
}
