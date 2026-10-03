class Solution {
    public int removeDuplicates(int[] nums) {

        int l = 0,r = l+1;
        int n = nums.length;

        if (n == 1) {
            return 1;
        }


        while(r < n) {

            if (nums[r] != nums[l] ) {

                nums[l+1] = nums[r];
                l++;
                r++;
            } else {

                r++;

                if(r>n) {
                    break;
                }

                // while (nums[r] != nums[l] && r < n) {
                //     r++;
                // }
                
                // l++;        
            }

        }

        return l+1;

    }
}