class Solution {
    public int majorityElement(int[] nums) {

        int count =0 , element = 0, n = nums.length;

        for (int i=0; i<n; i++) {

            if (count ==0) {
                element = nums[i];
                count++;

            } else if (nums[i] != element) {
                count --;
            } else {
                count ++;
            }
        }


        return element;
        
    }
}