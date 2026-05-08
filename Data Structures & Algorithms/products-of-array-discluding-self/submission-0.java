class Solution {
    public int[] productExceptSelf(int[] nums) {

        int pre = 1, post =1;

        int [] result = new int[nums.length];

        for(int i=0; i<nums.length; i++) {

            result[i] = pre;
            pre = nums[i] * pre;
        }

        for(int i=nums.length-1; i>=0; i--) {

            result[i] = post* result[i];
            post = nums[i] * post;
        }

        return result;
        
    }
}  
