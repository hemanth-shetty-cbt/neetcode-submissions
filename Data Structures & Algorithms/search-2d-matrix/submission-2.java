class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int mid = 0, left = 0, right = m * n - 1, num = 0;

        while (left <= right) {

            mid = left + (right - left) /2;

            num = matrix[mid/n][mid%n];

            if (num ==  target) {
                return true;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
        
    }
}
