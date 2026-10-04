class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

    int n = nums.length;
    Arrays.sort(nums);
    int left =0, right =0;
    List<List<Integer>> result = new ArrayList<>();

    for (int i=0; i<n-1; i++) {

        if (i>0 && nums[i]==nums[i-1])
            continue;

        left = i+1; right = n-1;

        while (left <right) {

        int sum = nums[left] + nums[right] + nums[i];

        if (sum == 0) {
             result.add(Arrays.asList(nums[i], nums[left],nums[right]));
             left++;
             right--;

             while (left < right && nums[left] == nums[left-1]) {
                     left++;
             }
             while (left< right && nums[right] == nums[right+1]) {
                right--;
             }
        } else if (sum > 0) {
            right--;
        } else {
            left++;
        }
    }

    }

    return result;  
    }

}
