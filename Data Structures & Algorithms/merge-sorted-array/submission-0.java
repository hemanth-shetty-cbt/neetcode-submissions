class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] result = new int[m + n];

        int left = 0,right = 0,resIndex =0;

        while (left < m && right < n) {

            if (nums1[left] < nums2[right]) {
                result[resIndex++] = nums1[left];
                left++;
            } else if (nums2[right] < nums1[left]) {
                result[resIndex++] = nums2[right];
                right++;
            } else {
                result[resIndex++] = nums1[left];
                result[resIndex++] = nums2[right];
                left++;
                right++;
            }
        }

        while(left < m ) {
            result[resIndex++] = nums1[left];
            left++;
        }

        while (right < n) {
            result[resIndex++] = nums2[right];
            right++;
        }

        System.arraycopy(result,0,nums1,0,m+n);
        
    }
}