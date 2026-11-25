class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i=0; i<nums.length; i++) {

            int compli = target - nums[i];

            if (mp.containsKey(compli)) {
                return new int[] {mp.get(compli), i};
            }
            mp.put(nums[i], i);
        }

        return new int[] {};
        
    }
}
