class Solution {
    public void rotate(int[] nums, int k) { 
        int n = nums.length;

        int[] result = new int[n];
        

        for (int i =0; i<n;i++) {

            int index = i+k;

            if (index >= n) {
                result[index % n] = nums[i];
            } else if (index < n) {
                result[index] = nums[i];
            }
        }

        System.arraycopy(result,0,nums,0,n);
        
    }
}