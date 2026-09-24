class Solution {
    public int removeElement(int[] nums, int val) {

    int k = 0;

    //if it is not the value we are adding in the original array

    for (int i=0; i< nums.length; i++) {

        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }

    }

    return k;      
    }
}