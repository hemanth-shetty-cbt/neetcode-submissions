class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        //conver the 2D matrix into 1D matrix

        int m = matrix.length, n = matrix[0].length, mid, val;

        int left = 0, right = m*n-1;

        while( left <= right) {

            mid = left + (right - left) /2;

            val = matrix[mid/n][mid%n];

            if(val == target) {
                return true;
            } else if(val < target) {
                left = mid + 1;

            } else {
                right = mid -1;
            }
        }

        return false;
        
    }
}
