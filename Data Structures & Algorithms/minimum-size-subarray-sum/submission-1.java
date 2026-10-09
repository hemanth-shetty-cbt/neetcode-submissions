class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int left = 0;
        int sum = 0, window =0,minlen = Integer.MAX_VALUE;


        for (int right = 0; right<n; right++) {

            sum = sum + nums[right];


            while (sum >= target) {

            window = right -left +1;
            minlen = Math.min(minlen, window);
            sum = sum - nums[left];
            left++;
            }

        }


       return minlen == Integer.MAX_VALUE ? 0:minlen;
      
        
    }
}