class Solution {
    public boolean hasDuplicate(int[] nums) {

        Set<Integer> mp = new HashSet<Integer> ();

        for (int i: nums) {

            if (mp.contains(i)) {
                return true;
            }

            mp.add(i);
        }

        return false;

        
        
    }
}