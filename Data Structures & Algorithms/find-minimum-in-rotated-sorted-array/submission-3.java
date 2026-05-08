class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;
        int l = 0, r = n-1,mid, ans = nums[0];

        while (l <= r ) {

            if (nums[l] <= nums [r]) {
                
                ans = Math.min(ans, nums[l]);
                break;
            }

            mid = l + (r -l) /2;

            ans = Math.min(nums[mid], ans);

            if (nums[mid] >= nums[r]) {
                 
                l = mid + 1;
            } else {

                r = mid -1;

            }
        }

        return ans;
        
    }
}