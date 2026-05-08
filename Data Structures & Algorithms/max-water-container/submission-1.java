class Solution {
    public int maxArea(int[] heights) {

        int max = 0, left = 0, right = heights.length -1;

        while(left < right) {

            int w = right - left;

            int area = Math.min(heights[left], heights[right]) * w;
            max = Math.max(max, area);

            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
        
    }
}
