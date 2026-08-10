class Solution {
    public int maxArea(int[] heights) {

        int n = heights.length;

        int max = 0;
        int left = 0 , right = n-1;

        while (left < right) {

            int w = right -left;

            int area = Math.min(heights[left], heights[right]) * w;
            max = Math.max(area, max);

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
            
        }

        return max;
        
    }
}
