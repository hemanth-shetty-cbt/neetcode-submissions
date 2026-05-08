class Solution {
    public int longestConsecutive(int[] nums) {
 

      if(nums.length == 0) {
        return 0;
      }

      int lss =1;

      HashSet<Integer> mp = new HashSet<>();

      for(int i=0;i<nums.length;i++) {

        mp.add(nums[i]);
      }

      for(int num:nums) {

        if(mp.contains(num-1)) {
            continue;
        }
        else{

            int css = 1;
            int cnum = num;

            while(mp.contains(cnum+1)) {
                css++;
                cnum++;
            }

        

        lss = Math.max(lss, css);
        }
    
    }

    return lss;
    }

}
