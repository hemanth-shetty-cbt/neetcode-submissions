class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        int left = 0, right = n-1, mid, ans = nums[0];

        if(n == 0) {
            return ans;
        }

        while(left <= right) {

            if(nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
            }

            mid = left + (right -left) /2;

            ans = Math.min(ans, nums[mid]);

            if(nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
        
    }
}
