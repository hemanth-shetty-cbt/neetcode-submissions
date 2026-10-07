class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> mp = new HashSet<>();

        int n = nums.length;

        for (int i=0; i<n; i++) {

            if (i > k) {
                mp.remove(nums[i-k-1]);
            }

            if (!mp.add(nums[i])) {

                return true;

            }
        }

        return false;
        
    }
}