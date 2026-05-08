class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
         
        int l = 0, h =n-1, mid;

        while (l < h) {

            mid = (l + h) / 2;

            if(nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        int pivot = l;

        int result = binarySearch(nums, target, 0, pivot -1);

        if (result != -1) {

          return result;
        }

        return binarySearch(nums, target, pivot, n-1);
        
        
    }

    public int binarySearch(int []nums,int target, int l , int h) {

     

        while( l <= h) {

            int mid = (l + h) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return -1;
    }

}
